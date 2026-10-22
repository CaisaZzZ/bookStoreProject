package backendproject.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import backendproject.bookstore.domain.Category;
import backendproject.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test // save
    public void createNewCategory() {
        Category category = new Category();
        category.setName("TestCategory");

        categoryRepository.save(category);
        assertThat(category.getCategoryid()).isNotNull();
        assertThat(category.getName()).isEqualTo("TestCategory");
    }

    @Test // delete
    public void deleteCategory() {
        Category category = new Category();
        category.setName("TestCategory");

        Category savedCategory = categoryRepository.save(category);
        categoryRepository.delete(savedCategory);
        assertThat(categoryRepository.findById(savedCategory.getCategoryid())).isEmpty();
    }

    @Test // search
    public void findByNameShouldReturnCategory() {
        Category category = new Category();
        category.setName("TestCategory");
        categoryRepository.save(category);

        List<Category> categories = categoryRepository.findByName("TestCategory");

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("TestCategory");
    }
}
