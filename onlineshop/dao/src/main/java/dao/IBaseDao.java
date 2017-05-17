package dao;

import entities.Bean;

import java.util.List;

public interface IBaseDao<T extends Bean> {
    List<T> getAll();
    int save(T entity);
    T getById(int id);
    void update(T entity);
    void delete(int id);
}
