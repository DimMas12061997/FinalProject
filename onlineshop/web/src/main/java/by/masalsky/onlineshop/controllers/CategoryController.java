package by.masalsky.onlineshop.controllers;

import by.masalsky.onlineshop.dto.CategoryDto;
import by.masalsky.onlineshop.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> list = categoryService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Integer id) {
        CategoryDto category = categoryService.getById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCategory(@PathVariable("id") Integer id) {
        CategoryDto category = categoryService.getById(id);
        if (category != null) {
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>("There is no such category", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.getByName(categoryDto.getCategoryName());
        if (category == null) {
            categoryService.save(categoryDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>("This category already exists", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateCategory(@PathVariable("id") Integer id, @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(id);
        categoryService.update(categoryDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
