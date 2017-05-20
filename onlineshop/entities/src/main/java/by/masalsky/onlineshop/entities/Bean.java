package by.masalsky.onlineshop.entities;

import javax.persistence.*;


@MappedSuperclass
@Access(AccessType.PROPERTY)
public abstract class Bean {

    protected Integer id;

    public Bean() {
    }

    public Bean(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bean)) return false;

        Bean entity = (Bean) o;

        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}