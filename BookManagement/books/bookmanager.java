package books;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import books.audiobook.type;
import books.book.Book_type;
import books.book.Language;
import books.book.genre;
import books.ebook.Book_format;
import books.paperback.condition;

public class bookmanager {
    private List<book> books;

    public bookmanager() {
        this.books = new ArrayList<>();
    }
// This method is used to read the books from the file and stores them in a book list.
    public void readBooksFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Integer barcode = Integer.parseInt(values[0].trim());
                Book_type bookType = Book_type.valueOf(values[1].trim().toUpperCase());
                String title = values[2];
                Language language = Language.valueOf(values[3].trim().toUpperCase());
                genre Genre = genre.valueOf(values[4].trim().replaceAll("\\s", "").toUpperCase());
                String releaseDateStr = values[5];
                int quantityInStock = Integer.parseInt(values[6].trim());
                double retailPrice = Double.parseDouble(values[7].trim());
                book b = null;
                switch (bookType) {
                    case PAPERBACK:
                        int numPages = Integer.parseInt(values[8].trim());
                        condition Condition = condition.valueOf(values[9].trim().toUpperCase());
                        b = new paperback(barcode, bookType, title, language, Genre, releaseDateStr, quantityInStock,
                                retailPrice, numPages, Condition);
                        break;
                    case EBOOK:
                        int numPages2 = Integer.parseInt(values[8].trim());
                        Book_format format = Book_format.valueOf(values[9].trim().toUpperCase());
                        b = new ebook(barcode, bookType, title, language, Genre, releaseDateStr, quantityInStock,
                                retailPrice, numPages2, format);
                        break;
                    case AUDIOBOOK:
                        double length = Double.parseDouble(values[8].trim());
                        type format2 = type.valueOf(values[9].trim().toUpperCase());
                        b = new audiobook(barcode, bookType, title, language, Genre, releaseDateStr, quantityInStock,
                                retailPrice, length, format2);
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
//  This method is used to sort the books by price
    public void sortBooksByRetailPrice() {
        Collections.sort(books, Comparator.comparingDouble(book::getRetail_price));
    }
//  This method is used to sort the books by quantity 
    public void sortBooksbyQuantity() {
        Collections.sort(books, Comparator.comparingInt(book::getQuantity));
    }
//  This method is used to format and display the books.
    public void displayBooks() {
        for (book b : books) {
            switch (b.getBooktype()) {
                case PAPERBACK:
                    System.out.printf("%-12s %-12s %-10s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %n", "Barcode", "Booktype",
                            "Title", "Language", "Genre", "Release Date", "Quantity", "Price", "Pages", "Condition");
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-12s %-12s %-10s %-12s %-12s %-12s %-5d $%.2f %-12s %-12s %n", b.getBarcode(),
                            b.getBooktype(), b.getTitle(), b.getLang(), b.getGen(), b.getRelease_date(),
                            b.getQuantity(), b.getRetail_price(), b.getPages(), b.getCon());
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case EBOOK:
                    System.out.printf("%-12s %-12s %-10s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %n", "Barcode", "Booktype",
                            "Title", "Language", "Genre", "Release Date", "Quantity", "Price", "Pages", "Format");
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-12s %-12s %-10s %-12s %-12s %-12s %-5d $%.2f %-12s %-15s %n", b.getBarcode(),
                            b.getBooktype(), b.getTitle(), b.getLang(), b.getGen(), b.getRelease_date(),
                            b.getQuantity(), b.getRetail_price(), b.getPages(), b.getFormat());
                     System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case AUDIOBOOK:
                    System.out.printf("%-12s %-12s %-10s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %n", "Barcode", "Booktype",
                            "Title", "Language", "Genre", "Release Date", "Quantity", "Price", "Hours", "Type");
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-12s %-12s %-10s %-12s %-12s %-12s %-5d $%.2f %-12s %-15s %n", b.getBarcode(),
                            b.getBooktype(), b.getTitle(), b.getLang(), b.getGen(), b.getRelease_date(),
                            b.getQuantity(), b.getRetail_price(), b.getHours(), b.getAbookType());
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                default:
                    System.out.println("error5");
                    break;
            }
        }

    }

    public void displayBooks(Integer barcode) {
        System.out.println("----------------------------------------------------");
        boolean check200 = false;
        for (book b : books) {
            if (b.getBarcode().equals(barcode)) {
                switch (b.getBooktype()) {
                    case PAPERBACK:
                        System.out.printf("%-5s %-5s %-10s %-5s %-5s %-5s %-5s %-5s %-5s %-5s %n", "Barcode",
                                "Booktype", "Title", "Language", "Genre", "Release Date", "Quantity", "Price", "Pages",
                                "Condition");
                        System.out.println("-------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-5s %-5s %-10s %-5s %-5s %-5s %-5d $%.2f %-5s %-5s %n", b.getBarcode(),
                                b.getBooktype(), b.getTitle(), b.getLang(), b.getGen(), b.getRelease_date(),
                                b.getQuantity(), b.getRetail_price(), b.getPages(), b.getCon());
                        System.out.println("-------------------------------------------------------------------------------------------------------");

                    break;
                    case EBOOK:
                        System.out.printf("%-5s %-5s %-10s %-5s %-5s %-5s %-5s %-5s %-5s %-5s %n", "Barcode",
                                "Booktype", "Title", "Language", "Genre", "Release Date", "Quantity", "Price", "Pages",
                                "Format");
                        System.out.println("-------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-5s %-5s %-10s %-5s %-5s %-5s %-5d $%.2f %-5s %-15s %n", b.getBarcode(),
                                b.getBooktype(), b.getTitle(), b.getLang(), b.getGen(), b.getRelease_date(),
                                b.getQuantity(), b.getRetail_price(), b.getPages(), b.getFormat());
                        System.out.println("-------------------------------------------------------------------------------------------------------");
                    break;
                    case AUDIOBOOK:
                        System.out.printf("%-5s %-5s %-10s %-5s %-5s %-5s %-5s %-5s %-5s %-5s %n", "Barcode",
                            "Booktype", "Title", "Language", "Genre", "Release Date", "Quantity", "Price", "Hours",
                            "Type");
                        System.out.println("-------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-5s %-5s %-10s %-5s %-5s %-5s %-5d $%.2f %-5s %-15s %n", b.getBarcode(),
                            b.getBooktype(), b.getTitle(), b.getLang(), b.getGen(), b.getRelease_date(),
                            b.getQuantity(), b.getRetail_price(), b.getHours(), b.getAbookType());
                        System.out.println("-------------------------------------------------------------------------------------------------------");
                    break;
                    default:
                        System.out.println("error5");
                    break;
                }
                check200 = true;
            }
        }
        if(!check200){
            System.out.println("book not found");
        }
    }

//  This method is used to add a book to the booklist and write it to the file.
    public void addBook() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);

        // Ask the user to input the book data
        Integer barcode = 0;
        boolean check = true;
        for(book b:books){
        while (check) {
            System.out.print("Enter the barcode: ");
            barcode = scanner.nextInt();
                if (!b.getBarcode().equals(barcode)) {
                    check = false;
                } else {
                    System.out.println("Error the book already exists, please enter another barcode");
                }
            }
        }

        System.out.print("Enter the book type (Paperback, Ebook, Audiobook): ");
        String booktype = sc2.nextLine();
        Book_type booktype2 = Book_type.valueOf(booktype.toUpperCase().trim());
        System.out.print("Enter the title: ");
        String title = sc2.nextLine();
        System.out.print("Enter the language (English, French): ");
        String language = sc2.nextLine();
        Language language2 = Language.valueOf(language.toUpperCase().trim());
        System.out.print("Enter the genre (Politics, Business, Computer Science, Biography): ");
        String gen = sc2.nextLine();
        genre gen2 = genre.valueOf(gen.toUpperCase().trim().replaceAll("\\s", ""));
        System.out.print("Enter the release date (dd-mm-yyyy): ");
        String releaseDate = sc2.nextLine();
        System.out.print("Enter the quantity in stock: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter the retail price: ");
        double retailPrice = sc3.nextDouble();

        // Depending on the book type, create an object of the corresponding class
        book b2;
        if (booktype.toLowerCase().trim().equals("paperback")) {
            System.out.print("Enter the number of pages: ");
            int numPages = scanner.nextInt();
            System.out.print("Enter the condition (New or Used): ");
            String con = sc2.nextLine();
            condition con1 = condition.valueOf(con.toUpperCase());
            b2 = new paperback(barcode, booktype2, title, language2, gen2, releaseDate, quantity, retailPrice, numPages,
                    con1);
        } else if (booktype.toLowerCase().trim().equals("ebook")) {
            System.out.print("Enter the number of pages: ");
            int numPages = scanner.nextInt();
            System.out.print("Enter the format (EPUB, MOBI, or PDF): ");
            String format = sc2.nextLine();
            Book_format format2 = Book_format.valueOf(format.toUpperCase());
            b2 = new ebook(barcode, booktype2, title, language2, gen2, releaseDate, quantity, retailPrice, numPages,
                    format2);
        } else if (booktype.toLowerCase().trim().equals("audiobook")) {
            System.out.print("Enter the length (in hours): ");
            int length = scanner.nextInt();
            System.out.print("Enter the format (MP3, WMA, or AAC): ");
            String formatt = sc2.nextLine();
            type formatt2 = type.valueOf(formatt.toUpperCase());
            b2 = new audiobook(barcode, booktype2, title, language2, gen2, releaseDate, quantity, retailPrice, length,
                    formatt2);
        } else {
            System.out.println("Error: Invalid book type!");
            return;
        }

        // Add the book to the books list
        books.add(b2);

        try (// Write the updated books list to the CSV file
                BufferedWriter writer = new BufferedWriter(new FileWriter(
                        "data_files/Stock.txt"))) {
            for (book bb : books) {
                switch (bb.getBooktype()) {
                    case PAPERBACK:
                        writer.write((bb.getBarcode() + "," + bb.getBooktype().toString().toLowerCase() + ","
                                + bb.getTitle() + "," + bb.getLang().toString().toLowerCase() + ","
                                + bb.getGen().toString().toLowerCase() + "," + bb.getRelease_date() + ","
                                + bb.getQuantity() + "," + bb.getRetail_price() + "," + bb.getPages() + ","
                                + bb.getCon().toString().toLowerCase()));
                        writer.newLine();
                        break;
                    case AUDIOBOOK:
                        writer.write((bb.getBarcode().toString() + "," + bb.getBooktype().toString().toLowerCase() + ","
                                + bb.getTitle() + "," + bb.getLang().toString().toLowerCase() + ","
                                + bb.getGen().toString().toLowerCase() + "," + bb.getRelease_date() + ","
                                + bb.getQuantity() + "," + bb.getRetail_price() + "," + bb.getHours() + ","
                                + bb.getAbookType()));
                        writer.newLine();
                        break;
                    case EBOOK:
                        writer.write((bb.getBarcode().toString() + "," + bb.getBooktype().toString().toLowerCase() + ","
                                + bb.getTitle() + "," + bb.getLang().toString().toLowerCase() + ","
                                + bb.getGen().toString().toLowerCase() + "," + bb.getRelease_date() + ","
                                + bb.getQuantity() + "," + bb.getRetail_price() + "," + bb.getPages() + ","
                                + bb.getFormat()));
                        writer.newLine();
                        break;
                    default:
                        System.out.println("error 3");
                        break;
                }
            }
        }

    }
// Validating barcode
    public String ValidateBarcode(Integer barcode) {
        if (barcode.toString().trim().length() == 8) {
            String pattern = "^[a-zA-Z!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$";
            if (barcode.toString().contains(pattern)) {
                return "invalid barcode";
            } else {
                return barcode.toString();
            }
        } else {
            return "invalid barcode";
        }

    }
// Filetering books by hours length
    public void Filterbooks(double hourslength){
        for(book b:books){
            if(b.getBooktype().toString().equalsIgnoreCase("audiobook") && b.getHours() > hourslength){
                System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n", "Barcode", "Booktype", "Title", "Language", "Genre", "Release Date", "Quantity", "Price", "Hours","Type");
                System.out.println("-------------------------------------------------------------------------------------------------------");
                System.out.printf("%-10s %-5s %-15s %-10s %-10s %-10s %-5d $%.2f %-10s %-10s %n", b.getBarcode(), b.getBooktype(), b.getTitle(), b.getLang(), b.getGen(), b.getRelease_date(),b.getQuantity(), b.getRetail_price(), b.getHours(), b.getAbookType());
                System.out.println("-------------------------------------------------------------------------------------------------------");
            }
        }    

    }
// Searches for an audiobook based on hours
    public void Filterbooks2(double hourslength){
        boolean check = false;
        for(book b: books){
            if(b.getBooktype().toString().equalsIgnoreCase("audiobook") && b.getHours() == hourslength){
                System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n", "Barcode", "Booktype", "Title", "Language", "Genre", "Release Date", "Quantity", "Price", "Hours","Type");
                System.out.println("-------------------------------------------------------------------------------------------------------");
                System.out.printf("%-10s %-5s %-15s %-10s %-10s %-10s %-5d $%.2f %-10s %-15s %n", b.getBarcode(), b.getBooktype(), b.getTitle(), b.getLang(), b.getGen(), b.getRelease_date(),b.getQuantity(), b.getRetail_price(), b.getHours(), b.getAbookType());
                System.out.println("-------------------------------------------------------------------------------------------------------");
            }
            else{
                check = true;
            }
        }
        if(check){
            System.out.println("No book found");
        }
    }
}
