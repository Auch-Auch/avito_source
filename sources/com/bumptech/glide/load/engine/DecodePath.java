package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class DecodePath<DataType, ResourceType, Transcode> {
    public final Class<DataType> a;
    public final List<? extends ResourceDecoder<DataType, ResourceType>> b;
    public final ResourceTranscoder<ResourceType, Transcode> c;
    public final Pools.Pool<List<Throwable>> d;
    public final String e;

    public interface a<ResourceType> {
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.a = cls;
        this.b = list;
        this.c = resourceTranscoder;
        this.d = pool;
        StringBuilder L = a2.b.a.a.a.L("Failed DecodePath{");
        L.append(cls.getSimpleName());
        L.append("->");
        L.append(cls2.getSimpleName());
        L.append("->");
        this.e = a2.b.a.a.a.E2(cls3, L, "}");
    }

    @NonNull
    public final Resource<ResourceType> a(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options, List<Throwable> list) throws GlideException {
        int size = this.b.size();
        Resource<ResourceType> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) this.b.get(i3);
            try {
                if (resourceDecoder.handles(dataRewinder.rewindAndGet(), options)) {
                    resource = resourceDecoder.decode(dataRewinder.rewindAndGet(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    String str = "Failed to decode data for " + resourceDecoder;
                }
                list.add(e2);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.e, new ArrayList(list));
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.bumptech.glide.load.engine.Resource] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bumptech.glide.load.engine.Resource<Transcode> decode(com.bumptech.glide.load.data.DataRewinder<DataType> r11, int r12, int r13, @androidx.annotation.NonNull com.bumptech.glide.load.Options r14, com.bumptech.glide.load.engine.DecodePath.a<ResourceType> r15) throws com.bumptech.glide.load.engine.GlideException {
        /*
        // Method dump skipped, instructions count: 269
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodePath.decode(com.bumptech.glide.load.data.DataRewinder, int, int, com.bumptech.glide.load.Options, com.bumptech.glide.load.engine.DecodePath$a):com.bumptech.glide.load.engine.Resource");
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("DecodePath{ dataClass=");
        L.append(this.a);
        L.append(", decoders=");
        L.append(this.b);
        L.append(", transcoder=");
        L.append(this.c);
        L.append('}');
        return L.toString();
    }
}
