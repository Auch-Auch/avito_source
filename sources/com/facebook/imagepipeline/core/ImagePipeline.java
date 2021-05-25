package com.facebook.imagepipeline.core;

import android.net.Uri;
import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener2;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.share.internal.ShareConstants;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public class ImagePipeline {
    public static final CancellationException p = new CancellationException("Prefetching is not enabled");
    public final ProducerSequenceFactory a;
    public final RequestListener b;
    public final RequestListener2 c;
    public final Supplier<Boolean> d;
    public final MemoryCache<CacheKey, CloseableImage> e;
    public final MemoryCache<CacheKey, PooledByteBuffer> f;
    public final BufferedDiskCache g;
    public final BufferedDiskCache h;
    public final CacheKeyFactory i;
    public final ThreadHandoffProducerQueue j;
    public final Supplier<Boolean> k;
    public AtomicLong l = new AtomicLong();
    public final Supplier<Boolean> m;
    @Nullable
    public final CallerContextVerifier n;
    public final ImagePipelineConfig o;

    public class a implements Supplier<DataSource<CloseableReference<CloseableImage>>> {
        public final /* synthetic */ ImageRequest a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ ImageRequest.RequestLevel c;

        public a(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
            this.a = imageRequest;
            this.b = obj;
            this.c = requestLevel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.facebook.common.internal.Supplier
        public DataSource<CloseableReference<CloseableImage>> get() {
            return ImagePipeline.this.fetchDecodedImage(this.a, this.b, this.c);
        }

        public String toString() {
            return Objects.toStringHelper(this).add(ShareConstants.MEDIA_URI, this.a.getSourceUri()).toString();
        }
    }

    public class b implements Supplier<DataSource<CloseableReference<CloseableImage>>> {
        public final /* synthetic */ ImageRequest a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ ImageRequest.RequestLevel c;
        public final /* synthetic */ RequestListener d;

        public b(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, RequestListener requestListener) {
            this.a = imageRequest;
            this.b = obj;
            this.c = requestLevel;
            this.d = requestListener;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.facebook.common.internal.Supplier
        public DataSource<CloseableReference<CloseableImage>> get() {
            return ImagePipeline.this.fetchDecodedImage(this.a, this.b, this.c, this.d);
        }

        public String toString() {
            return Objects.toStringHelper(this).add(ShareConstants.MEDIA_URI, this.a.getSourceUri()).toString();
        }
    }

    public class c implements Supplier<DataSource<CloseableReference<CloseableImage>>> {
        public final /* synthetic */ ImageRequest a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ ImageRequest.RequestLevel c;
        public final /* synthetic */ RequestListener d;
        public final /* synthetic */ String e;

        public c(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, RequestListener requestListener, String str) {
            this.a = imageRequest;
            this.b = obj;
            this.c = requestLevel;
            this.d = requestListener;
            this.e = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.facebook.common.internal.Supplier
        public DataSource<CloseableReference<CloseableImage>> get() {
            return ImagePipeline.this.fetchDecodedImage(this.a, this.b, this.c, this.d, this.e);
        }

        public String toString() {
            return Objects.toStringHelper(this).add(ShareConstants.MEDIA_URI, this.a.getSourceUri()).toString();
        }
    }

    public class d implements Supplier<DataSource<CloseableReference<PooledByteBuffer>>> {
        public final /* synthetic */ ImageRequest a;
        public final /* synthetic */ Object b;

        public d(ImageRequest imageRequest, Object obj) {
            this.a = imageRequest;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.facebook.common.internal.Supplier
        public DataSource<CloseableReference<PooledByteBuffer>> get() {
            return ImagePipeline.this.fetchEncodedImage(this.a, this.b);
        }

        public String toString() {
            return Objects.toStringHelper(this).add(ShareConstants.MEDIA_URI, this.a.getSourceUri()).toString();
        }
    }

    public class e implements Predicate<CacheKey> {
        public e(ImagePipeline imagePipeline) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.common.internal.Predicate
        public /* bridge */ /* synthetic */ boolean apply(CacheKey cacheKey) {
            return true;
        }
    }

    public class f implements Continuation<Boolean, Void> {
        public final /* synthetic */ SimpleDataSource a;

        public f(ImagePipeline imagePipeline, SimpleDataSource simpleDataSource) {
            this.a = simpleDataSource;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
        @Override // bolts.Continuation
        public Void then(Task<Boolean> task) throws Exception {
            this.a.setResult(Boolean.valueOf(!task.isCancelled() && !task.isFaulted() && task.getResult().booleanValue()));
            return null;
        }
    }

    public class g implements Continuation<Boolean, Task<Boolean>> {
        public final /* synthetic */ CacheKey a;

        public g(CacheKey cacheKey) {
            this.a = cacheKey;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
        @Override // bolts.Continuation
        public Task<Boolean> then(Task<Boolean> task) throws Exception {
            if (task.isCancelled() || task.isFaulted() || !task.getResult().booleanValue()) {
                return ImagePipeline.this.h.contains(this.a);
            }
            return Task.forResult(Boolean.TRUE);
        }
    }

    public ImagePipeline(ProducerSequenceFactory producerSequenceFactory, Set<RequestListener> set, Set<RequestListener2> set2, Supplier<Boolean> supplier, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, Supplier<Boolean> supplier2, Supplier<Boolean> supplier3, @Nullable CallerContextVerifier callerContextVerifier, ImagePipelineConfig imagePipelineConfig) {
        this.a = producerSequenceFactory;
        this.b = new ForwardingRequestListener(set);
        this.c = new ForwardingRequestListener2(set2);
        this.d = supplier;
        this.e = memoryCache;
        this.f = memoryCache2;
        this.g = bufferedDiskCache;
        this.h = bufferedDiskCache2;
        this.i = cacheKeyFactory;
        this.j = threadHandoffProducerQueue;
        this.k = supplier2;
        this.m = supplier3;
        this.n = callerContextVerifier;
        this.o = imagePipelineConfig;
    }

    public final DataSource<Void> a(ImageRequest imageRequest, Object obj, Priority priority) {
        boolean z;
        Producer<Void> producer;
        if (!this.d.get().booleanValue()) {
            return DataSources.immediateFailedDataSource(p);
        }
        try {
            Boolean shouldDecodePrefetches = imageRequest.shouldDecodePrefetches();
            if (shouldDecodePrefetches != null) {
                z = !shouldDecodePrefetches.booleanValue();
            } else {
                z = this.k.get().booleanValue();
            }
            if (z) {
                producer = this.a.getEncodedImagePrefetchProducerSequence(imageRequest);
            } else {
                producer = this.a.getDecodedImagePrefetchProducerSequence(imageRequest);
            }
            return c(producer, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e2) {
            return DataSources.immediateFailedDataSource(e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> b(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<T>> r15, com.facebook.imagepipeline.request.ImageRequest r16, com.facebook.imagepipeline.request.ImageRequest.RequestLevel r17, java.lang.Object r18, @javax.annotation.Nullable com.facebook.imagepipeline.listener.RequestListener r19, @javax.annotation.Nullable java.lang.String r20) {
        /*
            r14 = this;
            r1 = r14
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "ImagePipeline#submitFetchRequest"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r0)
        L_0x000c:
            com.facebook.imagepipeline.producers.InternalRequestListener r0 = new com.facebook.imagepipeline.producers.InternalRequestListener
            r3 = r16
            r2 = r19
            com.facebook.imagepipeline.listener.RequestListener r2 = r14.getRequestListenerForRequest(r3, r2)
            com.facebook.imagepipeline.listener.RequestListener2 r4 = r1.c
            r0.<init>(r2, r4)
            com.facebook.callercontext.CallerContextVerifier r2 = r1.n
            r4 = 0
            r7 = r18
            if (r2 == 0) goto L_0x0025
            r2.verifyCallerContext(r7, r4)
        L_0x0025:
            com.facebook.imagepipeline.request.ImageRequest$RequestLevel r2 = r16.getLowestPermittedRequestLevel()     // Catch:{ Exception -> 0x006e }
            r5 = r17
            com.facebook.imagepipeline.request.ImageRequest$RequestLevel r8 = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.getMax(r2, r5)     // Catch:{ Exception -> 0x006e }
            com.facebook.imagepipeline.producers.SettableProducerContext r13 = new com.facebook.imagepipeline.producers.SettableProducerContext     // Catch:{ Exception -> 0x006e }
            java.lang.String r5 = r14.generateUniqueFutureId()     // Catch:{ Exception -> 0x006e }
            r9 = 0
            boolean r2 = r16.getProgressiveRenderingEnabled()     // Catch:{ Exception -> 0x006e }
            if (r2 != 0) goto L_0x0049
            android.net.Uri r2 = r16.getSourceUri()     // Catch:{ Exception -> 0x006e }
            boolean r2 = com.facebook.common.util.UriUtil.isNetworkUri(r2)     // Catch:{ Exception -> 0x006e }
            if (r2 != 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r10 = 0
            goto L_0x004b
        L_0x0049:
            r2 = 1
            r10 = 1
        L_0x004b:
            com.facebook.imagepipeline.common.Priority r11 = r16.getPriority()     // Catch:{ Exception -> 0x006e }
            com.facebook.imagepipeline.core.ImagePipelineConfig r12 = r1.o     // Catch:{ Exception -> 0x006e }
            r2 = r13
            r3 = r16
            r4 = r5
            r5 = r20
            r6 = r0
            r7 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x006e }
            r2 = r15
            com.facebook.datasource.DataSource r0 = com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter.create(r15, r13, r0)     // Catch:{ Exception -> 0x006e }
            boolean r2 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r2 == 0) goto L_0x006b
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x006b:
            return r0
        L_0x006c:
            r0 = move-exception
            goto L_0x007d
        L_0x006e:
            r0 = move-exception
            com.facebook.datasource.DataSource r0 = com.facebook.datasource.DataSources.immediateFailedDataSource(r0)     // Catch:{ all -> 0x006c }
            boolean r2 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r2 == 0) goto L_0x007c
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x007c:
            return r0
        L_0x007d:
            boolean r2 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r2 == 0) goto L_0x0086
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0086:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ImagePipeline.b(com.facebook.imagepipeline.producers.Producer, com.facebook.imagepipeline.request.ImageRequest, com.facebook.imagepipeline.request.ImageRequest$RequestLevel, java.lang.Object, com.facebook.imagepipeline.listener.RequestListener, java.lang.String):com.facebook.datasource.DataSource");
    }

    public final DataSource<Void> c(Producer<Void> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        InternalRequestListener internalRequestListener = new InternalRequestListener(getRequestListenerForRequest(imageRequest, null), this.c);
        CallerContextVerifier callerContextVerifier = this.n;
        if (callerContextVerifier != null) {
            callerContextVerifier.verifyCallerContext(obj, true);
        }
        try {
            return ProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId(), internalRequestListener, obj, ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel), true, false, priority, this.o), internalRequestListener);
        } catch (Exception e2) {
            return DataSources.immediateFailedDataSource(e2);
        }
    }

    public void clearCaches() {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public void clearDiskCaches() {
        this.g.clearAll();
        this.h.clearAll();
    }

    public void clearMemoryCaches() {
        e eVar = new e(this);
        this.e.removeAll(eVar);
        this.f.removeAll(eVar);
    }

    public void evictFromCache(Uri uri) {
        evictFromMemoryCache(uri);
        evictFromDiskCache(uri);
    }

    public void evictFromDiskCache(Uri uri) {
        evictFromDiskCache(ImageRequest.fromUri(uri));
    }

    public void evictFromMemoryCache(Uri uri) {
        a2.g.p.b.a aVar = new a2.g.p.b.a(this, uri);
        this.e.removeAll(aVar);
        this.f.removeAll(aVar);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj) {
        return fetchEncodedImage(imageRequest, obj, null);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public String generateUniqueFutureId() {
        return String.valueOf(this.l.getAndIncrement());
    }

    public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        return this.e;
    }

    @Nullable
    public CacheKey getCacheKey(@Nullable ImageRequest imageRequest, @Nullable Object obj) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipeline#getCacheKey");
        }
        CacheKeyFactory cacheKeyFactory = this.i;
        CacheKey cacheKey = null;
        if (!(cacheKeyFactory == null || imageRequest == null)) {
            cacheKey = imageRequest.getPostprocessor() != null ? cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, obj) : cacheKeyFactory.getBitmapCacheKey(imageRequest, obj);
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return cacheKey;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.i;
    }

    @Nullable
    public CloseableReference<CloseableImage> getCachedImage(@Nullable CacheKey cacheKey) {
        MemoryCache<CacheKey, CloseableImage> memoryCache = this.e;
        if (memoryCache == null || cacheKey == null) {
            return null;
        }
        CloseableReference<CloseableImage> closeableReference = memoryCache.get(cacheKey);
        if (closeableReference == null || closeableReference.get().getQualityInfo().isOfFullQuality()) {
            return closeableReference;
        }
        closeableReference.close();
        return null;
    }

    public RequestListener getCombinedRequestListener(@Nullable RequestListener requestListener) {
        if (requestListener == null) {
            return this.b;
        }
        return new ForwardingRequestListener(this.b, requestListener);
    }

    public ImagePipelineConfig getConfig() {
        return this.o;
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        return new a(imageRequest, obj, requestLevel);
    }

    public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(ImageRequest imageRequest, Object obj) {
        return new d(imageRequest, obj);
    }

    public ProducerSequenceFactory getProducerSequenceFactory() {
        return this.a;
    }

    public RequestListener getRequestListenerForRequest(ImageRequest imageRequest, @Nullable RequestListener requestListener) {
        if (requestListener == null) {
            if (imageRequest.getRequestListener() == null) {
                return this.b;
            }
            return new ForwardingRequestListener(this.b, imageRequest.getRequestListener());
        } else if (imageRequest.getRequestListener() == null) {
            return new ForwardingRequestListener(this.b, requestListener);
        } else {
            return new ForwardingRequestListener(this.b, requestListener, imageRequest.getRequestListener());
        }
    }

    public long getUsedDiskCacheSize() {
        return this.h.getSize() + this.g.getSize();
    }

    public boolean hasCachedImage(@Nullable CacheKey cacheKey) {
        MemoryCache<CacheKey, CloseableImage> memoryCache = this.e;
        if (memoryCache == null || cacheKey == null) {
            return false;
        }
        return memoryCache.contains((MemoryCache<CacheKey, CloseableImage>) cacheKey);
    }

    public boolean isInBitmapMemoryCache(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        CloseableReference<CloseableImage> closeableReference = this.e.get(this.i.getBitmapCacheKey(imageRequest, null));
        try {
            return CloseableReference.isValid(closeableReference);
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public DataSource<Boolean> isInDiskCache(Uri uri) {
        return isInDiskCache(ImageRequest.fromUri(uri));
    }

    public boolean isInDiskCacheSync(Uri uri) {
        return isInDiskCacheSync(uri, ImageRequest.CacheChoice.SMALL) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DEFAULT);
    }

    public Supplier<Boolean> isLazyDataSource() {
        return this.m;
    }

    public boolean isPaused() {
        return this.j.isQueueing();
    }

    public void pause() {
        this.j.startQueueing();
    }

    public DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, Priority.MEDIUM);
    }

    @Deprecated
    public DataSource<Void> prefetchToBitmapCacheWithHighPriority(ImageRequest imageRequest, Object obj) {
        return a(imageRequest, obj, Priority.HIGH);
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj) {
        return prefetchToDiskCache(imageRequest, obj, Priority.MEDIUM);
    }

    public DataSource<Void> prefetchToEncodedCache(ImageRequest imageRequest, Object obj) {
        return prefetchToEncodedCache(imageRequest, obj, Priority.MEDIUM);
    }

    public void resume() {
        this.j.stopQueuing();
    }

    public <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        }
        try {
            DataSource<CloseableReference<T>> create = CloseableProducerToDataSourceAdapter.create(producer, settableProducerContext, new InternalRequestListener(requestListener, this.c));
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return create;
        } catch (Exception e2) {
            DataSource<CloseableReference<T>> immediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return immediateFailedDataSource;
        } catch (Throwable th) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    public void evictFromDiskCache(ImageRequest imageRequest) {
        CacheKey encodedCacheKey = this.i.getEncodedCacheKey(imageRequest, null);
        this.g.remove(encodedCacheKey);
        this.h.remove(encodedCacheKey);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, @Nullable RequestListener requestListener) {
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH, requestListener);
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj, @Nullable RequestListener requestListener) {
        Preconditions.checkNotNull(imageRequest.getSourceUri());
        try {
            Producer<CloseableReference<PooledByteBuffer>> encodedImageProducerSequence = this.a.getEncodedImageProducerSequence(imageRequest);
            if (imageRequest.getResizeOptions() != null) {
                imageRequest = ImageRequestBuilder.fromRequest(imageRequest).setResizeOptions(null).build();
            }
            return b(encodedImageProducerSequence, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, requestListener, null);
        } catch (Exception e2) {
            return DataSources.immediateFailedDataSource(e2);
        }
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable RequestListener requestListener) {
        return new b(imageRequest, obj, requestLevel, requestListener);
    }

    public DataSource<Boolean> isInDiskCache(ImageRequest imageRequest) {
        CacheKey encodedCacheKey = this.i.getEncodedCacheKey(imageRequest, null);
        SimpleDataSource create = SimpleDataSource.create();
        this.g.contains(encodedCacheKey).continueWithTask(new g(encodedCacheKey)).continueWith(new f(this, create));
        return create;
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.d.get().booleanValue()) {
            return DataSources.immediateFailedDataSource(p);
        }
        try {
            return c(this.a.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e2) {
            return DataSources.immediateFailedDataSource(e2);
        }
    }

    public DataSource<Void> prefetchToEncodedCache(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.d.get().booleanValue()) {
            return DataSources.immediateFailedDataSource(p);
        }
        try {
            return c(this.a.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e2) {
            return DataSources.immediateFailedDataSource(e2);
        }
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        return fetchDecodedImage(imageRequest, obj, requestLevel, null);
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable RequestListener requestListener, @Nullable String str) {
        return new c(imageRequest, obj, requestLevel, requestListener, str);
    }

    public boolean isInDiskCacheSync(Uri uri, ImageRequest.CacheChoice cacheChoice) {
        return isInDiskCacheSync(ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice(cacheChoice).build());
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable RequestListener requestListener) {
        return fetchDecodedImage(imageRequest, obj, requestLevel, requestListener, null);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable RequestListener requestListener, @Nullable String str) {
        try {
            return b(this.a.getDecodedImageProducerSequence(imageRequest), imageRequest, requestLevel, obj, requestListener, str);
        } catch (Exception e2) {
            return DataSources.immediateFailedDataSource(e2);
        }
    }

    public boolean isInBitmapMemoryCache(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.e.contains(new a2.g.p.b.a(this, uri));
    }

    public boolean isInDiskCacheSync(ImageRequest imageRequest) {
        CacheKey encodedCacheKey = this.i.getEncodedCacheKey(imageRequest, null);
        int ordinal = imageRequest.getCacheChoice().ordinal();
        if (ordinal == 0) {
            return this.h.diskCheckSync(encodedCacheKey);
        }
        if (ordinal != 1) {
            return false;
        }
        return this.g.diskCheckSync(encodedCacheKey);
    }
}
