package buffer;

import java.nio.ByteBuffer;

public class ByteBufferTest {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 10);
		buffer.put("ProposalId,OpportunityId,ClickCount,ImpressionCount\n".getBytes());
		buffer.put("101,006j000000I3cl2AAB,12,72\n".getBytes());
		buffer.put("103,006j000000I3cksAAB,29,131\n".getBytes());
		
		System.out.println(buffer.hasRemaining());
		System.out.println(buffer.position());
		System.out.println(buffer.remaining());
//		buffer.reset();
//		System.out.println(buffer.position());
//		System.out.println(buffer.remaining());
		int position = buffer.position();
		if (position != 0 || position != -1) {
			buffer.rewind();
			byte[] bytes = new byte[position];
			buffer.get(bytes);
			System.out.println(new String(bytes));
		}
		
		buffer.clear();
		
		buffer.put("102,006j000000I3ckxAAB,18,95\n".getBytes());
		position = buffer.position();
		if (position != 0 || position != -1) {
			buffer.rewind();
			byte[] bytes = new byte[position];
			buffer.get(bytes);
			System.out.println(new String(bytes));
		}
//		if (buffer.hasRemaining()) {
//			System.out.println(buffer.remaining());
//			byte[] bytes = new byte[buffer.remaining()];
//			buffer.get(bytes);
//			
//			System.out.println(bytes.length);
//			System.out.println(new String(bytes));
//		}
	}
}
