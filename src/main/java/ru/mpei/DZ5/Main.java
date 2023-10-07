package ru.mpei.DZ5;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> binaryTree = new BinaryTree<>(15);
        binaryTree.add(7);
        binaryTree.add(8);
        binaryTree.add(9);
        binaryTree.add(6);
        binaryTree.add(30);
        binaryTree.add(20);
        binaryTree.add(19);
        binaryTree.add(40);
        binaryTree.add(25);

        System.out.println("////////////////////////////////////////////////////////////////////////////");

        printBinaryTree(binaryTree, 0, 5);
        System.out.println("////////////////////////////////////////////////////////////////////////////");
        binaryTree.remove(20);
        printBinaryTree(binaryTree, 0, 5);

    }

    public static void printBinaryTree(BinaryTree<?> root, int space, int height)
    {
        // Базовый вариант
        if (root == null) {
            return;
        }

        // увеличить расстояние между уровнями
        space += height;

        // сначала напечатать правый дочерний элемент
        printBinaryTree(root.bigBinaryThree, space, height);
        System.out.println();

        // вывести текущий узел после заполнения пробелами
        for (int i = height; i < space; i++) {
            System.out.print(' ');
        }

        System.out.print(root.getValue()+"<");

        // напечатать левый дочерний элемент
        System.out.println();
        printBinaryTree(root.smallBinaryThree, space, height);
    }

}
