package org.dav.less01.task1;

import java.util.ArrayList;
import java.util.List;

/*
Реализовать систему учета книг в библиотеке. У каждой книги есть название,
автор и год издания. Необходимо создать список книг и выполнить следующие действия:
1. Обычный способ:
а) Найти все книги, написанные определенным автором (например, "Джон Доу")
б) Найти все книги, изданные после определенного года (например, после 2010)
в) Найти все уникальные названия книг в библиотеке
2. Использование лямбда-выражений:
а) Те же самые задачи, но с использованием ляьбда-выражения и
   STREAM API для более компактного и выразительного кода.
 */
public class Library {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Федор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));

        // Найти все книги, написанные определенным автором
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if ("Лев Толстой".equals(book.getAuthor())) authorBooks.add(book);
        }
        System.out.println("Лев Толстой books:" + '\n' + authorBooks);

        // Найти все книги, изданные после определенного года
        List<Book> booksAfterYear = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > 1866) booksAfterYear.add(book);
        }
        System.out.println("Books after 1866 year:" + '\n' + booksAfterYear);

        // Найти все уникальные названия книг в библиотеке
        List<String> uniqueTitles = new ArrayList<>();
        for (Book book : books) {
            if (!uniqueTitles.contains(book.getTitle())) {
                uniqueTitles.add(book.getTitle());
            }
        }
        System.out.println("Title of books:" + '\n' + uniqueTitles);




    }
}
