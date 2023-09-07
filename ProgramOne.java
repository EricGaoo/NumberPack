//=================================================================
// Program name: ProrgamOne
// Author: Eric Gao
// Date: November 22, 2021
// Programming Language: Eclipse IDE for Java Developers
// Version: Neon.1a Release (4.6.1)
// Build id: 20161007-1200
//=================================================================
//Problem Definition – required to prompt the user for a non-negative integer and then display each digit in the number on separate lines
//I - input of user name, user's number and exit condition
//O - outputs each digit of the number IN ORDER
//P - calculate the number of digits in the number, then use the following calculation method: divide the number by 10 to the power of # of digits-1 and modulus it by 10 [digit = (n/10^# of digits-1)%10]. 
//	  The amount of digits will used in a counted loop and will be used to calculate the digits from left to right which will result in the output being in order. Example:
//
// 	  (192/100)%10 = 1
// 	  (192/10)%10 = 9
// 	  (192/1)%10 = 2
//
//=================================================================
/*List of Variables 
	-let name represent the name of the user - String name;
	-let origNum represent the original number inputed by the user. This will be used to store and use the orignal number - int origNum = 0;
	-let number represent the number inputed by the user. This will be updated and changed as the calculations are performed on it - int number = 0;
	-let count represent the counter to keep the nested loop when calculating the exponent of the 10 - int count = 0;
	-let loopCount represent the counter in the for loop to track how many times a number is divided by 10 and modified with modulus - int loopCount = 0;
	-let tenExponent represent the 10 exponent value that the user's number is divided by. This number is to the next power every time it runs through the loop - int tenExponent;
	-let TEN represent a constant for 10 which is used in modulus and exponents - final int TEN = 10;
*/

import java.io.*; //import java.io

public class ProgramOne { //start of class ProgramOne

	public static void main(String[] args) throws IOException { //main method, throws IOException

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); //Declaration and instantiation of a BufferedReader object
		
		String name; //declare a string data type name
		int origNum = 0, number = 0, count = 0, loopCount = 0, tenExponent = 1; //declare a primitive int data type origNum = 0, number = 0, count = 0, loopCount = 0, tenExponent = 1
		final int TEN = 10; // declare a primitive int data type CONSTANT named TEN
		
		System.out.println("Hello! Welcome to the Digit Display Program! This program will display each digit of a non-negative integer you input"); //welcome message with description of what program does
		System.out.println("What's your name: "); //UFP for user's name
		name = br.readLine(); //reading and storing the user's name

		while (!name.equals("stop")) { //This is the loop for Displaying digits. The exit condition to the loop is if the user inputs "stop" as their name, the loop will end."
			do { // Bulletproofing: a loop to confirm the user's number is not a negative number
				System.out.println(name+", enter a non-negative integer number"); //UFP for the user's number
				origNum = Integer.parseInt(br.readLine()); //parsing the user's number input to origNum
				if (origNum < 0) { //if statement. Determines if the user's input is less than 0
					System.out.println("Please enter a non-negative integer!"); //a message telling the user to enter a non negative integer
				} //exit if statement
				else { //if the number is a non negative integer, then continue.
					number = origNum; //store user's number in 'number' this will be needed later when the value in origNum is modified.
				} // exit else statement
			}while (origNum < 0); // if the input is less than 0, the loop will restart and prompt the user for a non-negative value. if the number is a non negative integer, then exit the while loop and continue with the program. 

			while(origNum>0) { // a while loop to determine the number of digits in the user's number. This loop ends when 
				count++; //a counter that increments by 1. This counter will be storing the number of variables
				origNum /= TEN; //original number is divided by 10 each time the loop runs. This will eventually end in the original number reducing to zero which will happen after it is divided by the number of digits
				
			}// exit the while loop
				origNum = number; //after the loop, origNum is 0 so this resets the value of origNum with the original number that the user entered.
				loopCount = count; //assign the count (number of digits) to the loop count. The reason there is 2 counters is because they will be needed for nested loops
				
			System.out.println("The digits for '"+origNum+"' in order is: "); //UFP to tell the user their number and to start the digits. 
				
			for (int k = 1; k<=loopCount; k++) { //the start of the loop. This loop runs by the number of digits
				for (int i = count-1; i>=1; i--) { 
/*					This loop finds the exponent of 10 that divides into the digits of the number. Every time the loop runs, the count is subtracted by one. 
 * 					It's decremented because it needs to read from left to right. Hence, the exponent must be the largest as it gets smaller. The reason  the count 
 * 					variable is subtracted by 1 is because the 10 is to an extra exponent. For example, 192 would have 3 digits and 10 to the power of 3 is 1000 which 
 * 					is too much
 */
					tenExponent *= TEN; // here ten is raised by the exponent. The number of times this happens is based on the count variable in the for loop. tenExponent starts at 1 because if it starts at 0, it will always equal 0. 
				}//exit the for loop
				
				count -= 1; //here, the count (number of digit that was set earlier) is decremented to find the smaller digit in the loop, the next time it runs.
				number = (number/tenExponent)%TEN;//This is the line which calculates the digit. As explained earlier, the original number is divided by 10 to the power of number of digits-1 and moduled by 10. 
												  //This is also where the number variable comes in. we need the original number to put through the algorithm
				System.out.println(number);//printing out each digit on separate lines
				number = origNum; //Now we use origNum to bring the number back to it's original value. If we don't do this, number will be modified when it's run through the loop again
				tenExponent = 1;  //resetting tenExponent back to 1 each time. Without this, the exponent will get greater each time because it takes the previous exponent
			}//exit the for loop
			System.out.println("What's your name: "); //UFP for user's name again
			name = br.readLine(); //reading and storing the user's name

		}
		System.out.println("Goodbye "+name+"!Thank you for using the Digit Display Program"); //User Friendly exit statement
		System.out.println("A program by Eric Gao (2021)"); //A program by me :)


	}//End main method

}//end ProgramOne class
