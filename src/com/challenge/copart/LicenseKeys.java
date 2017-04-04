package com.challenge.copart;

import java.util.Scanner;

public class LicenseKeys {
	
	public static void main(String[] args) {
		
		final int FIRST_INDEX = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		String inputString;
		int subTokenSize;
		
		System.out.print("Enter the string: ");
		inputString = keyboard.nextLine();
		
		//Convert into uppercase
		inputString = inputString.toUpperCase();

		System.out.print("Enter size of the sub token: ");
		subTokenSize = keyboard.nextInt();
		
		
		StringBuffer tempString = new StringBuffer();
		
		int newStringCount = 0;
		int loopCount = inputString.length() - 1; 
		while (loopCount >= 0) {
			char tempChar = inputString.charAt(loopCount);  
			
			if (tempChar != '-') {
				tempString.append(tempChar); 
				newStringCount++;
			}
			
			if (newStringCount % subTokenSize == 0 
							&& loopCount != FIRST_INDEX) {
				tempString.append("-");
			}
			
			loopCount--;
						
		}
		
		tempString.reverse();
		System.out.println("Final String --->" + tempString);
		
		keyboard.close();
		System.exit(0);
	}

}
