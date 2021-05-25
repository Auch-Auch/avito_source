package com.facebook.imagepipeline.core;

import a2.b.a.a.a;
import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.HashMap;
import java.util.Map;
public class ProducerSequenceFactory {
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> A;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> B;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> C;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> D;
    @VisibleForTesting
    public Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> E = new HashMap();
    @VisibleForTesting
    public Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> F = new HashMap();
    @VisibleForTesting
    public Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> G = new HashMap();
    public final ContentResolver a;
    public final ProducerFactory b;
    public final NetworkFetcher c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final ThreadHandoffProducerQueue g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final ImageTranscoderFactory k;
    public final boolean l;
    public final boolean m;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> n;
    @VisibleForTesting
    public Producer<EncodedImage> o;
    @VisibleForTesting
    public Producer<EncodedImage> p;
    @VisibleForTesting
    public Producer<EncodedImage> q;
    @VisibleForTesting
    public Producer<CloseableReference<PooledByteBuffer>> r;
    @VisibleForTesting
    public Producer<CloseableReference<PooledByteBuffer>> s;
    @VisibleForTesting
    public Producer<CloseableReference<PooledByteBuffer>> t;
    @VisibleForTesting
    public Producer<Void> u;
    @VisibleForTesting
    public Producer<Void> v;
    public Producer<EncodedImage> w;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> x;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> y;
    @VisibleForTesting
    public Producer<CloseableReference<CloseableImage>> z;

    public ProducerSequenceFactory(ContentResolver contentResolver, ProducerFactory producerFactory, NetworkFetcher networkFetcher, boolean z2, boolean z3, ThreadHandoffProducerQueue threadHandoffProducerQueue, boolean z4, boolean z5, boolean z7, boolean z8, ImageTranscoderFactory imageTranscoderFactory, boolean z9, boolean z10) {
        this.a = contentResolver;
        this.b = producerFactory;
        this.c = networkFetcher;
        this.d = z2;
        this.e = z3;
        this.g = threadHandoffProducerQueue;
        this.h = z4;
        this.i = z5;
        this.f = z7;
        this.j = z8;
        this.k = imageTranscoderFactory;
        this.l = z9;
        this.m = z10;
    }

    public static String k(Uri uri) {
        String valueOf = String.valueOf(uri);
        if (valueOf.length() <= 30) {
            return valueOf;
        }
        return valueOf.substring(0, 30) + "...";
    }

    public static void q(ImageRequest imageRequest) {
        Preconditions.checkNotNull(imageRequest);
        Preconditions.checkArgument(imageRequest.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public final synchronized Producer<EncodedImage> a() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence");
        }
        if (this.p == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence:init");
            }
            this.p = this.b.newBackgroundThreadHandoffProducer(p(this.b.newLocalContentUriFetchProducer()), this.g);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.p;
    }

    public final synchronized Producer<EncodedImage> b() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");
        }
        if (this.o == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence:init");
            }
            this.o = this.b.newBackgroundThreadHandoffProducer(p(this.b.newLocalFileFetchProducer()), this.g);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.o;
    }

    public final synchronized Producer<EncodedImage> c() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence");
        }
        if (this.q == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");
            }
            this.q = this.b.newBackgroundThreadHandoffProducer(f(), this.g);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.q;
    }

    public final Producer<CloseableReference<CloseableImage>> d(ImageRequest imageRequest) {
        Producer<CloseableReference<CloseableImage>> producer;
        Producer<CloseableReference<CloseableImage>> producer2;
        Producer<CloseableReference<CloseableImage>> producer3;
        Producer<CloseableReference<CloseableImage>> producer4;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBasicDecodedImageSequence");
            }
            Preconditions.checkNotNull(imageRequest);
            Uri sourceUri = imageRequest.getSourceUri();
            Preconditions.checkNotNull(sourceUri, "Uri is null.");
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType != 0) {
                switch (sourceUriType) {
                    case 2:
                        Producer<CloseableReference<CloseableImage>> i2 = i();
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return i2;
                    case 3:
                        synchronized (this) {
                            if (this.x == null) {
                                this.x = n(this.b.newLocalFileFetchProducer());
                            }
                            producer = this.x;
                        }
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return producer;
                    case 4:
                        if (MediaUtils.isVideo(this.a.getType(sourceUri))) {
                            Producer<CloseableReference<CloseableImage>> i3 = i();
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return i3;
                        }
                        Producer<CloseableReference<CloseableImage>> h2 = h();
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return h2;
                    case 5:
                        synchronized (this) {
                            if (this.B == null) {
                                this.B = n(this.b.newLocalAssetFetchProducer());
                            }
                            producer2 = this.B;
                        }
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return producer2;
                    case 6:
                        synchronized (this) {
                            if (this.A == null) {
                                this.A = n(this.b.newLocalResourceFetchProducer());
                            }
                            producer3 = this.A;
                        }
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return producer3;
                    case 7:
                        Producer<CloseableReference<CloseableImage>> g2 = g();
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return g2;
                    case 8:
                        synchronized (this) {
                            if (this.D == null) {
                                this.D = n(this.b.newQualifiedResourceFetchProducer());
                            }
                            producer4 = this.D;
                        }
                        return producer4;
                    default:
                        throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + k(sourceUri));
                }
            } else {
                Producer<CloseableReference<CloseableImage>> j2 = j();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return j2;
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public final synchronized Producer<CloseableReference<CloseableImage>> e(Producer<CloseableReference<CloseableImage>> producer) {
        Producer<CloseableReference<CloseableImage>> producer2;
        producer2 = this.G.get(producer);
        if (producer2 == null) {
            producer2 = this.b.newBitmapPrepareProducer(producer);
            this.G.put(producer, producer2);
        }
        return producer2;
    }

    public final synchronized Producer<EncodedImage> f() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");
        }
        if (this.w == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence:init");
            }
            AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer = ProducerFactory.newAddImageTransformMetaDataProducer(p(this.b.newNetworkFetchProducer(this.c)));
            this.w = newAddImageTransformMetaDataProducer;
            this.w = this.b.newResizeAndRotateProducer(newAddImageTransformMetaDataProducer, this.d && !this.h, this.k);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.w;
    }

    public final synchronized Producer<CloseableReference<CloseableImage>> g() {
        if (this.C == null) {
            Producer<EncodedImage> newDataFetchProducer = this.b.newDataFetchProducer();
            if (WebpSupportStatus.sIsWebpSupportRequired && (!this.e || WebpSupportStatus.sWebpBitmapFactory == null)) {
                newDataFetchProducer = this.b.newWebpTranscodeProducer(newDataFetchProducer);
            }
            this.C = m(this.b.newResizeAndRotateProducer(ProducerFactory.newAddImageTransformMetaDataProducer(newDataFetchProducer), true, this.k));
        }
        return this.C;
    }

    public Producer<Void> getDecodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        Producer<Void> producer;
        Producer<CloseableReference<CloseableImage>> d2 = d(imageRequest);
        if (this.i) {
            d2 = e(d2);
        }
        synchronized (this) {
            if (!this.F.containsKey(d2)) {
                this.F.put(d2, ProducerFactory.newSwallowResultProducer(d2));
            }
            producer = this.F.get(d2);
        }
        return producer;
    }

    public Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(ImageRequest imageRequest) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getDecodedImageProducerSequence");
        }
        Producer<CloseableReference<CloseableImage>> d2 = d(imageRequest);
        if (imageRequest.getPostprocessor() != null) {
            synchronized (this) {
                if (!this.E.containsKey(d2)) {
                    this.E.put(d2, this.b.newPostprocessorBitmapMemoryCacheProducer(this.b.newPostprocessorProducer(d2)));
                }
                d2 = this.E.get(d2);
            }
        }
        if (this.i) {
            d2 = e(d2);
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return d2;
    }

    public Producer<Void> getEncodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        Producer<Void> producer;
        Producer<Void> producer2;
        q(imageRequest);
        int sourceUriType = imageRequest.getSourceUriType();
        if (sourceUriType == 0) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");
                }
                if (this.v == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence:init");
                    }
                    this.v = ProducerFactory.newSwallowResultProducer(c());
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                producer = this.v;
            }
            return producer;
        } else if (sourceUriType == 2 || sourceUriType == 3) {
            synchronized (this) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence");
                }
                if (this.u == null) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
                    }
                    this.u = ProducerFactory.newSwallowResultProducer(b());
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                producer2 = this.u;
            }
            return producer2;
        } else {
            Uri sourceUri = imageRequest.getSourceUri();
            StringBuilder L = a.L("Unsupported uri scheme for encoded image fetch! Uri is: ");
            L.append(k(sourceUri));
            throw new IllegalArgumentException(L.toString());
        }
    }

    public Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(ImageRequest imageRequest) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getEncodedImageProducerSequence");
            }
            q(imageRequest);
            Uri sourceUri = imageRequest.getSourceUri();
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType == 0) {
                Producer<CloseableReference<PooledByteBuffer>> networkFetchEncodedImageProducerSequence = getNetworkFetchEncodedImageProducerSequence();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return networkFetchEncodedImageProducerSequence;
            } else if (sourceUriType == 2 || sourceUriType == 3) {
                Producer<CloseableReference<PooledByteBuffer>> localFileFetchEncodedImageProducerSequence = getLocalFileFetchEncodedImageProducerSequence();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return localFileFetchEncodedImageProducerSequence;
            } else if (sourceUriType == 4) {
                return getLocalContentUriFetchEncodedImageProducerSequence();
            } else {
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + k(sourceUri));
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public Producer<CloseableReference<PooledByteBuffer>> getLocalContentUriFetchEncodedImageProducerSequence() {
        synchronized (this) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence");
            }
            if (this.s == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence:init");
                }
                this.s = new RemoveImageTransformMetaDataProducer(a());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        return this.s;
    }

    public Producer<CloseableReference<PooledByteBuffer>> getLocalFileFetchEncodedImageProducerSequence() {
        synchronized (this) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence");
            }
            if (this.r == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence:init");
                }
                this.r = new RemoveImageTransformMetaDataProducer(b());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        return this.r;
    }

    public Producer<CloseableReference<PooledByteBuffer>> getNetworkFetchEncodedImageProducerSequence() {
        synchronized (this) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence");
            }
            if (this.t == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence:init");
                }
                this.t = new RemoveImageTransformMetaDataProducer(c());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        return this.t;
    }

    public final synchronized Producer<CloseableReference<CloseableImage>> h() {
        if (this.z == null) {
            this.z = o(this.b.newLocalContentUriFetchProducer(), new ThumbnailProducer[]{this.b.newLocalContentUriThumbnailFetchProducer(), this.b.newLocalExifThumbnailProducer()});
        }
        return this.z;
    }

    public final synchronized Producer<CloseableReference<CloseableImage>> i() {
        if (this.y == null) {
            this.y = l(this.b.newLocalVideoThumbnailProducer());
        }
        return this.y;
    }

    public final synchronized Producer<CloseableReference<CloseableImage>> j() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence");
        }
        if (this.n == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence:init");
            }
            this.n = m(f());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.n;
    }

    public final Producer<CloseableReference<CloseableImage>> l(Producer<CloseableReference<CloseableImage>> producer) {
        ThreadHandoffProducer newBackgroundThreadHandoffProducer = this.b.newBackgroundThreadHandoffProducer(this.b.newBitmapMemoryCacheKeyMultiplexProducer(this.b.newBitmapMemoryCacheProducer(producer)), this.g);
        if (!this.l && !this.m) {
            return this.b.newBitmapMemoryCacheGetProducer(newBackgroundThreadHandoffProducer);
        }
        return this.b.newBitmapProbeProducer(this.b.newBitmapMemoryCacheGetProducer(newBackgroundThreadHandoffProducer));
    }

    public final Producer<CloseableReference<CloseableImage>> m(Producer<EncodedImage> producer) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
        }
        Producer<CloseableReference<CloseableImage>> l2 = l(this.b.newDecodeProducer(producer));
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return l2;
    }

    public final Producer<CloseableReference<CloseableImage>> n(Producer<EncodedImage> producer) {
        return o(producer, new ThumbnailProducer[]{this.b.newLocalExifThumbnailProducer()});
    }

    public final Producer<CloseableReference<CloseableImage>> o(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return m(ProducerFactory.newBranchOnSeparateImagesProducer(this.b.newResizeAndRotateProducer(this.b.newThumbnailBranchProducer(thumbnailProducerArr), true, this.k), this.b.newThrottlingProducer(this.b.newResizeAndRotateProducer(ProducerFactory.newAddImageTransformMetaDataProducer(p(producer)), true, this.k))));
    }

    public final Producer<EncodedImage> p(Producer<EncodedImage> producer) {
        DiskCacheWriteProducer diskCacheWriteProducer;
        if (WebpSupportStatus.sIsWebpSupportRequired && (!this.e || WebpSupportStatus.sWebpBitmapFactory == null)) {
            producer = this.b.newWebpTranscodeProducer(producer);
        }
        if (this.j) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#newDiskCacheSequence");
            }
            if (this.f) {
                diskCacheWriteProducer = this.b.newDiskCacheWriteProducer(this.b.newPartialDiskCacheProducer(producer));
            } else {
                diskCacheWriteProducer = this.b.newDiskCacheWriteProducer(producer);
            }
            producer = this.b.newDiskCacheReadProducer(diskCacheWriteProducer);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        EncodedMemoryCacheProducer newEncodedMemoryCacheProducer = this.b.newEncodedMemoryCacheProducer(producer);
        if (!this.m) {
            return this.b.newEncodedCacheKeyMultiplexProducer(newEncodedMemoryCacheProducer);
        }
        return this.b.newEncodedCacheKeyMultiplexProducer(this.b.newEncodedProbeProducer(newEncodedMemoryCacheProducer));
    }
}
