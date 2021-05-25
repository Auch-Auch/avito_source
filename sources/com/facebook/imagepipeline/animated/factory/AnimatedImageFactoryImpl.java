package com.facebook.imagepipeline.animated.factory;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
public class AnimatedImageFactoryImpl implements AnimatedImageFactory {
    public static AnimatedImageDecoder c;
    public static AnimatedImageDecoder d;
    public final AnimatedDrawableBackendProvider a;
    public final PlatformBitmapFactory b;

    public class a implements AnimatedImageCompositor.Callback {
        public a(AnimatedImageFactoryImpl animatedImageFactoryImpl) {
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
        @Nullable
        public CloseableReference<Bitmap> getCachedBitmap(int i) {
            return null;
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
        public void onIntermediateResult(int i, Bitmap bitmap) {
        }
    }

    public class b implements AnimatedImageCompositor.Callback {
        public final /* synthetic */ List a;

        public b(AnimatedImageFactoryImpl animatedImageFactoryImpl, List list) {
            this.a = list;
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
        public CloseableReference<Bitmap> getCachedBitmap(int i) {
            return CloseableReference.cloneOrNull((CloseableReference) this.a.get(i));
        }

        @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
        public void onIntermediateResult(int i, Bitmap bitmap) {
        }
    }

    static {
        AnimatedImageDecoder animatedImageDecoder;
        AnimatedImageDecoder animatedImageDecoder2 = null;
        try {
            animatedImageDecoder = (AnimatedImageDecoder) Class.forName("com.facebook.animated.gif.GifImage").newInstance();
        } catch (Throwable unused) {
            animatedImageDecoder = null;
        }
        c = animatedImageDecoder;
        try {
            animatedImageDecoder2 = (AnimatedImageDecoder) Class.forName("com.facebook.animated.webp.WebPImage").newInstance();
        } catch (Throwable unused2) {
        }
        d = animatedImageDecoder2;
    }

    public AnimatedImageFactoryImpl(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, PlatformBitmapFactory platformBitmapFactory) {
        this.a = animatedDrawableBackendProvider;
        this.b = platformBitmapFactory;
    }

    @SuppressLint({"NewApi"})
    public final CloseableReference<Bitmap> a(int i, int i2, Bitmap.Config config) {
        CloseableReference<Bitmap> createBitmapInternal = this.b.createBitmapInternal(i, i2, config);
        createBitmapInternal.get().eraseColor(0);
        createBitmapInternal.get().setHasAlpha(true);
        return createBitmapInternal;
    }

    public final CloseableReference<Bitmap> b(AnimatedImage animatedImage, Bitmap.Config config, int i) {
        CloseableReference<Bitmap> a3 = a(animatedImage.getWidth(), animatedImage.getHeight(), config);
        new AnimatedImageCompositor(this.a.get(AnimatedImageResult.forAnimatedImage(animatedImage), null), new a(this)).renderFrame(i, a3.get());
        return a3;
    }

    public final List<CloseableReference<Bitmap>> c(AnimatedImage animatedImage, Bitmap.Config config) {
        AnimatedDrawableBackend animatedDrawableBackend = this.a.get(AnimatedImageResult.forAnimatedImage(animatedImage), null);
        ArrayList arrayList = new ArrayList(animatedDrawableBackend.getFrameCount());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(animatedDrawableBackend, new b(this, arrayList));
        for (int i = 0; i < animatedDrawableBackend.getFrameCount(); i++) {
            CloseableReference<Bitmap> a3 = a(animatedDrawableBackend.getWidth(), animatedDrawableBackend.getHeight(), config);
            animatedImageCompositor.renderFrame(i, a3.get());
            arrayList.add(a3);
        }
        return arrayList;
    }

    public final CloseableImage d(ImageDecodeOptions imageDecodeOptions, AnimatedImage animatedImage, Bitmap.Config config) {
        Throwable th;
        List<CloseableReference<Bitmap>> list;
        CloseableReference<Bitmap> closeableReference = null;
        try {
            int frameCount = imageDecodeOptions.useLastFrameForPreview ? animatedImage.getFrameCount() - 1 : 0;
            if (imageDecodeOptions.forceStaticImage) {
                CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(b(animatedImage, config, frameCount), ImmutableQualityInfo.FULL_QUALITY, 0);
                CloseableReference.closeSafely((CloseableReference<?>) null);
                CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) null);
                return closeableStaticBitmap;
            }
            if (imageDecodeOptions.decodeAllFrames) {
                list = c(animatedImage, config);
                try {
                    closeableReference = CloseableReference.cloneOrNull((CloseableReference) ((ArrayList) list).get(frameCount));
                } catch (Throwable th2) {
                    th = th2;
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    CloseableReference.closeSafely(list);
                    throw th;
                }
            } else {
                list = null;
            }
            if (imageDecodeOptions.decodePreviewFrame && closeableReference == null) {
                closeableReference = b(animatedImage, config, frameCount);
            }
            CloseableAnimatedImage closeableAnimatedImage = new CloseableAnimatedImage(AnimatedImageResult.newBuilder(animatedImage).setPreviewBitmap(closeableReference).setFrameForPreview(frameCount).setDecodedFrames(list).setBitmapTransformation(imageDecodeOptions.bitmapTransformation).build());
            CloseableReference.closeSafely(closeableReference);
            CloseableReference.closeSafely(list);
            return closeableAnimatedImage;
        } catch (Throwable th3) {
            th = th3;
            list = null;
            CloseableReference.closeSafely((CloseableReference<?>) null);
            CloseableReference.closeSafely(list);
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageFactory
    public CloseableImage decodeGif(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config) {
        AnimatedImage animatedImage;
        if (c != null) {
            CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
            Preconditions.checkNotNull(byteBufferRef);
            try {
                PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
                if (pooledByteBuffer.getByteBuffer() != null) {
                    animatedImage = c.decodeFromByteBuffer(pooledByteBuffer.getByteBuffer(), imageDecodeOptions);
                } else {
                    animatedImage = c.decodeFromNativeMemory(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size(), imageDecodeOptions);
                }
                return d(imageDecodeOptions, animatedImage, config);
            } finally {
                CloseableReference.closeSafely(byteBufferRef);
            }
        } else {
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageFactory
    public CloseableImage decodeWebP(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config) {
        AnimatedImage animatedImage;
        if (d != null) {
            CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
            Preconditions.checkNotNull(byteBufferRef);
            try {
                PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
                if (pooledByteBuffer.getByteBuffer() != null) {
                    animatedImage = d.decodeFromByteBuffer(pooledByteBuffer.getByteBuffer(), imageDecodeOptions);
                } else {
                    animatedImage = d.decodeFromNativeMemory(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size(), imageDecodeOptions);
                }
                return d(imageDecodeOptions, animatedImage, config);
            } finally {
                CloseableReference.closeSafely(byteBufferRef);
            }
        } else {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
    }
}
