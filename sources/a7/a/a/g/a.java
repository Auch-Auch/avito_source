package a7.a.a.g;

import java.util.concurrent.ThreadFactory;
public final class a implements ThreadFactory {
    public static final a a = new a();

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "PrecomputedText");
    }
}
