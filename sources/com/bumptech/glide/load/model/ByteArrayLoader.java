package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {
    public final Converter<Data> a;

    public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {

        public class a implements Converter<ByteBuffer> {
            public a(ByteBufferFactory byteBufferFactory) {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
            public ByteBuffer convert(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
            public Class<ByteBuffer> getDataClass() {
                return ByteBuffer.class;
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<byte[], ByteBuffer> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new a(this));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public interface Converter<Data> {
        Data convert(byte[] bArr);

        Class<Data> getDataClass();
    }

    public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {

        public class a implements Converter<InputStream> {
            public a(StreamFactory streamFactory) {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
            public InputStream convert(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<byte[], InputStream> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new a(this));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class a<Data> implements DataFetcher<Data> {
        public final byte[] a;
        public final Converter<Data> b;

        public a(byte[] bArr, Converter<Data> converter) {
            this.a = bArr;
            this.b = converter;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<Data> getDataClass() {
            return this.b.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            dataCallback.onDataReady(this.b.convert(this.a));
        }
    }

    public ByteArrayLoader(Converter<Data> converter) {
        this.a = converter;
    }

    public boolean handles(@NonNull byte[] bArr) {
        return true;
    }

    public ModelLoader.LoadData<Data> buildLoadData(@NonNull byte[] bArr, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(bArr), new a(bArr, this.a));
    }
}
