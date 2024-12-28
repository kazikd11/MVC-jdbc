package com.proj.mvcjdbc.repository;

import java.util.Objects;

public class Util {
    public static String loadQuery(String resourcePath) {
        try {
            return new String(Objects.requireNonNull(Util.class.getResourceAsStream(resourcePath)).readAllBytes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }
}
