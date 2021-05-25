package a2.g.p.b;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Predicate;
import com.facebook.imagepipeline.core.ImagePipeline;
public class a implements Predicate<CacheKey> {
    public final /* synthetic */ Uri a;

    public a(ImagePipeline imagePipeline, Uri uri) {
        this.a = uri;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.facebook.common.internal.Predicate
    public boolean apply(CacheKey cacheKey) {
        return cacheKey.containsUri(this.a);
    }
}
