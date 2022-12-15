package dean.blog.project.services;

import dean.blog.project.data.models.Comment;
import dean.blog.project.data.models.Post;
import dean.blog.project.dtos.requests.CreatePostRequests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServicesImplTest {
    private PostServices postServices;
    CreatePostRequests postRequest;

    @BeforeEach
    void setUp() {
        postServices = new PostServicesImpl();
        postRequest = new CreatePostRequests();
    }

    @Test
    void createPost() {
        postRequest.setBody("the body");
        postRequest.setTitle("title");
        postServices.createPost(postRequest);

        CreatePostRequests req = new CreatePostRequests();
        req.setBody("the new body");
        req.setTitle("new title");
        postServices.createPost(req);

        CreatePostRequests reqs = new CreatePostRequests();
        reqs.setTitle("title3");
        reqs.setBody("body3");
        postServices.createPost(reqs);
        assertEquals(3, reqs.getId());
        assertEquals(3L, postServices.numberOfPosts());
    }

    @Test
    void updatePost() {
        postRequest.setBody("the body");
        postRequest.setTitle("title");
        postServices.createPost(postRequest);

        postRequest.setId("1");
        postRequest.setBody("new body");
        postRequest.setTitle("new title");
        postServices.createPost(postRequest);

        assertEquals(1L, postServices.numberOfPosts());
    }

    @Test
    void deletePostUsingId() {
        postRequest.setBody("the body");
        postRequest.setTitle("title");
        postServices.createPost(postRequest);

        CreatePostRequests req = new CreatePostRequests();
        req.setBody("the new body");
        req.setTitle("new title");
        postServices.createPost(req);

        CreatePostRequests reqs = new CreatePostRequests();
        reqs.setTitle("title3");
        reqs.setBody("body3");
        postServices.createPost(reqs);

        assertEquals(3, reqs.getId());
        assertEquals(3L, postServices.numberOfPosts());

        postServices.deletePost(2);

        assertEquals(2L, postServices.numberOfPosts());
    }

    @Test
    void deleteALlPosts() {
        postRequest.setBody("the body");
        postRequest.setTitle("title");
        postServices.createPost(postRequest);

        CreatePostRequests req = new CreatePostRequests();
        req.setBody("the new body");
        req.setTitle("new title");
        postServices.createPost(req);

        CreatePostRequests reqs = new CreatePostRequests();
        reqs.setTitle("title3");
        reqs.setBody("body3");
        postServices.createPost(reqs);

        assertEquals(3, reqs.getId());
        postServices.deletePost(2);

        assertEquals(2, postServices.numberOfPosts());

        CreatePostRequests real = new CreatePostRequests();
        real.setTitle("title3");
        real.setBody("body3");
        postServices.createPost(real);

        assertEquals(3L, postServices.numberOfPosts());
        assertEquals(4, real.getId());

        postServices.deleteAll();

        assertEquals(0, postServices.numberOfPosts());

    }

    @Test
    void viewPost() {
        postRequest.setBody("my body");
        postRequest.setTitle("title");
        postServices.createPost(postRequest);

        assertEquals(1, postServices.numberOfPosts());

        Post post = postServices.viewPost(1);
        assertEquals("my body", post.getBody());
        assertEquals("title", post.getTitle());
    }

    @Test
    void deletePostByPostObject() {
        postRequest.setBody("the body");
        postRequest.setTitle("title");
        postServices.createPost(postRequest);

        CreatePostRequests req = new CreatePostRequests();
        req.setBody("the new body");
        req.setTitle("new title");
        postServices.createPost(req);

        assertEquals(2, postServices.numberOfPosts());

        Post post = postServices.viewPost(1);

        postServices.deletePost(post);

        assertEquals(1, postServices.numberOfPosts());
    }
    @Test
    void addComment() {
        CreatePostRequests create = new CreatePostRequests();
        //Post post = new Post();
        create.setTitle("title");
        create.setBody("body");
        postServices.createPost(create);

        Comment comment = new Comment();
        comment.makeComment("i love me");
        postServices.addComment(1, comment);

        Post foundPost = postServices.viewPost(1);
        assertEquals(1, foundPost.getComments().size());
        assertEquals("i love me", foundPost.getComments().get(0).getComment());
    }

}