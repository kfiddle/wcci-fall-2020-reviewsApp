package reviews.com;


import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReviewRepositorytest {
    private Review oneReview = new Review(3L, "title", "url", 2, "content", 3, new GregorianCalendar(1975, 10, 10));
    private Review twoReview = new Review(2L, "title2", "url2", 1, "content2", 1, new GregorianCalendar(2000, 5, 20));
    private Review threeReview = new Review(4L, "title3", "url3", 2, "content4", 2, new GregorianCalendar(2020, 10, 1));
    private Review fourthReview = new Review(5L, "title4", "url4", 1, "content5", 5, new GregorianCalendar(2018, 3, 12));
    private ReviewRepository underTest = new ReviewRepository(oneReview, twoReview, threeReview, fourthReview);


    @Test
    public void shouldReturnAllReviews() {
        Collection<Review> reviewsFound = underTest.findAll();
        assertEquals(reviewsFound.size(), 3);
        assertThat(reviewsFound).contains(oneReview, twoReview, threeReview);
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