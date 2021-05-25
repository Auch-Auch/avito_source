package o6;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
public final class a {
    public static final a b = new a();
    public static final int c;
    public static final int d;
    public static final int e;
    public final Executor a = new b(null);

    public static class b implements Executor {
        public b(C0544a aVar) {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        c = availableProcessors;
        d = availableProcessors + 1;
        e = (availableProcessors * 2) + 1;
    }
}
