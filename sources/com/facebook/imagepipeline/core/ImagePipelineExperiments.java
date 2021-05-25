package com.facebook.imagepipeline.core;

import android.content.Context;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
public class ImagePipelineExperiments {
    public final int A;
    public final boolean a;
    public final WebpBitmapFactory.WebpErrorLogger b;
    public final boolean c;
    public final WebpBitmapFactory d;
    public final boolean e;
    public final boolean f;
    public final int g;
    public final int h;
    public boolean i;
    public final int j;
    public final boolean k;
    public final boolean l;
    public final ProducerFactoryMethod m;
    public final Supplier<Boolean> n;
    public final boolean o;
    public final boolean p;
    public final int q;
    public final Supplier<Boolean> r;
    public final boolean s;
    public final long t;
    public boolean u;
    public boolean v;
    public boolean w;
    public final boolean x;
    public final boolean y;
    public final boolean z;

    public static class Builder {
        public final ImagePipelineConfig.Builder a;
        public boolean b = false;
        public WebpBitmapFactory.WebpErrorLogger c;
        public boolean d = false;
        public WebpBitmapFactory e;
        public boolean f = false;
        public boolean g = false;
        public int h = 0;
        public int i = 0;
        public int j = 2048;
        public boolean k = false;
        public boolean l = false;
        public ProducerFactoryMethod m;
        public int mBitmapCloseableRefType;
        public boolean mBitmapPrepareToDrawForPrefetch = false;
        public boolean mDownsampleIfLargeBitmap;
        public boolean mDownscaleFrameToDrawableDimensions;
        public boolean mEncodedCacheEnabled = true;
        public boolean mEnsureTranscoderLibraryLoaded = true;
        public boolean mExperimentalThreadHandoffQueueEnabled;
        public boolean mGingerbreadDecoderEnabled;
        public Supplier<Boolean> mLazyDataSource;
        public long mMemoryType = 0;
        public Supplier<Boolean> mSuppressBitmapPrefetchingSupplier = Suppliers.of(Boolean.FALSE);
        public boolean n;
        public boolean o = false;
        public boolean p = false;
        public int q = 20;

        public Builder(ImagePipelineConfig.Builder builder) {
            this.a = builder;
        }

        public ImagePipelineExperiments build() {
            return new ImagePipelineExperiments(this, null);
        }

        public boolean isPartialImageCachingEnabled() {
            return this.l;
        }

        public ImagePipelineConfig.Builder setBitmapCloseableRefType(int i2) {
            this.mBitmapCloseableRefType = i2;
            return this.a;
        }

        public ImagePipelineConfig.Builder setBitmapPrepareToDraw(boolean z, int i2, int i3, boolean z2) {
            this.g = z;
            this.h = i2;
            this.i = i3;
            this.mBitmapPrepareToDrawForPrefetch = z2;
            return this.a;
        }

        public ImagePipelineConfig.Builder setDecodeCancellationEnabled(boolean z) {
            this.d = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setDownsampleIfLargeBitmap(boolean z) {
            this.mDownsampleIfLargeBitmap = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setEncodedCacheEnabled(boolean z) {
            this.mEncodedCacheEnabled = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setEnsureTranscoderLibraryLoaded(boolean z) {
            this.mEnsureTranscoderLibraryLoaded = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setExperimentalMemoryType(long j2) {
            this.mMemoryType = j2;
            return this.a;
        }

        public ImagePipelineConfig.Builder setExperimentalThreadHandoffQueueEnabled(boolean z) {
            this.mExperimentalThreadHandoffQueueEnabled = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setGingerbreadDecoderEnabled(boolean z) {
            this.mGingerbreadDecoderEnabled = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setIsDiskCacheProbingEnabled(boolean z) {
            this.p = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setIsEncodedMemoryCacheProbingEnabled(boolean z) {
            this.o = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setKeepCancelledFetchAsLowPriority(boolean z) {
            this.n = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setLazyDataSource(Supplier<Boolean> supplier) {
            this.mLazyDataSource = supplier;
            return this.a;
        }

        public ImagePipelineConfig.Builder setMaxBitmapSize(int i2) {
            this.j = i2;
            return this.a;
        }

        public ImagePipelineConfig.Builder setNativeCodeDisabled(boolean z) {
            this.k = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setPartialImageCachingEnabled(boolean z) {
            this.l = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setProducerFactoryMethod(ProducerFactoryMethod producerFactoryMethod) {
            this.m = producerFactoryMethod;
            return this.a;
        }

        public ImagePipelineConfig.Builder setShouldDownscaleFrameToDrawableDimensions(boolean z) {
            this.mDownscaleFrameToDrawableDimensions = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setSuppressBitmapPrefetchingSupplier(Supplier<Boolean> supplier) {
            this.mSuppressBitmapPrefetchingSupplier = supplier;
            return this.a;
        }

        public ImagePipelineConfig.Builder setTrackedKeysSize(int i2) {
            this.q = i2;
            return this.a;
        }

        public ImagePipelineConfig.Builder setUseDownsampligRatioForResizing(boolean z) {
            this.f = z;
            return this.a;
        }

        public ImagePipelineConfig.Builder setWebpBitmapFactory(WebpBitmapFactory webpBitmapFactory) {
            this.e = webpBitmapFactory;
            return this.a;
        }

        public ImagePipelineConfig.Builder setWebpErrorLogger(WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
            this.c = webpErrorLogger;
            return this.a;
        }

        public ImagePipelineConfig.Builder setWebpSupportEnabled(boolean z) {
            this.b = z;
            return this.a;
        }
    }

    public static class DefaultProducerFactoryMethod implements ProducerFactoryMethod {
        @Override // com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod
        public ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z4, int i3, CloseableReferenceFactory closeableReferenceFactory, boolean z5, int i4) {
            return new ProducerFactory(context, byteArrayPool, imageDecoder, progressiveJpegConfig, z, z2, z3, executorSupplier, pooledByteBufferFactory, memoryCache, memoryCache2, bufferedDiskCache, bufferedDiskCache2, cacheKeyFactory, platformBitmapFactory, i, i2, z4, i3, closeableReferenceFactory, z5, i4);
        }
    }

    public interface ProducerFactoryMethod {
        ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z4, int i3, CloseableReferenceFactory closeableReferenceFactory, boolean z5, int i4);
    }

    public ImagePipelineExperiments(Builder builder, a aVar) {
        this.a = builder.b;
        this.b = builder.c;
        this.c = builder.d;
        this.d = builder.e;
        this.e = builder.f;
        this.f = builder.g;
        this.g = builder.h;
        this.h = builder.i;
        this.i = builder.mBitmapPrepareToDrawForPrefetch;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        ProducerFactoryMethod producerFactoryMethod = builder.m;
        if (producerFactoryMethod == null) {
            this.m = new DefaultProducerFactoryMethod();
        } else {
            this.m = producerFactoryMethod;
        }
        this.n = builder.mLazyDataSource;
        this.o = builder.mGingerbreadDecoderEnabled;
        this.p = builder.mDownscaleFrameToDrawableDimensions;
        this.q = builder.mBitmapCloseableRefType;
        this.r = builder.mSuppressBitmapPrefetchingSupplier;
        this.s = builder.mExperimentalThreadHandoffQueueEnabled;
        this.t = builder.mMemoryType;
        this.u = builder.n;
        this.v = builder.mDownsampleIfLargeBitmap;
        this.w = builder.mEncodedCacheEnabled;
        this.x = builder.mEnsureTranscoderLibraryLoaded;
        this.y = builder.o;
        this.z = builder.p;
        this.A = builder.q;
    }

    public static Builder newBuilder(ImagePipelineConfig.Builder builder) {
        return new Builder(builder);
    }

    public int getBitmapCloseableRefType() {
        return this.q;
    }

    public boolean getBitmapPrepareToDrawForPrefetch() {
        return this.i;
    }

    public int getBitmapPrepareToDrawMaxSizeBytes() {
        return this.h;
    }

    public int getBitmapPrepareToDrawMinSizeBytes() {
        return this.g;
    }

    public int getMaxBitmapSize() {
        return this.j;
    }

    public long getMemoryType() {
        return this.t;
    }

    public ProducerFactoryMethod getProducerFactoryMethod() {
        return this.m;
    }

    public Supplier<Boolean> getSuppressBitmapPrefetchingSupplier() {
        return this.r;
    }

    public int getTrackedKeysSize() {
        return this.A;
    }

    public boolean getUseBitmapPrepareToDraw() {
        return this.f;
    }

    public boolean getUseDownsamplingRatioForResizing() {
        return this.e;
    }

    public WebpBitmapFactory getWebpBitmapFactory() {
        return this.d;
    }

    public WebpBitmapFactory.WebpErrorLogger getWebpErrorLogger() {
        return this.b;
    }

    public boolean isDecodeCancellationEnabled() {
        return this.c;
    }

    public boolean isDiskCacheProbingEnabled() {
        return this.z;
    }

    public boolean isEncodedCacheEnabled() {
        return this.w;
    }

    public boolean isEncodedMemoryCacheProbingEnabled() {
        return this.y;
    }

    public boolean isEnsureTranscoderLibraryLoaded() {
        return this.x;
    }

    public boolean isExperimentalThreadHandoffQueueEnabled() {
        return this.s;
    }

    public boolean isGingerbreadDecoderEnabled() {
        return this.o;
    }

    public Supplier<Boolean> isLazyDataSource() {
        return this.n;
    }

    public boolean isNativeCodeDisabled() {
        return this.k;
    }

    public boolean isPartialImageCachingEnabled() {
        return this.l;
    }

    public boolean isWebpSupportEnabled() {
        return this.a;
    }

    public boolean shouldDownsampleIfLargeBitmap() {
        return this.v;
    }

    public boolean shouldDownscaleFrameToDrawableDimensions() {
        return this.p;
    }

    public boolean shouldKeepCancelledFetchAsLowPriority() {
        return this.u;
    }
}
