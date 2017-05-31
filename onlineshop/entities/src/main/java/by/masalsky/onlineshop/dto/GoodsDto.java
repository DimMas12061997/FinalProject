package by.masalsky.onlineshop.dto;

public class GoodsDto extends BeanDto {
    private String name;
    private int number;
    private double unitPrice;
    private String producer;
    private String description;
    private int category;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "GoodsDto{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", unitPrice=" + unitPrice +
                ", producer='" + producer + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
