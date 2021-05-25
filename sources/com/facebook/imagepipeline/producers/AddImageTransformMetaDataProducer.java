package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
public class AddImageTransformMetaDataProducer implements Producer<EncodedImage> {
    public final Producer<EncodedImage> a;

    public static class b extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public b(Consumer consumer, a aVar) {
            super(consumer);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            EncodedImage encodedImage = (EncodedImage) obj;
            if (encodedImage == null) {
                getConsumer().onNewResult(null, i);
                return;
            }
            if (!EncodedImage.isMetaDataAvailable(encodedImage)) {
                encodedImage.parseMetaData();
            }
            getConsumer().onNewResult(encodedImage, i);
        }
    }

    public AddImageTransformMetaDataProducer(Producer<EncodedImage> producer) {
        this.a = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.a.produceResults(new b(consumer, null), producerContext);
    }
}
