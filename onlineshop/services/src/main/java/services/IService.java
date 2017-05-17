package services;


import entities.Bean;

import java.util.List;

public interface IService<T extends Bean> {
    int save(T entity);

    List<T> getAll();

    T getById(int id);

    void update(T entity);

    void delete(int id);
}
