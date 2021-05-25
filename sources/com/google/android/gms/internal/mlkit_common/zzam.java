package com.google.android.gms.internal.mlkit_common;

import java.util.concurrent.Executor;
public enum zzam implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
