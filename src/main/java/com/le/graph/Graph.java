package com.le.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Data;

/**
 * @Author happy_le
 * @date 2021/1/16 下午8:11
 */
@Data
public class Graph {

    private HashSet<Edge> edges;

    private Map<Integer, Node> nodeMap;


    public Graph() {
        nodeMap = new HashMap<>();
        edges = new HashSet<>();
    }


    /**
     * 构建图
     *
     * @param matrix
     * @return
     */
    //[1,0,1]
    //[2,0,2]  // 权重， from ， to
    public static Graph createGraph(int[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            int weight = matrix[i][0];
            int from = matrix[i][1];
            int to = matrix[i][2];

            if (!graph.nodeMap.containsKey(from)) {
                graph.nodeMap.put(from, new Node(from));

            }
            if (!graph.nodeMap.containsKey(to)) {
                graph.nodeMap.put(to, new Node(to));
            }

            Node fromNode = graph.nodeMap.get(from);
            Node toNode = graph.nodeMap.get(to);

            fromNode.setOut(fromNode.getOut() + 1);
            fromNode.getNextNodes().add(toNode);


            toNode.setIn(toNode.getIn() + 1);

            //构建边
            Edge edge = new Edge(weight, fromNode, toNode);

            graph.edges.add(edge);
        }
        return graph;

    }



    /**
     * 根据顶点找到邻接边，从该顶点出发的边
     * @param node
     * @return
     */
    public List<Edge> getEdges(Node node) {
        return this.edges.stream().filter(a ->
                a.getFrom().getValue() == node.getValue() || a.getTo().getValue() == node.getValue())
                .collect(Collectors.toList());
    }

}
