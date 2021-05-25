package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
public class BitmapProbeProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String PRODUCER_NAME = "BitmapProbeProducer";
    public final MemoryCache<CacheKey, PooledByteBuffer> a;
    public final BufferedDiskCache b;
    public final BufferedDiskCache c;
    public final CacheKeyFactory d;
    public final Producer<CloseableReference<CloseableImage>> e;
    public final BoundedLinkedHashSet<CacheKey> f;
    public final BoundedLinkedHashSet<CacheKey> g;

    public static class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final ProducerContext c;
        public final MemoryCache<CacheKey, PooledByteBuffer> d;
        public final BufferedDiskCache e;
        public final BufferedDiskCache f;
        public final CacheKeyFactory g;
        public final BoundedLinkedHashSet<CacheKey> h;
        public final BoundedLinkedHashSet<CacheKey> i;

        public a(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2) {
            super(consumer);
            this.c = producerContext;
            this.d = memoryCache;
            this.e = bufferedDiskCache;
            this.f = bufferedDiskCache2;
            this.g = cacheKeyFactory;
            this.h = boundedLinkedHashSet;
            this.i = boundedLinkedHashSet2;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i2) {
            CloseableReference closeableReference = (CloseableReference) obj;
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("BitmapProbeProducer#onNewResultImpl");
                }
                if (!BaseConsumer.isNotLast(i2) && closeableReference != null) {
                    if (!BaseConsumer.statusHasAnyFlag(i2, 8)) {
                        ImageRequest imageRequest = this.c.getImageRequest();
                        CacheKey encodedCacheKey = this.g.getEncodedCacheKey(imageRequest, this.c.getCallerContext());
                        if (this.c.getExtra("origin").equals("memory_bitmap")) {
                            if (this.c.getImagePipelineConfig().getExperiments().isEncodedMemoryCacheProbingEnabled() && !this.h.contains(encodedCacheKey)) {
                                this.d.probe(encodedCacheKey);
                                this.h.add(encodedCacheKey);
                            }
                            if (this.c.getImagePipelineConfig().getExperiments().isDiskCacheProbingEnabled() && !this.i.contains(encodedCacheKey)) {
                                (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL ? this.f : this.e).addKeyForAsyncProbing(encodedCacheKey);
                                this.i.add(encodedCacheKey);
                            }
                        }
                        getConsumer().onNewResult(closeableReference, i2);
                        if (!FrescoSystrace.isTracing()) {
                            return;
                        }
                    }
                }
                getConsumer().onNewResult(closeableReference, i2);
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }

    public BitmapProbeProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2, Producer<CloseableReference<CloseableImage>> producer) {
        this.a = memoryCache;
        this.b = bufferedDiskCache;
        this.c = bufferedDiskCache2;
        this.d = cacheKeyFactory;
        this.f = boundedLinkedHashSet;
        this.g = boundedLinkedHashSet2;
        this.e = producer;
    }

    public String getProducerName() {
        return PRODUCER_NAME;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BitmapProbeProducer#produceResults");
            }
            ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext, getProducerName());
            a aVar = new a(consumer, producerContext, this.a, this.b, this.c, this.d, this.f, this.g);
            producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, null);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("mInputProducer.produceResult");
            }
            this.e.produceResults(aVar, producerContext);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }
}
