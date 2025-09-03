package user_files;

import java.io.IOException;
import java.util.Scanner;

import books.bookmanager;

public class Customer extends User{
    public double credit;

    public Customer(Integer id, String user_name, String name, Address addr, double credit,Role role){
        super(id, user_name, name, addr,role);
        this.credit = credit;
    }
    public Customer(Integer id, String user_name, String name, Address addr,Role role){
        super(id,user_name,name,addr,role);
    }

    public Customer(){
    }

    public void setCredit(double creditt){
        this.credit = creditt;
    }

    public Double getCredit(){
        return this.credit;
    }

    public Address getaddress(){
        return this.addr;
    }

    public void viewbooks(){
       bookmanager bm1 = new bookmanager();
       bm1.readBooksFromCSV("data_files/Stock.txt");
       bm1.sortBooksByRetailPrice();
       bm1.displayBooks();
    }

   
    shoppingBasket shp1 = new shoppingBasket();
    public void addtobasket(){
        shp1.readfromcsv("data_files/Stock.txt");
        shp1.addToBasket();
    }
    public void viewBasket(){
        shp1.viewbasket();
    }
    public void clearBasket(){
        shp1.clearbasket();
    }

    
    public void checkout() throws IOException{
        Scanner sc = new Scanner(System.in);
        this.viewBasket();
        System.out.println("Are you sure you want to checkout?(yes/no)");
        String userin = sc.nextLine();
        if(userin.toLowerCase().equals("yes")){
            if(shp1.getTotal()>this.credit){
                System.out.println("Insufficient credit");
            }else{
                double remainingcredit = credit - shp1.getTotal();
                this.credit = remainingcredit;
                System.out.println("Thank you for the purchase! £"+shp1.getTotal()+" paid and your remaining credit balance is £"+remainingcredit+ ". Your delivery address is "+addr.ToString());
                shp1.Writetofile2();
            }
            
        }
    }

    public void searchbook1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Kindly enter the barcode of the book you want to search ");
        String userinput = sc.next();
        bookmanager bm = new bookmanager();
        bm.readBooksFromCSV("data_files/Stock.txt");
        bm.displayBooks(Integer.parseInt(userinput));
    }

    public void filterbooks(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the hours lenght by which you want to filter the books");
        double hourslength = sc.nextDouble();
        bookmanager b2 =new bookmanager();
        b2.readBooksFromCSV("data_files/Stock.txt");
        b2.Filterbooks(hourslength);
    }

    public void searchbook2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the hours lenght of the audiobook you want to search");
        double hourslength2 = sc.nextDouble();
        bookmanager bm2 = new bookmanager();
        bm2.readBooksFromCSV("data_files/Stock.txt");
        bm2.Filterbooks2(hourslength2);
    }

}