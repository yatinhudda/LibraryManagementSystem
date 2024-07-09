package com.LMS.LibraryManagementSystem.tester;

import com.LMS.LibraryManagementSystem.auth.UserAuthenticator;
import com.LMS.LibraryManagementSystem.book.BookCopy;
import com.LMS.LibraryManagementSystem.book.BookDetails;
import com.LMS.LibraryManagementSystem.dataaccessor.DBAccessor;
import com.LMS.LibraryManagementSystem.id.IDGenerator;
import com.LMS.LibraryManagementSystem.lib.Library;
import com.LMS.LibraryManagementSystem.searcher.*;
import com.LMS.LibraryManagementSystem.user.Member;

import java.util.Date;
import java.util.List;

public class Tester {
    private final Library library = new Library(new DBAccessor());
    public List<BookCopy> searchBooksByBookName(String bookName){
        if(bookName == null){
            throw new IllegalArgumentException("Book name can't be null");
        }
        BookSearcher bookSearcher = new NameBasedBookSearcher(bookName);
        return bookSearcher.search();
    }

    public List<BookCopy> searchBooksByAuthorName(List<String> authorNames){
        if(authorNames == null || authorNames.isEmpty()){
            throw new IllegalArgumentException("Author Name can't be null");
        }
        BookSearcher bookSearcher = new AuthorBasedBookSearcher(authorNames);
        return bookSearcher.search();
    }

    public List<Member> searchMemberByMemberName(String memberName, String adminToken) throws IllegalAccessException {
        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalAccessException("Operation Forbidden");
        }

        if(memberName == null || memberName.isEmpty()){
            throw new IllegalArgumentException("Member Name can't be null");
        }
        MemberSearcher memberSearcher = new NameBasedMemberSearcher(memberName);
        return memberSearcher.search();
    }

    public List<BookCopy> searchBooksByBookID(int bookID){
        return null;
    }



    public void addBook(String bookName, Date publicationDate, List<String> authors, String adminToken) throws IllegalAccessException {
        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalAccessException("Operation Forbidden");
        }
        BookCopy bookCopy = new BookCopy(new BookDetails(bookName, publicationDate, authors), IDGenerator.getUniqueId());
        library.addBookCopy(bookCopy);
    }

    public void deleteBook(int bookID, String adminToken) throws IllegalAccessException {
        if(bookID <= 0 || adminToken == null || adminToken.isEmpty()){
            throw new IllegalArgumentException("bookID/admin token cannot be null or empty");
        }
        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalAccessException("Operation Forbidden");
        }
        BookSearcher bookSearcher = new IdBasedBookSearcher(bookID);
        List<BookCopy> bookCopies =  bookSearcher.search();
        if(bookCopies == null || bookCopies.isEmpty()){
            throw new RuntimeException("No Book Copy retrieved for given id");
        }
        library.deleteBookCopy(bookCopies.get(0));

    }

    public void blockMember(int memberID, String adminToken) throws IllegalAccessException {
        if(memberID <= 0 || adminToken == null || adminToken.isEmpty()){
            throw new IllegalArgumentException("bookID/admin token cannot be null or empty");
        }
        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalAccessException("Operation Forbidden");
        }
        MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberID);
        List<Member> members = memberSearcher.search();
        if(members == null || members.isEmpty()){
            throw new RuntimeException("No Member retrieved for given id");
        }
        library.blockMember(members.get(0));
    }

    public void issueBook(int bookCopyID, int memberID, String adminToken) throws IllegalAccessException {
        if(bookCopyID <= 0 || memberID <= 0 || adminToken == null || adminToken.isEmpty()){
            throw new IllegalArgumentException("bookCopyID/memberId/adminToken cannot be null or less than 0");
        }
        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalAccessException("Operation Forbidden");
        }
        BookSearcher bookSearcher = new IdBasedBookSearcher(bookCopyID);
        List<BookCopy> bookCopies =  bookSearcher.search();
        if(bookCopies == null || bookCopies.isEmpty()){
            throw new RuntimeException("No Book Copy retrieved for given id");
        }
        MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberID);
        List<Member> members = memberSearcher.search();
        if(members == null || members.isEmpty()){
            throw new RuntimeException("No Member retrieved for given id");
        }
        library.issueBook(bookCopies.get(0), members.get(0));

    }

    public void submitBook(int bookCopyID, int memberID, String adminToken) throws IllegalAccessException {
        if(bookCopyID <= 0 || memberID <= 0 || adminToken == null || adminToken.isEmpty()){
            throw new IllegalArgumentException("bookCopyID/memberId/adminToken cannot be null or less than 0");
        }
        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalAccessException("Operation Forbidden");
        }
        BookSearcher bookSearcher = new IdBasedBookSearcher(bookCopyID);
        List<BookCopy> bookCopies =  bookSearcher.search();
        if(bookCopies == null || bookCopies.isEmpty()){
            throw new RuntimeException("No Book Copy retrieved for given id");
        }
        MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberID);
        List<Member> members = memberSearcher.search();
        if(members == null || members.isEmpty()){
            throw new RuntimeException("No Member retrieved for given id");
        }
        library.submitBook(bookCopies.get(0), members.get(0));
    }

    public Member getBorrowerOfBook(int bookCopyID, String adminToken) throws IllegalAccessException {
        if(bookCopyID <= 0 || adminToken == null || adminToken.isEmpty()){
            throw new IllegalArgumentException("bookID/admin token cannot be null or empty");
        }
        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalAccessException("Operation Forbidden");
        }
        BookSearcher bookSearcher = new IdBasedBookSearcher(bookCopyID);
        List<BookCopy> bookCopies =  bookSearcher.search();
        if(bookCopies == null || bookCopies.isEmpty()){
            throw new RuntimeException("No Book Copy retrieved for given id");
        }
        Member borrower =  library.getBorrower(bookCopies.get(0));
        return borrower;
    }

    public List<BookCopy> getBookBorrowedByMember(int memberID, String adminToken) throws IllegalAccessException {
        if(memberID <= 0 || adminToken == null || adminToken.isEmpty()){
            throw new IllegalArgumentException("bookID/admin token cannot be null or empty");
        }
        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalAccessException("Operation Forbidden");
        }
        MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberID);
        List<Member> members = memberSearcher.search();
        if(members == null || members.isEmpty()){
            throw new RuntimeException("No Member retrieved for given id");
        }
        List<BookCopy> bookCopiesBorrowedByMember = library.getBorrowedBooks(members.get(0));
        return bookCopiesBorrowedByMember;
    }
}
