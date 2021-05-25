package a2.j.b.b.d1.i;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations;
import com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class f {
    public final HashMap<String, e> a;
    public final SparseArray<String> b;
    public final SparseBooleanArray c;
    public final SparseBooleanArray d;
    public c e;
    @Nullable
    public c f;

    public static final class a implements c {
        public static final String[] e = {"id", "key", "metadata"};
        public final DatabaseProvider a;
        public final SparseArray<e> b = new SparseArray<>();
        public String c;
        public String d;

        public a(DatabaseProvider databaseProvider) {
            this.a = databaseProvider;
        }

        public static void i(DatabaseProvider databaseProvider, String str) throws DatabaseIOException {
            try {
                String str2 = "ExoPlayerCacheIndex" + str;
                SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    VersionTable.removeVersion(writableDatabase, 1, str);
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + str2);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        @Override // a2.j.b.b.d1.i.f.c
        public void a(long j) {
            String hexString = Long.toHexString(j);
            this.c = hexString;
            this.d = a2.b.a.a.a.c3("ExoPlayerCacheIndex", hexString);
        }

        @Override // a2.j.b.b.d1.i.f.c
        public void b(HashMap<String, e> hashMap) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    j(writableDatabase);
                    for (e eVar : hashMap.values()) {
                        h(writableDatabase, eVar);
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.b.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        @Override // a2.j.b.b.d1.i.f.c
        public void c(e eVar, boolean z) {
            if (z) {
                this.b.delete(eVar.a);
            } else {
                this.b.put(eVar.a, null);
            }
        }

        @Override // a2.j.b.b.d1.i.f.c
        public boolean d() throws DatabaseIOException {
            if (VersionTable.getVersion(this.a.getReadableDatabase(), 1, (String) Assertions.checkNotNull(this.c)) != -1) {
                return true;
            }
            return false;
        }

        @Override // a2.j.b.b.d1.i.f.c
        public void delete() throws DatabaseIOException {
            i(this.a, (String) Assertions.checkNotNull(this.c));
        }

        @Override // a2.j.b.b.d1.i.f.c
        public void e(HashMap<String, e> hashMap) throws IOException {
            if (this.b.size() != 0) {
                try {
                    SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    for (int i = 0; i < this.b.size(); i++) {
                        try {
                            e valueAt = this.b.valueAt(i);
                            if (valueAt == null) {
                                writableDatabase.delete((String) Assertions.checkNotNull(this.d), "id = ?", new String[]{Integer.toString(this.b.keyAt(i))});
                            } else {
                                h(writableDatabase, valueAt);
                            }
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.b.clear();
                    writableDatabase.endTransaction();
                } catch (SQLException e2) {
                    throw new DatabaseIOException(e2);
                }
            }
        }

        @Override // a2.j.b.b.d1.i.f.c
        public void f(e eVar) {
            this.b.put(eVar.a, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x008e, code lost:
            if (r0 != null) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            r0.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
            r1.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0098, code lost:
            throw r2;
         */
        @Override // a2.j.b.b.d1.i.f.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(java.util.HashMap<java.lang.String, a2.j.b.b.d1.i.e> r12, android.util.SparseArray<java.lang.String> r13) throws java.io.IOException {
            /*
                r11 = this;
                android.util.SparseArray<a2.j.b.b.d1.i.e> r0 = r11.b
                int r0 = r0.size()
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L_0x000c
                r0 = 1
                goto L_0x000d
            L_0x000c:
                r0 = 0
            L_0x000d:
                com.google.android.exoplayer2.util.Assertions.checkState(r0)
                com.google.android.exoplayer2.database.DatabaseProvider r0 = r11.a     // Catch:{ SQLiteException -> 0x0099 }
                android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0099 }
                java.lang.String r3 = r11.c     // Catch:{ SQLiteException -> 0x0099 }
                java.lang.Object r3 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r3)     // Catch:{ SQLiteException -> 0x0099 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ SQLiteException -> 0x0099 }
                int r0 = com.google.android.exoplayer2.database.VersionTable.getVersion(r0, r2, r3)     // Catch:{ SQLiteException -> 0x0099 }
                if (r0 == r2) goto L_0x003c
                com.google.android.exoplayer2.database.DatabaseProvider r0 = r11.a     // Catch:{ SQLiteException -> 0x0099 }
                android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0099 }
                r0.beginTransactionNonExclusive()     // Catch:{ SQLiteException -> 0x0099 }
                r11.j(r0)     // Catch:{ all -> 0x0037 }
                r0.setTransactionSuccessful()     // Catch:{ all -> 0x0037 }
                r0.endTransaction()
                goto L_0x003c
            L_0x0037:
                r1 = move-exception
                r0.endTransaction()
                throw r1
            L_0x003c:
                com.google.android.exoplayer2.database.DatabaseProvider r0 = r11.a
                android.database.sqlite.SQLiteDatabase r3 = r0.getReadableDatabase()
                java.lang.String r0 = r11.d
                java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)
                r4 = r0
                java.lang.String r4 = (java.lang.String) r4
                java.lang.String[] r5 = a2.j.b.b.d1.i.f.a.e
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8, r9, r10)
            L_0x0056:
                boolean r3 = r0.moveToNext()     // Catch:{ all -> 0x008b }
                if (r3 == 0) goto L_0x0087
                int r3 = r0.getInt(r1)     // Catch:{ all -> 0x008b }
                java.lang.String r4 = r0.getString(r2)     // Catch:{ all -> 0x008b }
                r5 = 2
                byte[] r5 = r0.getBlob(r5)     // Catch:{ all -> 0x008b }
                java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x008b }
                r6.<init>(r5)     // Catch:{ all -> 0x008b }
                java.io.DataInputStream r5 = new java.io.DataInputStream     // Catch:{ all -> 0x008b }
                r5.<init>(r6)     // Catch:{ all -> 0x008b }
                com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata r5 = a2.j.b.b.d1.i.f.a(r5)     // Catch:{ all -> 0x008b }
                a2.j.b.b.d1.i.e r6 = new a2.j.b.b.d1.i.e     // Catch:{ all -> 0x008b }
                r6.<init>(r3, r4, r5)     // Catch:{ all -> 0x008b }
                r12.put(r4, r6)     // Catch:{ all -> 0x008b }
                int r3 = r6.a     // Catch:{ all -> 0x008b }
                java.lang.String r4 = r6.b     // Catch:{ all -> 0x008b }
                r13.put(r3, r4)     // Catch:{ all -> 0x008b }
                goto L_0x0056
            L_0x0087:
                r0.close()
                return
            L_0x008b:
                r1 = move-exception
                throw r1     // Catch:{ all -> 0x008d }
            L_0x008d:
                r2 = move-exception
                if (r0 == 0) goto L_0x0098
                r0.close()     // Catch:{ all -> 0x0094 }
                goto L_0x0098
            L_0x0094:
                r0 = move-exception
                r1.addSuppressed(r0)
            L_0x0098:
                throw r2
            L_0x0099:
                r0 = move-exception
                r12.clear()
                r13.clear()
                com.google.android.exoplayer2.database.DatabaseIOException r12 = new com.google.android.exoplayer2.database.DatabaseIOException
                r12.<init>(r0)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.d1.i.f.a.g(java.util.HashMap, android.util.SparseArray):void");
        }

        public final void h(SQLiteDatabase sQLiteDatabase, e eVar) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            f.b(eVar.e, new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(eVar.a));
            contentValues.put("key", eVar.b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) Assertions.checkNotNull(this.d), null, contentValues);
        }

        public final void j(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            VersionTable.setVersion(sQLiteDatabase, 1, (String) Assertions.checkNotNull(this.c), 1);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ((String) Assertions.checkNotNull(this.d)));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }
    }

    public static class b implements c {
        public final boolean a;
        @Nullable
        public final Cipher b;
        @Nullable
        public final SecretKeySpec c;
        @Nullable
        public final SecureRandom d;
        public final AtomicFile e;
        public boolean f;
        @Nullable
        public ReusableBufferedOutputStream g;

        public b(File file, @Nullable byte[] bArr, boolean z) {
            SecretKeySpec secretKeySpec;
            Cipher cipher;
            boolean z2 = false;
            Assertions.checkState(bArr != null || !z);
            SecureRandom secureRandom = null;
            if (bArr != null) {
                Assertions.checkArgument(bArr.length == 16 ? true : z2);
                try {
                    if (Util.SDK_INT == 18) {
                        try {
                            cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
                        } catch (Throwable unused) {
                        }
                        secretKeySpec = new SecretKeySpec(bArr, "AES");
                    }
                    cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                    throw new IllegalStateException(e2);
                }
            } else {
                Assertions.checkArgument(!z);
                cipher = null;
                secretKeySpec = null;
            }
            this.a = z;
            this.b = cipher;
            this.c = secretKeySpec;
            this.d = z ? new SecureRandom() : secureRandom;
            this.e = new AtomicFile(file);
        }

        @Override // a2.j.b.b.d1.i.f.c
        public void a(long j) {
        }

        @Override // a2.j.b.b.d1.i.f.c
        public void b(HashMap<String, e> hashMap) throws IOException {
            Throwable th;
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream startWrite = this.e.startWrite();
                ReusableBufferedOutputStream reusableBufferedOutputStream = this.g;
                if (reusableBufferedOutputStream == null) {
                    this.g = new ReusableBufferedOutputStream(startWrite);
                } else {
                    reusableBufferedOutputStream.reset(startWrite);
                }
                ReusableBufferedOutputStream reusableBufferedOutputStream2 = this.g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(reusableBufferedOutputStream2);
                try {
                    dataOutputStream2.writeInt(2);
                    dataOutputStream2.writeInt(this.a ? 1 : 0);
                    if (this.a) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) Util.castNonNull(this.d)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            ((Cipher) Util.castNonNull(this.b)).init(1, (Key) Util.castNonNull(this.c), new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(reusableBufferedOutputStream2, this.b));
                        } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                            throw new IllegalStateException(e2);
                        }
                    }
                    dataOutputStream2.writeInt(hashMap.size());
                    int i = 0;
                    for (e eVar : hashMap.values()) {
                        dataOutputStream2.writeInt(eVar.a);
                        dataOutputStream2.writeUTF(eVar.b);
                        f.b(eVar.e, dataOutputStream2);
                        i += h(eVar, 2);
                    }
                    dataOutputStream2.writeInt(i);
                    this.e.endWrite(dataOutputStream2);
                    Util.closeQuietly((Closeable) null);
                    this.f = false;
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = dataOutputStream2;
                    Util.closeQuietly(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                Util.closeQuietly(dataOutputStream);
                throw th;
            }
        }

        @Override // a2.j.b.b.d1.i.f.c
        public void c(e eVar, boolean z) {
            this.f = true;
        }

        @Override // a2.j.b.b.d1.i.f.c
        public boolean d() {
            return this.e.exists();
        }

        @Override // a2.j.b.b.d1.i.f.c
        public void delete() {
            this.e.delete();
        }

        @Override // a2.j.b.b.d1.i.f.c
        public void e(HashMap<String, e> hashMap) throws IOException {
            if (this.f) {
                b(hashMap);
            }
        }

        @Override // a2.j.b.b.d1.i.f.c
        public void f(e eVar) {
            this.f = true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00c1  */
        /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
        @Override // a2.j.b.b.d1.i.f.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(java.util.HashMap<java.lang.String, a2.j.b.b.d1.i.e> r11, android.util.SparseArray<java.lang.String> r12) {
            /*
                r10 = this;
                boolean r0 = r10.f
                r1 = 1
                r0 = r0 ^ r1
                com.google.android.exoplayer2.util.Assertions.checkState(r0)
                com.google.android.exoplayer2.util.AtomicFile r0 = r10.e
                boolean r0 = r0.exists()
                r2 = 0
                if (r0 != 0) goto L_0x0012
                goto L_0x00bf
            L_0x0012:
                r0 = 0
                java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                com.google.android.exoplayer2.util.AtomicFile r4 = r10.e     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                java.io.InputStream r4 = r4.openRead()     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                r4.<init>(r3)     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
                int r0 = r4.readInt()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                if (r0 < 0) goto L_0x00a8
                r5 = 2
                if (r0 <= r5) goto L_0x002e
                goto L_0x00a8
            L_0x002e:
                int r6 = r4.readInt()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r6 = r6 & r1
                if (r6 == 0) goto L_0x006b
                javax.crypto.Cipher r6 = r10.b     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                if (r6 != 0) goto L_0x003b
                goto L_0x00a8
            L_0x003b:
                r6 = 16
                byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r4.readFully(r6)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                javax.crypto.spec.IvParameterSpec r7 = new javax.crypto.spec.IvParameterSpec     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r7.<init>(r6)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                javax.crypto.Cipher r6 = r10.b     // Catch:{ InvalidKeyException -> 0x0064, InvalidAlgorithmParameterException -> 0x0062 }
                javax.crypto.spec.SecretKeySpec r8 = r10.c     // Catch:{ InvalidKeyException -> 0x0064, InvalidAlgorithmParameterException -> 0x0062 }
                java.lang.Object r8 = com.google.android.exoplayer2.util.Util.castNonNull(r8)     // Catch:{ InvalidKeyException -> 0x0064, InvalidAlgorithmParameterException -> 0x0062 }
                java.security.Key r8 = (java.security.Key) r8     // Catch:{ InvalidKeyException -> 0x0064, InvalidAlgorithmParameterException -> 0x0062 }
                r6.init(r5, r8, r7)     // Catch:{ InvalidKeyException -> 0x0064, InvalidAlgorithmParameterException -> 0x0062 }
                java.io.DataInputStream r5 = new java.io.DataInputStream
                javax.crypto.CipherInputStream r6 = new javax.crypto.CipherInputStream
                javax.crypto.Cipher r7 = r10.b
                r6.<init>(r3, r7)
                r5.<init>(r6)
                r4 = r5
                goto L_0x0071
            L_0x0062:
                r0 = move-exception
                goto L_0x0065
            L_0x0064:
                r0 = move-exception
            L_0x0065:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                r1.<init>(r0)
                throw r1
            L_0x006b:
                boolean r3 = r10.a
                if (r3 == 0) goto L_0x0071
                r10.f = r1
            L_0x0071:
                int r3 = r4.readInt()
                r5 = 0
                r6 = 0
            L_0x0077:
                if (r5 >= r3) goto L_0x0091
                a2.j.b.b.d1.i.e r7 = r10.i(r0, r4)
                java.lang.String r8 = r7.b
                r11.put(r8, r7)
                int r8 = r7.a
                java.lang.String r9 = r7.b
                r12.put(r8, r9)
                int r7 = r10.h(r7, r0)
                int r6 = r6 + r7
                int r5 = r5 + 1
                goto L_0x0077
            L_0x0091:
                int r0 = r4.readInt()
                int r3 = r4.read()
                r5 = -1
                if (r3 != r5) goto L_0x009e
                r3 = 1
                goto L_0x009f
            L_0x009e:
                r3 = 0
            L_0x009f:
                if (r0 != r6) goto L_0x00a8
                if (r3 != 0) goto L_0x00a4
                goto L_0x00a8
            L_0x00a4:
                com.google.android.exoplayer2.util.Util.closeQuietly(r4)
                goto L_0x00bf
            L_0x00a8:
                com.google.android.exoplayer2.util.Util.closeQuietly(r4)
                goto L_0x00be
            L_0x00ac:
                r11 = move-exception
                r0 = r4
                goto L_0x00b2
            L_0x00af:
                r0 = r4
                goto L_0x00b9
            L_0x00b1:
                r11 = move-exception
            L_0x00b2:
                if (r0 == 0) goto L_0x00b7
                com.google.android.exoplayer2.util.Util.closeQuietly(r0)
            L_0x00b7:
                throw r11
            L_0x00b8:
            L_0x00b9:
                if (r0 == 0) goto L_0x00be
                com.google.android.exoplayer2.util.Util.closeQuietly(r0)
            L_0x00be:
                r1 = 0
            L_0x00bf:
                if (r1 != 0) goto L_0x00cc
                r11.clear()
                r12.clear()
                com.google.android.exoplayer2.util.AtomicFile r11 = r10.e
                r11.delete()
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.d1.i.f.b.g(java.util.HashMap, android.util.SparseArray):void");
        }

        public final int h(e eVar, int i) {
            int hashCode = eVar.b.hashCode() + (eVar.a * 31);
            if (i >= 2) {
                return (hashCode * 31) + eVar.e.hashCode();
            }
            long a3 = g.a(eVar.e);
            return (hashCode * 31) + ((int) (a3 ^ (a3 >>> 32)));
        }

        public final e i(int i, DataInputStream dataInputStream) throws IOException {
            DefaultContentMetadata defaultContentMetadata;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i < 2) {
                long readLong = dataInputStream.readLong();
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                ContentMetadataMutations.setContentLength(contentMetadataMutations, readLong);
                defaultContentMetadata = DefaultContentMetadata.EMPTY.copyWithMutationsApplied(contentMetadataMutations);
            } else {
                defaultContentMetadata = f.a(dataInputStream);
            }
            return new e(readInt, readUTF, defaultContentMetadata);
        }
    }

    public interface c {
        void a(long j);

        void b(HashMap<String, e> hashMap) throws IOException;

        void c(e eVar, boolean z);

        boolean d() throws IOException;

        void delete() throws IOException;

        void e(HashMap<String, e> hashMap) throws IOException;

        void f(e eVar);

        void g(HashMap<String, e> hashMap, SparseArray<String> sparseArray) throws IOException;
    }

    public f(@Nullable DatabaseProvider databaseProvider, @Nullable File file, @Nullable byte[] bArr, boolean z, boolean z2) {
        Assertions.checkState((databaseProvider == null && file == null) ? false : true);
        this.a = new HashMap<>();
        this.b = new SparseArray<>();
        this.c = new SparseBooleanArray();
        this.d = new SparseBooleanArray();
        b bVar = null;
        a aVar = databaseProvider != null ? new a(databaseProvider) : null;
        bVar = file != null ? new b(new File(file, "cached_content_index.exi"), bArr, z) : bVar;
        if (aVar == null || (bVar != null && z2)) {
            this.e = (c) Util.castNonNull(bVar);
            this.f = aVar;
            return;
        }
        this.e = aVar;
        this.f = bVar;
    }

    public static DefaultContentMetadata a(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 >= 0) {
                int min = Math.min(readInt2, 10485760);
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                int i2 = 0;
                while (i2 != readInt2) {
                    int i3 = i2 + min;
                    bArr = Arrays.copyOf(bArr, i3);
                    dataInputStream.readFully(bArr, i2, min);
                    min = Math.min(readInt2 - i3, 10485760);
                    i2 = i3;
                }
                hashMap.put(readUTF, bArr);
            } else {
                throw new IOException(a2.b.a.a.a.M2("Invalid value size: ", readInt2));
            }
        }
        return new DefaultContentMetadata(hashMap);
    }

    public static void b(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> entrySet = defaultContentMetadata.entrySet();
        dataOutputStream.writeInt(entrySet.size());
        for (Map.Entry<String, byte[]> entry : entrySet) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Nullable
    public e c(String str) {
        return this.a.get(str);
    }

    public e d(String str) {
        int i;
        e eVar = this.a.get(str);
        if (eVar != null) {
            return eVar;
        }
        SparseArray<String> sparseArray = this.b;
        int size = sparseArray.size();
        int i2 = 0;
        if (size == 0) {
            i = 0;
        } else {
            i = sparseArray.keyAt(size - 1) + 1;
        }
        if (i < 0) {
            while (i2 < size && i2 == sparseArray.keyAt(i2)) {
                i2++;
            }
            i = i2;
        }
        e eVar2 = new e(i, str, DefaultContentMetadata.EMPTY);
        this.a.put(str, eVar2);
        this.b.put(i, str);
        this.d.put(i, true);
        this.e.f(eVar2);
        return eVar2;
    }

    @WorkerThread
    public void e(long j) throws IOException {
        c cVar;
        this.e.a(j);
        c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.a(j);
        }
        if (this.e.d() || (cVar = this.f) == null || !cVar.d()) {
            this.e.g(this.a, this.b);
        } else {
            this.f.g(this.a, this.b);
            this.e.b(this.a);
        }
        c cVar3 = this.f;
        if (cVar3 != null) {
            cVar3.delete();
            this.f = null;
        }
    }

    public void f(String str) {
        e eVar = this.a.get(str);
        if (eVar != null && eVar.c.isEmpty() && eVar.d.isEmpty()) {
            this.a.remove(str);
            int i = eVar.a;
            boolean z = this.d.get(i);
            this.e.c(eVar, z);
            if (z) {
                this.b.remove(i);
                this.d.delete(i);
                return;
            }
            this.b.put(i, null);
            this.c.put(i, true);
        }
    }

    @WorkerThread
    public void g() throws IOException {
        this.e.e(this.a);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.b.remove(this.c.keyAt(i));
        }
        this.c.clear();
        this.d.clear();
    }
}
