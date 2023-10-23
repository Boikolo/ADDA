package EJERCICIOS;

import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio1 {
	
	 public static record EnteroCadena(Integer a, String s) {
		 public static EnteroCadena of(Integer a, String s) {
			 return new EnteroCadena(a, s);
		 }
	 }
	 
	 public static String Ej1(Integer a, Integer b) {
		 UnaryOperator<EnteroCadena> nx = ec -> {
			 	return EnteroCadena.of(ec.a() + 3, ec.a() % 2 == 0 ? ec.a() + "*": ec.a() + "!");
		 };
		 return Stream.iterate(EnteroCadena.of(a, "a"), ec -> ec.a() < b,nx)
				 	.filter(ec -> ec.a() % 10 != 0)
				 	.map(ec -> ec.s())
				 	.collect(Collectors.joining("-"));
	 }
	 
	 public static String Ej1I(Integer a, Integer b) {
		 String rs = "";
		 EnteroCadena ec = EnteroCadena.of(a, "a");
		 while(ec.a()<b) {
			 if(ec.a()%10 != 0) {
				 rs = rs + "-" + ec.s();
			 }
			 if(ec.a()%2==0) {
				 ec = EnteroCadena.of(ec.a()+3, ec.a()+ "*");
			 }
			 else {
				 ec = EnteroCadena.of(ec.a()+3, ec.a()+ "!");
			 }
		 }
		 return rs;
	 }
	
	 public static String Ej1RF(Integer a, Integer b) {
		 return Ej1RF(a, b, EnteroCadena.of(a, "a"), "");
	 }
	
	 public static String Ej1RF(Integer a, Integer b, EnteroCadena ec, String rs) {
		 while(ec.a()<b) {
			 if(ec.a()%10 != 0) {
				 rs += "-" + ec.s();
			 }
			 if(ec.a()%2==0) {
				 return Ej1RF(a, b, EnteroCadena.of(ec.a()+3, ec.a	()+ "*"),rs);
			 }
			 else {
				 return Ej1RF(a, b, EnteroCadena.of(ec.a()+3, ec.a	()+ "!"),rs);
			 }
		 }
		 return rs;
	}
}

