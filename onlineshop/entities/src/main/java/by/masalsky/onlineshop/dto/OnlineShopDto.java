package by.masalsky.onlineshop.dto;


public class OnlineShopDto extends BeanDto {
    private String name;
    private double profit;
    private String description;

    public OnlineShopDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
