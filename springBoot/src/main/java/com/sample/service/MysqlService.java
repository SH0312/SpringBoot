package com.sample.service;

import java.util.List;

import com.sample.vo.MemberVO;

public interface MysqlService {
    public List<MemberVO> selectMemberList() throws Exception;
}


