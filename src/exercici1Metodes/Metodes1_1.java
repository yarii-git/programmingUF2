package exercici1Metodes;
//Author: Yarií Soto

public class Metodes1_1 {
	//Principal method, call the test method.
	public static void main(String[]args) {
		testRankAdd();
	}
	
	//Method sumaRang, renamed rankAdd. 
	public static int rankAdd(int limit1, int limit2) {
		//Escriu un mètode sumaRang que calculi la suma dels nombres enters entre n i m amb n i m inclosos.
		int add=0;
		int min=Math.min(limit1,limit2);
		int max=Math.max(limit1,limit2);
		
		//Check if the numbers are equal or not, if true it returns limit1+limit2, otherwise it adds all the numbers between the minimum and the maximum. 
		if(limit1==limit2) {
			return limit1+limit2;
		}else {
		 for (int i = min; i <= max; i++) {
                add += i;
            }
		}
		return add;
	}
	
	//Testing
	public static void testRankAdd() {
		//Create 3 arrays, two for the numbers and one for the expected results.
		int[] a = {4, -2, -2, -5, 7, 5};
        int[] b = {7, 5, -5, -2, 7, 2};
        int[] expected = {22, 12, -14, -14, 14, 14};
        
        //With one "for" checks if the method return the expected results.
        for (int i = 0; i < a.length; i++) {
            System.out.printf("rankAdd(%d,%d) -> %d %s\n",a[i], b[i], rankAdd(a[i], b[i]), rankAdd(a[i],b[i]) == expected[i] ? "OK" : "NOK");
        }
	}
}
