package com.avito.security;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class f0 extends e0 {
    public static final <T> void a(List<T> list, Comparator<? super T> comparator) {
        j1.b(list, "$this$sortWith");
        j1.b(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
