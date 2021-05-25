package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.nio.ByteBuffer;
import java.util.Date;
public final class zzbu extends zzekv {
    private Date zzde;
    private Date zzdf;
    private long zzdg;
    private long zzdh;
    private double zzdi = 1.0d;
    private float zzdj = 1.0f;
    private zzelf zzdk = zzelf.zziqu;
    private long zzdl;
    private int zzdm;
    private int zzdn;
    private int zzdo;
    private int zzdp;
    private int zzdq;
    private int zzdr;

    public zzbu() {
        super("mvhd");
    }

    public final long getDuration() {
        return this.zzdh;
    }

    public final String toString() {
        StringBuilder Q = a.Q("MovieHeaderBox[", "creationTime=");
        Q.append(this.zzde);
        Q.append(";");
        Q.append("modificationTime=");
        Q.append(this.zzdf);
        Q.append(";");
        Q.append("timescale=");
        Q.append(this.zzdg);
        Q.append(";");
        Q.append("duration=");
        Q.append(this.zzdh);
        Q.append(";");
        Q.append("rate=");
        Q.append(this.zzdi);
        Q.append(";");
        Q.append("volume=");
        Q.append(this.zzdj);
        Q.append(";");
        Q.append("matrix=");
        Q.append(this.zzdk);
        Q.append(";");
        Q.append("nextTrackId=");
        return a.l(Q, this.zzdl, "]");
    }

    @Override // com.google.android.gms.internal.ads.zzeku
    public final void zzl(ByteBuffer byteBuffer) {
        zzr(byteBuffer);
        if (getVersion() == 1) {
            this.zzde = zzelc.zzfv(zzbq.zzh(byteBuffer));
            this.zzdf = zzelc.zzfv(zzbq.zzh(byteBuffer));
            this.zzdg = zzbq.zzf(byteBuffer);
            this.zzdh = zzbq.zzh(byteBuffer);
        } else {
            this.zzde = zzelc.zzfv(zzbq.zzf(byteBuffer));
            this.zzdf = zzelc.zzfv(zzbq.zzf(byteBuffer));
            this.zzdg = zzbq.zzf(byteBuffer);
            this.zzdh = zzbq.zzf(byteBuffer);
        }
        this.zzdi = zzbq.zzi(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzdj = ((float) ((short) ((bArr[1] & 255) | ((short) (0 | ((bArr[0] << 8) & 65280)))))) / 256.0f;
        zzbq.zzg(byteBuffer);
        zzbq.zzf(byteBuffer);
        zzbq.zzf(byteBuffer);
        this.zzdk = zzelf.zzs(byteBuffer);
        this.zzdm = byteBuffer.getInt();
        this.zzdn = byteBuffer.getInt();
        this.zzdo = byteBuffer.getInt();
        this.zzdp = byteBuffer.getInt();
        this.zzdq = byteBuffer.getInt();
        this.zzdr = byteBuffer.getInt();
        this.zzdl = zzbq.zzf(byteBuffer);
    }

    public final long zzr() {
        return this.zzdg;
    }
}
