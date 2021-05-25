package a2.d.a.d.b;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;
public class d implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    public final List<Key> a;
    public final g<?> b;
    public final DataFetcherGenerator.FetcherReadyCallback c;
    public int d = -1;
    public Key e;
    public List<ModelLoader<File, ?>> f;
    public int g;
    public volatile ModelLoader.LoadData<?> h;
    public File i;

    public d(g<?> gVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        List<Key> a3 = gVar.a();
        this.a = a3;
        this.b = gVar;
        this.c = fetcherReadyCallback;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean a() {
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
                        g<?> gVar = this.b;
                        this.h = list2.get(i2).buildLoadData(file, gVar.e, gVar.f, gVar.i);
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
            if (i3 >= this.a.size()) {
                return false;
            }
            Key key = this.a.get(this.d);
            g<?> gVar2 = this.b;
            File file2 = gVar2.b().get(new e(key, gVar2.n));
            this.i = file2;
            if (file2 != null) {
                this.e = key;
                this.f = this.b.c.getRegistry().getModelLoaders(file2);
                this.g = 0;
            }
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
        this.c.onDataFetcherReady(this.e, obj, this.h.fetcher, DataSource.DATA_DISK_CACHE, this.e);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception exc) {
        this.c.onDataFetcherFailed(this.e, exc, this.h.fetcher, DataSource.DATA_DISK_CACHE);
    }

    public d(List<Key> list, g<?> gVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.a = list;
        this.b = gVar;
        this.c = fetcherReadyCallback;
    }
}
