package com.google.firebase.messaging;

import a2.b.a.a.a;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_messaging.zzh;
import com.google.android.gms.internal.firebase_messaging.zzi;
import com.google.android.gms.internal.firebase_messaging.zzk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
public class ImageDownload implements Closeable {
    @Nullable
    private volatile InputStream connectionInputStream;
    @Nullable
    private Task<Bitmap> task;
    private final URL url;

    private ImageDownload(URL url2) {
        this.url = url2;
    }

    private byte[] blockingDownloadBytes() throws IOException {
        URLConnection openConnection = this.url.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                this.connectionInputStream = inputStream;
                byte[] zza = zzh.zza(zzh.zza(inputStream, 1048577));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable(Constants.TAG, 2)) {
                    int length = zza.length;
                    String.valueOf(this.url).length();
                }
                if (zza.length <= 1048576) {
                    return zza;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                zzk.zza(th, th);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }

    @Nullable
    public static ImageDownload create(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ImageDownload(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Not downloading image, bad URL: ".concat(valueOf);
            } else {
                new String("Not downloading image, bad URL: ");
            }
            return null;
        }
    }

    public Bitmap blockingDownload() throws IOException {
        String.valueOf(this.url).length();
        byte[] blockingDownloadBytes = blockingDownloadBytes();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(blockingDownloadBytes, 0, blockingDownloadBytes.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                String.valueOf(this.url).length();
            }
            return decodeByteArray;
        }
        String valueOf = String.valueOf(this.url);
        throw new IOException(a.r2(valueOf.length() + 24, "Failed to decode image: ", valueOf));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            zzi.zza(this.connectionInputStream);
        } catch (NullPointerException unused) {
        }
    }

    public Task<Bitmap> getTask() {
        return (Task) Preconditions.checkNotNull(this.task);
    }

    public void start(Executor executor) {
        this.task = Tasks.call(executor, new Callable(this) { // from class: com.google.firebase.messaging.ImageDownload$$Lambda$0
            private final ImageDownload arg$1;

            {
                this.arg$1 = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.arg$1.blockingDownload();
            }
        });
    }
}
