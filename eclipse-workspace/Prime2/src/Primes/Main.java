package Primes;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	
	public static void main(String[]args){
	
		//time start
		long tStart = System.currentTimeMillis();


    ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads  
    
    	for (int i =1;i<Number.total;i++)  {  
    		synchronized(Number.class) {//attempt at synching class creation to stop two of same i being passed in
    	Runnable  worker = new Number(i);  //creating new object passing in i
        executor.execute(worker); 
      } 
    }
    executor.shutdown();  
    while (!executor.isTerminated()) {   }  

    System.out.println("Finished all threads");  
    
    //time calculations
    long tEnd = System.currentTimeMillis();
  	long tDelta = tEnd - tStart;
  	double elapsedSeconds = tDelta / 1000.0;

	//printouts
	Number.primes = (Number.total-2)-Number.nonPrimes;
	System.out.println("number of prime numbers between 0 and "+Number.total +" is "+Number.primes);
	  System.out.println("Time: "+ elapsedSeconds);	

	}
}

	
