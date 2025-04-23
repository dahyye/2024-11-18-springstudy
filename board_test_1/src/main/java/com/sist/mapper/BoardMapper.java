package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface BoardMapper {

	@Select("SELECT group_id, group_name, profile_img, description, capacity, is_public, create_by,create_at, num "
			+ "FROM (SELECT group_id, group_name, profile_img, description, capacity, is_public, create_by,create_at, rownum as num "
			+ "FROM (SELECT group_id, group_name, profile_img, description, capacity, is_public, create_by,create_at "
			+ "FROM p_group ORDER BY group_id))")
	public List<GroupVO> groupListData();
	
	@Select("SELECT feed_no,group_no,user_id,title,filecount,regdate, num "
			+ "FROM (SELECT feed_no,group_no,user_id,title,filecount,regdate, rownum as num "
			+ "FROM (SELECT feed_no,group_no,user_id,title,filecount,regdate "
			+ "FROM p_board ORDER BY feed_no ASC)) "
			+ "WHERE group_no=#{group_no}")
	public List<BoardVO> boardListData(int group_no);
	
	@Insert("INSERT INTO p_board VALUES(p_feedno_seq.nextval,#{group_no},#{user_id},#{title},#{content},1,SYSDATE,SYSDATE)")
	public void boardInsertData(BoardVO vo);
	
	
	
	
	@Insert("INSERT INTO p_fileInf VALUES(#{fno},#{filename},#{filesize})")
	public void boardFileInsert(FeedFileInfoVO vo);
	   
	@Select("SELECT * FROM p_fileInf WHERE fno=#{fno}")
	public List<FeedFileInfoVO> fileListData(int no);
}
