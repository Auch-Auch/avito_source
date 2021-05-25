package l6.f.a;

import java.util.concurrent.Executor;
public enum a implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return "DirectExecutor";
    }
}
