package EJERCICIOS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio2 {
	
	public static List<Integer> Ej2RNoF(Integer a, Integer b) {
		List<Integer> ls = new ArrayList<Integer>();
		if(a<2 || b<2) {
			ls.add(a*b);
		}
		else if(a>b) {
			ls = Ej2RNoF(a%b, b-1);
			ls.add(a);
		}
		else {
			ls = Ej2RNoF(a-2, b/2);
			ls.add(b);
		}
		return ls;
	 }
	
	 public static List<Integer> Ej2RF(Integer a, Integer b) {
		 return Ej2RF(a, b, new ArrayList<Integer>());
	 }
	
	 public static List<Integer> Ej2RF(Integer a, Integer b, List<Integer> ls) {
		 if(a<2 || b<2) {
			 ls.add(a*b);
		 }
		 else if(a>b) {
			 ls = Ej2RF(a%b, b-1, ls);
			 ls.add(a);
		 }
		 else {
			 ls = Ej2RF(a-2, b/2, ls);
			 ls.add(b);
		 	}
		 return ls;
	 }
	 
	 public static List<Integer> Ej2I(Integer a, Integer b) {
		 List<Integer> ls = new ArrayList<Integer>();
		 	while(a>=2 && b>=2) {
		 		if (a > b) {
		 			ls.add(a);
		 			a= a%b; //a=21 // a = 8 // a=1
		 			b=b-1; //b= 23 //10 // 4
		 		} else {
		 			ls.add(b);
		 			a=a-2; //19 // 6 // -1
		 			b=b/2; // 11 // 5 // 2
		 		}
		 	}
		 	if(a<2 || b<2) {
		 		ls.add(a*b);
		 	}
		 	Collections.sort(ls);
		 	return ls;
	 	}
}
