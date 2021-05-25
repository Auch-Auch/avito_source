package com.bumptech.glide.load.engine;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LoadPath<Data, ResourceType, Transcode> {
    public final Class<Data> a;
    public final Pools.Pool<List<Throwable>> b;
    public final List<? extends DecodePath<Data, ResourceType, Transcode>> c;
    public final String d;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.a = cls;
        this.b = pool;
        this.c = (List) Preconditions.checkNotEmpty(list);
        StringBuilder L = a.L("Failed LoadPath{");
        L.append(cls.getSimpleName());
        L.append("->");
        L.append(cls2.getSimpleName());
        L.append("->");
        this.d = a.E2(cls3, L, "}");
    }

    public Class<Data> getDataClass() {
        return this.a;
    }

    public Resource<Transcode> load(DataRewinder<Data> dataRewinder, @NonNull Options options, int i, int i2, DecodePath.a<ResourceType> aVar) throws GlideException {
        List<Throwable> list = (List) Preconditions.checkNotNull(this.b.acquire());
        try {
            int size = this.c.size();
            Resource<Transcode> resource = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    resource = ((DecodePath) this.c.get(i3)).decode(dataRewinder, i, i2, options, aVar);
                } catch (GlideException e) {
                    list.add(e);
                }
                if (resource != null) {
                    break;
                }
            }
            if (resource != null) {
                return resource;
            }
            throw new GlideException(this.d, new ArrayList(list));
        } finally {
            this.b.release(list);
        }
    }

    public String toString() {
        StringBuilder L = a.L("LoadPath{decodePaths=");
        L.append(Arrays.toString(this.c.toArray()));
        L.append('}');
        return L.toString();
    }
}
