package unifor.br.springboot.Model;

public class Yield {

    private double profitTotal;
    private double profitScrip;
    private User user;

    public Yield(User user) {
        this.user = user;
    }


    public void getProfitTotal() {
        double prof = 0;
        for (Scrip scrip: user.getScrips()) {
            prof = prof + scrip.getPriceToday() - scrip.getPriceBought();
        };
        this.profitTotal = prof;
    }


    public void getProfitScrip(String ticker) {
        double prof = 0;
        prof = user.getScrip(ticker).getPriceToday() - user.getScrip(ticker).getPriceBought();
        this.profitScrip = prof;
    }
}
