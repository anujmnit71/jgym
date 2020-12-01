package io.jgym.warmups.day17;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class MonthsGrouping {
    public static void main(String... args) {
        List<String> months = List.of("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October",
                "November", "December");

        // Java 1.2 - Old fashioned loopy looping
        //*
        Map lastLetterToMonthsMap = new HashMap(); // Character, List of Strings
        Iterator it = months.iterator();
        while (it.hasNext()) {
            String month = (String) it.next();
            Character lastLetter = new Character(month.charAt(month.length() - 1));
            List groupedMonths = (List) lastLetterToMonthsMap.get(lastLetter);
            if (groupedMonths == null) {
                groupedMonths = new ArrayList();
                lastLetterToMonthsMap.put(lastLetter, groupedMonths);
            }
            groupedMonths.add(month);
        }
        //*/

        // Java 1.3 - Changing style from while() to for() loop - iterator variable is contained
        /*
        Map lastLetterToMonthsMap = new HashMap();
        for (Iterator it = months.iterator(); it.hasNext(); ) {
            String month = (String) it.next();
            Character lastLetter = new Character(month.charAt(month.length() - 1));
            List groupedMonths = (List) lastLetterToMonthsMap.get(lastLetter);
            if (groupedMonths == null) {
                groupedMonths = new ArrayList();
                lastLetterToMonthsMap.put(lastLetter, groupedMonths);
            }
            groupedMonths.add(month);
        }
        //*/

        // Java 1.5 - Generics means we have to do less casting - but the code gets longer
        /*
        Map<Character, List<String>> lastLetterToMonthsMap =
                new HashMap<Character, List<String>>();
        for (Iterator<String> it = months.iterator(); it.hasNext(); ) {
            String month = it.next();
            Character lastLetter = new Character(month.charAt(month.length() - 1));
            List<String> groupedMonths = lastLetterToMonthsMap.get(lastLetter);
            if (groupedMonths == null) {
                groupedMonths = new ArrayList<String>();
                lastLetterToMonthsMap.put(lastLetter, groupedMonths);
            }
            groupedMonths.add(month);
        }
        //*/

        // Java 1.5 - Autoboxing used to create the Character
        /*
        Map<Character, List<String>> lastLetterToMonthsMap =
                new HashMap<Character, List<String>>();
        for (Iterator<String> it = months.iterator(); it.hasNext(); ) {
            String month = it.next();
            Character lastLetter = month.charAt(month.length() - 1);
            List<String> groupedMonths = lastLetterToMonthsMap.get(lastLetter);
            if (groupedMonths == null) {
                groupedMonths = new ArrayList<String>();
                lastLetterToMonthsMap.put(lastLetter, groupedMonths);
            }
            groupedMonths.add(month);
        }
        //*/

        // Java 1.5 - Enhanced for loop
        /*
        Map<Character, List<String>> lastLetterToMonthsMap =
                new HashMap<Character, List<String>>();
        for (String month : months) {
            Character lastLetter = month.charAt(month.length() - 1);
            List<String> groupedMonths = lastLetterToMonthsMap.get(lastLetter);
            if (groupedMonths == null) {
                groupedMonths = new ArrayList<String>();
                lastLetterToMonthsMap.put(lastLetter, groupedMonths);
            }
            groupedMonths.add(month);
        }
        //*/


        // Java 1.7 - Diamond operator for generics
        /*
        Map<Character, List<String>> lastLetterToMonthsMap =
                new HashMap<>();
        for (String month : months) {
            Character lastLetter = month.charAt(month.length() - 1);
            List<String> groupedMonths = lastLetterToMonthsMap.get(lastLetter);
            if (groupedMonths == null) {
                groupedMonths = new ArrayList<>();
                lastLetterToMonthsMap.put(lastLetter, groupedMonths);
            }
            groupedMonths.add(month);
        }
        //*/

        // Java 8 - computeIfAbsent()
        /*
        Map<Character, List<String>> lastLetterToMonthsMap =
                new HashMap<>();
        for (String month : months) {
            Character lastLetter = month.charAt(month.length() - 1);
            List<String> groupedMonths =
                    lastLetterToMonthsMap.computeIfAbsent(
                            lastLetter, k -> new ArrayList<>());
            groupedMonths.add(month);
        }
        //*/

        // Java 8 - Iterating via stream
        /*
        Map<Character, List<String>> lastLetterToMonthsMap = months.stream()
                .collect(Collectors.groupingBy(
                       month -> month.charAt(month.length() - 1),
                       Collectors.mapping(Function.identity(),
                               Collectors.toList())));
        //*/

        // Java 10 - Making map and lists immutable
        /*
        Map<Character, List<String>> lastLetterToMonthsMap =
                Map.copyOf(months.stream()
                        .collect(Collectors.groupingBy(
                                month -> month.charAt(month.length() - 1),
                                Collectors.mapping(Function.identity(),
                                        Collectors.toUnmodifiableList()))));
        //*/


        lastLetterToMonthsMap.entrySet().forEach(System.out::println);

    }
}