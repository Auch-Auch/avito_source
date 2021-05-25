package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    public final Uri a;
    public final ContentResolver b;
    public T c;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.b = contentResolver;
        this.a = uri;
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
    public final void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T loadResource = loadResource(this.a, this.b);
            this.c = loadResource;
            dataCallback.onDataReady(loadResource);
        } catch (FileNotFoundException e) {
            Log.isLoggable("LocalUriFetcher", 3);
            dataCallback.onLoadFailed(e);
        }
    }

    public abstract T loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
