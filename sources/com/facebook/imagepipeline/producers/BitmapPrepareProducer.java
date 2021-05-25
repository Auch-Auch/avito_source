package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
public class BitmapPrepareProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String PRODUCER_NAME = "BitmapPrepareProducer";
    public final Producer<CloseableReference<CloseableImage>> a;
    public final int b;
    public final int c;
    public final boolean d;

    public static class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final int c;
        public final int d;

        public a(Consumer<CloseableReference<CloseableImage>> consumer, int i, int i2) {
            super(consumer);
            this.c = i;
            this.d = i2;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            CloseableImage closeableImage;
            Bitmap underlyingBitmap;
            int height;
            CloseableReference closeableReference = (CloseableReference) obj;
            if (closeableReference != null && closeableReference.isValid() && (closeableImage = (CloseableImage) closeableReference.get()) != null && !closeableImage.isClosed() && (closeableImage instanceof CloseableStaticBitmap) && (underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap()) != null && (height = underlyingBitmap.getHeight() * underlyingBitmap.getRowBytes()) >= this.c && height <= this.d) {
                underlyingBitmap.prepareToDraw();
            }
            getConsumer().onNewResult(closeableReference, i);
        }
    }

    public BitmapPrepareProducer(Producer<CloseableReference<CloseableImage>> producer, int i, int i2, boolean z) {
        Preconditions.checkArgument(i <= i2);
        this.a = (Producer) Preconditions.checkNotNull(producer);
        this.b = i;
        this.c = i2;
        this.d = z;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        if (!producerContext.isPrefetch() || this.d) {
            this.a.produceResults(new a(consumer, this.b, this.c), producerContext);
        } else {
            this.a.produceResults(consumer, producerContext);
        }
    }
}
