package unifor.br.springboot.Model;

import java.util.Date;

public class Scrip {

    private String name;
    private String ticker;
    private double priceToday;
    private double priceBought;
    private double percentageToday;
    private double percentageBought;
    private Date dateToday;
    private Date dateBought;
    private int quantity;

    public Scrip(String name, String ticker, double priceToday, double priceBought, double percentageToday, double percentageBought, Date dateToday, Date dateBought, int quantity) {
        this.name = name;
        this.ticker = ticker;
        this.priceToday = priceToday;
        this.priceBought = priceBought;
        this.percentageToday = percentageToday;
        this.percentageBought = percentageBought;
        this.dateToday = dateToday;
        this.dateBought = dateBought;
        this.quantity = quantity;
    }

    public double getPriceToday() {
        return priceToday;
    }

    public void setPriceToday(double priceToday) {
        this.priceToday = priceToday;
    }

    public double getPercentageToday() {
        return percentageToday;
    }

    public void setPercentageToday(double percentageToday) {
        this.percentageToday = percentageToday;
    }

    public Date getDateToday() {
        return dateToday;
    }

    public void setDateToday(Date dateToday) {
        this.dateToday = dateToday;
    }

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPriceBought() {
        return priceBought;
    }

    public double getPercentageBought() {
        return percentageBought;
    }

    public Date getDateBought() {
        return dateBought;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
