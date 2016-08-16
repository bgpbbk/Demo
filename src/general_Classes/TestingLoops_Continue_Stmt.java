package general_Classes;

public class TestingLoops_Continue_Stmt {	
	
	public static void main(String[] args) {
		
		int nValues = 50; // The maximum value to be checked
		// Check all values from 2 to nValues
		
		Throwable th=new Throwable();

		OuterLoop: for (int i = 2; i <= nValues; ++i) {
			// Try dividing by all integers from 2 to i-1

			for (int j = 2; j < i; ++j) {
				
				if (i % j == 0) { // This is true if j divides exactly
					continue OuterLoop; // so exit the loop
				}else{
					//assert false;
					Throwable getCause=th.getCause();
					throw new AssertionError("This Error is due to "+ getCause);
				}
					}
			// We only get here if we have a prime
			System.out.println(i); // so output the value
		}
	}
}	
		
		/* public class TestingLoops_Continue_Stmt{			//B'coz of naming conflict i have given the same above class name to this class.
			 												//Actual class name is Breaking_Indefinite_Loops and this class achieves the same Functionality.
			public static void main(String[] args){
				
				int nPrimes = 50; // The maximum value to be checked
				// Check all values from 2 to nValues
		
		OuterLoop:
			for(int i = 2 ; ; ++i) { // This loop runs forever
			// Try dividing by all integers from 2 to i-1
			for(int j = 2; j < i; ++j) {
			if(i % j == 0) { // This is true if j divides exactly
			continue OuterLoop; // so exit the loop
			}
			}
			// We only get here if we have a prime
			System.out.println(i); // so output the value
			if(--nPrimes == 0) { // Decrement the prime count
			break; // It is zero so we have them all
			}
			}
	}

}
*/