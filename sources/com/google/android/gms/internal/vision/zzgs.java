package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
public abstract class zzgs implements Serializable, Iterable<Byte> {
    public static final zzgs zztt = new zzhc(zzie.zzys);
    private static final zzgy zztu = (zzgl.zzel() ? new zzhf(null) : new zzgw(null));
    private static final Comparator<zzgs> zztv = new zzgu();
    private int zzoc = 0;

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & 255;
    }

    public static zzgs zza(byte[] bArr, int i, int i2) {
        zze(i, i + i2, bArr.length);
        return new zzhc(zztu.zzd(bArr, i, i2));
    }

    public static zzha zzaw(int i) {
        return new zzha(i, null);
    }

    public static zzgs zzb(byte[] bArr, int i, int i2) {
        return new zzgz(bArr, i, i2);
    }

    public static zzgs zzd(byte[] bArr) {
        return new zzhc(bArr);
    }

    public static int zze(int i, int i2, int i3) {
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

    public static zzgs zzv(String str) {
        return new zzhc(str.getBytes(zzie.UTF_8));
    }

    @Override // java.lang.Object
    public abstract boolean equals(Object obj);

    @Override // java.lang.Object
    public final int hashCode() {
        int i = this.zzoc;
        if (i == 0) {
            int size = size();
            i = zzd(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzoc = i;
        }
        return i;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzgv(this);
    }

    public abstract int size();

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003d: APUT  (r1v1 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r2v5 java.lang.String) */
    @Override // java.lang.Object
    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? zzkt.zzd(this) : String.valueOf(zzkt.zzd(zzi(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract String zza(Charset charset);

    public abstract void zza(zzgt zzgt) throws IOException;

    public abstract void zza(byte[] bArr, int i, int i2, int i3);

    public abstract byte zzau(int i);

    public abstract byte zzav(int i);

    public abstract int zzd(int i, int i2, int i3);

    public final String zzfl() {
        return size() == 0 ? "" : zza(zzie.UTF_8);
    }

    public abstract boolean zzfm();

    public final int zzfn() {
        return this.zzoc;
    }

    public abstract zzgs zzi(int i, int i2);
}
