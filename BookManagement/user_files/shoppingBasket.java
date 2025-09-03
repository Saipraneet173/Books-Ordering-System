package user_files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import books.audiobook;
import books.book;
import books.ebook;
import books.paperback;
import books.audiobook.type;
import books.book.Book_type;
import books.book.Language;
import books.book.genre;
import books.ebook.Book_format;
import books.paperback.condition;

public class shoppingBasket {
    private List <book> basket;
    private List <book> books;
    public double total = 0;


    public shoppingBasket(){
        this.basket = new ArrayList<>();
        this.total = 0;
        this.books = new ArrayList<>();
    }

    public double getTotal(){
        return total;
    }

    public void setTotal(double total){
        this.total = total;
    }
    public void readfromcsv(String filename){
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Integer barcode = Integer.parseInt(values[0].trim());
                Book_type bookType = Book_type.valueOf(values[1].trim().toUpperCase());
                String title = values[2];
                Language language = Language.valueOf(values[3].trim().toUpperCase());
                genre Genre = genre.valueOf(values[4].trim().replaceAll("\\s","").toUpperCase());
                String releaseDateStr = values[5];
                int quantityInStock = Integer.parseInt(values[6].trim());
                double retailPrice = Double.parseDouble(values[7].trim());
                book b = null;
                switch (bookType) {
                    case PAPERBACK:
                        int numPages = Integer.parseInt(values[8].trim());
                        condition Condition = condition.valueOf(values[9].trim().toUpperCase());
                        b = new paperback(barcode, bookType, title, language, Genre, releaseDateStr, quantityInStock, retailPrice, numPages, Condition);
                        break;
                    case EBOOK:
                        int numPages2 = Integer.parseInt(values[8].trim());
                        Book_format format = Book_format.valueOf(values[9].trim().toUpperCase());
                        b = new ebook(barcode, bookType, title, language, Genre, releaseDateStr, quantityInStock, retailPrice, numPages2, format);
                        break;
                    case AUDIOBOOK:
                        double length = Double.parseDouble(values[8].trim());
                        type format2 = type.valueOf(values[9].trim().toUpperCase());
                        b = new audiobook(barcode,bookType, title, language, Genre, releaseDateStr, quantityInStock, retailPrice, length, format2);
                        break;
                    default:
                        System.out.println("error");
                }
                if (b != null) {
                    books.add(b);
                }
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addToBasket(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        String userdec = "yes";
        while(userdec.equals("yes")){
        System.out.println("Enter the barcode of the book: ");
        String barcode = sc.next();
        boolean check = false;
        book c =null;
        for(book b: books){
            if(b.getBarcode().toString().trim().equals(barcode.toString().trim())){
                check = true;
                System.out.println(b.toString1());
                System.out.println("Add this item to the basket?(yes/no)");
                String userin = sc1.nextLine().trim().toLowerCase();
                if (userin.equals("yes")){
                    System.out.println("How many copies of the book do you want to buy?");
                    int copies = sc3.nextInt();
                    if(b.getQuantity() == 0){
                        System.out.println("Out of stock");
                    }else if(b.getQuantity()<copies){
                        System.out.println("Only "+b.getQuantity()+" copies of the book are available");
                    }
                    else{
                        int quantity = b.getQuantity() - copies;
                        switch(b.getBooktype()){
                            case PAPERBACK:
                                c = new paperback(b.getBarcode(),b.getBooktype(),b.getTitle(),b.getLang(),b.getGen(),b.getRelease_date(),copies,b.getRetail_price(),b.getPages(),b.getCon());
                            break;
                            case AUDIOBOOK:
                                c = new audiobook(b.getBarcode(),b.getBooktype(),b.getTitle(),b.getLang(),b.getGen(),b.getRelease_date(),copies,b.getRetail_price(),b.getHours(),b.getAbookType());
                            break;
                            case EBOOK:
                                c = new ebook(b.getBarcode(),b.getBooktype(),b.getTitle(),b.getLang(),b.getGen(),b.getRelease_date(),copies,b.getRetail_price(),b.getPages(),b.getFormat());
                            break;
                            default:
                            System.out.println("erorrr2");
                        }
                        b.setQuantity(quantity);
                        basket.add(c);
                        total += (b.getRetail_price())*copies;
                        System.out.println("book added successfully");
                        break;
                    }
                }else{
                    break;
                }
            }else{
                continue;
                
            }
            
        }
        if(check == false){
            System.out.println("book not found");
        }
        System.out.println("add another book?(yes/no)");
        userdec = sc2.nextLine().toLowerCase().trim();
        }
       
    }

    public void viewbasket(){
        if(basket.isEmpty()){
            System.out.println("Basket empty");
        }
        for(book b: basket){
            switch (b.getBooktype()){
                case PAPERBACK:
                System.out.printf("%-10s %-10s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n", "Barcode", "Booktype", "Title", "Language", "Genre", "Release Date", "Quantity", "Price", "Pages", "Condition");
                System.out.println("-------------------------------------------------------------------------------------------------------");
                System.out.printf("%-10s %-10s %-15s %-10s %-10s %-10s %-5d $%.2f %-10s %-10s %n", b.getBarcode(), b.getBooktype(), b.getTitle(), b.getLang(), b.getGen(),b.getRelease_date() , b.getQuantity(), b.getRetail_price(), b.getPages(), b.getCon());
                System.out.println("-------------------------------------------------------------------------------------------------------");
                break;
                case EBOOK:
                System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n", "Barcode", "Booktype", "Title", "Language", "Genre", "Release Date", "Quantity", "Price", "Pages", "Format");
                System.out.println("-------------------------------------------------------------------------------------------------------");
                System.out.printf("%-10s %-10s %-15s %-10s %-10s %-10s %-5d $%.2f %-10s %-10s %n", b.getBarcode(), b.getBooktype(), b.getTitle(), b.getLang(), b.getGen(),b.getRelease_date() , b.getQuantity(), b.getRetail_price(), b.getPages(), b.getFormat());
                System.out.println("-------------------------------------------------------------------------------------------------------");
                break;
                case AUDIOBOOK:
                System.out.printf("%-10s %-10s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n", "Barcode", "Booktype", "Title", "Language", "Genre", "Release Date", "Quantity", "Price", "Hours", "Type");
                System.out.println("-------------------------------------------------------------------------------------------------------");
                System.out.printf("%-10s %-10s %-15s %-10s %-10s %-10s %-5d $%.2f %-10s %-10s %n", b.getBarcode(), b.getBooktype(), b.getTitle(), b.getLang(), b.getGen(),b.getRelease_date() , b.getQuantity(), b.getRetail_price(), b.getHours(), b.getAbookType());
                System.out.println("-------------------------------------------------------------------------------------------------------");
                break;
                default:
                System.out.println("basket empty");
                break;
            }
        }
        System.out.println("The total amount is: " + "$"+total);
    }

    public void clearbasket(){
        basket.clear();
        total = 0;
        System.out.println("Basket has been cleared");
        this.readfromcsv("data_files/Stock.txt");
    }
    
    public void Writetofile2()throws IOException {
        BufferedWriter bfr = new BufferedWriter(new FileWriter("data_files/Stock.txt", false));
        for(book b1: books){
            switch(b1.getBooktype()){
                case PAPERBACK:
                    bfr.write(b1.getBarcode() + "," + b1.getBooktype().toString().toLowerCase() + ","
                    + b1.getTitle() + "," + b1.getLang().toString().toLowerCase() + ","
                    + b1.getGen().toString().toLowerCase() + "," + b1.getRelease_date() + ","
                    + b1.getQuantity() + "," + b1.getRetail_price() + "," + b1.getPages() + ","
                    + b1.getCon().toString().toLowerCase());
                bfr.newLine();
                break;
                case AUDIOBOOK:
                    bfr.write((b1.getBarcode().toString() + "," + b1.getBooktype().toString().toLowerCase() + ","
                    + b1.getTitle() + "," + b1.getLang().toString().toLowerCase() + ","
                    + b1.getGen().toString().toLowerCase() + "," + b1.getRelease_date() + ","
                    + b1.getQuantity() + "," + b1.getRetail_price() + "," + b1.getHours() + ","
                    + b1.getAbookType()));
                bfr.newLine();
                break;
                case EBOOK:
                    bfr.write((b1.getBarcode().toString() + "," + b1.getBooktype().toString().toLowerCase() + ","
                    + b1.getTitle() + "," + b1.getLang().toString().toLowerCase() + ","
                    + b1.getGen().toString().toLowerCase() + "," + b1.getRelease_date() + ","
                    + b1.getQuantity() + "," + b1.getRetail_price() + "," + b1.getPages() + ","
                    + b1.getFormat())); 
                bfr.newLine();
                break;
                default:
                System.out.println("errorrrr");  
            }
        }
        bfr.close();
    }
}
