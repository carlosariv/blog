package carlosariv.blog.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import carlosariv.blog.models.Post;
import carlosariv.blog.services.PostService;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/{id}")
    public String view_post(@PathVariable("id") Long post_id, Model model) {
        Optional<Post> post = postService.findFromId(post_id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            return "post";
        } else {
            return "";
        }
    }

    @GetMapping("/post/new")
    public String new_post(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "/postForm";
    }

    @PostMapping("/post/new")
    public String submit_post(@ModelAttribute Post post) {
        post.setCreateDate(LocalDateTime.now());
        postService.save(post);

        String res = "redirect:/post/" + post.getId();
        return res;
    }
}
