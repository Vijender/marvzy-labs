package trees;

import java.util.PriorityQueue;

public class HeapPriorityQueue {

    PriorityQueue<Integer>  minHeap = new PriorityQueue<>();
    PriorityQueue<Integer>  maxHeap  = new PriorityQueue<>();

    void main() {

        HeapPriorityQueue heap = new HeapPriorityQueue();

        heap.minHeap.add(11);
        heap.minHeap.add(2);
        heap.minHeap.add(3);
        heap.minHeap.add(4);

        System.out.println(heap.minHeap);


        heap.maxHeap.add(11);
        heap.maxHeap.add(2);
        heap.maxHeap.add(3);
        heap.maxHeap.add(4);

        System.out.println(heap.maxHeap);
    }
}
