package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    public final String a;
    public final AssetManager b;
    public T c;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.b = assetManager;
        this.a = str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T t = this.c;
        if (t != null) {
            try {
                close(t);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void close(T t) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T loadResource = loadResource(this.b, this.a);
            this.c = loadResource;
            dataCallback.onDataReady(loadResource);
        } catch (IOException e) {
            Log.isLoggable("AssetPathFetcher", 3);
            dataCallback.onLoadFailed(e);
        }
    }

    public abstract T loadResource(AssetManager assetManager, String str) throws IOException;
}
