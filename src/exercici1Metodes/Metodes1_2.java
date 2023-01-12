package exercici1Metodes;
//Author: Yarií Soto
/*
 2.Escriu el mètode min que retorni el mínim de tres números 
 i el mètode mijana que retorni la mitjana aritmètica de tres números. 
 
 Proporciona funcions de testeig pels mètodes anteriors. 
 Segueix el diagrama proporcionat.
 
 Signatures de les funcions:
 public static double min(double x, double y, double z)
 public static double mitjana(double x, double y, double z)
 */
public class Metodes1_2 {
	public static void main(String[]args) {
		test();
	}
	
	public static double min(double x, double y, double z) {
		double minimum=0;
		if((x<y && y<z) || (x<z && z<y)) {
			minimum=x;
		}else if((y<x && x<z) || (y<z && z<x)) {
			minimum=y;
		}else if((z<y && y<x) || (z<y && y<x)) {
			minimum=z;
		}
		return minimum;
	}

	public static double average(double x, double y, double z) {
		return (Math.round(x+y+z)/3f);
	}
	
	public static double roundDecimals(double initialValue, int decimalNums) {
		double intPart, result;
		result = initialValue;
		intPart = Math.floor(result);
		result=(result-intPart)*Math.pow(10, decimalNums);
		result=Math.round(result);
		result=(result/Math.pow(10, decimalNums))+intPart;
		return result;
	}
	
	//Testing
	public static void test() {
		//Create 3 arrays, two for the numbers and one for the expected results.
		double[] a = {4.5, -2, -2, 5.1};
        double[] b = {7.3, 5.3, -5, -2};
        double[] c = {5, 4, -5.4, 6.4};
        double[] expectedMin = {4.5,-2, -5.4, -2};
        double[] expectedAverage = {5.600000, 2.433333, -4.133333, 3,166667};
        
        //With one "for" to each method checks if the method return the expected results.
        for (int i = 0; i < a.length; i++) {
            System.out.printf("min(%f,%f,%f) -> %f %s%n",a[i], b[i],c[i],min(a[i], b[i],c[i]), min(a[i], b[i],c[i]) == expectedMin[i] ? "OK" : "NOK");
        }
        
        for (int i = 0; i < a.length; i++) {
            System.out.printf("average(%f,%f,%f) -> %f %s%n",a[i], b[i],c[i],average(a[i], b[i],c[i]), average(a[i],b[i],c[i]) == expectedAverage[i] ? "OK" : "NOK");
        }
	}
}
