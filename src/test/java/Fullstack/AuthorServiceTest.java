package Fullstack;

import Fullstack.DAO.AuthorDAO;
import Fullstack.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorDAO authorDAO;

    @Test
    void testAddAuthor() {
        try {
            authorService.addAuthor(new Author());
        } catch (IllegalArgumentException iae) {
            System.out.println("We should never have reached this point.");
            System.out.println("Did we somehow call the real method in stead of the mocked one?");
            fail();
        }
    }

    @Test
    void testAddAuthor2() {
        Author comparison = new Author(69, "FakeName", "FakeEmail", new Address(69, "FakeAddress", 42069));
        lenient().when(authorDAO.addAuthor(comparison)).thenReturn(comparison);
        assertThat(authorService.addAuthor(comparison)).isEqualTo(comparison);
    }

    @Test
    void testGetAuthorById() {

        Author comparison = new Author(69, "FakeName", "FakeEmail", new Address(69, "FakeAddress", 42069));
        lenient().when(authorDAO.getAuthorById(comparison.getId())).thenReturn(comparison);
        assertThat(authorService.getAuthorById(comparison.getId())).isEqualTo(comparison);
    }

    @Test
    void testGetAuthorByName() {
        Author comparison = new Author(69, "FakeName", "FakeEmail", new Address(69, "FakeAddress", 42069));
        lenient().when(authorDAO.getAuthorByName(comparison.getName())).thenReturn(comparison);
        assertThat(authorService.getAuthorByName(comparison.getName())).isEqualTo(comparison);
    }

    @Test
    void testUpdateAuthor() {
        Author comparison = new Author(69, "FakeName", "FakeEmail", new Address(69, "FakeAddress", 42069));
        lenient().when(authorDAO.updateAuthor(comparison, comparison.getId())).thenReturn(1);

        int update = authorService.updateAuthor(comparison, comparison.getId());
        assertThat(update).isEqualTo(1);
    }

    @Test
    void testGetAuthors() {
        List<Author> list = new ArrayList<>();
        Author comparison = new Author(69, "FakeName", "FakeEmail", new Address(69, "FakeAddress", 42069));
        Author comparison2 = new Author(70, "Haavlek", "Haavlek", new Address(70, "Fake", 420));
        list.add(comparison);
        list.add(comparison2);

        lenient().when(authorDAO.getAuthors()).thenReturn(list);
        assertThat(authorService.getAuthors()).contains(comparison);
        assertThat(authorService.getAuthors()).contains(comparison2);
    }

    @Test
    void testDeleteAuthor() {
        Author comparison = new Author(69, "FakeName", "FakeEmail", new Address(69, "FakeAddress", 42069));
        lenient().when(authorDAO.deleteAuthor(comparison.getId())).thenReturn(1);

        int delete = authorService.deleteAuthor(comparison.getId());
        assertThat(delete).isEqualTo(1);
    }
}
