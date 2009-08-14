package com.yellowaxe.app.primecounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrimeCounterNaive {

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
		List<Integer> primesList = new ArrayList<Integer>(1000000);
		File primes = new File("1000000.txt");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(primes)));
		
		while (br.ready()) {
			String inp = br.readLine();
			String [] res = inp.trim().split("\\D+");
			for (String prime : res) {
				primesList.add(Integer.parseInt(prime));
			}
		}
		
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
