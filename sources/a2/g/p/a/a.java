package a2.g.p.a;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import java.util.concurrent.Callable;
public class a implements Callable<Boolean> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ CacheKey b;
    public final /* synthetic */ BufferedDiskCache c;

    public a(BufferedDiskCache bufferedDiskCache, Object obj, CacheKey cacheKey) {
        this.c = bufferedDiskCache;
        this.a = obj;
        this.b = cacheKey;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        Object onBeginWork = FrescoInstrumenter.onBeginWork(this.a, null);
        try {
            Boolean valueOf = Boolean.valueOf(this.c.c(this.b));
            FrescoInstrumenter.onEndWork(onBeginWork);
            return valueOf;
        } catch (Throwable th) {
            FrescoInstrumenter.onEndWork(onBeginWork);
            throw th;
        }
    }
}
