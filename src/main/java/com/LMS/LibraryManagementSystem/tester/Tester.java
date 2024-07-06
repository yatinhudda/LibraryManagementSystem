package com.LMS.LibraryManagementSystem.tester;

import java.util.Date;
import java.util.List;

public class Tester {
    public List<BookCopy> searchBooksByBookName(String bookName){

    }

    public List<BookCopy> searchBooksByAuthorName(String authorNames){

    }

    public List<BookCopy> searchBooksByBookID(int bookID){

    }

    public List<Member> searchMemberByMemberName(String memberName){

    }

    public void addBook(String bookName, Date publicationDate, List<String> authors, String adminToken){

    }

    public void deleteBook(int bookID, String adminToken){

    }

    public void blockMember(int memberID, String adminToken){

    }

    public void issueBook(int bookCopyID, int memberID, String adminToken){

    }

    public void submitBook(int bookCopyID, int memberID, String adminToken){

    }

    public Member getBorrowerOfBook(int bookCopyID, String adminToken){

    }

    public List<BookCopy> getBookBorrowedByMember(int memberID, String adminToken){

    }
}
