package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
public class FileLoader<Data> implements ModelLoader<File, Data> {
    public final FileOpener<Data> a;

    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {
        public final FileOpener<Data> a;

        public Factory(FileOpener<Data> fileOpener) {
            this.a = fileOpener;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public final ModelLoader<File, Data> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.a);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }
    }

    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {

        public class a implements FileOpener<ParcelFileDescriptor> {
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public void close(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public Class<ParcelFileDescriptor> getDataClass() {
                return ParcelFileDescriptor.class;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public ParcelFileDescriptor open(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public FileDescriptorFactory() {
            super(new a());
        }
    }

    public interface FileOpener<Data> {
        void close(Data data) throws IOException;

        Class<Data> getDataClass();

        Data open(File file) throws FileNotFoundException;
    }

    public static class StreamFactory extends Factory<InputStream> {

        public class a implements FileOpener<InputStream> {
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
            public InputStream open(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public StreamFactory() {
            super(new a());
        }
    }

    public static final class a<Data> implements DataFetcher<Data> {
        public final File a;
        public final FileOpener<Data> b;
        public Data c;

        public a(File file, FileOpener<Data> fileOpener) {
            this.a = file;
            this.b = fileOpener;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            Data data = this.c;
            if (data != null) {
                try {
                    this.b.close(data);
                } catch (IOException unused) {
                }
            }
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
            try {
                Data open = this.b.open(this.a);
                this.c = open;
                dataCallback.onDataReady(open);
            } catch (FileNotFoundException e) {
                Log.isLoggable("FileLoader", 3);
                dataCallback.onLoadFailed(e);
            }
        }
    }

    public FileLoader(FileOpener<Data> fileOpener) {
        this.a = fileOpener;
    }

    public boolean handles(@NonNull File file) {
        return true;
    }

    public ModelLoader.LoadData<Data> buildLoadData(@NonNull File file, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(file), new a(file, this.a));
    }
}
