package books;

import books.audiobook.type;
import books.ebook.Book_format;
import books.paperback.condition;

abstract public class book {
    public enum Language {
        ENGLISH,FRENCH;
    }

    public enum genre{
        POLITICS, BUSINESS, COMPUTERSCIENCE, BIOGRAPHY;
    }

    public enum Book_type{
        PAPERBACK,EBOOK,AUDIOBOOK;
    }

    protected Integer barcode;
    public Book_type booktype;
    protected String title;
    protected Language lang;
    protected genre gen;
    protected int quantity;
    protected double retail_price;
    protected String release_date;
    
    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public Book_type getBooktype() {
        return booktype;
    }

    public void setBooktype(Book_type booktype) {
        this.booktype = booktype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public genre getGen() {
        return gen;
    }

    public void setGen(genre gen) {
        this.gen = gen;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(double retail_price) {
        this.retail_price = retail_price;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public book(Integer barcode , Book_type booktype,String title, Language lang, genre gen, String release_date, int quantity, double retail_price){
        this.barcode = barcode;
        this.title = title;
        this.lang = lang;
        this.gen = gen;
        this.quantity = quantity;
        this.retail_price = retail_price;
        this.release_date = release_date;
        this.booktype = booktype;
    }
    public book(){
    }
    

abstract public String ValidateBarcode(Integer barcode);
abstract public String toString1();
public abstract int getPages();
public abstract condition getCon();
public abstract Book_format getFormat();
public abstract double getHours();
public abstract type getAbookType();
}
