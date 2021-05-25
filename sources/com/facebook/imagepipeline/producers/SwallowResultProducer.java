package com.facebook.imagepipeline.producers;
public class SwallowResultProducer<T> implements Producer<Void> {
    public final Producer<T> a;

    public class a extends DelegatingConsumer<T, Void> {
        public a(SwallowResultProducer swallowResultProducer, Consumer consumer) {
            super(consumer);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(T t, int i) {
            if (BaseConsumer.isLast(i)) {
                getConsumer().onNewResult(null, i);
            }
        }
    }

    public SwallowResultProducer(Producer<T> producer) {
        this.a = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<Void> consumer, ProducerContext producerContext) {
        this.a.produceResults(new a(this, consumer), producerContext);
    }
}
