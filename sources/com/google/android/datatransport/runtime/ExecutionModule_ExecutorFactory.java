package com.google.android.datatransport.runtime;

import a2.j.b.a.c.f;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
public final class ExecutionModule_ExecutorFactory implements Factory<Executor> {
    public static final ExecutionModule_ExecutorFactory a = new ExecutionModule_ExecutorFactory();

    public static ExecutionModule_ExecutorFactory create() {
        return a;
    }

    public static Executor executor() {
        return (Executor) Preconditions.checkNotNull(new f(Executors.newSingleThreadExecutor()), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Executor get() {
        return executor();
    }
}
