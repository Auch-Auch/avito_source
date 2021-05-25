package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
public class ResizeAndRotateProducer implements Producer<EncodedImage> {
    public final Executor a;
    public final PooledByteBufferFactory b;
    public final Producer<EncodedImage> c;
    public final boolean d;
    public final ImageTranscoderFactory e;

    public class a extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final boolean c;
        public final ImageTranscoderFactory d;
        public final ProducerContext e;
        public boolean f = false;
        public final JobScheduler g;

        /* renamed from: com.facebook.imagepipeline.producers.ResizeAndRotateProducer$a$a  reason: collision with other inner class name */
        public class C0181a implements JobScheduler.JobRunnable {
            public C0181a(ResizeAndRotateProducer resizeAndRotateProducer) {
            }

            /* JADX INFO: finally extract failed */
            @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
            public void run(EncodedImage encodedImage, int i) {
                a aVar = a.this;
                ImageTranscoder imageTranscoder = (ImageTranscoder) Preconditions.checkNotNull(aVar.d.createImageTranscoder(encodedImage.getImageFormat(), a.this.c));
                aVar.e.getProducerListener().onProducerStart(aVar.e, "ResizeAndRotateProducer");
                ImageRequest imageRequest = aVar.e.getImageRequest();
                PooledByteBufferOutputStream newOutputStream = ResizeAndRotateProducer.this.b.newOutputStream();
                try {
                    ImageTranscodeResult transcode = imageTranscoder.transcode(encodedImage, newOutputStream, imageRequest.getRotationOptions(), imageRequest.getResizeOptions(), null, 85);
                    if (transcode.getTranscodeStatus() != 2) {
                        Map<String, String> a3 = aVar.a(encodedImage, imageRequest.getResizeOptions(), transcode, imageTranscoder.getIdentifier());
                        CloseableReference of = CloseableReference.of(newOutputStream.toByteBuffer());
                        try {
                            EncodedImage encodedImage2 = new EncodedImage(of);
                            encodedImage2.setImageFormat(DefaultImageFormats.JPEG);
                            try {
                                encodedImage2.parseMetaData();
                                aVar.e.getProducerListener().onProducerFinishWithSuccess(aVar.e, "ResizeAndRotateProducer", a3);
                                if (transcode.getTranscodeStatus() != 1) {
                                    i |= 16;
                                }
                                aVar.getConsumer().onNewResult(encodedImage2, i);
                                EncodedImage.closeSafely(encodedImage2);
                                newOutputStream.close();
                            } catch (Throwable th) {
                                EncodedImage.closeSafely(encodedImage2);
                                throw th;
                            }
                        } finally {
                            CloseableReference.closeSafely(of);
                        }
                    } else {
                        throw new RuntimeException("Error while transcoding the image");
                    }
                } catch (Exception e) {
                    aVar.e.getProducerListener().onProducerFinishWithFailure(aVar.e, "ResizeAndRotateProducer", e, null);
                    if (BaseConsumer.isLast(i)) {
                        aVar.getConsumer().onFailure(e);
                    }
                } catch (Throwable th2) {
                    newOutputStream.close();
                    throw th2;
                }
            }
        }

        public class b extends BaseProducerContextCallbacks {
            public final /* synthetic */ Consumer a;

            public b(ResizeAndRotateProducer resizeAndRotateProducer, Consumer consumer) {
                this.a = consumer;
            }

            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                a.this.g.clearJob();
                a.this.f = true;
                this.a.onCancellation();
            }

            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onIsIntermediateResultExpectedChanged() {
                if (a.this.e.isIntermediateResultExpected()) {
                    a.this.g.scheduleJob();
                }
            }
        }

        public a(Consumer<EncodedImage> consumer, ProducerContext producerContext, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
            super(consumer);
            this.e = producerContext;
            Boolean resizingAllowedOverride = producerContext.getImageRequest().getResizingAllowedOverride();
            this.c = resizingAllowedOverride != null ? resizingAllowedOverride.booleanValue() : z;
            this.d = imageTranscoderFactory;
            this.g = new JobScheduler(ResizeAndRotateProducer.this.a, new C0181a(ResizeAndRotateProducer.this), 100);
            producerContext.addCallbacks(new b(ResizeAndRotateProducer.this, consumer));
        }

        @Nullable
        public final Map<String, String> a(EncodedImage encodedImage, @Nullable ResizeOptions resizeOptions, @Nullable ImageTranscodeResult imageTranscodeResult, @Nullable String str) {
            String str2;
            if (!this.e.getProducerListener().requiresExtraMap(this.e, "ResizeAndRotateProducer")) {
                return null;
            }
            String str3 = encodedImage.getWidth() + "x" + encodedImage.getHeight();
            if (resizeOptions != null) {
                str2 = resizeOptions.width + "x" + resizeOptions.height;
            } else {
                str2 = "Unspecified";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Image format", String.valueOf(encodedImage.getImageFormat()));
            hashMap.put("Original size", str3);
            hashMap.put("Requested size", str2);
            hashMap.put("queueTime", String.valueOf(this.g.getQueuedTime()));
            hashMap.put("Transcoder id", str);
            hashMap.put("Transcoding result", String.valueOf(imageTranscodeResult));
            return ImmutableMap.copyOf(hashMap);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x007c, code lost:
            if (r5 != false) goto L_0x007e;
         */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNewResultImpl(@javax.annotation.Nullable java.lang.Object r9, int r10) {
            /*
            // Method dump skipped, instructions count: 279
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.a.onNewResultImpl(java.lang.Object, int):void");
        }
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer, boolean z, ImageTranscoderFactory imageTranscoderFactory) {
        this.a = (Executor) Preconditions.checkNotNull(executor);
        this.b = (PooledByteBufferFactory) Preconditions.checkNotNull(pooledByteBufferFactory);
        this.c = (Producer) Preconditions.checkNotNull(producer);
        this.e = (ImageTranscoderFactory) Preconditions.checkNotNull(imageTranscoderFactory);
        this.d = z;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.c.produceResults(new a(consumer, producerContext, this.d, this.e), producerContext);
    }
}
