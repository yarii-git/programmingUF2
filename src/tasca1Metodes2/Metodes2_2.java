package tasca1Metodes2;
import java.util.Scanner;
//Author: Yarií Soto
//Date: 27/12/2022
/*
2.Escriu el mètode llegirPrimerDouble que espera la entrada d’un número de tipus double 
i en cas que el número entrat sigui un double el retorna, en cas contrari torna a demanar el double. 
El mètode rep per parametre l'Scanner i el missatge que es vol mostrar l'usuari (prompt)

Signatures de les funcions
public static double llegirFinsDouble(Scanner in, String prompt)

Exemple
Scanner in = new Scanner(System.in);
double d = llegirFinsDouble(in, "Introdueix un número: ");
*/
public class Metodes2_2 {
	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		double numDouble = readUntilDouble(input, "Introdueix un número: ");
		System.out.printf("El número %f és Double.",numDouble);
	}
	
	public static double readUntilDouble(Scanner input, String prompt) {
		boolean isDouble=false;
		double num=0f;
		//TODO restar la parte entera del número a el mismo, si sale 0 no es decimal, en el scanner si hay una , o un . es decimal
		do {
			System.out.print(prompt);
			String entryUser=input.nextLine();
			
			/*if(entryUser.matches("\\d+\[,|.\]\\d+")) {
				
			}*/
			
		}while(!isDouble);
		
		return num;
	}
}
