package prime;

public class Number implements Runnable{

	static int total = 3000000;
	static int nonPrimes =0 ;	
	static int primes = 0;	
	private int i=1;
	
	
	//////constructor
	public Number(int x) {
	i=x;
	}
	
	
	
	@Override
	public synchronized void run() { 
		try {
			int num = getI();	
			synchronized(Number.class) {// THHIS SOLVED THE CONCURRENCY ISSUES!!!!!!!!!!!!!!!!!!
				for(int j=2;j<10;j++) {
					if(num!=j) {
						if(num%j==0) {
							nonPrimes++;
							break;
						}
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