package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
public final class zzegr {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzibj;
    private static final ByteBuffer zzigk;
    private static final zzefq zzigl;

    static {
        byte[] bArr = new byte[0];
        zzibj = bArr;
        zzigk = ByteBuffer.wrap(bArr);
        zzigl = zzefq.zzb(bArr, 0, bArr.length, false);
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

    public static int zzbu(boolean z) {
        return z ? 1231 : 1237;
    }

    public static Object zze(Object obj, Object obj2) {
        return ((zzehz) obj).zzbfp().zzf((zzehz) obj2).zzbfw();
    }

    public static int zzfr(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static boolean zzk(zzehz zzehz) {
        if (!(zzehz instanceof zzeex)) {
            return false;
        }
        zzeex zzeex = (zzeex) zzehz;
        return false;
    }

    public static boolean zzy(byte[] bArr) {
        return zzejw.zzy(bArr);
    }

    public static String zzz(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }
}
