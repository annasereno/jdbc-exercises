package models;

public class Qoute {

    private int id;
    private String author;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //no arguments constructor
    public Qoute() {
    }

    public Qoute(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public Qoute(int id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Qoute{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
