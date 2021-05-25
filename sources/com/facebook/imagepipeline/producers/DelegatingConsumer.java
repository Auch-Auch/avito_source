package com.facebook.imagepipeline.producers;
public abstract class DelegatingConsumer<I, O> extends BaseConsumer<I> {
    public final Consumer<O> b;

    public DelegatingConsumer(Consumer<O> consumer) {
        this.b = consumer;
    }

    public Consumer<O> getConsumer() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onCancellationImpl() {
        this.b.onCancellation();
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onFailureImpl(Throwable th) {
        this.b.onFailure(th);
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onProgressUpdateImpl(float f) {
        this.b.onProgressUpdate(f);
    }
}
