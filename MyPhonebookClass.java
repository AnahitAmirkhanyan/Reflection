import java.util.Vector;

public class MyPhonebookClass {
   
   //declare the necessary variable, declare them static, so
   //they will be the same for any object which is created
   //my suggestion: a list (Vector) of PhoneBookEntry objects

	static Vector<PhoneBookEntry> vec = new Vector<PhoneBookEntry>();
	
	public MyPhonebookClass() {
		vec.add(new PhoneBookEntry("James Halpert", "Jim", "3261  Moonlight Drive", 37472937));
		vec.add(new PhoneBookEntry("Pamela Beesly", "Pam", "4184  Bartlett Avenue", 35753325));
		vec.add(new PhoneBookEntry("Michael Scott", "Mike", "3864  Grey Fox Farm Road", 28740340));
	}
	
   public void add(String name, String address, Integer phone, String nickname) 
   {
    //adds an entry for the phonebook
	 vec.add(new PhoneBookEntry(name, nickname, address, phone));
	 System.out.println("Entry Successfully added!");
   }

   public void add(String name, Integer phone) {
    //adds an entry without address and nickname
	   vec.add(new PhoneBookEntry(name, null, null, phone));
   }

   public void printAll(String nickname) {
     //prints on the console (with system.out.println) 
     //all available information for that nickname
	   for(PhoneBookEntry pbe:vec) {
		   if(nickname.equals(pbe.getNickname())) {
			   System.out.println("Nickname : " + pbe.getNickname());
			   System.out.println("Name : " + pbe.getName());
			   System.out.println("Address : " + pbe.getAddress());
			   System.out.println("Phone : " + pbe.getPhone());
		   }
	   }
   }

   public void changePhone(String name, Integer phone) {
      //changes the phone for that name
	   for(PhoneBookEntry pbe:vec) {
		   if(name.equals(pbe.getName())) {
			   pbe.setPhone(phone);
		   }
	   }
	   System.out.println("Phone number successfully changed to " + phone);
   }

   public void changeAddress(String name, String address){
     //changes the address for that name
	   for(PhoneBookEntry pbe:vec) {
		   if(name.equals(pbe.getName())) {
			   pbe.setAddress(address);
		   }
	   }
	   System.out.println("Address successfully changed to " + address);
   }

   public void delete(String nickname) {
     //deletes the entry (all information) for that nickname
	   for(PhoneBookEntry pbe:vec) {
		   if(nickname.equals(pbe.getNickname())) {
			   vec.remove(pbe);
		   }
	   }
	   System.out.println("Entry successfully removed!");
   }
}

class PhoneBookEntry {
   String name, nickname, address;
   Integer phone;
   
  public PhoneBookEntry(String name, String nickname, String address, Integer phone) {
	  this.name = name;
	  this.nickname = nickname;
	  this.address = address;
	  this.phone = phone;
  }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getNickname() {
	return nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public Integer getPhone() {
	return phone;
}

public void setPhone(Integer phone) {
	this.phone = phone;
}
  
  
}

  


    