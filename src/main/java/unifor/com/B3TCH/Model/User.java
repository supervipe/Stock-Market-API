package unifor.com.B3TCH.Model;

import java.util.List;

public class User {

    private String name;
    private String cpf;
    private String password;
    private String email;
    private List<Scrip> scrips;

    public User(String name, String cpf, String password, String email) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Scrip> getScrips() {
        return scrips;
    }
    public Scrip getScrip(String ticker) {
        for (Scrip scrip: scrips) {
            if(ticker.equals(scrip.getTicker())){
                return scrip;
            }
        }
        return null;
    }
    public List<Scrip> addScrip(Scrip scrip) {
        scrips.add(scrip);
        return scrips;
    }
    public List<Scrip> removeScrip(String ticker) {
        scrips.remove(getScrip(ticker));
        return scrips;
    }
}
