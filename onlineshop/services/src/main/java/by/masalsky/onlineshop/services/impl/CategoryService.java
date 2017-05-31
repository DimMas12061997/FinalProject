package by.masalsky.onlineshop.services.impl;

import by.masalsky.onlineshop.constants.ServiceConstants;
import by.masalsky.onlineshop.converters.Converter;
import by.masalsky.onlineshop.dao.interfaces.ICategoryDao;
import by.masalsky.onlineshop.dto.CategoryDto;
import by.masalsky.onlineshop.entities.Category;
import by.masalsky.onlineshop.exceptions.ServiceException;
import by.masalsky.onlineshop.services.interfaces.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryDao categoryDao;
    private final static Logger logger = LoggerFactory.getLogger(CategoryService.class);


    @Override
    public int save(CategoryDto categoryDto) {
        Category category = Converter.categoryDtoToCategory(categoryDto);
        int id = 0;
        try {
            id = categoryDao.save(category);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return id;
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categoryList = null;
        CategoryDto categoryDto = null;
        List<CategoryDto> usersDto = new ArrayList<CategoryDto>();
        if (logger.isDebugEnabled()) {
            logger.debug(ServiceConstants.TRANSACTION_DEBUG);
        }
        try {
            categoryList = categoryDao.getAll();
            for (Category category : categoryList) {
                categoryDto = Converter.categoryToCategoryDto(category);
                usersDto.add(categoryDto);
            }
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return usersDto;
    }

    @Override
    public CategoryDto getById(int id) {
        Category category = null;
        CategoryDto categoryDto = null;
        try {
            category = categoryDao.getById(id);
            if (category != null)
            categoryDto = Converter.categoryToCategoryDto(category);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return categoryDto;
    }

    @Override
    public void update(CategoryDto categoryDto) {
        Category category = Converter.categoryDtoToCategory(categoryDto);
        try {
            categoryDao.update(category);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (org.hibernate.service.spi.ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            categoryDao.delete(id);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (org.hibernate.service.spi.ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
    }

    @Override
    public CategoryDto getByName(String name) {
        Category category = null;
        CategoryDto categoryDto = null;
        try {
            category = categoryDao.getByName(name);
            if (category != null)
                categoryDto = Converter.categoryToCategoryDto(category);
            logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
        } catch (ServiceException e) {
            logger.error(ServiceConstants.TRANSACTION_FAILED, e);
        }
        return categoryDto;
    }
}
