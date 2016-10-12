package sftp;

import java.util.Date;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.ChannelSftp.LsEntry;

public class JSCHSample {
	public static void main(String[] args) {
		testCopyLatest();
	}

	private static void testCopyLatest() {

		JSch jsch = new JSch();
		Session session = null;
        try {
        	session = jsch.getSession("10880629",
            		"ftp1.exacttarget.com", 22);
        	session.setPassword("h2Y2kkH3");
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            String latestSource = getLatestSource("/Import/Wave/SF_Wave_Products_*", sftpChannel);
            System.out.println(latestSource);
            session.disconnect();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	private static String getLatestSource(String source, ChannelSftp sftpChannel) {
		try {
            Vector ls = sftpChannel.ls(source);

            String basePath = FilenameUtils.getPath(source);
            System.out.println("Base Path : " + basePath);
            int latestModTime = 0;
            String fileName = "";
            for (int i = 0, size = ls.size(); i < size; i++) {
            	LsEntry entry = (LsEntry) ls.get(i);
            	int modTime = entry.getAttrs().getMTime();
            	if (latestModTime < modTime) {
            		latestModTime = modTime;
            		fileName = entry.getFilename();
            	}
			}

            return FilenameUtils.concat(basePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

		return null;
	}

//	private static String getBasePath(String source) {
//		int folderIndex = source.lastIndexOf('/');
//		if (folderIndex != -1) {
//			source.substring(0, folderIndex);
//		}
//
//		FilenameUtils.getBaseName(filename)
//	}

	private static void testCopy() {

		JSch jsch = new JSch();
		Session session = null;
        try {
        	jsch.addIdentity("/home/sam/Downloads/sml-predictiveapps.pem");

        	session = jsch.getSession("ec2-user",
            		"ec2-52-27-55-223.us-west-2.compute.amazonaws.com", 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            copy(sftpChannel, "/home/ec2-user/work/files/", "/home/sam/tmp/s/");
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }
	}

	private static void copy(ChannelSftp sftpChannel,
			String source, String target) throws SftpException {
		System.out.println("Copying files from " + source + " to " + target);
		sftpChannel.cd(source);
		sftpChannel.lcd(target);
		Vector<ChannelSftp.LsEntry> childFiles = sftpChannel.ls(".");
		for (LsEntry lsEntry : childFiles) {
			String entryName = lsEntry.getFilename();
			System.out.println(entryName);
			if (!entryName.equals(".") && !entryName.equals("..")) {
				if (lsEntry.getAttrs().isDir()) {
					copy(sftpChannel, source + entryName + "/", target);
				} else {
					System.out.println("Copying file " + entryName);
					sftpChannel.get(entryName, entryName);
				}
			}
		}

	}
}
