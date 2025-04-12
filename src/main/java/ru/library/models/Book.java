package ru.library.models;

public class Book {
    private int book_id;
    private Integer person_id;
    private String title;
    private String author;
    private int publicationYear;

    public Book(int book_id, Integer person_id, String author, String title, int publicationYear) {
        this.book_id = book_id;
        this.person_id = person_id;
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public Book() {}

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }
}
