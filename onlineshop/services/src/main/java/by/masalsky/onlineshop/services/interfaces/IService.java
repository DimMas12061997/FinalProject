package by.masalsky.onlineshop.services.interfaces;


import by.masalsky.onlineshop.entities.Bean;

import java.util.List;

public interface IService<T extends Bean> {
    int save(T entity);

    List<T> getAll();

    T getById(int id);

    void update(T entity);

    void delete(int id);
}
