package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addTest(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(2);
        list.add(5);
        list.add(6);

        Assert.assertTrue(list.contains(2));
        Assert.assertTrue(list.contains(5));
        Assert.assertTrue(list.contains(6));
    }

    @Test
    public void removeTest(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(2);
        list.add(5);
        list.add(6);
        boolean expected = list.remove(1);
        Assert.assertTrue(expected);
        Assert.assertTrue(list.contains(2));
        Assert.assertFalse(list.contains(5));
        Assert.assertTrue(list.contains(6));
    }

    @Test
    public void removeFailTest(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(2);
        list.add(5);
        list.add(6);
        boolean expected = list.remove(3);
        Assert.assertFalse(expected);
        Assert.assertTrue(list.contains(2));
        Assert.assertTrue(list.contains(5));
        Assert.assertTrue(list.contains(6));
    }

    @Test
    public void containsTest(){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("hello");
        list.add("world");
        list.add("bye");
        Assert.assertTrue(list.contains("hello"));
        Assert.assertFalse(list.contains("yay"));
    }

    @Test
    public void findTest(){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("hello");
        list.add("world");
        list.add("bye");
        Assert.assertEquals(0,list.find("hello"));
        Assert.assertEquals(1,list.find("world"));
        Assert.assertEquals(2,list.find("bye"));

    }

    @Test
    public void sizeTest(){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("hello");
        list.add("world");
        list.add("bye");
        Assert.assertEquals(3,list.size());
    }

    @Test
    public void getTest(){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("hello");
        list.add("world");
        list.add("bye");
        Assert.assertEquals("hello",list.get(0));
        Assert.assertEquals("world",list.get(1));
        Assert.assertEquals("bye",list.get(2));
    }

    @Test
    public void copyTest(){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("hello");
        list.add("world");
        list.add("bye");
        SinglyLinkedList<String> list2 = list.copy();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i),list2.get(i));
        }
    }

    @Test
    public void swapTest(){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("hello");
        list.add("world");
        list.add("bye");
        list.swap(0,2);
        Assert.assertEquals("bye", list.get(0));
        Assert.assertEquals("hello", list.get(2));
    }

    @Test
    public void compareTest(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(6);
        list.add(5);
        Assert.assertTrue(list.get(0).compareTo(list.get(1))>0);
        Assert.assertTrue(list.get(1).compareTo(list.get(0))<0);
        list.sort();
        Assert.assertFalse(list.get(0).compareTo(list.get(1))>0);
        Assert.assertFalse(list.get(1).compareTo(list.get(0))<0);
    }

    @Test
    public void sortTest(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(6);
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(8);
        list.add(7);
        list.add(2);
        list.add(4);
        Assert.assertEquals(8,list.size());
        list.sort();
        System.out.println(list);
    }
}
