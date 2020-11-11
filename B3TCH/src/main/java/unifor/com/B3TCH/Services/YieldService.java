package unifor.com.B3TCH.Services;

import unifor.com.B3TCH.Model.Yield;

public class YieldService {

    private Yield yield;
    private UserService userService;

    public YieldService(UserService userService){
        this.yield = new Yield(userService.getUser());
    }

    public double getTotalProfit(){
        return yield.getProfitTotal();
    }

    public double getScripProfit(String tinker){
        return yield.getProfitScrip(tinker);
    }

}
