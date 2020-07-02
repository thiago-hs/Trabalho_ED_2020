package com.fatec.ed;

import java.util.LinkedList;

public class HashLinkedList {

    public static class HTObject {
        public int key;
        public String value;
    }
 
    public static int ARR_SIZE;
    private LinkedList<HTObject>[] arr;
 
    public HashLinkedList(int tam) {
    	
    	this.ARR_SIZE = tam;
    	this.arr = new LinkedList[tam];
    	
        //init vals in array
        for(int i=0; i < tam; i++) {
            arr[i] = null;
        }
        
    }
 
    private HTObject getObj(String key) {
        if(key == null)
            return null;
 
        int index = key.hashCode() % ARR_SIZE;
        LinkedList<HTObject> items = arr[index];
 
        if(items == null)
            return null;
 
        for(HTObject item : items) {
            if(item.key == key.hashCode())
                return item;
        }
 
        return null;
    }
 
    public String get(String key) {
        HTObject item = getObj(key);
 
        if(item == null)
            return null;
        else
            return
            item.value;
    }
 
    public void put(String key) {
    	
        int index = (Character.toString(key.toLowerCase().charAt(0)).hashCode() & 0x7fffffff) % ARR_SIZE;
        
        LinkedList<HTObject> items = arr[index];
 
        if(items == null) {
            items = new LinkedList<HTObject>();
 
            HTObject item = new HTObject();
            item.key = key.hashCode();
            item.value = key;
 
            items.add(item);
 
            arr[index] = items;
        }
        else {
            for(HTObject item : items) {
                if(item.key == key.hashCode()) {
                    item.value = key;
                    return;
                }
            }
 
            HTObject item = new HTObject();
            item.key = key.hashCode();
            item.value = key;
 
            items.add(item);
        }
    }
 
    public void delete(String key) {
        int index = key.hashCode() % ARR_SIZE;
        LinkedList<HTObject> items = arr[index];
 
        if(items == null)
            return;
 
        for(HTObject item : items) {
            if (item.key == key.hashCode()) {
                items.remove(item);
                return;
            }
        }
    }
    
    public void printHashTable() {
    	
    	for(int i=0; i < this.ARR_SIZE; i++) {
    		if(arr[i] != null) {
    			System.out.print("Hash["+i+"] => ");
    			
    		    LinkedList<HTObject> linkedList = arr[i];

    			for(HTObject item: linkedList) {
    				System.out.print(item.value + " -> ");
    			}
    			
    			System.out.println("");
    		}
        }
    	
    }
}
