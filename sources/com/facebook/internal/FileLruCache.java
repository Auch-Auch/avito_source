package com.facebook.internal;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
public final class FileLruCache {
    public static final AtomicLong g = new AtomicLong();
    public final String a;
    public final Limits b;
    public final File c;
    public boolean d;
    public final Object e;
    public AtomicLong f = new AtomicLong(0);

    public static final class Limits {
        public int a = 1048576;
        public int b = 1024;
    }

    public class a implements g {
        public final /* synthetic */ long a;
        public final /* synthetic */ File b;
        public final /* synthetic */ String c;

        public a(long j, File file, String str) {
            this.a = j;
            this.b = file;
            this.c = str;
        }

        public void a() {
            if (this.a < FileLruCache.this.f.get()) {
                this.b.delete();
                return;
            }
            FileLruCache fileLruCache = FileLruCache.this;
            String str = this.c;
            File file = this.b;
            Objects.requireNonNull(fileLruCache);
            if (!file.renameTo(new File(fileLruCache.c, Utility.md5hash(str)))) {
                file.delete();
            }
            synchronized (fileLruCache.e) {
                if (!fileLruCache.d) {
                    fileLruCache.d = true;
                    FacebookSdk.getExecutor().execute(new a2.g.r.c(fileLruCache));
                }
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ File[] a;

        public b(FileLruCache fileLruCache, File[] fileArr) {
            this.a = fileArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (File file : this.a) {
                file.delete();
            }
        }
    }

    public static class c {
        public static final FilenameFilter a = new a();
        public static final FilenameFilter b = new b();

        public static class a implements FilenameFilter {
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return !str.startsWith("buffer");
            }
        }

        public static class b implements FilenameFilter {
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith("buffer");
            }
        }
    }

    public static class d extends OutputStream {
        public final OutputStream a;
        public final g b;

        public d(OutputStream outputStream, g gVar) {
            this.a = outputStream;
            this.b = gVar;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.a.close();
            } finally {
                ((a) this.b).a();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.a.flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.a.write(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.a.write(i);
        }
    }

    public static final class f implements Comparable<f> {
        public final File a;
        public final long b;

        public f(File file) {
            this.a = file;
            this.b = file.lastModified();
        }

        /* renamed from: a */
        public int compareTo(f fVar) {
            long j = this.b;
            long j2 = fVar.b;
            if (j < j2) {
                return -1;
            }
            if (j > j2) {
                return 1;
            }
            return this.a.compareTo(fVar.a);
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            return (obj instanceof f) && compareTo((f) obj) == 0;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return ((this.a.hashCode() + 1073) * 37) + ((int) (this.b % 2147483647L));
        }
    }

    public interface g {
    }

    public FileLruCache(String str, Limits limits) {
        File[] listFiles;
        this.a = str;
        this.b = limits;
        File file = new File(FacebookSdk.getCacheDir(), str);
        this.c = file;
        this.e = new Object();
        if ((file.mkdirs() || file.isDirectory()) && (listFiles = file.listFiles(c.b)) != null) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    public void clearCache() {
        File[] listFiles = this.c.listFiles(c.a);
        this.f.set(System.currentTimeMillis());
        if (listFiles != null) {
            FacebookSdk.getExecutor().execute(new b(this, listFiles));
        }
    }

    public InputStream get(String str) throws IOException {
        return get(str, null);
    }

    public String getLocation() {
        return this.c.getPath();
    }

    public InputStream interceptAndPut(String str, InputStream inputStream) throws IOException {
        return new e(inputStream, openPutStream(str));
    }

    public OutputStream openPutStream(String str) throws IOException {
        return openPutStream(str, null);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("{FileLruCache: tag:");
        L.append(this.a);
        L.append(" file:");
        L.append(this.c.getName());
        L.append("}");
        return L.toString();
    }

    public static final class e extends InputStream {
        public final InputStream a;
        public final OutputStream b;

        public e(InputStream inputStream, OutputStream outputStream) {
            this.a = inputStream;
            this.b = outputStream;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.a.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.a.close();
            } finally {
                this.b.close();
            }
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            int read = this.a.read(bArr);
            if (read > 0) {
                this.b.write(bArr, 0, read);
            }
            return read;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (j2 < j) {
                int read = this.a.read(bArr, 0, (int) Math.min(j - j2, (long) 1024));
                if (read > 0) {
                    this.b.write(bArr, 0, read);
                }
                if (read < 0) {
                    return j2;
                }
                j2 += (long) read;
            }
            return j2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int read = this.a.read();
            if (read >= 0) {
                this.b.write(read);
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.a.read(bArr, i, i2);
            if (read > 0) {
                this.b.write(bArr, i, read);
            }
            return read;
        }
    }

    public InputStream get(String str, String str2) throws IOException {
        File file = new File(this.c, Utility.md5hash(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                JSONObject I1 = AppCompatDelegateImpl.i.I1(bufferedInputStream);
                if (I1 == null) {
                    return null;
                }
                String optString = I1.optString("key");
                if (optString == null || !optString.equals(str)) {
                    bufferedInputStream.close();
                    return null;
                }
                String optString2 = I1.optString("tag", null);
                if ((str2 != null || optString2 == null) && (str2 == null || str2.equals(optString2))) {
                    long time = new Date().getTime();
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    Logger.log(loggingBehavior, "FileLruCache", "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                    file.setLastModified(time);
                    return bufferedInputStream;
                }
                bufferedInputStream.close();
                return null;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public OutputStream openPutStream(String str, String str2) throws IOException {
        File file = this.c;
        StringBuilder L = a2.b.a.a.a.L("buffer");
        L.append(Long.valueOf(g.incrementAndGet()).toString());
        File file2 = new File(file, L.toString());
        file2.delete();
        if (file2.createNewFile()) {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new d(new FileOutputStream(file2), new a(System.currentTimeMillis(), file2, str)), 8192);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    if (!Utility.isNullOrEmpty(str2)) {
                        jSONObject.put("tag", str2);
                    }
                    AppCompatDelegateImpl.i.m2(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e2) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    Logger.log(loggingBehavior, 5, "FileLruCache", "Error creating JSON header for cache file: " + e2);
                    throw new IOException(e2.getMessage());
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                Logger.log(loggingBehavior2, 5, "FileLruCache", "Error creating buffer output stream: " + e3);
                throw new IOException(e3.getMessage());
            }
        } else {
            StringBuilder L2 = a2.b.a.a.a.L("Could not create file at ");
            L2.append(file2.getAbsolutePath());
            throw new IOException(L2.toString());
        }
    }
}
