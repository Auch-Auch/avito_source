package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
public final class zzben {
    private long zzdh;

    public final long zzq(ByteBuffer byteBuffer) {
        zzbu zzbu;
        zzbr zzbr;
        long j = this.zzdh;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator<zzbp> it = new zzbn(new zzbek(duplicate), zzbep.zzeko).zzbjk().iterator();
            while (true) {
                zzbu = null;
                if (!it.hasNext()) {
                    zzbr = null;
                    break;
                }
                zzbp next = it.next();
                if (next instanceof zzbr) {
                    zzbr = (zzbr) next;
                    break;
                }
            }
            Iterator<zzbp> it2 = zzbr.zzbjk().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzbp next2 = it2.next();
                if (next2 instanceof zzbu) {
                    zzbu = (zzbu) next2;
                    break;
                }
            }
            long duration = (zzbu.getDuration() * 1000) / zzbu.zzr();
            this.zzdh = duration;
            return duration;
        } catch (IOException | RuntimeException unused) {
            return 0;
        }
    }
}
