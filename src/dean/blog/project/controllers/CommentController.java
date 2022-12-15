package dean.blog.project.controllers;

import dean.blog.project.dtos.requests.CreateCommentRequest;
import dean.blog.project.services.CommentServices;
import dean.blog.project.services.CommentServicesImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    private CommentServices commentServices = new CommentServicesImpl();
@PostMapping("/comment")
    public String addComment(@RequestBody CreateCommentRequest createCommentRequest) {
        commentServices.createComment(createCommentRequest);
        return "Comment added";
    }
}
