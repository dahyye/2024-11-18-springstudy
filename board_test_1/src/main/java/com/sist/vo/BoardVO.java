package com.sist.vo;
import java.util.*;
/*
FEEDNO              NUMBER         
GROUPNO    NOT NULL NUMBER         
USER_ID     NOT NULL VARCHAR2(200)  
TITLE       NOT NULL VARCHAR2(4000) 
CONTENT     NOT NULL CLOB           
FILECOUNT            NUMBER         
REGDATE              DATE           
UPDATE_TIME          DATE           

 */

import lombok.Data;

@Data
public class BoardVO {
	private int feedno, groupno,filecount;
	private String user_id,title,content,dbday;
	private Date regdate, update_time;
}
