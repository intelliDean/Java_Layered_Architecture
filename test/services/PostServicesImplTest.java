package services;

import data.models.Post;
import data.repositories.PostRepoImpl;
import data.repositories.RepoOfPost;
import dtos.requests.CreatePostRequests;
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

        CreatePostRequests reqs =  new CreatePostRequests();
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

        postRequest.setId(1);
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

        CreatePostRequests reqs =  new CreatePostRequests();
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

        CreatePostRequests reqs =  new CreatePostRequests();
        reqs.setTitle("title3");
        reqs.setBody("body3");
        postServices.createPost(reqs);

        assertEquals(3, reqs.getId());
        postServices.deletePost(2);

        assertEquals(2, postServices.numberOfPosts());

        CreatePostRequests real =  new CreatePostRequests();
        real.setTitle("title3");
        real.setBody("body3");
        postServices.createPost(real);

        assertEquals(3L, postServices.numberOfPosts());
        assertEquals(4, real.getId());

        postServices.deleteAll();

        assertEquals(0, postServices.numberOfPosts());

    }
//    @Test
//    void viewPost() {
//        RepoOfPost repo = new PostRepoImpl();
//        Post post = new Post();
//        post.setTitle("title");
//        post.setBody("the body");
//        repo.save(post);
//
//        Post post1 = new Post();
//        post1.setTitle("title1");
//        post1.setBody("the body1");
//        repo.save(post1);
//
//        assertEquals(2L, postServices.numberOfPosts());
//
//
//    }


}