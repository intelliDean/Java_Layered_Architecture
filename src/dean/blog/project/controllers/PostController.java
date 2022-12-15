package dean.blog.project.controllers;

import dean.blog.project.data.models.Post;
import dean.blog.project.dtos.requests.CreatePostRequests;
import dean.blog.project.services.PostServices;
import dean.blog.project.services.PostServicesImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    private PostServices  postServices= new PostServicesImpl();
    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequests postRequests) {
        postServices.createPost(postRequests);
        return "Successful";
    }
    @GetMapping("/post/{postId}")
    public Post viewPost(@PathVariable String postId) {
        return postServices.viewPost(postId);
    }
}
