package y6.a.a;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
public final class b extends ScheduledThreadPoolExecutor {
    public static final /* synthetic */ int a = 0;

    /* renamed from: y6.a.a.b$b  reason: collision with other inner class name */
    public static final class C0702b {
        public static final b a = new b(null);
    }

    public b(a aVar) {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }
}
