package com.LMS.LibraryManagementSystem.lib;

import com.LMS.LibraryManagementSystem.book.BookCopy;
import com.LMS.LibraryManagementSystem.dataaccessor.DBAccessor;
import com.LMS.LibraryManagementSystem.dataaccessor.Results;
import com.LMS.LibraryManagementSystem.dataaccessor.ResultsConvertor;
import com.LMS.LibraryManagementSystem.user.Member;

import java.util.List;

public class Library {

    private final DBAccessor dbAccessor;

    public Library(DBAccessor dbAccessor) {
        this.dbAccessor = dbAccessor;
    }


    public void addBookCopy(BookCopy bookCopy){
        if(bookCopy == null){
            throw new IllegalArgumentException("bookCopy can't be null");
        }
        dbAccessor.insertBookCopy(bookCopy);
    }

    public synchronized void deleteBookCopy(BookCopy bookCopy){
        if(bookCopy == null){
            throw new IllegalArgumentException("bookCopy can't be null");
        }
        //check if bookCopy is available
        //then perform deletion
        if(dbAccessor.isCopyAvailable(bookCopy)){
            dbAccessor.deleteBookCopy(bookCopy);
        }
    }

    public void blockMember(Member member){

    }

    public void issueBook(BookCopy bookCopy, Member member){

    }

    public void submitBook(BookCopy bookCopy, Member member){

    }

    public Member getBorrower(BookCopy bookCopy){
        if(bookCopy == null){
            throw new IllegalArgumentException("bookCopy can't be null");
        }
        Results results = dbAccessor.getBorrower(bookCopy);
        return ResultsConvertor.convertToMember(results);
    }

    public List<BookCopy> getBorrowedBooks(Member member){
        return null;
    }
}
