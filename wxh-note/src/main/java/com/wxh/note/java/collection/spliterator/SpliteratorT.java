package com.wxh.note.java.collection.spliterator;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * <p>Description: spliterator 测试类</p>
 *
 * @author weixuhui
 *
 * @date 2018年5月29日 下午2:46:53
 */
public class SpliteratorT {
	
	final static String PROVERBS = "I LOVE COFFEE BABE";
	
	public static void main(String[] args) {
		System.out.println("countWordsIteratively:" + countWordsIteratively(PROVERBS));
		Stream<Character> stream = IntStream.range(0, PROVERBS.length()).mapToObj(PROVERBS::charAt);
		System.out.println("countWordsWithStream:" + countWordsWithStream(stream));
		Stream<Character> parallelStream = IntStream.range(0, PROVERBS.length()).mapToObj(PROVERBS::charAt).parallel();
		System.out.println("countWordsWithStream parallel:" + countWordsWithStream(parallelStream));
	}
	
	public static int countWordsIteratively(String s) {
		int counter = 0;
		boolean lastSpace = true;
		for(char c : s.toCharArray()) {
			if(Character.isWhitespace(c)) {
				lastSpace = true;
			} else {
				if(lastSpace) counter++;
				lastSpace = false;
			}
		}
		return counter;
	}
	
	public static int countWordsWithStream(Stream<Character> stream) {
		
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
		
		return wordCounter.getCounter();
	}
	
	public 
	
	@Data
	@AllArgsConstructor
	static class WordCounter{
		
		private final int counter;
		
		private final boolean lastSpace;
		
		public WordCounter accumulate(Character c) {
			if(Character.isWhitespace(c)) {
				return lastSpace ? this : new WordCounter(counter, true);
			} else {
				return lastSpace ? new WordCounter(counter + 1, false) : this;
			}
		}
		
		public WordCounter combine(WordCounter wordCounter) {
			return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
		}
	}

}
