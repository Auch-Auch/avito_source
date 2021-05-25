package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import java.nio.ByteBuffer;
public final class zzue extends zzub {
    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zztz.zzbx(i);
        }
        if (i2 == 1) {
            return zztz.zzr(i, zztx.zza(bArr, j));
        }
        if (i2 == 2) {
            return zztz.zzc(i, zztx.zza(bArr, j), zztx.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b6, code lost:
        return -1;
     */
    @Override // com.google.android.gms.internal.gtm.zzub
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r16, byte[] r17, int r18, int r19) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzue.zzb(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.gtm.zzub
    public final String zzh(byte[] bArr, int i, int i2) throws zzrk {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte zza = zztx.zza(bArr, (long) i);
                if (!(zzua.zzd(zza))) {
                    break;
                }
                i++;
                zzua.zza(zza, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte zza2 = zztx.zza(bArr, (long) i);
                if (zzua.zzd(zza2)) {
                    int i7 = i5 + 1;
                    zzua.zza(zza2, cArr, i5);
                    while (i6 < i3) {
                        byte zza3 = zztx.zza(bArr, (long) i6);
                        if (!(zzua.zzd(zza3))) {
                            break;
                        }
                        i6++;
                        zzua.zza(zza3, cArr, i7);
                        i7++;
                    }
                    i = i6;
                    i5 = i7;
                } else if (zzua.zze(zza2)) {
                    if (i6 < i3) {
                        zzua.zza(zza2, zztx.zza(bArr, (long) i6), cArr, i5);
                        i = i6 + 1;
                        i5++;
                    } else {
                        throw zzrk.zzpw();
                    }
                } else if (zzua.zzf(zza2)) {
                    if (i6 < i3 - 1) {
                        int i8 = i6 + 1;
                        zzua.zza(zza2, zztx.zza(bArr, (long) i6), zztx.zza(bArr, (long) i8), cArr, i5);
                        i = i8 + 1;
                        i5++;
                    } else {
                        throw zzrk.zzpw();
                    }
                } else if (i6 < i3 - 2) {
                    int i9 = i6 + 1;
                    int i10 = i9 + 1;
                    zzua.zza(zza2, zztx.zza(bArr, (long) i6), zztx.zza(bArr, (long) i9), zztx.zza(bArr, (long) i10), cArr, i5);
                    i = i10 + 1;
                    i5 = i5 + 1 + 1;
                } else {
                    throw zzrk.zzpw();
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.google.android.gms.internal.gtm.zzub
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c;
        long j;
        long j2;
        int i3;
        char charAt;
        long j3 = (long) i;
        long j4 = ((long) i2) + j3;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            throw new ArrayIndexOutOfBoundsException(a.l2(37, "Failed writing ", charSequence.charAt(length - 1), " at index ", i + i2));
        }
        int i4 = 0;
        while (true) {
            c = 128;
            j = 1;
            if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zztx.zza(bArr, j3, (byte) charAt);
            i4++;
            j3 = 1 + j3;
        }
        if (i4 == length) {
            return (int) j3;
        }
        while (i4 < length) {
            char charAt2 = charSequence.charAt(i4);
            if (charAt2 < c && j3 < j4) {
                j2 = j3 + j;
                zztx.zza(bArr, j3, (byte) charAt2);
            } else if (charAt2 < 2048 && j3 <= j4 - 2) {
                long j5 = j3 + j;
                zztx.zza(bArr, j3, (byte) ((charAt2 >>> 6) | 960));
                zztx.zza(bArr, j5, (byte) ((charAt2 & '?') | 128));
                j3 = j5 + j;
                i4++;
                c = 128;
            } else if ((charAt2 < 55296 || 57343 < charAt2) && j3 <= j4 - 3) {
                long j6 = j3 + j;
                zztx.zza(bArr, j3, (byte) ((charAt2 >>> '\f') | 480));
                long j7 = j + j6;
                zztx.zza(bArr, j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                j2 = j7 + 1;
                zztx.zza(bArr, j7, (byte) ((charAt2 & '?') | 128));
                j = 1;
            } else if (j3 <= j4 - 4) {
                int i5 = i4 + 1;
                if (i5 != length) {
                    char charAt3 = charSequence.charAt(i5);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        long j8 = j3 + 1;
                        zztx.zza(bArr, j3, (byte) ((codePoint >>> 18) | 240));
                        long j9 = 1 + j8;
                        zztx.zza(bArr, j8, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j10 = 1 + j9;
                        zztx.zza(bArr, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                        j = 1;
                        zztx.zza(bArr, j10, (byte) ((codePoint & 63) | 128));
                        i4 = i5;
                        j3 = j10 + 1;
                        i4++;
                        c = 128;
                    } else {
                        i4 = i5;
                    }
                }
                throw new zzud(i4 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(j3);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            } else {
                throw new zzud(i4, length);
            }
            j3 = j2;
            i4++;
            c = 128;
        }
        return (int) j3;
    }

    @Override // com.google.android.gms.internal.gtm.zzub
    public final void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        char c;
        long j;
        long j2;
        int i;
        char charAt;
        long zzb = zztx.zzb(byteBuffer);
        long position = ((long) byteBuffer.position()) + zzb;
        long limit = ((long) byteBuffer.limit()) + zzb;
        int length = charSequence.length();
        if (((long) length) <= limit - position) {
            int i2 = 0;
            while (true) {
                c = 128;
                if (i2 >= length || (charAt = charSequence.charAt(i2)) >= 128) {
                    break;
                }
                zztx.zza(position, (byte) charAt);
                i2++;
                position++;
            }
            if (i2 == length) {
                byteBuffer.position((int) (position - zzb));
                return;
            }
            while (i2 < length) {
                char charAt2 = charSequence.charAt(i2);
                if (charAt2 >= c || position >= limit) {
                    if (charAt2 >= 2048 || position > limit - 2) {
                        j = zzb;
                        if ((charAt2 < 55296 || 57343 < charAt2) && position <= limit - 3) {
                            long j3 = position + 1;
                            zztx.zza(position, (byte) ((charAt2 >>> '\f') | 480));
                            long j4 = j3 + 1;
                            zztx.zza(j3, (byte) (((charAt2 >>> 6) & 63) | 128));
                            zztx.zza(j4, (byte) ((charAt2 & '?') | 128));
                            j2 = j4 + 1;
                        } else if (position <= limit - 4) {
                            int i3 = i2 + 1;
                            if (i3 != length) {
                                char charAt3 = charSequence.charAt(i3);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    long j5 = position + 1;
                                    zztx.zza(position, (byte) ((codePoint >>> 18) | 240));
                                    long j6 = j5 + 1;
                                    zztx.zza(j5, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j7 = j6 + 1;
                                    zztx.zza(j6, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j2 = j7 + 1;
                                    zztx.zza(j7, (byte) ((codePoint & 63) | 128));
                                    i2 = i3;
                                } else {
                                    i2 = i3;
                                }
                            }
                            throw new zzud(i2 - 1, length);
                        } else if (55296 > charAt2 || charAt2 > 57343 || ((i = i2 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i)))) {
                            StringBuilder sb = new StringBuilder(46);
                            sb.append("Failed writing ");
                            sb.append(charAt2);
                            sb.append(" at index ");
                            sb.append(position);
                            throw new ArrayIndexOutOfBoundsException(sb.toString());
                        } else {
                            throw new zzud(i2, length);
                        }
                    } else {
                        j = zzb;
                        long j8 = position + 1;
                        zztx.zza(position, (byte) ((charAt2 >>> 6) | 960));
                        j2 = j8 + 1;
                        zztx.zza(j8, (byte) ((charAt2 & '?') | 128));
                    }
                    position = j2;
                } else {
                    zztx.zza(position, (byte) charAt2);
                    position++;
                    j = zzb;
                }
                i2++;
                c = 128;
                zzb = j;
            }
            byteBuffer.position((int) (position - zzb));
            return;
        }
        throw new ArrayIndexOutOfBoundsException(a.l2(37, "Failed writing ", charSequence.charAt(length - 1), " at index ", byteBuffer.limit()));
    }
}
