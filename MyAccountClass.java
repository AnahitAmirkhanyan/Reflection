import java.util.Iterator;
import java.util.Vector;

public class MyAccountClass {
   
   //declare the necessary variables static so they
   //are the same for any object of this class which is created 
   //my suggestion: a list (Vector) of Account objects
   static Vector<Account> vec = new Vector<Account>();
   
   public MyAccountClass() {
	   vec.add(new Account("Jane", 123, 10000));
	   vec.add(new Account("John", 147, 100000));
	   vec.add(new Account("Jean", 234, 300000));
   }
   public void newaccount(String name, Integer accountnumber) 
   {
    //creates a new account with balance = 0
	   Account newAcc = new Account(name, accountnumber, 0);
	   vec.add(newAcc);
	   System.out.println("Account successfully added!");
   }

   public void withdraw(Integer accountnumber, Integer sum) {
    //decreases the balance for account
	  for(Account a:vec) {
		  if(a.getNumber() == accountnumber) {
			  a.setBalance(a.getBalance()-sum);
		  }
	  }
	  
	  System.out.println("Successfully withdrawn " + sum + " from " + accountnumber);
   }

    public void deposit(Integer accountnumber, Integer sum) {
     //increases the balance for account
    	 for(Account a:vec) {
   		  if(a.getNumber() == accountnumber) {
   			  a.setBalance(a.getBalance()+sum);
   		  }
   	  }
   	  
   	  System.out.println("Successfully deposited " + sum + " into " + accountnumber);
    }

   public void printAll(Integer accountnumber) {
     //prints on the console (with system.out.println) 
     //name of owner and balanace for that account
	  for(Account a:vec) {
		  if(accountnumber == a.getNumber()) {
			  System.out.println("Name : " + a.getOwner());
			  System.out.println("Balance : " + a.getBalance());
		  }
	  }
   }

    public void printAll(String name) {
     //prints on the console (with system.out.println) 
     //account number and balanace for that person 
    	 for(Account a:vec) {
   		  if(name.equals(a.getNumber())) {
   			  System.out.println("Account Number : " + a.getNumber());
   			  System.out.println("Balance : " + a.getBalance());
   		  }
   	  }
   }


   public void delete(Integer accountnumber) {
     //deletes the entry (all information) for that account
	   for(Account a:vec) {
		   if(accountnumber == a.getNumber()) {
			   vec.remove(a);
		   }
	   }
	System.out.println("Account successfully deleted!");   
   }
}

class Account {
  Integer number, balance;
  String owner;
  public Account(String owner, Integer number, Integer balance) {
	  this.number = number;
	  this.owner = owner;
	  this.balance = balance;
  }
public Integer getNumber() {
	return number;
}
public void setNumber(Integer number) {
	this.number = number;
}
public Integer getBalance() {
	return balance;
}
public void setBalance(Integer balance) {
	this.balance = balance;
}
public String getOwner() {
	return owner;
}
public void setOwner(String owner) {
	this.owner = owner;
}

  
}

  


    