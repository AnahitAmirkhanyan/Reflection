import java.lang.reflect.*;
import java.util.ArrayList;

public class WebServiceLike {

   public static void main(String args[]) throws InstantiationException, IllegalAccessException {
     /*this main method is invokes with the following arguments
      *args[0] the name of the class
      *args[1] the name of the method
      *the rest are for describing the arguments to use to call the method
      *args[2] is for the type and args[3] for the value of the first argument
      *in general: args[n+1] contains the type and args[n+2] the value of the nth argument
      *The program should create an object of the class received
      *(it might be any java class, MyAccountClass or MyPhonebookClass)
      *it should first create an Object of this type, apply the 
      *corresponding method and print the result on the console
      *with System.out.println. It should give a message in error cases like: 
      *1- the class does not exist 2- the method does not exist
     */
	   
 // 0				1				2				3				4				5			...
// class			method			type			value			type			value		...
// MyAccountClass	printall		int				123
	   
	   
   Object newObj = null;
   Class<?> c = null;
   int numOfP = (args.length - 2)/2; // number of parameters taken from command line
   Class<?> paramtypes[] = new Class[numOfP];
   Method method = null;
   Object methargs[] = new Object[numOfP];
   
   try {
	   c = Class.forName(args[0]);
	   newObj = c.newInstance();
   } catch(ClassNotFoundException e) {
	   System.out.println("Class does not exist!");
	   return;
   }
   
  
   try {
	   int j = 0;
	   int k = 0;
	   for(int i = 2; i < args.length; i++) {
		   if(i % 2 == 0) {
			   switch(args[i]) {

			   case "int" :
			   case "Integer": paramtypes[j] = Integer.class; j++; break;
			   case "String" : paramtypes[j] = String.class; j++; break;
			   }
		   }
		   else {
			   	if(args[i-1].equals("int") || args[i-1].equals("Integer")) {
			   		methargs[k] = Integer.parseInt(args[i]);
			   	}
			   	else methargs[k] = args[i];
		   		k++;
		   }

	   }
   
   }catch(Exception e) {
	   e.printStackTrace();
   }
   

  
   try {
	   method = c.getMethod(args[1], paramtypes);
	   method.invoke(newObj, (Object[])methargs);
   } catch(NoSuchMethodException e) { 
	   System.out.println("The Method does not exist!");
	   return;
   } catch(Exception e) {
	   e.printStackTrace();
	   return;
   }
  
   }
}


