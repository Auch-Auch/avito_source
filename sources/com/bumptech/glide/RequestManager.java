package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
public class RequestManager implements ComponentCallbacks2, LifecycleListener {
    public static final RequestOptions k = ((RequestOptions) RequestOptions.decodeTypeOf(Bitmap.class).lock());
    public static final RequestOptions l = ((RequestOptions) RequestOptions.decodeTypeOf(GifDrawable.class).lock());
    public static final RequestOptions m = ((RequestOptions) ((RequestOptions) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW)).skipMemoryCache(true));
    public final Lifecycle a;
    @GuardedBy("this")
    public final RequestTracker b;
    @GuardedBy("this")
    public final RequestManagerTreeNode c;
    public final Context context;
    @GuardedBy("this")
    public final TargetTracker d = new TargetTracker();
    public final Runnable e;
    public final Handler f;
    public final ConnectivityMonitor g;
    public final Glide glide;
    public final CopyOnWriteArrayList<RequestListener<Object>> h;
    @GuardedBy("this")
    public RequestOptions i;
    public boolean j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestManager requestManager = RequestManager.this;
            requestManager.a.addListener(requestManager);
        }
    }

    public static class b extends CustomViewTarget<View, Object> {
        public b(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }
    }

    public class c implements ConnectivityMonitor.ConnectivityListener {
        @GuardedBy("RequestManager.this")
        public final RequestTracker a;

        public c(@NonNull RequestTracker requestTracker) {
            this.a = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    this.a.restartRequests();
                }
            }
        }
    }

    public RequestManager(@NonNull Glide glide2, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context2) {
        RequestTracker requestTracker = new RequestTracker();
        ConnectivityMonitorFactory connectivityMonitorFactory = glide2.h;
        a aVar = new a();
        this.e = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f = handler;
        this.glide = glide2;
        this.a = lifecycle;
        this.c = requestManagerTreeNode;
        this.b = requestTracker;
        this.context = context2;
        ConnectivityMonitor build = connectivityMonitorFactory.build(context2.getApplicationContext(), new c(requestTracker));
        this.g = build;
        if (Util.isOnBackgroundThread()) {
            handler.post(aVar);
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(build);
        this.h = new CopyOnWriteArrayList<>(glide2.d.getDefaultRequestListeners());
        setRequestOptions(glide2.d.getDefaultRequestOptions());
        synchronized (glide2.i) {
            if (!glide2.i.contains(this)) {
                glide2.i.add(this);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    public synchronized boolean a(@NonNull Target<?> target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.b.clearAndRemove(request)) {
            return false;
        }
        this.d.untrack(target);
        target.setRequest(null);
        return true;
    }

    public RequestManager addDefaultRequestListener(RequestListener<Object> requestListener) {
        this.h.add(requestListener);
        return this;
    }

    @NonNull
    public synchronized RequestManager applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        synchronized (this) {
            this.i = (RequestOptions) this.i.apply(requestOptions);
        }
        return this;
        return this;
    }

    @NonNull
    @CheckResult
    public <ResourceType> RequestBuilder<ResourceType> as(@NonNull Class<ResourceType> cls) {
        return new RequestBuilder<>(this.glide, this, cls, this.context);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Bitmap> asBitmap() {
        return as(Bitmap.class).apply((BaseRequestOptions<?>) k);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> asFile() {
        return as(File.class).apply((BaseRequestOptions<?>) RequestOptions.skipMemoryCacheOf(true));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<GifDrawable> asGif() {
        return as(GifDrawable.class).apply((BaseRequestOptions<?>) l);
    }

    public void clear(@NonNull View view) {
        clear(new b(view));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> download(@Nullable Object obj) {
        return downloadOnly().load(obj);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> downloadOnly() {
        return as(File.class).apply((BaseRequestOptions<?>) m);
    }

    public synchronized boolean isPaused() {
        return this.b.isPaused();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onDestroy() {
        this.d.onDestroy();
        for (Target<?> target : this.d.getAll()) {
            clear(target);
        }
        this.d.clear();
        this.b.clearRequests();
        this.a.removeListener(this);
        this.a.removeListener(this.g);
        this.f.removeCallbacks(this.e);
        Glide glide2 = this.glide;
        synchronized (glide2.i) {
            if (glide2.i.contains(this)) {
                glide2.i.remove(this);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStart() {
        resumeRequests();
        this.d.onStart();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStop() {
        pauseRequests();
        this.d.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.j) {
            pauseAllRequestsRecursive();
        }
    }

    public synchronized void pauseAllRequests() {
        this.b.pauseAllRequests();
    }

    public synchronized void pauseAllRequestsRecursive() {
        pauseAllRequests();
        for (RequestManager requestManager : this.c.getDescendants()) {
            requestManager.pauseAllRequests();
        }
    }

    public synchronized void pauseRequests() {
        this.b.pauseRequests();
    }

    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        for (RequestManager requestManager : this.c.getDescendants()) {
            requestManager.pauseRequests();
        }
    }

    public synchronized void resumeRequests() {
        this.b.resumeRequests();
    }

    public synchronized void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        for (RequestManager requestManager : this.c.getDescendants()) {
            requestManager.resumeRequests();
        }
    }

    @NonNull
    public synchronized RequestManager setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        setRequestOptions(requestOptions);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        this.j = z;
    }

    public synchronized void setRequestOptions(@NonNull RequestOptions requestOptions) {
        this.i = (RequestOptions) ((RequestOptions) requestOptions.clone()).autoClone();
    }

    @Override // java.lang.Object
    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.b + ", treeNode=" + this.c + "}";
    }

    public void clear(@Nullable Target<?> target) {
        boolean z;
        if (target != null) {
            boolean a3 = a(target);
            Request request = target.getRequest();
            if (!a3) {
                Glide glide2 = this.glide;
                synchronized (glide2.i) {
                    Iterator<RequestManager> it = glide2.i.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().a(target)) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                }
                if (!z && request != null) {
                    target.setRequest(null);
                    request.clear();
                }
            }
        }
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Bitmap bitmap) {
        return asDrawable().load(bitmap);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Drawable drawable) {
        return asDrawable().load(drawable);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable String str) {
        return asDrawable().load(str);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Uri uri) {
        return asDrawable().load(uri);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable File file) {
        return asDrawable().load(file);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable @DrawableRes @RawRes Integer num) {
        return asDrawable().load(num);
    }

    @CheckResult
    @Deprecated
    public RequestBuilder<Drawable> load(@Nullable URL url) {
        return asDrawable().load(url);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable byte[] bArr) {
        return asDrawable().load(bArr);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> load(@Nullable Object obj) {
        return asDrawable().load(obj);
    }
}
