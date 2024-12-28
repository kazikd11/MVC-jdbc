package com.proj.mvcjdbc.model;

public record Shelter(int id, String name, String phone, String internalPhone, String email, String owner,  boolean status) {

    public Shelter(int id, String name, String phone, String email, boolean status) {
        this(id, name, phone, null, email, null, status);
    }
}
