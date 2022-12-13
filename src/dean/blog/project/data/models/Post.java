package dean.blog.project.data.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// model is the POJO, where you have the setters and getters
public class Post {
    private int id;
    private String title;
    private String body;
    private LocalDateTime createTime = LocalDateTime.now();
    private List<Comment> comments = new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return String.format("""
               Time:    %s
               Post ID: %d
               Title:   %sb
               %s
               
               Comment: %s
               
               """,createTime, id, title, body, comments);
    }
}
