package a2.j.e.i;

import java.util.concurrent.Executor;
public final /* synthetic */ class f implements Executor {
    public static final Executor a = new f();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
