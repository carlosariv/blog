package carlosariv.blog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import carlosariv.blog.models.Post;
import carlosariv.blog.services.PostService;

@Controller
public class HomeController {
    private final PostService postService;

    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(path="/", method=RequestMethod.GET)
    public String getHome(Model model) {
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        for (Post post : posts) {
            System.out.print("Post: ");
            System.out.print(post.getTitle() + " ");
            System.out.print(post.getCreateDate() + " ");
            System.out.print(post.getBody());
            System.out.println();
        }
        return "/home";
    }
}
