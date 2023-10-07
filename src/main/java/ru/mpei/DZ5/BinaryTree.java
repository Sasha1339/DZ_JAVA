package ru.mpei.DZ5;

import java.util.Objects;

public class BinaryTree<T extends Comparable<T>> {
    public BinaryTree(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    private T value;
    BinaryTree<T> smallBinaryThree = null;
    BinaryTree<T> bigBinaryThree = null;



    public int add(T value){
        if (this.value.compareTo(value) < 0){
            if (bigBinaryThree == null){
                bigBinaryThree = new BinaryTree(value);
            }else {
                bigBinaryThree.add(value);
            }
            return 1;
        } else if (this.value.compareTo(value) > 0) {
            if (smallBinaryThree == null){
                smallBinaryThree = new BinaryTree(value);
            }else {
                smallBinaryThree.add(value);
            }
            return 1;
        } else {
            return 0;
        }
    }

    public T findSmall(){
        if (this.smallBinaryThree != null && this.smallBinaryThree.smallBinaryThree == null){
            T value = this.smallBinaryThree.value;
            this.smallBinaryThree = null;
            return value;
        }else{
            return this.smallBinaryThree.findSmall();
        }
    }

    public int remove(T value){
        if (this.bigBinaryThree != null && this.bigBinaryThree.value.equals(value)){
            if (this.bigBinaryThree.bigBinaryThree == null && this.bigBinaryThree.smallBinaryThree == null){
                this.bigBinaryThree = null;
                return 1;
            }
        }else if(this.smallBinaryThree != null && this.smallBinaryThree.value.equals(value)){
            if (this.smallBinaryThree.bigBinaryThree == null && this.smallBinaryThree.smallBinaryThree == null){
                this.smallBinaryThree = null;
                return 1;
            }
        }
        if (this.value.equals(value)){
            if (this.bigBinaryThree != null && this.smallBinaryThree != null){
                if (this.bigBinaryThree.smallBinaryThree == null){
                    this.value = this.bigBinaryThree.value;
                    this.bigBinaryThree = null;
                }else{
                    this.value = this.bigBinaryThree.findSmall();
                }
            }
            else if (this.bigBinaryThree != null){
                this.value = this.bigBinaryThree.value;
                BinaryTree<T> linkBig = this.bigBinaryThree.bigBinaryThree;
                BinaryTree<T> linkSmall = this.bigBinaryThree.smallBinaryThree;
                this.bigBinaryThree = linkBig;
                this.smallBinaryThree = linkSmall;
            }
            else if (this.smallBinaryThree != null){
                this.value = this.smallBinaryThree.value;
                BinaryTree<T> linkBig = this.smallBinaryThree.bigBinaryThree;
                BinaryTree<T> linkSmall = this.smallBinaryThree.smallBinaryThree;
                this.bigBinaryThree = linkBig;
                this.smallBinaryThree = linkSmall;
            }
        }else if (this.value.compareTo(value) < 0){
            this.bigBinaryThree.remove(value);
        }else if (this.value.compareTo(value) > 0){
            this.smallBinaryThree.remove(value);
        }else{
            return 0;
        }
        return 1;
    }

    public int size(){
       if (bigBinaryThree != null && smallBinaryThree != null) {
           return bigBinaryThree.size() + smallBinaryThree.size() + 1;
       } else if (bigBinaryThree != null){
           return bigBinaryThree.size() + 1;
       } else if (smallBinaryThree != null){
           return smallBinaryThree.size() + 1;
       } else{
           return 1;
       }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTree<?> that = (BinaryTree<?>) o;
        return Objects.equals(value, that.value) && Objects.equals(smallBinaryThree, that.smallBinaryThree) && Objects.equals(bigBinaryThree, that.bigBinaryThree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, smallBinaryThree, bigBinaryThree);
    }


    @Override
    public String toString() {
        return ""+value;
    }


}
