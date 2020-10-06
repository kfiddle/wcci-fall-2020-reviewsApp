package reviews.com;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReviewRepositorytest {
    private Review oneReview = new Review(3L, "title", "url", 2, "content", "3", LocalDate.of(1975, 10, 5));
    private Review twoReview = new Review(2L, "title2", "url2", 1, "content2", "4", LocalDate.of(1975, 10, 6));
    private Review threeReview = new Review(4L, "title3", "url3", 2, "content4", "2", LocalDate.of(1975, 10, 7));
    private Review fourthReview = new Review(5L, "title4", "url4", 1, "content5", "5", LocalDate.of(1975, 10, 8));
    private ReviewRepository underTest = new ReviewRepository(oneReview, twoReview, threeReview, fourthReview);


    @Test
    public void shouldReturnAllReviews() {
        Collection<Review> reviewsFound = underTest.findAll();
        assertEquals(reviewsFound.size(), 4);
        assertThat(reviewsFound).contains(oneReview, twoReview, threeReview, fourthReview);
    }

    @Test
    public void shouldReturnOneReview() {
        Review firstReview = underTest.findReview(3L);
        Review secondReview = underTest.findReview(2L);
        assertEquals(firstReview, underTest.findReview(3L));
        assertEquals(secondReview, underTest.findReview(2L));
    }

    @Test
    public void shouldReturnBeerReviewsOnly() {
        Collection<Review> beersOnly = underTest.showByCategory(1);
        assertThat(beersOnly).contains(twoReview, fourthReview);
    }

    @Test
    public void shouldReturnScotchReviewsOnly(){
        Collection<Review> scotchOnly = underTest.showByCategory(2);
        assertThat(scotchOnly).contains(oneReview, threeReview);
    }

}