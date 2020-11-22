package unifor.com.B3TCH.Controller;

import org.springframework.web.bind.annotation.*;
import unifor.com.B3TCH.Model.Scrip;
import unifor.com.B3TCH.Model.User;
import unifor.com.B3TCH.Services.UserService;
import unifor.com.B3TCH.Services.YieldService;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;
    private YieldService yieldService;

    public UserController() {
    }

    @PostMapping("/sing-up")
    public User singUp(User user) {
        return this.userService.singUp(user);
    }
    @PutMapping("/update/{email}")
    public User updateUser(String email, String password) {
        return this.userService.updateUser(email,password);
    }
    @GetMapping("/scrips")
    public List<Scrip> scripList() {
        return this.userService.scripList();
    }
    @GetMapping("/scrip/{ticker}")
    public Scrip getScrip(String ticker){
        return this.userService.getScrip(ticker);
    }
    @GetMapping("/yield")
    public double getTotalProfit(){
        return this.yieldService.getTotalProfit();
    }
    @GetMapping("/yield/{ticker}")
    public double getScripProfit(String ticker){
        return this.yieldService.getScripProfit(ticker);
    }
    public List<Scrip> addScrip(Scrip scrip) {
        return this.userService.addScrip(scrip);
    }

    public List<Scrip> removeScrip(String ticker){
        return this.userService.removeScrip(ticker);
    }
}
