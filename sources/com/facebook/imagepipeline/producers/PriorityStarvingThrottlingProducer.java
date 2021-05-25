package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.Priority;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
public class PriorityStarvingThrottlingProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "PriorityStarvingThrottlingProducer";
    public final Producer<T> a;
    public final int b;
    @GuardedBy("this")
    public final Queue<b<T>> c = new PriorityQueue(11, new c());
    public final Executor d;
    @GuardedBy("this")
    public int e = 0;

    public static class b<T> {
        public final Consumer<T> a;
        public final ProducerContext b;
        public final long c;

        public b(Consumer<T> consumer, ProducerContext producerContext, long j) {
            this.a = consumer;
            this.b = producerContext;
            this.c = j;
        }
    }

    public static class c<T> implements Comparator<b<T>> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            b bVar = (b) obj;
            b bVar2 = (b) obj2;
            Priority priority = bVar.b.getPriority();
            Priority priority2 = bVar2.b.getPriority();
            if (priority == priority2) {
                return Double.compare((double) bVar.c, (double) bVar2.c);
            }
            return priority.ordinal() > priority2.ordinal() ? -1 : 1;
        }
    }

    public class d extends DelegatingConsumer<T, T> {

        public class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                PriorityStarvingThrottlingProducer.this.a(this.a);
            }
        }

        public d(Consumer consumer, a aVar) {
            super(consumer);
        }

        public final void a() {
            b<T> poll;
            synchronized (PriorityStarvingThrottlingProducer.this) {
                poll = PriorityStarvingThrottlingProducer.this.c.poll();
                if (poll == null) {
                    PriorityStarvingThrottlingProducer priorityStarvingThrottlingProducer = PriorityStarvingThrottlingProducer.this;
                    priorityStarvingThrottlingProducer.e--;
                }
            }
            if (poll != null) {
                PriorityStarvingThrottlingProducer.this.d.execute(new a(poll));
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

    public PriorityStarvingThrottlingProducer(int i, Executor executor, Producer<T> producer) {
        this.b = i;
        this.d = (Executor) Preconditions.checkNotNull(executor);
        this.a = (Producer) Preconditions.checkNotNull(producer);
    }

    public final void a(b<T> bVar) {
        bVar.b.getProducerListener().onProducerFinishWithSuccess(bVar.b, PRODUCER_NAME, null);
        this.a.produceResults(new d(bVar.a, null), bVar.b);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        long nanoTime = System.nanoTime();
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        synchronized (this) {
            int i = this.e;
            z = true;
            if (i >= this.b) {
                this.c.add(new b<>(consumer, producerContext, nanoTime));
            } else {
                this.e = i + 1;
                z = false;
            }
        }
        if (!z) {
            producerContext.getProducerListener().onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, null);
            this.a.produceResults(new d(consumer, null), producerContext);
        }
    }
}
