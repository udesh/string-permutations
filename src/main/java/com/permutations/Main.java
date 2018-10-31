package com.permutations;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("Starting the program to generate permutations......");
		if (args[0] != null) {
			readFromFile(args[0]);
		} else {
			System.out.println("Please pass an input file full path as an argument......");
		}
		System.out.println("Ending the program......");
	}

	/**
	 * Read the strings exist in the file line by line and call the functions to
	 * generate permutations,sort them and print them
	 * 
	 * @param inputFilePath
	 *            The input file path of the file with the strings
	 * 
	 */
	public static void readFromFile(String inputFilePath) {
		FileInputStream inputFileStream = null;
		BufferedReader bufferReader = null;
		try {
			inputFileStream = new FileInputStream(inputFilePath);
			bufferReader = new BufferedReader(new InputStreamReader(inputFileStream));
			String strLine;
			System.out.println("Printing the generated permutations in alphabetical order......");
			while ((strLine = bufferReader.readLine()) != null) {
				generatePermutationsAndPrint(strLine);
			}
		} catch (Exception e) {
			System.out.println("Error in generating permutations " + e.getLocalizedMessage());
		} finally {
			if (bufferReader != null) {
				try {
					bufferReader.close();
				} catch (IOException e) {
				}
			}
			if (inputFileStream != null) {
				try {
					inputFileStream.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * Generate permutations , sort the permutations in alphabetical order and
	 * print them comma seperated
	 * 
	 * @param inputString
	 *            Input string value to generate the permutations sort them and
	 *            priint them
	 * 
	 */
	public static void generatePermutationsAndPrint(String inputString) {
		int stringCharacterLength = inputString.length();
		ArrayList<String> permutationsList = new ArrayList<String>();
		generatePermutation(inputString, 0, stringCharacterLength - 1, permutationsList);
		Collections.sort(permutationsList);
		System.out.println(permutationsList.toString().substring(1, permutationsList.toString().length() - 1));
	}

	/**
	 * Generate permutations for the passed string and add them to the list
	 * passed
	 * 
	 * @param inputString
	 *            String to generate permutations
	 * @param startingIndex
	 *            Starting index of the string
	 * @param endIndex
	 *            End index of the string
	 */
	public static void generatePermutation(String inputString, int startIndex, int endIndex,
			List<String> permutationsList) {
		if (startIndex == endIndex)
			permutationsList.add(inputString);
		else {
			for (int i = startIndex; i <= endIndex; i++) {
				inputString = swapCharacters(inputString, startIndex, i);
				generatePermutation(inputString, startIndex + 1, endIndex, permutationsList);
				inputString = swapCharacters(inputString, startIndex, i);
			}
		}
	}

	/**
	 * Swap characters of string in given positions.
	 * 
	 * @param value
	 *            String value to swap characters
	 * @param firstPosition
	 *            First position of the string value
	 * @param secondPosition
	 *            Second position of the string value
	 * @return swapped string
	 */
	public static String swapCharacters(String value, int firstPosition, int secondPosition) {
		char tempCharacter;
		char[] charArray = value.toCharArray();
		tempCharacter = charArray[firstPosition];
		charArray[firstPosition] = charArray[secondPosition];
		charArray[secondPosition] = tempCharacter;
		return String.valueOf(charArray);
	}

}
