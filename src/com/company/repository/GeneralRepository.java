package com.company.repository;

public interface GeneralRepository<T> {
    int SIZE = 20;

    T[] showList();

    int size();

    void add(int index, T element);

    void remove(int index);

    T set(int index, T element);

    int find(String elementName);
    T[] sort();
}
