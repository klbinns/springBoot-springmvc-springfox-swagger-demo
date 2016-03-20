package com.binns.business;

import com.binns.data.StringData;

public class StringManipulator {

	public static StringData forward(final String input){
		return new StringData(input, input);
	}
	
	public static StringData reverse(final String input){
		String reverse = new StringBuffer(input).reverse().toString();
		return new StringData(input, reverse);
	}
	
	public static StringData dropVowels(final String input){
		String stringWithDroppedVowels = input.replaceAll("[AEIOUaeiou]", "");
		return new StringData(input, stringWithDroppedVowels);
	}
	
}
