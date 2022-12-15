package data.repositories;

import dean.blog.project.data.models.Post;
import dean.blog.project.data.repositories.PostRepoImpl;
import dean.blog.project.data.repositories.RepoOfPost;
import dean.blog.project.dtos.requests.CreatePostRequests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepoImplTest {
    RepoOfPost repoPost;
    CreatePostRequests req;

    @BeforeEach
    void setUp() {
        repoPost = new PostRepoImpl();
        req = new CreatePostRequests();
    }

    @Test
    void savePostIntoRepo() {
        Post post = new Post();
        req.setBody("the first body");
        req.setTitle("the first title");
        post.setBody(req.getBody());
        post.setTitle(req.getTitle());
        repoPost.save(post);
        assertEquals(1L, repoPost.count());
    }

    @Test
    void findPostById() {
        Post post = new Post();
        req.setTitle("title1");
        req.setBody("body of post");
        post.setBody(req.getBody());
        post.setTitle(req.getTitle());
        repoPost.save(post);

        req.setTitle("title2");
        req.setBody("body of post2");
        Post post2 = new Post();
        post2.setBody(req.getBody());
        post2.setTitle(req.getTitle());
        repoPost.save(post2);

        assertEquals(2L, repoPost.count());
        assertEquals("body of post2", post2.getBody());
        assertEquals(post2, repoPost.findById("2"));
    }
    @Test
    void findByIdReturnsNullWhenIdNotFound() {
        Post post = new Post();
        req.setTitle("title1");
        req.setBody("body of post");
        post.setBody(req.getBody());
        post.setTitle(req.getTitle());
        repoPost.save(post);

        req.setTitle("title2");
        req.setBody("body of post2");
        Post post2 = new Post();
        post2.setBody(req.getBody());
        post2.setTitle(req.getTitle());
        repoPost.save(post2);

        assertEquals(2, repoPost.count());
        assertNull(repoPost.findById("3"));
    }

    @Test
    void updatePostInTheRepo() {
        Post post = new Post();
        req.setTitle("new title");
        req.setBody("new body");
        post.setTitle(req.getTitle());
        post.setBody(req.getBody());
        repoPost.save(post);

        Post post2 = new Post();
        post2.setId("1");
        post2.setTitle("title2");
        post2.setBody("new body2");
        repoPost.save(post2);

        assertEquals(1L, repoPost.count());
        assertEquals(post, repoPost.findById("1"));
        assertEquals("title2", post.getTitle());
        assertEquals("new body2", post.getBody());
    }

    @Test
    void deletePost() {
        Post post = new Post();
        req.setTitle("new title");
        req.setBody("new body");
        post.setTitle(req.getTitle());
        post.setBody(req.getBody());
        repoPost.save(post);

        Post post2 = new Post();
        req.setTitle("new title2");
        req.setBody("new body2");
        post2.setTitle(req.getTitle());
        post2.setBody(req.getBody());
        repoPost.save(post2);

        assertEquals(2, repoPost.count());
        repoPost.delete(1);
        assertEquals(1, repoPost.count());
    }

    @Test
    void saveThreePostsDeleteTwoAndSaveOnePostAndCheckItsID() {
        Post post = new Post();
        post.setTitle("title1");
        post.setBody("body1");
        repoPost.save(post);

        Post post2 = new Post();
        post2.setTitle("title2");
        post2.setBody("title2");
        repoPost.save(post2);

        Post post3 = new Post();
        post3.setTitle("title3");
        post3.setBody("body3");
        repoPost.save(post3);
        assertEquals(3, repoPost.count());

        assertEquals(1, post.getId());
        assertEquals(2, post2.getId());
        assertEquals(3, post3.getId());

        repoPost.delete(1);
        repoPost.delete(2);
        //repoPost.delete(3);

        assertEquals(1, repoPost.count());
        Post post4 = new Post();
        post4.setTitle("title4");
        post4.setBody("body4");
        repoPost.save(post4);
        assertEquals(2, repoPost.count());
        assertEquals(4, post4.getId());
    }

    @Test
    void deleteObjectPost() {
        Post post = new Post();
        post.setTitle("title1");
        post.setBody("body1");
        repoPost.save(post);

        Post post2 = new Post();
        post2.setTitle("title2");
        post2.setBody("title2");
        repoPost.save(post2);

        Post post3 = new Post();
        post2.setTitle("title3");
        post2.setBody("title3");
        repoPost.save(post3);

        repoPost.delete(post2);
        repoPost.delete(post);

        assertEquals(1, repoPost.count());
        assertEquals(3, post3.getId());
    }
    @Test
    void deleteAllPostsInTheRepo() {
        Post post = new Post();
        post.setTitle("title1");
        post.setBody("body1");
        repoPost.save(post);

        Post post2 = new Post();
        post2.setTitle("title2");
        post2.setBody("title2");
        repoPost.save(post2);

        Post post3 = new Post();
        post2.setTitle("title3");
        post2.setBody("title3");
        repoPost.save(post3);

        Post post4 = new Post();
        post4.setTitle("title4");
        post4.setBody("title4");
        repoPost.save(post4);

        assertEquals(4, repoPost.count());
        assertEquals(4, post4.getId());

        repoPost.delete(2);
        assertEquals(3, repoPost.count());
        Post post5 = new Post();
        post5.setTitle("title5");
        post5.setBody("title5");
        repoPost.save(post5);

        assertEquals(5, post5.getId());
        assertEquals(4, repoPost.count());

        repoPost.deleteAll();

        assertEquals(0, repoPost.count());
    }

}