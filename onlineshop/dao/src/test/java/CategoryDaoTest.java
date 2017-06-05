import by.masalsky.onlineshop.dao.impl.CategoryDao;
import by.masalsky.onlineshop.entities.Category;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-dao-context.xml")
@Transactional(transactionManager = "transactionManager")
public class CategoryDaoTest {
    @Autowired
    private CategoryDao categoryDao;
    private Category expectedCategory;
    private Category actualCategory;
    private int categoryId;

    @Before
    public void buildEntity() throws Exception {
        expectedCategory = new Category();
        expectedCategory.setCategoryName("test");
        save();
    }

    @Test
    public void testGetByName() throws Exception {
        expectedCategory.setId(categoryId);
        actualCategory = categoryDao.getByName(expectedCategory.getCategoryName());
        Assert.assertEquals("getByLogin() method failed: ", expectedCategory, actualCategory);
        delete();
    }

    @Test
    public void testSave() throws Exception {
        actualCategory = categoryDao.getById(categoryId);
        Assert.assertEquals("save() method failed: ", expectedCategory, actualCategory);
        expectedCategory.setId(categoryId);
        delete();
    }


    @Test
    public void testGetAll() throws Exception {
        expectedCategory.setId(categoryId);
        List<Category> listCategoryActual = categoryDao.getAll();
        List<Category> listCategoryExpected = new ArrayList<>();
        listCategoryExpected.add(expectedCategory);
        Assert.assertFalse("getAll() method failed", listCategoryActual.contains(listCategoryExpected));
        delete();
    }

    @Test
    public void testGetById() throws Exception {
        expectedCategory.setId(categoryId);
        actualCategory = categoryDao.getById(categoryId);
        Assert.assertEquals("getById() method failed: ", expectedCategory, actualCategory);
        delete();
    }


    @Test
    public void testUpdate() throws Exception {
        expectedCategory.setId(categoryId);
        expectedCategory.setCategoryName("update");
        categoryDao.update(expectedCategory);
        actualCategory = categoryDao.getById(categoryId);
        Assert.assertEquals("update() method failed: ", expectedCategory, actualCategory);
        delete();
    }

    @Test
    public void testDelete() throws Exception {
        delete();
        actualCategory = categoryDao.getById(categoryId);
        Assert.assertNull("delete() method failed: ", actualCategory);
    }

    @After
    public void commitReset() throws Exception{
        expectedCategory = null;
        actualCategory = null;
        categoryId = 0;
    }

    private void save() throws Exception {
        categoryId = categoryDao.save(expectedCategory);
    }

    private void delete() throws Exception {
        categoryDao.delete(categoryId);
    }
}
