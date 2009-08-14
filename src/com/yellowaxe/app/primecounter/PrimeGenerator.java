package com.yellowaxe.app.primecounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeGenerator {
	
	private long max;
	
	public PrimeGenerator() {
		max = 10000;
	}
	
	public PrimeGenerator(long max) {
		this.max = max;
	}
	
	public List<Long> generate() {
		List<Long> full = new ArrayList<Long>();
		List<Long> primes = new ArrayList<Long>();
		
		// set up full array
		for (long i = 2; i <= max; i++) {
			full.add(i);
		}
		
		for (Long testNumber : full) {
			if (isPrime(testNumber)) {
				primes.add(testNumber);
			}
		}
		
		return primes;
	}

	public boolean isPrime(long testNumber) {
		
		long sqrtLimit = Math.round(Math.sqrt(testNumber));
		
		long [] primeDivisor = { 2, 3, 5 };
		long [] trialModDivisor = { 1, 7, 11, 13, 17, 19, 23, 29 };
		
		for (long div : primeDivisor) {
			if (testNumber == div) return true;
			if (testNumber % div == 0) return false;
		}
		
		for (long div = 7; div <= sqrtLimit; div++) {
			long mod = div % 30;
			if (Arrays.binarySearch(trialModDivisor, mod) >= 0) {
				if (testNumber % div == 0) return false;
			}
		}
		
		return true;
	}
}
