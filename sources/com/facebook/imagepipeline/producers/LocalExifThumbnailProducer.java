package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.util.Pair;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.JfifUtil;
import com.facebook.soloader.DoNotOptimize;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
public class LocalExifThumbnailProducer implements ThumbnailProducer<EncodedImage> {
    public static final String PRODUCER_NAME = "LocalExifThumbnailProducer";
    public final Executor a;
    public final PooledByteBufferFactory b;
    public final ContentResolver c;

    @DoNotOptimize
    public class Api24Utils {
    }

    public class a extends StatefulProducerRunnable<EncodedImage> {
        public final /* synthetic */ ImageRequest e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ImageRequest imageRequest) {
            super(consumer, producerListener2, producerContext, str);
            this.e = imageRequest;
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void disposeResult(Object obj) {
            EncodedImage.closeSafely((EncodedImage) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
        public Map getExtraMapOnSuccess(EncodedImage encodedImage) {
            return ImmutableMap.of("createdThumbnail", Boolean.toString(encodedImage != null));
        }

        /* JADX INFO: finally extract failed */
        @Override // com.facebook.common.executors.StatefulRunnable
        @Nullable
        public Object getResult() throws Exception {
            ExifInterface exifInterface;
            int i;
            Uri sourceUri = this.e.getSourceUri();
            LocalExifThumbnailProducer localExifThumbnailProducer = LocalExifThumbnailProducer.this;
            String realPathFromUri = UriUtil.getRealPathFromUri(localExifThumbnailProducer.c, sourceUri);
            boolean z = false;
            if (realPathFromUri != null) {
                try {
                    File file = new File(realPathFromUri);
                    if (file.exists() && file.canRead()) {
                        z = true;
                    }
                } catch (IOException unused) {
                } catch (StackOverflowError unused2) {
                    FLog.e(LocalExifThumbnailProducer.class, "StackOverflowError in ExifInterface constructor");
                }
            }
            if (z) {
                exifInterface = new ExifInterface(realPathFromUri);
            } else {
                AssetFileDescriptor assetFileDescriptor = UriUtil.getAssetFileDescriptor(localExifThumbnailProducer.c, sourceUri);
                if (assetFileDescriptor != null && (i = Build.VERSION.SDK_INT) >= 24) {
                    ExifInterface exifInterface2 = i >= 24 ? new ExifInterface(assetFileDescriptor.getFileDescriptor()) : null;
                    assetFileDescriptor.close();
                    exifInterface = exifInterface2;
                }
                exifInterface = null;
            }
            if (exifInterface == null || !exifInterface.hasThumbnail()) {
                return null;
            }
            PooledByteBuffer newByteBuffer = LocalExifThumbnailProducer.this.b.newByteBuffer(exifInterface.getThumbnail());
            Objects.requireNonNull(LocalExifThumbnailProducer.this);
            Pair<Integer, Integer> decodeDimensions = BitmapUtil.decodeDimensions(new PooledByteBufferInputStream(newByteBuffer));
            int autoRotateAngleFromOrientation = JfifUtil.getAutoRotateAngleFromOrientation(Integer.parseInt(exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION)));
            int i2 = -1;
            int intValue = decodeDimensions != null ? ((Integer) decodeDimensions.first).intValue() : -1;
            if (decodeDimensions != null) {
                i2 = ((Integer) decodeDimensions.second).intValue();
            }
            CloseableReference of = CloseableReference.of(newByteBuffer);
            try {
                EncodedImage encodedImage = new EncodedImage(of);
                CloseableReference.closeSafely(of);
                encodedImage.setImageFormat(DefaultImageFormats.JPEG);
                encodedImage.setRotationAngle(autoRotateAngleFromOrientation);
                encodedImage.setWidth(intValue);
                encodedImage.setHeight(i2);
                return encodedImage;
            } catch (Throwable th) {
                CloseableReference.closeSafely(of);
                throw th;
            }
        }
    }

    public class b extends BaseProducerContextCallbacks {
        public final /* synthetic */ StatefulProducerRunnable a;

        public b(LocalExifThumbnailProducer localExifThumbnailProducer, StatefulProducerRunnable statefulProducerRunnable) {
            this.a = statefulProducerRunnable;
        }

        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void onCancellationRequested() {
            this.a.cancel();
        }
    }

    public LocalExifThumbnailProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        this.a = executor;
        this.b = pooledByteBufferFactory;
        this.c = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public boolean canProvideImageForSize(ResizeOptions resizeOptions) {
        return ThumbnailSizeChecker.isImageBigEnough(512, 512, resizeOptions);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ProducerListener2 producerListener = producerContext.getProducerListener();
        ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra(ImagesContract.LOCAL, "exif");
        a aVar = new a(consumer, producerListener, producerContext, PRODUCER_NAME, imageRequest);
        producerContext.addCallbacks(new b(this, aVar));
        this.a.execute(aVar);
    }
}
