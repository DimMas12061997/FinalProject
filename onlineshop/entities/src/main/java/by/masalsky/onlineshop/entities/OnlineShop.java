package by.masalsky.onlineshop.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = ("shop"))
public class OnlineShop extends Bean {
    private String name = "sportix";
    private double profit;
    private String description;

    public OnlineShop() {
    }

    @Column(name = ("name_shop"))
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = ("profit"), precision = 2)
    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Column(name = ("description"))
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "OnlineShop{" +
                "name='" + name + '\'' +
                ", profit=" + profit +
                ", description='" + description + '\'' +
                '}';
    }
}
