package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
public abstract class zzps implements Serializable, Iterable<Byte> {
    public static final zzps zzavx = new zzqc(zzre.zzbbh);
    private static final zzpy zzavy = (zzpp.zzna() ? new zzqd(null) : new zzpw(null));
    private static final Comparator<zzps> zzavz = new zzpu();
    private int zzavn = 0;

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & 255;
    }

    public static zzqa zzam(int i) {
        return new zzqa(i, null);
    }

    public static zzps zzb(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzqc(zzavy.zzc(bArr, i, i2));
    }

    public static zzps zzcy(String str) {
        return new zzqc(str.getBytes(zzre.UTF_8));
    }

    public static zzps zzf(byte[] bArr) {
        return new zzqc(bArr);
    }

    @Override // java.lang.Object
    public abstract boolean equals(Object obj);

    @Override // java.lang.Object
    public final int hashCode() {
        int i = this.zzavn;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzavn = i;
        }
        return i;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzpt(this);
    }

    public abstract int size();

    @Override // java.lang.Object
    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract int zza(int i, int i2, int i3);

    public abstract String zza(Charset charset);

    public abstract void zza(zzpr zzpr) throws IOException;

    public abstract byte zzak(int i);

    public abstract byte zzal(int i);

    public abstract zzps zzc(int i, int i2);

    public final String zznc() {
        return size() == 0 ? "" : zza(zzre.UTF_8);
    }

    public abstract boolean zznd();

    public final int zzne() {
        return this.zzavn;
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
