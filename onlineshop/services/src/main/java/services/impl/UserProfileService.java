package services.impl;

import entities.UserProfile;
import services.AbstractService;
import services.IUserProfileService;

import java.io.Serializable;
import java.util.List;

public class UserProfileService extends AbstractService<UserProfile> implements IUserProfileService {

    public Serializable save(UserProfile entity) {
        return null;
    }

    public List<UserProfile> getAll() {
        return null;
    }

    public UserProfile getById(int id) {
        return null;
    }

    public void update(UserProfile entity) {

    }

    public void delete(int id) {

    }
}
