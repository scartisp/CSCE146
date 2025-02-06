//Simion Cartis

// parent must be smaller in min heap;
public class MinHeap<T extends Comparable<T>> {
	private T[] heap;
	public static final int DEF_SIZE = 128;
	private int size;

	public MinHeap() {
		init(DEF_SIZE);
	}

	public MinHeap(int size) {
		init(size);
	}

	private void init(int size) {
		if (size > 1) {
			heap = (T[]) (new Comparable[size]);
		} else
			heap = (T[]) (new Comparable[DEF_SIZE]);
	}

	public void add(T aData) {
		if (size >= heap.length)
			return;
		heap[size] = aData;
		this.bubbleUp();
		size++;
	}

	private void bubbleUp() {
		int index = size;
		while (index > 0 && heap[p(index)].compareTo(heap[index]) > 0) {// assuming added object is greater than parent
			T temp = heap[p(index)];// while loop logic: cookingT is greater than aO.cookingT, returns a 1
			heap[p(index)] = heap[index];// 1 is greater than zero, switch, repeat until reach head
			heap[index] = temp;
			index = p(index);
		}
	}

	private int p(int index) {
		return (index - 1) / 2;
	}

	private int l(int index) {
		return index * 2 + 1;
	}

	private int r(int index) {
		return index * 2 + 2;
	}

	public T remove() {
		if (size <= 0)
			return null;
		T ret = heap[0];
		heap[0] = heap[size - 1];
		size--;
		this.bubbleDown();
		return ret;
	}

	private void bubbleDown() {
		int index = 0;
		while (l(index) < size) {
			int smallestIndex = l(index);
			if (r(index) < size && heap[l(index)].compareTo(heap[r(index)]) > 0) {
				smallestIndex = r(index);
			}
			if (heap[index].compareTo(heap[smallestIndex]) > 0) {
				T temp = heap[index];
				heap[index] = heap[smallestIndex];
				heap[smallestIndex] = temp;
			} else
				break;
			index = smallestIndex;
		}
	}

	public T peek() {
		return heap[0];
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(heap[i]);
		}
	}
	public void heapSort(T[] array) {
		if(array == null)
			return;
		MinHeap<T> mHeap = new MinHeap<T>(array.length);
		for(int i = 0;i< array.length;i++) {
			mHeap.add(array[1]);
		}
		for(int i = 0; i< array.length;i++) {
			array[i] = mHeap.remove();
		}
	}
}
