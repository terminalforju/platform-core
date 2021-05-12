package com.project;

public class test {

    public static void main(String[] args) {
        String target = "chrome\\locales\\sr.pak";

        System.out.printf(target.replaceAll("\\\\", "/"));

    }


}
