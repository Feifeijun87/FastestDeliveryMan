package order;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hsuhong1210
 */
public class UnsortedLinkedList<T> implements UnsortedLinkedListInterface<T> {

    private Node firstNode;
    private T[] list;
    private int numberOfEntries;
    private int countSearch;

    public UnsortedLinkedList() {
        firstNode = null;
        numberOfEntries = 0;
        countSearch = 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);	

        if (isEmpty()) 
        {
            firstNode = newNode;
        } else {                        
            Node currentNode = firstNode;					
            while (currentNode.next != null) {		
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public T getEntry(Integer givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		
            }
            result = currentNode.data;	
        }

        return result;
    }

    private boolean search(Node currentNode, T searchItem) {
        boolean found;
        if (currentNode == null) {
            found = false;
        } else if (searchItem.equals(currentNode.data)) {
            found = true;
        } else {
            found = search(currentNode.next, searchItem);
        }
       
        return found;
    }

    @Override
    public int countSearch() {
        int count = countSearch;
        countSearch = 0;
        return count;
    }

    @Override
    public boolean contains(T searchItem) {
         countSearch++;
        return search(firstNode, searchItem);
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
