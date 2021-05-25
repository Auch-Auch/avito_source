package a2.d.a.d.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.ModelLoader;
public class s implements DataFetcher.DataCallback<Object> {
    public final /* synthetic */ ModelLoader.LoadData a;
    public final /* synthetic */ t b;

    public s(t tVar, ModelLoader.LoadData loadData) {
        this.b = tVar;
        this.a = loadData;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(@Nullable Object obj) {
        t tVar = this.b;
        ModelLoader.LoadData<?> loadData = this.a;
        ModelLoader.LoadData<?> loadData2 = tVar.f;
        if (loadData2 != null && loadData2 == loadData) {
            t tVar2 = this.b;
            ModelLoader.LoadData loadData3 = this.a;
            DiskCacheStrategy diskCacheStrategy = tVar2.a.p;
            if (obj == null || !diskCacheStrategy.isDataCacheable(loadData3.fetcher.getDataSource())) {
                DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = tVar2.b;
                Key key = loadData3.sourceKey;
                DataFetcher<Data> dataFetcher = loadData3.fetcher;
                fetcherReadyCallback.onDataFetcherReady(key, obj, dataFetcher, dataFetcher.getDataSource(), tVar2.g);
                return;
            }
            tVar2.e = obj;
            tVar2.b.reschedule();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception exc) {
        t tVar = this.b;
        ModelLoader.LoadData<?> loadData = this.a;
        ModelLoader.LoadData<?> loadData2 = tVar.f;
        if (loadData2 != null && loadData2 == loadData) {
            t tVar2 = this.b;
            ModelLoader.LoadData loadData3 = this.a;
            DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = tVar2.b;
            e eVar = tVar2.g;
            DataFetcher<Data> dataFetcher = loadData3.fetcher;
            fetcherReadyCallback.onDataFetcherFailed(eVar, exc, dataFetcher, dataFetcher.getDataSource());
        }
    }
}
