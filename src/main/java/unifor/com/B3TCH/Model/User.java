package unifor.com.B3TCH.Model;

import javax.persistence.*;
import java.util.List;

@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private long cpf;
    private String password;
    private String email;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Scrip> scrips;
    @OneToOne(cascade = CascadeType.ALL)
    private Yield yield;

    public User(String name, long cpf, String password, String email) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
    }

    public User(){

    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setYield(Yield yield) {
        this.yield = yield;
    }

    public long getCpf() {
        return cpf;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
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
        scrip.setUser(this);
        return scrips;
    }
    public List<Scrip> removeScrip(String ticker) {
        Scrip s = getScrip(ticker);
        scrips.remove(getScrip(ticker));

        return scrips;
    }

    public double updateProfitTotal() {
        double prof = 0;
        for (Scrip scrip: getScrips()) {
            prof = prof + scrip.getPriceToday() - scrip.getPriceBought();
        }
        yield.setProfitTotal(prof);
        return yield.getProfitTotal();
    }


    public double updateProfitScrip(String ticker) {
        double prof = 0;
        prof = getScrip(ticker).getPriceToday() - getScrip(ticker).getPriceBought();
        yield.setProfitScrip(prof);
        return yield.getProfitScrip();
    }

    public Yield getYield() {
        return yield;
    }
}
