package a2.g.p.e;

import android.util.Pair;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.producers.BaseProducerContext;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.MultiplexProducer;
import com.facebook.imagepipeline.producers.ProducerContextCallbacks;
import java.util.List;
public class c extends BaseProducerContextCallbacks {
    public final /* synthetic */ Pair a;
    public final /* synthetic */ MultiplexProducer.b b;

    public c(MultiplexProducer.b bVar, Pair pair) {
        this.b = bVar;
        this.a = pair;
    }

    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
    public void onCancellationRequested() {
        boolean remove;
        List<ProducerContextCallbacks> list;
        List<ProducerContextCallbacks> list2;
        List<ProducerContextCallbacks> list3;
        BaseProducerContext baseProducerContext;
        synchronized (this.b) {
            remove = this.b.b.remove(this.a);
            list = null;
            if (!remove) {
                baseProducerContext = null;
            } else if (this.b.b.isEmpty()) {
                baseProducerContext = this.b.f;
            } else {
                List<ProducerContextCallbacks> k = this.b.k();
                list3 = this.b.l();
                list2 = this.b.j();
                baseProducerContext = null;
                list = k;
            }
            list3 = null;
            list2 = null;
        }
        BaseProducerContext.callOnIsPrefetchChanged(list);
        BaseProducerContext.callOnPriorityChanged(list3);
        BaseProducerContext.callOnIsIntermediateResultExpectedChanged(list2);
        if (baseProducerContext != null) {
            if (!MultiplexProducer.this.c || baseProducerContext.isPrefetch()) {
                baseProducerContext.cancel();
            } else {
                BaseProducerContext.callOnPriorityChanged(baseProducerContext.setPriorityNoCallbacks(Priority.LOW));
            }
        }
        if (remove) {
            ((Consumer) this.a.first).onCancellation();
        }
    }

    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
    public void onIsIntermediateResultExpectedChanged() {
        BaseProducerContext.callOnIsIntermediateResultExpectedChanged(this.b.j());
    }

    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
    public void onIsPrefetchChanged() {
        BaseProducerContext.callOnIsPrefetchChanged(this.b.k());
    }

    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
    public void onPriorityChanged() {
        BaseProducerContext.callOnPriorityChanged(this.b.l());
    }
}
