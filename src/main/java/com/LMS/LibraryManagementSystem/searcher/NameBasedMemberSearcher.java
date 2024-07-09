package com.LMS.LibraryManagementSystem.searcher;

import com.LMS.LibraryManagementSystem.dataaccessor.DBAccessor;
import com.LMS.LibraryManagementSystem.dataaccessor.Results;
import com.LMS.LibraryManagementSystem.dataaccessor.ResultsConvertor;
import com.LMS.LibraryManagementSystem.user.Member;

import java.util.List;

public class NameBasedMemberSearcher implements MemberSearcher{
    private final String memberName;
    private final DBAccessor dbAccessor;

    public NameBasedMemberSearcher(String memberName) {
        this.memberName = memberName;
        this.dbAccessor = new DBAccessor();
    }

    @Override
    public List<Member> search() {
        Results results = dbAccessor.getMemberWithName(memberName);
        return ResultsConvertor.convertToMembers(results);
    }
}
