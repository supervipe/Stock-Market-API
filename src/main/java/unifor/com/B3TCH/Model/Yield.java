package unifor.com.B3TCH.Model;

import javax.persistence.*;

@Table(name = "yield")
@Entity
public class Yield {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double profitTotal;
    private double profitScrip;

    public double getProfitTotal() {
        return profitTotal;
    }

    public void setProfitTotal(double profitTotal) {
        this.profitTotal = profitTotal;
    }

    public double getProfitScrip() {
        return profitScrip;
    }

    public void setProfitScrip(double profitScrip) {
        this.profitScrip = profitScrip;
    }
}
