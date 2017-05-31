package by.masalsky.onlineshop.services.interfaces;


import by.masalsky.onlineshop.dto.BeanDto;

import java.util.List;

public interface IService<T extends BeanDto> {
    int save(T entity);

    List<T> getAll();

    T getById(int id);

    void update(T entity);

    void delete(int id);
}
