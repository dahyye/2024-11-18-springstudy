package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;


public interface MemberMapper {

  //아이디 존재여부
  @Select("SELECT COUNT(*) FROM project_member WHERE id=#{id}")
  public int memberIdCount(String id);
   
  @Select("SELECT id,pwd,name,sex FROM project_member WHERE id=#{id}")
  public MemberVO memberInfoData(String id);
}
