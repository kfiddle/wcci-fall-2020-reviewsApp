package reviews.com;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;

@Repository
public class ReviewRepository {
    HashMap<Long, Review> reviews = new HashMap<>();


    public ReviewRepository() {
        Collection<Review> tempReviewsList = new ArrayList<>();
        tempReviewsList.add(new Review(1L, "Dortmunder is best", "url1", 1, "content1", 5, new GregorianCalendar(1975, 10, 10)));
        tempReviewsList.add(new Review(2L, "Yuengling only works in PA", "url2", 1, "content2", 1, new GregorianCalendar(2012, 5, 3)));
        tempReviewsList.add(new Review(3L, "Johnny Walker Blue is overhyped", "url3", 2, "content3", 3, new GregorianCalendar(2017, 2, 17)));
        tempReviewsList.add(new Review(4L, "Springbank- underrated", "url4", 2, "content4", 4, new GregorianCalendar(2019, 12, 22)));

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
