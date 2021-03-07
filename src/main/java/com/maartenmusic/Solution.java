package com.maartenmusic;

import java.util.*;

class Solution {

    public int openLock(String[] deadends, String target) {
        int counter = 0;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        if (Arrays.asList(deadends).contains(target) || Arrays.asList(deadends).contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }

        q.offer("0000");
        visited.add("0000");
        visited.addAll(Arrays.asList(deadends));

        while(!q.isEmpty()) {
            int size = q.size();
            counter++;

            for (int i = 0; i < size; i++) {

                List<String> nextMoves = getNextMoves(q.peek());
                if (nextMoves.contains(target)) {
                    return counter;
                }
                nextMoves.removeAll(visited);

                for (String nextMove : nextMoves) {
                    visited.add(nextMove);
                    q.offer(nextMove);
                }

                q.poll();
            }
        }
        return -1;
    }

    private List<String> getNextMoves(String curr) {
        List<String> nextMoves = new ArrayList<>();

        char firstChar = curr.charAt(0);
        char secondChar = curr.charAt(1);
        char thirdChar = curr.charAt(2);
        char fourthChar = curr.charAt(3);

        List<Character> firstOptions = getOptions(firstChar);
        List<Character> secondOptions = getOptions(secondChar);
        List<Character> thirdOptions = getOptions(thirdChar);
        List<Character> fourthOptions = getOptions(fourthChar);

        for (char firstOption : firstOptions) {
            char[] combined = {firstOption, secondChar, thirdChar, fourthChar};
            nextMoves.add(String.valueOf(combined));
        }

        for (char secondOption : secondOptions) {
            char[] combined = {firstChar, secondOption, thirdChar, fourthChar};
            nextMoves.add(String.valueOf(combined));
        }

        for (char thirdOption : thirdOptions) {
            char[] combined = {firstChar, secondChar, thirdOption, fourthChar};
            nextMoves.add(String.valueOf(combined));
        }

        for (char fourthOption : fourthOptions) {
            char[] combined = {firstChar, secondChar, thirdChar, fourthOption};
            nextMoves.add(String.valueOf(combined));
        }

        nextMoves.remove(curr);

        return nextMoves;
    }

    private List<Character> getOptions(char number) {
        List<Character> options = new ArrayList<>();

        int plusOne = number + 1;
        if (plusOne == 58) {
            plusOne = 48;
        }
        options.add((char) plusOne);

        int minusOne = number -1;
        if (minusOne == 47) {
            minusOne = 57;
        }
        options.add((char) minusOne);
        return options;
    }
}