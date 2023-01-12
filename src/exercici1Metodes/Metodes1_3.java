package exercici1Metodes;
//Author: Yarií Soto
/*
3.Escriu el mètode totsIguals que indica si tres números són iguals o no, 
el mètode totsDiferents que indica si tres números són tots diferents i 
el mètode estanOrdenats que indica tres números estan ordenats de menor a major. 
Proporciona funcions de testeig pels mètodes anteriors. Segueix el diagrama proporcionat.

Signatures de les funcions

public static boolean totsIguals(double x, double y, double z)
public static boolean totsDiferents(double x, double y, double z)
public static boolean estanOrdenats(double x, double y, double z)
*/
public class Metodes1_3 {
	public static void main(String[]args) {
		test();
	}
	public static boolean equals(double x, double y, double z) {
		return x==y && y==z ? true : false;
	}
	public static boolean differents(double x, double y, double z) {
		return (x<y&&y<z) ? false:true;
	}
	public static boolean inOrder(double x, double y, double z) {
		return (x<y&&y<z) ? true:false;
	}
	
	//Testing
	public static void test() {
		//Create 3 arrays, two for the numbers and one for the expected results.
		int[] x = {2,4,2,3};
        int[] y = {2,3,4,6};
        int[] z = {2,2,6,2};
        boolean[] expectedEquals = {true,false,false,false};
        boolean[] expectedDifferents = {false,true,false,true};
        boolean[] expectedInOrder = {false,false,true,false};
        
        //With one "for" checks if the method return the expected results.
        for (int i = 0; i < x.length; i++) {
            System.out.printf("min(%f,%f,%f) -> %f %s%n",x[i],y[i],z[i],equals(x[i],y[i],z[i]), equals(x[i],y[i],z[i]) == expectedEquals[i] ? "OK" : "NOK");
        }
        
        for (int i = 0; i < x.length; i++) {
            System.out.printf("min(%f,%f,%f) -> %f %s%n",x[i],y[i],z[i],differents(x[i],y[i],z[i]), differents(x[i],y[i],z[i]) == expectedDifferents[i] ? "OK" : "NOK");
        }
        
        for (int i = 0; i < x.length; i++) {
            System.out.printf("min(%f,%f,%f) -> %f %s%n",x[i],y[i],z[i],inOrder(x[i],y[i],z[i]), inOrder(x[i],y[i],z[i]) == expectedInOrder[i] ? "OK" : "NOK");
        }
	}
}
