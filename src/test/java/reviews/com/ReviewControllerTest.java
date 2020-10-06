package reviews.com;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewRepository reviewRepo;


    @Mock
    private Review reviewOne;
    @Mock
    private Review reviewTwo;


    @Test
    public void shouldBeOkForAllReviewsInReviewsTemplate() throws Exception {
        mockMvc.perform(get("/reviews")).andExpect(status().isOk())
                .andExpect(view().name("allReviewsTemplate"));
    }


    @Test
    public void shouldHaveAllReviewsInModel() throws Exception {
        ArrayList<Review> allReviewsInModel = new ArrayList<>();
        allReviewsInModel.add(reviewOne);
        allReviewsInModel.add(reviewTwo);
        assertEquals(allReviewsInModel.size(), 2);
        when(reviewRepo.findAll()).thenReturn(allReviewsInModel);
        mockMvc.perform(get("/reviews")).andExpect(model().attribute("allReviewsModel", allReviewsInModel));
    }


    @Test
    public void shouldFindSpecificReviewInReviewTemplate() throws Exception {
        mockMvc.perform(get("/review?id=2")).andExpect(status().isOk())
                .andExpect(view().name("oneReviewTemplate"));
    }

    @Test
    public void shouldBeGoodForBeersOnlyTemplate() throws Exception {
        mockMvc.perform(get("/beerReviews")).andExpect(status().isOk())
                .andExpect(view().name("beersTemplate"));
    }

    @Test
    public void shouldBeGoodForScotchOnlyTemplate() throws Exception {
        mockMvc.perform(get("/scotchReviews")).andExpect(status().isOk())
                .andExpect(view().name("scotchTemplate"));
    }



    }


