package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
public final class zzelf {
    public static final zzelf zziqu = new zzelf(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzelf zziqv = new zzelf(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzelf zziqw = new zzelf(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzelf zziqx = new zzelf(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double w;
    private final double zziqq;
    private final double zziqr;
    private final double zziqs;
    private final double zziqt;

    private zzelf(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.zziqq = d6;
        this.zziqr = d7;
        this.w = d8;
        this.a = d2;
        this.b = d3;
        this.c = d4;
        this.d = d5;
        this.zziqs = d9;
        this.zziqt = d10;
    }

    public static zzelf zzs(ByteBuffer byteBuffer) {
        double zzi = zzbq.zzi(byteBuffer);
        double zzi2 = zzbq.zzi(byteBuffer);
        double zzj = zzbq.zzj(byteBuffer);
        return new zzelf(zzi, zzi2, zzbq.zzi(byteBuffer), zzbq.zzi(byteBuffer), zzj, zzbq.zzj(byteBuffer), zzbq.zzj(byteBuffer), zzbq.zzi(byteBuffer), zzbq.zzi(byteBuffer));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzelf.class != obj.getClass()) {
            return false;
        }
        zzelf zzelf = (zzelf) obj;
        return Double.compare(zzelf.a, this.a) == 0 && Double.compare(zzelf.b, this.b) == 0 && Double.compare(zzelf.c, this.c) == 0 && Double.compare(zzelf.d, this.d) == 0 && Double.compare(zzelf.zziqs, this.zziqs) == 0 && Double.compare(zzelf.zziqt, this.zziqt) == 0 && Double.compare(zzelf.zziqq, this.zziqq) == 0 && Double.compare(zzelf.zziqr, this.zziqr) == 0 && Double.compare(zzelf.w, this.w) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zziqq);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zziqr);
        long doubleToLongBits3 = Double.doubleToLongBits(this.w);
        long doubleToLongBits4 = Double.doubleToLongBits(this.a);
        long doubleToLongBits5 = Double.doubleToLongBits(this.b);
        long doubleToLongBits6 = Double.doubleToLongBits(this.c);
        long doubleToLongBits7 = Double.doubleToLongBits(this.d);
        long doubleToLongBits8 = Double.doubleToLongBits(this.zziqs);
        long doubleToLongBits9 = Double.doubleToLongBits(this.zziqt);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zziqu)) {
            return "Rotate 0°";
        }
        if (equals(zziqv)) {
            return "Rotate 90°";
        }
        if (equals(zziqw)) {
            return "Rotate 180°";
        }
        if (equals(zziqx)) {
            return "Rotate 270°";
        }
        double d2 = this.zziqq;
        double d3 = this.zziqr;
        double d4 = this.w;
        double d5 = this.a;
        double d6 = this.b;
        double d7 = this.c;
        double d8 = this.d;
        double d9 = this.zziqs;
        double d10 = this.zziqt;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d2);
        sb.append(", v=");
        sb.append(d3);
        sb.append(", w=");
        sb.append(d4);
        sb.append(", a=");
        sb.append(d5);
        sb.append(", b=");
        sb.append(d6);
        sb.append(", c=");
        sb.append(d7);
        sb.append(", d=");
        sb.append(d8);
        sb.append(", tx=");
        sb.append(d9);
        sb.append(", ty=");
        sb.append(d10);
        sb.append("}");
        return sb.toString();
    }
}
