package by.masalsky.onlineshop.services.interfaces;


import by.masalsky.onlineshop.dto.CategoryDto;

public interface ICategoryService extends IService<CategoryDto> {
   CategoryDto getByName(String name);
}

