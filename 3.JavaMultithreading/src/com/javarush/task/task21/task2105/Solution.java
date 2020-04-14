package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }


    @Override
    public int hashCode() {
        return 31*first.length() + 37 * last.length();
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Solution))  return true;
        if (this == o) return true;
        if (this.hashCode() != o.hashCode()) return false;

        Solution n = (Solution) o;
        if( n.first == null ) return false;
        if( n.last == null ) return false;

        return n.first.equals(first) && n.last.equals(last);
    }   

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
