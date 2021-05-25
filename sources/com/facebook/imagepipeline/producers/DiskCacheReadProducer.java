package com.facebook.imagepipeline.producers;

import a2.g.p.e.a;
import a2.g.p.e.b;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
public class DiskCacheReadProducer implements Producer<EncodedImage> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "DiskCacheProducer";
    public final BufferedDiskCache a;
    public final BufferedDiskCache b;
    public final CacheKeyFactory c;
    public final Producer<EncodedImage> d;

    public DiskCacheReadProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.a = bufferedDiskCache;
        this.b = bufferedDiskCache2;
        this.c = cacheKeyFactory;
        this.d = producer;
    }

    @VisibleForTesting
    @Nullable
    public static Map<String, String> a(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z, int i) {
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
        boolean z = true;
        if (imageRequest.isDiskCacheEnabled()) {
            producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
            CacheKey encodedCacheKey = this.c.getEncodedCacheKey(imageRequest, producerContext.getCallerContext());
            if (imageRequest.getCacheChoice() != ImageRequest.CacheChoice.SMALL) {
                z = false;
            }
            BufferedDiskCache bufferedDiskCache = z ? this.b : this.a;
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bufferedDiskCache.get(encodedCacheKey, atomicBoolean).continueWith(new a(this, producerContext.getProducerListener(), producerContext, consumer));
            producerContext.addCallbacks(new b(this, atomicBoolean));
        } else if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            producerContext.putOriginExtra("disk", "nil-result_read");
            consumer.onNewResult(null, 1);
        } else {
            this.d.produceResults(consumer, producerContext);
        }
    }
}
