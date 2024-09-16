package webcam.app;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Registry {
	static Registry instance=new Registry();
	public static Registry getInstance() {return instance;}
	
	protected Registry() {
		
	}
	
	private BlockingQueue<byte[]> bqueue=new ArrayBlockingQueue<byte[]>(1000);
	public BlockingQueue<byte[]> getBqueue() {
		return bqueue;
	}

	public void setBqueue(BlockingQueue<byte[]> bqueue) {
		this.bqueue = bqueue;
	}
	
	
}
