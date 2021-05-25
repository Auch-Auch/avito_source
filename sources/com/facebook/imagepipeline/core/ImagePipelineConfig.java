package com.facebook.imagepipeline.core;

import a2.g.p.b.b;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import com.facebook.imagepipeline.debug.NoOpCloseableReferenceLeakTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
public class ImagePipelineConfig {
    public static DefaultImageRequestConfig I = new DefaultImageRequestConfig(null);
    public final DiskCacheConfig A;
    @Nullable
    public final ImageDecoderConfig B;
    public final ImagePipelineExperiments C;
    public final boolean D;
    @Nullable
    public final CallerContextVerifier E;
    public final CloseableReferenceLeakTracker F;
    @Nullable
    public final MemoryCache<CacheKey, CloseableImage> G;
    @Nullable
    public final MemoryCache<CacheKey, PooledByteBuffer> H;
    public final Bitmap.Config a;
    public final Supplier<MemoryCacheParams> b;
    public final MemoryCache.CacheTrimStrategy c;
    public final CountingMemoryCache.EntryStateObserver<CacheKey> d;
    public final CacheKeyFactory e;
    public final Context f;
    public final boolean g;
    public final FileCacheFactory h;
    public final Supplier<MemoryCacheParams> i;
    public final ExecutorSupplier j;
    public final ImageCacheStatsTracker k;
    @Nullable
    public final ImageDecoder l;
    @Nullable
    public final ImageTranscoderFactory m;
    @Nullable
    public final Integer n;
    public final Supplier<Boolean> o;
    public final DiskCacheConfig p;
    public final MemoryTrimmableRegistry q;
    public final int r;
    public final NetworkFetcher s;
    public final int t;
    @Nullable
    public final PlatformBitmapFactory u;
    public final PoolFactory v;
    public final ProgressiveJpegConfig w;
    public final Set<RequestListener> x;
    public final Set<RequestListener2> y;
    public final boolean z;

    public static class Builder {
        public ImageDecoderConfig A;
        public int B = -1;
        public final ImagePipelineExperiments.Builder C = new ImagePipelineExperiments.Builder(this);
        public boolean D = true;
        public CallerContextVerifier E;
        public CloseableReferenceLeakTracker F = new NoOpCloseableReferenceLeakTracker();
        @Nullable
        public MemoryCache<CacheKey, CloseableImage> G;
        @Nullable
        public MemoryCache<CacheKey, PooledByteBuffer> H;
        public Bitmap.Config a;
        public Supplier<MemoryCacheParams> b;
        public CountingMemoryCache.EntryStateObserver<CacheKey> c;
        public MemoryCache.CacheTrimStrategy d;
        public CacheKeyFactory e;
        public final Context f;
        public boolean g = false;
        public Supplier<MemoryCacheParams> h;
        public ExecutorSupplier i;
        public ImageCacheStatsTracker j;
        public ImageDecoder k;
        public ImageTranscoderFactory l;
        @Nullable
        public Integer m = null;
        public Supplier<Boolean> n;
        public DiskCacheConfig o;
        public MemoryTrimmableRegistry p;
        @Nullable
        public Integer q = null;
        public NetworkFetcher r;
        public PlatformBitmapFactory s;
        public PoolFactory t;
        public ProgressiveJpegConfig u;
        public Set<RequestListener> v;
        public Set<RequestListener2> w;
        public boolean x = true;
        public DiskCacheConfig y;
        public FileCacheFactory z;

        public Builder(Context context, b bVar) {
            this.f = (Context) Preconditions.checkNotNull(context);
        }

        public ImagePipelineConfig build() {
            return new ImagePipelineConfig(this, null);
        }

        public ImagePipelineExperiments.Builder experiment() {
            return this.C;
        }

        @Nullable
        public Integer getImageTranscoderType() {
            return this.m;
        }

        @Nullable
        public Integer getMemoryChunkType() {
            return this.q;
        }

        public boolean isDiskCacheEnabled() {
            return this.D;
        }

        public boolean isDownsampleEnabled() {
            return this.g;
        }

        public Builder setBitmapMemoryCache(@Nullable MemoryCache<CacheKey, CloseableImage> memoryCache) {
            this.G = memoryCache;
            return this;
        }

        public Builder setBitmapMemoryCacheEntryStateObserver(CountingMemoryCache.EntryStateObserver<CacheKey> entryStateObserver) {
            this.c = entryStateObserver;
            return this;
        }

        public Builder setBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            this.b = (Supplier) Preconditions.checkNotNull(supplier);
            return this;
        }

        public Builder setBitmapMemoryCacheTrimStrategy(MemoryCache.CacheTrimStrategy cacheTrimStrategy) {
            this.d = cacheTrimStrategy;
            return this;
        }

        public Builder setBitmapsConfig(Bitmap.Config config) {
            this.a = config;
            return this;
        }

        public Builder setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            this.e = cacheKeyFactory;
            return this;
        }

        public Builder setCallerContextVerifier(CallerContextVerifier callerContextVerifier) {
            this.E = callerContextVerifier;
            return this;
        }

        public Builder setCloseableReferenceLeakTracker(CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
            this.F = closeableReferenceLeakTracker;
            return this;
        }

        public Builder setDiskCacheEnabled(boolean z2) {
            this.D = z2;
            return this;
        }

        public Builder setDownsampleEnabled(boolean z2) {
            this.g = z2;
            return this;
        }

        public Builder setEncodedMemoryCache(@Nullable MemoryCache<CacheKey, PooledByteBuffer> memoryCache) {
            this.H = memoryCache;
            return this;
        }

        public Builder setEncodedMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            this.h = (Supplier) Preconditions.checkNotNull(supplier);
            return this;
        }

        public Builder setExecutorSupplier(ExecutorSupplier executorSupplier) {
            this.i = executorSupplier;
            return this;
        }

        public Builder setFileCacheFactory(FileCacheFactory fileCacheFactory) {
            this.z = fileCacheFactory;
            return this;
        }

        public Builder setHttpConnectionTimeout(int i2) {
            this.B = i2;
            return this;
        }

        public Builder setImageCacheStatsTracker(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.j = imageCacheStatsTracker;
            return this;
        }

        public Builder setImageDecoder(ImageDecoder imageDecoder) {
            this.k = imageDecoder;
            return this;
        }

        public Builder setImageDecoderConfig(ImageDecoderConfig imageDecoderConfig) {
            this.A = imageDecoderConfig;
            return this;
        }

        public Builder setImageTranscoderFactory(ImageTranscoderFactory imageTranscoderFactory) {
            this.l = imageTranscoderFactory;
            return this;
        }

        public Builder setImageTranscoderType(int i2) {
            this.m = Integer.valueOf(i2);
            return this;
        }

        public Builder setIsPrefetchEnabledSupplier(Supplier<Boolean> supplier) {
            this.n = supplier;
            return this;
        }

        public Builder setMainDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            this.o = diskCacheConfig;
            return this;
        }

        public Builder setMemoryChunkType(int i2) {
            this.q = Integer.valueOf(i2);
            return this;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.p = memoryTrimmableRegistry;
            return this;
        }

        public Builder setNetworkFetcher(NetworkFetcher networkFetcher) {
            this.r = networkFetcher;
            return this;
        }

        public Builder setPlatformBitmapFactory(PlatformBitmapFactory platformBitmapFactory) {
            this.s = platformBitmapFactory;
            return this;
        }

        public Builder setPoolFactory(PoolFactory poolFactory) {
            this.t = poolFactory;
            return this;
        }

        public Builder setProgressiveJpegConfig(ProgressiveJpegConfig progressiveJpegConfig) {
            this.u = progressiveJpegConfig;
            return this;
        }

        public Builder setRequestListener2s(Set<RequestListener2> set) {
            this.w = set;
            return this;
        }

        public Builder setRequestListeners(Set<RequestListener> set) {
            this.v = set;
            return this;
        }

        public Builder setResizeAndRotateEnabledForNetwork(boolean z2) {
            this.x = z2;
            return this;
        }

        public Builder setSmallImageDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            this.y = diskCacheConfig;
            return this;
        }
    }

    public ImagePipelineConfig(Builder builder, b bVar) {
        int i2;
        WebpBitmapFactory loadWebpBitmapFactoryIfExists;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        ImagePipelineExperiments build = builder.C.build();
        this.C = build;
        Supplier<MemoryCacheParams> supplier = builder.b;
        this.b = supplier == null ? new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) builder.f.getSystemService("activity")) : supplier;
        MemoryCache.CacheTrimStrategy cacheTrimStrategy = builder.d;
        this.c = cacheTrimStrategy == null ? new BitmapMemoryCacheTrimStrategy() : cacheTrimStrategy;
        this.d = builder.c;
        Bitmap.Config config = builder.a;
        this.a = config == null ? Bitmap.Config.ARGB_8888 : config;
        CacheKeyFactory cacheKeyFactory = builder.e;
        this.e = cacheKeyFactory == null ? DefaultCacheKeyFactory.getInstance() : cacheKeyFactory;
        this.f = (Context) Preconditions.checkNotNull(builder.f);
        FileCacheFactory fileCacheFactory = builder.z;
        this.h = fileCacheFactory == null ? new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory()) : fileCacheFactory;
        this.g = builder.g;
        Supplier<MemoryCacheParams> supplier2 = builder.h;
        this.i = supplier2 == null ? new DefaultEncodedMemoryCacheParamsSupplier() : supplier2;
        ImageCacheStatsTracker imageCacheStatsTracker = builder.j;
        this.k = imageCacheStatsTracker == null ? NoOpImageCacheStatsTracker.getInstance() : imageCacheStatsTracker;
        this.l = builder.k;
        ImageTranscoderFactory imageTranscoderFactory = builder.l;
        if (imageTranscoderFactory == null || builder.m == null) {
            this.m = imageTranscoderFactory == null ? null : imageTranscoderFactory;
            this.n = builder.m;
            Supplier<Boolean> supplier3 = builder.n;
            this.o = supplier3 == null ? new b(this) : supplier3;
            DiskCacheConfig diskCacheConfig = builder.o;
            if (diskCacheConfig == null) {
                Context context = builder.f;
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("DiskCacheConfig.getDefaultMainDiskCacheConfig");
                    }
                    diskCacheConfig = DiskCacheConfig.newBuilder(context).build();
                } finally {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            }
            this.p = diskCacheConfig;
            MemoryTrimmableRegistry memoryTrimmableRegistry = builder.p;
            this.q = memoryTrimmableRegistry == null ? NoOpMemoryTrimmableRegistry.getInstance() : memoryTrimmableRegistry;
            Integer num = builder.q;
            if (num != null) {
                i2 = num.intValue();
            } else if (build.getMemoryType() == 2 && Build.VERSION.SDK_INT >= 27) {
                i2 = 2;
            } else if (build.getMemoryType() == 1) {
                i2 = 1;
            } else {
                build.getMemoryType();
                i2 = 0;
            }
            this.r = i2;
            int i3 = builder.B;
            i3 = i3 < 0 ? HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT : i3;
            this.t = i3;
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ImagePipelineConfig->mNetworkFetcher");
            }
            NetworkFetcher networkFetcher = builder.r;
            this.s = networkFetcher == null ? new HttpUrlConnectionNetworkFetcher(i3) : networkFetcher;
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            this.u = builder.s;
            PoolFactory poolFactory = builder.t;
            poolFactory = poolFactory == null ? new PoolFactory(PoolConfig.newBuilder().build()) : poolFactory;
            this.v = poolFactory;
            ProgressiveJpegConfig progressiveJpegConfig = builder.u;
            this.w = progressiveJpegConfig == null ? new SimpleProgressiveJpegConfig() : progressiveJpegConfig;
            Set<RequestListener> set = builder.v;
            this.x = set == null ? new HashSet<>() : set;
            Set<RequestListener2> set2 = builder.w;
            this.y = set2 == null ? new HashSet<>() : set2;
            this.z = builder.x;
            DiskCacheConfig diskCacheConfig2 = builder.y;
            this.A = diskCacheConfig2 != null ? diskCacheConfig2 : diskCacheConfig;
            this.B = builder.A;
            int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
            ExecutorSupplier executorSupplier = builder.i;
            this.j = executorSupplier == null ? new DefaultExecutorSupplier(flexByteArrayPoolMaxNumThreads) : executorSupplier;
            this.D = builder.D;
            this.E = builder.E;
            this.F = builder.F;
            this.G = builder.G;
            this.H = builder.H;
            WebpBitmapFactory webpBitmapFactory = build.getWebpBitmapFactory();
            if (webpBitmapFactory != null) {
                HoneycombBitmapCreator honeycombBitmapCreator = new HoneycombBitmapCreator(getPoolFactory());
                WebpSupportStatus.sWebpBitmapFactory = webpBitmapFactory;
                WebpBitmapFactory.WebpErrorLogger webpErrorLogger = build.getWebpErrorLogger();
                if (webpErrorLogger != null) {
                    webpBitmapFactory.setWebpErrorLogger(webpErrorLogger);
                }
                webpBitmapFactory.setBitmapCreator(honeycombBitmapCreator);
            } else if (build.isWebpSupportEnabled() && WebpSupportStatus.sIsWebpSupportRequired && (loadWebpBitmapFactoryIfExists = WebpSupportStatus.loadWebpBitmapFactoryIfExists()) != null) {
                HoneycombBitmapCreator honeycombBitmapCreator2 = new HoneycombBitmapCreator(getPoolFactory());
                WebpSupportStatus.sWebpBitmapFactory = loadWebpBitmapFactoryIfExists;
                WebpBitmapFactory.WebpErrorLogger webpErrorLogger2 = build.getWebpErrorLogger();
                if (webpErrorLogger2 != null) {
                    loadWebpBitmapFactoryIfExists.setWebpErrorLogger(webpErrorLogger2);
                }
                loadWebpBitmapFactoryIfExists.setBitmapCreator(honeycombBitmapCreator2);
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
                return;
            }
            return;
        }
        throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType");
    }

    public static DefaultImageRequestConfig getDefaultImageRequestConfig() {
        return I;
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context, null);
    }

    @Nullable
    public MemoryCache<CacheKey, CloseableImage> getBitmapCacheOverride() {
        return this.G;
    }

    public Bitmap.Config getBitmapConfig() {
        return this.a;
    }

    public CountingMemoryCache.EntryStateObserver<CacheKey> getBitmapMemoryCacheEntryStateObserver() {
        return this.d;
    }

    public Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
        return this.b;
    }

    public MemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
        return this.c;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.e;
    }

    @Nullable
    public CallerContextVerifier getCallerContextVerifier() {
        return this.E;
    }

    public CloseableReferenceLeakTracker getCloseableReferenceLeakTracker() {
        return this.F;
    }

    public Context getContext() {
        return this.f;
    }

    @Nullable
    public MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCacheOverride() {
        return this.H;
    }

    public Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
        return this.i;
    }

    public ExecutorSupplier getExecutorSupplier() {
        return this.j;
    }

    public ImagePipelineExperiments getExperiments() {
        return this.C;
    }

    public FileCacheFactory getFileCacheFactory() {
        return this.h;
    }

    public ImageCacheStatsTracker getImageCacheStatsTracker() {
        return this.k;
    }

    @Nullable
    public ImageDecoder getImageDecoder() {
        return this.l;
    }

    @Nullable
    public ImageDecoderConfig getImageDecoderConfig() {
        return this.B;
    }

    @Nullable
    public ImageTranscoderFactory getImageTranscoderFactory() {
        return this.m;
    }

    @Nullable
    public Integer getImageTranscoderType() {
        return this.n;
    }

    public Supplier<Boolean> getIsPrefetchEnabledSupplier() {
        return this.o;
    }

    public DiskCacheConfig getMainDiskCacheConfig() {
        return this.p;
    }

    public int getMemoryChunkType() {
        return this.r;
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.q;
    }

    public NetworkFetcher getNetworkFetcher() {
        return this.s;
    }

    @Nullable
    public PlatformBitmapFactory getPlatformBitmapFactory() {
        return this.u;
    }

    public PoolFactory getPoolFactory() {
        return this.v;
    }

    public ProgressiveJpegConfig getProgressiveJpegConfig() {
        return this.w;
    }

    public Set<RequestListener2> getRequestListener2s() {
        return Collections.unmodifiableSet(this.y);
    }

    public Set<RequestListener> getRequestListeners() {
        return Collections.unmodifiableSet(this.x);
    }

    public DiskCacheConfig getSmallImageDiskCacheConfig() {
        return this.A;
    }

    public boolean isDiskCacheEnabled() {
        return this.D;
    }

    public boolean isDownsampleEnabled() {
        return this.g;
    }

    public boolean isResizeAndRotateEnabledForNetwork() {
        return this.z;
    }

    public static class DefaultImageRequestConfig {
        public boolean a = false;

        public DefaultImageRequestConfig() {
        }

        public boolean isProgressiveRenderingEnabled() {
            return this.a;
        }

        public void setProgressiveRenderingEnabled(boolean z) {
            this.a = z;
        }

        public DefaultImageRequestConfig(b bVar) {
        }
    }
}
