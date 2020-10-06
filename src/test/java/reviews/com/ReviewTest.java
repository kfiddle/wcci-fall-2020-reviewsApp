package reviews.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewTest {
        Review reviewTest = new Review(1L, "myTitle", "/images/reviewer1.jpg", 2, "myContent", "willBeStarsLink", LocalDate.of(2018, 6, 27));

    @Test
    public void shouldHaveAReviewObjectDate() {
        LocalDate randomDate = LocalDate.of(2018, 6, 27);
        Assertions.assertEquals(randomDate, reviewTest.getDate());
    }

    @Test
    public void shouldHaveAReviewObjectWithTitleAndName(){
        Assertions.assertEquals(reviewTest.getTitle(), "myTitle");
        Assertions.assertEquals(reviewTest.getCategory(), 2);
    }
}
