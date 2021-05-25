package androidx.browser.browseractions;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.FileProvider;
import androidx.core.util.AtomicFile;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
@RestrictTo({RestrictTo.Scope.LIBRARY})
@Deprecated
public final class BrowserServiceFileProvider extends FileProvider {
    public static Object e = new Object();

    public static class a implements Runnable {
        public final /* synthetic */ ContentResolver a;
        public final /* synthetic */ Uri b;
        public final /* synthetic */ ResolvableFuture c;

        public a(ContentResolver contentResolver, Uri uri, ResolvableFuture resolvableFuture) {
            this.a = contentResolver;
            this.b = uri;
            this.c = resolvableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ParcelFileDescriptor openFileDescriptor = this.a.openFileDescriptor(this.b, "r");
                if (openFileDescriptor == null) {
                    this.c.setException(new FileNotFoundException());
                    return;
                }
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
                openFileDescriptor.close();
                if (decodeFileDescriptor == null) {
                    this.c.setException(new IOException("File could not be decoded."));
                } else {
                    this.c.set(decodeFileDescriptor);
                }
            } catch (IOException e) {
                this.c.setException(e);
            }
        }
    }

    public static class b extends AsyncTask<Void, Void, Void> {
        public static final long b;
        public static final long c;
        public static final long d;
        public final Context a;

        static {
            TimeUnit timeUnit = TimeUnit.DAYS;
            b = timeUnit.toMillis(7);
            c = timeUnit.toMillis(7);
            d = timeUnit.toMillis(1);
        }

        public b(Context context) {
            this.a = context.getApplicationContext();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void[] voidArr) {
            long j;
            SharedPreferences sharedPreferences = this.a.getSharedPreferences(this.a.getPackageName() + ".image_provider", 0);
            boolean z = true;
            if (!(System.currentTimeMillis() > sharedPreferences.getLong("last_cleanup_time", System.currentTimeMillis()) + c)) {
                return null;
            }
            synchronized (BrowserServiceFileProvider.e) {
                File file = new File(this.a.getFilesDir(), "image_provider");
                if (!file.exists()) {
                    return null;
                }
                File[] listFiles = file.listFiles();
                long currentTimeMillis = System.currentTimeMillis() - b;
                for (File file2 : listFiles) {
                    if (file2.getName().endsWith("..png")) {
                        if (file2.lastModified() < currentTimeMillis && !file2.delete()) {
                            String str = "Fail to delete image: " + file2.getAbsoluteFile();
                            z = false;
                        }
                    }
                }
                if (z) {
                    j = System.currentTimeMillis();
                } else {
                    j = (System.currentTimeMillis() - c) + d;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong("last_cleanup_time", j);
                edit.apply();
                return null;
            }
        }
    }

    public static class c extends AsyncTask<String, Void, Void> {
        public final Context a;
        public final String b;
        public final Bitmap c;
        public final Uri d;
        public final ResolvableFuture<Uri> e;

        public c(Context context, String str, Bitmap bitmap, Uri uri, ResolvableFuture<Uri> resolvableFuture) {
            this.a = context.getApplicationContext();
            this.b = str;
            this.c = bitmap;
            this.d = uri;
            this.e = resolvableFuture;
        }

        public final void a(File file) {
            FileOutputStream fileOutputStream;
            IOException e2;
            if (Build.VERSION.SDK_INT >= 22) {
                AtomicFile atomicFile = new AtomicFile(file);
                try {
                    fileOutputStream = atomicFile.startWrite();
                    try {
                        this.c.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.close();
                        atomicFile.finishWrite(fileOutputStream);
                        this.e.set(this.d);
                    } catch (IOException e3) {
                        e2 = e3;
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    fileOutputStream = null;
                    atomicFile.failWrite(fileOutputStream);
                    this.e.setException(e2);
                }
            } else {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    this.c.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                    fileOutputStream2.close();
                    this.e.set(this.d);
                } catch (IOException e5) {
                    this.e.setException(e5);
                }
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public Void doInBackground(String[] strArr) {
            File file = new File(this.a.getFilesDir(), "image_provider");
            synchronized (BrowserServiceFileProvider.e) {
                if (file.exists() || file.mkdir()) {
                    File file2 = new File(file, this.b + ".png");
                    if (file2.exists()) {
                        this.e.set(this.d);
                    } else {
                        a(file2);
                    }
                    file2.setLastModified(System.currentTimeMillis());
                    return null;
                }
                this.e.setException(new IOException("Could not create file directory."));
                return null;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r3) {
            new b(this.a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    public static void grantReadPermission(@NonNull Intent intent, @Nullable List<Uri> list, @NonNull Context context) {
        if (!(list == null || list.size() == 0)) {
            ContentResolver contentResolver = context.getContentResolver();
            intent.addFlags(1);
            ClipData newUri = ClipData.newUri(contentResolver, "image_provider_uris", list.get(0));
            for (int i = 1; i < list.size(); i++) {
                newUri.addItem(new ClipData.Item(list.get(i)));
            }
            intent.setClipData(newUri);
        }
    }

    @NonNull
    public static ListenableFuture<Bitmap> loadBitmap(@NonNull ContentResolver contentResolver, @NonNull Uri uri) {
        ResolvableFuture create = ResolvableFuture.create();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new a(contentResolver, uri, create));
        return create;
    }

    @NonNull
    @UiThread
    public static ResolvableFuture<Uri> saveBitmap(@NonNull Context context, @NonNull Bitmap bitmap, @NonNull String str, int i) {
        StringBuilder Q = a2.b.a.a.a.Q(str, "_");
        Q.append(Integer.toString(i));
        String sb = Q.toString();
        String e3 = a2.b.a.a.a.e3("image_provider_images/", sb, ".png");
        Uri.Builder scheme = new Uri.Builder().scheme("content");
        Uri build = scheme.authority(context.getPackageName() + ".image_provider").path(e3).build();
        ResolvableFuture<Uri> create = ResolvableFuture.create();
        new c(context, sb, bitmap, build, create).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        return create;
    }
}
