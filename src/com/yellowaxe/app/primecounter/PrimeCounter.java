package com.yellowaxe.app.primecounter;


public class PrimeCounter {

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
		PrimeGenerator pg = new PrimeGenerator();
		int max = 1000*1000*1000;
		
		// 619 loop
		int start619 = 8501;
		while (true) {
			if (!pg.isPrime(start619)) {
				start619++;
				continue;
			}
			int sum619 = 0, count619 = 0;
			for (int i = start619; i < max; i++) {
				if (pg.isPrime(i)) {
					sum619 += i;
					count619++;
				} else {
					continue;
				}
				
				if (count619 == 619) {
					break;
				}
			}
			if (pg.isPrime(sum619)) {
				System.out.println("start: " + start619 + " this sum619 " + sum619 + " is a prime");
				
				// 245 loop ===================================== //
				int start245 = start619;
				while (true) {
					if (!pg.isPrime(start245)) {
						start245++;
						continue;
					}
					int sum245 = 0, count245 = 0;
					for (int i = start245; i < max; i++) {
						if (pg.isPrime(i)) {
							sum245 += i;
							count245++;
						} else {
							continue;
						}
						
						if (count245 == 245) {
							break;
						}
					}
					if (sum245 == sum619) {
						System.out.println("  start: " + start245 + " this sum245 " + sum245 + " is same as the sum619!");
						
						// 143 loop ===================================== //
						int start143 = start245;
						while (true) {
							if (!pg.isPrime(start143)) {
								start143++;
								continue;
							}
							int sum143 = 0, count143 = 0;
							for (int i = start143; i < max; i++) {
								if (pg.isPrime(i)) {
									sum143 += i;
									count143++;
								} else {
									continue;
								}
								
								if (count143 == 143) {
									break;
								}
							}
							if (sum143 == sum245) {
								System.out.println("    start: " + start143 + " this sum143 " + sum143 + " is same as the sum245!");
								System.exit(0);
							} else if (sum143 > sum245) {
								System.out.println("    failed: " + sum143 + " start: " + start143);
								break;
							}
							start143++;
						}
						// 143 loop ===================================== //

					} else if (sum245 > sum619) {
						System.out.println("  failed: " + sum245 + " start: " + start245);
						break;
					}
					start245++;
				}
				// 245 loop ===================================== //

			}
			start619++;
		}
	}
}
