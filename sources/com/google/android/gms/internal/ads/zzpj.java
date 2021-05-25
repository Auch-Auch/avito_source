package com.google.android.gms.internal.ads;
public final class zzpj {
    private byte[] data;
    private int zzbju;
    private int zzbjv = 0;
    private int zzbjw;

    public zzpj(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.zzbju = i;
        this.zzbjw = i2;
        zzix();
    }

    private final boolean zzbm(int i) {
        if (2 > i || i >= this.zzbjw) {
            return false;
        }
        byte[] bArr = this.data;
        return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i - 1] == 0;
    }

    private final int zziw() {
        int i = 0;
        int i2 = 0;
        while (!zzit()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = zzbk(i2);
        }
        return i3 + i;
    }

    private final void zzix() {
        int i;
        int i2;
        int i3 = this.zzbju;
        zzoz.checkState(i3 >= 0 && (i = this.zzbjv) >= 0 && i < 8 && (i3 < (i2 = this.zzbjw) || (i3 == i2 && i == 0)));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0039 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v8, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v9, resolved type: byte */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7 */
    public final int zzbk(int i) {
        int i2;
        byte b;
        if (i == 0) {
            return 0;
        }
        int i3 = i / 8;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = zzbm(this.zzbju + 1) ? this.zzbju + 2 : this.zzbju + 1;
            int i7 = this.zzbjv;
            if (i7 != 0) {
                byte[] bArr = this.data;
                b = ((bArr[i6] & 255) >>> (8 - i7)) | ((bArr[this.zzbju] & 255) << i7);
            } else {
                b = this.data[this.zzbju];
            }
            i -= 8;
            i4 |= (255 & (b == true ? 1 : 0)) << i;
            this.zzbju = i6;
        }
        if (i > 0) {
            int i8 = this.zzbjv + i;
            byte b2 = (byte) (255 >> (8 - i));
            int i9 = zzbm(this.zzbju + 1) ? this.zzbju + 2 : this.zzbju + 1;
            if (i8 > 8) {
                byte[] bArr2 = this.data;
                i2 = (b2 & (((255 & bArr2[i9]) >> (16 - i8)) | ((bArr2[this.zzbju] & 255) << (i8 - 8)))) | i4;
                this.zzbju = i9;
            } else {
                i2 = (b2 & ((255 & this.data[this.zzbju]) >> (8 - i8))) | i4;
                if (i8 == 8) {
                    this.zzbju = i9;
                }
            }
            i4 = i2;
            this.zzbjv = i8 % 8;
        }
        zzix();
        return i4;
    }

    public final void zzbl(int i) {
        int i2 = this.zzbju;
        int i3 = (i / 8) + i2;
        this.zzbju = i3;
        int i4 = (i % 8) + this.zzbjv;
        this.zzbjv = i4;
        if (i4 > 7) {
            this.zzbju = i3 + 1;
            this.zzbjv = i4 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzbju) {
                zzix();
                return;
            } else if (zzbm(i2)) {
                this.zzbju++;
                i2 += 2;
            }
        }
    }

    public final boolean zzit() {
        return zzbk(1) == 1;
    }

    public final int zziu() {
        return zziw();
    }

    public final int zziv() {
        int zziw = zziw();
        return ((zziw + 1) / 2) * (zziw % 2 == 0 ? -1 : 1);
    }
}
