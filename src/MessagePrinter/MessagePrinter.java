package MessagePrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessagePrinter implements Runnable{
	
	private String message;
	
	MessagePrinter(String message){
		this.message = message;
	}
	
	@Override
	public void run() {
		System.out.println("Task-X executed by '" + message + "'");
	}
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i = 1; i <= 5; i++) {
			Runnable task = new MessagePrinter("Task " + i);
			executor.submit(task);
		}
		System.out.println("executor.isTerminated() " + executor.isTerminated());
		System.out.println("executor.isShutdown() " + executor.isShutdown());
		//executor.shutdownNow();
		System.out.println("executor.isShutdown() " + executor.isShutdown());
	}

}
