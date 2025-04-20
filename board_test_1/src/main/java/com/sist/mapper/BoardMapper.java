package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface BoardMapper {
	@Select("SELECT feed_no,group_no,user_id,title,filecount,regdate, num "
			+ "FROM (SELECT feed_no,group_no,user_id,title,filecount,regdate, rownum as num "
			+ "FROM (SELECT feed_no,group_no,user_id,title,filecount,regdate "
			+ "FROM p_board ORDER BY feed_no ASC)) "
			+ "WHERE group_no=#{group_no}")
	public List<BoardVO> boardListData(int group_no);
	
	@Insert("INSERT INTO p_board VALUES(p_feedno_seq.nextval,#{group_no},#{user_id},#{title},#{content},1,SYSDATE,SYSDATE)")
	public void boardInsertData(BoardVO vo);
}
