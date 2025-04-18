package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface BoardMapper {
	@Select("SELECT feedno,groupno,user_id,title,filecount,regdate, num "
			+ "FROM (SELECT feedno,groupno,user_id,title,filecount,regdate, rownum as num "
			+ "FROM (SELECT feedno,groupno,user_id,title,filecount,regdate "
			+ "FROM p_board ORDER BY feedno ASC)) "
			+ "WHERE groupno=#{groupno}")
	public List<BoardVO> boardListData(int groupno);
}
