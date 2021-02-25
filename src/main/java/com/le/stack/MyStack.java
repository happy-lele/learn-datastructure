package com.le.stack;

/**
 * @Author happy_le
 * @date 2021/1/11 下午4:41
 */
public interface MyStack<T> {

    public void push(T o);

    public T pop();

    public T peek();

    public boolean isEmpty();
}
