package services;

import data.models.Post;
import dtos.requests.CreateHostRequests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServicesImplTest {
    private PostServices postServices;

    @BeforeEach
    void setUp() {
        postServices = new PostServicesImpl();
    }
    @Test
    void createMethodWorks() {
        CreateHostRequests postRequest = new CreateHostRequests();
        postRequest.setBody("the body");
        postRequest.setTitle("title");
        postServices.createPost(postRequest);
        assertEquals(1L, postServices.viewAllPost().size());
    }

}