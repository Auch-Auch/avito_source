package com.avito.security;

import java.util.List;
public class b0 extends a0 {
    public static <T> List<T> a() {
        return l0.a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> a(List<? extends T> list) {
        j1.b(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        return size != 0 ? size != 1 ? list : z.a(list.get(0)) : z.a();
    }
}
