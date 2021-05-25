package a2.g.p.e;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
public class f implements Runnable {
    public final /* synthetic */ PostprocessorProducer.b a;

    public f(PostprocessorProducer.b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        CloseableReference<CloseableImage> closeableReference;
        int i;
        boolean f;
        synchronized (this.a) {
            PostprocessorProducer.b bVar = this.a;
            closeableReference = bVar.g;
            i = bVar.h;
            bVar.g = null;
            bVar.i = false;
        }
        if (CloseableReference.isValid(closeableReference)) {
            try {
                PostprocessorProducer.b.a(this.a, closeableReference, i);
            } finally {
                CloseableReference.closeSafely(closeableReference);
            }
        }
        PostprocessorProducer.b bVar2 = this.a;
        synchronized (bVar2) {
            bVar2.j = false;
            f = bVar2.f();
        }
        if (f) {
            PostprocessorProducer.this.c.execute(new f(bVar2));
        }
    }
}
