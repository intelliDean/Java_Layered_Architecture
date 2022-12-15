package dean.blog.project.services;

import dean.blog.project.data.models.Comment;
//import dean.blog.project.data.repositories.CommentRepoImpl;
import dean.blog.project.data.repositories.RepoOfComment;
import dean.blog.project.dtos.requests.CreateCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServicesImpl implements CommentServices{

    @Autowired
    private PostServices postServices;
    @Autowired
    private RepoOfComment repo;
    @Override
    public void createComment(CreateCommentRequest createCommentRequest) {
        Comment comment = new Comment();
        comment.makeComment(createCommentRequest.getComment());
        comment.setUserName(createCommentRequest.getCommenterName());
        comment.setId(createCommentRequest.getPostId());
        Comment savedComment = repo.save(comment);
        postServices.addComment(createCommentRequest.getPostId(), savedComment);
    }

    @Override
    public List<Comment> viewAll() {
        return null;
    }
}
