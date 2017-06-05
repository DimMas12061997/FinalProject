import by.masalsky.onlineshop.dto.CategoryDto;
import by.masalsky.onlineshop.services.interfaces.ICategoryService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration("/test-services-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceTest {
    @Autowired
    private ICategoryService categoryService;
    private CategoryDto expectedCategory;
    private CategoryDto actualCategory;
    private int categoryId;

    @Before
    public void buildEntity() throws Exception {
        expectedCategory = new CategoryDto();
        expectedCategory.setCategoryName("test");
        save();
    }

    @Test
    public void testGetByName() throws Exception {
        expectedCategory.setId(categoryId);
        actualCategory = categoryService.getByName(expectedCategory.getCategoryName());
        Assert.assertEquals("getByLogin() method failed: ", expectedCategory, actualCategory);
        delete();
    }

    @Test
    public void testSave() throws Exception {
        expectedCategory.setId(categoryId);
        actualCategory = categoryService.getById(categoryId);
        Assert.assertEquals("save() method failed: ", expectedCategory, actualCategory);
        delete();
    }


    @Test
    public void testGetAll() throws Exception {
        expectedCategory.setId(categoryId);
        List<CategoryDto> listCategoryActual = categoryService.getAll();
        List<CategoryDto> listCategoryExpected = new ArrayList<CategoryDto>();
        listCategoryExpected.add(expectedCategory);
        Assert.assertFalse("getAll() method failed", listCategoryActual.contains(listCategoryExpected));
        delete();
    }

    @Test
    public void testGetById() throws Exception {
        expectedCategory.setId(categoryId);
        actualCategory = categoryService.getById(categoryId);
        Assert.assertEquals("getById() method failed: ", expectedCategory, actualCategory);
        delete();
    }


    @Test
    public void testUpdate() throws Exception {
        expectedCategory.setId(categoryId);
        expectedCategory.setCategoryName("update");
        categoryService.update(expectedCategory);
        actualCategory = categoryService.getById(categoryId);
        System.out.println(expectedCategory);
        System.out.println(actualCategory);
        Assert.assertEquals("update() method failed: ", expectedCategory, actualCategory);
        delete();
    }

    @Test
    public void testDelete() throws Exception {
        delete();
        actualCategory = categoryService.getById(categoryId);
        Assert.assertNull("delete() method failed: ", actualCategory);
    }

    @After
    public void commitReset() throws Exception {
        expectedCategory = null;
        actualCategory = null;
        categoryId = 0;
    }

    private void save() throws Exception {
        categoryId = categoryService.save(expectedCategory);
    }

    private void delete() throws Exception {
        categoryService.delete(categoryId);
    }
}
