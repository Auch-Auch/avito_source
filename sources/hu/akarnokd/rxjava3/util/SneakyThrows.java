package hu.akarnokd.rxjava3.util;
public final class SneakyThrows {
    public SneakyThrows() {
        throw new IllegalStateException("No instances!");
    }

    public static <E extends Throwable> E justThrowX(Throwable th) throws Throwable {
        throw th;
    }
}
