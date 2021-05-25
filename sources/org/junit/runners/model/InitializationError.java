package org.junit.runners.model;

import java.util.Arrays;
import java.util.List;
public class InitializationError extends Exception {
    private static final long serialVersionUID = 1;
    public final List<Throwable> a;

    public InitializationError(List<Throwable> list) {
        this.a = list;
    }

    public List<Throwable> getCauses() {
        return this.a;
    }

    public InitializationError(Throwable th) {
        this(Arrays.asList(th));
    }

    public InitializationError(String str) {
        this(new Exception(str));
    }
}
