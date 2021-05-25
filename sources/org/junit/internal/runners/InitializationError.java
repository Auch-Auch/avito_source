package org.junit.internal.runners;

import java.util.Arrays;
import java.util.List;
@Deprecated
public class InitializationError extends Exception {
    private static final long serialVersionUID = 1;
    public final List<Throwable> a;

    public InitializationError(List<Throwable> list) {
        this.a = list;
    }

    public List<Throwable> getCauses() {
        return this.a;
    }

    public InitializationError(Throwable... thArr) {
        this(Arrays.asList(thArr));
    }

    public InitializationError(String str) {
        this(new Exception(str));
    }
}
