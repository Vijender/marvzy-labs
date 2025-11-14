package trees;

import java.util.ArrayList;

public class MinHeap {

    private final ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return i * 2 + 1;
    }
    private int right(int i) {
        return i * 2 + 2;
    }

    private void insert( int i ) {

        heap.add(i);
        int index = heap.size() - 1;

        //Heapify --  8 -- 6 -- 2
        while (index > 0 && heap.get(index) < heap.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }

    }

    private void swap( int i, int j ) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void minHeapify( int i ) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        //   10 2 4 5 6 8
        //   10 2 4
        //   4  2 10
        //Itr 2
        //  i = 2, smallest = 4, l = 1 -> 2, r = 2 -> 10

        if (l < heap.size() &&  heap.get(l) < heap.get(smallest)) {
            smallest = l;
        }
        if (r < heap.size() && heap.get(r) < heap.get(smallest)) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }

    }

    public int extractMin() {
        int min = heap.getFirst();
        heap.set(0, heap.getLast());
        heap.removeLast();

        if (!heap.isEmpty()) {
            minHeapify(0);
        }

        return min;
    }


    static  void main() {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(6);
        minHeap.insert(7);
        System.out.println(minHeap.extractMin());
    }

}
