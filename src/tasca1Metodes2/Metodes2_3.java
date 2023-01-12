package tasca1Metodes2;

import java.util.Scanner;

//Author: Yarií Soto
//Date: 27/12/2022
/*
3.Escriu un mètode intToNom que donat un número enter positiu, menor que 10000, el retorni escrit amb lletres. Per exemple:

Exemple
String nom = intToNom(952);
System.out.println(nom);
nou-cents cinquanta-dos

Recorda que en català s’aplica la regla del D-U-C, és a dir, es posa guió entre les desenes i les unitats 
i entre les unitats i les centenes i que les vintenes s’escriuen amb una i amb guions, per exemple vint-i-sis.

Finalment fes un programa que demani números enters a l’usuari i els mostri escrits en lletres fins que s’entri un número negatiu.

Per fer el programa necessitaràs una sèrie de mètodes que hauràs d’implementar. 
Per exemple pots descomposar el problema principal en problemes més petits com ara convertir només les unitats, o convertir només les desenes ...

Signatura del mètode intToNom:
public static String intToNom(int numero)

entra un número positiu < 10000: 1
u
entra un número positiu < 10000: 9
nou
entra un número positiu < 10000: 10
deu
entra un número positiu < 10000: 19
dinou
entra un número positiu < 10000: 20
vint
entra un número positiu < 10000: 21
vint-i-u
entra un número positiu < 10000: 33
trenta-tres
entra un número positiu < 10000: 333
tres-cents trenta-tres
entra un número positiu < 10000: 9333
nou mil tres-cents trenta-tres
entra un número positiu < 10000: 7123
set mil cent vint-i-tres
entra un número positiu < 10000: 7256
set mil dos-cents cinquata-sis
entra un número positiu < 10000: -1
*/
public class Metodes2_3 {
	public static void main(String[]args) {
		final short MAX_NUM=999;
		short numUser;
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("Entra un número positiu < 10.000 (per sortir entra un número negatiu): ");
			numUser=input.nextShort();
			if (numUser>MAX_NUM) {
				System.out.print("Ha de ser un núm. menor a 10.000, prova un altre cop: ");
				numUser=input.nextShort();
			}
			//String name = intToName(952);
			System.out.println(intToName(numUser));
		}while (numUser>0);
		
		System.out.println("Has sortit del programa.");
	}
	
	public static String intToName(short number) {
		//TODO revisar variables i constantes que no se usan.
		final byte UNIT_LENGTH=1, TEN_LENGTH=2, HUNDRED_LENGTH=3, THOUSAND_LENGTH=4;
		final short MOD_10=10;
		short tenNumber,unitNumber,hundredNumber, thousandNumber;
		String name="", tenName="",unitName="",hundredName="", thousandName="";
		String numberString=String.valueOf(number);
		
		short count= (short) numberString.length();
		short mod=10;
		
		while (count>0) {
			unitNumber=(short) (number%mod);
			
			if (count==String.valueOf(number).length()) {
				unitName=unit(unitNumber);
			}
			
			if (count<String.valueOf(number).length()-1) {
				tenName=ten(number);
				System.out.println(tenName);
			}
			
			if (count<String.valueOf(number).length()-2) {
				hundredNumber= (short) (Math.round(number%100));
				hundredName=unit(hundredNumber)+"cent";
				System.out.println(hundredName);
			}
			
			
			//Restar al número el resto
			number=(short) (number-number%mod);
			count--;
			mod=(short) (mod*10);
			
		}
		name=hundredName+tenName+unitName;
		return name;
		
		/*String numberString=String.valueOf(number);

		if(numberString.length()==HUNDRED_LENGTH) {
			hundredName="cent ";
			number=Integer.valueOf(numberString.substring(1)).shortValue();
			System.out.println(Integer.valueOf(numberString.substring(1)).shortValue());
		}
		
		numberString=String.valueOf(number);
		if(numberString.length()==TEN_LENGTH) {
			tenNumber= (short) (number-(number%MOD_10));
			
			//System.out.println(number-(number%MOD_10));
			tenName=twoDigits(tenNumber);
			//System.out.println(twoDigits(tenNumber));
			
			number= (short) (number%MOD_10);
		}
		
		numberString=String.valueOf(number);
		
		if (numberString.length()==UNIT_LENGTH) {
			unitName=unit(number);
			name=hundredName+tenName+" "+unitName;
		}*/
	}
	
	//Unit
	public static String unit(short number) {
		String unit="";
		switch (number) {
		case 1:
			unit="u";
			break;
			
		case 2:
			unit="dos";
			break;
		
		case 3:
			unit="tres";
			break;
			
		case 4:
			unit="quatre";
			break;
			
		case 5:
			unit="cinc";
			break;
			
		case 6:
			unit="sis";
			break;
		
		case 7:
			unit="set";
			break;
			
		case 8:
			unit="vuit";
			break;
			
		case 9:
			unit="nou";
			break;
		}
		return unit;
	}
	
	//Numbers two digits
	public static String ten(short number) {
		String num="";
		switch (number) {
		case 10:
			num="deu";
			break;
			
		case 11:
			num="onze";
			break;
			
		case 12:
			num="dotze";
			break;
			
		case 13:
			num="tretze";
			break;
			
		case 14:
			num="catorze";
			break;
			
		case 15:
			num="quinze";
			break;
			
		case 16:
			num="setze";
			break;
			
		case 17:
			num="disset";
			break;
			
		case 18:
			num="divuit";
			break;
			
		case 19:
			num="dinou";
			break;
			
		case 20:
			num="vint";
			break;
			
		case 30:
			num="trenta";
			break;
			
		case 40:
			num="quaranta";
			break;
			
		case 50:
			num="cinquanta";
			break;
			
		case 60:
			num="seixanta";
			break;
			
		case 70:
			num="setanta";
			break;
			
		case 80:
			num="vuitanta";
			break;
			
		case 90:
			num="noranta";
			break;
		}
		
		return num;
	}
	/*//Ten
	public static String ten(short number) {
		String ten="";
		switch (number) {
		case 10:
			ten="deu";
			break;
			
		case 20:
			ten="vint";
			break;
			
		case 30:
			ten="trenta";
			break;
			
		case 40:
			ten="quaranta";
			break;
			
		case 50:
			ten="cinquanta";
			break;
			
		case 60:
			ten="seixanta";
			break;
			
		case 70:
			ten="setanta";
			break;
			
		case 80:
			ten="vuitanta";
			break;
			
		case 90:
			ten="noranta";
			break;
			
		case 100:
			ten="cent";
			break;
		}
		
		return ten;
	}*/
}
