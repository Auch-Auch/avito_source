package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class Callables {

    public static class a implements Callable<T> {
        public final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // java.util.concurrent.Callable
        public T call() {
            return (T) this.a;
        }
    }

    public static class b implements AsyncCallable<T> {
        public final /* synthetic */ ListeningExecutorService a;
        public final /* synthetic */ Callable b;

        public b(ListeningExecutorService listeningExecutorService, Callable callable) {
            this.a = listeningExecutorService;
            this.b = callable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture<T> call() throws Exception {
            return this.a.submit(this.b);
        }
    }

    public static boolean a(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    @Beta
    @GwtIncompatible
    public static <T> AsyncCallable<T> asAsyncCallable(Callable<T> callable, ListeningExecutorService listeningExecutorService) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(listeningExecutorService);
        return new b(listeningExecutorService, callable);
    }

    public static <T> Callable<T> returning(@NullableDecl T t) {
        return new a(t);
    }
}
