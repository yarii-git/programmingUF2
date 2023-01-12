package tasca1Metodes2;
import java.util.Scanner;
//Author: Yarií Soto
//Date: 27/12/2022
/*
6.Escriu un programa que demani un número i mostri les taules de multiplicar de la d l'1 fins el número entrat. 
Utilitza mètodes per simplificar el codi.
*/
public class Metodes2_6 {
	public static void main(String[]args) {
		final byte MIN_MULTIPLE=1,MAX_MULTIPLE=10;
		byte numUser;
		Scanner input=new Scanner(System.in);
		System.out.println("Aquest programa mostra les taules de multiplicar de l'1 fins al número entrar.");
		System.out.print("Fina quina taula vols que es mostrin? (número enter entre 1 i 10): ");
		numUser=input.nextByte();
		
		
		for (byte i=MIN_MULTIPLE;i<=numUser;i++) {
			for (byte j=MIN_MULTIPLE;j<=MAX_MULTIPLE;j++) {
				System.out.printf("%d x %d = %d",i,j,multiply(i,j));
				System.out.printf("%n");
			}
			System.out.printf("%n");
		}
	}
	
	public static byte multiply(byte num1,byte num2){
		byte multiplication;
		multiplication = (byte) (num1*num2);
		return multiplication;
	}
}
