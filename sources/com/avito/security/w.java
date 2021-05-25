package com.avito.security;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class w extends v {
    public static <T> List<T> a(T[] tArr) {
        j1.b(tArr, "$this$asList");
        List<T> a = y.a(tArr);
        j1.a((Object) a, "ArraysUtilJVM.asList(this)");
        return a;
    }

    public static final <T> void a(T[] tArr, Comparator<? super T> comparator) {
        j1.b(tArr, "$this$sortWith");
        j1.b(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static final <T> void b(T[] tArr) {
        j1.b(tArr, "$this$sort");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }
}
