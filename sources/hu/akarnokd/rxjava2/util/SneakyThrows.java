package hu.akarnokd.rxjava2.util;
public final class SneakyThrows {
    public SneakyThrows() {
        throw new IllegalStateException("No instances!");
    }

    public static <E extends Throwable> E justThrow(Throwable th) throws Throwable {
        throw th;
    }
}
