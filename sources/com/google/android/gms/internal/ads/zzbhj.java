package com.google.android.gms.internal.ads;
public final class zzbhj {
    public final int heightPixels;
    private final int type;
    public final int widthPixels;

    private zzbhj(int i, int i2, int i3) {
        this.type = i;
        this.widthPixels = i2;
        this.heightPixels = i3;
    }

    public static zzbhj zzacu() {
        return new zzbhj(0, 0, 0);
    }

    public static zzbhj zzacv() {
        return new zzbhj(4, 0, 0);
    }

    public static zzbhj zzacw() {
        return new zzbhj(5, 0, 0);
    }

    public static zzbhj zzb(zzvj zzvj) {
        if (zzvj.zzchn) {
            return new zzbhj(3, 0, 0);
        }
        if (zzvj.zzchp) {
            return new zzbhj(2, 0, 0);
        }
        if (zzvj.zzbrc) {
            return zzacu();
        }
        return zzq(zzvj.widthPixels, zzvj.heightPixels);
    }

    public static zzbhj zzq(int i, int i2) {
        return new zzbhj(1, i, i2);
    }

    public final boolean isFluid() {
        return this.type == 2;
    }

    public final boolean zzacx() {
        return this.type == 3;
    }

    public final boolean zzacy() {
        return this.type == 0;
    }

    public final boolean zzacz() {
        return this.type == 4;
    }

    public final boolean zzada() {
        return this.type == 5;
    }
}
