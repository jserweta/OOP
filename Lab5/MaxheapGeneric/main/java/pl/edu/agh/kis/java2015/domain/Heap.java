package pl.edu.agh.kis.java2015.domain;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

	private int heapSize = 0;
    private ArrayList<T> tab = new ArrayList<T>();

    public ArrayList<T> get_list(){
        return tab;
    }

	public void insert(T value) {
		int currentIndex = heapSize;
		int parentIndex = parentIndex(currentIndex);
		tab.add(value);
		while( isChildGreaterThanParent(currentIndex, parentIndex) ) {
			swapElements(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = parentIndex(currentIndex);
		}
		heapSize++;
	}

	public boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
        if(tab.get(currentIndex).compareTo(tab.get(parentIndex)) > 0) return true;
        else return false;
	}

	public void swapElements(int currentIndex, int parentIndex) {
		T parentValue = parentValue(currentIndex);
		T currentValue = tab.get(currentIndex);
		tab.set(parentIndex, currentValue);
		tab.set(currentIndex, parentValue);
	}

	public T parentValue(int currentIndex) {
		T parentValue = tab.get(parentIndex(currentIndex));
		return parentValue;
	}

	public int parentIndex(int currentIndex) {
		return currentIndex/2;
	}

	public int size() {
	    return heapSize ;
	}

	public T top() {
	    return tab.get(0);
	}

    public int leftIndex(int currentIndex){
        return 2*currentIndex+1;
    }
    public int rightIndex(int currentIndex){
        return 2*currentIndex+2;
    }

	public T extractMax(){
        T max = tab.get(0);
        tab.set(0,tab.get(heapSize-1));
        tab.remove(heapSize-1);
        heapSize--;
        heapify(tab,0);
        return max;
    }

    public void deleteMax() {
        tab.set(0,tab.get(heapSize-1));
        tab.remove(heapSize-1);
        heapSize--;
        heapify(tab,0);
    }
    public void replace(T element){
        tab.set(0,element);
        heapify(tab,0);
    }

    public void heapify(ArrayList<T> list , int i){
        int l = leftIndex(i);
        int r = rightIndex(i);
        int largest = 0;
        if(l < list.size() && (list.get(l).compareTo(list.get(i))) > 0) largest = l;
        else largest = i;

        if(r < list.size() && (list.get(r).compareTo(list.get(largest))) > 0) largest = r;

        if(largest != i){
            T LargestValue = list.get(largest);
            T IValue = list.get(i);
            list.set(largest,IValue);
            list.set(i,LargestValue);

            heapify(list,largest);
        }
    }

    public Heap merge(Heap First, Heap Second){
        ArrayList<T> First_list = First.get_list();
        ArrayList<T> Second_list = Second.get_list();
        Heap heap_result = new Heap();

        for(T d:First_list) heap_result.insert(d);
        for(T d:Second_list) heap_result.insert(d);

        return heap_result;
    }

    public void meld(ArrayList<T> list){
        for(T d : list){
            this.insert(d);
        }
    }

}
