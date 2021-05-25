package x6.c.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.runners.model.RunnerScheduler;
public final class a implements RunnerScheduler {
    public final ExecutorService a = Executors.newCachedThreadPool();

    @Override // org.junit.runners.model.RunnerScheduler
    public void finished() {
        try {
            this.a.shutdown();
            this.a.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override // org.junit.runners.model.RunnerScheduler
    public void schedule(Runnable runnable) {
        this.a.submit(runnable);
    }
}
