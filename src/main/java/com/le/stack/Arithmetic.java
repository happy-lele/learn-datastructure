package com.le.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Arithmetic {
	
	enum Op{
		ADD("+", (a,b)->a+b, 1),
		MINUS("-", (a,b)->a-b, 1),
		TIMES("*", (a,b)->a*b, 2),
		DIVIDE("/", (a,b)->a/b, 2),
		POW("^", (a,b) -> (int)(Math.pow(a,b)), 3),
		LP("(", (a,b)->null, 0),
		RP(")", (a,b)->null, 0)
		;
		
		private final String token;
		private final BinaryOperator<Integer> fn;
		private final int priority;

		 Op(String token,  BinaryOperator<Integer> fn, int priority){
			this.token = token;
			this.fn = fn;
			this.priority = priority;
		}

		 
		public String getToken() {
			return token;
		}


		public int getPriority() {
			return priority;
		}

		public int eval(int v1, int v2) {
			return fn.apply(v1, v2);
		}

		
		public static Op of(String token) {
			for(Op op : Op.values()) {
				if (token.equals(op.getToken())) {
					return op;
				}
			}
			return null; 
		}
		
	}
	
	private static boolean isNumeric(String token) {
		try {
	        Integer.parseInt(token);
	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	}
	
	public static List<String> toSuffixExprs(List<String> infixExprs){
		List<String> ret = new ArrayList<>();
		MyStack<Op> stack = new ArrayStack<>();
		
		
		for (String token : infixExprs) {
			accept(token, stack, ret);
		}
		
		while(!stack.isEmpty()) {
			ret.add(stack.pop().getToken());
		}
		return ret;
	}
	
	private static void accept(String token, MyStack<Op> stack, List<String> suffixExprs){
		if (isNumeric(token)) {
			suffixExprs.add(token);
		}else {
			Op op = Op.of(token);
			if (stack.isEmpty() || op == Op.LP) {
				stack.push(op);
				return;
			}
			Op previousOp = stack.peek();
			if (op == Op.RP && previousOp == Op.LP) {
				stack.pop();//pop LP
				return;
			}else {
				if (op.getPriority() <= previousOp.getPriority()) {
					suffixExprs.add(stack.pop().getToken());
					accept(token, stack, suffixExprs);
				}else {
					stack.push(op);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param suffixExprs [1, 2,  + , 3, -]
	 * @return
	 */
	public static int evalSuffixExprs(List<String> suffixExprs) {
		MyStack<Integer> stack = new ArrayStack<>();
		for (String token : suffixExprs ) {
			if (isNumeric(token))  {//if num, push stack
				stack.push(Integer.valueOf(token));
			}else {//op
				Op op = Op.of(token);
				Integer v2 = stack.pop();
				Integer v1 = stack.pop();
				
				stack.push(op.eval(v1, v2));
			}
		}
		return stack.pop();
	}
	
	public static int eval(String expr) {
		List<String> exprs = Arrays.asList(expr.trim().split(" "));
		return evalSuffixExprs(toSuffixExprs(exprs));
	}
	
	
	public static void main(String[] args) {
		//String expr = " 1 + ( 2 + 3 )";
		String expr = " 2 + 1 - 3 * ( 8 * ( 2 + 1 * 1 ) + 4 ) * 1 - 5 * 2  ";
		List<String> exprs = Arrays.asList(expr.trim().split(" "));
		System.out.println(exprs);
		System.out.println(toSuffixExprs(exprs));
		System.out.println(evalSuffixExprs(toSuffixExprs(exprs)));
	}
}
