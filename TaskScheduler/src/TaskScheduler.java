import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Stack;
import java.util.PriorityQueue;
import java.lang.Math;

public class TaskScheduler {
    
    public static void main(String[] args) throws InterruptedException {        
        System.out.println("Task Scheduler!");
        /*
        // Thread pool
        ExecutorService executor = Executors.newFixedThreadPool(5);  
        for (int i = 0; i < 10; i++) {  
            Runnable worker = new WorkerThread("" + i, 2);  
            executor.execute(worker);  
          }  
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
  
        System.out.println("Finished all threads"); 
        */
        
        // Thread pool with delay
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(5);

        for (int i=10; i>0; i--) {
            Thread.sleep(1000);
            Runnable worker = new WorkerThread("scheduled worker " + i, 2);
            ScheduledFuture scheduledFuture =
                scheduledExecutorService.schedule(
                worker,
                i%2==0?10:1,
                TimeUnit.SECONDS);
     
        }               

        scheduledExecutorService.shutdown();
        while (!scheduledExecutorService.isTerminated()) {   }  
        
        System.out.println("Finished scheduled threads");
    }    
}
