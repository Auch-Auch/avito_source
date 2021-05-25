package com.google.android.play.core.internal;

import a2.b.a.a.a;
import a2.j.b.e.a.d.b0;
import a2.j.b.e.a.d.f0;
import a2.j.b.e.a.d.o;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
public final class h {
    public static int a(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                String valueOf = String.valueOf(Long.toHexString((long) i));
                throw new IllegalArgumentException(valueOf.length() == 0 ? new String("Unknown signature algorithm: 0x") : "Unknown signature algorithm: 0x".concat(valueOf));
        }
    }

    public static long a(ByteBuffer byteBuffer) {
        j(byteBuffer);
        return ((long) byteBuffer.getInt(byteBuffer.position() + 16)) & BodyPartID.bodyIdMax;
    }

    public static String a(String str, String str2) {
        return a.u(new StringBuilder(str.length() + 1 + String.valueOf(str2).length()), str, ":", str2);
    }

    public static String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(a.G1(str.length(), 2, String.valueOf(str2).length(), String.valueOf(str3).length()));
        a.n1(sb, str, ":", str2, ":");
        sb.append(str3);
        return sb.toString();
    }

    public static void a(ByteBuffer byteBuffer, long j) {
        j(byteBuffer);
        int position = byteBuffer.position() + 16;
        if (j < 0 || j > BodyPartID.bodyIdMax) {
            throw new IllegalArgumentException(a.q2(47, "uint32 value of out range: ", j));
        }
        byteBuffer.putInt(byteBuffer.position() + position, (int) j);
    }

    public static long b(ByteBuffer byteBuffer) {
        j(byteBuffer);
        return ((long) byteBuffer.getInt(byteBuffer.position() + 12)) & BodyPartID.bodyIdMax;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.nio.ByteBuffer, java.lang.Long> b(java.io.RandomAccessFile r8, int r9) throws java.io.IOException {
        /*
            long r0 = r8.length()
            r2 = 22
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x007e
            long r2 = (long) r9
            r4 = -22
            long r4 = r4 + r0
            long r2 = java.lang.Math.min(r2, r4)
            int r9 = (int) r2
            r2 = 22
            int r9 = r9 + r2
            java.nio.ByteBuffer r9 = java.nio.ByteBuffer.allocate(r9)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            r9.order(r3)
            int r3 = r9.capacity()
            long r3 = (long) r3
            long r0 = r0 - r3
            r8.seek(r0)
            byte[] r3 = r9.array()
            int r4 = r9.arrayOffset()
            int r5 = r9.capacity()
            r8.readFully(r3, r4, r5)
            j(r9)
            int r8 = r9.capacity()
            r3 = -1
            if (r8 < r2) goto L_0x0064
            int r8 = r8 + -22
            r2 = 65535(0xffff, float:9.1834E-41)
            int r2 = java.lang.Math.min(r8, r2)
            r4 = 0
        L_0x004b:
            if (r4 >= r2) goto L_0x0064
            int r5 = r8 - r4
            int r6 = r9.getInt(r5)
            r7 = 101010256(0x6054b50, float:2.506985E-35)
            if (r6 != r7) goto L_0x0061
            int r6 = r5 + 20
            short r6 = r9.getShort(r6)
            char r6 = (char) r6
            if (r6 == r4) goto L_0x0065
        L_0x0061:
            int r4 = r4 + 1
            goto L_0x004b
        L_0x0064:
            r5 = -1
        L_0x0065:
            if (r5 == r3) goto L_0x007e
            r9.position(r5)
            java.nio.ByteBuffer r8 = r9.slice()
            java.nio.ByteOrder r9 = java.nio.ByteOrder.LITTLE_ENDIAN
            r8.order(r9)
            long r2 = (long) r5
            long r0 = r0 + r2
            java.lang.Long r9 = java.lang.Long.valueOf(r0)
            android.util.Pair r8 = android.util.Pair.create(r8, r9)
            return r8
        L_0x007e:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.h.b(java.io.RandomAccessFile, int):android.util.Pair");
    }

    public static void c(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) (i >> 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012a A[Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012b A[Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.X509Certificate[] d(java.nio.ByteBuffer r21, java.util.Map<java.lang.Integer, byte[]> r22, java.security.cert.CertificateFactory r23) throws java.lang.SecurityException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 660
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.h.d(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    public static byte[][] e(int[] iArr, o[] oVarArr) throws DigestException {
        int i;
        int length;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        while (true) {
            if (i2 >= 3) {
                break;
            }
            j2 += (oVarArr[i2].a() + 1048575) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            i2++;
        }
        if (j2 < 2097151) {
            int i3 = (int) j2;
            byte[][] bArr = new byte[iArr.length][];
            int i4 = 0;
            while (true) {
                length = iArr.length;
                if (i4 >= length) {
                    break;
                }
                byte[] bArr2 = new byte[((i(iArr[i4]) * i3) + 5)];
                bArr2[0] = 90;
                c(i3, bArr2);
                bArr[i4] = bArr2;
                i4++;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            for (int i5 = 0; i5 < iArr.length; i5++) {
                String g = g(iArr[i5]);
                try {
                    messageDigestArr[i5] = MessageDigest.getInstance(g);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(g.concat(" digest not supported"), e);
                }
            }
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            for (i = 3; i6 < i; i = 3) {
                o oVar = oVarArr[i6];
                long a = oVar.a();
                long j3 = j;
                while (a > j) {
                    int min = (int) Math.min(a, (long) PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                    c(min, bArr3);
                    int i9 = 0;
                    while (i9 < length) {
                        messageDigestArr[i9].update(bArr3);
                        i9++;
                        i6 = i6;
                    }
                    try {
                        oVar.a(messageDigestArr, j3, min);
                        int i10 = 0;
                        while (i10 < iArr.length) {
                            int i11 = iArr[i10];
                            byte[] bArr4 = bArr[i10];
                            int i12 = i(i11);
                            MessageDigest messageDigest = messageDigestArr[i10];
                            int digest = messageDigest.digest(bArr4, (i7 * i12) + 5, i12);
                            if (digest == i12) {
                                i10++;
                                bArr3 = bArr3;
                                oVar = oVar;
                                messageDigestArr = messageDigestArr;
                            } else {
                                String algorithm = messageDigest.getAlgorithm();
                                StringBuilder sb = new StringBuilder(String.valueOf(algorithm).length() + 46);
                                sb.append("Unexpected output size of ");
                                sb.append(algorithm);
                                sb.append(" digest: ");
                                sb.append(digest);
                                throw new RuntimeException(sb.toString());
                            }
                        }
                        long j4 = (long) min;
                        j3 += j4;
                        a -= j4;
                        i7++;
                        j = 0;
                        i6 = i6;
                    } catch (IOException e2) {
                        throw new DigestException(a.p2(59, "Failed to digest chunk #", i7, " of section #", i8), e2);
                    }
                }
                i8++;
                i6++;
            }
            byte[][] bArr5 = new byte[iArr.length][];
            for (int i13 = 0; i13 < iArr.length; i13++) {
                int i14 = iArr[i13];
                byte[] bArr6 = bArr[i13];
                String g2 = g(i14);
                try {
                    bArr5[i13] = MessageDigest.getInstance(g2).digest(bArr6);
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(g2.concat(" digest not supported"), e3);
                }
            }
            return bArr5;
        }
        throw new DigestException(a.q2(37, "Too many chunks: ", j2));
    }

    public static X509Certificate[][] f(FileChannel fileChannel, f0 f0Var) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer k = k(f0Var.a);
                int i = 0;
                while (k.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(d(k(k), hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException(a.o2(48, "Failed to parse/verify signer #", i, " block"), e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    long j = f0Var.b;
                    long j2 = f0Var.c;
                    long j3 = f0Var.d;
                    ByteBuffer byteBuffer = f0Var.e;
                    if (!hashMap.isEmpty()) {
                        b0 b0Var = new b0(fileChannel, 0, j);
                        b0 b0Var2 = new b0(fileChannel, j2, j3 - j2);
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        a(duplicate, j);
                        a2.j.b.e.a.d.a aVar = new a2.j.b.e.a.d.a(duplicate);
                        int size = hashMap.size();
                        int[] iArr = new int[size];
                        int i2 = 0;
                        for (Integer num : hashMap.keySet()) {
                            iArr[i2] = num.intValue();
                            i2++;
                        }
                        try {
                            byte[][] e2 = e(iArr, new o[]{b0Var, b0Var2, aVar});
                            for (int i3 = 0; i3 < size; i3++) {
                                int i4 = iArr[i3];
                                if (!MessageDigest.isEqual((byte[]) hashMap.get(Integer.valueOf(i4)), e2[i3])) {
                                    throw new SecurityException(g(i4).concat(" digest of contents did not verify"));
                                }
                            }
                            return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                        } catch (DigestException e3) {
                            throw new SecurityException("Failed to compute digest(s) of contents", e3);
                        }
                    } else {
                        throw new SecurityException("No digests provided");
                    }
                } else {
                    throw new SecurityException("No content digests found");
                }
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    public static String g(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return McElieceCCA2KeyGenParameterSpec.SHA512;
        }
        throw new IllegalArgumentException(a.m2(44, "Unknown content digest algorthm: ", i));
    }

    public static ByteBuffer h(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 < position || i2 > limit) {
                throw new BufferUnderflowException();
            }
            byteBuffer.limit(i2);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i2);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        } else {
            throw new IllegalArgumentException(a.m2(17, "size: ", i));
        }
    }

    public static int i(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        throw new IllegalArgumentException(a.m2(44, "Unknown content digest algorthm: ", i));
    }

    public static void j(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static ByteBuffer k(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i <= byteBuffer.remaining()) {
                return h(byteBuffer, i);
            } else {
                throw new IOException(a.p2(101, "Length-prefixed field longer than remaining buffer. Field length: ", i, ", remaining: ", byteBuffer.remaining()));
            }
        } else {
            throw new IOException(a.m2(93, "Remaining buffer too short to contain length of length-prefixed field. Remaining: ", byteBuffer.remaining()));
        }
    }

    public static byte[] l(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        } else if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        } else {
            throw new IOException(a.p2(90, "Underflow while reading length-prefixed value. Length: ", i, ", available: ", byteBuffer.remaining()));
        }
    }

    public static X509Certificate[][] a(String str) throws e, SecurityException, IOException {
        Pair<ByteBuffer, Long> pair;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            int i = 0;
            if (randomAccessFile.length() >= 22) {
                pair = b(randomAccessFile, 0);
                if (pair == null) {
                    pair = b(randomAccessFile, 65535);
                }
            } else {
                pair = null;
            }
            if (pair != null) {
                ByteBuffer byteBuffer = (ByteBuffer) pair.first;
                long longValue = ((Long) pair.second).longValue();
                long j = -20 + longValue;
                if (j >= 0) {
                    randomAccessFile.seek(j);
                    if (randomAccessFile.readInt() == 1347094023) {
                        throw new e("ZIP64 APK not supported");
                    }
                }
                long a = a(byteBuffer);
                if (a >= longValue) {
                    StringBuilder sb = new StringBuilder(122);
                    sb.append("ZIP Central Directory offset out of range: ");
                    sb.append(a);
                    sb.append(". ZIP End of Central Directory offset: ");
                    sb.append(longValue);
                    throw new e(sb.toString());
                } else if (b(byteBuffer) + a != longValue) {
                    throw new e("ZIP Central Directory is not immediately followed by End of Central Directory");
                } else if (a >= 32) {
                    ByteBuffer allocate = ByteBuffer.allocate(24);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    allocate.order(byteOrder);
                    randomAccessFile.seek(a - ((long) allocate.capacity()));
                    randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                    if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                        long j2 = allocate.getLong(0);
                        if (j2 < ((long) allocate.capacity()) || j2 > 2147483639) {
                            StringBuilder sb2 = new StringBuilder(57);
                            sb2.append("APK Signing Block size out of range: ");
                            sb2.append(j2);
                            throw new e(sb2.toString());
                        }
                        int i2 = (int) (8 + j2);
                        long j3 = a - ((long) i2);
                        if (j3 >= 0) {
                            ByteBuffer allocate2 = ByteBuffer.allocate(i2);
                            allocate2.order(byteOrder);
                            randomAccessFile.seek(j3);
                            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                            long j4 = allocate2.getLong(0);
                            if (j4 == j2) {
                                Pair create = Pair.create(allocate2, Long.valueOf(j3));
                                ByteBuffer byteBuffer2 = (ByteBuffer) create.first;
                                long longValue2 = ((Long) create.second).longValue();
                                if (byteBuffer2.order() == byteOrder) {
                                    int capacity = byteBuffer2.capacity() - 24;
                                    if (capacity >= 8) {
                                        int capacity2 = byteBuffer2.capacity();
                                        if (capacity <= byteBuffer2.capacity()) {
                                            int limit = byteBuffer2.limit();
                                            int position = byteBuffer2.position();
                                            try {
                                                byteBuffer2.position(0);
                                                byteBuffer2.limit(capacity);
                                                byteBuffer2.position(8);
                                                ByteBuffer slice = byteBuffer2.slice();
                                                slice.order(byteBuffer2.order());
                                                while (slice.hasRemaining()) {
                                                    i++;
                                                    if (slice.remaining() >= 8) {
                                                        long j5 = slice.getLong();
                                                        if (j5 < 4 || j5 > 2147483647L) {
                                                            StringBuilder sb3 = new StringBuilder(76);
                                                            sb3.append("APK Signing Block entry #");
                                                            sb3.append(i);
                                                            sb3.append(" size out of range: ");
                                                            sb3.append(j5);
                                                            throw new e(sb3.toString());
                                                        }
                                                        int i3 = (int) j5;
                                                        int position2 = slice.position() + i3;
                                                        if (i3 > slice.remaining()) {
                                                            int remaining = slice.remaining();
                                                            StringBuilder sb4 = new StringBuilder(91);
                                                            sb4.append("APK Signing Block entry #");
                                                            sb4.append(i);
                                                            sb4.append(" size out of range: ");
                                                            sb4.append(i3);
                                                            sb4.append(", available: ");
                                                            sb4.append(remaining);
                                                            throw new e(sb4.toString());
                                                        } else if (slice.getInt() == 1896449818) {
                                                            X509Certificate[][] f = f(randomAccessFile.getChannel(), new f0(h(slice, i3 - 4), longValue2, a, longValue, byteBuffer));
                                                            randomAccessFile.close();
                                                            try {
                                                                randomAccessFile.close();
                                                            } catch (IOException unused) {
                                                            }
                                                            return f;
                                                        } else {
                                                            slice.position(position2);
                                                        }
                                                    } else {
                                                        StringBuilder sb5 = new StringBuilder(70);
                                                        sb5.append("Insufficient data to read size of APK Signing Block entry #");
                                                        sb5.append(i);
                                                        throw new e(sb5.toString());
                                                    }
                                                }
                                                throw new e("No APK Signature Scheme v2 block in APK Signing Block");
                                            } finally {
                                                byteBuffer2.position(i);
                                                byteBuffer2.limit(limit);
                                                byteBuffer2.position(position);
                                            }
                                        } else {
                                            StringBuilder sb6 = new StringBuilder(41);
                                            sb6.append("end > capacity: ");
                                            sb6.append(capacity);
                                            sb6.append(" > ");
                                            sb6.append(capacity2);
                                            throw new IllegalArgumentException(sb6.toString());
                                        }
                                    } else {
                                        StringBuilder sb7 = new StringBuilder(38);
                                        sb7.append("end < start: ");
                                        sb7.append(capacity);
                                        sb7.append(" < ");
                                        sb7.append(8);
                                        throw new IllegalArgumentException(sb7.toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                                }
                            } else {
                                StringBuilder sb8 = new StringBuilder(103);
                                sb8.append("APK Signing Block sizes in header and footer do not match: ");
                                sb8.append(j4);
                                sb8.append(" vs ");
                                sb8.append(j2);
                                throw new e(sb8.toString());
                            }
                        } else {
                            StringBuilder sb9 = new StringBuilder(59);
                            sb9.append("APK Signing Block offset out of range: ");
                            sb9.append(j3);
                            throw new e(sb9.toString());
                        }
                    } else {
                        throw new e("No APK Signing Block before ZIP Central Directory");
                    }
                } else {
                    StringBuilder sb10 = new StringBuilder(87);
                    sb10.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
                    sb10.append(a);
                    throw new e(sb10.toString());
                }
            } else {
                long length = randomAccessFile.length();
                StringBuilder sb11 = new StringBuilder(102);
                sb11.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
                sb11.append(length);
                sb11.append(" bytes");
                throw new e(sb11.toString());
            }
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }
}
