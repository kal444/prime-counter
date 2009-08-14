package com.yellowaxe.app.primecounter;

import java.util.List;

public class PrimeCounterNaiveAgain {

	/**
	 * Find the smallest number that can be expressed as
	 * the sum of 7 consecutive prime numbers,
	 * the sum of 39 consecutive prime numbers,
	 * the sum of 143 consecutive prime numbers,
	 * the sum of 245 consecutive prime numbers,
	 * the sum of 619 consecutive prime numbers,
	 * and is itself a prime number.
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		PrimeGenerator pg = new PrimeGenerator(1000000);
		List<Long> primesList = pg.generate();
		System.out.println("" + primesList.size() + " primes");

		int start619 = 0;
		while (true) {
			// 619 loop
			int sum619 = 0;
			for (int i = start619; i < start619+619; i++) {
				sum619 += primesList.get(i);
			}
			if (primesList.contains(sum619)) {
				System.out.println("this sum619 " + sum619 + " is a prime");
				
				// 245 loop
				int start245 = 0;
				while (true) {
					int sum245 = 0;
					for (int i = start245; i < start245+245; i++) {
						sum245 += primesList.get(i); 
					}
					if (sum245 == sum619) {
						System.out.println("this sum245 " + sum245 + " is same as the sum619!");
					}
					start245++;
				}
			}
			start619++;
		}
	}
	
}
