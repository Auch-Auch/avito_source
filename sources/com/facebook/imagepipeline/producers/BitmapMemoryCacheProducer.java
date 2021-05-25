package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.internal.ServerProtocol;
import java.util.Map;
public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
    public final MemoryCache<CacheKey, CloseableImage> a;
    public final CacheKeyFactory b;
    public final Producer<CloseableReference<CloseableImage>> c;

    public class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final /* synthetic */ CacheKey c;
        public final /* synthetic */ boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, CacheKey cacheKey, boolean z) {
            super(consumer);
            this.c = cacheKey;
            this.d = z;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            CloseableReference<CloseableImage> closeableReference;
            CloseableReference<CloseableImage> closeableReference2 = (CloseableReference) obj;
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("BitmapMemoryCacheProducer#onNewResultImpl");
                }
                boolean isLast = BaseConsumer.isLast(i);
                CloseableReference<CloseableImage> closeableReference3 = null;
                if (closeableReference2 == null) {
                    if (isLast) {
                        getConsumer().onNewResult(null, i);
                    }
                } else if (closeableReference2.get().isStateful() || BaseConsumer.statusHasFlag(i, 8)) {
                    getConsumer().onNewResult(closeableReference2, i);
                    if (!FrescoSystrace.isTracing()) {
                    }
                } else {
                    if (!isLast && (closeableReference = BitmapMemoryCacheProducer.this.a.get(this.c)) != null) {
                        try {
                            QualityInfo qualityInfo = closeableReference2.get().getQualityInfo();
                            QualityInfo qualityInfo2 = closeableReference.get().getQualityInfo();
                            if (qualityInfo2.isOfFullQuality() || qualityInfo2.getQuality() >= qualityInfo.getQuality()) {
                                getConsumer().onNewResult(closeableReference, i);
                                CloseableReference.closeSafely(closeableReference);
                                if (!FrescoSystrace.isTracing()) {
                                    return;
                                }
                            }
                        } finally {
                            CloseableReference.closeSafely(closeableReference);
                        }
                    }
                    if (this.d) {
                        closeableReference3 = BitmapMemoryCacheProducer.this.a.cache(this.c, closeableReference2);
                    }
                    if (isLast) {
                        try {
                            getConsumer().onProgressUpdate(1.0f);
                        } catch (Throwable th) {
                            CloseableReference.closeSafely(closeableReference3);
                            throw th;
                        }
                    }
                    Consumer consumer = getConsumer();
                    if (closeableReference3 != null) {
                        closeableReference2 = closeableReference3;
                    }
                    consumer.onNewResult(closeableReference2, i);
                    CloseableReference.closeSafely(closeableReference3);
                    if (!FrescoSystrace.isTracing()) {
                    }
                }
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.a = memoryCache;
        this.b = cacheKeyFactory;
        this.c = producer;
    }

    public String getOriginSubcategory() {
        return "pipe_bg";
    }

    public String getProducerName() {
        return PRODUCER_NAME;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        boolean isTracing;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BitmapMemoryCacheProducer#produceResults");
            }
            ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext, getProducerName());
            CacheKey bitmapCacheKey = this.b.getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
            CloseableReference<CloseableImage> closeableReference = this.a.get(bitmapCacheKey);
            Map<String, String> map = null;
            if (closeableReference != null) {
                producerContext.putExtras(closeableReference.get().getExtras());
                boolean isOfFullQuality = closeableReference.get().getQualityInfo().isOfFullQuality();
                if (isOfFullQuality) {
                    producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? ImmutableMap.of("cached_value_found", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) : null);
                    producerListener.onUltimateProducerReached(producerContext, getProducerName(), true);
                    producerContext.putOriginExtra("memory_bitmap", getOriginSubcategory());
                    consumer.onProgressUpdate(1.0f);
                }
                consumer.onNewResult(closeableReference, BaseConsumer.simpleStatusForIsLast(isOfFullQuality));
                closeableReference.close();
                if (isOfFullQuality) {
                    if (!isTracing) {
                        return;
                    }
                    return;
                }
            }
            if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
                producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? ImmutableMap.of("cached_value_found", "false") : null);
                producerListener.onUltimateProducerReached(producerContext, getProducerName(), false);
                producerContext.putOriginExtra("memory_bitmap", getOriginSubcategory());
                consumer.onNewResult(null, 1);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                    return;
                }
                return;
            }
            Consumer<CloseableReference<CloseableImage>> wrapConsumer = wrapConsumer(consumer, bitmapCacheKey, producerContext.getImageRequest().isMemoryCacheEnabled());
            String producerName = getProducerName();
            if (producerListener.requiresExtraMap(producerContext, getProducerName())) {
                map = ImmutableMap.of("cached_value_found", "false");
            }
            producerListener.onProducerFinishWithSuccess(producerContext, producerName, map);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("mInputProducer.produceResult");
            }
            this.c.produceResults(wrapConsumer, producerContext);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z) {
        return new a(consumer, cacheKey, z);
    }
}
