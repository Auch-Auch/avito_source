package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
public abstract class zzeku implements zzbp {
    private static zzelg zzdc = zzelg.zzn(zzeku.class);
    private String type;
    private long zzawj;
    private zzbs zzipz;
    public boolean zziqa;
    private boolean zziqb;
    private ByteBuffer zziqc;
    private long zziqd;
    private long zziqe = -1;
    private zzela zziqf;
    private ByteBuffer zziqg = null;

    public zzeku(String str) {
        this.type = str;
        this.zziqb = true;
        this.zziqa = true;
    }

    private final synchronized void zzbji() {
        if (!this.zziqb) {
            try {
                zzelg zzelg = zzdc;
                String valueOf = String.valueOf(this.type);
                zzelg.zzik(valueOf.length() != 0 ? "mem mapping ".concat(valueOf) : new String("mem mapping "));
                this.zziqc = this.zziqf.zzh(this.zziqd, this.zziqe);
                this.zziqb = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void zza(zzela zzela, ByteBuffer byteBuffer, long j, zzbo zzbo) throws IOException {
        long position = zzela.position();
        this.zziqd = position;
        this.zzawj = position - ((long) byteBuffer.remaining());
        this.zziqe = j;
        this.zziqf = zzela;
        zzela.zzfc(zzela.position() + j);
        this.zziqb = false;
        this.zziqa = false;
        zzbjj();
    }

    public final synchronized void zzbjj() {
        zzbji();
        zzelg zzelg = zzdc;
        String valueOf = String.valueOf(this.type);
        zzelg.zzik(valueOf.length() != 0 ? "parsing details of ".concat(valueOf) : new String("parsing details of "));
        ByteBuffer byteBuffer = this.zziqc;
        if (byteBuffer != null) {
            this.zziqa = true;
            byteBuffer.rewind();
            zzl(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zziqg = byteBuffer.slice();
            }
            this.zziqc = null;
        }
    }

    public abstract void zzl(ByteBuffer byteBuffer);

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void zza(zzbs zzbs) {
        this.zzipz = zzbs;
    }
}
