package by.masalsky.onlineshop.dto;

public abstract class BeanDto {

    protected Integer id;

    public BeanDto() {
    }

    public BeanDto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
