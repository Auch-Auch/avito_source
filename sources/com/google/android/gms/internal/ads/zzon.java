package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.net.Uri;
import java.util.Arrays;
public final class zzon {
    public final int flags;
    public final long position;
    public final Uri uri;
    public final byte[] zzbhy;
    public final long zzbhz;
    public final String zzcn;
    public final long zzcp;

    public zzon(Uri uri2) {
        this(uri2, 0);
    }

    public final boolean isFlagSet(int i) {
        return (this.flags & 1) == 1;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.uri);
        String arrays = Arrays.toString(this.zzbhy);
        long j = this.zzbhz;
        long j2 = this.position;
        long j3 = this.zzcp;
        String str = this.zzcn;
        int i = this.flags;
        StringBuilder K = a.K(a.q0(str, a.q0(arrays, valueOf.length() + 93)), "DataSpec[", valueOf, ", ", arrays);
        a.l1(K, ", ", j, ", ");
        K.append(j2);
        a.l1(K, ", ", j3, ", ");
        K.append(str);
        K.append(", ");
        K.append(i);
        K.append("]");
        return K.toString();
    }

    private zzon(Uri uri2, int i) {
        this(uri2, 0, -1, null, 0);
    }

    public zzon(Uri uri2, long j, long j2, String str) {
        this(uri2, j, j, j2, str, 0);
    }

    private zzon(Uri uri2, long j, long j2, String str, int i) {
        this(uri2, 0, 0, -1, null, 0);
    }

    private zzon(Uri uri2, long j, long j2, long j3, String str, int i) {
        this(uri2, null, j, j2, j3, str, i);
    }

    public zzon(Uri uri2, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        zzoz.checkArgument(j >= 0);
        zzoz.checkArgument(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        zzoz.checkArgument(z);
        this.uri = uri2;
        this.zzbhy = bArr;
        this.zzbhz = j;
        this.position = j2;
        this.zzcp = j3;
        this.zzcn = str;
        this.flags = i;
    }
}
