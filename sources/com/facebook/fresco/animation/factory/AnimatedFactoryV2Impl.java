package com.facebook.fresco.animation.factory;

import a2.g.n.a.a.c;
import a2.g.n.a.a.d;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@DoNotStrip
@NotThreadSafe
public class AnimatedFactoryV2Impl implements AnimatedFactory {
    public final PlatformBitmapFactory a;
    public final ExecutorSupplier b;
    public final CountingMemoryCache<CacheKey, CloseableImage> c;
    public final boolean d;
    @Nullable
    public AnimatedImageFactory e;
    @Nullable
    public AnimatedDrawableBackendProvider f;
    @Nullable
    public AnimatedDrawableUtil g;
    @Nullable
    public DrawableFactory h;

    public class a implements ImageDecoder {
        public final /* synthetic */ Bitmap.Config a;

        public a(Bitmap.Config config) {
            this.a = config;
        }

        @Override // com.facebook.imagepipeline.decoder.ImageDecoder
        public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
            if (animatedFactoryV2Impl.e == null) {
                animatedFactoryV2Impl.e = new AnimatedImageFactoryImpl(new d(animatedFactoryV2Impl), animatedFactoryV2Impl.a);
            }
            return animatedFactoryV2Impl.e.decodeGif(encodedImage, imageDecodeOptions, this.a);
        }
    }

    public class b implements ImageDecoder {
        public final /* synthetic */ Bitmap.Config a;

        public b(Bitmap.Config config) {
            this.a = config;
        }

        @Override // com.facebook.imagepipeline.decoder.ImageDecoder
        public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
            if (animatedFactoryV2Impl.e == null) {
                animatedFactoryV2Impl.e = new AnimatedImageFactoryImpl(new d(animatedFactoryV2Impl), animatedFactoryV2Impl.a);
            }
            return animatedFactoryV2Impl.e.decodeWebP(encodedImage, imageDecodeOptions, this.a);
        }
    }

    @DoNotStrip
    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, boolean z) {
        this.a = platformBitmapFactory;
        this.b = executorSupplier;
        this.c = countingMemoryCache;
        this.d = z;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    @Nullable
    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        if (this.h == null) {
            a2.g.n.a.a.a aVar = new a2.g.n.a.a.a(this);
            DefaultSerialExecutorService defaultSerialExecutorService = new DefaultSerialExecutorService(this.b.forDecode());
            a2.g.n.a.a.b bVar = new a2.g.n.a.a.b(this);
            if (this.f == null) {
                this.f = new c(this);
            }
            this.h = new ExperimentalBitmapAnimationDrawableFactory(this.f, UiThreadImmediateExecutorService.getInstance(), defaultSerialExecutorService, RealtimeSinceBootClock.get(), this.a, this.c, aVar, bVar);
        }
        return this.h;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    public ImageDecoder getGifDecoder(Bitmap.Config config) {
        return new a(config);
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    public ImageDecoder getWebPDecoder(Bitmap.Config config) {
        return new b(config);
    }
}
