package ru.itpark;

import java.util.Iterator;

public class MainLinkedListIterator {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Marsel");
        list.add("Shamil");
        list.add("Roman");
        list.add("Adel");
        list.add("Rustem");
        list.add("Sergey");
        list.add("Damir");
        list.add("Nastya");
        list.add("Egor");
        list.add("Ilya");
        list.add("Marsel");
        list.add("Nailya");

        Iterator<String> iterator = list.getIterator();

        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/

//        System.out.println(list.get(4));

//        list.delete(2);
//        list.add("Mars");
//        System.out.println(list.contains("Nailya"));
        System.out.println(list.delete("Roman"));

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
