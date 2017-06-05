package by.masalsky.onlineshop.entities;

import javax.persistence.*;


@MappedSuperclass
@Access(AccessType.PROPERTY)
public abstract class Bean {

    protected int id;

    public Bean() {
    }

    public Bean(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

        Bean bean = (Bean) o;

        return id == bean.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
