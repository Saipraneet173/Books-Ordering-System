package books;

import books.audiobook.type;
import books.paperback.condition;

public class ebook extends book{
    public enum Book_format{
        EPUB, MOBI, PDF;
    }
    
    public int pages;
    public Book_format format;

    public int getPages() {
        return pages;
    }


    public void setPages(int pages) {
        this.pages = pages;
    }


    public Book_format getFormat() {
        return format;
    }


    public void setFormat(Book_format format) {
        this.format = format;
    }


    public ebook(Integer barcode, Book_type booktype,String title, Language lang, genre gen, String release_date,int quantity,double retail_price, int pages, Book_format format){
        super(barcode, booktype,title,lang,gen,release_date,quantity,retail_price);
        this.pages = pages;
        this.format = format;
    }
    public ebook(){
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
        return String.format("%-10s %-10s %-15s %-10s %-10s %-10s %-5d $%.2f %-10s %-10s", barcode, booktype, title, lang, gen, release_date, quantity, retail_price, pages, format);
    }


    @Override
    public condition getCon() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCon'");
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
