package com.pluralsight;

public class Book {
    /**
     * id: int
     * - isbn: String
     * - title: String
     * - isCheckedOut: boolean
     * - checkedOutTo: String
     * Out of respect for literature, adding author.
     */
    private int id;
    private String isbn,title,author,checkedOutTo;
    private boolean isCheckedOut;

    public Book(int id, String isbn, String title, String author, String checkedOutTo, boolean isCheckedOut) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.checkedOutTo = checkedOutTo;
        this.isCheckedOut = isCheckedOut;
    }
    //Getters/Setters below, methods underneath
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    //Homebrewed methods
    public void checkOut(String name){
        this.checkedOutTo = name;
        this.isCheckedOut = true;
    }
    public void checkIn(){
        this.checkedOutTo = "";
        this.isCheckedOut = true;
    }
}
