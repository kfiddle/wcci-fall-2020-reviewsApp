package reviews.com;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Review {
    private Long id;
    private String title;
    private String imageUrl;
    private int category;
    private String content;
    private int stars;
    private GregorianCalendar date;

    public Review(Long id, String title, String url, int category, String content, int stars, GregorianCalendar date) {
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

    public String getUrl() {
        return imageUrl;
    }

    public int getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public Review(){
        date = new GregorianCalendar(2018, 6, 27);
    }



}
