package a2.j.b.e.a.j;

import java.util.concurrent.Executor;
public final class i implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
