package services;

import data.models.Post;
import data.repositories.PostRepoImpl;
import data.repositories.RepoOfPost;
import dtos.requests.CreatePostRequests;

import java.util.List;

public class PostServicesImpl implements PostServices{
    private RepoOfPost repoOfPost = new PostRepoImpl();
    @Override
    public void createPost(CreatePostRequests postRequest) {

        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setBody(postRequest.getBody());
        repoOfPost.save(post);
    }

    @Override
    public void updatePost(CreatePostRequests postRequest) {
        if (postRequest.getId() != 0) {
          Post post = repoOfPost.findById(postRequest.getId());

        }
    }

    @Override
    public void deletePost(int id) {

    }

    @Override
    public Post viewPost(int id) {
        return null;
    }

    @Override
    public List<Post> viewAllPost() {
        return repoOfPost.findAll();
    }
}
