package a2.j.e.d.d.a;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
public class f {
    public final ExecutorService a;
    public Task<Void> b = Tasks.forResult(null);
    public final Object c = new Object();
    public ThreadLocal<Boolean> d = new ThreadLocal<>();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.d.set(Boolean.TRUE);
        }
    }

    public f(ExecutorService executorService) {
        this.a = executorService;
        executorService.submit(new a());
    }

    public void a() {
        if (!Boolean.TRUE.equals(this.d.get())) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public <T> Task<T> b(Callable<T> callable) {
        Task task;
        synchronized (this.c) {
            task = (Task<TContinuationResult>) this.b.continueWith(this.a, new h(this, callable));
            this.b = task.continueWith(this.a, new i(this));
        }
        return task;
    }

    public <T> Task<T> c(Callable<Task<T>> callable) {
        Task task;
        synchronized (this.c) {
            task = (Task<TContinuationResult>) this.b.continueWithTask(this.a, new h(this, callable));
            this.b = task.continueWith(this.a, new i(this));
        }
        return task;
    }
}
