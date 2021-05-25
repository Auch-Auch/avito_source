package com.google.android.gms.internal.vision;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
public final class zzie {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzys;
    private static final ByteBuffer zzyt;
    private static final zzhe zzyu;

    static {
        byte[] bArr = new byte[0];
        zzys = bArr;
        zzyt = ByteBuffer.wrap(bArr);
        zzyu = zzhe.zza(bArr, 0, bArr.length, false);
    }

    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public static <T> T zza(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static int zzab(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static Object zzb(Object obj, Object obj2) {
        return ((zzjn) obj).zzhc().zza((zzjn) obj2).zzgv();
    }

    public static boolean zzf(zzjn zzjn) {
        if (!(zzjn instanceof zzgg)) {
            return false;
        }
        zzgg zzgg = (zzgg) zzjn;
        return false;
    }

    public static boolean zzg(byte[] bArr) {
        return zzlf.zzg(bArr);
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int zzm(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }
}
