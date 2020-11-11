package unifor.com.B3TCH.Services;

import unifor.com.B3TCH.Model.Scrip;
import unifor.com.B3TCH.Model.User;

import java.util.List;

public class UserService {

    private User user;

    public User getUser(){
        return this.user;
    }

    public User singUp(User user) {
        this.user = user;
        return user;
    }

    public User updateUser(String email, String password) {
        this.user.setEmail(email);
        this.user.setPassword(password);
        return this.user;
    }

    public List<Scrip> scripList() {
        return this.user.getScrips();
    }

    public Scrip getScrip(String ticker){
        return this.user.getScrip(ticker);
    }

    public List<Scrip> addScrip(Scrip scrip) {
        return this.user.addScrip(scrip);
    }

    public List<Scrip> removeScrip(String ticker){
        return this.user.removeScrip(ticker);
    }
}
