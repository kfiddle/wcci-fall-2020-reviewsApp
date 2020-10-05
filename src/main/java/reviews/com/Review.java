package reviews.com;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Review implements Comparable<Review> {
    private Long id;
    private String title;
    private String imageUrl;
    private int category;
    private String content;
    private String stars;

    private LocalDate date;

    public Review(Long id, String title, String url, int category, String content, String stars, LocalDate date) {
        this.id = id;
        this.title = title;
        imageUrl = url;
        this.category = category;
        this.content = content;
        this.stars = stars;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStars() {
        return stars;
    }


    @Override
    public int compareTo(Review that) {
        return this.stars.compareTo(that.stars);
    }
}
