package org.dav.less01.task1;

import java.util.ArrayList;
import java.util.List;

public class LibraryStreamApi {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Федор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));

        // Найти все книги, написанные определенным автором
//        books.stream().filter(book -> book.getAuthor().equals("Лев Толстой")).
//                forEach(System.out::println);
        List<Book> authorBooks = books.stream()
                .filter(book -> book.getAuthor().equals("Лев Толстой")).toList();
        System.out.println(STR."Лев Толстой books:\{'\n'}\{authorBooks}");

                // Найти все книги, изданные после определенного года
//        books.stream().filter(book -> book.getYear() > 1866).
//                forEach(System.out::println);
        List<Book> booksAfterYear = books.stream()
                .filter(book -> book.getYear() > 1866).toList();
        System.out.println(STR."Books after 1866 year:\{'\n'}\{booksAfterYear}");

        // Найти все уникальные названия книг в библиотеке
//        books.stream().map(Book::getTitle).distinct().
//                forEach(System.out::println);

        List<String> uniqueTitles = books.stream().
                map(Book::getTitle).distinct().toList();
        System.out.println(STR."Title of books:\{'\n'}\{uniqueTitles}");
    }
}
