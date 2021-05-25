package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactoryProvider;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoderFactory;
import com.facebook.imagepipeline.producers.ExperimentalThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.SimpleImageTranscoderFactory;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
public class ImagePipelineFactory {
    public static ImagePipelineFactory t;
    public static boolean u;
    public static ImagePipeline v;
    public final ThreadHandoffProducerQueue a;
    public final ImagePipelineConfig b;
    public final CloseableReferenceFactory c;
    public CountingMemoryCache<CacheKey, CloseableImage> d;
    public InstrumentedMemoryCache<CacheKey, CloseableImage> e;
    public CountingMemoryCache<CacheKey, PooledByteBuffer> f;
    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> g;
    public BufferedDiskCache h;
    public FileCache i;
    public ImageDecoder j;
    public ImagePipeline k;
    public ImageTranscoderFactory l;
    public ProducerFactory m;
    public ProducerSequenceFactory n;
    public BufferedDiskCache o;
    public FileCache p;
    public PlatformBitmapFactory q;
    public PlatformDecoder r;
    public AnimatedFactory s;

    public ImagePipelineFactory(ImagePipelineConfig imagePipelineConfig) {
        ThreadHandoffProducerQueue threadHandoffProducerQueue;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        ImagePipelineConfig imagePipelineConfig2 = (ImagePipelineConfig) Preconditions.checkNotNull(imagePipelineConfig);
        this.b = imagePipelineConfig2;
        if (imagePipelineConfig2.getExperiments().isExperimentalThreadHandoffQueueEnabled()) {
            threadHandoffProducerQueue = new ExperimentalThreadHandoffProducerQueueImpl(imagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
        } else {
            threadHandoffProducerQueue = new ThreadHandoffProducerQueueImpl(imagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
        }
        this.a = threadHandoffProducerQueue;
        CloseableReference.setDisableCloseableReferencesForBitmaps(imagePipelineConfig.getExperiments().getBitmapCloseableRefType());
        this.c = new CloseableReferenceFactory(imagePipelineConfig.getCloseableReferenceLeakTracker());
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public static ImagePipelineFactory getInstance() {
        return (ImagePipelineFactory) Preconditions.checkNotNull(t, "ImagePipelineFactory was not initialized!");
    }

    public static synchronized boolean hasBeenInitialized() {
        boolean z;
        synchronized (ImagePipelineFactory.class) {
            z = t != null;
        }
        return z;
    }

    public static synchronized void initialize(Context context) {
        synchronized (ImagePipelineFactory.class) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ImagePipelineFactory#initialize");
            }
            initialize(ImagePipelineConfig.newBuilder(context).build());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public static void setInstance(ImagePipelineFactory imagePipelineFactory) {
        t = imagePipelineFactory;
    }

    public static synchronized void shutDown() {
        synchronized (ImagePipelineFactory.class) {
            ImagePipelineFactory imagePipelineFactory = t;
            if (imagePipelineFactory != null) {
                imagePipelineFactory.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
                t.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
                t = null;
            }
        }
    }

    public final ImagePipeline a() {
        ImageDecoder imageDecoder;
        boolean z = Build.VERSION.SDK_INT >= 24 && this.b.getExperiments().getUseBitmapPrepareToDraw();
        if (this.n == null) {
            ContentResolver contentResolver = this.b.getContext().getApplicationContext().getContentResolver();
            if (this.m == null) {
                ImagePipelineExperiments.ProducerFactoryMethod producerFactoryMethod = this.b.getExperiments().getProducerFactoryMethod();
                Context context = this.b.getContext();
                ByteArrayPool smallByteArrayPool = this.b.getPoolFactory().getSmallByteArrayPool();
                if (this.j == null) {
                    if (this.b.getImageDecoder() != null) {
                        this.j = this.b.getImageDecoder();
                    } else {
                        AnimatedFactory b2 = b();
                        ImageDecoder imageDecoder2 = null;
                        if (b2 != null) {
                            imageDecoder2 = b2.getGifDecoder(this.b.getBitmapConfig());
                            imageDecoder = b2.getWebPDecoder(this.b.getBitmapConfig());
                        } else {
                            imageDecoder = null;
                        }
                        if (this.b.getImageDecoderConfig() == null) {
                            this.j = new DefaultImageDecoder(imageDecoder2, imageDecoder, getPlatformDecoder());
                        } else {
                            this.j = new DefaultImageDecoder(imageDecoder2, imageDecoder, getPlatformDecoder(), this.b.getImageDecoderConfig().getCustomImageDecoders());
                            ImageFormatChecker.getInstance().setCustomImageFormatCheckers(this.b.getImageDecoderConfig().getCustomImageFormats());
                        }
                    }
                }
                this.m = producerFactoryMethod.createProducerFactory(context, smallByteArrayPool, this.j, this.b.getProgressiveJpegConfig(), this.b.isDownsampleEnabled(), this.b.isResizeAndRotateEnabledForNetwork(), this.b.getExperiments().isDecodeCancellationEnabled(), this.b.getExecutorSupplier(), this.b.getPoolFactory().getPooledByteBufferFactory(this.b.getMemoryChunkType()), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), c(), this.b.getCacheKeyFactory(), getPlatformBitmapFactory(), this.b.getExperiments().getBitmapPrepareToDrawMinSizeBytes(), this.b.getExperiments().getBitmapPrepareToDrawMaxSizeBytes(), this.b.getExperiments().getBitmapPrepareToDrawForPrefetch(), this.b.getExperiments().getMaxBitmapSize(), getCloseableReferenceFactory(), this.b.getExperiments().shouldKeepCancelledFetchAsLowPriority(), this.b.getExperiments().getTrackedKeysSize());
            }
            ProducerFactory producerFactory = this.m;
            NetworkFetcher networkFetcher = this.b.getNetworkFetcher();
            boolean isResizeAndRotateEnabledForNetwork = this.b.isResizeAndRotateEnabledForNetwork();
            boolean isWebpSupportEnabled = this.b.getExperiments().isWebpSupportEnabled();
            ThreadHandoffProducerQueue threadHandoffProducerQueue = this.a;
            boolean isDownsampleEnabled = this.b.isDownsampleEnabled();
            boolean isPartialImageCachingEnabled = this.b.getExperiments().isPartialImageCachingEnabled();
            boolean isDiskCacheEnabled = this.b.isDiskCacheEnabled();
            if (this.l == null) {
                if (this.b.getImageTranscoderFactory() == null && this.b.getImageTranscoderType() == null && this.b.getExperiments().isNativeCodeDisabled()) {
                    this.l = new SimpleImageTranscoderFactory(this.b.getExperiments().getMaxBitmapSize());
                } else {
                    this.l = new MultiImageTranscoderFactory(this.b.getExperiments().getMaxBitmapSize(), this.b.getExperiments().getUseDownsamplingRatioForResizing(), this.b.getImageTranscoderFactory(), this.b.getImageTranscoderType(), this.b.getExperiments().isEnsureTranscoderLibraryLoaded());
                }
            }
            this.n = new ProducerSequenceFactory(contentResolver, producerFactory, networkFetcher, isResizeAndRotateEnabledForNetwork, isWebpSupportEnabled, threadHandoffProducerQueue, isDownsampleEnabled, z, isPartialImageCachingEnabled, isDiskCacheEnabled, this.l, this.b.getExperiments().isEncodedMemoryCacheProbingEnabled(), this.b.getExperiments().isDiskCacheProbingEnabled());
        }
        return new ImagePipeline(this.n, this.b.getRequestListeners(), this.b.getRequestListener2s(), this.b.getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), c(), this.b.getCacheKeyFactory(), this.a, this.b.getExperiments().getSuppressBitmapPrefetchingSupplier(), this.b.getExperiments().isLazyDataSource(), this.b.getCallerContextVerifier(), this.b);
    }

    @Nullable
    public final AnimatedFactory b() {
        if (this.s == null) {
            this.s = AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.b.getExecutorSupplier(), getBitmapCountingMemoryCache(), this.b.getExperiments().shouldDownscaleFrameToDrawableDimensions());
        }
        return this.s;
    }

    public final BufferedDiskCache c() {
        if (this.o == null) {
            this.o = new BufferedDiskCache(getSmallImageFileCache(), this.b.getPoolFactory().getPooledByteBufferFactory(this.b.getMemoryChunkType()), this.b.getPoolFactory().getPooledByteStreams(), this.b.getExecutorSupplier().forLocalStorageRead(), this.b.getExecutorSupplier().forLocalStorageWrite(), this.b.getImageCacheStatsTracker());
        }
        return this.o;
    }

    @Nullable
    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        AnimatedFactory b2 = b();
        if (b2 == null) {
            return null;
        }
        return b2.getAnimatedDrawableFactory(context);
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache() {
        if (this.d == null) {
            this.d = BitmapCountingMemoryCacheFactory.get(this.b.getBitmapMemoryCacheParamsSupplier(), this.b.getMemoryTrimmableRegistry(), this.b.getBitmapMemoryCacheTrimStrategy(), this.b.getBitmapMemoryCacheEntryStateObserver());
        }
        return this.d;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        MemoryCache<CacheKey, CloseableImage> memoryCache;
        if (this.e == null) {
            if (this.b.getBitmapCacheOverride() != null) {
                memoryCache = this.b.getBitmapCacheOverride();
            } else {
                memoryCache = getBitmapCountingMemoryCache();
            }
            this.e = BitmapMemoryCacheFactory.get(memoryCache, this.b.getImageCacheStatsTracker());
        }
        return this.e;
    }

    public CloseableReferenceFactory getCloseableReferenceFactory() {
        return this.c;
    }

    public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache() {
        if (this.f == null) {
            this.f = EncodedCountingMemoryCacheFactory.get(this.b.getEncodedMemoryCacheParamsSupplier(), this.b.getMemoryTrimmableRegistry());
        }
        return this.f;
    }

    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache() {
        MemoryCache<CacheKey, PooledByteBuffer> memoryCache;
        if (this.g == null) {
            if (this.b.getEncodedMemoryCacheOverride() != null) {
                memoryCache = this.b.getEncodedMemoryCacheOverride();
            } else {
                memoryCache = getEncodedCountingMemoryCache();
            }
            this.g = EncodedMemoryCacheFactory.get(memoryCache, this.b.getImageCacheStatsTracker());
        }
        return this.g;
    }

    public ImagePipeline getImagePipeline() {
        if (u) {
            if (v == null) {
                ImagePipeline a3 = a();
                v = a3;
                this.k = a3;
            }
            return v;
        }
        if (this.k == null) {
            this.k = a();
        }
        return this.k;
    }

    public BufferedDiskCache getMainBufferedDiskCache() {
        if (this.h == null) {
            this.h = new BufferedDiskCache(getMainFileCache(), this.b.getPoolFactory().getPooledByteBufferFactory(this.b.getMemoryChunkType()), this.b.getPoolFactory().getPooledByteStreams(), this.b.getExecutorSupplier().forLocalStorageRead(), this.b.getExecutorSupplier().forLocalStorageWrite(), this.b.getImageCacheStatsTracker());
        }
        return this.h;
    }

    public FileCache getMainFileCache() {
        if (this.i == null) {
            this.i = this.b.getFileCacheFactory().get(this.b.getMainDiskCacheConfig());
        }
        return this.i;
    }

    public PlatformBitmapFactory getPlatformBitmapFactory() {
        if (this.q == null) {
            this.q = PlatformBitmapFactoryProvider.buildPlatformBitmapFactory(this.b.getPoolFactory(), getPlatformDecoder(), getCloseableReferenceFactory());
        }
        return this.q;
    }

    public PlatformDecoder getPlatformDecoder() {
        if (this.r == null) {
            this.r = PlatformDecoderFactory.buildPlatformDecoder(this.b.getPoolFactory(), this.b.getExperiments().isGingerbreadDecoderEnabled());
        }
        return this.r;
    }

    public FileCache getSmallImageFileCache() {
        if (this.p == null) {
            this.p = this.b.getFileCacheFactory().get(this.b.getSmallImageDiskCacheConfig());
        }
        return this.p;
    }

    @Nullable
    public String reportData() {
        return Objects.toStringHelper("ImagePipelineFactory").add("bitmapCountingMemoryCache", this.d.reportData()).add("encodedCountingMemoryCache", this.f.reportData()).toString();
    }

    public static synchronized void initialize(ImagePipelineConfig imagePipelineConfig, boolean z) {
        synchronized (ImagePipelineFactory.class) {
            if (t != null) {
                FLog.w(ImagePipelineFactory.class, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            u = z;
            t = new ImagePipelineFactory(imagePipelineConfig);
        }
    }

    public static synchronized void initialize(ImagePipelineConfig imagePipelineConfig) {
        synchronized (ImagePipelineFactory.class) {
            if (t != null) {
                FLog.w(ImagePipelineFactory.class, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            t = new ImagePipelineFactory(imagePipelineConfig);
        }
    }
}
