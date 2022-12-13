package data.models;

// model is the POJO, where you have the setters and getters
public class Comment {
    private int id;
    private String userName;
    private String comment;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void makeComment(String comment) {
        this.comment = comment;
    }
}
