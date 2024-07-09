package com.LMS.LibraryManagementSystem.dataaccessor;

import com.LMS.LibraryManagementSystem.book.BookCopy;
import com.LMS.LibraryManagementSystem.user.Member;

import java.awt.print.Book;
import java.util.List;

public class DBAccessor {

    public Results getBooksWithName(String bookName){
        return null;
    }

    public Results getBooksWithAuthorName(List<String> authorNames){
        return null;
    }

    public Results getMemberWithName(String memberName){
        return null;
    }

    public void insertBookCopy(BookCopy bookCopy){

    }

    public void deleteBookCopy(BookCopy bookCopy){

    }

    public void markedAsBlocked(Member member){

    }

    public void issueBookCopyToMember(BookCopy bookCopy, Member member){

    }

    public void submitBookCopyFromMember(BookCopy bookCopy, Member member){

    }

    public boolean isCopyAvailable(BookCopy bookCopy){
        return false;
    }

    public Results getBorrower(BookCopy bookCopy){
        return null;
    }

    public Results getBorrowedBooks(Member member){
        return null;
    }
}
