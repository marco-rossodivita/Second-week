package com.corso.java.market;

public interface Finder<K> {

    void findByPrimaryKey(int i);
    void findByForeignKey(int i);
}
