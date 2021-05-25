package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;
public class ThreadHandoffProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
    public final Producer<T> a;
    public final ThreadHandoffProducerQueue b;

    public class a extends StatefulProducerRunnable<T> {
        public final /* synthetic */ ProducerListener2 e;
        public final /* synthetic */ ProducerContext f;
        public final /* synthetic */ Consumer g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ProducerListener2 producerListener22, ProducerContext producerContext2, Consumer consumer2) {
            super(consumer, producerListener2, producerContext, str);
            this.e = producerListener22;
            this.f = producerContext2;
            this.g = consumer2;
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void disposeResult(T t) {
        }

        @Override // com.facebook.common.executors.StatefulRunnable
        @Nullable
        public T getResult() throws Exception {
            return null;
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void onSuccess(T t) {
            this.e.onProducerFinishWithSuccess(this.f, ThreadHandoffProducer.PRODUCER_NAME, null);
            ThreadHandoffProducer.this.a.produceResults(this.g, this.f);
        }
    }

    public class b extends BaseProducerContextCallbacks {
        public final /* synthetic */ StatefulProducerRunnable a;

        public b(StatefulProducerRunnable statefulProducerRunnable) {
            this.a = statefulProducerRunnable;
        }

        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void onCancellationRequested() {
            this.a.cancel();
            ThreadHandoffProducer.this.b.remove(this.a);
        }
    }

    public ThreadHandoffProducer(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        this.a = (Producer) Preconditions.checkNotNull(producer);
        this.b = threadHandoffProducerQueue;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        String str;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ThreadHandoffProducer#produceResults");
            }
            ProducerListener2 producerListener = producerContext.getProducerListener();
            a aVar = new a(consumer, producerListener, producerContext, PRODUCER_NAME, producerListener, producerContext, consumer);
            producerContext.addCallbacks(new b(aVar));
            ThreadHandoffProducerQueue threadHandoffProducerQueue = this.b;
            if (FrescoInstrumenter.isTracing()) {
                str = "ThreadHandoffProducer_produceResults_" + producerContext.getId();
            } else {
                str = null;
            }
            threadHandoffProducerQueue.addToQueueOrExecute(FrescoInstrumenter.decorateRunnable(aVar, str));
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }
}
