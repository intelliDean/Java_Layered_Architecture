package dean.blog.project.services;

import dean.blog.project.data.models.Comment;
import dean.blog.project.data.models.Post;
//import dean.blog.project.data.repositories.PostRepoImpl;
import dean.blog.project.data.repositories.RepoOfPost;
import dean.blog.project.dtos.requests.CreatePostRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServicesImpl implements PostServices {
    @Autowired
    private /*static*/ RepoOfPost repoOfPost;
    private int idInitializer;

    @Override
    public void createPost(CreatePostRequests postRequest) {
        if (Objects.equals(postRequest.getId(), String.valueOf(0))) {
            postRequest.setId(String.valueOf(++idInitializer));
            Post post = new Post();
            post.setTitle(postRequest.getTitle());
            post.setBody(postRequest.getBody());
            repoOfPost.save(post);
        }
    }

    @Override
    public void updatePost(CreatePostRequests postRequest) {
        if (!(Objects.equals(postRequest.getId(), String.valueOf(0)))) {
            Post post = repoOfPost.findPostById(postRequest.getId());
            post.setBody(postRequest.getBody());
            post.setTitle(postRequest.getTitle());
        }
    }

    @Override
    public void deletePost(String id) {

    }

//    @Override
//    public void deletePost(String id) {
//        repoOfPost.delete(id);
//    }

    @Override
    public void deletePost(Post post) {
        repoOfPost.delete(viewPost(post.getId()));
    }

    @Override
    public Post viewPost(String id) {
        return repoOfPost.findPostById(id);
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

    @Override
    public void addComment(String postId, Comment comment) {
        Post post = repoOfPost.findPostById(postId);
        post.getComments().add(comment);
        repoOfPost.save(post);
    }
}
