package com.google.firebase.platforminfo;

import a2.j.e.k.a;
import a2.j.e.k.c;
import com.google.firebase.components.Component;
public class LibraryVersionComponent {
    public static Component<?> create(String str, String str2) {
        return Component.intoSet(new a(str, str2), c.class);
    }
}
