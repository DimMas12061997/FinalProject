package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = ("category"))
public class Category extends Bean {
    private String categoryName;

    @Column(nullable = false, name = ("category_shop"))
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
