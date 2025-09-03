package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import user_files.Admin;
import user_files.Customer;
import user_files.User;
import user_files.usermanager;

public class UserInterface {
    public static void main(String[] args) throws IOException {
        Scanner sc10 = new Scanner(System.in);
        Scanner sc11 = new Scanner(System.in);
        Scanner sc12 = new Scanner(System.in);
        Scanner sc13 = new Scanner(System.in);
        Scanner sc14 = new Scanner(System.in);
        System.out.println("Welome! Kindly identify yourself");
        boolean maincheck = true;
        while(maincheck){
        System.out.println("choose your option\n1.Admin\n2.Customer");
        int useroption = sc10.nextInt();
        switch (useroption) {
            case 1:
                usermanager uu = new usermanager();
                uu.readuserfromcsv();
                List<User> userss = uu.readfromcsvA();
                List<Integer> userids = new ArrayList<Integer>();
                for (User u10 : userss) {
                    System.out.println(u10.getId());
                    userids.add(u10.getId());
                }
                Admin A1 = null;
                int userid = 0;
                boolean check1 = true;
                while (check1 == true) {
                    System.out.println("Choose a userid from the above list");
                    userid = sc11.nextInt();
                    if (!userids.contains(userid)) {
                        System.out.println("error, please choose a user id from the above list");
                    } else {
                        check1 = false;
                        break;
                    }
                }
                for (User u : userss) {
                    if (userid == u.getId()) {
                        A1 = new Admin(u.getId(), u.getUser_name(), u.getName(), u.getAddr(), u.getRole());
                    }
                }
                boolean check2 = true;
                while (check2) {
                    System.out.println("Kindly choose what you want to do:\n1.Add Book\n2.View Books\n3.Exit");
                    int userchoice = sc12.nextInt();
                    switch (userchoice) {
                        case 1:
                            A1.addbook();
                            break;
                        case 2:
                            A1.viewbooks();
                            break;
                        case 3:
                            check2 = false;
                        break;
                        default:
                            System.out.println("failed");
                    }
                }
                break;
                case 2:
                    usermanager u2 = new usermanager();
                    u2.readuserfromcsv();
                    List <User> C_users = u2.readfromcsvC();
                    List <Integer> userids2 = new ArrayList<>();
                    for(User u: C_users){
                        System.out.println(u.getId());
                        userids2.add(u.getId());
                    }
                    Customer c1 = null;
                    int userid2 = 0;
                    boolean check3 = true;
                    while(check3 == true){
                        System.out.println("choose a userid from the above list(type the userid): ");
                        userid2 = sc11.nextInt();
                        if(!userids2.contains(userid2)){
                            System.out.println("Kindly choose a userid from the above list only!");
                        }else{
                            check3 = false;
                            break;
                        }
                    }
                    for(User u: C_users){
                        if(userid2 == u.getId()){
                            c1 = new Customer(u.getId(),u.getUser_name(),u.getName(),u.getAddr(),u.getCredit(),u.getRole());
                        }
                    }
                    boolean check4 = true;
                    while(check4){
                        System.out.println("What would you like to do?\n1.Viewbooks\n2.Add to basket\n3.viewbasket\n4.checkout\n5.Clear basket\n6.Searchbook\n7.Filterbooks(based on audioLength)\n8.Exit");
                        int userchoice2 = sc12.nextInt();
                        switch(userchoice2){
                            case 1:
                                c1.viewbooks();
                            break;
                            case 2:
                                c1.addtobasket();
                            break;
                            case 3:
                                c1.viewBasket();
                            break;
                            case 4:
                                c1.checkout();
                                int useridd = c1.getId();
                                double creditt = c1.getCredit();
                                u2.alterlist(useridd, creditt);
                                u2.Writetofile();
                            break;
                            case 5:
                                c1.clearBasket();
                            break;
                            case 6:
                                boolean checkk = true;
                                while(checkk){
                                    System.out.println("By what parameter do you want to search for your book?\n1.barcode\n2.audiolenght");
                                    int userdec = sc13.nextInt();
                                    switch(userdec){
                                        case 1:
                                        c1.searchbook1();
                                        checkk = false;
                                        break;
                                        case 2:
                                        c1.searchbook2();
                                        checkk = false;
                                        break;
                                        default:
                                        System.out.println("Please choose from the options provided only");
                                    }

                                }
                               
                            break;
                            case 7:
                            c1.filterbooks();
                            break;
                            case 8:
                            check4 = false;
                            break;
                            default:
                            System.out.println("Please choose from the options provided only");

                        }
                    }
            }
            System.out.println("Do you want to login as another user?\n1.yes\n2.no");
            String dec = sc14.nextLine();
            if(dec.equalsIgnoreCase("yes")){
                continue;
            }
            else{
                System.out.println("Thank you!");
                maincheck = false;
                break;
            }
        }
    }
}

