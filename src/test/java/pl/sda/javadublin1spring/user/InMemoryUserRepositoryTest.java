package pl.sda.javadublin1spring.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;


public class InMemoryUserRepositoryTest {

    private InMemoryUserRepository inMemoryUserRepository;

    @Before
    public void init() {
        this.inMemoryUserRepository = new InMemoryUserRepository(Arrays.asList(
                new User(1L, "Szymon", "Nowak", Gender.MALE),
                new User(2L, "Jan", "Kowalski", Gender.MALE),
                new User(3L, "Anna", "Wiśniewska", Gender.FEMALE),
                new User(4L, "Karolina", "Nowak", Gender.FEMALE)
        ));

    }

    @Test(expected = IllegalArgumentException.class)
    public void findById_ShouldIdThrowIllegalArgumentExceptionWhenPassingNull() {
        // given
        Long id = null;
        // when
        inMemoryUserRepository.findById(id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findById_ShouldIdThrowIllegalArgumentExceptionWhenPassingNegativeValue() {
        // given
        Long id = -5L;
        // when
        inMemoryUserRepository.findById(id);

    }

    @Test
    public void findById_ShouldReturnEmptyOptionalForNonExistingId() {
        // given instancjonujemy
        Long id = 5L;

        // when robimy akcje co chcemy sprawdzic
        Optional<User> actual = inMemoryUserRepository.findById(id);

        // then asercje (aserty)
        Assert.assertFalse("Optional is not empty. User not found", actual.isPresent());

    }

    @Test
    public void findById_ShouldReturnOptionalWithExpectedUserForGivenId() {
        // given instancjonujemy
        Long id = 3L;
        User expectedUser = new User(3L, "Anna", "Wiśniewska", Gender.FEMALE);

        // when robimy akcje co chcemy sprawdzic
        Optional<User> actual = inMemoryUserRepository.findById(id);

        // then asercje (aserty)
        Assert.assertTrue("Optional was empty. User not fonud", actual.isPresent());
        Assert.assertEquals("Found user is not the correct one", expectedUser, actual.get());


    }
}