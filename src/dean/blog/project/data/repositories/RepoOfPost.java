package dean.blog.project.data.repositories;

import dean.blog.project.data.models.Post;

import java.util.List;

public interface RepoOfPost {

    Post save(Post post);
    Post findById(int id);
    List<Post> findAll();
    long count();
    void delete(Post post);
    void delete(int id);
    void deleteAll();
}
