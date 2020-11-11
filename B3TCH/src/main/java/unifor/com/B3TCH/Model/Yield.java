package unifor.com.B3TCH.Model;

public class Yield {

    private double profitTotal;
    private double profitScrip;
    private User user;

    public Yield(User user) {
        this.user = user;
    }


    public double getProfitTotal() {
        double prof = 0;
        for (Scrip scrip: user.getScrips()) {
            prof = prof + scrip.getPriceToday() - scrip.getPriceBought();
        };
        this.profitTotal = prof;
        return this.profitTotal;
    }


    public double getProfitScrip(String ticker) {
        double prof = 0;
        prof = user.getScrip(ticker).getPriceToday() - user.getScrip(ticker).getPriceBought();
        this.profitScrip = prof;
        return this.profitScrip;
    }
}
