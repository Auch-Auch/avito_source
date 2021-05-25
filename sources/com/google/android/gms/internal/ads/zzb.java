package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
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
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
public final class zzb {
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039 A[Catch:{ all -> 0x028f }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0265  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.X509Certificate[][] zza(java.lang.String r19) throws com.google.android.gms.internal.ads.zzh, java.lang.SecurityException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 660
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzb.zza(java.lang.String):java.security.cert.X509Certificate[][]");
    }

    private static String zzb(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return McElieceCCA2KeyGenParameterSpec.SHA512;
        }
        throw new IllegalArgumentException(a.m2(44, "Unknown content digest algorthm: ", i));
    }

    private static int zzc(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        throw new IllegalArgumentException(a.m2(44, "Unknown content digest algorthm: ", i));
    }

    private static byte[] zzb(ByteBuffer byteBuffer) throws IOException {
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

    private static X509Certificate[][] zza(FileChannel fileChannel, zze zze) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer zza = zza(zze.zzb);
                int i = 0;
                while (zza.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(zza(zza(zza), hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException(a.o2(48, "Failed to parse/verify signer #", i, " block"), e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    long j = zze.zzc;
                    long j2 = zze.zzd;
                    long j3 = zze.zze;
                    ByteBuffer byteBuffer = zze.zzf;
                    if (!hashMap.isEmpty()) {
                        zzf zzf = new zzf(fileChannel, 0, j);
                        zzf zzf2 = new zzf(fileChannel, j2, j3 - j2);
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        zzi.zza(duplicate, j);
                        zzd zzd = new zzd(duplicate);
                        int size = hashMap.size();
                        int[] iArr = new int[size];
                        int i2 = 0;
                        for (Integer num : hashMap.keySet()) {
                            iArr[i2] = num.intValue();
                            i2++;
                        }
                        try {
                            byte[][] zza2 = zza(iArr, new zzc[]{zzf, zzf2, zzd});
                            for (int i3 = 0; i3 < size; i3++) {
                                int i4 = iArr[i3];
                                if (!MessageDigest.isEqual((byte[]) hashMap.get(Integer.valueOf(i4)), zza2[i3])) {
                                    throw new SecurityException(String.valueOf(zzb(i4)).concat(" digest of contents did not verify"));
                                }
                            }
                            return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                        } catch (DigestException e2) {
                            throw new SecurityException("Failed to compute digest(s) of contents", e2);
                        }
                    } else {
                        throw new SecurityException("No digests provided");
                    }
                } else {
                    throw new SecurityException("No content digests found");
                }
            } catch (IOException e3) {
                throw new SecurityException("Failed to read list of signers", e3);
            }
        } catch (CertificateException e4) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x004a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0049 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x00ac A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0015 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.cert.X509Certificate[] zza(java.nio.ByteBuffer r20, java.util.Map<java.lang.Integer, byte[]> r21, java.security.cert.CertificateFactory r22) throws java.lang.SecurityException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 772
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzb.zza(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    private static byte[][] zza(int[] iArr, zzc[] zzcArr) throws DigestException {
        long j;
        String str;
        zzc[] zzcArr2 = zzcArr;
        int length = zzcArr2.length;
        long j2 = 0;
        int i = 0;
        int i2 = 0;
        long j3 = 0;
        while (true) {
            j = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            if (i2 >= length) {
                break;
            }
            j3 += ((zzcArr2[i2].size() + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - 1) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            i2++;
        }
        if (j3 < 2097151) {
            int i3 = (int) j3;
            byte[][] bArr = new byte[iArr.length][];
            for (int i4 = 0; i4 < iArr.length; i4++) {
                byte[] bArr2 = new byte[((zzc(iArr[i4]) * i3) + 5)];
                bArr2[0] = 90;
                zza(i3, bArr2, 1);
                bArr[i4] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length2 = iArr.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length2];
            int i5 = 0;
            while (true) {
                str = " digest not supported";
                if (i5 >= iArr.length) {
                    break;
                }
                String zzb = zzb(iArr[i5]);
                try {
                    messageDigestArr[i5] = MessageDigest.getInstance(zzb);
                    i5++;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(String.valueOf(zzb).concat(str), e);
                }
            }
            int length3 = zzcArr2.length;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length3) {
                zzc zzc = zzcArr2[i6];
                int i8 = i7;
                long size = zzc.size();
                long j4 = j;
                long j5 = j2;
                while (size > j2) {
                    int min = (int) Math.min(size, j4);
                    zza(min, bArr3, 1);
                    for (int i9 = 0; i9 < length2; i9++) {
                        messageDigestArr[i9].update(bArr3);
                    }
                    try {
                        zzc.zza(messageDigestArr, j5, min);
                        int i10 = 0;
                        while (i10 < iArr.length) {
                            int i11 = iArr[i10];
                            byte[] bArr4 = bArr[i10];
                            int zzc2 = zzc(i11);
                            MessageDigest messageDigest = messageDigestArr[i10];
                            int digest = messageDigest.digest(bArr4, (i8 * zzc2) + 5, zzc2);
                            if (digest == zzc2) {
                                i10++;
                                bArr3 = bArr3;
                                length2 = length2;
                            } else {
                                String algorithm = messageDigest.getAlgorithm();
                                StringBuilder sb = new StringBuilder(a.q0(algorithm, 46));
                                sb.append("Unexpected output size of ");
                                sb.append(algorithm);
                                sb.append(" digest: ");
                                sb.append(digest);
                                throw new RuntimeException(sb.toString());
                            }
                        }
                        long j6 = (long) min;
                        j5 += j6;
                        size -= j6;
                        i8++;
                        j4 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                        j2 = 0;
                        bArr3 = bArr3;
                    } catch (IOException e2) {
                        throw new DigestException(a.p2(59, "Failed to digest chunk #", i8, " of section #", i), e2);
                    }
                }
                i++;
                i6++;
                j2 = 0;
                j = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                i7 = i8;
                str = str;
                length3 = length3;
                zzcArr2 = zzcArr;
            }
            byte[][] bArr5 = new byte[iArr.length][];
            for (int i12 = 0; i12 < iArr.length; i12++) {
                int i13 = iArr[i12];
                byte[] bArr6 = bArr[i12];
                String zzb2 = zzb(i13);
                try {
                    bArr5[i12] = MessageDigest.getInstance(zzb2).digest(bArr6);
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(String.valueOf(zzb2).concat(str), e3);
                }
            }
            return bArr5;
        }
        throw new DigestException(a.q2(37, "Too many chunks: ", j3));
    }

    private static int zza(int i) {
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
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(valueOf) : new String("Unknown signature algorithm: 0x"));
        }
    }

    /* JADX INFO: finally extract failed */
    private static ByteBuffer zza(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 >= 8) {
            int capacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
                    byteBuffer.position(8);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                    return slice;
                } catch (Throwable th) {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                    throw th;
                }
            } else {
                throw new IllegalArgumentException(a.p2(41, "end > capacity: ", i2, " > ", capacity));
            }
        } else {
            throw new IllegalArgumentException(a.o2(38, "end < start: ", i2, " < 8"));
        }
    }

    private static ByteBuffer zza(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
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

    private static ByteBuffer zza(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i <= byteBuffer.remaining()) {
                return zza(byteBuffer, i);
            } else {
                throw new IOException(a.p2(101, "Length-prefixed field longer than remaining buffer. Field length: ", i, ", remaining: ", byteBuffer.remaining()));
            }
        } else {
            throw new IOException(a.m2(93, "Remaining buffer too short to contain length of length-prefixed field. Remaining: ", byteBuffer.remaining()));
        }
    }

    private static void zza(int i, byte[] bArr, int i2) {
        bArr[1] = (byte) i;
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 16);
        bArr[4] = (byte) (i >>> 24);
    }
}
