package a2.g.p.c;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter;
import com.facebook.imagepipeline.producers.BaseConsumer;
import javax.annotation.Nullable;
public class a extends BaseConsumer<T> {
    public final /* synthetic */ AbstractProducerToDataSourceAdapter b;

    public a(AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter) {
        this.b = abstractProducerToDataSourceAdapter;
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onCancellationImpl() {
        AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter = this.b;
        synchronized (abstractProducerToDataSourceAdapter) {
            Preconditions.checkState(abstractProducerToDataSourceAdapter.isClosed());
        }
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onFailureImpl(Throwable th) {
        AbstractProducerToDataSourceAdapter.c(this.b, th);
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onNewResultImpl(@Nullable T t, int i) {
        AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter = this.b;
        abstractProducerToDataSourceAdapter.onNewResultImpl(t, i, abstractProducerToDataSourceAdapter.i);
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onProgressUpdateImpl(float f) {
        this.b.setProgress(f);
    }
}
