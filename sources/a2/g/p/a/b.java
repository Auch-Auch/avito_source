package a2.g.p.a;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
public class b implements Callable<EncodedImage> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ CacheKey c;
    public final /* synthetic */ BufferedDiskCache d;

    public b(BufferedDiskCache bufferedDiskCache, Object obj, AtomicBoolean atomicBoolean, CacheKey cacheKey) {
        this.d = bufferedDiskCache;
        this.a = obj;
        this.b = atomicBoolean;
        this.c = cacheKey;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: finally extract failed */
    @Override // java.util.concurrent.Callable
    @Nullable
    public EncodedImage call() throws Exception {
        EncodedImage encodedImage = null;
        Object onBeginWork = FrescoInstrumenter.onBeginWork(this.a, null);
        try {
            if (!this.b.get()) {
                EncodedImage encodedImage2 = this.d.f.get(this.c);
                if (encodedImage2 != null) {
                    FLog.v(BufferedDiskCache.class, "Found image for %s in staging area", this.c.getUriString());
                    this.d.g.onStagingAreaHit(this.c);
                    encodedImage = encodedImage2;
                } else {
                    FLog.v(BufferedDiskCache.class, "Did not find image for %s in staging area", this.c.getUriString());
                    this.d.g.onStagingAreaMiss(this.c);
                    try {
                        PooledByteBuffer a3 = BufferedDiskCache.a(this.d, this.c);
                        if (a3 == null) {
                            FrescoInstrumenter.onEndWork(onBeginWork);
                            return encodedImage;
                        }
                        CloseableReference of = CloseableReference.of(a3);
                        try {
                            EncodedImage encodedImage3 = new EncodedImage(of);
                            CloseableReference.closeSafely(of);
                            encodedImage = encodedImage3;
                        } catch (Throwable th) {
                            CloseableReference.closeSafely(of);
                            throw th;
                        }
                    } catch (Exception unused) {
                    }
                }
                if (Thread.interrupted()) {
                    FLog.v(BufferedDiskCache.class, "Host thread was interrupted, decreasing reference count");
                    encodedImage.close();
                    throw new InterruptedException();
                }
                FrescoInstrumenter.onEndWork(onBeginWork);
                return encodedImage;
            }
            throw new CancellationException();
        } catch (Throwable th2) {
            FrescoInstrumenter.onEndWork(onBeginWork);
            throw th2;
        }
    }
}
