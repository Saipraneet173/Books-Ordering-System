package books;

import books.audiobook.type;
import books.ebook.Book_format;

public class paperback extends book{
    public enum condition{
        NEW,USED;
    }
    
    public int pages;
    public condition con;
    

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public condition getCon() {
        return con;
    }

    public void setCon(condition con) {
        this.con = con;
    }

    public paperback(Integer barcode, Book_type booktype,String title, Language lang, genre gen, String release_date, int quantity, double retail_price, int pages, condition con){
        super(barcode,booktype,title,lang,gen,release_date,quantity,retail_price);
        this.pages = pages;
        this.con = con;

    }

    public paperback() {
    }

    @Override
    public String ValidateBarcode(Integer barcode) {
        if (barcode.toString().trim().length() == 8){
            String pattern = "^[a-zA-Z!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$";
            if (barcode.toString().contains(pattern)){
               return "invalid barcode";
            }else{
                return barcode.toString();
            }
        }else{
            return "invalid barcode";
        }

    }
    public String toString1() {
        return String.format("%-10s %-10s %-15s %-10s %-10s %-10s %-5d $%.2f %-10s %-10s", barcode, booktype, title, lang, gen, release_date, quantity, retail_price, pages, con);
    }

    @Override
    public Book_format getFormat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFormat'");
    }

    @Override
    public double getHours() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHours'");
    }

    @Override
    public type getAbookType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAbookType'");
    }

}

