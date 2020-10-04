package reviews.com;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class ReviewController {

    @Resource
    private ReviewRepository reviewsRepo;


    @RequestMapping("/reviews")
    public String getAllReviews(Model model){
        //model.addAttribute("allReviewsModel", reviewsRepo.findAll());
    return "allReviewsTemplate";
    }

    @RequestMapping("/review")
    public String findOneReview(@RequestParam(value = "id") Long id, Model model){
        model.addAttribute("reviewModel", reviewsRepo.findReview(id));
        return "oneReviewTemplate";
    }

    @RequestMapping("/beerReviews")
    public String showBeerReviews(Model model){
        model.addAttribute("beersOnlyModel", reviewsRepo.showByCategory(1));
        return "beersTemplate";
    }

    @RequestMapping("/scotchReviews")
    public String showScotchReviews(Model model){
        model.addAttribute("scotchOnlyModel", reviewsRepo.showByCategory(2));
        return "scotchTemplate";
    }

}
