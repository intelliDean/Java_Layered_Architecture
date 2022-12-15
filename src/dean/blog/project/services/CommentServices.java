package dean.blog.project.services;

import dean.blog.project.data.models.Comment;
import dean.blog.project.dtos.requests.CreateCommentRequest;

import java.util.List;

public interface CommentServices {
    void createComment(CreateCommentRequest createCommentRequest);

    List<Comment> viewAll();

}
