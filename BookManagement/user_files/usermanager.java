package user_files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class usermanager {
   public List<User> users; 

   public usermanager(){
    users = new ArrayList<>();
   }

   public void readuserfromcsv() throws IOException{
        // Create a new BufferedReader
        BufferedReader reader = new BufferedReader(new FileReader("data_files/UserData.txt"));
        // Create a list to store the users
      //   List<User> users = new ArrayList<>();

        // Read in the data rows
        String row;
        try {
         while ((row = reader.readLine()) != null) {
               // Parse the row data
               String[] rowData = row.split(",");
               int userId = Integer.parseInt(rowData[0].trim());
               String username = rowData[1].trim();
               String surname = rowData[2].trim();
               String address = rowData[3].trim()+","+rowData[4].trim()+","+rowData[5].trim();
               String[] addressParts = address.split(",");
               int houseNumber = Integer.parseInt(addressParts[0].trim());
               String postcode = addressParts[1].trim();
               String city = addressParts[2].trim();

               // Determine if the user is an admin or customer
               String userType = rowData[7].trim();
               User user;
               if (userType.equalsIgnoreCase("admin")) {
                   user = new Admin(userId, username, surname, new Address(houseNumber, postcode, city),Role.Admin);
               }else{
                  double creditBalance = Double.parseDouble(rowData[6].trim());
                  user = new Customer(userId, username, surname, new Address(houseNumber, postcode, city),creditBalance, Role.Customer);
               }

               // Add the user to the list
               users.add(user);
           }
   
         
      } catch (NumberFormatException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

        // Close the reader
        reader.close();
   }
   
   // public void Writingtofile1(Integer userid,String username,String name,Integer housenumber,String postcode,String city,double credit,String role){
   //    User us = new Customer(userid,username,name,new Address(housenumber, postcode, city),credit,Role.Customer);
   //    users.add(us);
   // }

   // public void Writingtofile2(Integer userid,String username,String name,Integer housenumber,String postcode,String city,String role){
   //    User us = new Admin(userid, username, name, new Address(housenumber, postcode, city),Role.Admin);
   //    users.add(us);
   // }
   public void alterlist(int useridd,double creditt){
      for(User u: users){
         if(u.getId() == useridd){
            ((Customer)u).setCredit(creditt);
         }
      }
   }
   public void Writetofile(){
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("data_files/UserData.txt", false))) {
         for (User u: users){
            if(u instanceof Customer){
               writer.write(((Customer)u).getId()+","+((Customer)u).getUser_name()+","+((Customer)u).getName()+","+((Customer)u).getAddr().ToString()+","+((Customer)u).getCredit()+","+(((Customer)u).getRole().toString()));
               writer.newLine();
            }else if(u instanceof Admin){
               writer.write(((Admin)u).getId()+","+((Admin)u).getUser_name()+","+((Admin)u).getName()+","+((Admin)u).getAddr().ToString()+","+","+(((Admin)u).getRole().toString()));
               writer.newLine();
            }else{
               System.out.println("Error: couldnt write to the file");
            }
         }
         writer.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public ArrayList<User> readfromcsvA() throws IOException {
      ArrayList<User> list = new ArrayList<User>();
      for(User u11 : users){
         if(u11.getRole().toString().equalsIgnoreCase("admin")){
            list.add(u11);
         }
      }
      return list;
   }
   public ArrayList<User> readfromcsvC() throws IOException {
      ArrayList<User> list = new ArrayList<User>();
      for(User u11 : users){
         if(u11.getRole().toString().equalsIgnoreCase("customer")){
            list.add(u11);
         }
      }
      return list;
   }

}

