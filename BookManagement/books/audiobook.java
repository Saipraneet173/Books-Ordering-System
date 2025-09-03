package books;

import books.ebook.Book_format;
import books.paperback.condition;

public class audiobook extends book {
    public enum type{
        MP3, WMA, AAC;
    }
    
    public double hours;
    public type AbookType;

    public double getHours() {
        return hours;
    }


    public void setHours(double hours) {
        this.hours = hours;
    }


    public type getAbookType() {
        return AbookType;
    }


    public void setAbookType(type abookType) {
        AbookType = abookType;
    }


    public audiobook(Integer barcode, Book_type booktype,String title, Language lang, genre gen, String release_date,int quantity, double retail_price, double hours, type AbookType){
        super(barcode, booktype,title, lang, gen, release_date, quantity,retail_price);
        this.hours = hours;
        this.AbookType = AbookType;
    }
    public audiobook(){

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
        return String.format("%-10s %-10s %-15s %-10s %-10s %-10s %-5d $%.2f %-10f %-10s", barcode, booktype, title, lang, gen, release_date, quantity, retail_price, hours, AbookType);
    }


    @Override
    public int getPages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPages'");
    }


    @Override
    public condition getCon() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCon'");
    }


    @Override
    public Book_format getFormat() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFormat'");
    }
}
