package com.le.stack;

/**
 * @Author happy_le
 * @date 2021/1/11 下午5:09
 */
public class StackTest {

    public static void main(String[] args) {
//       testArrayStack();
        testRecurisiveStack();
    }

    private static void testRecurisiveStack() {
        RecurisiveStack<Integer> stack = new RecurisiveStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        stack.push(3);

        System.out.println(stack.toString());


        System.out.println(stack.isEmpty());
    }

    private static void testArrayStack() {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.toString());

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        System.out.println(stack.isEmpty());
    }
}
