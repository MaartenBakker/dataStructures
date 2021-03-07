package com.maartenmusic;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        System.out.println(solution.openLock(deadends, "0202"));
    }
}
