package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
@RequiresApi(29)
public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {
    public final Context a;
    public final ModelLoader<File, DataT> b;
    public final ModelLoader<Uri, DataT> c;
    public final Class<DataT> d;

    @RequiresApi(29)
    public static final class FileDescriptorFactory extends a<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    @RequiresApi(29)
    public static final class InputStreamFactory extends a<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    public static abstract class a<DataT> implements ModelLoaderFactory<Uri, DataT> {
        public final Context a;
        public final Class<DataT> b;

        public a(Context context, Class<DataT> cls) {
            this.a = context;
            this.b = cls;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public final ModelLoader<Uri, DataT> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new QMediaStoreUriLoader(this.a, multiModelLoaderFactory.build(File.class, this.b), multiModelLoaderFactory.build(Uri.class, this.b), this.b);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }
    }

    public static final class b<DataT> implements DataFetcher<DataT> {
        public static final String[] k = {"_data"};
        public final Context a;
        public final ModelLoader<File, DataT> b;
        public final ModelLoader<Uri, DataT> c;
        public final Uri d;
        public final int e;
        public final int f;
        public final Options g;
        public final Class<DataT> h;
        public volatile boolean i;
        @Nullable
        public volatile DataFetcher<DataT> j;

        public b(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Uri uri, int i2, int i3, Options options, Class<DataT> cls) {
            this.a = context.getApplicationContext();
            this.b = modelLoader;
            this.c = modelLoader2;
            this.d = uri;
            this.e = i2;
            this.f = i3;
            this.g = options;
            this.h = cls;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: com.bumptech.glide.load.data.DataFetcher<Data>, com.bumptech.glide.load.data.DataFetcher<DataT> */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x007a  */
        @androidx.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.bumptech.glide.load.data.DataFetcher<DataT> a() throws java.io.FileNotFoundException {
            /*
                r9 = this;
                boolean r0 = android.os.Environment.isExternalStorageLegacy()
                r1 = 0
                if (r0 == 0) goto L_0x007e
                com.bumptech.glide.load.model.ModelLoader<java.io.File, DataT> r0 = r9.b
                android.net.Uri r8 = r9.d
                android.content.Context r2 = r9.a     // Catch:{ all -> 0x0077 }
                android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0077 }
                java.lang.String[] r4 = com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.b.k     // Catch:{ all -> 0x0077 }
                r5 = 0
                r6 = 0
                r7 = 0
                r3 = r8
                android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0077 }
                if (r2 == 0) goto L_0x005d
                boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x0074 }
                if (r3 == 0) goto L_0x005d
                java.lang.String r3 = "_data"
                int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x0074 }
                java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x0074 }
                boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0074 }
                if (r4 != 0) goto L_0x0046
                java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0074 }
                r4.<init>(r3)     // Catch:{ all -> 0x0074 }
                r2.close()
                int r2 = r9.e
                int r3 = r9.f
                com.bumptech.glide.load.Options r5 = r9.g
                com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r0.buildLoadData(r4, r2, r3, r5)
                goto L_0x00a2
            L_0x0046:
                java.io.FileNotFoundException r0 = new java.io.FileNotFoundException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "File path was empty in media store for: "
                r1.append(r3)
                r1.append(r8)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x005d:
                java.io.FileNotFoundException r0 = new java.io.FileNotFoundException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Failed to media store entry for: "
                r1.append(r3)
                r1.append(r8)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0074:
                r0 = move-exception
                r1 = r2
                goto L_0x0078
            L_0x0077:
                r0 = move-exception
            L_0x0078:
                if (r1 == 0) goto L_0x007d
                r1.close()
            L_0x007d:
                throw r0
            L_0x007e:
                android.content.Context r0 = r9.a
                java.lang.String r2 = "android.permission.ACCESS_MEDIA_LOCATION"
                int r0 = r0.checkSelfPermission(r2)
                if (r0 != 0) goto L_0x008a
                r0 = 1
                goto L_0x008b
            L_0x008a:
                r0 = 0
            L_0x008b:
                if (r0 == 0) goto L_0x0094
                android.net.Uri r0 = r9.d
                android.net.Uri r0 = android.provider.MediaStore.setRequireOriginal(r0)
                goto L_0x0096
            L_0x0094:
                android.net.Uri r0 = r9.d
            L_0x0096:
                com.bumptech.glide.load.model.ModelLoader<android.net.Uri, DataT> r2 = r9.c
                int r3 = r9.e
                int r4 = r9.f
                com.bumptech.glide.load.Options r5 = r9.g
                com.bumptech.glide.load.model.ModelLoader$LoadData r0 = r2.buildLoadData(r0, r3, r4, r5)
            L_0x00a2:
                if (r0 == 0) goto L_0x00a6
                com.bumptech.glide.load.data.DataFetcher<Data> r1 = r0.fetcher
            L_0x00a6:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.b.a():com.bumptech.glide.load.data.DataFetcher");
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.i = true;
            DataFetcher<DataT> dataFetcher = this.j;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            DataFetcher<DataT> dataFetcher = this.j;
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<DataT> getDataClass() {
            return this.h;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super DataT> dataCallback) {
            try {
                DataFetcher<DataT> a3 = a();
                if (a3 == null) {
                    dataCallback.onLoadFailed(new IllegalArgumentException("Failed to build fetcher for: " + this.d));
                    return;
                }
                this.j = a3;
                if (this.i) {
                    cancel();
                } else {
                    a3.loadData(priority, dataCallback);
                }
            } catch (FileNotFoundException e2) {
                dataCallback.onLoadFailed(e2);
            }
        }
    }

    public QMediaStoreUriLoader(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Class<DataT> cls) {
        this.a = context.getApplicationContext();
        this.b = modelLoader;
        this.c = modelLoader2;
        this.d = cls;
    }

    public ModelLoader.LoadData<DataT> buildLoadData(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new b(this.a, this.b, this.c, uri, i, i2, options, this.d));
    }

    public boolean handles(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && MediaStoreUtil.isMediaStoreUri(uri);
    }
}
