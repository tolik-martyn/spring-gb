package com.example.reviewservice;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    private final MeterRegistry meterRegistry;

    public ReviewController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/")
    public String showReviews(Model model) {
        meterRegistry.counter("requests_to_reviews").increment();
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "reviews-list";
    }

    @PostMapping("/")
    public String addReview(Review review) {
        reviewService.addReview(review);
        return "redirect:/reviews/";
    }
}