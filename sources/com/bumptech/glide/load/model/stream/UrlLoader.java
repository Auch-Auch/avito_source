package com.bumptech.glide.load.model.stream;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.net.URL;
public class UrlLoader implements ModelLoader<URL, InputStream> {
    public final ModelLoader<GlideUrl, InputStream> a;

    public static class StreamFactory implements ModelLoaderFactory<URL, InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<URL, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlLoader(multiModelLoaderFactory.build(GlideUrl.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public UrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.a = modelLoader;
    }

    public boolean handles(@NonNull URL url) {
        return true;
    }

    public ModelLoader.LoadData<InputStream> buildLoadData(@NonNull URL url, int i, int i2, @NonNull Options options) {
        return this.a.buildLoadData(new GlideUrl(url), i, i2, options);
    }
}
