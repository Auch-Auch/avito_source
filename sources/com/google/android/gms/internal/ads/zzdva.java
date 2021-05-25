package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public enum zzdva implements Executor {
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
