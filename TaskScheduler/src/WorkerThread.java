import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  

class WorkerThread implements Runnable {  
    private String message;  
    private int duration;
    public WorkerThread(String s, int d){  
        this.message=s;  
        this.duration=d;
    }  
    
    public void run() {  
        System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);  
        processmessage();  
        System.out.println(Thread.currentThread().getName()+" (End)");  
    }
    
    private void processmessage() {  
        try {  
            Thread.sleep(duration*1000);  
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }  
    }  
}