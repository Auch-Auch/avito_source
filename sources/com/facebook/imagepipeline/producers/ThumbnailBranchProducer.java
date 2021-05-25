package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
public class ThumbnailBranchProducer implements Producer<EncodedImage> {
    public final ThumbnailProducer<EncodedImage>[] a;

    public class a extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public final ProducerContext c;
        public final int d;
        public final ResizeOptions e;

        public a(Consumer<EncodedImage> consumer, ProducerContext producerContext, int i) {
            super(consumer);
            this.c = producerContext;
            this.d = i;
            this.e = producerContext.getImageRequest().getResizeOptions();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            if (!ThumbnailBranchProducer.this.a(this.d + 1, getConsumer(), this.c)) {
                getConsumer().onFailure(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            EncodedImage encodedImage = (EncodedImage) obj;
            if (encodedImage != null && (BaseConsumer.isNotLast(i) || ThumbnailSizeChecker.isImageBigEnough(encodedImage, this.e))) {
                getConsumer().onNewResult(encodedImage, i);
            } else if (BaseConsumer.isLast(i)) {
                EncodedImage.closeSafely(encodedImage);
                if (!ThumbnailBranchProducer.this.a(this.d + 1, getConsumer(), this.c)) {
                    getConsumer().onNewResult(null, 1);
                }
            }
        }
    }

    public ThumbnailBranchProducer(ThumbnailProducer<EncodedImage>... thumbnailProducerArr) {
        ThumbnailProducer<EncodedImage>[] thumbnailProducerArr2 = (ThumbnailProducer[]) Preconditions.checkNotNull(thumbnailProducerArr);
        this.a = thumbnailProducerArr2;
        Preconditions.checkElementIndex(0, thumbnailProducerArr2.length);
    }

    public final boolean a(int i, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ResizeOptions resizeOptions = producerContext.getImageRequest().getResizeOptions();
        while (true) {
            ThumbnailProducer<EncodedImage>[] thumbnailProducerArr = this.a;
            if (i >= thumbnailProducerArr.length) {
                i = -1;
                break;
            } else if (thumbnailProducerArr[i].canProvideImageForSize(resizeOptions)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return false;
        }
        this.a[i].produceResults(new a(consumer, producerContext, i), producerContext);
        return true;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (producerContext.getImageRequest().getResizeOptions() == null) {
            consumer.onNewResult(null, 1);
        } else if (!a(0, consumer, producerContext)) {
            consumer.onNewResult(null, 1);
        }
    }
}
