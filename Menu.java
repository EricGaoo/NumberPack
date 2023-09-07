//=================================================================
// Program name: ProrgamFourMenu
// Author: Eric Gao
// Date: November 22, 2021
// Programming Language: Eclipse IDE for Java Developers
// Version: Neon.1a Release (4.6.1)
// Build id: 20161007-1200
//=================================================================
//Problem Definition – required to create a menu to select from between programOne, //programTwo and programThree. After running the program, the user will be prompted if they //wanted to continue the program or select new one
//I - input of user’s name, user's program choice and exit condition
//O - outputs programOne, programTwo, programThree choice to continue or choose a new //program
//P - Assign each program to a number. The user will then input a number when prompted. A //switch/case will be used to show the programs once. After the program is finished, the user //is prompted to continue or choose a new program. If they select to continue, the program will //repeat. If they select to stop, they will choose a new program.
//	  
//
//
//=================================================================
/*List of Variables 
	-let name represent the name of the user for all the programs - String name;
	-let menuChoice represent the user’s input when either choosing a program or   entering the exit string - String menuChoice; 
	-let menuRestart represents the user's input when asked if they want to choose to continue or end the current program - String menuRestart = 0;
	-let menuVerify represent the boolean value to validate if the user would like to go back to the menu - boolean menuVerify = false;
	-let choice represent the variable that stores the input when menuChoice is parsed to an integer - int choice = 0;
*/

import java.io.*; //import java.io

public class ProgramFourMenu { //start of class ProgramOne

	public static void main(String[] args) throws IOException{	//main method, throws IOException			
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Declaration and instantiation of a BufferedReader object

	
		String name; //declare a string data type name
		String menuChoice, menuRestart; //declare a string type menuChoice, menuRestart
		boolean menuVerify = false; //declare boolean data type menuVerify
		int choice = 0; //declare integer data type choice
		
		System.out.println("Hello! Welcome to the ICS3UI Java Program Pack! This pack contains 3 programs that will complete different tasks!"); //welcome message with description of what program does

		System.out.println("What's your name?"); //UFP for user's name
		name = br.readLine();	 //reading and storing the user's name
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------"); //a line to separate the printed statements. This just makes it easier for the user to read the text
		System.out.println("Hello "+name+", choose from the following programs below:"); //UFP to tell the user to choose from the programs
		System.out.println("1 - Digit Displayer: A program that program that will display each digit of a non-negative integer you input");  //A description and assigned value to run The Digit Displayer Program
		System.out.println("2 - GCD: A program that will find the Greatest Common Divisor for two non-negative integers you input");/A description and assigned value to run The GCD Program
		System.out.println("3 - BinaryToDecimal: A program that will convert your binary input into decimal!");//A description and assigned value to run The Binary To Decimal Program
		System.out.println("Enter the number in front of the program to run it or enter 'end' to stop the whole program:"); //UFP to instruct the user to enter the assigned number or to exit from the programs
		menuChoice = br.readLine(); //reading and storing the string into menuChoice
		
		while (!menuChoice.equals("end")) {
			try {
				choice = Integer.parseInt(menuChoice);
				if (choice>0 && choice<4) {
					switch (choice)
					{
					case 1 :
						int origNum = 0, number = 0, count = 0, loopCount = 0, tenExponent = 1;
						final int TEN = 10;
						
						System.out.println("Hello! Welcome to the Digit Display Program! This program will display each digit of a non-negative integer you input");					

							do {
								System.out.println(name+", enter a non-negative integer number");
								origNum = Integer.parseInt(br.readLine());
								if (origNum < 0) {
									System.out.println("Please enter a non-negative integer!");
								} 
								else {
									number = origNum;
								}
							}while (origNum < 0);

							
							while(origNum>0) {
								count++;
								origNum /= TEN;
								
							}	
								origNum = number;
								loopCount = count;
								
							System.out.println("The digits for '"+origNum+"' in order is: ");
								
							for (int k = 1; k<=loopCount; k++) {
								for (int i = count-1; i>=1; i--) {
									tenExponent *= TEN;
								}
								
								count -= 1;
								number = (number/tenExponent)%TEN;
								System.out.println(number);
								number = origNum;
								tenExponent = 1;
							}
						break;
					case 2 :
						int numOne = 0, numTwo = 0, leastNum, greatestCD = 0;
						boolean integerCheck = true;
						
						
						System.out.println("Hello! Welcome to the Greatest Common Divisor Program! This program will find the Greatest Common Divisor for two non-negative integers you input!");
						
							System.out.println(name+", what's your first number?");
							do {
								try {
									numOne = Integer.parseInt(br.readLine());
									if (numOne <0) 
										integerCheck = false;
									else
										integerCheck = true;
							}
							catch (NumberFormatException error) {
								System.out.println(name+", please input a non-negative integer! what's your first number?");
								integerCheck = false;
							}
							}while (integerCheck == false);
							System.out.println(name+", what's your second number?");
							do {
								try {
									numTwo = Integer.parseInt(br.readLine());
									if (numTwo <0) 
										integerCheck = false;
									else
										integerCheck = true;
							}
							catch (NumberFormatException error) {
								System.out.println(name+", please input a non-negative integer! what's your second number?");
								integerCheck = false;
							}
							}while (integerCheck == false);
							
							if (numOne >= numTwo) 
								leastNum = numTwo; 
							else 
								leastNum = numOne; 
								
							
							for (int i = 1; i <= leastNum; i++) {
								if ((numTwo%i == 0)&&(numOne%i == 0)) {
									greatestCD = i;
								}
							}
							System.out.println("The greatest common factor of '"+numOne+"' and '"+numTwo+"' is: "+greatestCD);
						
						break;
					case 3 :
						int userNum, userDigit = 0, origNum3, total = 0, exponent = 1, count3 = 0;
						boolean isBinary = true;
						
						System.out.println("Hello! Welcome to the Binary to Decimal Program! This program will convert your binary input into decimal!");
						
						System.out.println("Hi "+name+", please input your BINARY number or a negative number to exit the program:");
						userNum = Integer.parseInt(br.readLine());
						origNum3 = userNum;

							while(userNum > 0){ 
								count3 += 1;
								
								if (count3 == 1) 
									exponent = 1;
								else 					
									exponent*= 2;
								
								userDigit = userNum%10;
								if (userDigit == 1)
									total = total+exponent;
								else if (userDigit >= 2) {
									isBinary = false;
								}
								userNum = userNum/10;
							
							}
							if (isBinary == false) 
								System.out.println("Invalid value!");
							else 
								System.out.println("The decimal value of "+origNum3+" is: "+total);
							count3 = 0;
							total = 0;
							
						break;
					}
						do {
							System.out.println("would you like to continue this program? Please enter yes or no");
							menuRestart = br.readLine();	
							if (menuRestart.equals("no")|| menuRestart.equals("NO")) {
								System.out.println("-----------------------------------------------------------------------------------------------------------------");
								System.out.println("Hello! Welcome back to the ICS3UI Java Program Pack!");
								System.out.println("1 - Digit Displayer: A program that program that will display each digit of a non-negative integer you input");
								System.out.println("2 - GCD: A program that will find the Greatest Common Divisor for two non-negative integers you input");
								System.out.println("3 - BinaryToDecimal: A program that will convert your binary input into decimal!");
								System.out.println("Enter the number infront of the program to run it or enter 'end' to stop the whole program:");
								menuChoice = br.readLine();
								menuVerify = true;
							}
							else if (menuRestart.equals("yes")|| menuRestart.equals("YES")||menuRestart.equals("Yes")) {
								menuVerify = true;

							}
							else {
								System.out.println("Please input 'yes' to continue or 'no' to stop");
								menuVerify = false;
								
							}
						} while(!menuVerify == true);
				}
				else if (!menuChoice.equals("end")) {
					System.out.println("You can only input 1,2,3 or end in the program!");
					System.out.println("-----------------------------------------------------------------------------------------------------------------");
					System.out.println("Hello! Welcome to the ICS3UI Java Program Pack! This pack contains 3 programs that will complete different tasks!");
					System.out.println("1 - Digit Displayer: A program that program that will display each digit of a non-negative integer you input");
					System.out.println("2 - GCD: A program that will find the Greatest Common Divisor for two non-negative integers you input");
					System.out.println("3 - BinaryToDecimal: A program that will convert your binary input into decimal!");
					System.out.println("Enter the number infront of the program to run it or enter 'end' to stop the whole program:");
					menuChoice = br.readLine();
				}

			}
			catch (NumberFormatException error) {
				System.out.println("You can only input 1,2,3 or end in the program!");
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				System.out.println("Hello! Welcome to the ICS3UI Java Program Pack! This pack contains 3 programs that will complete different tasks!");
				System.out.println("1 - Digit Displayer: A program that program that will display each digit of a non-negative integer you input");
				System.out.println("2 - GCD: A program that will find the Greatest Common Divisor for two non-negative integers you input");
				System.out.println("3 - BinaryToDecimal: A program that will convert your binary input into decimal!");
				System.out.println("Enter the number infront of the program to run it or enter 'end' to stop the whole program:");
				menuChoice = br.readLine();
			}
			if (menuChoice.equals("end")) {
				System.out.println("Goodbye!Thank you for using the ICS3UI Java Program Pack!");
				System.out.println("A program by Eric Gao (2021)");
			}
	}

}

}



