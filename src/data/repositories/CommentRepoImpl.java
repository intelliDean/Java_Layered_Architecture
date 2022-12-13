package data.repositories;

import data.models.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class CommentRepoImpl implements RepoOfComment {
    private LocalDateTime commentTime = LocalDateTime.now();
    private List<Comment> comments = new ArrayList<>();
    private int idInitializer;

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() != 0) {
            updateComment(comment);
        } else {
            comments.add(comment);
            comment.setId(++idInitializer);
        }
        commentTime = LocalDateTime.now();
        return comment;
    }

    private void updateComment(Comment comment) {
        Comment foundComment = findById(comment.getId());
        foundComment.makeComment(comment.getComment());     //the foundComment is used to update the comment, with the new comment as the argument
        comment.setUserName(foundComment.getUserName());    //the new comment is used to set the username, with the foundComment as the argument
                                                            // this way, the username cannot be updated, only the comment can
    }

    @Override
    public Comment findById(int id) {
        for (Comment comment : comments) {
            if (comment.getId() == id) {
                return comment;
            }
        }
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return comments;
    }

    @Override
    public long count() {
        return comments.size();
    }

    @Override
    public void delete(Comment comment) {
        comments.removeIf(comm->comm.equals(comment));
    }

    @Override
    public void delete(int id) {
        int index = -1;
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getId() == id) {
                index = i;
            }
        }
        if (index != -1) {
            comments.remove(index);
        }
    }

    @Override
    public void deleteAll() {
        comments.removeAll(findAll());
    }
}
