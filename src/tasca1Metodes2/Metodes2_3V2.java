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
public class Metodes2_3V2 {
	private static final short MAX_VALUE = 9999;
    private static short[] digits;
    private static short numUser;
    
    private static final String[][] letters = {
        {"u", "dos", "tres", "quatre", "cinc", "sis", "set", "vuit", "nou"},
        {"deu", "vint", "trenta", "quaranta", "cinquanta", "seixanta", "setanta", "vuitanta", "noranta"},
        {"cent", "dos-cents", "tres-cents", "quantre-cents", "cinc-cents", "sis-cents", "set-cents", "vuit-cents", "nou-cents"},
        {"mil", "dos-mil", "tres-mil", "quantre-mil", "cinc-mil", "sis-mil", "set-mil", "vuit-mil", "nou-mil"}
    };
 
    private static final String[][] special = {
        {"deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "disset", "divuit", "dinou"},
        {"vint", "vint i un", "vint i dos", "vint i tres", "vint \n"
        		+ "		i quatre", "vint i cinc", "vint i sis", "vint i set", "vint i vuit", "vint i nou"}
    };
    
	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		//Exit flag for the user's entry control
		boolean exit=false;
		
		//Control the user entry
		do {
			System.out.print("Entra un número positiu < 10.000 (per sortir entra un número negatiu): ");
			numUser=input.nextShort();
			
			if(numUser<0) {
				exit=true;
			}else if (numUser>MAX_VALUE){
				System.out.print("Ha de ser un núm. menor a 10.000, prova un altre cop: ");
				numUser=input.nextShort();
			}else {
				System.out.println(intToName(numUser));
			}
		}while (!exit);
		
		input.close();
		
		System.out.println("Has sortit del programa.");
	}
	
	//Method to give the name of the number.
	public static String intToName(short number) {
		//Call the method to put the number into an array.
		initializeDigits(numUser);
		
		//Build the name string.
		StringBuilder name = new StringBuilder();
        name.append(processUpToTens());
        name.append(processTens());
        return name.toString();
	}
	
	//Put the digits in the digits array.
	public static void initializeDigits(short number) {
        String numberString = Integer.toString(number);
		
		digits = new short[numberString.length()];
		byte j = 0;
		
		//If the number digit's are more than 1
        for (int i = numberString.length() - 1; i > 0; i--) {
            digits[j++] = Short.parseShort(numberString.substring(i, i+1));
        }
        
        //For the first digit, if only have one digit is this code.
        digits[j] = Short.parseShort(numberString.substring(0, 1));
	}
	
	//Method to process numbers
	public static String processUpToTens() {
		StringBuilder name = new StringBuilder();
		
        for (int i = digits.length - 1; i >= 2; i--) {

            if (0 == digits[i]) {
                continue;
            }
 
            name.append(letters[i][digits[i] - 1]);
 
            name.append(" ");
        }
 
        return name.toString();
	}
	
	//Process tens and units.
	public static String processTens() {
		if (1 == digits.length) {
            return letters[0][digits[0] - 1];
            
        } else if (digits.length >= 2) {
        	//If the number is in the first o second line return the names in special array.
            if ((1 == digits[1] || 2 == digits[1])) {
                return special[digits[1] - 1][digits[0]];
            } else {
                StringBuilder name = new StringBuilder();
 
                for (int i = 1; i >= 0; i--) {
                    if (0 == digits[i]) {
                        continue;
                    }
 
                    name.append(letters[i][digits[i] - 1]);
                    name.append("-");
 
                }
                //To quit the final hyphen (-)
                return name.substring(0, name.length()-1).toString();
            }
        }
 
        return null;
	}
}
