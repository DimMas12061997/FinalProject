package by.masalsky.onlineshop.dto;

public class BlackListDto extends BeanDto {
    private UserDto user;
    private String createdDate;


    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }


    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
