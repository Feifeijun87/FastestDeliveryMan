/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.util.*;







/**
 *
 * @author user
 */
public class LinkedQueue<T> implements QueueInterface<T> {

 private Node firstNode; // references node at front of queue
  private Node lastNode;  // references node at back of queue
  private int size;
    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);

         if (isEmpty())
         {
            firstNode = newNode;
         } 
         else 
         {
             lastNode.next = newNode;
         }
            lastNode = newNode;
    }

    @Override
    public T dequeue() {
        T front = null;

        if (!isEmpty())
        {
             front = firstNode.data;
            firstNode = firstNode.next;
            if (firstNode == null)
            {
              lastNode = null;
            }
        } 
        return front;
    }

    @Override
    public T getFront() {
       T front = null;

         if (!isEmpty())
         {
          front = firstNode.data;
        }
         return front;
    }

    @Override
    public boolean isEmpty() {
         return (firstNode == null) && (lastNode == null);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  

   
    private class Node {

    private T data; // entry in queue
    private Node next; // link to next node

    private Node(T dataPortion) {
      data = dataPortion;
      next = null;
    } // end constructor

    private Node(T dataPortion, Node linkPortion) {
      data = dataPortion;
      next = linkPortion;
    } // end constructor
  } // end Node
    
}
