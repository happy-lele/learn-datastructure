package com.le.stack;

/**
 * @Author happy_le
 * @date 2021/1/11 下午5:20
 */
public class RecurisiveStack<T> implements MyStack<T>{
    private T top;

    private RecurisiveStack<T> remain;

    public RecurisiveStack() {
    }

    public RecurisiveStack(T top, RecurisiveStack<T> remain) {
        this.top = top;
        this.remain = remain;
    }

    public void push(T o) {
        if (top != null) {
            RecurisiveStack<T> self = new RecurisiveStack<T>(top, remain);
            top = o;
            remain = self;
        } else {
            if (remain == null) {
                top = o;
            } else {
                remain.push(o);
            }
        }
    }

    public T pop() {
        if (top != null) {
            T ret = top;
            top = null;
            return ret;
        } else {
            if (remain == null) {
                return null;
            } else {
                return remain.pop();
            }
        }
    }

    public T peek() {
        if (top != null) {
            return top;
        } else {
            if (remain == null) {
                return null;
            } else {
                return remain.peek();
            }
        }
    }

    public boolean isEmpty() {
        return top == null && (remain == null || remain.isEmpty());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (remain != null) {
            sb.append(remain.toString());
        }

        if (top != null) {
            sb.append(" ").append(top);
        }

        return sb.toString().trim();
    }
}
