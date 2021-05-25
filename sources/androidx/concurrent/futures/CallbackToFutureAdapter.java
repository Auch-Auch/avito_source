package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public final class CallbackToFutureAdapter {

    public static final class Completer<T> {
        public Object a;
        public b<T> b;
        public ResolvableFuture<Void> c = ResolvableFuture.create();
        public boolean d;

        public final void a() {
            this.a = null;
            this.b = null;
            this.c = null;
        }

        public void addCancellationListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            ResolvableFuture<Void> resolvableFuture = this.c;
            if (resolvableFuture != null) {
                resolvableFuture.addListener(runnable, executor);
            }
        }

        public void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            b<T> bVar = this.b;
            if (bVar != null && !bVar.isDone()) {
                StringBuilder L = a2.b.a.a.a.L("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
                L.append(this.a);
                bVar.b.setException(new a(L.toString()));
            }
            if (!this.d && (resolvableFuture = this.c) != null) {
                resolvableFuture.set(null);
            }
        }

        public boolean set(T t) {
            boolean z = true;
            this.d = true;
            b<T> bVar = this.b;
            if (bVar == null || !bVar.b.set(t)) {
                z = false;
            }
            if (z) {
                a();
            }
            return z;
        }

        public boolean setCancelled() {
            boolean z = true;
            this.d = true;
            b<T> bVar = this.b;
            if (bVar == null || !bVar.b.cancel(true)) {
                z = false;
            }
            if (z) {
                a();
            }
            return z;
        }

        public boolean setException(@NonNull Throwable th) {
            boolean z = true;
            this.d = true;
            b<T> bVar = this.b;
            if (bVar == null || !bVar.b.setException(th)) {
                z = false;
            }
            if (z) {
                a();
            }
            return z;
        }
    }

    public interface Resolver<T> {
        @Nullable
        Object attachCompleter(@NonNull Completer<T> completer) throws Exception;
    }

    public static final class a extends Throwable {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public static final class b<T> implements ListenableFuture<T> {
        public final WeakReference<Completer<T>> a;
        public final AbstractResolvableFuture<T> b = new a();

        public class a extends AbstractResolvableFuture<T> {
            public a() {
            }

            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            public String pendingToString() {
                Completer<T> completer = b.this.a.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return a2.b.a.a.a.r(a2.b.a.a.a.L("tag=["), completer.a, "]");
            }
        }

        public b(Completer<T> completer) {
            this.a = new WeakReference<>(completer);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
            this.b.addListener(runnable, executor);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            Completer<T> completer = this.a.get();
            boolean cancel = this.b.cancel(z);
            if (cancel && completer != null) {
                completer.a = null;
                completer.b = null;
                completer.c.set(null);
            }
            return cancel;
        }

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            return this.b.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.b.isDone();
        }

        @Override // java.lang.Object
        public String toString() {
            return this.b.toString();
        }

        @Override // java.util.concurrent.Future
        public T get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.b.get(j, timeUnit);
        }
    }

    @NonNull
    public static <T> ListenableFuture<T> getFuture(@NonNull Resolver<T> resolver) {
        Completer<T> completer = new Completer<>();
        b<T> bVar = new b<>(completer);
        completer.b = bVar;
        completer.a = resolver.getClass();
        try {
            Object attachCompleter = resolver.attachCompleter(completer);
            if (attachCompleter != null) {
                completer.a = attachCompleter;
            }
        } catch (Exception e) {
            bVar.b.setException(e);
        }
        return bVar;
    }
}
