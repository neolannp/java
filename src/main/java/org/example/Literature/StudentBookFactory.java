package org.example.Literature;

public class StudentBookFactory implements BookFactory{
    @Override
    public Book createEngBook(Book book) {
        return new EngStudentBook();
    }

    @Override
    public Book createRusBook(Book book) {
        return new RusStudentBook();
    }
}
