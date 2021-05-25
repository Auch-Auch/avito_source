package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
public class zzekw extends zzeky implements zzbp {
    private String type;
    private long zzawj;
    private zzbs zzipz;
    private boolean zziqh;

    public zzekw(String str) {
        this.type = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void zza(zzbs zzbs) {
        this.zzipz = zzbs;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void zza(zzela zzela, ByteBuffer byteBuffer, long j, zzbo zzbo) throws IOException {
        this.zzawj = zzela.position() - ((long) byteBuffer.remaining());
        this.zziqh = byteBuffer.remaining() == 16;
        zza(zzela, j, zzbo);
    }

    @Override // com.google.android.gms.internal.ads.zzeky
    public final void zza(zzela zzela, long j, zzbo zzbo) throws IOException {
        this.zziqf = zzela;
        long position = zzela.position();
        this.zziql = position;
        this.zzbgh = position - ((long) ((this.zziqh || 8 + j >= 4294967296L) ? 16 : 8));
        zzela.zzfc(zzela.position() + j);
        this.zzawf = zzela.position();
        this.zziqj = zzbo;
    }
}
