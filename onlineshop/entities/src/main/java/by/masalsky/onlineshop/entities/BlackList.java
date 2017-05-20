package by.masalsky.onlineshop.entities;

import javax.persistence.*;

@Entity
@Table(name = ("black_list"))
public class BlackList extends Bean {
    private User user;
    private String createdDate;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", name = ("created_date"))
    @Column(name = ("created_date"))
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
