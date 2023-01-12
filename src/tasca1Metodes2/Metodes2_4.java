package tasca1Metodes2;

import java.util.Scanner;

//Author: Yarií Soto
//Date: 27/12/2022
/*
4..(update) A la uf anterior vas fer un programa per convertir números romans a la seva representació decimal, l’enunciat era el següent:
Escriu un programa que converteixi un enter positiu en números romans. Amb les següents consideracions:

	1.El sistema de numeració romà té els següents dígits:

		a. I → 1
	
		b. V → 5
	
		c. X → 10
	
		d. L → 50
	
		e. C → 100
	
		f. D → 500
	
		g. M → 1000
	

	2.Només es representaran números entre 1 i 3999

	3.Com en el sistema decimal, els milers, les centenes, les desenes i les unitats s’expressen separadament.
	
	4.Els nombres del 1 al 9 s’expressen com I II III IV V VI VII VII IX
	
		a. Les desenes i les centenes funcionen igual però substituint I, V, X per X, L, C o C, D, M


*/
public class Metodes2_4 {
	public static void main (String[]args) {
		final short MIN=1, MAX=3999;
		short num;
		Scanner input = new Scanner(System.in);
		System.out.println("Aquest programa mostra la representació en números romans d'un nombre decimal enter.");
		
		//Control the user's entry.
		do {
			System.out.print("Introdueix un número enter (del 1 al 3999) per convertir a números romans: ");
			num = input.nextShort();
		}while(num<MIN || num>MAX);
		
		input.close();
		System.out.printf("La representació del nombre %d en números romans és: %s",num,toRomanNum(num));
	}
	
	//Method to convert decimal numbers into Roman numbers.
    public static String toRomanNum(short number) {
    	char [] numberString;
    	byte [] numbers;
    	
    	//Array with Roman numbers.
    	final String [][] NUMS_ROMAN= {
    			{"", "I", "II", "III", "IV", "V", "VI", "VII", "VII", "IX"}, //Unity
    			{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, //Ten
    			{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, //Hundred
    			{"","M","MM","MMM"}//Thousand
    			};
    	
    	StringBuilder numRoman = new StringBuilder();
    	
    	//Fill an array with the number's digits.
    	numberString=String.valueOf(number).toCharArray();
    	numbers=new byte [numberString.length];
    	
    	//Poner los números al revés, desde el último dígito al primero
    	byte count=0;
    	for(byte i= (byte) (numbers.length-1);i>=0;i--){
    		numbers[count]=(byte) (Character.getNumericValue(numberString[i]));
    		count++;
    	}
    	
    	//Build the Roman number string
    	for(byte i=(byte) (numbers.length-1);i>=0;i--){
    		numRoman.append(NUMS_ROMAN[i][numbers[i]]);
    	}
    	
		return numRoman.toString();
	}
}
