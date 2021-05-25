package r6.a.b.l;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Scheduler;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
public final class e<R> implements CallAdapter<R, Object> {
    public final Type a;
    @Nullable
    public final Scheduler b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public e(Type type, @Nullable Scheduler scheduler, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8) {
        this.a = type;
        this.b = scheduler;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = z7;
        this.i = z8;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    @Override // retrofit2.CallAdapter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object adapt(retrofit2.Call<R> r2) {
        /*
            r1 = this;
            boolean r0 = r1.c
            if (r0 == 0) goto L_0x000a
            r6.a.b.l.b r0 = new r6.a.b.l.b
            r0.<init>(r2)
            goto L_0x000f
        L_0x000a:
            r6.a.b.l.c r0 = new r6.a.b.l.c
            r0.<init>(r2)
        L_0x000f:
            boolean r2 = r1.d
            if (r2 == 0) goto L_0x001a
            r6.a.b.l.d r2 = new r6.a.b.l.d
            r2.<init>(r0)
        L_0x0018:
            r0 = r2
            goto L_0x0024
        L_0x001a:
            boolean r2 = r1.e
            if (r2 == 0) goto L_0x0024
            r6.a.b.l.a r2 = new r6.a.b.l.a
            r2.<init>(r0)
            goto L_0x0018
        L_0x0024:
            io.reactivex.rxjava3.core.Scheduler r2 = r1.b
            if (r2 == 0) goto L_0x002c
            io.reactivex.rxjava3.core.Observable r0 = r0.subscribeOn(r2)
        L_0x002c:
            boolean r2 = r1.f
            if (r2 == 0) goto L_0x0037
            io.reactivex.rxjava3.core.BackpressureStrategy r2 = io.reactivex.rxjava3.core.BackpressureStrategy.LATEST
            io.reactivex.rxjava3.core.Flowable r2 = r0.toFlowable(r2)
            return r2
        L_0x0037:
            boolean r2 = r1.g
            if (r2 == 0) goto L_0x0040
            io.reactivex.rxjava3.core.Single r2 = r0.singleOrError()
            return r2
        L_0x0040:
            boolean r2 = r1.h
            if (r2 == 0) goto L_0x0049
            io.reactivex.rxjava3.core.Maybe r2 = r0.singleElement()
            return r2
        L_0x0049:
            boolean r2 = r1.i
            if (r2 == 0) goto L_0x0052
            io.reactivex.rxjava3.core.Completable r2 = r0.ignoreElements()
            return r2
        L_0x0052:
            io.reactivex.rxjava3.core.Observable r2 = io.reactivex.rxjava3.plugins.RxJavaPlugins.onAssembly(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.a.b.l.e.adapt(retrofit2.Call):java.lang.Object");
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.a;
    }
}
