package by.masalsky.onlineshop.dto;

public class CategoryDto extends BeanDto {
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CategoryDto that = (CategoryDto) o;

        return categoryName != null ? categoryName.equals(that.categoryName) : that.categoryName == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }
}
