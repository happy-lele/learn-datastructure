package com.le.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author happy_le
 * @date 2021/1/17 下午4:45
 */
public class CodeTest {
    private Random random = new Random();

    private List<Integer> getRandomList() {
        return new ArrayList<Integer>(IntStream.range(0, 1 + random.nextInt(15)).map(i -> random.nextInt(20)).boxed().collect(Collectors.toList()));
    }

    public void test() {
        List<Integer> list = getRandomList();
        System.out.println(list);

        BinaryTree tree = new BinaryTree();
        list.forEach(tree::insert);
        System.out.println(tree.inorderVisit());
    }
    public static void main(String[] args) {
        CodeTest codeTest = new CodeTest();
        codeTest.test();
    }
}
