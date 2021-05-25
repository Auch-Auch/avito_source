package com.facebook.imagepipeline.producers;

import a2.g.p.e.i;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.nativecode.WebpTranscoder;
import com.facebook.imagepipeline.nativecode.WebpTranscoderFactory;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
public class WebpTranscodeProducer implements Producer<EncodedImage> {
    public static final String PRODUCER_NAME = "WebpTranscodeProducer";
    public final Executor a;
    public final PooledByteBufferFactory b;
    public final Producer<EncodedImage> c;

    public class a extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final ProducerContext c;
        public TriState d = TriState.UNSET;

        public a(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer);
            this.c = producerContext;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable Object obj, int i) {
            EncodedImage encodedImage = (EncodedImage) obj;
            TriState triState = this.d;
            TriState triState2 = TriState.UNSET;
            if (triState == triState2 && encodedImage != null) {
                Preconditions.checkNotNull(encodedImage);
                ImageFormat imageFormat_WrapIOException = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
                if (DefaultImageFormats.isStaticWebpFormat(imageFormat_WrapIOException)) {
                    WebpTranscoder webpTranscoder = WebpTranscoderFactory.getWebpTranscoder();
                    if (webpTranscoder == null) {
                        triState2 = TriState.NO;
                    } else {
                        triState2 = TriState.valueOf(!webpTranscoder.isWebpNativelySupported(imageFormat_WrapIOException));
                    }
                } else if (imageFormat_WrapIOException != ImageFormat.UNKNOWN) {
                    triState2 = TriState.NO;
                }
                this.d = triState2;
            }
            if (this.d == TriState.NO) {
                getConsumer().onNewResult(encodedImage, i);
            } else if (!BaseConsumer.isLast(i)) {
            } else {
                if (this.d != TriState.YES || encodedImage == null) {
                    getConsumer().onNewResult(encodedImage, i);
                    return;
                }
                WebpTranscodeProducer webpTranscodeProducer = WebpTranscodeProducer.this;
                Consumer consumer = getConsumer();
                ProducerContext producerContext = this.c;
                Objects.requireNonNull(webpTranscodeProducer);
                Preconditions.checkNotNull(encodedImage);
                webpTranscodeProducer.a.execute(new i(webpTranscodeProducer, consumer, producerContext.getProducerListener(), producerContext, WebpTranscodeProducer.PRODUCER_NAME, EncodedImage.cloneOrNull(encodedImage)));
            }
        }
    }

    public WebpTranscodeProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer) {
        this.a = (Executor) Preconditions.checkNotNull(executor);
        this.b = (PooledByteBufferFactory) Preconditions.checkNotNull(pooledByteBufferFactory);
        this.c = (Producer) Preconditions.checkNotNull(producer);
    }

    public static void a(EncodedImage encodedImage, PooledByteBufferOutputStream pooledByteBufferOutputStream) throws Exception {
        InputStream inputStream = encodedImage.getInputStream();
        ImageFormat imageFormat_WrapIOException = ImageFormatChecker.getImageFormat_WrapIOException(inputStream);
        if (imageFormat_WrapIOException == DefaultImageFormats.WEBP_SIMPLE || imageFormat_WrapIOException == DefaultImageFormats.WEBP_EXTENDED) {
            WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToJpeg(inputStream, pooledByteBufferOutputStream, 80);
            encodedImage.setImageFormat(DefaultImageFormats.JPEG);
        } else if (imageFormat_WrapIOException == DefaultImageFormats.WEBP_LOSSLESS || imageFormat_WrapIOException == DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA) {
            WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToPng(inputStream, pooledByteBufferOutputStream);
            encodedImage.setImageFormat(DefaultImageFormats.PNG);
        } else {
            throw new IllegalArgumentException("Wrong image format");
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.c.produceResults(new a(consumer, producerContext), producerContext);
    }
}
