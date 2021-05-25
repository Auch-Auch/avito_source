package a2.d.a.d.b;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;
public class t implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
    public final g<?> a;
    public final DataFetcherGenerator.FetcherReadyCallback b;
    public int c;
    public d d;
    public Object e;
    public volatile ModelLoader.LoadData<?> f;
    public e g;

    public t(g<?> gVar, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.a = gVar;
        this.b = fetcherReadyCallback;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean a() {
        Object obj = this.e;
        if (obj != null) {
            this.e = null;
            long logTime = LogTime.getLogTime();
            try {
                Encoder sourceEncoder = this.a.c.getRegistry().getSourceEncoder(obj);
                f fVar = new f(sourceEncoder, obj, this.a.i);
                Key key = this.f.sourceKey;
                g<?> gVar = this.a;
                this.g = new e(key, gVar.n);
                gVar.b().put(this.g, fVar);
                if (Log.isLoggable("SourceGenerator", 2)) {
                    String str = "Finished encoding source to cache, key: " + this.g + ", data: " + obj + ", encoder: " + sourceEncoder + ", duration: " + LogTime.getElapsedMillis(logTime);
                }
                this.f.fetcher.cleanup();
                this.d = new d(Collections.singletonList(this.f.sourceKey), this.a, this);
            } catch (Throwable th) {
                this.f.fetcher.cleanup();
                throw th;
            }
        }
        d dVar = this.d;
        if (dVar != null && dVar.a()) {
            return true;
        }
        this.d = null;
        this.f = null;
        boolean z = false;
        while (!z) {
            if (!(this.c < this.a.c().size())) {
                break;
            }
            List<ModelLoader.LoadData<?>> c2 = this.a.c();
            int i = this.c;
            this.c = i + 1;
            this.f = c2.get(i);
            if (this.f != null && (this.a.p.isDataCacheable(this.f.fetcher.getDataSource()) || this.a.e(this.f.fetcher.getDataClass()))) {
                this.f.fetcher.loadData(this.a.o, new s(this, this.f));
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.f;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.b.onDataFetcherFailed(key, exc, dataFetcher, this.f.fetcher.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.b.onDataFetcherReady(key, obj, dataFetcher, this.f.fetcher.getDataSource(), key);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        throw new UnsupportedOperationException();
    }
}
