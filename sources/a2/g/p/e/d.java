package a2.g.p.e;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener2;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.concurrent.CancellationException;
public class d implements Continuation<EncodedImage, Void> {
    public final /* synthetic */ ProducerListener2 a;
    public final /* synthetic */ ProducerContext b;
    public final /* synthetic */ Consumer c;
    public final /* synthetic */ CacheKey d;
    public final /* synthetic */ PartialDiskCacheProducer e;

    public d(PartialDiskCacheProducer partialDiskCacheProducer, ProducerListener2 producerListener2, ProducerContext producerContext, Consumer consumer, CacheKey cacheKey) {
        this.e = partialDiskCacheProducer;
        this.a = producerListener2;
        this.b = producerContext;
        this.c = consumer;
        this.d = cacheKey;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
    @Override // bolts.Continuation
    public Void then(Task<EncodedImage> task) throws Exception {
        if (task.isCancelled() || (task.isFaulted() && (task.getError() instanceof CancellationException))) {
            this.a.onProducerFinishWithCancellation(this.b, PartialDiskCacheProducer.PRODUCER_NAME, null);
            this.c.onCancellation();
        } else if (task.isFaulted()) {
            this.a.onProducerFinishWithFailure(this.b, PartialDiskCacheProducer.PRODUCER_NAME, task.getError(), null);
            PartialDiskCacheProducer.a(this.e, this.c, this.b, this.d, null);
        } else {
            EncodedImage result = task.getResult();
            if (result != null) {
                ProducerListener2 producerListener2 = this.a;
                ProducerContext producerContext = this.b;
                producerListener2.onProducerFinishWithSuccess(producerContext, PartialDiskCacheProducer.PRODUCER_NAME, PartialDiskCacheProducer.b(producerListener2, producerContext, true, result.getSize()));
                BytesRange max = BytesRange.toMax(result.getSize() - 1);
                result.setBytesRange(max);
                int size = result.getSize();
                ImageRequest imageRequest = this.b.getImageRequest();
                if (max.contains(imageRequest.getBytesRange())) {
                    this.b.putOriginExtra("disk", "partial");
                    this.a.onUltimateProducerReached(this.b, PartialDiskCacheProducer.PRODUCER_NAME, true);
                    this.c.onNewResult(result, 9);
                } else {
                    this.c.onNewResult(result, 8);
                    PartialDiskCacheProducer.a(this.e, this.c, new SettableProducerContext(ImageRequestBuilder.fromRequest(imageRequest).setBytesRange(BytesRange.from(size - 1)).build(), this.b), this.d, result);
                }
            } else {
                ProducerListener2 producerListener22 = this.a;
                ProducerContext producerContext2 = this.b;
                producerListener22.onProducerFinishWithSuccess(producerContext2, PartialDiskCacheProducer.PRODUCER_NAME, PartialDiskCacheProducer.b(producerListener22, producerContext2, false, 0));
                PartialDiskCacheProducer.a(this.e, this.c, this.b, this.d, result);
            }
        }
        return null;
    }
}
