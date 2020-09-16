package br.com.curso.rest;

import java.lang.reflect.InvocationTargetException;

public class TesteMain {
   public static void main(String[] args) throws InstantiationException, IllegalAccessException,
         InvocationTargetException{
	   
	   Class myClassType = MyClass.class;
	   String nomeConstrutor = myClassType.getConstructors()[0].getName();
	   System.out.println(nomeConstrutor);
	   
	   // Tomei essa exception: java.lang.IllegalArgumentException: wrong number of arguments
	   MyClass myClass = (MyClass) myClassType.getConstructors()[0].newInstance(new Object[]{0});
	   
	   
   }
} 
