package com.le.graph;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @Author happy_le
 * @date 2021/1/16 下午8:11
 */
public class Node {
    //顶点的值
    private int value;
    //入度
    private int in;
    //出度
    private int out;

    //从当前节点出发的领接点@Data
    private List<Node> nextNodes;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nextNodes = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public List<Node> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(List<Node> nextNodes) {
        this.nextNodes = nextNodes;
    }
}
