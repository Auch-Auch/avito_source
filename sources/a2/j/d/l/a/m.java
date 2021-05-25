package a2.j.d.l.a;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class m<V> extends g<Object, V> {

    public final class a extends m<V>.c {
        public final AsyncCallable<V> g;

        public a(AsyncCallable<V> asyncCallable, Executor executor) {
            super(executor);
            this.g = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        }

        @Override // a2.j.d.l.a.v
        public Object d() throws Exception {
            this.e = false;
            return (ListenableFuture) Preconditions.checkNotNull(this.g.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.g);
        }

        @Override // a2.j.d.l.a.v
        public String e() {
            return this.g.toString();
        }

        @Override // a2.j.d.l.a.m.c
        public void f(Object obj) {
            m.this.setFuture((ListenableFuture) obj);
            m.this.q();
        }
    }

    public final class b extends m<V>.c {
        public final Callable<V> g;

        public b(Callable<V> callable, Executor executor) {
            super(executor);
            this.g = (Callable) Preconditions.checkNotNull(callable);
        }

        @Override // a2.j.d.l.a.v
        public V d() throws Exception {
            this.e = false;
            return this.g.call();
        }

        @Override // a2.j.d.l.a.v
        public String e() {
            return this.g.toString();
        }

        @Override // a2.j.d.l.a.m.c
        public void f(V v) {
            m.this.set(v);
        }
    }

    public abstract class c<T> extends v<T> {
        public final Executor d;
        public boolean e = true;

        public c(Executor executor) {
            this.d = (Executor) Preconditions.checkNotNull(executor);
        }

        @Override // a2.j.d.l.a.v
        public final void a(T t, Throwable th) {
            if (th == null) {
                f(t);
            } else if (th instanceof ExecutionException) {
                m.this.setException(th.getCause());
            } else if (th instanceof CancellationException) {
                m.this.cancel(false);
            } else {
                m.this.setException(th);
            }
        }

        @Override // a2.j.d.l.a.v
        public final boolean c() {
            return m.this.isDone();
        }

        public abstract void f(T t);
    }

    public final class d extends g<Object, V>.a {
        public c i;

        public d(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z, c cVar) {
            super(immutableCollection, z, false);
            this.i = cVar;
        }

        @Override // a2.j.d.l.a.g.a
        public void g(boolean z, int i2, @NullableDecl Object obj) {
        }

        @Override // a2.j.d.l.a.g.a
        public void i() {
            c cVar = this.i;
            if (cVar != null) {
                try {
                    cVar.d.execute(cVar);
                } catch (RejectedExecutionException e) {
                    if (cVar.e) {
                        m.this.setException(e);
                    }
                }
            } else {
                Preconditions.checkState(m.this.isDone());
            }
        }

        @Override // a2.j.d.l.a.g.a
        public void l() {
            c cVar = this.i;
            if (cVar != null) {
                cVar.b();
            }
        }

        @Override // a2.j.d.l.a.g.a
        public void m() {
            this.e = null;
            this.i = null;
        }
    }

    public m(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z, Executor executor, AsyncCallable<V> asyncCallable) {
        p(new d(immutableCollection, z, new a(asyncCallable, executor)));
    }

    public m(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z, Executor executor, Callable<V> callable) {
        p(new d(immutableCollection, z, new b(callable, executor)));
    }
}
