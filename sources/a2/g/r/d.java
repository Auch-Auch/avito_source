package a2.g.r;

import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
public class d {
    public static final String a = "d";
    public static FileLruCache b;

    public static class a extends BufferedInputStream {
        public HttpURLConnection a;

        public a(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, 8192);
            this.a = httpURLConnection;
        }

        @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() throws IOException {
            super.close();
            Utility.disconnectQuietly(this.a);
        }
    }

    public static synchronized FileLruCache a() throws IOException {
        FileLruCache fileLruCache;
        synchronized (d.class) {
            if (b == null) {
                b = new FileLruCache(a, new FileLruCache.Limits());
            }
            fileLruCache = b;
        }
        return fileLruCache;
    }

    public static InputStream b(Uri uri, Context context) {
        if (uri != null && d(uri)) {
            try {
                return a().get(uri.toString());
            } catch (IOException e) {
                Logger.log(LoggingBehavior.CACHE, 5, a, e.toString());
            }
        }
        return null;
    }

    public static InputStream c(Context context, HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        Uri parse = Uri.parse(httpURLConnection.getURL().toString());
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            return d(parse) ? a().interceptAndPut(parse.toString(), new a(inputStream, httpURLConnection)) : inputStream;
        } catch (IOException unused) {
            return inputStream;
        }
    }

    public static boolean d(Uri uri) {
        if (uri == null) {
            return false;
        }
        String host = uri.getHost();
        if (host.endsWith("fbcdn.net")) {
            return true;
        }
        if (!host.startsWith("fbcdn") || !host.endsWith("akamaihd.net")) {
            return false;
        }
        return true;
    }
}
