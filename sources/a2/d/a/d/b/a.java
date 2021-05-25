package a2.d.a.d.b;

import a2.d.a.d.b.m;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
public final class a {
    public final boolean a;
    public final Executor b;
    @VisibleForTesting
    public final Map<Key, b> c = new HashMap();
    public final ReferenceQueue<m<?>> d = new ReferenceQueue<>();
    public m.a e;
    public volatile boolean f;

    /* renamed from: a2.d.a.d.b.a$a  reason: collision with other inner class name */
    public class ThreadFactoryC0014a implements ThreadFactory {

        /* renamed from: a2.d.a.d.b.a$a$a  reason: collision with other inner class name */
        public class RunnableC0015a implements Runnable {
            public final /* synthetic */ Runnable a;

            public RunnableC0015a(ThreadFactoryC0014a aVar, Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.a.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0015a(this, runnable), "glide-active-resources");
        }
    }

    @VisibleForTesting
    public static final class b extends WeakReference<m<?>> {
        public final Key a;
        public final boolean b;
        @Nullable
        public Resource<?> c;

        public b(@NonNull Key key, @NonNull m<?> mVar, @NonNull ReferenceQueue<? super m<?>> referenceQueue, boolean z) {
            super(mVar, referenceQueue);
            this.a = (Key) Preconditions.checkNotNull(key);
            this.c = (!mVar.a || !z) ? null : (Resource) Preconditions.checkNotNull(mVar.c);
            this.b = mVar.a;
        }
    }

    public a(boolean z) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactoryC0014a());
        this.a = z;
        this.b = newSingleThreadExecutor;
        newSingleThreadExecutor.execute(new b(this));
    }

    public synchronized void a(Key key, m<?> mVar) {
        b put = this.c.put(key, new b(key, mVar, this.d, this.a));
        if (put != null) {
            put.c = null;
            put.clear();
        }
    }

    public void b(@NonNull b bVar) {
        synchronized (this) {
            this.c.remove(bVar.a);
            if (bVar.b) {
                Resource<?> resource = bVar.c;
                if (resource != null) {
                    this.e.onResourceReleased(bVar.a, new m<>(resource, true, false, bVar.a, this.e));
                }
            }
        }
    }
}
