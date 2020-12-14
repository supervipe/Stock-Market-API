package unifor.com.B3TCH.Model;

import javax.persistence.*;

@Table(name = "scrip")
@Entity
public class Scrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String ticker;
    private double priceToday;
    private double priceBought;
    private double percentageToday;
    private double percentageBought;
    private String dateToday;
    private String dateBought;
    private int quantity;

    @ManyToOne
    private User user;

    public Scrip(String name, String ticker, double priceToday, double priceBought, double percentageToday, double percentageBought, String dateToday, String dateBought, int quantity) {
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

    public Scrip(){

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

    public String getDateToday() {
        return dateToday;
    }

    public void setDateToday(String dateToday) {
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

    public String getDateBought() {
        return dateBought;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }
}
