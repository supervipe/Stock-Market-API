package unifor.com.B3TCH.Services;

import unifor.com.B3TCH.Model.Scrip;

import java.util.Date;

public class ScripService {

    private Scrip scrip;
    private UserService userService;

    public ScripService(UserService userService){
        this.userService = userService;
    }

    public Scrip updateScrip(String ticker,double priceToday, double percentageToday, Date dateToday,int quantity){
        this.scrip = this.userService.getScrip(ticker);
        this.scrip.setPriceToday(priceToday);
        this.scrip.setPercentageToday(percentageToday);
        this.scrip.setDateToday(dateToday);
        this.scrip.setQuantity(quantity);
        return this.scrip;
    }


}
