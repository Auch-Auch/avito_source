package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import java.nio.ByteBuffer;
public abstract class zzub {
    public static void zzc(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i = 0;
        while (i < length) {
            try {
                char charAt = charSequence.charAt(i);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i, (byte) charAt);
                i++;
            } catch (IndexOutOfBoundsException unused) {
                int position2 = byteBuffer.position();
                throw new ArrayIndexOutOfBoundsException(a.l2(37, "Failed writing ", charSequence.charAt(i), " at index ", Math.max(i, (position - byteBuffer.position()) + 1) + position2));
            }
        }
        if (i == length) {
            byteBuffer.position(position + i);
            return;
        }
        position += i;
        while (i < length) {
            char charAt2 = charSequence.charAt(i);
            if (charAt2 < 128) {
                byteBuffer.put(position, (byte) charAt2);
            } else if (charAt2 < 2048) {
                int i2 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt2 >>> 6) | 192));
                    byteBuffer.put(i2, (byte) ((charAt2 & '?') | 128));
                    position = i2;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i2;
                    int position2 = byteBuffer.position();
                    throw new ArrayIndexOutOfBoundsException(a.l2(37, "Failed writing ", charSequence.charAt(i), " at index ", Math.max(i, (position - byteBuffer.position()) + 1) + position2));
                }
            } else if (charAt2 < 55296 || 57343 < charAt2) {
                int i3 = position + 1;
                byteBuffer.put(position, (byte) ((charAt2 >>> '\f') | 224));
                position = i3 + 1;
                byteBuffer.put(i3, (byte) (((charAt2 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
            } else {
                int i4 = i + 1;
                if (i4 != length) {
                    try {
                        char charAt3 = charSequence.charAt(i4);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i5 = position + 1;
                            try {
                                byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                int i6 = i5 + 1;
                                byteBuffer.put(i5, (byte) (((codePoint >>> 12) & 63) | 128));
                                int i7 = i6 + 1;
                                byteBuffer.put(i6, (byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put(i7, (byte) ((codePoint & 63) | 128));
                                position = i7;
                                i = i4;
                            } catch (IndexOutOfBoundsException unused3) {
                                position = i5;
                                i = i4;
                                int position2 = byteBuffer.position();
                                throw new ArrayIndexOutOfBoundsException(a.l2(37, "Failed writing ", charSequence.charAt(i), " at index ", Math.max(i, (position - byteBuffer.position()) + 1) + position2));
                            }
                        } else {
                            i = i4;
                        }
                    } catch (IndexOutOfBoundsException unused4) {
                        i = i4;
                        int position2 = byteBuffer.position();
                        throw new ArrayIndexOutOfBoundsException(a.l2(37, "Failed writing ", charSequence.charAt(i), " at index ", Math.max(i, (position - byteBuffer.position()) + 1) + position2));
                    }
                }
                throw new zzud(i, length);
            }
            i++;
            position++;
        }
        byteBuffer.position(position);
    }

    public abstract int zzb(int i, byte[] bArr, int i2, int i3);

    public abstract int zzb(CharSequence charSequence, byte[] bArr, int i, int i2);

    public abstract void zzb(CharSequence charSequence, ByteBuffer byteBuffer);

    public final boolean zzf(byte[] bArr, int i, int i2) {
        return zzb(0, bArr, i, i2) == 0;
    }

    public abstract String zzh(byte[] bArr, int i, int i2) throws zzrk;
}
