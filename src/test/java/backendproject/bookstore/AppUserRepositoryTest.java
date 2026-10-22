package backendproject.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import backendproject.bookstore.domain.AppUser;
import backendproject.bookstore.domain.AppUserRepository;

@DataJpaTest
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Test // save
    public void createNewUser() {
        AppUser user = new AppUser("testuser", "testpassword", "testemail", "testrole");

        appUserRepository.save(user);

        assertThat(user.getId()).isNotNull();
        assertThat(user.getUsername()).isEqualTo("testuser");
    }

    @Test // delete
    public void deleteAppUser() {
        AppUser user = new AppUser("testuser", "testpassword", "testemail", "testrole");
        appUserRepository.save(user);
        appUserRepository.delete(user);

        assertThat(appUserRepository.findById(user.getId())).isEmpty();
    }

    @Test // search
    public void findByUsernameShouldReturnAppUser() {
        AppUser user = new AppUser("TestUser","testpassword","test@example.com","USER");

        appUserRepository.save(user);

        AppUser foundUser = appUserRepository.findByUsername("TestUser");

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo("TestUser");
    }
}