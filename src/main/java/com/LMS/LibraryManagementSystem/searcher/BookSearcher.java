package com.LMS.LibraryManagementSystem.searcher;

import com.LMS.LibraryManagementSystem.book.BookCopy;

import java.util.List;

public interface BookSearcher {

    List<BookCopy> search();
}
