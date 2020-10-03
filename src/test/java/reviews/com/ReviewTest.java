package reviews.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewTest {
        Review reviewTest = new Review(1L, "myTitle", "myUrl", 2, "myContent", 5, new GregorianCalendar(2018, 6, 27));

    @Test
    public void shouldHaveAReviewObjectDate() {
        GregorianCalendar randomDate = new GregorianCalendar(2018, 6, 27);
        Assertions.assertEquals(randomDate, reviewTest.getDate());
    }

    @Test
    public void shouldHaveAReviewObjectWithTitleAndName(){
        Assertions.assertEquals(reviewTest.getTitle(), "myTitle");
        Assertions.assertEquals(reviewTest.getCategory(), 2);
    }
}
