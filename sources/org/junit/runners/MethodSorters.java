package org.junit.runners;

import java.lang.reflect.Method;
import java.util.Comparator;
import org.junit.internal.MethodSorter;
public enum MethodSorters {
    NAME_ASCENDING(MethodSorter.NAME_ASCENDING),
    JVM(null),
    DEFAULT(MethodSorter.DEFAULT);
    
    public final Comparator<Method> a;

    /* access modifiers changed from: public */
    MethodSorters(Comparator comparator) {
        this.a = comparator;
    }

    public Comparator<Method> getComparator() {
        return this.a;
    }
}
