package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.internal.ServerProtocol;
import java.util.Map;
public class EncodedMemoryCacheProducer implements Producer<EncodedImage> {
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
    public final MemoryCache<CacheKey, PooledByteBuffer> a;
    public final CacheKeyFactory b;
    public final Producer<EncodedImage> c;

    public static class a extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final MemoryCache<CacheKey, PooledByteBuffer> c;
        public final CacheKey d;
        public final boolean e;
        public final boolean f;

        public a(Consumer<EncodedImage> consumer, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKey cacheKey, boolean z, boolean z2) {
            super(consumer);
            this.c = memoryCache;
            this.d = cacheKey;
            this.e = z;
            this.f = z2;
        }

        /* JADX INFO: finally extract failed */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            EncodedImage encodedImage = (EncodedImage) obj;
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("EncodedMemoryCacheProducer#onNewResultImpl");
                }
                if (!BaseConsumer.isNotLast(i) && encodedImage != null && !BaseConsumer.statusHasAnyFlag(i, 10)) {
                    if (encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
                        if (byteBufferRef != null) {
                            CloseableReference<PooledByteBuffer> closeableReference = null;
                            try {
                                if (this.f && this.e) {
                                    closeableReference = this.c.cache(this.d, byteBufferRef);
                                }
                                if (closeableReference != null) {
                                    try {
                                        EncodedImage encodedImage2 = new EncodedImage(closeableReference);
                                        encodedImage2.copyMetaDataFrom(encodedImage);
                                        try {
                                            getConsumer().onProgressUpdate(1.0f);
                                            getConsumer().onNewResult(encodedImage2, i);
                                            EncodedImage.closeSafely(encodedImage2);
                                            if (!FrescoSystrace.isTracing()) {
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            EncodedImage.closeSafely(encodedImage2);
                                            throw th;
                                        }
                                    } finally {
                                        CloseableReference.closeSafely(closeableReference);
                                    }
                                }
                            } finally {
                                CloseableReference.closeSafely(byteBufferRef);
                            }
                        }
                        getConsumer().onNewResult(encodedImage, i);
                        if (!FrescoSystrace.isTracing()) {
                            return;
                        }
                    }
                }
                getConsumer().onNewResult(encodedImage, i);
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.a = memoryCache;
        this.b = cacheKeyFactory;
        this.c = producer;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("EncodedMemoryCacheProducer#produceResults");
            }
            ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext, PRODUCER_NAME);
            CacheKey encodedCacheKey = this.b.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
            CloseableReference<PooledByteBuffer> closeableReference = this.a.get(encodedCacheKey);
            Map<String, String> map = null;
            if (closeableReference != null) {
                try {
                    EncodedImage encodedImage = new EncodedImage(closeableReference);
                    try {
                        if (producerListener.requiresExtraMap(producerContext, PRODUCER_NAME)) {
                            map = ImmutableMap.of("cached_value_found", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                        }
                        producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, map);
                        producerListener.onUltimateProducerReached(producerContext, PRODUCER_NAME, true);
                        producerContext.putOriginExtra("memory_encoded");
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(encodedImage, 1);
                        EncodedImage.closeSafely(encodedImage);
                        CloseableReference.closeSafely(closeableReference);
                    } catch (Throwable th) {
                        EncodedImage.closeSafely(encodedImage);
                        throw th;
                    }
                } catch (Throwable th2) {
                    CloseableReference.closeSafely(closeableReference);
                    throw th2;
                }
            } else if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, producerListener.requiresExtraMap(producerContext, PRODUCER_NAME) ? ImmutableMap.of("cached_value_found", "false") : null);
                producerListener.onUltimateProducerReached(producerContext, PRODUCER_NAME, false);
                producerContext.putOriginExtra("memory_encoded", "nil-result");
                consumer.onNewResult(null, 1);
                CloseableReference.closeSafely(closeableReference);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } else {
                a aVar = new a(consumer, this.a, encodedCacheKey, producerContext.getImageRequest().isMemoryCacheEnabled(), producerContext.getImagePipelineConfig().getExperiments().isEncodedCacheEnabled());
                if (producerListener.requiresExtraMap(producerContext, PRODUCER_NAME)) {
                    map = ImmutableMap.of("cached_value_found", "false");
                }
                producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, map);
                this.c.produceResults(aVar, producerContext);
                CloseableReference.closeSafely(closeableReference);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }
}
