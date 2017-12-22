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
public interface UnsortedLinkedListInterface<T> {

    public boolean add(T newEntry); //add new item

    public int getLength(); //get the length of list

    public boolean isEmpty(); //verify whether the list is empty

    public T getEntry(Integer givenPosition); //get the specific entry
     
    public boolean contains(T searchItem); //search item
    
    public int countSearch(); //count the number of item searched in list, use together with contains
}
