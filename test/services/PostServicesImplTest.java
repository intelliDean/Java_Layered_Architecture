package services;

import data.models.Post;
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
        assertEquals(1L, postServices.viewAllPost().size());
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

        assertEquals(1L, postServices.viewAllPost().size());




    }
//    @Test
//    void viewPost() {
//        postRequest.setTitle("title");
//        postRequest.setBody("the body");
//        Post post = new Post();
//        postServices.createPost(postRequest);
//        assertEquals(postServices.createPost(postRequest), postServices.viewPost(postRequest.getId()));
//
//    }


}