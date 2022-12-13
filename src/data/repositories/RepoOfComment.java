package data.repositories;

import data.models.Comment;
import data.models.Post;

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
