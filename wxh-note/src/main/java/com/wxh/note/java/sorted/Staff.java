package com.wxh.note.java.sorted;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Staff {

	private Integer staffId;
	private String name;
	private String sex;
	private String role;
	private String workType;
	
	public boolean isMan() {
		return "man".equals(sex);
	}
	
	public boolean isLeader() {
		return "leader".equals(role);
	}
	
	public boolean isFullTime() {
		return  "full-time".equals(workType);
	}
}
