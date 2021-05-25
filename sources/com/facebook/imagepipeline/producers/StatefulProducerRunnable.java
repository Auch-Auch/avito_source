package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;
import javax.annotation.Nullable;
public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {
    public final Consumer<T> a;
    public final ProducerListener2 b;
    public final String c;
    public final ProducerContext d;

    public StatefulProducerRunnable(Consumer<T> consumer, ProducerListener2 producerListener2, ProducerContext producerContext, String str) {
        this.a = consumer;
        this.b = producerListener2;
        this.c = str;
        this.d = producerContext;
        producerListener2.onProducerStart(producerContext, str);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public abstract void disposeResult(T t);

    @Nullable
    public Map<String, String> getExtraMapOnCancellation() {
        return null;
    }

    @Nullable
    public Map<String, String> getExtraMapOnFailure(Exception exc) {
        return null;
    }

    @Nullable
    public Map<String, String> getExtraMapOnSuccess(T t) {
        return null;
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onCancellation() {
        ProducerListener2 producerListener2 = this.b;
        ProducerContext producerContext = this.d;
        String str = this.c;
        producerListener2.onProducerFinishWithCancellation(producerContext, str, producerListener2.requiresExtraMap(producerContext, str) ? getExtraMapOnCancellation() : null);
        this.a.onCancellation();
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onFailure(Exception exc) {
        ProducerListener2 producerListener2 = this.b;
        ProducerContext producerContext = this.d;
        String str = this.c;
        producerListener2.onProducerFinishWithFailure(producerContext, str, exc, producerListener2.requiresExtraMap(producerContext, str) ? getExtraMapOnFailure(exc) : null);
        this.a.onFailure(exc);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onSuccess(T t) {
        ProducerListener2 producerListener2 = this.b;
        ProducerContext producerContext = this.d;
        String str = this.c;
        producerListener2.onProducerFinishWithSuccess(producerContext, str, producerListener2.requiresExtraMap(producerContext, str) ? getExtraMapOnSuccess(t) : null);
        this.a.onNewResult(t, 1);
    }
}
