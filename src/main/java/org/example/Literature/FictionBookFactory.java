package org.example.Literature;

import java.io.IOException;

public class FictionBookFactory implements BookFactory{
    @Override
    public Book createEngBook(Book book) throws IOException {
        return new EngFictionBook();
    }

    @Override
    public Book createRusBook(Book book) throws IOException {
        return new RusFictionBook();
    }


}
