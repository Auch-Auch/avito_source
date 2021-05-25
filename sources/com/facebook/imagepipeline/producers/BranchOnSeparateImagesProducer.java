package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
public class BranchOnSeparateImagesProducer implements Producer<EncodedImage> {
    public final Producer<EncodedImage> a;
    public final Producer<EncodedImage> b;

    public class b extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public ProducerContext c;

        public b(Consumer consumer, ProducerContext producerContext, a aVar) {
            super(consumer);
            this.c = producerContext;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            BranchOnSeparateImagesProducer.this.b.produceResults(getConsumer(), this.c);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            EncodedImage encodedImage = (EncodedImage) obj;
            ImageRequest imageRequest = this.c.getImageRequest();
            boolean isLast = BaseConsumer.isLast(i);
            boolean isImageBigEnough = ThumbnailSizeChecker.isImageBigEnough(encodedImage, imageRequest.getResizeOptions());
            if (encodedImage != null && (isImageBigEnough || imageRequest.getLocalThumbnailPreviewsEnabled())) {
                if (!isLast || !isImageBigEnough) {
                    getConsumer().onNewResult(encodedImage, BaseConsumer.turnOffStatusFlag(i, 1));
                } else {
                    getConsumer().onNewResult(encodedImage, i);
                }
            }
            if (isLast && !isImageBigEnough) {
                EncodedImage.closeSafely(encodedImage);
                BranchOnSeparateImagesProducer.this.b.produceResults(getConsumer(), this.c);
            }
        }
    }

    public BranchOnSeparateImagesProducer(Producer<EncodedImage> producer, Producer<EncodedImage> producer2) {
        this.a = producer;
        this.b = producer2;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.a.produceResults(new b(consumer, producerContext, null), producerContext);
    }
}
