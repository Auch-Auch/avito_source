package a2.j.d.l.a;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.errorprone.annotations.ForOverride;
import java.lang.Throwable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class a<V, X extends Throwable, F, T> extends FluentFuture.a<V> implements Runnable {
    public static final /* synthetic */ int k = 0;
    @NullableDecl
    public ListenableFuture<? extends V> h;
    @NullableDecl
    public Class<X> i;
    @NullableDecl
    public F j;

    /* renamed from: a2.j.d.l.a.a$a  reason: collision with other inner class name */
    public static final class C0077a<V, X extends Throwable> extends a<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        public C0077a(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        @Override // a2.j.d.l.a.a
        public Object o(Object obj, Throwable th) throws Exception {
            AsyncFunction asyncFunction = (AsyncFunction) obj;
            ListenableFuture apply = asyncFunction.apply(th);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        @Override // a2.j.d.l.a.a
        public void p(Object obj) {
            setFuture((ListenableFuture) obj);
        }
    }

    public static final class b<V, X extends Throwable> extends a<V, X, Function<? super X, ? extends V>, V> {
        public b(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        @Override // a2.j.d.l.a.a
        @NullableDecl
        public Object o(Object obj, Throwable th) throws Exception {
            return ((Function) obj).apply(th);
        }

        @Override // a2.j.d.l.a.a
        public void p(@NullableDecl V v) {
            set(v);
        }
    }

    public a(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f) {
        this.h = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.i = (Class) Preconditions.checkNotNull(cls);
        this.j = (F) Preconditions.checkNotNull(f);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        m(this.h);
        this.h = null;
        this.i = null;
        this.j = null;
    }

    @NullableDecl
    @ForOverride
    public abstract T o(F f, X x) throws Exception;

    @ForOverride
    public abstract void p(@NullableDecl T t);

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        ListenableFuture<? extends V> listenableFuture = this.h;
        Class<X> cls = this.i;
        F f = this.j;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls != null && f != null) {
            return str + "exceptionType=[" + cls + "], fallback=[" + ((Object) f) + "]";
        } else if (pendingToString != null) {
            return a2.b.a.a.a.c3(str, pendingToString);
        } else {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: a2.j.d.l.a.a<V, X extends java.lang.Throwable, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    @Override // java.lang.Runnable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r7.h
            java.lang.Class<X extends java.lang.Throwable> r1 = r7.i
            F r2 = r7.j
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x000c
            r5 = 1
            goto L_0x000d
        L_0x000c:
            r5 = 0
        L_0x000d:
            if (r1 != 0) goto L_0x0011
            r6 = 1
            goto L_0x0012
        L_0x0011:
            r6 = 0
        L_0x0012:
            r5 = r5 | r6
            if (r2 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            r3 = r3 | r5
            boolean r4 = r7.isCancelled()
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0020
            return
        L_0x0020:
            r3 = 0
            r7.h = r3
            java.lang.Object r4 = com.google.common.util.concurrent.Futures.getDone(r0)     // Catch:{ ExecutionException -> 0x002c, all -> 0x002a }
            r5 = r4
            r4 = r3
            goto L_0x0038
        L_0x002a:
            r4 = move-exception
            goto L_0x0037
        L_0x002c:
            r4 = move-exception
            java.lang.Throwable r4 = r4.getCause()
            java.lang.Object r4 = com.google.common.base.Preconditions.checkNotNull(r4)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
        L_0x0037:
            r5 = r3
        L_0x0038:
            if (r4 != 0) goto L_0x003e
            r7.set(r5)
            return
        L_0x003e:
            boolean r1 = r1.isInstance(r4)
            if (r1 != 0) goto L_0x0048
            r7.setFuture(r0)
            return
        L_0x0048:
            java.lang.Object r0 = r7.o(r2, r4)     // Catch:{ all -> 0x0054 }
            r7.i = r3
            r7.j = r3
            r7.p(r0)
            return
        L_0x0054:
            r0 = move-exception
            r7.setException(r0)     // Catch:{ all -> 0x005d }
            r7.i = r3
            r7.j = r3
            return
        L_0x005d:
            r0 = move-exception
            r7.i = r3
            r7.j = r3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.d.l.a.a.run():void");
    }
}
