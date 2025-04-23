package com.sist.vo;

import lombok.Data;
import java.util.*;
@Data
public class GroupVO {
	private int group_id, capacity;
	private String group_name, profile_img, description, is_public;
	private Date created_by, created_at;
}
