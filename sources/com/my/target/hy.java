package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;
public final class hy {
    @NonNull
    public static final FilenameFilter b = new a();
    @NonNull
    public static final FilenameFilter c = new b();
    @Nullable
    public static volatile hy d;
    @NonNull
    public final File a;

    public static class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith("mytrg_");
        }
    }

    public static class b implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".mp4");
        }
    }

    public class c implements Comparator<File> {
        public c(hy hyVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return Long.valueOf(file2.lastModified()).compareTo(Long.valueOf(file.lastModified()));
        }
    }

    public hy(@NonNull File file) {
        this.a = file;
    }

    @Nullable
    @WorkerThread
    public static hy Z(@NonNull Context context) {
        hy hyVar = d;
        if (hyVar == null) {
            synchronized (hy.class) {
                hyVar = d;
                if (hyVar == null) {
                    File cacheDir = context.getCacheDir();
                    boolean z = true;
                    if (cacheDir != null && !cacheDir.exists()) {
                        z = cacheDir.mkdir();
                    }
                    if (!z) {
                        ae.c("DiskCache: unable to create cache dir");
                        return null;
                    }
                    File file = new File(cacheDir, "mytargetcache");
                    if (!file.exists()) {
                        z = file.mkdir();
                    }
                    if (!z) {
                        ae.c("DiskCache: unable to create cache dir");
                        return null;
                    } else if (file.isDirectory() && file.canWrite()) {
                        hy hyVar2 = new hy(file);
                        d = hyVar2;
                        hyVar = hyVar2;
                    }
                }
            }
        }
        return hyVar;
    }

    public final int a(@NonNull InputStream inputStream, @NonNull OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
        int i = 0;
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
            } catch (Throwable th) {
                ae.a(th.getMessage());
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (Throwable th2) {
            ae.a(th2.getMessage());
        }
        try {
            bufferedInputStream.close();
        } catch (Throwable th3) {
            ae.a(th3.getMessage());
        }
        return i;
        throw th;
        bufferedInputStream.close();
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b A[SYNTHETIC, Splitter:B:21:0x008b] */
    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.io.File a(int r6, @androidx.annotation.NonNull java.lang.String r7, boolean r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.sync()     // Catch:{ all -> 0x0090 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = ".json"
            java.io.File r6 = r5.d(r6, r0)     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r0.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = "DiskCache save text: "
            r0.append(r1)     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = r6.getPath()     // Catch:{ all -> 0x0090 }
            r0.append(r1)     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0090 }
            com.my.target.ae.a(r0)     // Catch:{ all -> 0x0090 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0090 }
            boolean r2 = r6.exists()     // Catch:{ all -> 0x0090 }
            if (r2 == 0) goto L_0x0036
            if (r8 == 0) goto L_0x0036
            long r0 = r6.lastModified()     // Catch:{ all -> 0x0090 }
        L_0x0036:
            r8 = 0
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0073 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0073 }
            r3.<init>(r6)     // Catch:{ all -> 0x0073 }
            java.lang.String r4 = "UTF-8"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)     // Catch:{ all -> 0x0073 }
            java.nio.charset.CharsetEncoder r4 = r4.newEncoder()     // Catch:{ all -> 0x0073 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0073 }
            r2.write(r7)     // Catch:{ all -> 0x0071 }
            r2.close()     // Catch:{ all -> 0x0071 }
            boolean r7 = r6.setLastModified(r0)
            if (r7 != 0) goto L_0x006f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "DiskCache: unable to set last modified to file "
            r7.append(r0)
            java.lang.String r0 = r6.getPath()
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.my.target.ae.a(r7)
        L_0x006f:
            monitor-exit(r5)
            return r6
        L_0x0071:
            r6 = move-exception
            goto L_0x0075
        L_0x0073:
            r6 = move-exception
            r2 = r8
        L_0x0075:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "DiskCache exception: "
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.my.target.ae.c(r6)
            if (r2 == 0) goto L_0x008e
            r2.close()     // Catch:{ all -> 0x008e }
        L_0x008e:
            monitor-exit(r5)
            return r8
        L_0x0090:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.hy.a(int, java.lang.String, boolean):java.io.File");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[SYNTHETIC, Splitter:B:20:0x0060] */
    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.io.File a(@androidx.annotation.NonNull java.io.InputStream r4, @androidx.annotation.NonNull java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.sync()     // Catch:{ all -> 0x0098 }
            java.lang.String r0 = ".img"
            java.io.File r5 = r3.d(r5, r0)     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r0.<init>()     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = "DiskCache save image: "
            r0.append(r1)     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = r5.getPath()     // Catch:{ all -> 0x0098 }
            r0.append(r1)     // Catch:{ all -> 0x0098 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0098 }
            com.my.target.ae.a(r0)     // Catch:{ all -> 0x0098 }
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0048 }
            r1.<init>(r5)     // Catch:{ all -> 0x0048 }
            r3.a(r4, r1)     // Catch:{ all -> 0x0046 }
            r1.close()     // Catch:{ all -> 0x002f }
            goto L_0x0044
        L_0x002f:
            r4 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "DiskCache exception: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            com.my.target.ae.c(r4)
        L_0x0044:
            monitor-exit(r3)
            return r5
        L_0x0046:
            r4 = move-exception
            goto L_0x004a
        L_0x0048:
            r4 = move-exception
            r1 = r0
        L_0x004a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x007b }
            r5.<init>()     // Catch:{ all -> 0x007b }
            java.lang.String r2 = "DiskCache exception: "
            r5.append(r2)     // Catch:{ all -> 0x007b }
            r5.append(r4)     // Catch:{ all -> 0x007b }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x007b }
            com.my.target.ae.c(r4)     // Catch:{ all -> 0x007b }
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ all -> 0x0064 }
            goto L_0x0079
        L_0x0064:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "DiskCache exception: "
            r5.append(r1)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.my.target.ae.c(r4)
        L_0x0079:
            monitor-exit(r3)
            return r0
        L_0x007b:
            r4 = move-exception
            if (r1 == 0) goto L_0x0097
            r1.close()     // Catch:{ all -> 0x0082 }
            goto L_0x0097
        L_0x0082:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "DiskCache exception: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            com.my.target.ae.c(r5)
        L_0x0097:
            throw r4
        L_0x0098:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.hy.a(java.io.InputStream, java.lang.String):java.io.File");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0102 A[SYNTHETIC, Splitter:B:42:0x0102] */
    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String a(int r6, long r7) {
        /*
        // Method dump skipped, instructions count: 315
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.hy.a(int, long):java.lang.String");
    }

    @Nullable
    @WorkerThread
    public String ae(@NonNull String str) {
        return c(str, ".mp4");
    }

    @Nullable
    @WorkerThread
    public String af(@NonNull String str) {
        return c(str, ".img");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[SYNTHETIC, Splitter:B:20:0x0060] */
    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.io.File b(@androidx.annotation.NonNull java.io.InputStream r4, @androidx.annotation.NonNull java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.sync()     // Catch:{ all -> 0x0098 }
            java.lang.String r0 = ".mp4"
            java.io.File r5 = r3.d(r5, r0)     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r0.<init>()     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = "DiskCache save video: "
            r0.append(r1)     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = r5.getPath()     // Catch:{ all -> 0x0098 }
            r0.append(r1)     // Catch:{ all -> 0x0098 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0098 }
            com.my.target.ae.a(r0)     // Catch:{ all -> 0x0098 }
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0048 }
            r1.<init>(r5)     // Catch:{ all -> 0x0048 }
            r3.a(r4, r1)     // Catch:{ all -> 0x0046 }
            r1.close()     // Catch:{ all -> 0x002f }
            goto L_0x0044
        L_0x002f:
            r4 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "DiskCache exception: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            com.my.target.ae.c(r4)
        L_0x0044:
            monitor-exit(r3)
            return r5
        L_0x0046:
            r4 = move-exception
            goto L_0x004a
        L_0x0048:
            r4 = move-exception
            r1 = r0
        L_0x004a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x007b }
            r5.<init>()     // Catch:{ all -> 0x007b }
            java.lang.String r2 = "DiskCache exception: "
            r5.append(r2)     // Catch:{ all -> 0x007b }
            r5.append(r4)     // Catch:{ all -> 0x007b }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x007b }
            com.my.target.ae.c(r4)     // Catch:{ all -> 0x007b }
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ all -> 0x0064 }
            goto L_0x0079
        L_0x0064:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "DiskCache exception: "
            r5.append(r1)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.my.target.ae.c(r4)
        L_0x0079:
            monitor-exit(r3)
            return r0
        L_0x007b:
            r4 = move-exception
            if (r1 == 0) goto L_0x0097
            r1.close()     // Catch:{ all -> 0x0082 }
            goto L_0x0097
        L_0x0082:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "DiskCache exception: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            com.my.target.ae.c(r5)
        L_0x0097:
            throw r4
        L_0x0098:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.hy.b(java.io.InputStream, java.lang.String):java.io.File");
    }

    @Nullable
    @WorkerThread
    public final synchronized String c(@NonNull String str, @NonNull String str2) {
        sync();
        File d2 = d(str, str2);
        if (d2.exists()) {
            ae.a("DiskCache get path: " + d2.getPath());
            try {
                return d2.getAbsolutePath();
            } catch (Throwable th) {
                ae.c("DiskCache exception: " + th);
            }
        }
        return null;
    }

    @NonNull
    public final File d(@NonNull String str, @NonNull String str2) {
        StringBuilder L = a2.b.a.a.a.L("mytrg_");
        L.append(hz.ah(str));
        L.append(str2);
        String sb = L.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.a.getAbsolutePath());
        return new File(a2.b.a.a.a.t(sb2, File.separator, sb));
    }

    @Nullable
    @WorkerThread
    public synchronized Bitmap getBitmap(@NonNull String str) {
        String str2;
        sync();
        File d2 = d(str, ".img");
        if (d2.exists()) {
            ae.a("DiskCache get image: " + d2.getPath());
            try {
                return BitmapFactory.decodeFile(d2.getAbsolutePath());
            } catch (OutOfMemoryError e) {
                System.gc();
                ae.c("DiskCache OOME, trying once again");
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    return BitmapFactory.decodeFile(d2.getAbsolutePath(), options);
                } catch (OutOfMemoryError unused) {
                    str2 = "DiskCache OOME, called twice: " + e;
                    ae.c(str2);
                    return null;
                }
            } catch (Throwable th) {
                str2 = "DiskCache exception: " + th;
                ae.c(str2);
                return null;
            }
        }
        return null;
    }

    @WorkerThread
    public synchronized void sync() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.a.lastModified() + 604800000 < currentTimeMillis) {
                File[] listFiles = this.a.listFiles(b);
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.isFile() && file.lastModified() + 604800000 < currentTimeMillis) {
                            ae.a("DiskCache: remove expired file " + file.getPath());
                            if (!file.delete()) {
                                ae.a("DiskCache: unable to delete file " + file.getAbsolutePath());
                            }
                        }
                    }
                }
                if (!this.a.setLastModified(currentTimeMillis)) {
                    ae.a("DiskCache: unable to set last modified to dir " + this.a.getAbsolutePath());
                }
            }
            File[] listFiles2 = this.a.listFiles(c);
            if (listFiles2 != null && listFiles2.length > 10) {
                Arrays.sort(listFiles2, new c(this));
                for (int length = listFiles2.length - 1; length >= 10; length--) {
                    String path = listFiles2[length].getPath();
                    ae.a("DiskCache: remove redundant video " + path);
                    if (!listFiles2[length].delete()) {
                        ae.a("DiskCache: unable to remove file " + path);
                    }
                }
            }
        } catch (Throwable th) {
            ae.c("DiskCache exception: " + th);
        }
    }
}
