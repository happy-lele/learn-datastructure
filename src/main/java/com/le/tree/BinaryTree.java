package com.le.tree;

import java.util.Optional;

/**
 * @Author happy_le
 * @date 2021/1/16 下午8:12
 */
public class BinaryTree {

    private Integer value;
    private Optional<BinaryTree> left = Optional.empty();
    private Optional<BinaryTree> right = Optional.empty();
    private BinaryTree parent;
    private int height = 0;

    public BinaryTree() {}

    public BinaryTree(int v) {
        this.value = v;
    }

    public void setLeft(int v) {
        setLeft(new BinaryTree(v));
    }

    private void refreshHeight() {

    }

    public void setLeft(BinaryTree node) {
        if (node == null && left.isPresent()) {
            left.get().parent = null;
        }
        this.left = Optional.ofNullable(node);
        if (left.isPresent()) {
            left.get().parent = this;
        }
        refreshHeight();
    }

    public void setRight(int v) {
        setRight(new BinaryTree(v));
    }

    public void setRight(BinaryTree node) {
        if (node == null && right.isPresent()) {
            right.get().parent = null;
        }
        this.right = Optional.ofNullable(node);
        if (right.isPresent()) {
            right.get().parent = this;
        }
        refreshHeight();
    }

    public Integer getValue() {
        return value;
    }

    public int getHeight() {
        return height;
    }

    public Optional<BinaryTree> getLeft() {
        return left;
    }

    public Optional<BinaryTree> getRight() {
        return right;
    }

    public BinaryTree getParent() {
        return parent;
    }

    public void insert(int v) {
        if (value == null) {
            this.value = v;
            return ;
        }

        if (v == this.value) {
            throw new RuntimeException("duplicate value");
        }

        if (v < this.value) {
            if (left.isPresent()) {
                left.get().insert(v);
            } else {
                this.setLeft(v);
            }
        } else {
            if (right.isPresent()) {
                right.get().insert(v);
            } else {
                this.setRight(v);
            }
        }
    }

    public void delete(int v) {
        BinaryTree node = search(v);
        if (node != null) {
            node.delete();
        }
    }

    public void delete() {

    }

    private boolean isLeft() {
        if (parent == null) {
            return false;
        }
        return parent.left.isPresent() && parent.left.get() == this;
    }

    private boolean isRight() {
        if (parent == null) {
            return false;
        }
        return parent.right.isPresent() && parent.right.get() == this;
    }

    private boolean isRoot() {
        return parent == null;
    }

    private boolean isLeaf() {
        return !left.isPresent() && !right.isPresent();
    }

    public String inorderVisit() {
        StringBuilder sb = new StringBuilder();
//        left.map(node -> node.inorderVisit()).ifPresent(sb::append);
        left.map(BinaryTree::inorderVisit).ifPresent(sb::append);
        sb.append(" " + value);
        right.map(BinaryTree::inorderVisit).ifPresent(sb::append);

        return sb.toString();
    }

    public BinaryTree search(int v) {

        return null;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    public String toJson() {
        return "";
    }
}
