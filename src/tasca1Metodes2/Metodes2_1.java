package tasca1Metodes2;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

//Author: Yarií Soto
//Date: 27/12/2022
/*
1.La majoria de la gent és capaç de llegir un text les paraules del qual se’ls hi ha intercanviat dues lletres 
sempre i quan la primera i la última lletra de cada paraula segueixin essent les mateixes. 

Per exemple, "Sxgueiees poednt lliger aquset txet."

Escriu el mètode barrejarParaula que genera una versió de la paraula entrada amb dues lletres intercanviades, 
aleatòriament, diferents de la primera i la última.

A continuació escriu la funció barrejarFrase que demana una frase i la mostra amb les paraules barrejades.  

Exemple "hola que tal" - "tal hola que"

Finalment fes que el main, utilitzant els mètodes anteriors, permeti a l’usuari introduir una frase i la mostri "barrejada", 
barrejant primer les paraules i finalment la frase.

Signatures de les funcions
public static String barrejarParaula(String paraula)
public static String barrejarFrase(String frase)
*/
public class Metodes2_1 {
	public static void main(String[]args) {
		String sentence;
		Scanner input = new Scanner(System.in);
		System.out.println("Aquest programa demana una frase i barreja les lletres del mig de cada paraula i les paraules de la frase.");
		System.out.print("Entra una frase per barrejar: ");
		sentence=input.nextLine();
        input.close();
        
        System.out.println(mixSentence(sentence));
	}
	
	public static String mixWord(String word) {
		char [] letters=word.toCharArray();
		//StringBuilder finalWord = new StringBuilder();
		
		//Control that the numbers are different (for different positions).
		byte num,num1;
		Random randomNumGenerator = new Random();
		
		//Control that the numbers are different (for different positions).
		num = (byte) (randomNumGenerator.nextInt(word.length()-2)+1);
		do {
			num1 = (byte) (randomNumGenerator.nextInt(word.length()-2)+1);
		}while(num==num1);
		
		//Change the position of two letters
		for (short i=1;i<word.length()-1;i++) {
			if (i==num) {
				char aux=letters[i];
				letters[i]=letters[num1];
				letters[num1]=aux;
			}
		}
		
		//Return the final word
		return Arrays.toString(letters);
	}

	public static String mixSentence(String sentence) {
		StringBuilder finalSentence = new StringBuilder();
		
		Random randomNumGenerator = new Random();
        String[] words=sentence.split(" ");
        String finalSentenceArray[]=new String[words.length];
        byte randomNums[]=new byte[words.length];
        
        //Fill the array with 
        for (short i=0;i<words.length;i++) {
			if(words[i].length()>3){
				words[i]=mixWord(words[i]);
			}
		}
		
		//TODO Mix the words
		
		/*for (short i=0;i<words.length;i++) {
			byte posRandom=(byte) randomNumGenerator.nextInt(words.length);
			
			String temp=words[i];
			words[i]=words[posRandom];
			words[posRandom]=temp;
		}*/
        
		byte count=0;
		while(count<words.length) {
			byte posRandom=(byte) randomNumGenerator.nextInt(words.length);
			
			/*if(binarySearch(randomNums, posRandom)) {
				
			}*/
		}
		
		//Build the final sentence
		for (String element: words) {
			finalSentence.append(element+" ");
		}
		System.out.println("frase "+finalSentence);
		
        return finalSentence.toString();
	}
}
