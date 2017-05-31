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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeanDto beanDto = (BeanDto) o;

        return id != null ? id.equals(beanDto.id) : beanDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
