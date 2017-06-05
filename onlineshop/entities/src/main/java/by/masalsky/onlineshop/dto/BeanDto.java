package by.masalsky.onlineshop.dto;

public abstract class BeanDto {

    protected int id;

    public BeanDto() {
    }

    public BeanDto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeanDto beanDto = (BeanDto) o;

        return id == beanDto.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
