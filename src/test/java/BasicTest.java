import api.dto.response.books.BookResponseDTO;
import api.exceptions.BookNotFoundException;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import api.service.BookService;
import api.steps.BookSteps;
import api.steps.UserSteps;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("This is general epic")
public class BasicTest {

    @BeforeMethod(groups = {"Regression", "Smoke", "Api"})
    void clearAllBooks() {
        new BookSteps().deleteBook();
    }

    @Test(description = "Get user with book or not", groups = {"Regression", "Api"})
    @Story("[1232-xml] As a user I want to get my own book user")
    @Link(name = "[1234-xml]", url = "https://google.com")
    @Issue("AUTH-123")
    void shouldBeUserReturned() {
        var user = new UserSteps().getUser();
        assertThat(user.getUsername()).as("Username is not correct").isEqualTo("user15");
    }

    @Test(dataProvider = "Books", groups = {"Smoke", "Api"})
    @Flaky
    void shouldBeAddedOneBookIntoUser(String booksTitle) {
        var isbn = new BookService().getIsbnOfBook(booksTitle);

        new BookSteps().addBookIntoUser(isbn);

        var user = new UserSteps().getUser();

        var bookTitle = user.getBooks().stream().map(BookResponseDTO::getTitle).filter(title -> title.equals(booksTitle))
                        .findFirst().orElseThrow(() -> new BookNotFoundException(format("Book - %s is not found", booksTitle)));

        assertThat(bookTitle).as("Title is not correct").isEqualTo(booksTitle);
    }

//    @Test(dataProvider = "WrongBooks", groups = {"Smoke", "Api"})
//    void shouldBeValidatedBookTitle(String s1, Integer s2) {
//        var empty = new BookService().checkIsbnBook(s1);
//        System.out.println(s2);
//        assertThat(empty).isEqualTo(true);
//    }
//
//    @DataProvider(name = "WrongBooks")
//    public Object[][] getWrongBooks() {
//        return new Object[][] {
//                {"", 343},
//                {"---", 111},
//                {"123", 145}
//        };
//    }

    @DataProvider(name = "Books")
    public Object[][] getBooks() {
        return new Object[][] {
                {"You Don't Know JS"},
                {"Learning JavaScript Design Patterns"},
                {"Git Pocket Guide"}
        };
    }
}
