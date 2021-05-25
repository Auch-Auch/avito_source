package com.google.android.gms.internal.ads;
public final class zzkz implements zzky {
    private final zzpk zzawe;
    private final int zzawy;
    private final int zzawz;
    private int zzaxa;
    private int zzaxb;

    public zzkz(zzkt zzkt) {
        zzpk zzpk = zzkt.zzawe;
        this.zzawe = zzpk;
        zzpk.zzbo(12);
        this.zzawz = zzpk.zzjd() & 255;
        this.zzawy = zzpk.zzjd();
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final int zzgw() {
        return this.zzawy;
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final int zzgx() {
        int i = this.zzawz;
        if (i == 8) {
            return this.zzawe.readUnsignedByte();
        }
        if (i == 16) {
            return this.zzawe.readUnsignedShort();
        }
        int i2 = this.zzaxa;
        this.zzaxa = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zzaxb & 15;
        }
        int readUnsignedByte = this.zzawe.readUnsignedByte();
        this.zzaxb = readUnsignedByte;
        return (readUnsignedByte & 240) >> 4;
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final boolean zzgy() {
        return false;
    }
}
