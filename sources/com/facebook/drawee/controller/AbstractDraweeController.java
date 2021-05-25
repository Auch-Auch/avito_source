package com.facebook.drawee.controller;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.fresco.middleware.MiddlewareUtils;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.ForwardingControllerListener2;
import com.facebook.fresco.ui.common.LoggingListener;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
public abstract class AbstractDraweeController<T, INFO> implements DraweeController, DeferredReleaser.Releasable, GestureDetector.ClickListener {
    public static final Map<String, Object> t = ImmutableMap.of("component_tag", "drawee");
    public static final Map<String, Object> u = ImmutableMap.of("origin", "memory_bitmap", ProducerContext.ExtraKeys.ORIGIN_SUBCATEGORY, "shortcut");
    public static final Class<?> v = AbstractDraweeController.class;
    public final DraweeEventTracker a = DraweeEventTracker.newInstance();
    public final DeferredReleaser b;
    public final Executor c;
    @Nullable
    public RetryManager d;
    @Nullable
    public GestureDetector e;
    @Nullable
    public ControllerViewportVisibilityListener f;
    @Nullable
    public SettableDraweeHierarchy g;
    @Nullable
    public Drawable h;
    public String i;
    public Object j;
    public boolean k;
    public boolean l;
    public boolean m;
    @Nullable
    public ControllerListener<INFO> mControllerListener;
    public ForwardingControllerListener2<INFO> mControllerListener2 = new ForwardingControllerListener2<>();
    @Nullable
    public Drawable mDrawable;
    @Nullable
    public LoggingListener mLoggingListener;
    public boolean n;
    public boolean o;
    @Nullable
    public String p;
    @Nullable
    public DataSource<T> q;
    @Nullable
    public T r;
    public boolean s = true;

    public class a extends BaseDataSubscriber<T> {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<T> dataSource) {
            AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
            String str = this.a;
            Throwable failureCause = dataSource.getFailureCause();
            Map<String, Object> map = AbstractDraweeController.t;
            abstractDraweeController.g(str, dataSource, failureCause, true);
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onNewResultImpl(DataSource<T> dataSource) {
            boolean isFinished = dataSource.isFinished();
            boolean hasMultipleResults = dataSource.hasMultipleResults();
            float progress = dataSource.getProgress();
            T result = dataSource.getResult();
            if (result != null) {
                AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
                String str = this.a;
                boolean z = this.b;
                Map<String, Object> map = AbstractDraweeController.t;
                abstractDraweeController.h(str, dataSource, result, progress, isFinished, z, hasMultipleResults);
            } else if (isFinished) {
                AbstractDraweeController abstractDraweeController2 = AbstractDraweeController.this;
                String str2 = this.a;
                NullPointerException nullPointerException = new NullPointerException();
                Map<String, Object> map2 = AbstractDraweeController.t;
                abstractDraweeController2.g(str2, dataSource, nullPointerException, true);
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onProgressUpdate(DataSource<T> dataSource) {
            boolean isFinished = dataSource.isFinished();
            float progress = dataSource.getProgress();
            AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
            String str = this.a;
            Map<String, Object> map = AbstractDraweeController.t;
            if (!abstractDraweeController.b(str, dataSource)) {
                abstractDraweeController.c("ignore_old_datasource @ onProgress", null);
                dataSource.close();
            } else if (!isFinished) {
                abstractDraweeController.g.setProgress(progress, false);
            }
        }
    }

    public static class b<INFO> extends ForwardingControllerListener<INFO> {
    }

    public AbstractDraweeController(DeferredReleaser deferredReleaser, Executor executor, String str, Object obj) {
        this.b = deferredReleaser;
        this.c = executor;
        a(str, obj);
    }

    public final synchronized void a(String str, Object obj) {
        DeferredReleaser deferredReleaser;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#init");
        }
        this.a.recordEvent(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.s && (deferredReleaser = this.b) != null) {
            deferredReleaser.cancelDeferredRelease(this);
        }
        this.k = false;
        this.m = false;
        i();
        this.o = false;
        RetryManager retryManager = this.d;
        if (retryManager != null) {
            retryManager.init();
        }
        GestureDetector gestureDetector = this.e;
        if (gestureDetector != null) {
            gestureDetector.init();
            this.e.setClickListener(this);
        }
        ControllerListener<INFO> controllerListener = this.mControllerListener;
        if (controllerListener instanceof b) {
            ((b) controllerListener).clearListeners();
        } else {
            this.mControllerListener = null;
        }
        this.f = null;
        SettableDraweeHierarchy settableDraweeHierarchy = this.g;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
            this.g.setControllerOverlay(null);
            this.g = null;
        }
        this.h = null;
        if (FLog.isLoggable(2)) {
            FLog.v(v, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.i, str);
        }
        this.i = str;
        this.j = obj;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        if (this.mLoggingListener != null) {
            SettableDraweeHierarchy settableDraweeHierarchy2 = this.g;
            if (settableDraweeHierarchy2 instanceof GenericDraweeHierarchy) {
                ((GenericDraweeHierarchy) settableDraweeHierarchy2).setOnFadeFinishedListener(new a2.g.m.b.a(this));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.facebook.drawee.controller.ControllerListener<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void addControllerListener(ControllerListener<? super INFO> controllerListener) {
        Preconditions.checkNotNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.mControllerListener;
        if (controllerListener2 instanceof b) {
            ((b) controllerListener2).addListener(controllerListener);
        } else if (controllerListener2 != null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#createInternal");
            }
            b bVar = new b();
            bVar.addListener(controllerListener2);
            bVar.addListener(controllerListener);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            this.mControllerListener = bVar;
        } else {
            this.mControllerListener = controllerListener;
        }
    }

    public void addControllerListener2(ControllerListener2<INFO> controllerListener2) {
        this.mControllerListener2.addListener(controllerListener2);
    }

    public final boolean b(String str, DataSource<T> dataSource) {
        if (dataSource == null && this.q == null) {
            return true;
        }
        if (!str.equals(this.i) || dataSource != this.q || !this.l) {
            return false;
        }
        return true;
    }

    public final void c(String str, Throwable th) {
        if (FLog.isLoggable(2)) {
            FLog.v(v, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.i, str, th);
        }
    }

    public abstract Drawable createDrawable(T t2);

    public final void d(String str, T t2) {
        if (FLog.isLoggable(2)) {
            FLog.v(v, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.i, str, getImageClass(t2), Integer.valueOf(getImageHash(t2)));
        }
    }

    public final ControllerListener2.Extras e(@Nullable DataSource<T> dataSource, @Nullable INFO info, @Nullable Uri uri) {
        return f(dataSource == null ? null : dataSource.getExtras(), obtainExtrasFromImage(info), uri);
    }

    public final ControllerListener2.Extras f(@Nullable Map<String, Object> map, @Nullable Map<String, Object> map2, @Nullable Uri uri) {
        PointF pointF;
        String str;
        SettableDraweeHierarchy settableDraweeHierarchy = this.g;
        Rect rect = null;
        if (settableDraweeHierarchy instanceof GenericDraweeHierarchy) {
            str = String.valueOf(((GenericDraweeHierarchy) settableDraweeHierarchy).getActualImageScaleType());
            pointF = ((GenericDraweeHierarchy) this.g).getActualImageFocusPoint();
        } else {
            str = null;
            pointF = null;
        }
        Map<String, Object> map3 = t;
        Map<String, Object> map4 = u;
        SettableDraweeHierarchy settableDraweeHierarchy2 = this.g;
        if (settableDraweeHierarchy2 != null) {
            rect = settableDraweeHierarchy2.getBounds();
        }
        return MiddlewareUtils.obtainExtras(map3, map4, map, rect, str, pointF, map2, getCallerContext(), uri);
    }

    public final void g(String str, DataSource<T> dataSource, Throwable th, boolean z) {
        Drawable drawable;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#onFailureInternal");
        }
        if (!b(str, dataSource)) {
            c("ignore_old_datasource @ onFailure", th);
            dataSource.close();
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
                return;
            }
            return;
        }
        this.a.recordEvent(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            c("final_failed @ onFailure", th);
            this.q = null;
            this.n = true;
            if (this.o && (drawable = this.mDrawable) != null) {
                this.g.setImage(drawable, 1.0f, true);
            } else if (k()) {
                this.g.setRetry(th);
            } else {
                this.g.setFailure(th);
            }
            ControllerListener2.Extras e2 = e(dataSource, null, null);
            getControllerListener().onFailure(this.i, th);
            getControllerListener2().onFailure(this.i, th, e2);
        } else {
            c("intermediate_failed @ onFailure", th);
            getControllerListener().onIntermediateImageFailed(this.i, th);
            getControllerListener2().onIntermediateImageFailed(this.i);
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public Animatable getAnimatable() {
        Drawable drawable = this.mDrawable;
        if (drawable instanceof Animatable) {
            return (Animatable) drawable;
        }
        return null;
    }

    @Nullable
    public T getCachedImage() {
        return null;
    }

    public Object getCallerContext() {
        return this.j;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public String getContentDescription() {
        return this.p;
    }

    public ControllerListener<INFO> getControllerListener() {
        ControllerListener<INFO> controllerListener = this.mControllerListener;
        return controllerListener == null ? BaseControllerListener.getNoOpListener() : controllerListener;
    }

    public ControllerListener2<INFO> getControllerListener2() {
        return this.mControllerListener2;
    }

    @Nullable
    public Drawable getControllerOverlay() {
        return this.h;
    }

    public abstract DataSource<T> getDataSource();

    @Nullable
    public GestureDetector getGestureDetector() {
        return this.e;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public DraweeHierarchy getHierarchy() {
        return this.g;
    }

    public String getId() {
        return this.i;
    }

    public String getImageClass(@Nullable T t2) {
        return t2 != null ? t2.getClass().getSimpleName() : "<null>";
    }

    public int getImageHash(@Nullable T t2) {
        return System.identityHashCode(t2);
    }

    @Nullable
    public abstract INFO getImageInfo(T t2);

    @Nullable
    public LoggingListener getLoggingListener() {
        return this.mLoggingListener;
    }

    @Nullable
    public Uri getMainUri() {
        return null;
    }

    @ReturnsOwnership
    public RetryManager getRetryManager() {
        if (this.d == null) {
            this.d = new RetryManager();
        }
        return this.d;
    }

    public final void h(String str, DataSource<T> dataSource, @Nullable T t2, float f2, boolean z, boolean z2, boolean z3) {
        boolean isTracing;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#onNewResultInternal");
            }
            if (!b(str, dataSource)) {
                d("ignore_old_datasource @ onNewResult", t2);
                releaseImage(t2);
                dataSource.close();
                if (!isTracing) {
                    return;
                }
                return;
            }
            this.a.recordEvent(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
            try {
                Drawable createDrawable = createDrawable(t2);
                T t3 = this.r;
                Drawable drawable = this.mDrawable;
                this.r = t2;
                this.mDrawable = createDrawable;
                if (z) {
                    try {
                        d("set_final_result @ onNewResult", t2);
                        this.q = null;
                        this.g.setImage(createDrawable, 1.0f, z2);
                        j(str, t2, dataSource);
                    } catch (Throwable th) {
                        if (!(drawable == null || drawable == createDrawable)) {
                            releaseDrawable(drawable);
                        }
                        if (!(t3 == null || t3 == t2)) {
                            d("release_previous_result @ onNewResult", t3);
                            releaseImage(t3);
                        }
                        throw th;
                    }
                } else if (z3) {
                    d("set_temporary_result @ onNewResult", t2);
                    this.g.setImage(createDrawable, 1.0f, z2);
                    j(str, t2, dataSource);
                } else {
                    d("set_intermediate_result @ onNewResult", t2);
                    this.g.setImage(createDrawable, f2, z2);
                    INFO imageInfo = getImageInfo(t2);
                    getControllerListener().onIntermediateImageSet(str, imageInfo);
                    getControllerListener2().onIntermediateImageSet(str, imageInfo);
                }
                if (!(drawable == null || drawable == createDrawable)) {
                    releaseDrawable(drawable);
                }
                if (!(t3 == null || t3 == t2)) {
                    d("release_previous_result @ onNewResult", t3);
                    releaseImage(t3);
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } catch (Exception e2) {
                d("drawable_failed @ onNewResult", t2);
                releaseImage(t2);
                g(str, dataSource, e2, z);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public final void i() {
        Map<String, Object> map;
        Map<String, Object> map2;
        boolean z = this.l;
        this.l = false;
        this.n = false;
        DataSource<T> dataSource = this.q;
        if (dataSource != null) {
            map = dataSource.getExtras();
            this.q.close();
            this.q = null;
        } else {
            map = null;
        }
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            releaseDrawable(drawable);
        }
        if (this.p != null) {
            this.p = null;
        }
        this.mDrawable = null;
        T t2 = this.r;
        if (t2 != null) {
            map2 = obtainExtrasFromImage(getImageInfo(t2));
            d("release", this.r);
            releaseImage(this.r);
            this.r = null;
        } else {
            map2 = null;
        }
        if (z) {
            getControllerListener().onRelease(this.i);
            getControllerListener2().onRelease(this.i, f(map, map2, null));
        }
    }

    public void initialize(String str, Object obj) {
        a(str, obj);
        this.s = false;
    }

    public final void j(String str, @Nullable T t2, @Nullable DataSource<T> dataSource) {
        INFO imageInfo = getImageInfo(t2);
        getControllerListener().onFinalImageSet(str, imageInfo, getAnimatable());
        getControllerListener2().onFinalImageSet(str, imageInfo, e(dataSource, imageInfo, null));
    }

    public final boolean k() {
        RetryManager retryManager;
        return this.n && (retryManager = this.d) != null && retryManager.shouldRetryOnTap();
    }

    @Nullable
    public abstract Map<String, Object> obtainExtrasFromImage(INFO info);

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onAttach() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#onAttach");
        }
        if (FLog.isLoggable(2)) {
            FLog.v(v, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.i, this.l ? "request already submitted" : "request needs submit");
        }
        this.a.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        Preconditions.checkNotNull(this.g);
        this.b.cancelDeferredRelease(this);
        this.k = true;
        if (!this.l) {
            submitRequest();
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    @Override // com.facebook.drawee.gestures.GestureDetector.ClickListener
    public boolean onClick() {
        if (FLog.isLoggable(2)) {
            FLog.v(v, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.i);
        }
        if (!k()) {
            return false;
        }
        this.d.notifyTapToRetry();
        this.g.reset();
        submitRequest();
        return true;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onDetach() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#onDetach");
        }
        if (FLog.isLoggable(2)) {
            FLog.v(v, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.i);
        }
        this.a.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.k = false;
        this.b.scheduleDeferredRelease(this);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public void onImageLoadedFromCacheImmediately(String str, T t2) {
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (FLog.isLoggable(2)) {
            FLog.v(v, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.i, motionEvent);
        }
        GestureDetector gestureDetector = this.e;
        if (gestureDetector == null) {
            return false;
        }
        if (!gestureDetector.isCapturingGesture() && !shouldHandleGesture()) {
            return false;
        }
        this.e.onTouchEvent(motionEvent);
        return true;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onViewportVisibilityHint(boolean z) {
        ControllerViewportVisibilityListener controllerViewportVisibilityListener = this.f;
        if (controllerViewportVisibilityListener != null) {
            if (z && !this.m) {
                controllerViewportVisibilityListener.onDraweeViewportEntry(this.i);
            } else if (!z && this.m) {
                controllerViewportVisibilityListener.onDraweeViewportExit(this.i);
            }
        }
        this.m = z;
    }

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public void release() {
        this.a.recordEvent(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        RetryManager retryManager = this.d;
        if (retryManager != null) {
            retryManager.reset();
        }
        GestureDetector gestureDetector = this.e;
        if (gestureDetector != null) {
            gestureDetector.reset();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.g;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
        }
        i();
    }

    public abstract void releaseDrawable(@Nullable Drawable drawable);

    public abstract void releaseImage(@Nullable T t2);

    public void removeControllerListener(ControllerListener<? super INFO> controllerListener) {
        Preconditions.checkNotNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.mControllerListener;
        if (controllerListener2 instanceof b) {
            ((b) controllerListener2).removeListener(controllerListener);
        } else if (controllerListener2 == controllerListener) {
            this.mControllerListener = null;
        }
    }

    public void removeControllerListener2(ControllerListener2<INFO> controllerListener2) {
        this.mControllerListener2.removeListener(controllerListener2);
    }

    public void reportSubmit(DataSource<T> dataSource, @Nullable INFO info) {
        getControllerListener().onSubmit(this.i, this.j);
        getControllerListener2().onSubmit(this.i, this.j, e(dataSource, info, getMainUri()));
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void setContentDescription(@Nullable String str) {
        this.p = str;
    }

    public void setControllerOverlay(@Nullable Drawable drawable) {
        this.h = drawable;
        SettableDraweeHierarchy settableDraweeHierarchy = this.g;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.setControllerOverlay(drawable);
        }
    }

    public void setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener controllerViewportVisibilityListener) {
        this.f = controllerViewportVisibilityListener;
    }

    public void setGestureDetector(@Nullable GestureDetector gestureDetector) {
        this.e = gestureDetector;
        if (gestureDetector != null) {
            gestureDetector.setClickListener(this);
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void setHierarchy(@Nullable DraweeHierarchy draweeHierarchy) {
        if (FLog.isLoggable(2)) {
            FLog.v(v, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.i, draweeHierarchy);
        }
        this.a.recordEvent(draweeHierarchy != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.l) {
            this.b.cancelDeferredRelease(this);
            release();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.g;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.setControllerOverlay(null);
            this.g = null;
        }
        if (draweeHierarchy != null) {
            Preconditions.checkArgument(draweeHierarchy instanceof SettableDraweeHierarchy);
            SettableDraweeHierarchy settableDraweeHierarchy2 = (SettableDraweeHierarchy) draweeHierarchy;
            this.g = settableDraweeHierarchy2;
            settableDraweeHierarchy2.setControllerOverlay(this.h);
        }
        if (this.mLoggingListener != null) {
            SettableDraweeHierarchy settableDraweeHierarchy3 = this.g;
            if (settableDraweeHierarchy3 instanceof GenericDraweeHierarchy) {
                ((GenericDraweeHierarchy) settableDraweeHierarchy3).setOnFadeFinishedListener(new a2.g.m.b.a(this));
            }
        }
    }

    public void setLoggingListener(LoggingListener loggingListener) {
        this.mLoggingListener = loggingListener;
    }

    public void setRetainImageOnFailure(boolean z) {
        this.o = z;
    }

    public boolean shouldHandleGesture() {
        return k();
    }

    public void submitRequest() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#submitRequest");
        }
        T cachedImage = getCachedImage();
        if (cachedImage != null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#submitRequest->cache");
            }
            this.q = null;
            this.l = true;
            this.n = false;
            this.a.recordEvent(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            reportSubmit(this.q, getImageInfo(cachedImage));
            onImageLoadedFromCacheImmediately(this.i, cachedImage);
            h(this.i, this.q, cachedImage, 1.0f, true, true, true);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
                return;
            }
            return;
        }
        this.a.recordEvent(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        this.g.setProgress(0.0f, true);
        this.l = true;
        this.n = false;
        DataSource<T> dataSource = getDataSource();
        this.q = dataSource;
        reportSubmit(dataSource, null);
        if (FLog.isLoggable(2)) {
            FLog.v(v, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.i, Integer.valueOf(System.identityHashCode(this.q)));
        }
        this.q.subscribe(new a(this.i, this.q.hasResult()), this.c);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public String toString() {
        return Objects.toStringHelper(this).add("isAttached", this.k).add("isRequestSubmitted", this.l).add("hasFetchFailed", this.n).add("fetchedImage", getImageHash(this.r)).add("events", this.a.toString()).toString();
    }
}
