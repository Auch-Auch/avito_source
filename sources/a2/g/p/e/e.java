package a2.g.p.e;

import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import java.util.concurrent.atomic.AtomicBoolean;
public class e extends BaseProducerContextCallbacks {
    public final /* synthetic */ AtomicBoolean a;

    public e(PartialDiskCacheProducer partialDiskCacheProducer, AtomicBoolean atomicBoolean) {
        this.a = atomicBoolean;
    }

    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
    public void onCancellationRequested() {
        this.a.set(true);
    }
}
