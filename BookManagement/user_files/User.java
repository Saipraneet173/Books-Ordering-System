package user_files;


 abstract public class User {
    public Integer id;
    public String user_name;
    public String name;
    public Address addr;
    public Role role;

    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddr() {
        return addr;
    }
    public void setAddr(Address addr) {
        this.addr = addr;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public User(Integer id, String user_name, String name, Address addr, Role role) {
        this.id = id;
        this.user_name = user_name;
        this.name = name;
        this.addr = addr;
        this.role = role;
    }
    public int getId() {
        return id;
    }

    public User(){}
    abstract void viewbooks();
    public abstract Double getCredit();
}
