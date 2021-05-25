package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
public final class zzbel implements zzom {
    private Uri uri;
    private final zzom zzekj;
    private final long zzekk;
    private final zzom zzekl;
    private long zzekm;

    public zzbel(zzom zzom, int i, zzom zzom2) {
        this.zzekj = zzom;
        this.zzekk = (long) i;
        this.zzekl = zzom2;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final void close() throws IOException {
        this.zzekj.close();
        this.zzekl.close();
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzekm;
        long j2 = this.zzekk;
        if (j < j2) {
            i3 = this.zzekj.read(bArr, i, (int) Math.min((long) i2, j2 - j));
            this.zzekm += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.zzekm < this.zzekk) {
            return i3;
        }
        int read = this.zzekl.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.zzekm += (long) read;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final long zza(zzon zzon) throws IOException {
        zzon zzon2;
        this.uri = zzon.uri;
        long j = zzon.position;
        long j2 = this.zzekk;
        zzon zzon3 = null;
        if (j >= j2) {
            zzon2 = null;
        } else {
            long j3 = zzon.zzcp;
            zzon2 = new zzon(zzon.uri, j, j3 != -1 ? Math.min(j3, j2 - j) : j2 - j, null);
        }
        long j4 = zzon.zzcp;
        if (j4 == -1 || zzon.position + j4 > this.zzekk) {
            long max = Math.max(this.zzekk, zzon.position);
            long j5 = zzon.zzcp;
            zzon3 = new zzon(zzon.uri, max, j5 != -1 ? Math.min(j5, (zzon.position + j5) - this.zzekk) : -1, null);
        }
        long j6 = 0;
        long zza = zzon2 != null ? this.zzekj.zza(zzon2) : 0;
        if (zzon3 != null) {
            j6 = this.zzekl.zza(zzon3);
        }
        this.zzekm = zzon.position;
        if (zza == -1 || j6 == -1) {
            return -1;
        }
        return zza + j6;
    }
}
