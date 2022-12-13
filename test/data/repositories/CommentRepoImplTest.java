package data.repositories;

import dean.blog.project.data.models.Comment;
import dean.blog.project.data.repositories.CommentRepoImpl;
import dean.blog.project.data.repositories.RepoOfComment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepoImplTest {
    RepoOfComment repoCom;

    @BeforeEach
    void setUp() {
        repoCom = new CommentRepoImpl();
    }
    @Test
    void saveComment() {
        Comment comment = new Comment();
        comment.setUserName("@dean8ix");
        comment.makeComment("I love you and now always");
        repoCom.save(comment);
        assertEquals(1, repoCom.count());
    }
    @Test
    void findCommentById() {
        Comment comment = new Comment();
        comment.setUserName("@dean8ix");
        comment.makeComment("I love you and now always");
        repoCom.save(comment);

        Comment comment2 = new Comment();
        comment2.setUserName("@maiko90");
        comment2.makeComment("Come to think of it");
        repoCom.save(comment2);
        assertEquals(2, repoCom.count());
        Comment comm = repoCom.findById(2);
        assertEquals(comment2, comm);
    }
    @Test
    void ifFindByIdAndIdNotFoundItReturnsNull() {
        Comment comment = new Comment();
        comment.setUserName("@dean8ix");
        comment.makeComment("I love you and now always");
        repoCom.save(comment);

        Comment comment2 = new Comment();
        comment2.setUserName("@maiko90");
        comment2.makeComment("Come to think of it");
        repoCom.save(comment2);
        assertEquals(2, repoCom.count());

        assertNull(repoCom.findById(3));
    }
    @Test
    void updateCommentIfSameIdIsEntered() {
        Comment comment = new Comment();
        comment.setUserName("@dean8ix");
        comment.makeComment("I love you and now always");
        repoCom.save(comment);

        Comment comment2 = new Comment();
        comment2.setId(1);
        comment2.setUserName("@maiko90");
        comment2.makeComment("Come to think of it");
        repoCom.save(comment2);

        assertEquals(1, repoCom.count());
        assertEquals(comment, repoCom.findById(1));
        assertEquals("@dean8ix", comment2.getUserName());
        assertEquals("Come to think of it", comment.getComment());
    }
    @Test
      void deleteByObjectComment() {
        Comment comment = new Comment();
        comment.setUserName("@dean8ix");
        comment.makeComment("I love you and now always");
        repoCom.save(comment);

        Comment comment2 = new Comment();
        comment2.setUserName("@maiko90");
        comment2.makeComment("Come to think of it");
        repoCom.save(comment2);

        Comment comment3 = new Comment();
        comment3.setUserName("jedi");
        comment3.makeComment("konji");
        repoCom.save(comment3);
        assertEquals(3, repoCom.count());

        repoCom.delete(comment2);
        repoCom.delete(comment);

        assertEquals(1, repoCom.count());
        assertEquals(1, comment.getId());
    }
    @Test
    void makeThreeCommentsDeleteTwoAndMakeAnotherCommentThenCheckTheId() {
        Comment comment = new Comment();
        comment.setUserName("@dean8ix");
        comment.makeComment("I love you and now always");
        repoCom.save(comment);

        Comment comment2 = new Comment();
        comment2.setUserName("@maiko90");
        comment2.makeComment("Come to think of it");
        repoCom.save(comment2);

        Comment comment3 = new Comment();
        comment3.setUserName("jedi");
        comment3.makeComment("konji");
        repoCom.save(comment3);
        assertEquals(3, repoCom.count());

        repoCom.delete(1);
        repoCom.delete(3);
        assertEquals(1, repoCom.count());
        assertEquals(2, comment2.getId());
    }
    @Test
    void deleteAllComments() {
        Comment comment = new Comment();
        comment.setUserName("@dean8ix");
        comment.makeComment("I love you and now always");
        repoCom.save(comment);

        Comment comment2 = new Comment();
        comment2.setUserName("@maiko90");
        comment2.makeComment("Come to think of it");
        repoCom.save(comment2);

        Comment comment3 = new Comment();
        comment3.setUserName("@jedi");
        comment3.makeComment("konji");
        repoCom.save(comment3);
        assertEquals(3, repoCom.count());

        repoCom.delete(1);

        assertEquals(2, repoCom.count());
        Comment comment4 = new Comment();
        comment4.setUserName("@india");
        comment4.makeComment("lovely");
        repoCom.save(comment4);

        assertEquals(3, repoCom.count());

        repoCom.deleteAll();
        assertEquals(0, repoCom.count());


    }


}