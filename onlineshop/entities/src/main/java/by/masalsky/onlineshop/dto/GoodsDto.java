package by.masalsky.onlineshop.dto;

public class GoodsDto extends BeanDto {
    private String name;
    private int number;
    private double unitPrice;
    private String producer;
    private String description;
    private String createdDate;
    private OnlineShopDto shopId;
    private CategoryDto categoryId;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public OnlineShopDto getShopId() {
        return shopId;
    }

    public void setShopId(OnlineShopDto shopId) {
        this.shopId = shopId;
    }

    public CategoryDto getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryDto categoryId) {
        this.categoryId = categoryId;
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


}
