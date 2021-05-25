package com.google.android.gms.internal.ads;
public final class zzhu {
    public static final zzhu zzahv = new zzhu(1.0f, 1.0f);
    public final float zzahw;
    public final float zzahx;
    private final int zzahy;

    public zzhu(float f, float f2) {
        this.zzahw = f;
        this.zzahx = f2;
        this.zzahy = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzhu.class == obj.getClass()) {
            zzhu zzhu = (zzhu) obj;
            if (this.zzahw == zzhu.zzahw && this.zzahx == zzhu.zzahx) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.zzahx) + ((Float.floatToRawIntBits(this.zzahw) + 527) * 31);
    }

    public final long zzdu(long j) {
        return j * ((long) this.zzahy);
    }
}
