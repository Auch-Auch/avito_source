package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
public final class zzmt {
    private final zzjx zzarf;
    private final zzjv[] zzbej;
    private zzjv zzbek;

    public zzmt(zzjv[] zzjvArr, zzjx zzjx) {
        this.zzbej = zzjvArr;
        this.zzarf = zzjx;
    }

    public final void release() {
        zzjv zzjv = this.zzbek;
        if (zzjv != null) {
            zzjv.release();
            this.zzbek = null;
        }
    }

    public final zzjv zza(zzjy zzjy, Uri uri) throws IOException, InterruptedException {
        zzjv zzjv = this.zzbek;
        if (zzjv != null) {
            return zzjv;
        }
        zzjv[] zzjvArr = this.zzbej;
        int length = zzjvArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzjv zzjv2 = zzjvArr[i];
            try {
                if (zzjv2.zza(zzjy)) {
                    this.zzbek = zzjv2;
                    zzjy.zzgo();
                    break;
                }
                i++;
            } catch (EOFException unused) {
            } finally {
                zzjy.zzgo();
            }
        }
        zzjv zzjv3 = this.zzbek;
        if (zzjv3 != null) {
            zzjv3.zza(this.zzarf);
            return this.zzbek;
        }
        String zza = zzpq.zza(this.zzbej);
        throw new zzns(a.s2(a.q0(zza, 58), "None of the available extractors (", zza, ") could read the stream."), uri);
    }
}
