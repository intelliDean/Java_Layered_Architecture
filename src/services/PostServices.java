package services;

import data.models.Post;
import dtos.requests.CreateHostRequests;

import java.util.List;

public interface PostServices {
    void createPost(CreateHostRequests postRequest);
    void updatePost(int id, String title, String body);
    void deletePost(int id);
    Post viewPost(int id);
    List<Post> viewAllPost();
}
