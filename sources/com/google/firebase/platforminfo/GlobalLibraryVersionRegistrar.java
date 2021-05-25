package com.google.firebase.platforminfo;

import a2.j.e.k.a;
import a2.j.e.k.c;
import java.util.HashSet;
import java.util.Set;
public class GlobalLibraryVersionRegistrar {
    public static volatile GlobalLibraryVersionRegistrar b;
    public final Set<c> a = new HashSet();

    public static GlobalLibraryVersionRegistrar getInstance() {
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = b;
        if (globalLibraryVersionRegistrar == null) {
            synchronized (GlobalLibraryVersionRegistrar.class) {
                globalLibraryVersionRegistrar = b;
                if (globalLibraryVersionRegistrar == null) {
                    globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                    b = globalLibraryVersionRegistrar;
                }
            }
        }
        return globalLibraryVersionRegistrar;
    }

    public void registerVersion(String str, String str2) {
        synchronized (this.a) {
            this.a.add(new a(str, str2));
        }
    }
}
