package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// already was done, so not my code
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// make a string array by splitting phrase at ' ' and '-'
		String[] result = phrase.split("[ -]");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			// grab only the first letters of the strings.
			sb.append(result[i].charAt(0));
		}
		// set the String
		String finalResult = sb.toString();
		// return the string in upper case.
		return finalResult.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		/*
		 * If all sides are equal, it is an Equilateral. if A == B, and B == C, Then C
		 * == A
		 */
		public boolean isEquilateral() {
			if (this.sideOne == this.sideTwo && this.sideTwo == this.sideThree) {
				return true;
			} else {
				return false;
			}
		}

		/*
		 * If any 2 sides are equal, it is an Isosceles
		 */
		public boolean isIsosceles() {
			if (this.sideOne == this.sideTwo || this.sideTwo == this.sideThree || this.sideOne == this.sideThree) {
				return true;
			}
			return false;
		}

		/*
		 * If any side is not equal to another, we can assume that it is most likely
		 * Scalene. Assuming, all inputs are actually for a triangle.
		 */
		public boolean isScalene() {
			if (this.sideOne == this.sideTwo || this.sideTwo == this.sideThree || this.sideOne == this.sideThree) {
				return false;
			}
			return true;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		char[] cArray = string.toLowerCase().toCharArray();
		for (int i = 0; i < cArray.length; i++) {
			score += scoreChecker(cArray[i]);
		}
		return score;
	}

	/*
	 * Check for the score of the letter
	 */
	private int scoreChecker(char c) {
		char[] cArray = new char[] { 'a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't' };
		for (int i = 0; i < cArray.length; i++) {
			if (c == cArray[i])
				return 1;
		}
		cArray = new char[] { 'd', 'g' };
		for (int i = 0; i < cArray.length; i++) {
			if (c == cArray[i])
				return 2;
		}
		cArray = new char[] { 'b', 'c', 'm', 'p' };
		for (int i = 0; i < cArray.length; i++) {
			if (c == cArray[i])
				return 3;
		}
		cArray = new char[] { 'f', 'h', 'v', 'w', 'y' };
		for (int i = 0; i < cArray.length; i++) {
			if (c == cArray[i])
				return 4;
		}
		cArray = new char[] { 'k' };
		for (int i = 0; i < cArray.length; i++) {
			if (c == cArray[i])
				return 5;
		}
		cArray = new char[] { 'j', 'x' };
		for (int i = 0; i < cArray.length; i++) {
			if (c == cArray[i])
				return 8;
		}
		cArray = new char[] { 'q', 'z' };
		for (int i = 0; i < cArray.length; i++) {
			if (c == cArray[i])
				return 10;
		}
		return 0;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException {
		char[] cArray = string.toCharArray();
		List<Character> numbers = new ArrayList<Character>();
		for (int i = 0; i < cArray.length; i++) {
			if (isNumber(cArray[i])) {
				numbers.add(cArray[i]);
			}
		}

		// if the number is less than 10, we can assume that it is not a number and we
		// can throw an exception.
		if (numbers.size() > 10 || numbers.size() < 10) {
			// if, the size is greater then 10, check of that 11th number == 1. if not throw
			// exception.
			if (numbers.size() > 10) {
				if (numbers.get(0) != '1') {
					throw new IllegalArgumentException();
				}
			} else {
				throw new IllegalArgumentException();
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.size(); i++) {
			// since the number: (NXX)-NXX-XXXX points out that N needs to be between 2-9, I
			// check
			// to make sure that it is equal to 2-9.
			if (i == 0 || i == 3) {
				if (isNumberN(numbers.get(i))) {
					sb.append(numbers.get(i));
				} else {
					throw new IllegalArgumentException();
				}
			} else {
				sb.append(numbers.get(i));
			}
		}
		// return the full string.
		return sb.toString();
	}

	// check of the N in the phone number is correct. 1 (NXX)-NXX-XXXX
	public boolean isNumberN(char c) {
		char[] numbers = new char[] { '2', '3', '4', '5', '6', '7', '8', '9' };
		for (int i = 0; i < numbers.length; i++) {
			if (c == numbers[i]) {
				return true;
			}
		}
		return false;
	}

	// check if there is a number 1 (NXX)-NXX-XXXX
	public boolean isNumber(char c) {
		char[] numbers = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (int i = 0; i < numbers.length; i++) {
			if (c == numbers[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> mapCount = new HashMap<String, Integer>();
		String str = string.replace(",", " ");
		String[] strArray = str.replaceAll("\n", "").trim().split(" ");
		int count = 1;
		for (String s : strArray) {
			count = 1;
			// if the map already has the word in it, add an extra 1 to count.
			if (mapCount.containsKey(s)) {
				count = mapCount.get(s) + 1;
			}
			// since maps do not allow duplicate keys, it is fine for me to just re-put the
			// value
			mapCount.put(s, count);
		}
		return mapCount;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
			int low = 0;
			int high = sortedList.size() - 1;
			// if high is smaller or equal to low, return 0.
			if (low >= high) {
				return 0;
			}
			int middle = 0;
			// this boolean is just incase the number wasn't found. And because Hao made a
			// big deal about it.
			boolean found = false;
			// while low is lower then
			while (low <= high) {
				// update middle every run.
				middle = (low + high) / 2;
				if (t.compareTo(sortedList.get(middle)) < 0) {
					// if the value is supposed to be lower then middle, set high = middle -1 (minus
					// one because without it, we have math problems).
					high = middle - 1;
				} else if (t.compareTo(sortedList.get(middle)) > 0) {
					// same goes for if the value is greater then middle.
					low = middle + 1;
				} else if (t.equals(sortedList.get(middle))) {
					// if found, break out of the loop
					found = true;
					break;
				}
			}
			// return middle, OR an error if value wasn't found.
			if (found) {
				return middle;
			} else {
				return -1;
			}
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String[] strArray = string.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strArray.length; i++) {
			// add a space after each word.
			if (i > 0) {
				sb.append(" ");
			}
			// compare if the first letter of the word is a vowel or a consonant
			if (checkVowel(strArray[i], ' ')) {
				sb.append(strArray[i].concat("ay"));
			} else if (checkConsonant(strArray[i])) {
				// if there is a Consonant, then keep moving values until a vowel is reached.
				sb.append(checkMoveConsonant(strArray[i]));
			}
		}
		return sb.toString();
	}

	private boolean checkConsonant(String str) {
		// B, C, D, F, G, H, J, K, L, M, N, P, Q, R, S, T, V, X, Y, Z
		char[] vowels = new char[] { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 
									 'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'y', 'z' };
		char[] cArray = str.toCharArray();
		// if first letter is a consonant, return true.
		for (int i = 0; i < vowels.length; i++) {
			if (cArray[0] == vowels[i]) {
				return true;
			}
		}

		return false;
	}

	private String checkMoveConsonant(String str) {
		char[] cArray = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 1;
		boolean hitVowel = false;
		for (int i = 1; i < cArray.length; i++) {
			// Once a vowel is reached, the loop will stop counting up 
			if (!hitVowel) {
				// check if a vowel has been hit
				if (checkVowel("" + cArray[i], cArray[i - 1])) {
					sb.append(cArray[i]);
					hitVowel = true;
				} else {
					// if not, just count up.
					count++;
				}
			} else {
				// once a vowel has been hit, start adding the vowel and everything after that
				// to the StringBuilder
				sb.append(cArray[i]);
			}
		}
		// after the for loop, finish adding the first X numbers back in.
		for (int i = 0; i < count; i++) {
			sb.append(cArray[i]);
		}
		// then add ay to the end of the string
		sb.append("ay");
		return sb.toString();
	}

	// check if the strings first character is a value
	private boolean checkVowel(String str, char exceptionVowels) {
		char[] vowels;
		// there may be more exceptions to vowels, but I only found q to u.
		// The wiki only mentioned consonant clusters (multiple consonants that form one
		// sound), q+u is one of those
		if (exceptionVowels == 'q') {
			vowels = new char[] { 'a', 'e', 'i', 'o' };
		} else {
			vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };
		}
		char[] cArray = str.toCharArray();
		// check values of the vowel vs the first letter.
		for (int i = 0; i < vowels.length; i++) {
			if (cArray[0] == vowels[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// get a char array to work with instead of an int
		char[] numbers = convertNumberToCharArray(input);
		return checkIfArmstrongNumber(numbers, input);
	}

	// to convert the ints to a char array
	private char[] convertNumberToCharArray(int input) {
		String number = "" + input;
		return number.toCharArray();
	}

	// check if the number is an armstrong number
	private boolean checkIfArmstrongNumber(char[] numbers, int input) {
		int totalValue = 0;
		for (int i = 0; i < numbers.length; i++) {
			int number = Character.getNumericValue(numbers[i]);
			// get the totalValue + the number that came after calculating it's value
			totalValue = totalValue + calculateNumber(number, numbers.length);
		}
		// check if totalValue and input equal an ArmStrong number
		if (totalValue == input) {
			return true;
		}
		return false;
	}

	// calculate the number raised to the power of it's digits
	private int calculateNumber(int number, int toThePowerOf) {
		int value = number;
		for (int i = 1; i < toThePowerOf; i++) {
			value = value * number;
		}
		return value;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		return countUpToMaxNumber(l);
	}

	private List<Long> countUpToMaxNumber(Long l) {
		List<Long> primeNumbers = new ArrayList<Long>();
		int i = 2;
		// keep dividing until l is set to one.
		while (l != 1) {
			// if l is divisible by i
			if (l % i == 0) {
				// check if it is a prime number
				if (checkIfPrimeNumber(i)) {
					// divide l by i
					l = l / i;
					primeNumbers.add((long) i);
				} else {
					i++;
				}
			} else {
				i++;
			}
		}
		return primeNumbers;
	}

	private boolean checkIfPrimeNumber(long i) {
		// if the number is less then 3, it is by default a prime number (2 and 3)
		if (i < 3) {
			return true;
		}
		int totalDividableNumber = 0;
		// loop through the numbers to check if the number given is actually a prime number
		for (int j = 2; j <= i; j++) {
			if (i % j == 0) {
				totalDividableNumber++;
			}
			if (totalDividableNumber > 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		// ascii values: A = 065, Z = 090
		// a = 097, z = 122
		public String rotate(String string) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < string.length(); i++) {
				int number = string.charAt(i);
				char c = calculateIfUpperOrLowerCase(number, key);
				sb.append(c);
			}
			return sb.toString();
		}

		private char calculateIfUpperOrLowerCase(int number, int key) {
			char c;
			// if statements are setup to display that number should be 
			// - between low <= number =< high
			if (65 <= number && number <= 90) {
				c = (char) moveLetter(65, 90, number, key);
			} else if (97 <= number && number <= 122) {
				c = (char) moveLetter(97, 122, number, key);
			} else {
				c = (char) number;
			}
			return c;
		}

		private int moveLetter(int low, int high, int number, int key) {
			// move the letter to the value of the key.
			for (int i = 0; i < key; i++) {
				// if the number has gotten higher then high, set to low. 
				if (number == high) {
					number = low;
				} else {
					number++;
				}
			}
			return number;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		int finalNumber = 0;
		int totalNumberOfPrimeNumbers = 0;
		// check if i == 0
		if (i == totalNumberOfPrimeNumbers) {
			throw new IllegalArgumentException();
		} else {
			// count up to i and calculate the prime numbers between.
			for (int number = 2; totalNumberOfPrimeNumbers < i; number++) {
				// check if a the number is a prime number.
				if (checkIfPrime(number)) {
					totalNumberOfPrimeNumbers++;
				}
				if (totalNumberOfPrimeNumbers == i) {
					finalNumber = number;
				}
			}
		}
		return finalNumber;
	}
	
	// there is probably a faster way to compute this, but I can't figure it out currently. 
	private boolean checkIfPrime(int number) {
		if (number < 3) {
			return true;
		}
		// we can assume that a number can be divided by it's self. So we will start it
		// at one
		int totalDividableNumber = 1;
		// by cutting the number in half, we decrease the number of iterations. since
		// there is no point to re-checking the higher values
		// this calculation has decreased my time from 5 seconds to 1.6s
		int cutNumberInHalf = 0;
		if (number % 2 == 0) {
			return false;
		} else {
			cutNumberInHalf = (number - 1) / 2;
			cutNumberInHalf++;
		}
		for (int j = 2; j <= cutNumberInHalf; j++) {
			// if the number can be divided by more then once, then it is not a prime number
			if (number % j == 0) {
				totalDividableNumber++;
			}
			if (totalDividableNumber > 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			Map<Character, Character> map = setupMap();
			StringBuilder sb = new StringBuilder();
			// count is here to place a space between every 5 letters
			int count = 0;
			for (int i = 0; i < string.length(); i++) {
				// check if the value of the map is null. if it is, ignore it.
				if(map.get(string.toLowerCase().charAt(i)) != null) {
					sb.append(map.get(string.toLowerCase().charAt(i)));
					count++;
				}
				// check if there is a digit
				if (Character.isDigit(string.charAt(i))) {
					sb.append(string.charAt(i));
					count++;
				}
				// if count is greater then 4, add a space. 
				if (count > 4) {
					if (i < string.length()) {
						sb.append(' ');
						count = 0;
					}
				}
			}
			return sb.toString().trim();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			Map<Character, Character> map = setupMap();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < string.length(); i++) {
				// check if the value of the map is null. if it is, ignore it.
				if(map.get(string.toLowerCase().charAt(i)) != null) {
					sb.append(map.get(string.toLowerCase().charAt(i)));
				}
				// check if there is a digit
				if (Character.isDigit(string.charAt(i))) {
					sb.append(string.charAt(i));
				}
			}
			return sb.toString().trim();
		}

		// map for converting chars
		private static Map<Character, Character> setupMap() {
			Map<Character, Character> map = new HashMap<Character, Character>();
			map.put('a', 'z'); map.put('b', 'y');
			map.put('c', 'x'); map.put('d', 'w');
			map.put('e', 'v'); map.put('f', 'u');
			map.put('g', 't'); map.put('h', 's');
			map.put('i', 'r'); map.put('j', 'q');
			map.put('k', 'p'); map.put('l', 'o');
			map.put('m', 'n'); map.put('n', 'm');
			map.put('o', 'l'); map.put('p', 'k');
			map.put('q', 'j'); map.put('r', 'i');
			map.put('s', 'h'); map.put('t', 'g');
			map.put('u', 'f'); map.put('v', 'e');
			map.put('w', 'd'); map.put('x', 'c');
			map.put('y', 'b'); map.put('z', 'a');
			return map;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		char[] cArray = string.replace("-", "").toCharArray();
		// final int because this question has a constant count down 10 to 1 
		final int ten = 10;
		int totalValue = 0;
		for (int i = 0; i < cArray.length; i++) {
			// check if the character is a digit
			if (Character.isDigit(cArray[i])) {
				// add the digit times ten-i
				totalValue = totalValue + (Character.getNumericValue(cArray[i]) * (ten - i));
			} else if (cArray[i] == 'X') {
				// if there is a char value X, add ten. 
				totalValue = totalValue + (10 * (ten - i));
			}
		}
		// check if divisible by 11.
		if (totalValue % 11 == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		int totalValue = 0;
		boolean letterAlreadyUsed = false;
		List<Integer> numbersFound = new ArrayList<Integer>();
		for (int i = 0; i < string.length(); i++) {
			letterAlreadyUsed = false;
			// check if the character is a letter
			if (Character.isLetter(string.charAt(i))) {
				// check if the ASCII has been used already
				for (Integer num : numbersFound) {
					// if the character is found set letterAlreadyUsed to true
					if (num == string.charAt(i)) {
						letterAlreadyUsed = true;
					}
				}
				// if letterAlreadyUsed is false, add to the total value and add the letter to the numbersFound array. 
				if (!letterAlreadyUsed) {
					totalValue += string.charAt(i);
					numbersFound.add((int) string.charAt(i));
				}
			}
		}
		// 2847 is the total value of the alphabet (lower case ASCII)
		if (totalValue == 2847) {
			return true;
		}
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		int GIGASECOND = 1000000000;
		// check if the current temporal supports seconds
		if (given.isSupported(ChronoUnit.SECONDS)) {
			given = given.plus(GIGASECOND, ChronoUnit.SECONDS);
			return given;
		} else {
			// if the temporal doesn't support seconds cast into LocalDate
			given = ((LocalDate) given).atStartOfDay();
			given = given.plus(GIGASECOND, ChronoUnit.SECONDS);
			return given;
		}
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		List<Integer> numbers = new ArrayList<Integer>();
		// for that counts up to the value of i
		for (int j = 1; j < i; j++) {
			// for loop for checking the set of numbers
			for (int k = 0; k < set.length; k++) {
				// if j * set is less then i add to the list.
				if (j * set[k] < i) {
					// if the int isn't in the List (I could have used a set for this, but didn't think about that till after I was done).
					if (!checkIfInList(numbers, j * set[k])) {
						// add it too the list
						numbers.add(j * set[k]);
					}
				}
			}
		}
		int result = 0;
		// add up the total result
		for (Integer num : numbers) {
			result = result + num;
		}
		return result;
	}

	// check if the value is already in the List
	private boolean checkIfInList(List<Integer> list, int num) {
		for (Integer value : list) {
			if (value == num) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < string.length(); i++) {
			if (Character.isDigit(string.charAt(i))) {
				numbers.add(Character.getNumericValue(string.charAt(i)));
			} else if (string.charAt(i) == ' ') {

			} else {
				// if a value that wasn't supposed to be input is found, end the program.
				return false;
			}
		}
		// count backwards to multiple every 2 numbers by 2. 
		for (int i = numbers.size() - 2; i > 0; i -= 2) {
			if (numbers.get(i) * 2 > 9) {
				numbers.set(i, ((numbers.get(i) * 2) - 9));
			} else {
				numbers.set(i, (numbers.get(i) * 2));
			}
		}
		int result = 0;
		// add up all the numbers
		for (Integer num : numbers) {
			result += num;
		}
		// if divisible by 10
		if (result% 10 == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// parse out the useless values leaving us with a number, math word, number.
		String[] strArray = string.toLowerCase().replace("what is ", "").replace("by ", "").replace("?", "").split(" ");
		int firstNumber = 0, secondNumber = 0, result = 0;
		// get both numbers
		firstNumber = Integer.parseInt(strArray[0]);
		secondNumber = Integer.parseInt(strArray[2]);
		// check what math symbol to use. 
		if ("multiplied".equals(strArray[1])) {
			result = firstNumber * secondNumber;
		} else if ("divided".equals(strArray[1])) {
			result = firstNumber / secondNumber;
		} else if ("plus".equals(strArray[1])) {
			result = firstNumber + secondNumber;
		} else if ("minus".equals(strArray[1])) {
			result = firstNumber - secondNumber;
		}
		return result;
	}

}
