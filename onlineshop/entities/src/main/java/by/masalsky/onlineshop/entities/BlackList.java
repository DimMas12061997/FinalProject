package by.masalsky.onlineshop.entities;

import javax.persistence.*;

@Entity
@Table(name = ("black_list"))
public class BlackList extends Bean {
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "user=" + user +
                '}';
    }
}
