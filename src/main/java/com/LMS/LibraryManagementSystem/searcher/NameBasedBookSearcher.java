package com.LMS.LibraryManagementSystem.searcher;

import com.LMS.LibraryManagementSystem.book.BookCopy;
import com.LMS.LibraryManagementSystem.dataaccessor.DBAccessor;
import com.LMS.LibraryManagementSystem.dataaccessor.Results;
import com.LMS.LibraryManagementSystem.dataaccessor.ResultsConvertor;

import java.util.List;

public class NameBasedBookSearcher implements BookSearcher{
    private final String bookName;
    private final DBAccessor dbAccessor;

    public NameBasedBookSearcher(String bookName) {
        this.bookName = bookName;
        this.dbAccessor = new DBAccessor();
    }

    @Override
    public List<BookCopy> search() {
        Results results = dbAccessor.getBooksWithName(bookName);
        return ResultsConvertor.convertToBookCopies(results);
    }
}
