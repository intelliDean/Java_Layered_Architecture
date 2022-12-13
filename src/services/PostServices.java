package services;

import data.models.Post;
import dtos.requests.CreatePostRequests;

import java.util.List;

public interface PostServices {
    void createPost(CreatePostRequests postRequest);
    void updatePost(CreatePostRequests postRequest);
    void deletePost(int id);
    void deletePost(Post post);
    Post viewPost(int id);
    List<Post> viewAllPost();
    long numberOfPosts();
    void deleteAll();
}
