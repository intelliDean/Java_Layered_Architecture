package dean.blog.project.services;

import dean.blog.project.data.models.Post;
import dean.blog.project.data.repositories.PostRepoImpl;
import dean.blog.project.data.repositories.RepoOfPost;
import dean.blog.project.dtos.requests.CreatePostRequests;

import java.util.List;

public class PostServicesImpl implements PostServices {
    private RepoOfPost repoOfPost = new PostRepoImpl();
    private int idInitializer;

    @Override
    public void createPost(CreatePostRequests postRequest) {
        if (postRequest.getId() == 0) {
            postRequest.setId(++idInitializer);
            Post post = new Post();
            post.setTitle(postRequest.getTitle());
            post.setBody(postRequest.getBody());
            repoOfPost.save(post);
        }
    }

    @Override
    public void updatePost(CreatePostRequests postRequest) {
        if (postRequest.getId() != 0) {
            Post post = repoOfPost.findById(postRequest.getId());
            post.setBody(postRequest.getBody());
            post.setTitle(postRequest.getTitle());
        }
    }

    @Override
    public void deletePost(int id) {
        repoOfPost.delete(id);
    }

    @Override
    public void deletePost(Post post) {
        repoOfPost.delete(viewPost(post.getId()));
    }

    @Override
    public Post viewPost(int id) {
        return repoOfPost.findById(id);
    }

    @Override
    public List<Post> viewAllPost() {
        return repoOfPost.findAll();
    }
    public long numberOfPosts() {
        return viewAllPost().size();
    }

    @Override
    public void deleteAll() {
        repoOfPost.deleteAll();
    }
}
