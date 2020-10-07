package unifor.br.springboot.Model;

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
}
