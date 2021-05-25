package a2.j.e.d.d.a;

import java.util.concurrent.Callable;
public class g implements Callable<Void> {
    public final /* synthetic */ Runnable a;

    public g(f fVar, Runnable runnable) {
        this.a = runnable;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.a.run();
        return null;
    }
}
