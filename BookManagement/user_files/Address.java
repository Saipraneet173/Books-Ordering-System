package user_files;
public class Address {
    int House_number;
    String postcode;
    String city;
    public Address(int House_number, String postcode, String city){
        this.House_number = House_number;
        this.city = city;
        this.postcode= postcode;
    }

    public String ToString(){
        return(this.House_number+","+this.postcode+","+this.city);
    }
}   
