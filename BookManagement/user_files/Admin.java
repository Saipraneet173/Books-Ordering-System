package user_files;

import java.io.IOException;
import books.bookmanager;



public class Admin extends User {
    public Admin(Integer id,String username, String name, Address addr, Role role){
        super(id, username, name, addr, role);
    }

    public int getid(){
        return id;
    }
    public Double getCredit(){
        throw new UnsupportedOperationException("Unimplemented method 'getcredit'"); 
    }
    
    public void ViewBooks(){
        bookmanager bookManager2 = new bookmanager();
        bookManager2.readBooksFromCSV("data_files/Stock.txt");
        
    }

    public void addbook(){
        bookmanager bm1 = new bookmanager();
        try {
            bm1.readBooksFromCSV("data_files/Stock.txt");
            bm1.addBook();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void viewbooks(){
        bookmanager bm1 =  new bookmanager();
        bm1.readBooksFromCSV("data_files/Stock.txt");   
        bm1.sortBooksbyQuantity();
        bm1.displayBooks();
    } 

}


