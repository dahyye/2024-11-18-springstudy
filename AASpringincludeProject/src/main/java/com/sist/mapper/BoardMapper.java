package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BoardMapper {
	@Select("SELECT no,subject,name,hit,regdate,num "
		    +"FROM (SELECT no,subject,name,hit,regdate,rownum as num "
		    +"FROM (SELECT no,subject,name,hit,regdate "
		    +"FROM springReplyBoard2 ORDER BY no DESC)) "
		    +"WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	
	@Select("SELECT COUNT(*) FROM springReplyBoard2")
	public int boardRowCount();
	
	@Insert("INSERT INTO springReplyBoard2("
		     +"no,name,subject,content,pwd,group_id) "
		     +"VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#,"
		     +"(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard2))")
	public void boardInsert(BoardVO vo);
	
	//@Update(
	 
}
