package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.LoggingListener;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements SimpleDraweeControllerBuilder {
    public static final ControllerListener<Object> r = new a();
    public static final NullPointerException s = new NullPointerException("No image request was specified!");
    public static final AtomicLong t = new AtomicLong();
    public final Context a;
    public final Set<ControllerListener> b;
    public final Set<ControllerListener2> c;
    @Nullable
    public Object d;
    @Nullable
    public REQUEST e;
    @Nullable
    public REQUEST f;
    @Nullable
    public REQUEST[] g;
    public boolean h;
    @Nullable
    public Supplier<DataSource<IMAGE>> i;
    @Nullable
    public ControllerListener<? super INFO> j;
    @Nullable
    public LoggingListener k;
    @Nullable
    public ControllerViewportVisibilityListener l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    @Nullable
    public DraweeController q;

    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    public static class a extends BaseControllerListener<Object> {
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    public class b implements Supplier<DataSource<IMAGE>> {
        public final /* synthetic */ DraweeController a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ CacheLevel e;

        public b(DraweeController draweeController, String str, Object obj, Object obj2, CacheLevel cacheLevel) {
            this.a = draweeController;
            this.b = str;
            this.c = obj;
            this.d = obj2;
            this.e = cacheLevel;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.drawee.controller.AbstractDraweeControllerBuilder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.facebook.common.internal.Supplier
        public Object get() {
            return AbstractDraweeControllerBuilder.this.getDataSourceForRequest(this.a, this.b, this.c, this.d, this.e);
        }

        public String toString() {
            return Objects.toStringHelper(this).add("request", this.c.toString()).toString();
        }
    }

    public AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set, Set<ControllerListener2> set2) {
        this.a = context;
        this.b = set;
        this.c = set2;
        a();
    }

    public static String generateUniqueControllerId() {
        return String.valueOf(t.getAndIncrement());
    }

    public final void a() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = true;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.q = null;
        this.p = null;
    }

    public AbstractDraweeController buildController() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeControllerBuilder#buildController");
        }
        AbstractDraweeController obtainController = obtainController();
        obtainController.setRetainImageOnFailure(getRetainImageOnFailure());
        obtainController.setContentDescription(getContentDescription());
        obtainController.setControllerViewportVisibilityListener(getControllerViewportVisibilityListener());
        maybeBuildAndSetRetryManager(obtainController);
        maybeAttachListeners(obtainController);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return obtainController;
    }

    public boolean getAutoPlayAnimations() {
        return this.n;
    }

    @Nullable
    public Object getCallerContext() {
        return this.d;
    }

    @Nullable
    public String getContentDescription() {
        return this.p;
    }

    public Context getContext() {
        return this.a;
    }

    @Nullable
    public ControllerListener<? super INFO> getControllerListener() {
        return this.j;
    }

    @Nullable
    public ControllerViewportVisibilityListener getControllerViewportVisibilityListener() {
        return this.l;
    }

    public abstract DataSource<IMAGE> getDataSourceForRequest(DraweeController draweeController, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    @Nullable
    public Supplier<DataSource<IMAGE>> getDataSourceSupplier() {
        return this.i;
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController draweeController, String str, REQUEST request) {
        return getDataSourceSupplierForRequest(draweeController, str, request, CacheLevel.FULL_FETCH);
    }

    public Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(DraweeController draweeController, String str, REQUEST[] requestArr, boolean z) {
        ArrayList arrayList = new ArrayList(requestArr.length * 2);
        if (z) {
            for (REQUEST request : requestArr) {
                arrayList.add(getDataSourceSupplierForRequest(draweeController, str, request, CacheLevel.BITMAP_MEMORY_CACHE));
            }
        }
        for (REQUEST request2 : requestArr) {
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, request2));
        }
        return FirstAvailableDataSourceSupplier.create(arrayList);
    }

    @Nullable
    public REQUEST[] getFirstAvailableImageRequests() {
        return this.g;
    }

    @Nullable
    public REQUEST getImageRequest() {
        return this.e;
    }

    @Nullable
    public LoggingListener getLoggingListener() {
        return this.k;
    }

    @Nullable
    public REQUEST getLowResImageRequest() {
        return this.f;
    }

    @Nullable
    public DraweeController getOldController() {
        return this.q;
    }

    public boolean getRetainImageOnFailure() {
        return this.o;
    }

    public boolean getTapToRetryEnabled() {
        return this.m;
    }

    public final BUILDER getThis() {
        return this;
    }

    public void maybeAttachListeners(AbstractDraweeController abstractDraweeController) {
        Set<ControllerListener> set = this.b;
        if (set != null) {
            for (ControllerListener controllerListener : set) {
                abstractDraweeController.addControllerListener(controllerListener);
            }
        }
        Set<ControllerListener2> set2 = this.c;
        if (set2 != null) {
            for (ControllerListener2 controllerListener2 : set2) {
                abstractDraweeController.addControllerListener2(controllerListener2);
            }
        }
        ControllerListener<? super INFO> controllerListener3 = this.j;
        if (controllerListener3 != null) {
            abstractDraweeController.addControllerListener(controllerListener3);
        }
        if (this.n) {
            abstractDraweeController.addControllerListener(r);
        }
    }

    public void maybeBuildAndSetGestureDetector(AbstractDraweeController abstractDraweeController) {
        if (abstractDraweeController.getGestureDetector() == null) {
            abstractDraweeController.setGestureDetector(GestureDetector.newInstance(this.a));
        }
    }

    public void maybeBuildAndSetRetryManager(AbstractDraweeController abstractDraweeController) {
        if (this.m) {
            abstractDraweeController.getRetryManager().setTapToRetryEnabled(this.m);
            maybeBuildAndSetGestureDetector(abstractDraweeController);
        }
    }

    @ReturnsOwnership
    public abstract AbstractDraweeController obtainController();

    public Supplier<DataSource<IMAGE>> obtainDataSourceSupplier(DraweeController draweeController, String str) {
        Supplier<DataSource<IMAGE>> supplier = this.i;
        if (supplier != null) {
            return supplier;
        }
        Supplier<DataSource<IMAGE>> supplier2 = null;
        REQUEST request = this.e;
        if (request != null) {
            supplier2 = getDataSourceSupplierForRequest(draweeController, str, request);
        } else {
            REQUEST[] requestArr = this.g;
            if (requestArr != null) {
                supplier2 = getFirstAvailableDataSourceSupplier(draweeController, str, requestArr, this.h);
            }
        }
        if (!(supplier2 == null || this.f == null)) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(supplier2);
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, this.f));
            supplier2 = IncreasingQualityDataSourceSupplier.create(arrayList, false);
        }
        return supplier2 == null ? DataSources.getFailedDataSourceSupplier(s) : supplier2;
    }

    public BUILDER reset() {
        a();
        return getThis();
    }

    public BUILDER setAutoPlayAnimations(boolean z) {
        this.n = z;
        return getThis();
    }

    public BUILDER setContentDescription(String str) {
        this.p = str;
        return getThis();
    }

    public BUILDER setControllerListener(@Nullable ControllerListener<? super INFO> controllerListener) {
        this.j = controllerListener;
        return getThis();
    }

    public BUILDER setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener controllerViewportVisibilityListener) {
        this.l = controllerViewportVisibilityListener;
        return getThis();
    }

    public BUILDER setDataSourceSupplier(@Nullable Supplier<DataSource<IMAGE>> supplier) {
        this.i = supplier;
        return getThis();
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr) {
        return setFirstAvailableImageRequests(requestArr, true);
    }

    public BUILDER setImageRequest(REQUEST request) {
        this.e = request;
        return getThis();
    }

    public BUILDER setLoggingListener(@Nullable LoggingListener loggingListener) {
        this.k = loggingListener;
        return getThis();
    }

    public BUILDER setLowResImageRequest(REQUEST request) {
        this.f = request;
        return getThis();
    }

    public BUILDER setRetainImageOnFailure(boolean z) {
        this.o = z;
        return getThis();
    }

    public BUILDER setTapToRetryEnabled(boolean z) {
        this.m = z;
        return getThis();
    }

    public void validate() {
        boolean z = false;
        Preconditions.checkState(this.g == null || this.e == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.i == null || (this.g == null && this.e == null && this.f == null)) {
            z = true;
        }
        Preconditions.checkState(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public AbstractDraweeController build() {
        REQUEST request;
        validate();
        if (this.e == null && this.g == null && (request = this.f) != null) {
            this.e = request;
            this.f = null;
        }
        return buildController();
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController draweeController, String str, REQUEST request, CacheLevel cacheLevel) {
        return new b(draweeController, str, request, getCallerContext(), cacheLevel);
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public BUILDER setCallerContext(Object obj) {
        this.d = obj;
        return getThis();
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr, boolean z) {
        Preconditions.checkArgument(requestArr == null || requestArr.length > 0, "No requests specified!");
        this.g = requestArr;
        this.h = z;
        return getThis();
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public BUILDER setOldController(@Nullable DraweeController draweeController) {
        this.q = draweeController;
        return getThis();
    }
}
