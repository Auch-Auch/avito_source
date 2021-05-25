package com.avito.security;

import java.util.Collection;
public class c0 extends b0 {
    public static <T> int a(Iterable<? extends T> iterable, int i) {
        j1.b(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
