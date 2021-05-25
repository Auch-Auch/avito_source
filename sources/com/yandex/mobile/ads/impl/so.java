package com.yandex.mobile.ads.impl;

import android.os.SystemClock;
import com.yandex.mobile.ads.impl.rr;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
public final class so implements rr {
    private final Map<String, a> a = new LinkedHashMap(16, 0.75f, true);
    private long b = 0;
    private final File c;
    private final int d;

    public static class a {
        public long a;
        public String b;
        public String c;
        public long d;
        public long e;
        public long f;
        public long g;
        public Map<String, String> h;

        private a() {
        }

        public static a a(InputStream inputStream) throws IOException {
            a aVar = new a();
            if (so.a(inputStream) == 538247942) {
                aVar.b = so.c(inputStream);
                String c2 = so.c(inputStream);
                aVar.c = c2;
                if (c2.equals("")) {
                    aVar.c = null;
                }
                aVar.d = so.b(inputStream);
                aVar.e = so.b(inputStream);
                aVar.f = so.b(inputStream);
                aVar.g = so.b(inputStream);
                aVar.h = so.d(inputStream);
                return aVar;
            }
            throw new IOException();
        }

        public a(String str, rr.a aVar) {
            this.b = str;
            this.a = (long) aVar.a.length;
            this.c = aVar.b;
            this.d = aVar.c;
            this.e = aVar.d;
            this.f = aVar.e;
            this.g = aVar.f;
            this.h = aVar.g;
        }

        public final boolean a(OutputStream outputStream) {
            try {
                so.a(outputStream, 538247942);
                so.a(outputStream, this.b);
                String str = this.c;
                if (str == null) {
                    str = "";
                }
                so.a(outputStream, str);
                so.a(outputStream, this.d);
                so.a(outputStream, this.e);
                so.a(outputStream, this.f);
                so.a(outputStream, this.g);
                Map<String, String> map = this.h;
                if (map != null) {
                    so.a(outputStream, map.size());
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        so.a(outputStream, entry.getKey());
                        so.a(outputStream, entry.getValue());
                    }
                } else {
                    so.a(outputStream, 0);
                }
                outputStream.flush();
                return true;
            } catch (IOException e2) {
                sd.b("%s", e2.toString());
                return false;
            }
        }
    }

    public static final class b extends FilterInputStream {
        private int a;

        public /* synthetic */ b(InputStream inputStream, byte b) {
            this(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.a++;
            }
            return read;
        }

        private b(InputStream inputStream) {
            super(inputStream);
            this.a = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.a += read;
            }
            return read;
        }
    }

    public so(File file, int i) {
        this.c = file;
        this.d = i;
    }

    private synchronized void b(String str) {
        boolean delete = d(str).delete();
        a aVar = this.a.get(str);
        if (aVar != null) {
            this.b -= aVar.a;
            this.a.remove(str);
        }
        if (!delete) {
            sd.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }

    private static String c(String str) {
        int length = str.length() / 2;
        StringBuilder L = a2.b.a.a.a.L(String.valueOf(str.substring(0, length).hashCode()));
        L.append(String.valueOf(str.substring(length).hashCode()));
        return L.toString();
    }

    private File d(String str) {
        return new File(this.c, c(str));
    }

    private static int e(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c A[SYNTHETIC, Splitter:B:28:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009e A[SYNTHETIC, Splitter:B:39:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c0 A[SYNTHETIC, Splitter:B:50:0x00c0] */
    @Override // com.yandex.mobile.ads.impl.rr
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.yandex.mobile.ads.impl.rr.a a(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 213
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.so.a(java.lang.String):com.yandex.mobile.ads.impl.rr$a");
    }

    public static Map<String, String> d(InputStream inputStream) throws IOException {
        int a3 = a(inputStream);
        Map<String, String> emptyMap = a3 == 0 ? Collections.emptyMap() : new HashMap<>(a3);
        for (int i = 0; i < a3; i++) {
            emptyMap.put(c(inputStream).intern(), c(inputStream).intern());
        }
        return emptyMap;
    }

    public static String c(InputStream inputStream) throws IOException {
        return new String(a(inputStream, (int) b(inputStream)), "UTF-8");
    }

    public static long b(InputStream inputStream) throws IOException {
        return ((((long) e(inputStream)) & 255) << 0) | 0 | ((((long) e(inputStream)) & 255) << 8) | ((((long) e(inputStream)) & 255) << 16) | ((((long) e(inputStream)) & 255) << 24) | ((((long) e(inputStream)) & 255) << 32) | ((((long) e(inputStream)) & 255) << 40) | ((((long) e(inputStream)) & 255) << 48) | ((255 & ((long) e(inputStream))) << 56);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0056 A[SYNTHETIC, Splitter:B:26:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0066 A[SYNTHETIC] */
    @Override // com.yandex.mobile.ads.impl.rr
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.io.File r0 = r8.c     // Catch:{ all -> 0x006b }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x006b }
            r1 = 0
            if (r0 != 0) goto L_0x0024
            java.io.File r0 = r8.c     // Catch:{ all -> 0x006b }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "Unable to create cache dir %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x006b }
            java.io.File r3 = r8.c     // Catch:{ all -> 0x006b }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x006b }
            r2[r1] = r3     // Catch:{ all -> 0x006b }
            com.yandex.mobile.ads.impl.sd.c(r0, r2)     // Catch:{ all -> 0x006b }
        L_0x0022:
            monitor-exit(r8)
            return
        L_0x0024:
            java.io.File r0 = r8.c
            java.io.File[] r0 = r0.listFiles()
            if (r0 != 0) goto L_0x002e
            monitor-exit(r8)
            return
        L_0x002e:
            int r2 = r0.length
        L_0x002f:
            if (r1 >= r2) goto L_0x0069
            r3 = r0[r1]
            r4 = 0
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0053 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ all -> 0x0053 }
            r6.<init>(r3)     // Catch:{ all -> 0x0053 }
            r5.<init>(r6)     // Catch:{ all -> 0x0053 }
            com.yandex.mobile.ads.impl.so$a r4 = com.yandex.mobile.ads.impl.so.a.a(r5)     // Catch:{ all -> 0x0051 }
            long r6 = r3.length()     // Catch:{ all -> 0x0051 }
            r4.a = r6     // Catch:{ all -> 0x0051 }
            java.lang.String r6 = r4.b     // Catch:{ all -> 0x0051 }
            r8.a(r6, r4)     // Catch:{ all -> 0x0051 }
            r5.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x0066
        L_0x0051:
            r4 = r5
            goto L_0x0054
        L_0x0053:
        L_0x0054:
            if (r3 == 0) goto L_0x0061
            r3.delete()     // Catch:{ all -> 0x005a }
            goto L_0x0061
        L_0x005a:
            r0 = move-exception
            if (r4 == 0) goto L_0x0060
            r4.close()     // Catch:{ IOException -> 0x0060 }
        L_0x0060:
            throw r0
        L_0x0061:
            if (r4 == 0) goto L_0x0066
            r4.close()
        L_0x0066:
            int r1 = r1 + 1
            goto L_0x002f
        L_0x0069:
            monitor-exit(r8)
            return
        L_0x006b:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.so.a():void");
    }

    @Override // com.yandex.mobile.ads.impl.rr
    public final synchronized void a(String str, rr.a aVar) {
        long j;
        Iterator<Map.Entry<String, a>> it;
        long length = (long) aVar.a.length;
        if (this.b + length >= ((long) this.d)) {
            if (sd.b) {
                sd.a("Pruning old cache entries.", new Object[0]);
            }
            long j2 = this.b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, a>> it2 = this.a.entrySet().iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    j = j2;
                    break;
                }
                a value = it2.next().getValue();
                if (d(value.b).delete()) {
                    j = j2;
                    it = it2;
                    this.b -= value.a;
                } else {
                    j = j2;
                    it = it2;
                    String str2 = value.b;
                    sd.b("Could not delete cache entry for key=%s, filename=%s", str2, c(str2));
                }
                it.remove();
                i++;
                if (((float) (this.b + length)) < ((float) this.d) * 0.9f) {
                    break;
                }
                j2 = j;
                it2 = it;
            }
            if (sd.b) {
                sd.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
        File d2 = d(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(d2));
            a aVar2 = new a(str, aVar);
            if (aVar2.a(bufferedOutputStream)) {
                bufferedOutputStream.write(aVar.a);
                bufferedOutputStream.close();
                a(str, aVar2);
            } else {
                bufferedOutputStream.close();
                sd.b("Failed to write header for %s", d2.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException unused) {
            if (!d2.delete()) {
                sd.b("Could not clean up file %s", d2.getAbsolutePath());
            }
        }
    }

    private void a(String str, a aVar) {
        if (!this.a.containsKey(str)) {
            this.b += aVar.a;
        } else {
            this.b = (aVar.a - this.a.get(str).a) + this.b;
        }
        this.a.put(str, aVar);
    }

    private static byte[] a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    public static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    public static int a(InputStream inputStream) throws IOException {
        return (e(inputStream) << 24) | (e(inputStream) << 0) | 0 | (e(inputStream) << 8) | (e(inputStream) << 16);
    }

    public static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    public static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }
}
