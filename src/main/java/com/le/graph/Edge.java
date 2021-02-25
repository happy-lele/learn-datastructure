package com.le.graph;

import lombok.Data;

/**
 * @Author happy_le
 * @date 2021/1/16 下午8:11
 */
@Data
public class Edge {
    // 边上的权重
    private int weight;
    //边的起始定点
    private Node from;
    //边的达到定点
    private Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
