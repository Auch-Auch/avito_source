package a2.j.d.l.a;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
@GwtCompatible
public class g0<V> extends FluentFuture.a<V> implements RunnableFuture<V> {
    public volatile v<?> h;

    public final class a extends v<ListenableFuture<V>> {
        public final AsyncCallable<V> d;

        public a(AsyncCallable<V> asyncCallable) {
            this.d = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        }

        @Override // a2.j.d.l.a.v
        public void a(Object obj, Throwable th) {
            ListenableFuture<? extends V> listenableFuture = (ListenableFuture) obj;
            if (th == null) {
                g0.this.setFuture(listenableFuture);
            } else {
                g0.this.setException(th);
            }
        }

        @Override // a2.j.d.l.a.v
        public final boolean c() {
            return g0.this.isDone();
        }

        @Override // a2.j.d.l.a.v
        public Object d() throws Exception {
            return (ListenableFuture) Preconditions.checkNotNull(this.d.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.d);
        }

        @Override // a2.j.d.l.a.v
        public String e() {
            return this.d.toString();
        }
    }

    public final class b extends v<V> {
        public final Callable<V> d;

        public b(Callable<V> callable) {
            this.d = (Callable) Preconditions.checkNotNull(callable);
        }

        @Override // a2.j.d.l.a.v
        public void a(V v, Throwable th) {
            if (th == null) {
                g0.this.set(v);
            } else {
                g0.this.setException(th);
            }
        }

        @Override // a2.j.d.l.a.v
        public final boolean c() {
            return g0.this.isDone();
        }

        @Override // a2.j.d.l.a.v
        public V d() throws Exception {
            return this.d.call();
        }

        @Override // a2.j.d.l.a.v
        public String e() {
            return this.d.toString();
        }
    }

    public g0(Callable<V> callable) {
        this.h = new b(callable);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        v<?> vVar;
        super.afterDone();
        if (wasInterrupted() && (vVar = this.h) != null) {
            vVar.b();
        }
        this.h = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        v<?> vVar = this.h;
        if (vVar == null) {
            return super.pendingToString();
        }
        return "task=[" + vVar + "]";
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        v<?> vVar = this.h;
        if (vVar != null) {
            vVar.run();
        }
        this.h = null;
    }

    public g0(AsyncCallable<V> asyncCallable) {
        this.h = new a(asyncCallable);
    }
}
