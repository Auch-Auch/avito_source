package com.google.android.gms.internal.mlkit_vision_face;

import a2.b.a.a.a;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
public abstract class zzez implements Serializable, Iterable<Byte> {
    public static final zzez zza = new zzfj(zzgg.zzb);
    private static final zzff zzb = (zzex.zza() ? new zzfm(null) : new zzfd(null));
    private static final Comparator<zzez> zzd = new zzfb();
    private int zzc = 0;

    public static zzez zza(String str) {
        return new zzfj(str.getBytes(zzgg.zza));
    }

    /* access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & 255;
    }

    public static zzfh zzc(int i) {
        return new zzfh(i, null);
    }

    @Override // java.lang.Object
    public abstract boolean equals(Object obj);

    @Override // java.lang.Object
    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zza2 = zza();
            i = zza(zza2, 0, zza2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzfc(this);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003d: APUT  (r1v1 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r2v5 java.lang.String) */
    @Override // java.lang.Object
    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zza());
        objArr[2] = zza() <= 50 ? zzip.zza(this) : String.valueOf(zzip.zza(zza(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i);

    public abstract int zza();

    public abstract int zza(int i, int i2, int i3);

    public abstract zzez zza(int i, int i2);

    public abstract String zza(Charset charset);

    public abstract void zza(zzfa zzfa) throws IOException;

    public abstract byte zzb(int i);

    public final String zzb() {
        return zza() == 0 ? "" : zza(zzgg.zza);
    }

    public abstract boolean zzc();

    public final int zzd() {
        return this.zzc;
    }

    public static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(a.o2(32, "Beginning index: ", i, " < 0"));
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException(a.p2(66, "Beginning index larger than ending index: ", i, ", ", i2));
        } else {
            throw new IndexOutOfBoundsException(a.p2(37, "End index: ", i2, " >= ", i3));
        }
    }
}
