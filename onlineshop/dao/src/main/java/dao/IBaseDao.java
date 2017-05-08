package dao;

import entities.Bean;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T extends Bean> {
    List<T> getAll();
    Serializable save(T entity);
    T getById(int id);
    void update(T entity);
    void delete(int id);
}
