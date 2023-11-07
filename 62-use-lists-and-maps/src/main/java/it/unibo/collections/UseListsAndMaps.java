package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> arrlist = new ArrayList<>();
        for(int i = 1000; i < 2000; i++){
            arrlist.add(Integer.valueOf(i));
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> lnklist = new LinkedList<>(arrlist);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = arrlist.get(0);
        arrlist.set(0, arrlist.get(arrlist.size() - 1));
        arrlist.set(arrlist.size() - 1, Integer.valueOf(temp));
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(final int elem : arrlist){
            System.out.println(String.valueOf(elem));
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time1 = System.nanoTime();
        for(int i=2000; i<102_000; i++){
            arrlist.add(0, Integer.valueOf(i));
        }
        time1 = System.nanoTime() - time1;
        final var millis1 = TimeUnit.NANOSECONDS.toMillis(time1);
        System.out.println(// NOPMD
            "adding 100.000 elems to arrlist took: "  + time1
                + "ns ("
                + millis1
                + "ms)"
        );
        long time2 = System.nanoTime();
        for(int i=2000; i<102_000; i++){
            lnklist.add(0, Integer.valueOf(i));
        }
        time2 = System.nanoTime() - time2;
        final var millis2 = TimeUnit.NANOSECONDS.toMillis(time2);
        System.out.println(// NOPMD
            "adding 100.000 elems to lnklist took: "  + time2
                + "ns ("
                + millis2
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        long time3 = System.nanoTime();
        for(int i=0; i<1000; i++){
            arrlist.get((int)(arrlist.size() / 2));
        }
        time3 = System.nanoTime() - time3;
        final var millis3 = TimeUnit.NANOSECONDS.toMillis(time3);
        System.out.println(// NOPMD
            "raeding 1000 times from arrlist took"  + time3 + "ns (" + millis3 + "ms)"
        );

        long time4 = System.nanoTime();
        for(int i=0; i<1000; i++){
            lnklist.get((int)(lnklist.size() / 2));
        }
        time4 = System.nanoTime() - time4;
        final var millis4 = TimeUnit.NANOSECONDS.toMillis(time4);
        System.out.println(// NOPMD
            "raeding 1000 times from arrlist took"  + time4
                + "ns ("
                + millis4
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> map = new HashMap<>();
        map.put("Africa", 1_110_635_000L);
        map.put("Americas", 972_005_000L);
        map.put("Antarctica", 0L);
        map.put("Asia", 4_298_723_000L);
        map.put("Europe", 742_452_000L);
        map.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long worldPop = 0L;
        for (final long l : map.values()) {
            worldPop = worldPop + l;
        }
        System.out.println("World population = " + worldPop);
    }
}
