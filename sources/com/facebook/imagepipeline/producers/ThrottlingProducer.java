package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
public class ThrottlingProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "ThrottlingProducer";
    public final Producer<T> a;
    public final int b;
    @GuardedBy("this")
    public int c = 0;
    @GuardedBy("this")
    public final ConcurrentLinkedQueue<Pair<Consumer<T>, ProducerContext>> d = new ConcurrentLinkedQueue<>();
    public final Executor e;

    public class b extends DelegatingConsumer<T, T> {

        public class a implements Runnable {
            public final /* synthetic */ Pair a;

            public a(Pair pair) {
                this.a = pair;
            }

            @Override // java.lang.Runnable
            public void run() {
                ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                Pair pair = this.a;
                ProducerContext producerContext = (ProducerContext) pair.second;
                Objects.requireNonNull(throttlingProducer);
                producerContext.getProducerListener().onProducerFinishWithSuccess(producerContext, ThrottlingProducer.PRODUCER_NAME, null);
                throttlingProducer.a.produceResults(new b((Consumer) pair.first, null), producerContext);
            }
        }

        public b(Consumer consumer, a aVar) {
            super(consumer);
        }

        public final void a() {
            Pair<Consumer<T>, ProducerContext> poll;
            synchronized (ThrottlingProducer.this) {
                poll = ThrottlingProducer.this.d.poll();
                if (poll == null) {
                    ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                    throttlingProducer.c--;
                }
            }
            if (poll != null) {
                ThrottlingProducer.this.e.execute(new a(poll));
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            getConsumer().onCancellation();
            a();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            getConsumer().onFailure(th);
            a();
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(T t, int i) {
            getConsumer().onNewResult(t, i);
            if (BaseConsumer.isLast(i)) {
                a();
            }
        }
    }

    public ThrottlingProducer(int i, Executor executor, Producer<T> producer) {
        this.b = i;
        this.e = (Executor) Preconditions.checkNotNull(executor);
        this.a = (Producer) Preconditions.checkNotNull(producer);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        synchronized (this) {
            int i = this.c;
            z = true;
            if (i >= this.b) {
                this.d.add(Pair.create(consumer, producerContext));
            } else {
                this.c = i + 1;
                z = false;
            }
        }
        if (!z) {
            producerContext.getProducerListener().onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, null);
            this.a.produceResults(new b(consumer, null), producerContext);
        }
    }
}
