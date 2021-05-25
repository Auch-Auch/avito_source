package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
public final class zzoj implements zzom {
    private final byte[] data;
    private Uri uri;
    private int zzbhw;
    private int zzbhx;

    public zzoj(byte[] bArr) {
        zzoz.checkNotNull(bArr);
        zzoz.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final void close() throws IOException {
        this.uri = null;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzbhx;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.data, this.zzbhw, bArr, i, min);
        this.zzbhw += min;
        this.zzbhx -= min;
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final long zza(zzon zzon) throws IOException {
        this.uri = zzon.uri;
        long j = zzon.position;
        int i = (int) j;
        this.zzbhw = i;
        long j2 = zzon.zzcp;
        if (j2 == -1) {
            j2 = ((long) this.data.length) - j;
        }
        int i2 = (int) j2;
        this.zzbhx = i2;
        if (i2 > 0 && i + i2 <= this.data.length) {
            return (long) i2;
        }
        int i3 = this.zzbhw;
        long j3 = zzon.zzcp;
        int length = this.data.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i3);
        sb.append(", ");
        sb.append(j3);
        sb.append("], length: ");
        sb.append(length);
        throw new IOException(sb.toString());
    }
}
