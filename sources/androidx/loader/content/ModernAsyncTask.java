package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
public abstract class ModernAsyncTask<Params, Progress, Result> {
    public static final ThreadFactory f;
    public static final BlockingQueue<Runnable> g;
    public static final Executor h;
    public static e i;
    public final f<Params, Result> a;
    public final FutureTask<Result> b;
    public volatile Status c = Status.PENDING;
    public final AtomicBoolean d = new AtomicBoolean();
    public final AtomicBoolean e = new AtomicBoolean();

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder L = a2.b.a.a.a.L("ModernAsyncTask #");
            L.append(this.a.getAndIncrement());
            return new Thread(runnable, L.toString());
        }
    }

    public class b extends f<Params, Result> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            ModernAsyncTask.this.e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) ModernAsyncTask.this.a(this.a);
                Binder.flushPendingCommands();
                ModernAsyncTask.this.d(result);
                return result;
            } catch (Throwable th) {
                ModernAsyncTask.this.d(result);
                throw th;
            }
        }
    }

    public class c extends FutureTask<Result> {
        public c(Callable callable) {
            super(callable);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: androidx.loader.content.ModernAsyncTask */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                Object obj = get();
                ModernAsyncTask modernAsyncTask = ModernAsyncTask.this;
                if (!modernAsyncTask.e.get()) {
                    modernAsyncTask.d(obj);
                }
            } catch (InterruptedException unused) {
            } catch (ExecutionException e) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e.getCause());
            } catch (CancellationException unused2) {
                ModernAsyncTask modernAsyncTask2 = ModernAsyncTask.this;
                if (!modernAsyncTask2.e.get()) {
                    modernAsyncTask2.d(null);
                }
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    public static class d<Data> {
        public final ModernAsyncTask a;
        public final Data[] b;

        public d(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.a = modernAsyncTask;
            this.b = dataArr;
        }
    }

    public static class e extends Handler {
        public e() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar = (d) message.obj;
            int i = message.what;
            if (i == 1) {
                ModernAsyncTask modernAsyncTask = dVar.a;
                Data data = dVar.b[0];
                if (modernAsyncTask.d.get()) {
                    modernAsyncTask.b(data);
                } else {
                    modernAsyncTask.c(data);
                }
                modernAsyncTask.c = Status.FINISHED;
            } else if (i == 2) {
                Objects.requireNonNull(dVar.a);
            }
        }
    }

    public static abstract class f<Params, Result> implements Callable<Result> {
        public Params[] a;
    }

    static {
        a aVar = new a();
        f = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        g = linkedBlockingQueue;
        h = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
    }

    public ModernAsyncTask() {
        b bVar = new b();
        this.a = bVar;
        this.b = new c(bVar);
    }

    public abstract Result a(Params... paramsArr);

    public void b(Result result) {
    }

    public void c(Result result) {
    }

    public Result d(Result result) {
        e eVar;
        synchronized (ModernAsyncTask.class) {
            if (i == null) {
                i = new e();
            }
            eVar = i;
        }
        eVar.obtainMessage(1, new d(this, result)).sendToTarget();
        return result;
    }
}
