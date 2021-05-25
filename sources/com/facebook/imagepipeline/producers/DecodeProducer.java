package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_BITMAP_BYTES = "byteCount";
    public static final String EXTRA_BITMAP_SIZE = "bitmapSize";
    public static final String EXTRA_HAS_GOOD_QUALITY = "hasGoodQuality";
    public static final String EXTRA_IMAGE_FORMAT_NAME = "imageFormat";
    public static final String EXTRA_IS_FINAL = "isFinal";
    public static final String PRODUCER_NAME = "DecodeProducer";
    public static final String REQUESTED_IMAGE_SIZE = "requestedImageSize";
    public static final String SAMPLE_SIZE = "sampleSize";
    public final ByteArrayPool a;
    public final Executor b;
    public final ImageDecoder c;
    public final ProgressiveJpegConfig d;
    public final Producer<EncodedImage> e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final CloseableReferenceFactory j;
    @Nullable
    public final Runnable k;
    public final Supplier<Boolean> l;

    public class a extends c {
        public a(DecodeProducer decodeProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, boolean z, int i) {
            super(consumer, producerContext, z, i);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.c
        public int b(EncodedImage encodedImage) {
            return encodedImage.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.c
        public QualityInfo c() {
            return ImmutableQualityInfo.of(0, false, false);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.c
        public synchronized boolean g(EncodedImage encodedImage, int i) {
            if (BaseConsumer.isNotLast(i)) {
                return false;
            }
            return this.g.updateJob(encodedImage, i);
        }
    }

    public class b extends c {
        public final ProgressiveJpegParser i;
        public final ProgressiveJpegConfig j;
        public int k = 0;

        public b(DecodeProducer decodeProducer, Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig, boolean z, int i2) {
            super(consumer, producerContext, z, i2);
            this.i = (ProgressiveJpegParser) Preconditions.checkNotNull(progressiveJpegParser);
            this.j = (ProgressiveJpegConfig) Preconditions.checkNotNull(progressiveJpegConfig);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.c
        public int b(EncodedImage encodedImage) {
            return this.i.getBestScanEndOffset();
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.c
        public QualityInfo c() {
            return this.j.getQualityInfo(this.i.getBestScanNumber());
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.c
        public synchronized boolean g(EncodedImage encodedImage, int i2) {
            boolean updateJob = this.g.updateJob(encodedImage, i2);
            if ((BaseConsumer.isNotLast(i2) || BaseConsumer.statusHasFlag(i2, 8)) && !BaseConsumer.statusHasFlag(i2, 4) && EncodedImage.isValid(encodedImage) && encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
                if (!this.i.parseMoreData(encodedImage)) {
                    return false;
                }
                int bestScanNumber = this.i.getBestScanNumber();
                int i3 = this.k;
                if (bestScanNumber <= i3) {
                    return false;
                }
                if (bestScanNumber < this.j.getNextScanNumberToDecode(i3) && !this.i.isEndMarkerRead()) {
                    return false;
                }
                this.k = bestScanNumber;
            }
            return updateJob;
        }
    }

    public abstract class c extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {
        public final ProducerContext c;
        public final ProducerListener2 d;
        public final ImageDecodeOptions e;
        @GuardedBy("this")
        public boolean f = false;
        public final JobScheduler g;

        public class a implements JobScheduler.JobRunnable {
            public final /* synthetic */ ProducerContext a;
            public final /* synthetic */ int b;

            public a(DecodeProducer decodeProducer, ProducerContext producerContext, int i) {
                this.a = producerContext;
                this.b = i;
            }

            /* JADX WARNING: Removed duplicated region for block: B:51:0x013a A[Catch:{ all -> 0x01ef }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x0159  */
            @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run(com.facebook.imagepipeline.image.EncodedImage r20, int r21) {
                /*
                // Method dump skipped, instructions count: 505
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.DecodeProducer.c.a.run(com.facebook.imagepipeline.image.EncodedImage, int):void");
            }
        }

        public class b extends BaseProducerContextCallbacks {
            public final /* synthetic */ boolean a;

            public b(DecodeProducer decodeProducer, boolean z) {
                this.a = z;
            }

            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                if (this.a) {
                    c cVar = c.this;
                    cVar.e(true);
                    cVar.getConsumer().onCancellation();
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onIsIntermediateResultExpectedChanged() {
                if (c.this.c.isIntermediateResultExpected()) {
                    c.this.g.scheduleJob();
                }
            }
        }

        public c(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, boolean z, int i) {
            super(consumer);
            this.c = producerContext;
            this.d = producerContext.getProducerListener();
            ImageDecodeOptions imageDecodeOptions = producerContext.getImageRequest().getImageDecodeOptions();
            this.e = imageDecodeOptions;
            this.g = new JobScheduler(DecodeProducer.this.b, new a(DecodeProducer.this, producerContext, i), imageDecodeOptions.minDecodeIntervalMs);
            producerContext.addCallbacks(new b(DecodeProducer.this, z));
        }

        @Nullable
        public final Map<String, String> a(@Nullable CloseableImage closeableImage, long j, QualityInfo qualityInfo, boolean z, String str, String str2, String str3, String str4) {
            if (!this.d.requiresExtraMap(this.c, DecodeProducer.PRODUCER_NAME)) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(qualityInfo.isOfGoodEnoughQuality());
            String valueOf3 = String.valueOf(z);
            if (closeableImage instanceof CloseableStaticBitmap) {
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap();
                HashMap hashMap = new HashMap(8);
                hashMap.put(DecodeProducer.EXTRA_BITMAP_SIZE, underlyingBitmap.getWidth() + "x" + underlyingBitmap.getHeight());
                hashMap.put("queueTime", valueOf);
                hashMap.put(DecodeProducer.EXTRA_HAS_GOOD_QUALITY, valueOf2);
                hashMap.put(DecodeProducer.EXTRA_IS_FINAL, valueOf3);
                hashMap.put("encodedImageSize", str2);
                hashMap.put(DecodeProducer.EXTRA_IMAGE_FORMAT_NAME, str);
                hashMap.put(DecodeProducer.REQUESTED_IMAGE_SIZE, str3);
                hashMap.put(DecodeProducer.SAMPLE_SIZE, str4);
                hashMap.put(DecodeProducer.EXTRA_BITMAP_BYTES, underlyingBitmap.getByteCount() + "");
                return ImmutableMap.copyOf(hashMap);
            }
            HashMap hashMap2 = new HashMap(7);
            hashMap2.put("queueTime", valueOf);
            hashMap2.put(DecodeProducer.EXTRA_HAS_GOOD_QUALITY, valueOf2);
            hashMap2.put(DecodeProducer.EXTRA_IS_FINAL, valueOf3);
            hashMap2.put("encodedImageSize", str2);
            hashMap2.put(DecodeProducer.EXTRA_IMAGE_FORMAT_NAME, str);
            hashMap2.put(DecodeProducer.REQUESTED_IMAGE_SIZE, str3);
            hashMap2.put(DecodeProducer.SAMPLE_SIZE, str4);
            return ImmutableMap.copyOf(hashMap2);
        }

        public abstract int b(EncodedImage encodedImage);

        public abstract QualityInfo c();

        public final CloseableImage d(EncodedImage encodedImage, int i, QualityInfo qualityInfo) {
            DecodeProducer decodeProducer = DecodeProducer.this;
            boolean z = decodeProducer.k != null && decodeProducer.l.get().booleanValue();
            try {
                return DecodeProducer.this.c.decode(encodedImage, i, qualityInfo, this.e);
            } catch (OutOfMemoryError e2) {
                if (z) {
                    DecodeProducer.this.k.run();
                    System.gc();
                    return DecodeProducer.this.c.decode(encodedImage, i, qualityInfo, this.e);
                }
                throw e2;
            }
        }

        public final void e(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.f) {
                        getConsumer().onProgressUpdate(1.0f);
                        this.f = true;
                        this.g.clearJob();
                    }
                }
            }
        }

        public final void f(EncodedImage encodedImage, CloseableImage closeableImage) {
            Bitmap.Config config;
            this.c.setExtra(ProducerContext.ExtraKeys.ENCODED_WIDTH, Integer.valueOf(encodedImage.getWidth()));
            this.c.setExtra(ProducerContext.ExtraKeys.ENCODED_HEIGHT, Integer.valueOf(encodedImage.getHeight()));
            this.c.setExtra(ProducerContext.ExtraKeys.ENCODED_SIZE, Integer.valueOf(encodedImage.getSize()));
            if (closeableImage instanceof CloseableBitmap) {
                Bitmap underlyingBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap();
                if (underlyingBitmap == null) {
                    config = null;
                } else {
                    config = underlyingBitmap.getConfig();
                }
                this.c.setExtra("bitmap_config", String.valueOf(config));
            }
            if (closeableImage != null) {
                closeableImage.setImageExtras(this.c.getExtras());
            }
        }

        public abstract boolean g(EncodedImage encodedImage, int i);

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            e(true);
            getConsumer().onCancellation();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            e(true);
            getConsumer().onFailure(th);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            boolean isTracing;
            EncodedImage encodedImage = (EncodedImage) obj;
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("DecodeProducer#onNewResultImpl");
                }
                boolean isLast = BaseConsumer.isLast(i);
                if (isLast) {
                    if (encodedImage == null) {
                        ExceptionWithNoStacktrace exceptionWithNoStacktrace = new ExceptionWithNoStacktrace("Encoded image is null.");
                        e(true);
                        getConsumer().onFailure(exceptionWithNoStacktrace);
                        if (!isTracing) {
                            return;
                        }
                    } else if (!encodedImage.isValid()) {
                        ExceptionWithNoStacktrace exceptionWithNoStacktrace2 = new ExceptionWithNoStacktrace("Encoded image is not valid.");
                        e(true);
                        getConsumer().onFailure(exceptionWithNoStacktrace2);
                        if (!FrescoSystrace.isTracing()) {
                            return;
                        }
                    }
                }
                if (g(encodedImage, i)) {
                    boolean statusHasFlag = BaseConsumer.statusHasFlag(i, 4);
                    if (isLast || statusHasFlag || this.c.isIntermediateResultExpected()) {
                        this.g.scheduleJob();
                    }
                    if (!FrescoSystrace.isTracing()) {
                    }
                } else if (!FrescoSystrace.isTracing()) {
                }
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onProgressUpdateImpl(float f2) {
            super.onProgressUpdateImpl(f2 * 0.99f);
        }
    }

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, Producer<EncodedImage> producer, int i2, CloseableReferenceFactory closeableReferenceFactory, @Nullable Runnable runnable, Supplier<Boolean> supplier) {
        this.a = (ByteArrayPool) Preconditions.checkNotNull(byteArrayPool);
        this.b = (Executor) Preconditions.checkNotNull(executor);
        this.c = (ImageDecoder) Preconditions.checkNotNull(imageDecoder);
        this.d = (ProgressiveJpegConfig) Preconditions.checkNotNull(progressiveJpegConfig);
        this.f = z;
        this.g = z2;
        this.e = (Producer) Preconditions.checkNotNull(producer);
        this.h = z3;
        this.i = i2;
        this.j = closeableReferenceFactory;
        this.k = runnable;
        this.l = supplier;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Consumer<EncodedImage> consumer2;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DecodeProducer#produceResults");
            }
            if (!UriUtil.isNetworkUri(producerContext.getImageRequest().getSourceUri())) {
                consumer2 = new a(this, consumer, producerContext, this.h, this.i);
            } else {
                consumer2 = new b(this, consumer, producerContext, new ProgressiveJpegParser(this.a), this.d, this.h, this.i);
            }
            this.e.produceResults(consumer2, producerContext);
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }
}
