package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
public class EncodedProbeProducer implements Producer<EncodedImage> {
    public static final String PRODUCER_NAME = "EncodedProbeProducer";
    public final BufferedDiskCache a;
    public final BufferedDiskCache b;
    public final CacheKeyFactory c;
    public final Producer<EncodedImage> d;
    public final BoundedLinkedHashSet<CacheKey> e;
    public final BoundedLinkedHashSet<CacheKey> f;

    public static class a extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final ProducerContext c;
        public final BufferedDiskCache d;
        public final BufferedDiskCache e;
        public final CacheKeyFactory f;
        public final BoundedLinkedHashSet<CacheKey> g;
        public final BoundedLinkedHashSet<CacheKey> h;

        public a(Consumer<EncodedImage> consumer, ProducerContext producerContext, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2) {
            super(consumer);
            this.c = producerContext;
            this.d = bufferedDiskCache;
            this.e = bufferedDiskCache2;
            this.f = cacheKeyFactory;
            this.g = boundedLinkedHashSet;
            this.h = boundedLinkedHashSet2;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            EncodedImage encodedImage = (EncodedImage) obj;
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("EncodedProbeProducer#onNewResultImpl");
                }
                if (!BaseConsumer.isNotLast(i) && encodedImage != null && !BaseConsumer.statusHasAnyFlag(i, 10)) {
                    if (encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                        ImageRequest imageRequest = this.c.getImageRequest();
                        CacheKey encodedCacheKey = this.f.getEncodedCacheKey(imageRequest, this.c.getCallerContext());
                        this.g.add(encodedCacheKey);
                        if (this.c.getExtra("origin").equals("memory_encoded")) {
                            if (!this.h.contains(encodedCacheKey)) {
                                (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL ? this.e : this.d).addKeyForAsyncProbing(encodedCacheKey);
                                this.h.add(encodedCacheKey);
                            }
                        } else if (this.c.getExtra("origin").equals("disk")) {
                            this.h.add(encodedCacheKey);
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

    public EncodedProbeProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet boundedLinkedHashSet, BoundedLinkedHashSet boundedLinkedHashSet2, Producer<EncodedImage> producer) {
        this.a = bufferedDiskCache;
        this.b = bufferedDiskCache2;
        this.c = cacheKeyFactory;
        this.e = boundedLinkedHashSet;
        this.f = boundedLinkedHashSet2;
        this.d = producer;
    }

    public String getProducerName() {
        return PRODUCER_NAME;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("EncodedProbeProducer#produceResults");
            }
            ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext, getProducerName());
            a aVar = new a(consumer, producerContext, this.a, this.b, this.c, this.e, this.f);
            producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, null);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("mInputProducer.produceResult");
            }
            this.d.produceResults(aVar, producerContext);
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
