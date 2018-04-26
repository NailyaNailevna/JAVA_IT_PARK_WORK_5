package ru.itpark;

public class Main {

    public static void main(String[] args) {
        List list = new ArrayList();
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
        list.add("Nailya");

        //System.out.println(list.size());
        //System.out.println(list.contains("Roman"));
        //System.out.println(list.contains("Ksusha"));
        //System.out.println(list.get(2));
        //System.out.println(list.get(10));

        list.delete(6);
        //list.delete("Damir");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
