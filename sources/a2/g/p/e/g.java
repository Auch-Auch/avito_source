package a2.g.p.e;

import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
public class g extends BaseProducerContextCallbacks {
    public final /* synthetic */ PostprocessorProducer.c a;

    public g(PostprocessorProducer.c cVar, PostprocessorProducer postprocessorProducer) {
        this.a = cVar;
    }

    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
    public void onCancellationRequested() {
        if (this.a.a()) {
            this.a.getConsumer().onCancellation();
        }
    }
}
