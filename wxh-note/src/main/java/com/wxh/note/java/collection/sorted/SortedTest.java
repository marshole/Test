package com.wxh.note.java.collection.sorted;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;


public class SortedTest {
	
	public static void main(String[] args) {
		List<Staff> staffs = Lists.newArrayList(
				new Staff(1,"程成","man","staff","part-time"),
				new Staff(2,"刘沐华","man","staff","full-time"),
				new Staff(3,"聂鹏","man","leader","full-time"),
				new Staff(4,"李海霞","female","staff","part-time"),
				new Staff(5,"白丹宁","female","staff","full-time")
				);
		staffs = staffs.stream()
				.sorted(Comparator.comparing(Staff::getStaffId))
				.sorted(Comparator.comparing(staff -> !staff.isFullTime()))//全职靠前
				.sorted(Comparator.comparing(staff -> !staff.isMan()))//男性靠前
				.sorted(Comparator.comparing(staff -> !staff.isLeader()))//班长靠前
				.collect(Collectors.toList());
		
		staffs.forEach(staff->{
			System.out.println(staff.toString());
		});
	}

}

