
//=================================================================
// Program name: ProgamTwo
// Author: Eric Gao
// Date: November 22, 2021
// Programming Language: Eclipse IDE for Java Developers
// Version: Neon.1a Release (4.6.1)
// Build id: 20161007-1200
//=================================================================
//Problem Definition – required to prompt the user for binary and then to convert to decimal in one line
//I - input of user name, user's number and exit condition
//O - the binary value of their number
//P - The number is run through a similar algorithm to ProgramOne. Each digit is found however this time, it's from right to left. To do this we use a loop where we modulus the user's number for the remainder.
//	  Then, we divide the user's number by 10 to find the next digit. At the same time, each time the loop runs, the exponent that 2 is raised by is increased by 2. Finally, an if statement is added
//	  if the program detects a 1. If it does, it adds the 2 to the exponent to a total. After the loop finishes running, we end up with the decimal value!
//
// 	  101%10 = 1 --> 0(total) + 2^0 = 1
// 	  101/10 = 10
//	  10%10 = 0 --> does not equal 1!
// 	  10/10 = 1
//	  1%10 = 1 --> 1(total) + 2^2 = 5
// 	  1/10 = 0
// 	  
//
//=================================================================
/*List of Variables 
	-let name represent the name of the user - String name;
	-let origNum represent the original number inputed by the user. This will be used in calculation message when the value is calculated - int origNum;
	-let userNum represent the number inputed by the user. This will be updated and changed as the calculations are performed on it - int userNum = 0;
	-let total represent the the decimal value that is calculated from the binary number - int total = 0;
	-let loopCount represent the counter in the for loop to track how many times a number is divided by 10 and modified with modulus - int loopCount = 0;
	-let exponent represent the value calculated when it is raised to the exponent of 2. This number is to the next power every time it runs through the loop - int exponent = 1;
	-let TEN represent a constant for 10 which is used in modulus and division - final int TEN = 10;
	-let isBinary represent whether the user input is binary - boolean isBinary = true;
*/

import java.io.*; // import java.io

public class ProgramTwo { //start of class ProgramTwo

	public static void main(String[] args) throws IOException { //main method throws IOException
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Declaration and instantiation of a BufferedReader object

		String name; //declare a string type name
		int userNum, userDigit = 0, origNum, total = 0, exponent = 1, count = 0; //declare a primitive int data type userNum, userDigit = 0, origNum, total = 0, exponent = 1, count = 0
		final int TEN = 10; // declare a primitive int data type CONSTANT named TEN
		boolean isBinary = true; //declare a boolean data type isBinary used to verify if the number a user inputs is binary or not
		
		System.out.println("Hello! Welcome to the Binary to Decimal Program! This program will convert your binary input into decimal!"); //User Friendly Welcome to introduce and explain the program
		
		System.out.println("What's your name: "); //prompting user for their name
		name = br.readLine(); //parsing and storing the user's name input to the name variable
		
		System.out.println("Hi "+name+", please input your BINARY number or a negative number to exit the program:"); //UFP to tell the user to input the number
		userNum = Integer.parseInt(br.readLine()); //parsing and assigning the variable to the userNum
		origNum = userNum; //Storing the user's original number into origNum. This will be used at the end of the program

		while (userNum > 0) { //while loop with the condition of the number that the user inputs is not 0 and has the job of repeating the program
			while(userNum > 0){ //while loop for calculating the digits and total decimal value. The condition is userNum cannot equal 0 which happens when the final digit is calculated
				count += 1; //counter used to understand what exponent 2 is raised to
				
				if (count>1) //if statement to make sure at the first digit, when 2 is raised to the exponent of 0, the value is 1 NOT 0.					
					exponent*= 2; //here, the exponent is multiplied by 2. The amount of times this happens is determined with the while loop
				
				userDigit = userNum%TEN; //userDigit is used here to store the digit from module 10. As the userNum is divided by 10, you get the digit from right to left.
				if (userDigit == 1) //if statement for the program to know when to add the number exponent to the total. If there's a zero, then nothing is added
					total = total+exponent; //total starts at 0 and is added to with the exponent values to get the decimal value
				else if (userDigit >= 2) { //while reading through all the digits, if there is a number that is more than or equal to 2, then the number is not binary
					isBinary = false; //the boolean isBinary is then set to false
				}
				userNum = userNum/TEN; //after modulating userNum, it is then divided by ten to get to the next digit of the number
			}
			if (isBinary == false) //if statement to determine if the user's number is binary or not from the boolean isBinary variable
				System.out.println("Invalid value!"); //if the number is not binary, it will not result in a decimal number but instead an invalid number message
			else if (isBinary == true) //the opposite of the if statement, if isBinary is true, then that means the number is binary
				System.out.println("The decimal value of "+origNum+" is: "+total); //then, the program will show the user their original binary number and the decimal value
			
			count = 0; //resetting count. Without this, then 2 to the power of 0 will not be taken into account
			total = 0; //resetting total. Without this, then the next time you run the program, your decimal will be added to the previous
			
			System.out.println("Hi "+name+", please input your BINARY number or a negative number to exit the program:"); //UFP to tell the user to input the number again
			userNum = Integer.parseInt(br.readLine()); //parsing and assigning the variable to the userNum again
			origNum = userNum; //Storing the user's original number into origNum. This will be used at the end of the program again

		}
		if (userNum == 0) { //since "0" is an integer, we need an output in case the user enters "0"
			System.out.println("The decimal value of "+origNum+" is: "); //the program will show the user their original binary number and the decimal value
			System.out.println("0"); //no matter how many 0s you put, the decimal value will always be 0. So, it's appropriate to just print 0;
		}
		System.out.println("Goodbye "+name+"! Thank you for using the Digit Display Program");//User Friendly exit message
		System.out.println("A program by Eric Gao (2021)");//made by me :)
		
	}//End main method

}//end ProgramOne class
