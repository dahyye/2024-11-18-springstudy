package com.sist.vo;
import java.util.*;
/*
 USERID     NOT NULL VARCHAR2(20)  
USERNAME   NOT NULL VARCHAR2(52)  
USERPWD    NOT NULL VARCHAR2(100) 
ENABLE              NUMBER(1)     
SEX                 CHAR(4)       
BIRTHDAY   NOT NULL VARCHAR2(20)  
EMAIL               VARCHAR2(100) 
POST       NOT NULL VARCHAR2(100) 
ADDR1      NOT NULL VARCHAR2(100) 
ADDR2               VARCHAR2(100) 
PHONE               VARCHAR2(20)  
CONTENT             CLOB          
REGDATE             DATE          
MODIFYDATA          DATE          
LASTLOGIN           DATE    

 
USERNAME  NOT NULL VARCHAR2(64) 
SERIES    NOT NULL VARCHAR2(64) 
TOKEN     NOT NULL VARCHAR2(64) 
LAST_USED NOT NULL TIMESTAMP(6) 
 */

import lombok.Data;

@Data
public class MemberVO {
	private int enable; // 1(활성), 0(휴먼)
	private String userid, username,userpwd,sex,birthday,email,
					post,addr1,addr2,phone,content,authority,msg,phone1,phone2;
	private Date regdate,modifydata,lastlogin;
}
