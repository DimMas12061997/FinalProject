package by.masalsky.onlineshop.dto;

public class BlackListDto extends BeanDto {
    private int userId;

    public int getUser() {
        return userId;
    }

    public void setUser(int user) {
        this.userId = user;
    }

    @Override
    public String toString() {
        return "BlackListDto{" +
                "userId=" + userId +
                '}';
    }
}
