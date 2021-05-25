package a2.a.a.j.b;

import androidx.work.ListenableWorker;
import java.util.concurrent.Callable;
public final class b<V> implements Callable<ListenableWorker.Result> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public ListenableWorker.Result call() {
        return ListenableWorker.Result.retry();
    }
}
