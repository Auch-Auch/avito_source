package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
public class DiskCacheWriteProducer implements Producer<EncodedImage> {
    public final BufferedDiskCache a;
    public final BufferedDiskCache b;
    public final CacheKeyFactory c;
    public final Producer<EncodedImage> d;

    public static class b extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final ProducerContext c;
        public final BufferedDiskCache d;
        public final BufferedDiskCache e;
        public final CacheKeyFactory f;

        public b(Consumer consumer, ProducerContext producerContext, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, a aVar) {
            super(consumer);
            this.c = producerContext;
            this.d = bufferedDiskCache;
            this.e = bufferedDiskCache2;
            this.f = cacheKeyFactory;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            EncodedImage encodedImage = (EncodedImage) obj;
            this.c.getProducerListener().onProducerStart(this.c, "DiskCacheWriteProducer");
            if (BaseConsumer.isNotLast(i) || encodedImage == null || BaseConsumer.statusHasAnyFlag(i, 10) || encodedImage.getImageFormat() == ImageFormat.UNKNOWN) {
                this.c.getProducerListener().onProducerFinishWithSuccess(this.c, "DiskCacheWriteProducer", null);
                getConsumer().onNewResult(encodedImage, i);
                return;
            }
            ImageRequest imageRequest = this.c.getImageRequest();
            CacheKey encodedCacheKey = this.f.getEncodedCacheKey(imageRequest, this.c.getCallerContext());
            if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
                this.e.put(encodedCacheKey, encodedImage);
            } else {
                this.d.put(encodedCacheKey, encodedImage);
            }
            this.c.getProducerListener().onProducerFinishWithSuccess(this.c, "DiskCacheWriteProducer", null);
            getConsumer().onNewResult(encodedImage, i);
        }
    }

    public DiskCacheWriteProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.a = bufferedDiskCache;
        this.b = bufferedDiskCache2;
        this.c = cacheKeyFactory;
        this.d = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            producerContext.putOriginExtra("disk", "nil-result_write");
            consumer.onNewResult(null, 1);
            return;
        }
        if (producerContext.getImageRequest().isDiskCacheEnabled()) {
            consumer = new b(consumer, producerContext, this.a, this.b, this.c, null);
        }
        this.d.produceResults(consumer, producerContext);
    }
}
