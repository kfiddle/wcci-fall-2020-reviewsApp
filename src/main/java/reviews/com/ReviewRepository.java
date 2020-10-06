package reviews.com;

import org.springframework.stereotype.Repository;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;

@Repository
public class ReviewRepository {
    HashMap<Long, Review> reviews = new HashMap<>();


    public ReviewRepository() throws MalformedURLException {
        Collection<Review> tempReviewsList = new ArrayList<>();
        tempReviewsList.add(new Review(1L, "Dortmunder is best", "/images/reviewer1.jpg", 1, "/images/reviews/review1.txt", "/images/stars/stars5.jpg", LocalDate.of(1975, 10, 10)));
        tempReviewsList.add(new Review(2L, "Yuengling only works in PA", "/images/reviewer2.jpg", 1, "/images/reviews/review2.txt", "/images/stars/stars1.jpg", LocalDate.of(2012, 5, 3)));
        tempReviewsList.add(new Review(3L, "Johnny Walker Blue is overhyped", "/images/reviewer3.jpg", 2, "/images/reviews/review3.txt", "/images/stars/stars3.jpg",  LocalDate.of(2017, 2, 17)));
        tempReviewsList.add(new Review(4L, "Springbank- underrated", "/images/reviewer4.jpg", 2, "images/reviews/review4.txt", "/images/stars/stars5.jpg",   LocalDate.of(2019, 12, 22)));
        tempReviewsList.add(new Review(5L, "MacAllan 12 is good but pricey", "/images/reviewer5.jpg", 2, "/images/reviews/review5.txt", "/images/stars/stars4.jpg",  LocalDate.of(2019, 3, 2)));
        tempReviewsList.add(new Review(6L, "Suntory- a good surpise", "/images/reviewer6.jpg", 2, "/images/reviews/review6.txt", "/images/stars/stars5.jpg",  LocalDate.of(2018, 12, 22)));
        tempReviewsList.add(new Review(7L, "No thanks on Ardbeg", "/images/reviewer7.jpg", 2, "/images/reviews/review7.txt", "/images/stars/stars1.jpg",  LocalDate.of(2019, 12, 22)));
        tempReviewsList.add(new Review(8L, "anything by Troegs works", "/images/reviewer8.jpg", 1, "/images/reviews/review8.txt", "/images/stars/stars3.jpg",  LocalDate.of(2016, 4, 8)));
        tempReviewsList.add(new Review(9L, "Duvel isn't so special ", "/images/reviewer9.jpg", 1, "/images/reviews/review9.txt", "/images/stars/stars3.jpg",  LocalDate.of(2019, 3, 19)));
        tempReviewsList.add(new Review(10L, "Three Philosophers!", "/images/reviewer10.jpg", 1, "/images/reviews/review10.txt", "/images/stars/stars5.jpg",  LocalDate.of(2019, 9, 2)));
        tempReviewsList.add(new Review(11L, "Bumblerry Ale, so-so", "/images/reviewer11.jpg", 1, "/images/reviews/review11.txt", "/images/stars/stars3.jpg", LocalDate.of(1975, 10, 10)));
        tempReviewsList.add(new Review(12L, "Zwickle Trickle", "/images/reviewer12.jpg", 1, "/images/reviews/review12.txt", "/images/stars/stars2.jpg", LocalDate.of(2014, 5, 13)));
        tempReviewsList.add(new Review(13L, "Aviator IPA is good", "/images/reviewer13.jpg", 1, "/images/reviews/review13.txt", "/images/stars/stars4.jpg",  LocalDate.of(2017, 5, 7)));
        tempReviewsList.add(new Review(14L, "Springbank Cask Strength", "/images/reviewer14.jpg", 2, "images/reviews/review14.txt", "/images/stars/stars5.jpg",   LocalDate.of(2019, 6, 29)));
        tempReviewsList.add(new Review(15L, "Grave Digger Pumpkin Ale- nice", "/images/reviewer15.jpg", 1, "/images/reviews/review15.txt", "/images/stars/stars4.jpg",  LocalDate.of(2016, 2, 2)));
        tempReviewsList.add(new Review(16L, "Aberlour Speyside", "/images/reviewer16.jpg", 2, "/images/reviews/review16.txt", "/images/stars/stars3.jpg",  LocalDate.of(2018, 11, 20)));
        tempReviewsList.add(new Review(17L, "Cleveland Underground Bourbon", "/images/reviewer17.jpg", 2, "/images/reviews/review17.txt", "/images/stars/stars5.jpg",  LocalDate.of(2018, 12, 27)));
        tempReviewsList.add(new Review(18L, "Glenmorangie", "/images/reviewer18.jpg", 2, "/images/reviews/review18.txt", "/images/stars/stars3.jpg",  LocalDate.of(2015, 1, 8)));
        tempReviewsList.add(new Review(19L, "Balvenie 12year", "/images/reviewer19.jpg", 2, "/images/reviews/review19.txt", "/images/stars/stars4.jpg",  LocalDate.of(2018, 5, 19)));
        tempReviewsList.add(new Review(20L, "Macallan Triple 18year", "/images/reviewer20.jpg", 2, "/images/reviews/review20.txt", "/images/stars/stars5.jpg",  LocalDate.of(2019, 2, 5)));


        for (Review review : tempReviewsList) {
            reviews.put(review.getId(), review);
        }
    }

    public ReviewRepository(Review... incomingReviews) {
        for (Review review : incomingReviews) {
            reviews.put(review.getId(), review);
        }
    }

    public Collection<Review> findAll() {
        return reviews.values();
    }

    public Review findReview(long id) {
        return reviews.get(id);
    }

    public Collection<Review> showByCategory(int category) {
        Collection<Review> listByCategory = new ArrayList<>();
        for (Review review : reviews.values()) {
            if (review.getCategory() == category) {
                listByCategory.add(review);
            }
        }
        return listByCategory;
    }
}
