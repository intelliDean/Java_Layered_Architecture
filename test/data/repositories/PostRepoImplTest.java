package data.repositories;

import data.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepoImplTest {
  RepoOfPost repoPost;

  @BeforeEach
    void setUp() {
      repoPost = new PostRepoImpl();
  }
  @Test
    void savePostIntoRepo() {
      Post post = new Post();
      post.setBody("Body of post");
      post.setTitle("Title");
      repoPost.save(post);
      assertEquals(1L, repoPost.count());
  }
  @Test
  void findPostById() {
    Post post = new Post();
      post.setBody("Body of post");
      post.setTitle("Title");
      repoPost.save(post);

      Post post2 = new Post();
      post2.setBody("Body of post2");
      post2.setTitle("Title2");
      repoPost.save(post2);

      assertEquals(2L, repoPost.count());
      assertEquals(post2, repoPost.findById(2));
  }
  @Test
  void updatePostInTheRepo() {
    Post post = new Post();
    post.setTitle("new title");
    post.setBody("new body");
    repoPost.save(post);

    Post post2 = new Post();
    post2.setId(1);
    post2.setTitle("title2");
    post2.setBody("body2");
    repoPost.save(post2);

    assertEquals(1L, repoPost.count());
    assertEquals(post, repoPost.findById(1));
    assertEquals("title2", post.getTitle());
    assertEquals("body2", post.getBody());
  }
  @Test
  void deletePost() {
   Post post = new Post();
    post.setTitle("new title");
    post.setBody("new body");
    repoPost.save(post);

    Post post2 = new Post();
    post2.setTitle("new title2");
    post2.setBody("new body2");
    repoPost.save(post2);
    assertEquals(2, repoPost.count() );

    repoPost.delete(1);
    assertEquals(1, repoPost.count());
  }

}