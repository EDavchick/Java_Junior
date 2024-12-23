package org.dav.less01.task1;

public class Book {




    // region Constructor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    // endregion

    // region Methods

    @Override
    public String toString() {
        return "Book: " +
                "title: '" + title + '\'' +
                ", author: '" + author + '\'' +
                ", year: " + year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
    // endregion

    // region Var
    private final String title;
    private final String author;
    private final int year;
    // endregion





}
