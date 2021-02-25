package com.le.stack;

import java.util.ArrayList;
import java.util.List;

public class StackSort {
	
	public static List<Integer> sort(List<Integer> list){
		MyStack<Integer> 
			left = new ArrayStack<>(),
			right  = new ArrayStack<>();
		
		for(int i : list) {
			accept(left, right, i);
		}
		
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		
		List<Integer> ret = new ArrayList<>();
		while(!right.isEmpty()) {
			ret.add(right.pop());
		}
		
		return ret;
	}
	
	
	private static void accept(MyStack<Integer> left, MyStack<Integer> right, int v) {
		while(!left.isEmpty() && left.peek() > v) {
			right.push(left.pop());
		}
		while(!right.isEmpty() && right.peek() < v) {
			left.push(right.pop());
		}
		
		left.push(v);		
	}
	
	
}
