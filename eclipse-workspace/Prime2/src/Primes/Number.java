package Primes;

public class Number implements Runnable{

	static int total = 30;
	static int nonPrimes =0 ;	
	static int primes = 0;	
	private int i=1;
	
	
	//////constructor
	public Number(int x) {//is it possible I changes here
	i=x;
	}
	
	
	
	@Override
	public synchronized void run() { 
		try {
			int num = getI();	//setting i to num
			for(int j=2;j<10;j++) {
				if(num!=j) {
					if(num%j==0) {
						nonPrimes++;
						//System.out.println("Added Non Prime"+ getI()); // shows it works well for smaller total
						break;
					}
				}
				
			}
			setI(1);
			
		}catch(Exception e) {}
	}

	private synchronized int getI() { //synch here to provide lock
		return i;
	}

	private synchronized void setI(int x) {
		i =i+ x;
	}
}
