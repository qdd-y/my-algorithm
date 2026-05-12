package cn.qdd.algorithm.heap;

import java.util.Arrays;

/**
 * @Author: qdd
 * @Description: MaxHeap
 * @DateTime: 2026/5/9 16:08
 **/
public class MaxHeap {
    int [] array;
    int size;
    int capacity;

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }


    private void heapify() {
        //(size-1)/2是最后一个非叶子节点的索引
        for (int i = (size - 1) / 2; i >= 0; i--) {
            down(i);
        }
    }
    //将父节点与左右孩子节点进行比较，如果父节点小于孩子节点，则交换位置，并继续向下调整
    private void down(int parent) {
        //公式算左右孩子的位置
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int max = parent;

        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) {
            swap(parent, max);
            down(max);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int peek(){
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        return array[0];
    }

    public int poll(){
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        int top = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return top;
    }

    public int pool(int index){
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    public void replace(int replaced){
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        array[0] = replaced;
        down(0);
    }

    public boolean offer(int offered){
        if (size == array.length){
           //扩容
            grow();
        }
        up(offered);
        size++;
        return true;
    }
    private void grow() {
        int newCapacity = size + (size >> 1); // 扩容为原来的1.5倍
        int[] newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public void up(int offered){
        int child = size;
        while(child > 0){
            int parent = (child -1) / 2;
            if (offered > array[parent]){
                array[child] = array[parent];
            }else {
                break;
            }
            child = parent;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(array);
        System.out.println(Arrays.toString(maxHeap.array));
    }
}
