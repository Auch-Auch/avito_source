package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.io.IOException;
import java.util.Stack;
public final class zzki implements zzkj {
    private final byte[] zzaox = new byte[8];
    private final Stack<zzkk> zzaoy = new Stack<>();
    private final zzks zzaoz = new zzks();
    private zzkm zzapa;
    private int zzapb;
    private int zzapc;
    private long zzapd;

    @Override // com.google.android.gms.internal.ads.zzkj
    public final void reset() {
        this.zzapb = 0;
        this.zzaoy.clear();
        this.zzaoz.reset();
    }

    @Override // com.google.android.gms.internal.ads.zzkj
    public final void zza(zzkm zzkm) {
        this.zzapa = zzkm;
    }

    @Override // com.google.android.gms.internal.ads.zzkj
    public final boolean zzb(zzjy zzjy) throws IOException, InterruptedException {
        String str;
        double d;
        int zzat;
        int zza;
        zzoz.checkState(this.zzapa != null);
        while (true) {
            if (this.zzaoy.isEmpty() || zzjy.getPosition() < this.zzaoy.peek().zzape) {
                if (this.zzapb == 0) {
                    long zza2 = this.zzaoz.zza(zzjy, true, false, 4);
                    if (zza2 == -2) {
                        zzjy.zzgo();
                        while (true) {
                            zzjy.zza(this.zzaox, 0, 4);
                            zzat = zzks.zzat(this.zzaox[0]);
                            if (zzat != -1 && zzat <= 4) {
                                zza = (int) zzks.zza(this.zzaox, zzat, false);
                                if (this.zzapa.zzao(zza)) {
                                    break;
                                }
                            }
                            zzjy.zzai(1);
                        }
                        zzjy.zzai(zzat);
                        zza2 = (long) zza;
                    }
                    if (zza2 == -1) {
                        return false;
                    }
                    this.zzapc = (int) zza2;
                    this.zzapb = 1;
                }
                if (this.zzapb == 1) {
                    this.zzapd = this.zzaoz.zza(zzjy, false, true, 8);
                    this.zzapb = 2;
                }
                int zzan = this.zzapa.zzan(this.zzapc);
                if (zzan == 0) {
                    zzjy.zzai((int) this.zzapd);
                    this.zzapb = 0;
                } else if (zzan == 1) {
                    long position = zzjy.getPosition();
                    this.zzaoy.add(new zzkk(this.zzapc, this.zzapd + position));
                    this.zzapa.zzd(this.zzapc, position, this.zzapd);
                    this.zzapb = 0;
                    return true;
                } else if (zzan == 2) {
                    long j = this.zzapd;
                    if (j <= 8) {
                        this.zzapa.zzc(this.zzapc, zza(zzjy, (int) j));
                        this.zzapb = 0;
                        return true;
                    }
                    throw new zzhv(a.q2(42, "Invalid integer size: ", this.zzapd));
                } else if (zzan == 3) {
                    long j2 = this.zzapd;
                    if (j2 <= 2147483647L) {
                        zzkm zzkm = this.zzapa;
                        int i = this.zzapc;
                        int i2 = (int) j2;
                        if (i2 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i2];
                            zzjy.readFully(bArr, 0, i2);
                            str = new String(bArr);
                        }
                        zzkm.zza(i, str);
                        this.zzapb = 0;
                        return true;
                    }
                    throw new zzhv(a.q2(41, "String element size: ", this.zzapd));
                } else if (zzan == 4) {
                    this.zzapa.zza(this.zzapc, (int) this.zzapd, zzjy);
                    this.zzapb = 0;
                    return true;
                } else if (zzan == 5) {
                    long j3 = this.zzapd;
                    if (j3 == 4 || j3 == 8) {
                        zzkm zzkm2 = this.zzapa;
                        int i3 = this.zzapc;
                        int i4 = (int) j3;
                        long zza3 = zza(zzjy, i4);
                        if (i4 == 4) {
                            d = (double) Float.intBitsToFloat((int) zza3);
                        } else {
                            d = Double.longBitsToDouble(zza3);
                        }
                        zzkm2.zza(i3, d);
                        this.zzapb = 0;
                        return true;
                    }
                    throw new zzhv(a.q2(40, "Invalid float size: ", this.zzapd));
                } else {
                    throw new zzhv(a.m2(32, "Invalid element type ", zzan));
                }
            } else {
                this.zzapa.zzap(this.zzaoy.pop().zzapc);
                return true;
            }
        }
    }

    private final long zza(zzjy zzjy, int i) throws IOException, InterruptedException {
        zzjy.readFully(this.zzaox, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zzaox[i2] & 255));
        }
        return j;
    }
}
