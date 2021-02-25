package com.le.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @Author happy_le
 * @date 2021/1/16 下午8:11
 */
public class CodeGraph {


    private void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();

        Set<Node> visitedNode = new HashSet<>();

        queue.add(node);
        visitedNode.add(node);

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            System.out.println(node.getValue());

            List<Node> nextNodes = curNode.getNextNodes();
            for (Node nextNode : nextNodes) {
                if (!visitedNode.contains(nextNode)) {
                    queue.add(nextNode);
                    visitedNode.add(nextNode);
                }
            }

        }

    }


    private void dfs(Node node) {
        Stack<Node> stack = new Stack<>();

        Set<Node> visitedNode = new HashSet<>();

        stack.push(node);
        visitedNode.add(node);

        while (!stack.empty()) {
            Node cur = stack.pop();
            for (Node nextNode : cur.getNextNodes()) {
                if (!visitedNode.contains(nextNode)) {
                    stack.push(cur);
                    stack.push(nextNode);

                    System.out.println(nextNode.getValue());
                    visitedNode.add(nextNode);

                    break;

                }
            }

        }
    }



    private static List<Node> topologySort(Graph graph) {
        Queue<Node> zeroInQueue = new LinkedList<>();

        Map<Node, Integer> inMap = new HashMap<>();

        for (Node node : graph.getNodeMap().values()) {
            if (node.getIn() == 0) {
                zeroInQueue.add(node);
            }
            inMap.put(node, node.getIn());
        }

        List<Node> result = new ArrayList<>();

        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);

            for (Node nextNode : cur.getNextNodes()) {
                inMap.put(nextNode, inMap.get(nextNode) - 1);

                if (inMap.get(nextNode) == 0) {
                    zeroInQueue.add(nextNode);
                }

            }

        }

        return result;

    }


    private Set<Edge> prim (Graph graph) {
        Set<Edge> result = new HashSet<>();

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());

        Set<Node> nodeSet = new HashSet<>();

        for (Node node : graph.getNodeMap().values()) {
            if (!nodeSet.contains(node)) {
                List<Edge> edges = graph.getEdges(node);
                edges.forEach(e -> priorityQueue.add(e));

                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node to = edge.getTo();
                    if(!nodeSet.contains(to)) {
                        List<Edge> edgeList = graph.getEdges(to);
                        edgeList.forEach(e -> priorityQueue.add(e));
                        nodeSet.add(to);
                        result.add(edge);

                    }
                }

            }
        }

        return result;

    }


    private static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }


}
