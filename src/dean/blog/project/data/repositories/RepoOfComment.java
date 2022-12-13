package dean.blog.project.data.repositories;

import dean.blog.project.data.models.Comment;

import java.util.List;

public interface RepoOfComment {

    Comment save(Comment comment);
    Comment findById(int id);
    List<Comment> findAll();
    long count();
    void delete(Comment comment);
    void delete(int id);
    void deleteAll();
}
