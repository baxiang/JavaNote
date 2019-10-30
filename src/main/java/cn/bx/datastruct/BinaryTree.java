package cn.bx.datastruct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree <T>{
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;
    private T data;

    public BinaryTree() {
    }
    public BinaryTree(T  data) {
        this(null, data,null);
    }
    public BinaryTree(BinaryTree<T> leftChild,T data, BinaryTree<T> rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }
    public T getData() {
        return data;
    }
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    public BinaryTree<T> getRightChild() {
        return rightChild;
    }


   public  static void preTraversal(BinaryTree node) {
        if (node != null) {
            System.out.print(node.getData().toString());
            preTraversal(node.getLeftChild());
            preTraversal(node.getRightChild());
        }
    }

    public  static void traversal(BinaryTree node) {
        if (node != null) {
            preTraversal(node.getLeftChild());
            System.out.print(node.getData().toString());
            preTraversal(node.getRightChild());
        }
    }


    public  static void postTraversal(BinaryTree node) {
        if (node != null) {
            preTraversal(node.getLeftChild());
            preTraversal(node.getRightChild());
            System.out.print(node.getData().toString());
        }
    }


    public static void preTraversalIteration(BinaryTree node) {
            // 创建一个栈
            Stack<BinaryTree> mStack = new Stack<>();
            while (true) {
                while (node != null) { // 非叶子结点的子树
                    // 前序遍历，先访问根结点
                    System.out.print(node.getData().toString());
                    // 将当前结点压入栈
                    mStack.push(node);
                    // 对左子树继续进行前序遍历
                    node=node.getLeftChild();
                }
                if (mStack.isEmpty()) {
                    //所有元素已遍历完成
                    break;
                }
                // 弹出栈顶结点
                node=mStack.pop();
                // 右子树前序遍历
                node=node.getRightChild();
            }
    }

    /**
     * 中序遍历-迭代实现
     * @param node
     */
    public static void TraversalIteration(BinaryTree node) {
        // 创建一个栈
        Stack<BinaryTree> mStack = new Stack<>();
        while (true) {
            while (node != null) { // 非叶子结点的子树
                // 将当前结点压入栈
                mStack.push(node);
                // 对左子树继续进行中序遍历
                node=node.getLeftChild();
            }

            if (mStack.isEmpty()) {
                //所有元素已遍历完成
                break;
            }
            // 弹出栈顶结点
            node=mStack.pop();
            // 中序遍历，访问根结点
            System.out.print(node.getData().toString());
            // 右子树中序遍历
            node=node.getRightChild();
        }
    }

    /**
     * 后序遍历-迭代实现
     * @param node
     */
    public static void postTraversalIteration(BinaryTree node) {
        // 创建一个栈
        Stack<BinaryTree> mStack = new Stack<>();
        while (true) {
            if (node != null) {
                //当前结点非空，压入栈
                mStack.push(node);
                // 左子树继续遍历
                node=node.getLeftChild();
            }else {
                // 左子树为空

                if(mStack.isEmpty()){
                    return;
                }

                if (mStack.lastElement().getRightChild() == null) {
                    // 栈顶元素右子树为空，则当前结点为叶子结点，输出
                    node=mStack.pop();
                    System.out.print(node.getData().toString());
                    while (node == mStack.lastElement().getRightChild()) {
                        System.out.print(mStack.lastElement().getData().toString());
                        node=mStack.pop();
                        if (mStack.isEmpty()) {
                            break;
                        }
                    }
                }

                if (!mStack.isEmpty()) {
                    node=mStack.lastElement().getRightChild();
                }else {
                    node=null;
                }
            }
        }
    }


   public static void levelTraversal(BinaryTree node) {
        //创建队列
        Queue<BinaryTree> mNodeQueue = new LinkedList<>();
        // 根结点加入队列
        mNodeQueue.add(node);

       BinaryTree temp;

        while (!mNodeQueue.isEmpty()) {
            //元素出队列
            temp=mNodeQueue.poll();
            //输出
            System.out.print(temp.getData().toString());
            if (temp.getLeftChild() != null) {
                // 左子树入队列
                mNodeQueue.add(temp.getLeftChild());
            }

            if (temp.getRightChild() != null) {
                //右子树入队列
                mNodeQueue.add(temp.getRightChild());
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree<String> nodeH = new BinaryTree<>("H");
        BinaryTree<String> nodeG = new BinaryTree<>("G");

        BinaryTree<String> nodeF = new BinaryTree<>(nodeH, "F", null);
        BinaryTree<String> nodeE = new BinaryTree<>(nodeG, "E", null);
        BinaryTree<String> nodeD = new BinaryTree<>("D");

        BinaryTree<String> nodeC = new BinaryTree<>(null, "C", nodeF);
        BinaryTree<String> nodeB = new BinaryTree<>(nodeD, "B", nodeE);
        BinaryTree<String> root = new BinaryTree<>(nodeB, "A", nodeC);

        preTraversal(root);
        System.out.println("");
        preTraversalIteration(root);
        System.out.println("");
        traversal(root);
        System.out.println("");
        postTraversal(root);
        System.out.println("");
        levelTraversal(root);
    }
}
