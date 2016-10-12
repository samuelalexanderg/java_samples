package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

public class FileUtilsTest {
	public static void main(String[] args) throws Exception {
		pathsTest();
	}

	private static void readFileToString() throws IOException {
		String fileLocation = "file:///home/sam/work/projects/etl/prototype/gdf/wave_connector_prototype/sf_source_config.json";
		System.out.println(new File(fileLocation).isFile());
        FileUtils.readFileToString(new File(fileLocation), Charsets.UTF_8);
	}

	private static void pathsTest() {
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println(s);

		System.out.println(System.getProperty("user.dir"));
		System.out.println(FileUtilsTest.class.getClassLoader().getResource("").getPath());
	}
}
