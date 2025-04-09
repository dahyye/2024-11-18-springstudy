package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface EmpMapper {
	@Select("SELECT empno,ename,job,sal,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
			+ "FROM emp")
	public List<EmpVO> empListData();
	
	@Select("SELECT * FROM dept")
	public List<deptVO> deptListData();
	
}
