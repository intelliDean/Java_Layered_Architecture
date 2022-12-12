package services;

import data.models.Post;
import data.repositories.PostRepoImpl;
import data.repositories.RepoOfPost;
import dtos.requests.CreateHostRequests;

import java.util.Collection;
import java.util.List;

public class PostServicesImpl implements PostServices{
    private RepoOfPost repoOfPost = new PostRepoImpl();
    @Override
    public void createPost(CreateHostRequests postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setBody(postRequest.getBody());
        repoOfPost.save(post);
    }

    @Override
    public void updatePost(int id, String title, String body) {

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
