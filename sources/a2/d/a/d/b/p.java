package a2.d.a.d.b;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;
public class p implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    public final DataFetcherGenerator.FetcherReadyCallback a;
    public final g<?> b;
    public int c;
    public int d = -1;
    public Key e;
    public List<ModelLoader<File, ?>> f;
    public int g;
    public volatile ModelLoader.LoadData<?> h;
    public File i;
    public q j;

    public p(g<?> gVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.b = gVar;
        this.a = fetcherReadyCallback;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean a() {
        List<Key> a3 = this.b.a();
        if (a3.isEmpty()) {
            return false;
        }
        g<?> gVar = this.b;
        List<Class<?>> registeredResourceClasses = gVar.c.getRegistry().getRegisteredResourceClasses(gVar.d.getClass(), gVar.g, gVar.k);
        if (!registeredResourceClasses.isEmpty()) {
            while (true) {
                List<ModelLoader<File, ?>> list = this.f;
                if (list != null) {
                    if (this.g < list.size()) {
                        this.h = null;
                        boolean z = false;
                        while (!z) {
                            if (!(this.g < this.f.size())) {
                                break;
                            }
                            List<ModelLoader<File, ?>> list2 = this.f;
                            int i2 = this.g;
                            this.g = i2 + 1;
                            File file = this.i;
                            g<?> gVar2 = this.b;
                            this.h = list2.get(i2).buildLoadData(file, gVar2.e, gVar2.f, gVar2.i);
                            if (this.h != null && this.b.e(this.h.fetcher.getDataClass())) {
                                this.h.fetcher.loadData(this.b.o, this);
                                z = true;
                            }
                        }
                        return z;
                    }
                }
                int i3 = this.d + 1;
                this.d = i3;
                if (i3 >= registeredResourceClasses.size()) {
                    int i4 = this.c + 1;
                    this.c = i4;
                    if (i4 >= a3.size()) {
                        return false;
                    }
                    this.d = 0;
                }
                Key key = a3.get(this.c);
                Class<?> cls = registeredResourceClasses.get(this.d);
                Transformation<Z> d2 = this.b.d(cls);
                ArrayPool arrayPool = this.b.c.getArrayPool();
                g<?> gVar3 = this.b;
                this.j = new q(arrayPool, key, gVar3.n, gVar3.e, gVar3.f, d2, cls, gVar3.i);
                File file2 = gVar3.b().get(this.j);
                this.i = file2;
                if (file2 != null) {
                    this.e = key;
                    this.f = this.b.c.getRegistry().getModelLoaders(file2);
                    this.g = 0;
                }
            }
        } else if (File.class.equals(this.b.k)) {
            return false;
        } else {
            StringBuilder L = a.L("Failed to find any load path from ");
            L.append(this.b.d.getClass());
            L.append(" to ");
            L.append(this.b.k);
            throw new IllegalStateException(L.toString());
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.h;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object obj) {
        this.a.onDataFetcherReady(this.e, obj, this.h.fetcher, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception exc) {
        this.a.onDataFetcherFailed(this.j, exc, this.h.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }
}
