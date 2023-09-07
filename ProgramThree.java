//=================================================================
// Program name: ProrgamThree
// Author: Eric Gao
// Date: Nov 22, 2021
// Programming Language: Eclipse IDE for Java Developers
// Version: Neon.1a Release (4.6.1)
// Build id: 20161007-1200
//=================================================================
// Problem Definition – required to prompt the user for 2 non-negative integers and then display the Greatest Common Divisor of both numbers
//I - input of user name, user's first number, user's second number and exit 
//O - outputs the greatest common divisor of both numbers
//P - First, compare both numbers that the user enters. The lowest number will be the limit of the GCD because a number divided by a greater number will not result in an integer. Use the
//	  lowest number as the limit in the condition of a for loop. In the for loop, a number beginning at 1 will be increased by 1 as it is tested on the 2 numbers with modulus. If both 
//	  modulus calculations result in 0, then it will be updated as the greatest common divisor. Example:
//	
//	  4 and 8: the lowest number is 4
//	  Number: 4
//	  (1), (2), 3, (4), 5, 6, 7, 8, 
// 	  Number: 8
//	  (1), (2), 3, (4), 5, 6, 7, 8,
//	  GCD = 4
//
//=================================================================
/*List of Variables - let money represent the amount of money given the native – type integer

	-let name represent the name of the user - String name;
	-let numOne represent the first number that the user inputs - int numOne;
	-let numTwo represent the second number that the user inputs - int numTwo;
	-let leastNum represent the variable to store the least number out of the 2 numbers that the user inputs - int leastNum;
	-let greatestCD represent the greatest common divisor that is calculated - greatestCD = 0;
	-let integerCheck represent the boolean value to check if a the numbers that user inputs are positive or negative integers - boolean intgerCheck = true;

*/

import java.io.*; //import java.io

public class ProgramThree { //start of class ProgramThree

	public static void main(String[] args) throws IOException { //main method throws IOException
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Declaration and instantiation of a BufferedReader object

		String name; //declare a string type name
		int numOne = 0, numTwo = 0, leastNum, greatestCD = 0; //declare a primitive int data type numOne, numTwo, leastNum, greatestCD = 0
		boolean integerCheck = true;
		
		System.out.println("Hello! Welcome to the Greatest Common Divisor Program! This program will find the Greatest Common Divisor for two non-negative integers you input!"); //welcome message with description of what program does
		
		
		System.out.println("Please enter your name or 'stop' to end the program: "); //prompting user for their name. Also includes exit condition if user would like to end the program
		name = br.readLine(); //parsing and storing the input of the user
		
		while (!name.equals("stop")){ //while loop that runs on the condition that the user does not input "stop"
		
			System.out.println(name+", what's your first number?"); //UFP asking for the user's first number
			do { // a do while loop, this is here to make BULLETPROOF the code and make sure the user enters a non-negative number. The loop is here because it runs the prompt again if there is a catch
				try { // this is try/catch. The code is executed in the try {. However, if the exceptions are caught in catch, the program will perform the code in catch{
				numOne = Integer.parseInt(br.readLine()); //parsing and storing the user's first number into numOne
				if (numOne <0)  //an if statement to check if numOne is negative integer
					integerCheck = false; // if it is a negative number, then integer check is false and requires the user to enter a number again
				else // else, numOne is not a negative number. Therefore, it is valid and the code will run intendedly
					integerCheck = true; //since the number is no a negative number and if no number format exceptions are caught, then integerCheck can be true
			}//exit try
			catch (NumberFormatException error) { //this is the catch. NumberFormatException basically occurs when an attempt is made to convert a string with improper format into a numeric value
				System.out.println(name+", please input a non-negative integer! what's your first number?"); //a message to the user that their input is invalid and prompts them to enter it again
				integerCheck = false; //since the integer entered is not valid, integerCheck is false
			}//exit catch
			}while (integerCheck == false); //when integerCheck is false, the loops runs again until the value that the user enters is valid.

			
			System.out.println(name+", what's your second number?");//UFP asking for the user's second number
			do { // a do while loop, this is here to make BULLETPROOF the code and make sure the user enters a non-negative number. The loop is here because it runs the prompt again if there is a catch
				try {// this is try/catch the code is executed in the catch. However, if the exceptions are caught in catch, the code will result in something else
				numTwo = Integer.parseInt(br.readLine()); //parsing and storing the user's second number into numTwo
				if (numTwo <0) //an if statement to check if numTwo is negative integer
					integerCheck = false; // if it is a negative number, then integer check is false and requires the user to enter a number again
				else // else, numTwo is not a negative number. Therefore, it is valid and the code will run intendedly
					integerCheck = true; //since the number is no a negative number and if no number format exceptions are caught, then integerCheck can be true
			}//exit try
			catch (NumberFormatException error) { //this is the catch. NumberFormatException basically occurs when an attempt is made to convert a string with improper format into a numeric value
				System.out.println(name+", please input a non-negative integer! what's your second number?"); //a message to the user that their input is invalid and prompts them to enter it again
				integerCheck = false;//since the integer entered is not valid, integerCheck is false
			}//exit catch
			}while (integerCheck == false);//when integerCheck is false, the loops runs again until the value that the user enters is valid.
			
			if (numOne >= numTwo) //here this is an if statement the displays 2 cases. This is if the first number is larger or equal to the second number
				leastNum = numTwo; //either way, if they are equal, then least number could be either. If number one is larger, then number two will be assigned to the lowest number as leastNum
			else  //the only other case that could happen is if the second number is larger than the first
				leastNum = numOne; //in that case, then the first number will be assigned as the last number
				
			
			for (int i = 1; i <= leastNum; i++) { //here is a counted loop with the condition limit being the lowest number. As mentioned, the GCD cannot be bigger than a number
				if ((numTwo%i == 0)&&(numOne%i == 0)) { //here, I use the variable i instead of a counter. i incrementally goes up and I test if it results in 0 when used in a modulus
					greatestCD = i; //if they both result in 0, then it is a common divisor and the loop will continue going until the greatest one is found and assigned to greatest CD
				}
			}
			System.out.println("The greatest common factor of '"+numOne+"' and '"+numTwo+"' is: "+greatestCD); //User friendly resulting prompt. It shows the user's 2 inputs and the GCD!
		
			System.out.println("Would you like to stop the program "+name+"? Enter your name to continue or 'stop' to end the program"); //UFP to ask if they want to rerun the program
			name = br.readLine();//assigns and stores the name/exit condition into name
		}
		System.out.println("Goodbye "+name+"! Thank you for using the Greatest Common Divisor Program"); //User Friendly exit statement
		System.out.println("A program by Eric Gao (2021)"); //A program by me :)

	}

}
