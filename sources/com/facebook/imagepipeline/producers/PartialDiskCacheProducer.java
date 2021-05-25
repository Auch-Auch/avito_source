package com.facebook.imagepipeline.producers;

import a2.g.p.e.d;
import a2.g.p.e.e;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
public class PartialDiskCacheProducer implements Producer<EncodedImage> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "PartialDiskCacheProducer";
    public final BufferedDiskCache a;
    public final CacheKeyFactory b;
    public final PooledByteBufferFactory c;
    public final ByteArrayPool d;
    public final Producer<EncodedImage> e;

    public static class a extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final BufferedDiskCache c;
        public final CacheKey d;
        public final PooledByteBufferFactory e;
        public final ByteArrayPool f;
        @Nullable
        public final EncodedImage g;

        public a(Consumer consumer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, EncodedImage encodedImage, d dVar) {
            super(consumer);
            this.c = bufferedDiskCache;
            this.d = cacheKey;
            this.e = pooledByteBufferFactory;
            this.f = byteArrayPool;
            this.g = encodedImage;
        }

        public final void a(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = (byte[]) this.f.get(16384);
            int i2 = i;
            while (i2 > 0) {
                try {
                    int read = inputStream.read(bArr, 0, Math.min(16384, i2));
                    if (read < 0) {
                        break;
                    } else if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        i2 -= read;
                    }
                } catch (Throwable th) {
                    this.f.release(bArr);
                    throw th;
                }
            }
            this.f.release(bArr);
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        public final PooledByteBufferOutputStream b(EncodedImage encodedImage, EncodedImage encodedImage2) throws IOException {
            PooledByteBufferOutputStream newOutputStream = this.e.newOutputStream(encodedImage2.getSize() + encodedImage2.getBytesRange().from);
            a(encodedImage.getInputStream(), newOutputStream, encodedImage2.getBytesRange().from);
            a(encodedImage2.getInputStream(), newOutputStream, encodedImage2.getSize());
            return newOutputStream;
        }

        public final void c(PooledByteBufferOutputStream pooledByteBufferOutputStream) {
            EncodedImage encodedImage;
            Throwable th;
            CloseableReference of = CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
            try {
                encodedImage = new EncodedImage(of);
                try {
                    encodedImage.parseMetaData();
                    getConsumer().onNewResult(encodedImage, 1);
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely(of);
                } catch (Throwable th2) {
                    th = th2;
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely(of);
                    throw th;
                }
            } catch (Throwable th3) {
                encodedImage = null;
                th = th3;
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(of);
                throw th;
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            EncodedImage encodedImage = (EncodedImage) obj;
            if (!BaseConsumer.isNotLast(i)) {
                if (this.g != null && encodedImage.getBytesRange() != null) {
                    try {
                        c(b(this.g, encodedImage));
                    } catch (IOException e2) {
                        FLog.e(PartialDiskCacheProducer.PRODUCER_NAME, "Error while merging image data", e2);
                        getConsumer().onFailure(e2);
                    } catch (Throwable th) {
                        encodedImage.close();
                        this.g.close();
                        throw th;
                    }
                    encodedImage.close();
                    this.g.close();
                    this.c.remove(this.d);
                } else if (!BaseConsumer.statusHasFlag(i, 8) || !BaseConsumer.isLast(i) || encodedImage.getImageFormat() == ImageFormat.UNKNOWN) {
                    getConsumer().onNewResult(encodedImage, i);
                } else {
                    this.c.put(this.d, encodedImage);
                    getConsumer().onNewResult(encodedImage, i);
                }
            }
        }
    }

    public PartialDiskCacheProducer(BufferedDiskCache bufferedDiskCache, CacheKeyFactory cacheKeyFactory, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, Producer<EncodedImage> producer) {
        this.a = bufferedDiskCache;
        this.b = cacheKeyFactory;
        this.c = pooledByteBufferFactory;
        this.d = byteArrayPool;
        this.e = producer;
    }

    public static void a(PartialDiskCacheProducer partialDiskCacheProducer, Consumer consumer, ProducerContext producerContext, CacheKey cacheKey, EncodedImage encodedImage) {
        partialDiskCacheProducer.e.produceResults(new a(consumer, partialDiskCacheProducer.a, cacheKey, partialDiskCacheProducer.c, partialDiskCacheProducer.d, encodedImage, null), producerContext);
    }

    @VisibleForTesting
    @Nullable
    public static Map<String, String> b(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z, int i) {
        if (!producerListener2.requiresExtraMap(producerContext, PRODUCER_NAME)) {
            return null;
        }
        if (z) {
            return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
        }
        return ImmutableMap.of("cached_value_found", String.valueOf(z));
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (!imageRequest.isDiskCacheEnabled()) {
            this.e.produceResults(consumer, producerContext);
            return;
        }
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        CacheKey encodedCacheKey = this.b.getEncodedCacheKey(imageRequest, imageRequest.getSourceUri().buildUpon().appendQueryParameter("fresco_partial", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE).build(), producerContext.getCallerContext());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.a.get(encodedCacheKey, atomicBoolean).continueWith(new d(this, producerContext.getProducerListener(), producerContext, consumer, encodedCacheKey));
        producerContext.addCallbacks(new e(this, atomicBoolean));
    }
}
