package com.facebook.imagepipeline.datasource;

import a2.g.p.c.a;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.HasImageRequest;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T> implements HasImageRequest {
    public final SettableProducerContext i;
    public final RequestListener2 j;

    public AbstractProducerToDataSourceAdapter(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()");
        }
        this.i = settableProducerContext;
        this.j = requestListener2;
        setExtras(settableProducerContext.getExtras());
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->onRequestStart");
        }
        requestListener2.onRequestStart(settableProducerContext);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->produceResult");
        }
        producer.produceResults(new a(this), settableProducerContext);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public static void c(AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter, Throwable th) {
        if (super.setFailure(th, abstractProducerToDataSourceAdapter.getExtras(abstractProducerToDataSourceAdapter.i))) {
            abstractProducerToDataSourceAdapter.j.onRequestFailure(abstractProducerToDataSourceAdapter.i, th);
        }
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean close() {
        if (!super.close()) {
            return false;
        }
        if (super.isFinished()) {
            return true;
        }
        this.j.onRequestCancellation(this.i);
        this.i.cancel();
        return true;
    }

    public Map<String, Object> getExtras(ProducerContext producerContext) {
        return producerContext.getExtras();
    }

    @Override // com.facebook.imagepipeline.request.HasImageRequest
    public ImageRequest getImageRequest() {
        return this.i.getImageRequest();
    }

    public void onNewResultImpl(@Nullable T t, int i2, ProducerContext producerContext) {
        boolean isLast = BaseConsumer.isLast(i2);
        if (super.setResult(t, isLast, getExtras(producerContext)) && isLast) {
            this.j.onRequestSuccess(this.i);
        }
    }
}
