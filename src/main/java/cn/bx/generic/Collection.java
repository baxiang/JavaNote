package cn.bx.generic;

import java.util.*;

public class Collection {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(3);
//        list.add(5);
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey()+":"+next.getValue());
        }


    }
}
