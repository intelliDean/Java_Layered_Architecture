package dean.blog.project.services;

import dean.blog.project.data.models.Comment;
import dean.blog.project.data.models.Post;
import dean.blog.project.dtos.requests.CreatePostRequests;

import java.util.List;

public interface PostServices {
    void createPost(CreatePostRequests postRequest);
    void updatePost(CreatePostRequests postRequest);
    void deletePost(String id);
    void deletePost(Post post);
    Post viewPost(String id);
    List<Post> viewAllPost();
    long numberOfPosts();
    void deleteAll();
    void addComment(String postId, Comment comment);
}
