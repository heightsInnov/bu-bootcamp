import java.util.*;

public class ContactManager {
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 

        contacts.put("Ayotola Jacobs", new Contact("Ayotola Jacobs", "+1 437 429 6582"));
        contacts.put("Daluchi Ada", new Contact("Daluchi Ada", "+1 437 429 6585"));
        contacts.put("Jane Puble", new Contact("Jane Puble", "+1 438 465 3180"));
        contacts.put("Ayobola Janet", new Contact("Ayobola Janet", "+1 437 429 6682"));
        contacts.put("Vicky Laurence", new Contact("Vicky Laurence", "+1 438 429 6582"));

        Contact existContact = contacts.get("Ayotola Jacobs");
        if(existContact == null){
            System.out.println("Contact not found.");
        }else{
            System.out.println(existContact);
        }

        Contact nonExist = contacts.get("Ada Lawrence");
        if(nonExist == null){
            System.out.println("Contact not found.");
        }else{
            System.out.println(nonExist);
        }


        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a,b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");
        for (Contact nameContact : sorted) {
            System.out.println(nameContact);
        }
        
        // Step 5: look up a contact 
 
        // Step 6: print sorted list 
    } 
}
