package a2.j.d.l.a;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class e<I, O, F, T> extends FluentFuture.a<O> implements Runnable {
    public static final /* synthetic */ int j = 0;
    @NullableDecl
    public ListenableFuture<? extends I> h;
    @NullableDecl
    public F i;

    public static final class a<I, O> extends e<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        public a(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        @Override // a2.j.d.l.a.e
        public Object o(Object obj, @NullableDecl Object obj2) throws Exception {
            AsyncFunction asyncFunction = (AsyncFunction) obj;
            ListenableFuture<O> apply = asyncFunction.apply(obj2);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        @Override // a2.j.d.l.a.e
        public void p(Object obj) {
            setFuture((ListenableFuture) obj);
        }
    }

    public static final class b<I, O> extends e<I, O, Function<? super I, ? extends O>, O> {
        public b(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        @Override // a2.j.d.l.a.e
        @NullableDecl
        public Object o(Object obj, @NullableDecl Object obj2) throws Exception {
            return ((Function) obj).apply(obj2);
        }

        @Override // a2.j.d.l.a.e
        public void p(@NullableDecl O o) {
            set(o);
        }
    }

    public e(ListenableFuture<? extends I> listenableFuture, F f) {
        this.h = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.i = (F) Preconditions.checkNotNull(f);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        m(this.h);
        this.h = null;
        this.i = null;
    }

    @NullableDecl
    @ForOverride
    public abstract T o(F f, @NullableDecl I i2) throws Exception;

    @ForOverride
    public abstract void p(@NullableDecl T t);

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        ListenableFuture<? extends I> listenableFuture = this.h;
        F f = this.i;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (f != null) {
            return str + "function=[" + ((Object) f) + "]";
        } else if (pendingToString != null) {
            return a2.b.a.a.a.c3(str, pendingToString);
        } else {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: a2.j.d.l.a.e<I, O, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture<? extends I> listenableFuture = this.h;
        F f = this.i;
        boolean z = true;
        boolean isCancelled = isCancelled() | (listenableFuture == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.h = null;
            if (listenableFuture.isCancelled()) {
                setFuture(listenableFuture);
                return;
            }
            try {
                try {
                    Object o = o(f, Futures.getDone(listenableFuture));
                    this.i = null;
                    p(o);
                } catch (Throwable th) {
                    this.i = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                setException(e.getCause());
            } catch (RuntimeException e2) {
                setException(e2);
            } catch (Error e3) {
                setException(e3);
            }
        }
    }
}
