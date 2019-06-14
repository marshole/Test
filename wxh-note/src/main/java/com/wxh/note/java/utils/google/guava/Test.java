package com.wxh.note.java.utils.google.guava;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 
 * <p>Description: guava 工具包使用案例 </p>
 *
 * @author weixuhui
 *
 * @date 2017年12月11日 下午8:48:56
 */
public class Test {

	public static void main(String[] args) {

		List<Integer> listA = Lists.newArrayList(1, 2, 3, 4);
		List<Integer> listB = Lists.newArrayList(4, 3, 2, 1,null);


		boolean flag = StringUtils.equals(
				listA.stream().filter(Objects::nonNull).sorted().map(p -> p.toString()).collect(Collectors.joining(",")),
				listB.stream().filter(Objects::nonNull).sorted().map(p -> p.toString()).collect(Collectors.joining(",")));

		System.out.println(flag);
	}
}
