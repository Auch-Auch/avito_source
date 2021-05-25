package a2.d.a.d.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class a<Model, Data> implements ModelLoader<Model, Data> {
    public final List<ModelLoader<Model, Data>> a;
    public final Pools.Pool<List<Throwable>> b;

    /* renamed from: a2.d.a.d.c.a$a  reason: collision with other inner class name */
    public static class C0018a<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {
        public final List<DataFetcher<Data>> a;
        public final Pools.Pool<List<Throwable>> b;
        public int c = 0;
        public Priority d;
        public DataFetcher.DataCallback<? super Data> e;
        @Nullable
        public List<Throwable> f;
        public boolean g;

        public C0018a(@NonNull List<DataFetcher<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.b = pool;
            Preconditions.checkNotEmpty(list);
            this.a = list;
        }

        public final void a() {
            if (!this.g) {
                if (this.c < this.a.size() - 1) {
                    this.c++;
                    loadData(this.d, this.e);
                    return;
                }
                Preconditions.checkNotNull(this.f);
                this.e.onLoadFailed(new GlideException("Fetch failed", new ArrayList(this.f)));
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.g = true;
            for (DataFetcher<Data> dataFetcher : this.a) {
                dataFetcher.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            List<Throwable> list = this.f;
            if (list != null) {
                this.b.release(list);
            }
            this.f = null;
            for (DataFetcher<Data> dataFetcher : this.a) {
                dataFetcher.cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<Data> getDataClass() {
            return this.a.get(0).getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return this.a.get(0).getDataSource();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            this.d = priority;
            this.e = dataCallback;
            this.f = this.b.acquire();
            this.a.get(this.c).loadData(priority, this);
            if (this.g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onDataReady(@Nullable Data data) {
            if (data != null) {
                this.e.onDataReady(data);
            } else {
                a();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void onLoadFailed(@NonNull Exception exc) {
            ((List) Preconditions.checkNotNull(this.f)).add(exc);
            a();
        }
    }

    public a(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.a = list;
        this.b = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Model model, int i, int i2, @NonNull Options options) {
        ModelLoader.LoadData<Data> buildLoadData;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i3 = 0; i3 < size; i3++) {
            ModelLoader<Model, Data> modelLoader = this.a.get(i3);
            if (modelLoader.handles(model) && (buildLoadData = modelLoader.buildLoadData(model, i, i2, options)) != null) {
                key = buildLoadData.sourceKey;
                arrayList.add(buildLoadData.fetcher);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData<>(key, new C0018a(arrayList, this.b));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Model model) {
        for (ModelLoader<Model, Data> modelLoader : this.a) {
            if (modelLoader.handles(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("MultiModelLoader{modelLoaders=");
        L.append(Arrays.toString(this.a.toArray()));
        L.append('}');
        return L.toString();
    }
}
