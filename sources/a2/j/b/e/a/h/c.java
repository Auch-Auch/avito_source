package a2.j.b.e.a.h;

import java.util.concurrent.ThreadFactory;
public final class c implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "SplitCompatBackgroundThread");
    }
}
