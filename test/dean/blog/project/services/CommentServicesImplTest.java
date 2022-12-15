package dean.blog.project.services;

import dean.blog.project.dtos.requests.CreateCommentRequest;
import dean.blog.project.dtos.requests.CreatePostRequests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentServicesImplTest {
    private CommentServices commentServices;
    private PostServices postServices;

    @BeforeEach
    void setUp() {
        commentServices = new CommentServicesImpl();
        postServices = new PostServicesImpl();
    }

    @Test
    void createComment() {
        CreateCommentRequest create = new CreateCommentRequest();
        create.setCommenterName("Dean");
        create.setPostId("1");
        create.setComment("comment");

        CreatePostRequests createPost = new CreatePostRequests();
        createPost.setTitle("title");
        createPost.setBody("body");

        postServices.createPost(createPost);
        commentServices.createComment(create);

        assertEquals(1, commentServices.viewAll().size());
    }

}