package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
public class NetworkFetchProducer implements Producer<EncodedImage> {
    public static final String INTERMEDIATE_RESULT_PRODUCER_EVENT = "intermediate_result";
    public static final String PRODUCER_NAME = "NetworkFetchProducer";
    public final PooledByteBufferFactory a;
    public final ByteArrayPool b;
    public final NetworkFetcher c;

    public class a implements NetworkFetcher.Callback {
        public final /* synthetic */ FetchState a;

        public a(FetchState fetchState) {
            this.a = fetchState;
        }

        @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
        public void onCancellation() {
            NetworkFetchProducer networkFetchProducer = NetworkFetchProducer.this;
            FetchState fetchState = this.a;
            Objects.requireNonNull(networkFetchProducer);
            fetchState.getListener().onProducerFinishWithCancellation(fetchState.getContext(), NetworkFetchProducer.PRODUCER_NAME, null);
            fetchState.getConsumer().onCancellation();
        }

        @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
        public void onFailure(Throwable th) {
            NetworkFetchProducer networkFetchProducer = NetworkFetchProducer.this;
            FetchState fetchState = this.a;
            Objects.requireNonNull(networkFetchProducer);
            fetchState.getListener().onProducerFinishWithFailure(fetchState.getContext(), NetworkFetchProducer.PRODUCER_NAME, th, null);
            fetchState.getListener().onUltimateProducerReached(fetchState.getContext(), NetworkFetchProducer.PRODUCER_NAME, false);
            fetchState.getContext().putOriginExtra("network");
            fetchState.getConsumer().onFailure(th);
        }

        @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
        public void onResponse(InputStream inputStream, int i) throws IOException {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("NetworkFetcher->onResponse");
            }
            NetworkFetchProducer.this.onResponse(this.a, inputStream, i);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public NetworkFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher networkFetcher) {
        this.a = pooledByteBufferFactory;
        this.b = byteArrayPool;
        this.c = networkFetcher;
    }

    public static float calculateProgress(int i, int i2) {
        return i2 > 0 ? ((float) i) / ((float) i2) : 1.0f - ((float) Math.exp(((double) (-i)) / 50000.0d));
    }

    public static void notifyConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream, int i, @Nullable BytesRange bytesRange, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Throwable th;
        CloseableReference of = CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
        EncodedImage encodedImage = null;
        try {
            EncodedImage encodedImage2 = new EncodedImage(of);
            try {
                encodedImage2.setBytesRange(bytesRange);
                encodedImage2.parseMetaData();
                producerContext.setEncodedImageOrigin(EncodedImageOrigin.NETWORK);
                consumer.onNewResult(encodedImage2, i);
                EncodedImage.closeSafely(encodedImage2);
                CloseableReference.closeSafely(of);
            } catch (Throwable th2) {
                th = th2;
                encodedImage = encodedImage2;
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(of);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            EncodedImage.closeSafely(encodedImage);
            CloseableReference.closeSafely(of);
            throw th;
        }
    }

    @VisibleForTesting
    public long getSystemUptime() {
        return SystemClock.uptimeMillis();
    }

    public void handleFinalResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        Map<String, String> map;
        int size = pooledByteBufferOutputStream.size();
        if (!fetchState.getListener().requiresExtraMap(fetchState.getContext(), PRODUCER_NAME)) {
            map = null;
        } else {
            map = this.c.getExtraMap(fetchState, size);
        }
        ProducerListener2 listener = fetchState.getListener();
        listener.onProducerFinishWithSuccess(fetchState.getContext(), PRODUCER_NAME, map);
        listener.onUltimateProducerReached(fetchState.getContext(), PRODUCER_NAME, true);
        fetchState.getContext().putOriginExtra("network");
        notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags() | 1, fetchState.getResponseBytesRange(), fetchState.getConsumer(), fetchState.getContext());
    }

    public void maybeHandleIntermediateResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        boolean z;
        long systemUptime = getSystemUptime();
        if (!fetchState.getContext().isIntermediateResultExpected()) {
            z = false;
        } else {
            z = this.c.shouldPropagate(fetchState);
        }
        if (z && systemUptime - fetchState.getLastIntermediateResultTimeMs() >= 100) {
            fetchState.setLastIntermediateResultTimeMs(systemUptime);
            fetchState.getListener().onProducerEvent(fetchState.getContext(), PRODUCER_NAME, INTERMEDIATE_RESULT_PRODUCER_EVENT);
            notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags(), fetchState.getResponseBytesRange(), fetchState.getConsumer(), fetchState.getContext());
        }
    }

    public void onResponse(FetchState fetchState, InputStream inputStream, int i) throws IOException {
        PooledByteBufferOutputStream pooledByteBufferOutputStream;
        if (i > 0) {
            pooledByteBufferOutputStream = this.a.newOutputStream(i);
        } else {
            pooledByteBufferOutputStream = this.a.newOutputStream();
        }
        byte[] bArr = (byte[]) this.b.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    this.c.onFetchCompletion(fetchState, pooledByteBufferOutputStream.size());
                    handleFinalResult(pooledByteBufferOutputStream, fetchState);
                    return;
                } else if (read > 0) {
                    pooledByteBufferOutputStream.write(bArr, 0, read);
                    maybeHandleIntermediateResult(pooledByteBufferOutputStream, fetchState);
                    fetchState.getConsumer().onProgressUpdate(calculateProgress(pooledByteBufferOutputStream.size(), i));
                }
            } finally {
                this.b.release(bArr);
                pooledByteBufferOutputStream.close();
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        FetchState createFetchState = this.c.createFetchState(consumer, producerContext);
        this.c.fetch(createFetchState, new a(createFetchState));
    }
}
