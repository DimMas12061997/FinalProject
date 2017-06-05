package by.masalsky.onlineshop.services.interfaces;


import by.masalsky.onlineshop.dto.UserProfileDto;

public interface IUserProfileService extends IService<UserProfileDto> {
    UserProfileDto getByUserId(int id);
}

