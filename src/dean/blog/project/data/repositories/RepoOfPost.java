package dean.blog.project.data.repositories;

import dean.blog.project.data.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepoOfPost extends MongoRepository<Post, String> {

    Post findPostById(String id);
    Post findPostByTitle(String title);

//    Post save(Post post);
//    Post findById(int id);
//    List<Post> findAll();
//    long count();
//    void delete(Post post);
//    void delete(int id);
//    void deleteAll();
}
