package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
public class PipelineDraweeControllerFactory {
    public Resources a;
    public DeferredReleaser b;
    public DrawableFactory c;
    public Executor d;
    public MemoryCache<CacheKey, CloseableImage> e;
    @Nullable
    public ImmutableList<DrawableFactory> f;
    @Nullable
    public Supplier<Boolean> g;

    public void init(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, @Nullable ImmutableList<DrawableFactory> immutableList, @Nullable Supplier<Boolean> supplier) {
        this.a = resources;
        this.b = deferredReleaser;
        this.c = drawableFactory;
        this.d = executor;
        this.e = memoryCache;
        this.f = immutableList;
        this.g = supplier;
    }

    public PipelineDraweeController internalCreateController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, @Nullable ImmutableList<DrawableFactory> immutableList) {
        return new PipelineDraweeController(resources, deferredReleaser, drawableFactory, executor, memoryCache, immutableList);
    }

    public PipelineDraweeController newController() {
        PipelineDraweeController internalCreateController = internalCreateController(this.a, this.b, this.c, this.d, this.e, this.f);
        Supplier<Boolean> supplier = this.g;
        if (supplier != null) {
            internalCreateController.setDrawDebugOverlay(supplier.get().booleanValue());
        }
        return internalCreateController;
    }
}
