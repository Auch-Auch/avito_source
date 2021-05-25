package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
public final class zzbfh extends zzbev implements zzpa<zzom> {
    private String url;
    private ByteBuffer zzami;
    private final zzbdf zzeiw;
    private boolean zzelf;
    private final zzbfe zzell = new zzbfe();
    private final zzben zzelm = new zzben();
    private boolean zzeln;
    private final Object zzelo = new Object();
    private boolean zzelp;

    public zzbfh(zzbde zzbde, zzbdf zzbdf) {
        super(zzbde);
        this.zzeiw = zzbdf;
    }

    private final void zzzg() {
        int zzaau = (int) this.zzell.zzaau();
        int zzq = (int) this.zzelm.zzq(this.zzami);
        int position = this.zzami.position();
        int round = Math.round((((float) position) / ((float) zzaau)) * ((float) zzq));
        boolean z = round > 0;
        int zzaar = zzbeb.zzaar();
        int zzaas = zzbeb.zzaas();
        String str = this.url;
        zza(str, zzfo(str), position, zzaau, (long) round, (long) zzq, z, zzaar, zzaas);
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void abort() {
        this.zzelf = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzelo) {
            ByteBuffer byteBuffer = this.zzami;
            if (byteBuffer != null && !this.zzeln) {
                byteBuffer.flip();
                this.zzeln = true;
            }
            this.zzelf = true;
        }
        return this.zzami;
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.android.gms.internal.ads.zzon] */
    @Override // com.google.android.gms.internal.ads.zzpa
    public final /* synthetic */ void zza(zzom zzom, zzon zzon) {
        zzom zzom2 = zzom;
        if (zzom2 instanceof zzop) {
            this.zzell.zza((zzop) zzom2);
        }
    }

    public final boolean zzaaw() {
        return this.zzelp;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.google.android.gms.internal.ads.zzpa
    public final /* bridge */ /* synthetic */ void zzc(zzom zzom, int i) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzpa
    public final /* bridge */ /* synthetic */ void zze(zzom zzom) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0144, code lost:
        r0 = th;
     */
    @Override // com.google.android.gms.internal.ads.zzbev
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfn(java.lang.String r23) {
        /*
        // Method dump skipped, instructions count: 405
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfh.zzfn(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final String zzfo(String str) {
        String valueOf = String.valueOf(super.zzfo(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }
}
