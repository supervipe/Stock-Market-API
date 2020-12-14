package unifor.com.B3TCH.Model;

public class Data {

    private String password;
    private String email;

    public Data(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}