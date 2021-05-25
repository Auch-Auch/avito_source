package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
public abstract class UnpackingSoSource extends DirectorySoSource {
    @Nullable
    public String[] a;
    public final Map<String, Object> b = new HashMap();
    public final Context mContext;
    @Nullable
    public String mCorruptedLib;

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        public static final DsoManifest a(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    Dso[] dsoArr = new Dso[readInt];
                    for (int i = 0; i < readInt; i++) {
                        dsoArr[i] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new DsoManifest(dsoArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            int i = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i < dsoArr.length) {
                    dataOutput.writeUTF(dsoArr[i].name);
                    dataOutput.writeUTF(this.dsos[i].hash);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final class InputDso implements Closeable {
        public final InputStream content;
        public final Dso dso;

        public InputDso(Dso dso2, InputStream inputStream) {
            this.dso = dso2;
            this.content = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.content.close();
        }
    }

    public static abstract class InputDsoIterator implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        public abstract InputDso next() throws IOException;
    }

    public static abstract class Unpacker implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;
    }

    public class a implements Runnable {
        public final /* synthetic */ File a;
        public final /* synthetic */ byte[] b;
        public final /* synthetic */ DsoManifest c;
        public final /* synthetic */ File d;
        public final /* synthetic */ FileLocker e;

        public a(File file, byte[] bArr, DsoManifest dsoManifest, File file2, FileLocker fileLocker) {
            this.a = file;
            this.b = bArr;
            this.c = dsoManifest;
            this.d = file2;
            this.e = fileLocker;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0060, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
            r2.addSuppressed(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
            throw r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0072, code lost:
            r2.addSuppressed(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0075, code lost:
            throw r4;
         */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                java.lang.String r0 = " (from syncer thread)"
                java.lang.String r1 = "releasing dso store lock for "
                java.lang.String r2 = "rw"
                java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ all -> 0x005c }
                java.io.File r4 = r6.a     // Catch:{ all -> 0x005c }
                r3.<init>(r4, r2)     // Catch:{ all -> 0x005c }
                byte[] r4 = r6.b     // Catch:{ all -> 0x006a }
                r3.write(r4)     // Catch:{ all -> 0x006a }
                long r4 = r3.getFilePointer()     // Catch:{ all -> 0x006a }
                r3.setLength(r4)     // Catch:{ all -> 0x006a }
                r3.close()
                java.io.File r3 = new java.io.File
                com.facebook.soloader.UnpackingSoSource r4 = com.facebook.soloader.UnpackingSoSource.this
                java.io.File r4 = r4.soDirectory
                java.lang.String r5 = "dso_manifest"
                r3.<init>(r4, r5)
                java.io.RandomAccessFile r4 = new java.io.RandomAccessFile
                r4.<init>(r3, r2)
                com.facebook.soloader.UnpackingSoSource$DsoManifest r2 = r6.c     // Catch:{ all -> 0x005e }
                r2.write(r4)     // Catch:{ all -> 0x005e }
                r4.close()
                com.facebook.soloader.UnpackingSoSource r2 = com.facebook.soloader.UnpackingSoSource.this
                java.io.File r2 = r2.soDirectory
                com.facebook.soloader.SysUtil.a(r2)
                java.io.File r2 = r6.d
                r3 = 1
                com.facebook.soloader.UnpackingSoSource.g(r2, r3)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0091 }
                r2.<init>()     // Catch:{ IOException -> 0x0091 }
                r2.append(r1)     // Catch:{ IOException -> 0x0091 }
                com.facebook.soloader.UnpackingSoSource r1 = com.facebook.soloader.UnpackingSoSource.this     // Catch:{ IOException -> 0x0091 }
                java.io.File r1 = r1.soDirectory     // Catch:{ IOException -> 0x0091 }
                r2.append(r1)     // Catch:{ IOException -> 0x0091 }
                r2.append(r0)     // Catch:{ IOException -> 0x0091 }
                r2.toString()     // Catch:{ IOException -> 0x0091 }
                com.facebook.soloader.FileLocker r0 = r6.e     // Catch:{ IOException -> 0x0091 }
                r0.close()     // Catch:{ IOException -> 0x0091 }
                return
            L_0x005c:
                r2 = move-exception
                goto L_0x0076
            L_0x005e:
                r2 = move-exception
                throw r2     // Catch:{ all -> 0x0060 }
            L_0x0060:
                r3 = move-exception
                r4.close()     // Catch:{ all -> 0x0065 }
                goto L_0x0069
            L_0x0065:
                r4 = move-exception
                r2.addSuppressed(r4)
            L_0x0069:
                throw r3
            L_0x006a:
                r2 = move-exception
                throw r2     // Catch:{ all -> 0x006c }
            L_0x006c:
                r4 = move-exception
                r3.close()     // Catch:{ all -> 0x0071 }
                goto L_0x0075
            L_0x0071:
                r3 = move-exception
                r2.addSuppressed(r3)
            L_0x0075:
                throw r4
            L_0x0076:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r1)
                com.facebook.soloader.UnpackingSoSource r1 = com.facebook.soloader.UnpackingSoSource.this
                java.io.File r1 = r1.soDirectory
                r3.append(r1)
                r3.append(r0)
                r3.toString()
                com.facebook.soloader.FileLocker r0 = r6.e
                r0.close()
                throw r2
            L_0x0091:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.a.run():void");
        }
    }

    public UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        this.mContext = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r4 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(java.io.File r3, byte r4) throws java.io.IOException {
        /*
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "rw"
            r0.<init>(r3, r1)
            r1 = 0
            r0.seek(r1)     // Catch:{ all -> 0x0021 }
            r0.write(r4)     // Catch:{ all -> 0x0021 }
            long r3 = r0.getFilePointer()     // Catch:{ all -> 0x0021 }
            r0.setLength(r3)     // Catch:{ all -> 0x0021 }
            java.io.FileDescriptor r3 = r0.getFD()     // Catch:{ all -> 0x0021 }
            r3.sync()     // Catch:{ all -> 0x0021 }
            r0.close()
            return
        L_0x0021:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x002c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.g(java.io.File, byte):void");
    }

    public static File getSoStorePath(Context context, String str) {
        return new File(a2.b.a.a.a.u(new StringBuilder(), context.getApplicationInfo().dataDir, "/", str));
    }

    public final void b(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals("dso_state") && !str.equals("dso_lock") && !str.equals("dso_deps") && !str.equals("dso_manifest")) {
                    boolean z = false;
                    int i = 0;
                    while (!z && i < dsoArr.length) {
                        if (dsoArr[i].name.equals(str)) {
                            z = true;
                        }
                        i++;
                    }
                    if (!z) {
                        File file = new File(this.soDirectory, str);
                        String str2 = "deleting unaccounted-for file " + file;
                        SysUtil.dumbDeleteRecursive(file);
                    }
                }
            }
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("unable to list directory ");
        L.append(this.soDirectory);
        throw new IOException(L.toString());
    }

    public final void c(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        String str = inputDso.dso.name;
        if (this.soDirectory.setWritable(true, true)) {
            File file = new File(this.soDirectory, inputDso.dso.name);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException unused) {
                String str2 = "error overwriting " + file + " trying to delete and start over";
                SysUtil.dumbDeleteRecursive(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            try {
                int available = inputDso.content.available();
                if (available > 1) {
                    SysUtil.fallocateIfSupported(randomAccessFile.getFD(), (long) available);
                }
                InputStream inputStream = inputDso.content;
                int i = 0;
                while (i < Integer.MAX_VALUE) {
                    int read = inputStream.read(bArr, 0, Math.min(bArr.length, Integer.MAX_VALUE - i));
                    if (read == -1) {
                        break;
                    }
                    randomAccessFile.write(bArr, 0, read);
                    i += read;
                }
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (file.setExecutable(true, false)) {
                    randomAccessFile.close();
                    return;
                }
                throw new IOException("cannot make file executable: " + file);
            } catch (IOException e) {
                SysUtil.dumbDeleteRecursive(file);
                throw e;
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        } else {
            StringBuilder L = a2.b.a.a.a.L("cannot make directory writable for us: ");
            L.append(this.soDirectory);
            throw new IOException(L.toString());
        }
    }

    public final Object d(String str) {
        Object obj;
        synchronized (this.b) {
            obj = this.b.get(str);
            if (obj == null) {
                obj = new Object();
                this.b.put(str, obj);
            }
        }
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r11.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bd, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00be, code lost:
        if (r8 != null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c4, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c5, code lost:
        r11.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c8, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00cb, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00cc, code lost:
        if (r0 != null) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d2, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d3, code lost:
        r11.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00d6, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d9, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00de, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00df, code lost:
        r11.addSuppressed(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00e2, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(com.facebook.soloader.FileLocker r11, int r12, byte[] r13) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 227
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.e(com.facebook.soloader.FileLocker, int, byte[]):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0093, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0098, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0099, code lost:
        r9.addSuppressed(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009c, code lost:
        throw r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[Catch:{ all -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(byte r9, com.facebook.soloader.UnpackingSoSource.DsoManifest r10, com.facebook.soloader.UnpackingSoSource.InputDsoIterator r11) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.Class r0 = r8.getClass()
            r0.getName()
            java.io.File r0 = new java.io.File
            java.io.File r1 = r8.soDirectory
            java.lang.String r2 = "dso_manifest"
            r0.<init>(r1, r2)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "rw"
            r1.<init>(r0, r2)
            r0 = 1
            if (r9 != r0) goto L_0x0022
            com.facebook.soloader.UnpackingSoSource$DsoManifest r9 = com.facebook.soloader.UnpackingSoSource.DsoManifest.a(r1)     // Catch:{ Exception -> 0x0022 }
            goto L_0x0023
        L_0x001f:
            r9 = move-exception
            goto L_0x0092
        L_0x0022:
            r9 = 0
        L_0x0023:
            r2 = 0
            if (r9 != 0) goto L_0x002d
            com.facebook.soloader.UnpackingSoSource$DsoManifest r9 = new com.facebook.soloader.UnpackingSoSource$DsoManifest     // Catch:{ all -> 0x001f }
            com.facebook.soloader.UnpackingSoSource$Dso[] r3 = new com.facebook.soloader.UnpackingSoSource.Dso[r2]     // Catch:{ all -> 0x001f }
            r9.<init>(r3)     // Catch:{ all -> 0x001f }
        L_0x002d:
            com.facebook.soloader.UnpackingSoSource$Dso[] r10 = r10.dsos     // Catch:{ all -> 0x001f }
            r8.b(r10)     // Catch:{ all -> 0x001f }
            r10 = 32768(0x8000, float:4.5918E-41)
            byte[] r10 = new byte[r10]     // Catch:{ all -> 0x001f }
        L_0x0037:
            boolean r3 = r11.hasNext()     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x0087
            com.facebook.soloader.UnpackingSoSource$InputDso r3 = r11.next()     // Catch:{ all -> 0x001f }
            r4 = 1
            r5 = 0
        L_0x0043:
            if (r4 == 0) goto L_0x006e
            com.facebook.soloader.UnpackingSoSource$Dso[] r6 = r9.dsos     // Catch:{ all -> 0x006c }
            int r7 = r6.length     // Catch:{ all -> 0x006c }
            if (r5 >= r7) goto L_0x006e
            r6 = r6[r5]     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r6.name     // Catch:{ all -> 0x006c }
            com.facebook.soloader.UnpackingSoSource$Dso r7 = r3.dso     // Catch:{ all -> 0x006c }
            java.lang.String r7 = r7.name     // Catch:{ all -> 0x006c }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x006c }
            if (r6 == 0) goto L_0x0069
            com.facebook.soloader.UnpackingSoSource$Dso[] r6 = r9.dsos     // Catch:{ all -> 0x006c }
            r6 = r6[r5]     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r6.hash     // Catch:{ all -> 0x006c }
            com.facebook.soloader.UnpackingSoSource$Dso r7 = r3.dso     // Catch:{ all -> 0x006c }
            java.lang.String r7 = r7.hash     // Catch:{ all -> 0x006c }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x006c }
            if (r6 == 0) goto L_0x0069
            r4 = 0
        L_0x0069:
            int r5 = r5 + 1
            goto L_0x0043
        L_0x006c:
            r9 = move-exception
            goto L_0x0074
        L_0x006e:
            if (r4 == 0) goto L_0x0081
            r8.c(r3, r10)     // Catch:{ all -> 0x006c }
            goto L_0x0081
        L_0x0074:
            throw r9     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r10 = move-exception
            if (r3 == 0) goto L_0x0080
            r3.close()     // Catch:{ all -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r11 = move-exception
            r9.addSuppressed(r11)
        L_0x0080:
            throw r10
        L_0x0081:
            if (r3 == 0) goto L_0x0037
            r3.close()
            goto L_0x0037
        L_0x0087:
            r1.close()
            java.lang.Class r9 = r8.getClass()
            r9.getName()
            return
        L_0x0092:
            throw r9     // Catch:{ all -> 0x0093 }
        L_0x0093:
            r10 = move-exception
            r1.close()     // Catch:{ all -> 0x0098 }
            goto L_0x009c
        L_0x0098:
            r11 = move-exception
            r9.addSuppressed(r11)
        L_0x009c:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.f(byte, com.facebook.soloader.UnpackingSoSource$DsoManifest, com.facebook.soloader.UnpackingSoSource$InputDsoIterator):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r1 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getDepsBlock() throws java.io.IOException {
        /*
            r5 = this;
            android.os.Parcel r0 = android.os.Parcel.obtain()
            com.facebook.soloader.UnpackingSoSource$Unpacker r1 = r5.makeUnpacker()
            com.facebook.soloader.UnpackingSoSource$DsoManifest r2 = r1.getDsoManifest()     // Catch:{ all -> 0x0036 }
            com.facebook.soloader.UnpackingSoSource$Dso[] r2 = r2.dsos     // Catch:{ all -> 0x0036 }
            r3 = 1
            r0.writeByte(r3)     // Catch:{ all -> 0x0036 }
            int r3 = r2.length     // Catch:{ all -> 0x0036 }
            r0.writeInt(r3)     // Catch:{ all -> 0x0036 }
            r3 = 0
        L_0x0017:
            int r4 = r2.length     // Catch:{ all -> 0x0036 }
            if (r3 >= r4) goto L_0x002b
            r4 = r2[r3]     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = r4.name     // Catch:{ all -> 0x0036 }
            r0.writeString(r4)     // Catch:{ all -> 0x0036 }
            r4 = r2[r3]     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = r4.hash     // Catch:{ all -> 0x0036 }
            r0.writeString(r4)     // Catch:{ all -> 0x0036 }
            int r3 = r3 + 1
            goto L_0x0017
        L_0x002b:
            r1.close()
            byte[] r1 = r0.marshall()
            r0.recycle()
            return r1
        L_0x0036:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r2 = move-exception
            if (r1 == 0) goto L_0x0043
            r1.close()     // Catch:{ all -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r1 = move-exception
            r0.addSuppressed(r1)
        L_0x0043:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.getDepsBlock():byte[]");
    }

    @Override // com.facebook.soloader.SoSource
    public String[] getSoSourceAbis() {
        String[] strArr = this.a;
        return strArr == null ? super.getSoSourceAbis() : strArr;
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int loadLibraryFrom;
        synchronized (d(str)) {
            loadLibraryFrom = loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
        }
        return loadLibraryFrom;
    }

    public abstract Unpacker makeUnpacker() throws IOException;

    @Override // com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        String str = "releasing dso store lock for ";
        File file = this.soDirectory;
        if (file.mkdirs() || file.isDirectory()) {
            FileLocker lock = FileLocker.lock(new File(this.soDirectory, "dso_lock"));
            try {
                String str2 = "locked dso store " + this.soDirectory;
                if (e(lock, i, getDepsBlock())) {
                    lock = null;
                } else {
                    String str3 = "dso store is up-to-date: " + this.soDirectory;
                }
                if (lock == null) {
                    StringBuilder L = a2.b.a.a.a.L("not releasing dso store lock for ");
                    L.append(this.soDirectory);
                    L.append(" (syncer thread started)");
                    L.toString();
                }
            } finally {
                if (lock != null) {
                    StringBuilder L2 = a2.b.a.a.a.L(str);
                    L2.append(this.soDirectory);
                    L2.toString();
                    lock.close();
                } else {
                    StringBuilder L3 = a2.b.a.a.a.L("not releasing dso store lock for ");
                    L3.append(this.soDirectory);
                    L3.append(" (syncer thread started)");
                    L3.toString();
                }
            }
        } else {
            throw new IOException(a2.b.a.a.a.Y2("cannot mkdir: ", file));
        }
    }

    public void setSoSourceAbis(String[] strArr) {
        this.a = strArr;
    }

    public UnpackingSoSource(Context context, File file) {
        super(file, 1);
        this.mContext = context;
    }

    public synchronized void prepare(String str) throws IOException {
        synchronized (d(str)) {
            this.mCorruptedLib = str;
            prepare(2);
        }
    }
}
