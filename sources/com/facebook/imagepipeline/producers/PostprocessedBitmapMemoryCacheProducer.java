package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.internal.ServerProtocol;
import java.util.Map;
public class PostprocessedBitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String PRODUCER_NAME = "PostprocessedBitmapMemoryCacheProducer";
    public final MemoryCache<CacheKey, CloseableImage> a;
    public final CacheKeyFactory b;
    public final Producer<CloseableReference<CloseableImage>> c;

    public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final CacheKey c;
        public final boolean d;
        public final MemoryCache<CacheKey, CloseableImage> e;
        public final boolean f;

        public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z, MemoryCache<CacheKey, CloseableImage> memoryCache, boolean z2) {
            super(consumer);
            this.c = cacheKey;
            this.d = z;
            this.e = memoryCache;
            this.f = z2;
        }

        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            CloseableReference<CloseableImage> closeableReference2 = null;
            if (closeableReference == null) {
                if (BaseConsumer.isLast(i)) {
                    getConsumer().onNewResult(null, i);
                }
            } else if (!BaseConsumer.isNotLast(i) || this.d) {
                if (this.f) {
                    closeableReference2 = this.e.cache(this.c, closeableReference);
                }
                try {
                    getConsumer().onProgressUpdate(1.0f);
                    Consumer consumer = getConsumer();
                    if (closeableReference2 != null) {
                        closeableReference = closeableReference2;
                    }
                    consumer.onNewResult(closeableReference, i);
                } finally {
                    CloseableReference.closeSafely(closeableReference2);
                }
            }
        }
    }

    public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.a = memoryCache;
        this.b = cacheKeyFactory;
        this.c = producer;
    }

    public String getProducerName() {
        return PRODUCER_NAME;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        ProducerListener2 producerListener = producerContext.getProducerListener();
        ImageRequest imageRequest = producerContext.getImageRequest();
        Object callerContext = producerContext.getCallerContext();
        Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor == null || postprocessor.getPostprocessorCacheKey() == null) {
            this.c.produceResults(consumer, producerContext);
            return;
        }
        producerListener.onProducerStart(producerContext, getProducerName());
        CacheKey postprocessedBitmapCacheKey = this.b.getPostprocessedBitmapCacheKey(imageRequest, callerContext);
        CloseableReference<CloseableImage> closeableReference = this.a.get(postprocessedBitmapCacheKey);
        Map<String, String> map = null;
        if (closeableReference != null) {
            String producerName = getProducerName();
            if (producerListener.requiresExtraMap(producerContext, getProducerName())) {
                map = ImmutableMap.of("cached_value_found", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            producerListener.onProducerFinishWithSuccess(producerContext, producerName, map);
            producerListener.onUltimateProducerReached(producerContext, PRODUCER_NAME, true);
            producerContext.putOriginExtra("memory_bitmap", "postprocessed");
            consumer.onProgressUpdate(1.0f);
            consumer.onNewResult(closeableReference, 1);
            closeableReference.close();
            return;
        }
        CachedPostprocessorConsumer cachedPostprocessorConsumer = new CachedPostprocessorConsumer(consumer, postprocessedBitmapCacheKey, postprocessor instanceof RepeatedPostprocessor, this.a, producerContext.getImageRequest().isMemoryCacheEnabled());
        String producerName2 = getProducerName();
        if (producerListener.requiresExtraMap(producerContext, getProducerName())) {
            map = ImmutableMap.of("cached_value_found", "false");
        }
        producerListener.onProducerFinishWithSuccess(producerContext, producerName2, map);
        this.c.produceResults(cachedPostprocessorConsumer, producerContext);
    }
}
