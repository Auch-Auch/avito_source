package a2.j.d.l.a;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.Executor;
@GwtCompatible
public enum n implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
