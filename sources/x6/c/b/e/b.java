package x6.c.b.e;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.internal.runners.MethodRoadie;
import org.junit.runners.model.TestTimedOutException;
public class b implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ MethodRoadie b;

    public class a implements Callable<Object> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            b.this.b.runTestMethod();
            return null;
        }
    }

    public b(MethodRoadie methodRoadie, long j) {
        this.b = methodRoadie;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future submit = newSingleThreadExecutor.submit(new a());
        newSingleThreadExecutor.shutdown();
        try {
            long j = this.a;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (!newSingleThreadExecutor.awaitTermination(j, timeUnit)) {
                newSingleThreadExecutor.shutdownNow();
            }
            submit.get(0, timeUnit);
        } catch (TimeoutException unused) {
            this.b.addFailure(new TestTimedOutException(this.a, TimeUnit.MILLISECONDS));
        } catch (Exception e) {
            this.b.addFailure(e);
        }
    }
}
