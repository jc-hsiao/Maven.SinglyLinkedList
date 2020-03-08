package com.zipcodewilmington.singlylinkedlist;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {

    private int size = 0;
    private SinglyNode<T> head;
    private SinglyNode<T> tail;

    public SinglyLinkedList(){}

    private static class SinglyNode<T> {
        T val;
        SinglyLinkedList.SinglyNode<T> next;
        SinglyNode(T element, SinglyLinkedList.SinglyNode<T> next) {
            this.val = element;
            this.next = next;
        }
    }

    //add -- add an element to the list
    public void add(T newElement){
        if( size == 0 ){
            head = new SinglyNode<T>(newElement,tail);
            tail = head;
        }else{
            SinglyNode<T> newNode = new SinglyNode<T>(newElement, null);
            tail.next =  newNode;
            tail = newNode;
        }
        size++;
    }

    //    remove -- remove an element (specified by numeric index) from the list
    public boolean remove(int index){
        int counter=0;
        if( size == 0 || index < 0 || index >= size ){
            return false;
        }else{
            if(index == 0){//wants to remove head
                if(head.next==null)
                    tail = null;
                head = head.next;
            }
            for (SinglyLinkedList.SinglyNode<T> x = head; x != null; x = x.next) {
                if (counter==index-1) {
                    unlinkNext(x);
                    size--;
                    return true;
                }
                counter++;
            }
        }
        size--;
        return true;
    }

    public void unlinkNext(SinglyNode<T> node){
        if(node.next.next == null) //when the node is second last
            tail=node;
        node.next = node.next.next;
    }

    //    contains -- returns true if the element is in the list, false otherwise
    public boolean contains(T val){
        return find(val) != -1;
    }

    //    find -- returns the element's index if it is in the list, -1 otherwise
    public int find(T val){
        int counter = 0;
        for (SinglyLinkedList.SinglyNode<T> x = head; x != null; x = x.next) {
            if(val == x.val){
                return counter;
            }
            counter++;
        }
        return -1;
    }

    protected SinglyNode<T> getNode(int index){
        int counter = 0;
        for (SinglyLinkedList.SinglyNode<T> x = head; x != null; x = x.next) {
            if(counter == index)
                return x;
            counter++;
        }
        return null;
    }

    public void swap(int index1, int index2){
        SinglyNode<T> node1 = getNode(index1);
        SinglyNode<T> node2 = getNode(index2);
        T v1 = node1.val;
        node1.val = node2.val;
        node2.val = v1;
    }

    //    size -- returns the current size of the list
    public int size(){
        return size;
    }

    //    get -- returns the element at the specified index
    public T get(int index){
        int counter = 0;
        for (SinglyLinkedList.SinglyNode<T> x = head; x != null; x = x.next) {
            if(counter == index)
                return x.val;
            counter++;
        }
        return null;
    }

    //    copy -- returns a new linked list containing the same values (look up deep versus shallow copy)
    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
        for (SinglyLinkedList.SinglyNode<T> x = head; x != null; x = x.next) {
            newList.add(x.val);//since x.val is not getting 'cloned', this is shallow copy.
        }
        return newList;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (SinglyLinkedList.SinglyNode<T> x = head; x != null; x = x.next) {
            s.append(x.val).append("\n");
        }
        return s.toString();
    }

    public void sort(){
        int size = this.size;
        for (int i = size/2-1; i >= 0; i--)
            heapify(this, size, i);

        //extract elements from heap
        for (int i=size-1; i>=0; i--) {
            // Move current root to end
            swap(0,i);
            heapify(this, i, 0);
        }
    }


    void heapify(SinglyLinkedList<T> list, int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        if (l < n && list.get(l).compareTo(list.get(largest))>0 )
            largest = l;

        if (r < n && list.get(r).compareTo(list.get(largest))>0)
            largest = r;

        if (largest != i) {
            swap(i,largest);
            heapify(list, n, largest);
        }
    }


}
