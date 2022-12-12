package data.repositories;

import data.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepoImpl implements RepoOfPost{
    private List<Post> postDb = new ArrayList<>();
    @Override
    public Post save(Post post) {
        if (post.getId() != 0) {
            update(post);
        } else {
        post.setId(postDb.size() + 1);
        postDb.add(post);
        }
        return post;
    }

    private void update(Post post) {
        Post post2 = findById(post.getId());
        post2.setTitle(post.getTitle());
        post2.setBody(post.getBody());
    }

    @Override
    public Post findById(int id) {
        for (Post post : postDb) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    @Override
    public List<Post> findAll() {
        return postDb;
    }

    @Override
    public long count() {
        return postDb.size();
    }

    @Override
    public void delete(Post post) {

    }

    @Override
    public void delete(int id) {
        Post post = findById(id);
        if (post != null) {
            postDb.remove(post);
        }
    }
}
