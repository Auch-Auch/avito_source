package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.debug.DebugOverlayImageOriginColor;
import com.facebook.drawee.backends.pipeline.debug.DebugOverlayImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ForwardingImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeControllerListener;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.fresco.ui.common.MultiUriHelper;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo> {
    public CacheKey A;
    public Supplier<DataSource<CloseableReference<CloseableImage>>> B;
    public boolean C;
    @Nullable
    public ImmutableList<DrawableFactory> D;
    @Nullable
    public ImagePerfMonitor E;
    @GuardedBy("this")
    @Nullable
    public Set<RequestListener> F;
    @GuardedBy("this")
    @Nullable
    public ImageOriginListener G;
    public DebugOverlayImageOriginListener H;
    @Nullable
    public ImageRequest I;
    @Nullable
    public ImageRequest[] J;
    @Nullable
    public ImageRequest K;
    public final Resources w;
    public final DrawableFactory x;
    @Nullable
    public final ImmutableList<DrawableFactory> y;
    @Nullable
    public final MemoryCache<CacheKey, CloseableImage> z;

    public PipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, @Nullable MemoryCache<CacheKey, CloseableImage> memoryCache, @Nullable ImmutableList<DrawableFactory> immutableList) {
        super(deferredReleaser, executor, null, null);
        this.w = resources;
        this.x = new DefaultDrawableFactory(resources, drawableFactory);
        this.y = immutableList;
        this.z = memoryCache;
    }

    public synchronized void addImageOriginListener(ImageOriginListener imageOriginListener) {
        ImageOriginListener imageOriginListener2 = this.G;
        if (imageOriginListener2 instanceof ForwardingImageOriginListener) {
            ((ForwardingImageOriginListener) imageOriginListener2).addImageOriginListener(imageOriginListener);
        } else if (imageOriginListener2 != null) {
            this.G = new ForwardingImageOriginListener(imageOriginListener2, imageOriginListener);
        } else {
            this.G = imageOriginListener;
        }
    }

    public synchronized void addRequestListener(RequestListener requestListener) {
        if (this.F == null) {
            this.F = new HashSet();
        }
        this.F.add(requestListener);
    }

    public void clearImageOriginListeners() {
        synchronized (this) {
            this.G = null;
        }
    }

    public CacheKey getCacheKey() {
        return this.A;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public DataSource<CloseableReference<CloseableImage>> getDataSource() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeController#getDataSource");
        }
        if (FLog.isLoggable(2)) {
            FLog.v(PipelineDraweeController.class, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        DataSource<CloseableReference<CloseableImage>> dataSource = this.B.get();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return dataSource;
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier() {
        return this.B;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    @Nullable
    public Uri getMainUri() {
        return MultiUriHelper.getMainUri(this.I, this.K, this.J, ImageRequest.REQUEST_TO_URI_FN);
    }

    @Nullable
    public synchronized RequestListener getRequestListener() {
        ImageOriginRequestListener imageOriginRequestListener = null;
        if (this.G != null) {
            imageOriginRequestListener = new ImageOriginRequestListener(getId(), this.G);
        }
        Set<RequestListener> set = this.F;
        if (set == null) {
            return imageOriginRequestListener;
        }
        ForwardingRequestListener forwardingRequestListener = new ForwardingRequestListener(set);
        if (imageOriginRequestListener != null) {
            forwardingRequestListener.addRequestListener(imageOriginRequestListener);
        }
        return forwardingRequestListener;
    }

    public Resources getResources() {
        return this.w;
    }

    public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj, @Nullable ImmutableList<DrawableFactory> immutableList, @Nullable ImageOriginListener imageOriginListener) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeController#initialize");
        }
        super.initialize(str, obj);
        this.B = supplier;
        m(null);
        this.A = cacheKey;
        setCustomDrawableFactories(immutableList);
        clearImageOriginListeners();
        m(null);
        addImageOriginListener(imageOriginListener);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public synchronized void initializePerformanceMonitoring(@Nullable ImagePerfDataListener imagePerfDataListener, AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> abstractDraweeControllerBuilder, Supplier<Boolean> supplier) {
        ImagePerfMonitor imagePerfMonitor = this.E;
        if (imagePerfMonitor != null) {
            imagePerfMonitor.reset();
        }
        if (imagePerfDataListener != null) {
            if (this.E == null) {
                this.E = new ImagePerfMonitor(AwakeTimeSinceBootClock.get(), this, supplier);
            }
            this.E.addImagePerfDataListener(imagePerfDataListener);
            this.E.setEnabled(true);
            this.E.updateImageRequestData(abstractDraweeControllerBuilder);
        }
        this.I = abstractDraweeControllerBuilder.getImageRequest();
        this.J = abstractDraweeControllerBuilder.getFirstAvailableImageRequests();
        this.K = abstractDraweeControllerBuilder.getLowResImageRequest();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean isSameImageRequest(@Nullable DraweeController draweeController) {
        CacheKey cacheKey = this.A;
        if (cacheKey == null || !(draweeController instanceof PipelineDraweeController)) {
            return false;
        }
        return Objects.equal(cacheKey, ((PipelineDraweeController) draweeController).getCacheKey());
    }

    @Nullable
    public final Drawable l(@Nullable ImmutableList<DrawableFactory> immutableList, CloseableImage closeableImage) {
        Drawable createDrawable;
        if (immutableList == null) {
            return null;
        }
        Iterator<DrawableFactory> it = immutableList.iterator();
        while (it.hasNext()) {
            DrawableFactory next = it.next();
            if (next.supportsImageType(closeableImage) && (createDrawable = next.createDrawable(closeableImage)) != null) {
                return createDrawable;
            }
        }
        return null;
    }

    public final void m(@Nullable CloseableImage closeableImage) {
        if (this.C) {
            if (getControllerOverlay() == null) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable = new DebugControllerOverlayDrawable();
                ImageLoadingTimeControllerListener imageLoadingTimeControllerListener = new ImageLoadingTimeControllerListener(debugControllerOverlayDrawable);
                this.H = new DebugOverlayImageOriginListener();
                addControllerListener(imageLoadingTimeControllerListener);
                setControllerOverlay(debugControllerOverlayDrawable);
            }
            if (this.G == null) {
                addImageOriginListener(this.H);
            }
            if (getControllerOverlay() instanceof DebugControllerOverlayDrawable) {
                updateDebugOverlay(closeableImage, (DebugControllerOverlayDrawable) getControllerOverlay());
            }
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void releaseDrawable(@Nullable Drawable drawable) {
        if (drawable instanceof DrawableWithCaches) {
            ((DrawableWithCaches) drawable).dropCaches();
        }
    }

    public synchronized void removeImageOriginListener(ImageOriginListener imageOriginListener) {
        ImageOriginListener imageOriginListener2 = this.G;
        if (imageOriginListener2 instanceof ForwardingImageOriginListener) {
            ((ForwardingImageOriginListener) imageOriginListener2).removeImageOriginListener(imageOriginListener);
            return;
        }
        if (imageOriginListener2 == imageOriginListener) {
            this.G = null;
        }
    }

    public synchronized void removeRequestListener(RequestListener requestListener) {
        Set<RequestListener> set = this.F;
        if (set != null) {
            set.remove(requestListener);
        }
    }

    public void setCustomDrawableFactories(@Nullable ImmutableList<DrawableFactory> immutableList) {
        this.D = immutableList;
    }

    public void setDrawDebugOverlay(boolean z2) {
        this.C = z2;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController, com.facebook.drawee.interfaces.DraweeController
    public void setHierarchy(@Nullable DraweeHierarchy draweeHierarchy) {
        super.setHierarchy(draweeHierarchy);
        m(null);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public String toString() {
        return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.B).toString();
    }

    public void updateDebugOverlay(@Nullable CloseableImage closeableImage, DebugControllerOverlayDrawable debugControllerOverlayDrawable) {
        ScaleTypeDrawable activeScaleTypeDrawable;
        debugControllerOverlayDrawable.setControllerId(getId());
        DraweeHierarchy hierarchy = getHierarchy();
        ScalingUtils.ScaleType scaleType = null;
        if (!(hierarchy == null || (activeScaleTypeDrawable = ScalingUtils.getActiveScaleTypeDrawable(hierarchy.getTopLevelDrawable())) == null)) {
            scaleType = activeScaleTypeDrawable.getScaleType();
        }
        debugControllerOverlayDrawable.setScaleType(scaleType);
        int imageOrigin = this.H.getImageOrigin();
        debugControllerOverlayDrawable.setOrigin(ImageOriginUtils.toString(imageOrigin), DebugOverlayImageOriginColor.getImageOriginColor(imageOrigin));
        if (closeableImage != null) {
            debugControllerOverlayDrawable.setDimensions(closeableImage.getWidth(), closeableImage.getHeight());
            debugControllerOverlayDrawable.setImageSize(closeableImage.getSizeInBytes());
            return;
        }
        debugControllerOverlayDrawable.reset();
    }

    public Drawable createDrawable(CloseableReference<CloseableImage> closeableReference) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("PipelineDraweeController#createDrawable");
            }
            Preconditions.checkState(CloseableReference.isValid(closeableReference));
            CloseableImage closeableImage = closeableReference.get();
            m(closeableImage);
            Drawable l = l(this.D, closeableImage);
            if (l != null) {
                return l;
            }
            Drawable l2 = l(this.y, closeableImage);
            if (l2 != null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return l2;
            }
            Drawable createDrawable = this.x.createDrawable(closeableImage);
            if (createDrawable != null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return createDrawable;
            }
            throw new UnsupportedOperationException("Unrecognized image class: " + closeableImage);
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    @Nullable
    public CloseableReference<CloseableImage> getCachedImage() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeController#getCachedImage");
        }
        try {
            MemoryCache<CacheKey, CloseableImage> memoryCache = this.z;
            if (memoryCache != null) {
                CacheKey cacheKey = this.A;
                if (cacheKey != null) {
                    CloseableReference<CloseableImage> closeableReference = memoryCache.get(cacheKey);
                    if (closeableReference == null || closeableReference.get().getQualityInfo().isOfFullQuality()) {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return closeableReference;
                    }
                    closeableReference.close();
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return null;
                }
            }
            return null;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public int getImageHash(@Nullable CloseableReference<CloseableImage> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.getValueHash();
        }
        return 0;
    }

    public ImageInfo getImageInfo(CloseableReference<CloseableImage> closeableReference) {
        Preconditions.checkState(CloseableReference.isValid(closeableReference));
        return closeableReference.get();
    }

    @Nullable
    public Map<String, Object> obtainExtrasFromImage(ImageInfo imageInfo) {
        if (imageInfo == null) {
            return null;
        }
        return imageInfo.getExtras();
    }

    public void onImageLoadedFromCacheImmediately(String str, CloseableReference<CloseableImage> closeableReference) {
        super.onImageLoadedFromCacheImmediately(str, (String) closeableReference);
        synchronized (this) {
            ImageOriginListener imageOriginListener = this.G;
            if (imageOriginListener != null) {
                imageOriginListener.onImageLoaded(str, 6, true, "PipelineDraweeController");
            }
        }
    }

    public void releaseImage(@Nullable CloseableReference<CloseableImage> closeableReference) {
        CloseableReference.closeSafely(closeableReference);
    }
}
