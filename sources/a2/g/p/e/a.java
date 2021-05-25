package a2.g.p.e;

import bolts.Continuation;
import bolts.Task;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener2;
import java.util.concurrent.CancellationException;
public class a implements Continuation<EncodedImage, Void> {
    public final /* synthetic */ ProducerListener2 a;
    public final /* synthetic */ ProducerContext b;
    public final /* synthetic */ Consumer c;
    public final /* synthetic */ DiskCacheReadProducer d;

    public a(DiskCacheReadProducer diskCacheReadProducer, ProducerListener2 producerListener2, ProducerContext producerContext, Consumer consumer) {
        this.d = diskCacheReadProducer;
        this.a = producerListener2;
        this.b = producerContext;
        this.c = consumer;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
    @Override // bolts.Continuation
    public Void then(Task<EncodedImage> task) throws Exception {
        if (task.isCancelled() || (task.isFaulted() && (task.getError() instanceof CancellationException))) {
            this.a.onProducerFinishWithCancellation(this.b, DiskCacheReadProducer.PRODUCER_NAME, null);
            this.c.onCancellation();
        } else if (task.isFaulted()) {
            this.a.onProducerFinishWithFailure(this.b, DiskCacheReadProducer.PRODUCER_NAME, task.getError(), null);
            this.d.d.produceResults(this.c, this.b);
        } else {
            EncodedImage result = task.getResult();
            if (result != null) {
                ProducerListener2 producerListener2 = this.a;
                ProducerContext producerContext = this.b;
                producerListener2.onProducerFinishWithSuccess(producerContext, DiskCacheReadProducer.PRODUCER_NAME, DiskCacheReadProducer.a(producerListener2, producerContext, true, result.getSize()));
                this.a.onUltimateProducerReached(this.b, DiskCacheReadProducer.PRODUCER_NAME, true);
                this.b.putOriginExtra("disk");
                this.c.onProgressUpdate(1.0f);
                this.c.onNewResult(result, 1);
                result.close();
            } else {
                ProducerListener2 producerListener22 = this.a;
                ProducerContext producerContext2 = this.b;
                producerListener22.onProducerFinishWithSuccess(producerContext2, DiskCacheReadProducer.PRODUCER_NAME, DiskCacheReadProducer.a(producerListener22, producerContext2, false, 0));
                this.d.d.produceResults(this.c, this.b);
            }
        }
        return null;
    }
}
