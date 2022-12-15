package dean.blog.project.data.repositories;

import dean.blog.project.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoOfComment extends MongoRepository<Comment, String> {

//    Comment save(Comment comment);
//    Comment findById(int id);
//    List<Comment> findAll();
//    long count();
//    void delete(Comment comment);
//    void delete(int id);
//    void deleteAll();
}
