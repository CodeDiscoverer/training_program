package SampleThreads;

import java.time.Instant;

public class Main extends Thread implements Runnable{
	
	static Main thread1 = new Main();
	static Main thread2 = new Main();
	static Main thread3 = new Main();
	static Main thread4 = new Main();
		
	@SuppressWarnings("deprecation")
	public void run() {
		
		for(int i = 1; i < 5;i++) {    
            try {  
            	if(i == 1) {
            		System.out.println(getName());
            	}
            	if(i == 2) {
            		System.err.println(Instant.now().toEpochMilli());
            		Thread.sleep(6000);
            		System.out.println(getName());
            	}
            	if(i == 3) {
            		System.out.println(Instant.now().toEpochMilli());
            		//thread4.sleep(5000);
            		System.out.println(getName());
            	}
            	if(i == 4) {
            		System.out.println(thread4.isAlive());
            		System.out.println(getName());
            	}
            	
            }catch(InterruptedException e){System.out.println(e);}      
        }    
    }    

	public static void main(String[] args) throws InterruptedException {
		
		
		thread1.setName("Hello Suriya");
		thread2.setName("Welcome Suriya");
		thread3.setName("Good Morning Suriya");
		thread4.setName("How Are you!");
		
		thread1.start();
		thread2.start(); 
		thread4.start();
        thread3.run();      

	}

}
