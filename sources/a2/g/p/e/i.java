package a2.g.p.e;

import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener2;
import com.facebook.imagepipeline.producers.StatefulProducerRunnable;
import com.facebook.imagepipeline.producers.WebpTranscodeProducer;
public class i extends StatefulProducerRunnable<EncodedImage> {
    public final /* synthetic */ EncodedImage e;
    public final /* synthetic */ WebpTranscodeProducer f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(WebpTranscodeProducer webpTranscodeProducer, Consumer consumer, ProducerListener2 producerListener2, ProducerContext producerContext, String str, EncodedImage encodedImage) {
        super(consumer, producerListener2, producerContext, str);
        this.f = webpTranscodeProducer;
        this.e = encodedImage;
    }

    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
    public void disposeResult(Object obj) {
        EncodedImage.closeSafely((EncodedImage) obj);
    }

    /* JADX INFO: finally extract failed */
    @Override // com.facebook.common.executors.StatefulRunnable
    public Object getResult() throws Exception {
        PooledByteBufferOutputStream newOutputStream = this.f.b.newOutputStream();
        try {
            WebpTranscodeProducer.a(this.e, newOutputStream);
            CloseableReference of = CloseableReference.of(newOutputStream.toByteBuffer());
            try {
                EncodedImage encodedImage = new EncodedImage(of);
                encodedImage.copyMetaDataFrom(this.e);
                CloseableReference.closeSafely(of);
                return encodedImage;
            } catch (Throwable th) {
                CloseableReference.closeSafely(of);
                throw th;
            }
        } finally {
            newOutputStream.close();
        }
    }

    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
    public void onCancellation() {
        EncodedImage.closeSafely(this.e);
        super.onCancellation();
    }

    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
    public void onFailure(Exception exc) {
        EncodedImage.closeSafely(this.e);
        super.onFailure(exc);
    }

    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
    public void onSuccess(Object obj) {
        EncodedImage.closeSafely(this.e);
        super.onSuccess((EncodedImage) obj);
    }
}
