package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
public abstract class LocalFetchProducer implements Producer<EncodedImage> {
    public final Executor a;
    public final PooledByteBufferFactory b;

    public class a extends StatefulProducerRunnable<EncodedImage> {
        public final /* synthetic */ ImageRequest e;
        public final /* synthetic */ ProducerListener2 f;
        public final /* synthetic */ ProducerContext g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ImageRequest imageRequest, ProducerListener2 producerListener22, ProducerContext producerContext2) {
            super(consumer, producerListener2, producerContext, str);
            this.e = imageRequest;
            this.f = producerListener22;
            this.g = producerContext2;
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void disposeResult(Object obj) {
            EncodedImage.closeSafely((EncodedImage) obj);
        }

        @Override // com.facebook.common.executors.StatefulRunnable
        @Nullable
        public Object getResult() throws Exception {
            EncodedImage encodedImage = LocalFetchProducer.this.getEncodedImage(this.e);
            if (encodedImage == null) {
                this.f.onUltimateProducerReached(this.g, LocalFetchProducer.this.getProducerName(), false);
                this.g.putOriginExtra(ImagesContract.LOCAL);
                return null;
            }
            encodedImage.parseMetaData();
            this.f.onUltimateProducerReached(this.g, LocalFetchProducer.this.getProducerName(), true);
            this.g.putOriginExtra(ImagesContract.LOCAL);
            return encodedImage;
        }
    }

    public class b extends BaseProducerContextCallbacks {
        public final /* synthetic */ StatefulProducerRunnable a;

        public b(LocalFetchProducer localFetchProducer, StatefulProducerRunnable statefulProducerRunnable) {
            this.a = statefulProducerRunnable;
        }

        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void onCancellationRequested() {
            this.a.cancel();
        }
    }

    public LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        this.a = executor;
        this.b = pooledByteBufferFactory;
    }

    public EncodedImage getByteBufferBackedEncodedImage(InputStream inputStream, int i) throws IOException {
        CloseableReference closeableReference;
        if (i <= 0) {
            try {
                closeableReference = CloseableReference.of(this.b.newByteBuffer(inputStream));
            } catch (Throwable th) {
                Closeables.closeQuietly(inputStream);
                CloseableReference.closeSafely((CloseableReference<?>) null);
                throw th;
            }
        } else {
            closeableReference = CloseableReference.of(this.b.newByteBuffer(inputStream, i));
        }
        EncodedImage encodedImage = new EncodedImage(closeableReference);
        Closeables.closeQuietly(inputStream);
        CloseableReference.closeSafely(closeableReference);
        return encodedImage;
    }

    public abstract EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException;

    public EncodedImage getEncodedImage(InputStream inputStream, int i) throws IOException {
        return getByteBufferBackedEncodedImage(inputStream, i);
    }

    public abstract String getProducerName();

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ProducerListener2 producerListener = producerContext.getProducerListener();
        ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra(ImagesContract.LOCAL, "fetch");
        a aVar = new a(consumer, producerListener, producerContext, getProducerName(), imageRequest, producerListener, producerContext);
        producerContext.addCallbacks(new b(this, aVar));
        this.a.execute(aVar);
    }
}
