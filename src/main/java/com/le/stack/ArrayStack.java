package com.le.stack;

/**
 * @Author happy_le
 * @date 2021/1/11 下午4:31
 */
public class ArrayStack<T> implements MyStack<T>{
    private T[] array = (T[]) new Object[1024];

    private int nextEmptyIndex = 0;

    public void push(T o) {
        array[nextEmptyIndex++] = o;
    }

    // 出栈
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T ret = peek();
        array[--nextEmptyIndex] = null;
        return ret;
    }

    // 返回栈顶元素
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return array[nextEmptyIndex - 1];
    }

    public boolean isEmpty() {
        return nextEmptyIndex == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nextEmptyIndex; i++) {
            sb.append(array[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
