import java.io.*;
import java.applet.*;//import the Applet class
import java.awt.*; //import Graphics class
import java.awt.event.*;


public class ProgramFourAppletMenu extends Applet implements ActionListener {

	static boolean DigitDisplayerChoice = false;
	static boolean GCDChoice = false;
	static boolean BinaryToDecimalChoice = false;
	

	public void init(){
			button1 = new Button("Digit Displayer");
			add(button1);
			button1.addActionListener(this);

			button2 = new Button("Greatest Common Divisor Finder");
			add(button2);
			button2.addActionListener(this);
			
			button3 = new Button("Binary to Decimal Converter");
			add(button3);
			button3.addActionListener(this);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				DigitDisplayerChoice = true;
				System.out.println("Running The Digit Displayer...");	
				
			}
			else if (e.getSource() == button2) {
				GCDChoice = true;
				System.out.println("Running The Greatest Common Divisor Finder...");
			}	
			else {
				BinaryToDecimalChoice = true;
				System.out.println("Running The Binary to Decimal Converter...");
			}
			
			if (DigitDisplayerChoice = true) {
				try {
					DigitDisplayer.main(null);
				} catch (IOException e1) {

				}
			}
			else if (GCDChoice = true) {
				try {
					GCD.main(null);
				} catch (IOException e1) {

				}
			}
			else if (BinaryToDecimalChoice = true) {
				try {
					BinaryToDecimal.main(null);
				} catch (IOException e1) {

				}
			}
		}
		
		Button button1, button2, button3;
}

class DigitDisplayer {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		String name;
		int origNum = 0, number = 0, count = 0, loopcount = 0, tenExponent = 1;
		final int TEN = 10;
		
		System.out.println("Hello! Welcome to the Digit Display Program! This program will display each digit of a non-negative integer you input");
		
		System.out.println("What's your name: ");
		name = br.readLine();

		while (!name.equals("stop")) {
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
				loopcount = count;
				
			System.out.println("The digits for '"+origNum+"' in order is: ");
				
			for (int k = 1; k<=loopcount; k++) {
				for (int i = count-1; i>=1; i--) {
					tenExponent *= TEN;
				}
				
				count -= 1;
				number = (number/tenExponent)%TEN;
				System.out.println(number);
				number = origNum;
				tenExponent = 1;
			}
			System.out.println("What's your name: ");
			name = br.readLine();

		}
		System.out.println("Goodbye "+name+"!Thank you for using the Digit Display Program");
		System.out.println("A program by Eric Gao (2021)");


	}
}

class GCD {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String name;
		int userNum, userDigit = 0, origNum, total = 0, exponent = 1, count = 0;
		boolean isBinary = true;
		
		System.out.println("Hello! Welcome to the Binary to Decimal Program! This program will convert your binary input into decimal!");
		
		System.out.println("What's your name: ");
		name = br.readLine();
		
		System.out.println("Hi "+name+", please input your BINARY number or a negative number to exit the program:");
		userNum = Integer.parseInt(br.readLine());
		origNum = userNum;

		while (userNum > 0) {
			while(userNum > 0){ 
				count += 1;
				
				if (count == 1) 
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
				System.out.println("The decimal value of "+origNum+" is: "+total);
			
			count = 0;
			total = 0;
			
			System.out.println("Hi "+name+", please input your BINARY number or a negative number to exit the program:");
			userNum = Integer.parseInt(br.readLine());
			origNum = userNum;

		}
		System.out.println("Goodbye "+name+"! Thank you for using the Digit Display Program");
		System.out.println("A program by Eric Gao (2021)");
		
	}
}
class BinaryToDecimal {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String name;
		int userNum, userDigit = 0, origNum, total = 0, exponent = 1, count = 0;
		boolean isBinary = true;
		
		System.out.println("Hello! Welcome to the Binary to Decimal Program! This program will convert your binary input into decimal!");
		
		System.out.println("What's your name: ");
		name = br.readLine();
		
		System.out.println("Hi "+name+", please input your BINARY number or a negative number to exit the program:");
		userNum = Integer.parseInt(br.readLine());
		origNum = userNum;

		while (userNum > 0) {
			while(userNum > 0){ 
				count += 1;
				
				if (count == 1) 
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
				System.out.println("The decimal value of "+origNum+" is: "+total);
			
			count = 0;
			total = 0;
			
			System.out.println("Hi "+name+", please input your BINARY number or a negative number to exit the program:");
			userNum = Integer.parseInt(br.readLine());
			origNum = userNum;

		}
		System.out.println("Goodbye "+name+"! Thank you for using the Digit Display Program");
		System.out.println("A program by Eric Gao (2021)");
		
	}
}
