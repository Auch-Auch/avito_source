package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    public static final boolean D = Log.isLoggable("Request", 2);
    @GuardedBy("requestLock")
    public int A;
    @GuardedBy("requestLock")
    public boolean B;
    @Nullable
    public RuntimeException C;
    @Nullable
    public final String a;
    public final StateVerifier b;
    public final Object c;
    @Nullable
    public final RequestListener<R> d;
    public final RequestCoordinator e;
    public final Context f;
    public final GlideContext g;
    @Nullable
    public final Object h;
    public final Class<R> i;
    public final BaseRequestOptions<?> j;
    public final int k;
    public final int l;
    public final Priority m;
    public final Target<R> n;
    @Nullable
    public final List<RequestListener<R>> o;
    public final TransitionFactory<? super R> p;
    public final Executor q;
    @GuardedBy("requestLock")
    public Resource<R> r;
    @GuardedBy("requestLock")
    public Engine.LoadStatus s;
    @GuardedBy("requestLock")
    public long t;
    public volatile Engine u;
    @GuardedBy("requestLock")
    public a v;
    @Nullable
    @GuardedBy("requestLock")
    public Drawable w;
    @Nullable
    @GuardedBy("requestLock")
    public Drawable x;
    @Nullable
    @GuardedBy("requestLock")
    public Drawable y;
    @GuardedBy("requestLock")
    public int z;

    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public SingleRequest(Context context, GlideContext glideContext, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i2, int i3, Priority priority, Target<R> target, @Nullable RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.a = D ? String.valueOf(hashCode()) : null;
        this.b = StateVerifier.newInstance();
        this.c = obj;
        this.f = context;
        this.g = glideContext;
        this.h = obj2;
        this.i = cls;
        this.j = baseRequestOptions;
        this.k = i2;
        this.l = i3;
        this.m = priority;
        this.n = target;
        this.d = requestListener;
        this.o = list;
        this.e = requestCoordinator;
        this.u = engine;
        this.p = transitionFactory;
        this.q = executor;
        this.v = a.PENDING;
        if (this.C == null && glideContext.isLoggingRequestOriginsEnabled()) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i2, int i3, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest<>(context, glideContext, obj, obj2, cls, baseRequestOptions, i2, i3, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    @GuardedBy("requestLock")
    public final void a() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    public final Drawable b() {
        if (this.y == null) {
            Drawable fallbackDrawable = this.j.getFallbackDrawable();
            this.y = fallbackDrawable;
            if (fallbackDrawable == null && this.j.getFallbackId() > 0) {
                this.y = e(this.j.getFallbackId());
            }
        }
        return this.y;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0080  */
    @Override // com.bumptech.glide.request.Request
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void begin() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.c
            monitor-enter(r0)
            r5.a()     // Catch:{ all -> 0x009c }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.b     // Catch:{ all -> 0x009c }
            r1.throwIfRecycled()     // Catch:{ all -> 0x009c }
            long r1 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x009c }
            r5.t = r1     // Catch:{ all -> 0x009c }
            java.lang.Object r1 = r5.h     // Catch:{ all -> 0x009c }
            if (r1 != 0) goto L_0x003c
            int r1 = r5.k     // Catch:{ all -> 0x009c }
            int r2 = r5.l     // Catch:{ all -> 0x009c }
            boolean r1 = com.bumptech.glide.util.Util.isValidDimensions(r1, r2)     // Catch:{ all -> 0x009c }
            if (r1 == 0) goto L_0x0027
            int r1 = r5.k     // Catch:{ all -> 0x009c }
            r5.z = r1     // Catch:{ all -> 0x009c }
            int r1 = r5.l     // Catch:{ all -> 0x009c }
            r5.A = r1     // Catch:{ all -> 0x009c }
        L_0x0027:
            android.graphics.drawable.Drawable r1 = r5.b()     // Catch:{ all -> 0x009c }
            if (r1 != 0) goto L_0x002f
            r1 = 5
            goto L_0x0030
        L_0x002f:
            r1 = 3
        L_0x0030:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x009c }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x009c }
            r5.f(r2, r1)     // Catch:{ all -> 0x009c }
            monitor-exit(r0)     // Catch:{ all -> 0x009c }
            return
        L_0x003c:
            com.bumptech.glide.request.SingleRequest$a r1 = r5.v     // Catch:{ all -> 0x009c }
            com.bumptech.glide.request.SingleRequest$a r2 = com.bumptech.glide.request.SingleRequest.a.RUNNING     // Catch:{ all -> 0x009c }
            if (r1 == r2) goto L_0x0094
            com.bumptech.glide.request.SingleRequest$a r3 = com.bumptech.glide.request.SingleRequest.a.COMPLETE     // Catch:{ all -> 0x009c }
            if (r1 != r3) goto L_0x004f
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.r     // Catch:{ all -> 0x009c }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x009c }
            r5.onResourceReady(r1, r2)     // Catch:{ all -> 0x009c }
            monitor-exit(r0)     // Catch:{ all -> 0x009c }
            return
        L_0x004f:
            com.bumptech.glide.request.SingleRequest$a r1 = com.bumptech.glide.request.SingleRequest.a.WAITING_FOR_SIZE     // Catch:{ all -> 0x009c }
            r5.v = r1     // Catch:{ all -> 0x009c }
            int r3 = r5.k     // Catch:{ all -> 0x009c }
            int r4 = r5.l     // Catch:{ all -> 0x009c }
            boolean r3 = com.bumptech.glide.util.Util.isValidDimensions(r3, r4)     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x0065
            int r3 = r5.k     // Catch:{ all -> 0x009c }
            int r4 = r5.l     // Catch:{ all -> 0x009c }
            r5.onSizeReady(r3, r4)     // Catch:{ all -> 0x009c }
            goto L_0x006a
        L_0x0065:
            com.bumptech.glide.request.target.Target<R> r3 = r5.n     // Catch:{ all -> 0x009c }
            r3.getSize(r5)     // Catch:{ all -> 0x009c }
        L_0x006a:
            com.bumptech.glide.request.SingleRequest$a r3 = r5.v     // Catch:{ all -> 0x009c }
            if (r3 == r2) goto L_0x0070
            if (r3 != r1) goto L_0x0089
        L_0x0070:
            com.bumptech.glide.request.RequestCoordinator r1 = r5.e     // Catch:{ all -> 0x009c }
            if (r1 == 0) goto L_0x007d
            boolean r1 = r1.canNotifyStatusChanged(r5)     // Catch:{ all -> 0x009c }
            if (r1 == 0) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            r1 = 0
            goto L_0x007e
        L_0x007d:
            r1 = 1
        L_0x007e:
            if (r1 == 0) goto L_0x0089
            com.bumptech.glide.request.target.Target<R> r1 = r5.n     // Catch:{ all -> 0x009c }
            android.graphics.drawable.Drawable r2 = r5.c()     // Catch:{ all -> 0x009c }
            r1.onLoadStarted(r2)     // Catch:{ all -> 0x009c }
        L_0x0089:
            boolean r1 = com.bumptech.glide.request.SingleRequest.D     // Catch:{ all -> 0x009c }
            if (r1 == 0) goto L_0x0092
            long r1 = r5.t     // Catch:{ all -> 0x009c }
            com.bumptech.glide.util.LogTime.getElapsedMillis(r1)     // Catch:{ all -> 0x009c }
        L_0x0092:
            monitor-exit(r0)     // Catch:{ all -> 0x009c }
            return
        L_0x0094:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x009c }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x009c }
            throw r1     // Catch:{ all -> 0x009c }
        L_0x009c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.begin():void");
    }

    @GuardedBy("requestLock")
    public final Drawable c() {
        if (this.x == null) {
            Drawable placeholderDrawable = this.j.getPlaceholderDrawable();
            this.x = placeholderDrawable;
            if (placeholderDrawable == null && this.j.getPlaceholderId() > 0) {
                this.x = e(this.j.getPlaceholderId());
            }
        }
        return this.x;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    @Override // com.bumptech.glide.request.Request
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.c
            monitor-enter(r0)
            r5.a()     // Catch:{ all -> 0x0055 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.b     // Catch:{ all -> 0x0055 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x0055 }
            com.bumptech.glide.request.SingleRequest$a r1 = r5.v     // Catch:{ all -> 0x0055 }
            com.bumptech.glide.request.SingleRequest$a r2 = com.bumptech.glide.request.SingleRequest.a.CLEARED     // Catch:{ all -> 0x0055 }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x0013:
            r5.a()     // Catch:{ all -> 0x0055 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.b     // Catch:{ all -> 0x0055 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x0055 }
            com.bumptech.glide.request.target.Target<R> r1 = r5.n     // Catch:{ all -> 0x0055 }
            r1.removeCallback(r5)     // Catch:{ all -> 0x0055 }
            com.bumptech.glide.load.engine.Engine$LoadStatus r1 = r5.s     // Catch:{ all -> 0x0055 }
            r3 = 0
            if (r1 == 0) goto L_0x002a
            r1.cancel()     // Catch:{ all -> 0x0055 }
            r5.s = r3     // Catch:{ all -> 0x0055 }
        L_0x002a:
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.r     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x0031
            r5.r = r3     // Catch:{ all -> 0x0055 }
            r3 = r1
        L_0x0031:
            com.bumptech.glide.request.RequestCoordinator r1 = r5.e     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x003e
            boolean r1 = r1.canNotifyCleared(r5)     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r1 = 0
            goto L_0x003f
        L_0x003e:
            r1 = 1
        L_0x003f:
            if (r1 == 0) goto L_0x004a
            com.bumptech.glide.request.target.Target<R> r1 = r5.n     // Catch:{ all -> 0x0055 }
            android.graphics.drawable.Drawable r4 = r5.c()     // Catch:{ all -> 0x0055 }
            r1.onLoadCleared(r4)     // Catch:{ all -> 0x0055 }
        L_0x004a:
            r5.v = r2     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            if (r3 == 0) goto L_0x0054
            com.bumptech.glide.load.engine.Engine r0 = r5.u
            r0.release(r3)
        L_0x0054:
            return
        L_0x0055:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    @GuardedBy("requestLock")
    public final boolean d() {
        RequestCoordinator requestCoordinator = this.e;
        return requestCoordinator == null || !requestCoordinator.getRoot().isAnyResourceSet();
    }

    @GuardedBy("requestLock")
    public final Drawable e(@DrawableRes int i2) {
        return DrawableDecoderCompat.getDrawable(this.g, i2, this.j.getTheme() != null ? this.j.getTheme() : this.f.getTheme());
    }

    /* JADX INFO: finally extract failed */
    public final void f(GlideException glideException, int i2) {
        boolean z2;
        this.b.throwIfRecycled();
        synchronized (this.c) {
            glideException.setOrigin(this.C);
            int logLevel = this.g.getLogLevel();
            if (logLevel <= i2) {
                String str = "Load failed for " + this.h + " with size [" + this.z + "x" + this.A + "]";
                if (logLevel <= 4) {
                    glideException.logRootCauses("Glide");
                }
            }
            this.s = null;
            this.v = a.FAILED;
            boolean z3 = true;
            this.B = true;
            try {
                List<RequestListener<R>> list = this.o;
                if (list != null) {
                    z2 = false;
                    for (RequestListener<R> requestListener : list) {
                        z2 |= requestListener.onLoadFailed(glideException, this.h, this.n, d());
                    }
                } else {
                    z2 = false;
                }
                RequestListener<R> requestListener2 = this.d;
                if (requestListener2 == null || !requestListener2.onLoadFailed(glideException, this.h, this.n, d())) {
                    z3 = false;
                }
                if (!z2 && !z3) {
                    h();
                }
                this.B = false;
                RequestCoordinator requestCoordinator = this.e;
                if (requestCoordinator != null) {
                    requestCoordinator.onRequestFailed(this);
                }
            } catch (Throwable th) {
                this.B = false;
                throw th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @GuardedBy("requestLock")
    public final void g(Resource<R> resource, R r2, DataSource dataSource) {
        boolean z2;
        boolean d2 = d();
        this.v = a.COMPLETE;
        this.r = resource;
        if (this.g.getLogLevel() <= 3) {
            StringBuilder L = a2.b.a.a.a.L("Finished loading ");
            L.append(r2.getClass().getSimpleName());
            L.append(" from ");
            L.append(dataSource);
            L.append(" for ");
            L.append(this.h);
            L.append(" with size [");
            L.append(this.z);
            L.append("x");
            L.append(this.A);
            L.append("] in ");
            L.append(LogTime.getElapsedMillis(this.t));
            L.append(" ms");
            L.toString();
        }
        boolean z3 = true;
        this.B = true;
        try {
            List<RequestListener<R>> list = this.o;
            if (list != null) {
                z2 = false;
                for (RequestListener<R> requestListener : list) {
                    z2 |= requestListener.onResourceReady(r2, this.h, this.n, dataSource, d2);
                }
            } else {
                z2 = false;
            }
            RequestListener<R> requestListener2 = this.d;
            if (requestListener2 == null || !requestListener2.onResourceReady(r2, this.h, this.n, dataSource, d2)) {
                z3 = false;
            }
            if (!z3 && !z2) {
                this.n.onResourceReady(r2, this.p.build(dataSource, d2));
            }
            this.B = false;
            RequestCoordinator requestCoordinator = this.e;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestSuccess(this);
            }
        } catch (Throwable th) {
            this.B = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public Object getLock() {
        this.b.throwIfRecycled();
        return this.c;
    }

    @GuardedBy("requestLock")
    public final void h() {
        RequestCoordinator requestCoordinator = this.e;
        if (requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this)) {
            Drawable drawable = null;
            if (this.h == null) {
                drawable = b();
            }
            if (drawable == null) {
                if (this.w == null) {
                    Drawable errorPlaceholder = this.j.getErrorPlaceholder();
                    this.w = errorPlaceholder;
                    if (errorPlaceholder == null && this.j.getErrorId() > 0) {
                        this.w = e(this.j.getErrorId());
                    }
                }
                drawable = this.w;
            }
            if (drawable == null) {
                drawable = c();
            }
            this.n.onLoadFailed(drawable);
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        boolean z2;
        synchronized (this.c) {
            z2 = this.v == a.COMPLETE;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z2;
        synchronized (this.c) {
            z2 = this.v == a.CLEARED;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z2;
        synchronized (this.c) {
            z2 = this.v == a.COMPLETE;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request request) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority2;
        int size2;
        if (!(request instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.c) {
            i2 = this.k;
            i3 = this.l;
            obj = this.h;
            cls = this.i;
            baseRequestOptions = this.j;
            priority = this.m;
            List<RequestListener<R>> list = this.o;
            size = list != null ? list.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) request;
        synchronized (singleRequest.c) {
            i4 = singleRequest.k;
            i5 = singleRequest.l;
            obj2 = singleRequest.h;
            cls2 = singleRequest.i;
            baseRequestOptions2 = singleRequest.j;
            priority2 = singleRequest.m;
            List<RequestListener<R>> list2 = singleRequest.o;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i2 == i4 && i3 == i5 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && size == size2;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z2;
        synchronized (this.c) {
            a aVar = this.v;
            if (aVar != a.RUNNING) {
                if (aVar != a.WAITING_FOR_SIZE) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(GlideException glideException) {
        f(glideException, 5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.bumptech.glide.request.SingleRequest<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    public void onResourceReady(Resource<?> resource, DataSource dataSource) {
        Throwable th;
        this.b.throwIfRecycled();
        try {
            synchronized (this.c) {
                try {
                    this.s = null;
                    if (resource == null) {
                        onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.i + " inside, but instead got null."));
                        return;
                    }
                    Object obj = resource.get();
                    if (obj != null) {
                        if (this.i.isAssignableFrom(obj.getClass())) {
                            RequestCoordinator requestCoordinator = this.e;
                            if (!(requestCoordinator == null || requestCoordinator.canSetImage(this))) {
                                try {
                                    this.r = null;
                                    this.v = a.COMPLETE;
                                    this.u.release(resource);
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            } else {
                                g(resource, obj, dataSource);
                                return;
                            }
                        }
                    }
                    this.r = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected to receive an object of ");
                    sb.append(this.i);
                    sb.append(" but instead got ");
                    sb.append(obj != null ? obj.getClass() : "");
                    sb.append("{");
                    sb.append(obj);
                    sb.append("} inside Resource{");
                    sb.append(resource);
                    sb.append("}.");
                    sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                    onLoadFailed(new GlideException(sb.toString()));
                    this.u.release(resource);
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        } catch (Throwable th4) {
            if (0 != 0) {
                this.u.release(null);
            }
            throw th4;
        }
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i2, int i3) {
        Object obj;
        Throwable th;
        int i4;
        int i5 = i2;
        this.b.throwIfRecycled();
        Object obj2 = this.c;
        synchronized (obj2) {
            try {
                boolean z2 = D;
                if (z2) {
                    LogTime.getElapsedMillis(this.t);
                }
                if (this.v == a.WAITING_FOR_SIZE) {
                    a aVar = a.RUNNING;
                    this.v = aVar;
                    float sizeMultiplier = this.j.getSizeMultiplier();
                    if (i5 != Integer.MIN_VALUE) {
                        i5 = Math.round(((float) i5) * sizeMultiplier);
                    }
                    this.z = i5;
                    if (i3 == Integer.MIN_VALUE) {
                        i4 = i3;
                    } else {
                        i4 = Math.round(sizeMultiplier * ((float) i3));
                    }
                    this.A = i4;
                    if (z2) {
                        LogTime.getElapsedMillis(this.t);
                    }
                    Engine engine = this.u;
                    GlideContext glideContext = this.g;
                    Object obj3 = this.h;
                    Key signature = this.j.getSignature();
                    int i6 = this.z;
                    int i7 = this.A;
                    Class<?> resourceClass = this.j.getResourceClass();
                    Class<R> cls = this.i;
                    Priority priority = this.m;
                    DiskCacheStrategy diskCacheStrategy = this.j.getDiskCacheStrategy();
                    Map<Class<?>, Transformation<?>> transformations = this.j.getTransformations();
                    boolean isTransformationRequired = this.j.isTransformationRequired();
                    BaseRequestOptions<?> baseRequestOptions = this.j;
                    obj = obj2;
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                        while (true) {
                            try {
                                break;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        throw th;
                    }
                    try {
                        this.s = engine.load(glideContext, obj3, signature, i6, i7, resourceClass, cls, priority, diskCacheStrategy, transformations, isTransformationRequired, baseRequestOptions.y, baseRequestOptions.getOptions(), this.j.isMemoryCacheable(), this.j.getUseUnlimitedSourceGeneratorsPool(), this.j.getUseAnimationPool(), this.j.getOnlyRetrieveFromCache(), this, this.q);
                        if (this.v != aVar) {
                            this.s = null;
                        }
                        if (z2) {
                            LogTime.getElapsedMillis(this.t);
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        while (true) {
                            break;
                        }
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                obj = obj2;
                while (true) {
                    break;
                }
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.c) {
            if (isRunning()) {
                clear();
            }
        }
    }
}
