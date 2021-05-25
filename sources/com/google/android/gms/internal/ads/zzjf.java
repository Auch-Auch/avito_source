package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.nio.ShortBuffer;
import java.util.Arrays;
public final class zzjf {
    private final int zzahj;
    private float zzahw = 1.0f;
    private float zzahx = 1.0f;
    private final int zzamw;
    private final int zzamx;
    private final int zzamy;
    private final int zzamz;
    private final short[] zzana;
    private int zzanb;
    private short[] zzanc;
    private int zzand;
    private short[] zzane;
    private int zzanf;
    private short[] zzang;
    private int zzanh = 0;
    private int zzani = 0;
    private int zzanj;
    private int zzank;
    private int zzanl;
    private int zzanm;
    private int zzann = 0;
    private int zzano;
    private int zzanp;
    private int zzanq;

    public zzjf(int i, int i2) {
        this.zzahj = i;
        this.zzamw = i2;
        this.zzamx = i / 400;
        int i3 = i / 65;
        this.zzamy = i3;
        int i4 = i3 * 2;
        this.zzamz = i4;
        this.zzana = new short[i4];
        this.zzanb = i4;
        this.zzanc = new short[(i4 * i2)];
        this.zzand = i4;
        this.zzane = new short[(i4 * i2)];
        this.zzanf = i4;
        this.zzang = new short[(i4 * i2)];
    }

    private final void zzaa(int i) {
        int i2 = this.zzank + i;
        int i3 = this.zzand;
        if (i2 > i3) {
            int i4 = (i3 / 2) + i + i3;
            this.zzand = i4;
            this.zzane = Arrays.copyOf(this.zzane, i4 * this.zzamw);
        }
    }

    private final void zzab(int i) {
        int i2 = this.zzanj + i;
        int i3 = this.zzanb;
        if (i2 > i3) {
            int i4 = (i3 / 2) + i + i3;
            this.zzanb = i4;
            this.zzanc = Arrays.copyOf(this.zzanc, i4 * this.zzamw);
        }
    }

    private final void zzgg() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.zzank;
        float f = this.zzahw / this.zzahx;
        double d = (double) f;
        int i8 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i9 = this.zzanj;
            if (i9 >= this.zzamz) {
                int i10 = 0;
                while (true) {
                    int i11 = this.zzanm;
                    if (i11 > 0) {
                        int min = Math.min(this.zzamz, i11);
                        zza(this.zzanc, i10, min);
                        this.zzanm -= min;
                        i10 += min;
                    } else {
                        short[] sArr = this.zzanc;
                        int i12 = this.zzahj;
                        int i13 = i12 > 4000 ? i12 / 4000 : 1;
                        if (this.zzamw == i8 && i13 == i8) {
                            i4 = zza(sArr, i10, this.zzamx, this.zzamy);
                        } else {
                            zzb(sArr, i10, i13);
                            int zza = zza(this.zzana, 0, this.zzamx / i13, this.zzamy / i13);
                            if (i13 != i8) {
                                int i14 = zza * i13;
                                int i15 = i13 << 2;
                                int i16 = i14 - i15;
                                int i17 = i14 + i15;
                                int i18 = this.zzamx;
                                if (i16 < i18) {
                                    i16 = i18;
                                }
                                int i19 = this.zzamy;
                                if (i17 > i19) {
                                    i17 = i19;
                                }
                                if (this.zzamw == i8) {
                                    i4 = zza(sArr, i10, i16, i17);
                                } else {
                                    zzb(sArr, i10, i8);
                                    i4 = zza(this.zzana, 0, i16, i17);
                                }
                            } else {
                                i4 = zza;
                            }
                        }
                        int i20 = this.zzanp;
                        int i21 = i20 != 0 && this.zzann != 0 && this.zzanq <= i20 * 3 && (i20 << 1) > this.zzano * 3 ? this.zzann : i4;
                        this.zzano = i20;
                        this.zzann = i4;
                        if (d > 1.0d) {
                            short[] sArr2 = this.zzanc;
                            if (f >= 2.0f) {
                                i6 = (int) (((float) i21) / (f - 1.0f));
                            } else {
                                this.zzanm = (int) (((2.0f - f) * ((float) i21)) / (f - 1.0f));
                                i6 = i21;
                            }
                            zzaa(i6);
                            zza(i6, this.zzamw, this.zzane, this.zzank, sArr2, i10, sArr2, i10 + i21);
                            this.zzank += i6;
                            i10 = i21 + i6 + i10;
                        } else {
                            short[] sArr3 = this.zzanc;
                            if (f < 0.5f) {
                                i5 = (int) ((((float) i21) * f) / (1.0f - f));
                            } else {
                                this.zzanm = (int) ((((2.0f * f) - 1.0f) * ((float) i21)) / (1.0f - f));
                                i5 = i21;
                            }
                            int i22 = i21 + i5;
                            zzaa(i22);
                            int i23 = this.zzamw;
                            System.arraycopy(sArr3, i10 * i23, this.zzane, this.zzank * i23, i23 * i21);
                            zza(i5, this.zzamw, this.zzane, this.zzank + i21, sArr3, i21 + i10, sArr3, i10);
                            this.zzank += i22;
                            i10 += i5;
                        }
                    }
                    if (this.zzamz + i10 > i9) {
                        break;
                    }
                    i8 = 1;
                }
                int i24 = this.zzanj - i10;
                short[] sArr4 = this.zzanc;
                int i25 = this.zzamw;
                System.arraycopy(sArr4, i10 * i25, sArr4, 0, i25 * i24);
                this.zzanj = i24;
            }
        } else {
            zza(this.zzanc, 0, this.zzanj);
            this.zzanj = 0;
        }
        float f2 = this.zzahx;
        if (f2 != 1.0f && this.zzank != i7) {
            int i26 = this.zzahj;
            int i27 = (int) (((float) i26) / f2);
            while (true) {
                if (i27 <= 16384 && i26 <= 16384) {
                    break;
                }
                i27 /= 2;
                i26 /= 2;
            }
            int i28 = this.zzank - i7;
            int i29 = this.zzanl + i28;
            int i30 = this.zzanf;
            if (i29 > i30) {
                int i31 = (i30 / 2) + i28 + i30;
                this.zzanf = i31;
                this.zzang = Arrays.copyOf(this.zzang, i31 * this.zzamw);
            }
            short[] sArr5 = this.zzane;
            int i32 = this.zzamw;
            System.arraycopy(sArr5, i7 * i32, this.zzang, this.zzanl * i32, i32 * i28);
            this.zzank = i7;
            this.zzanl += i28;
            int i33 = 0;
            while (true) {
                i = this.zzanl;
                if (i33 >= i - 1) {
                    break;
                }
                while (true) {
                    i2 = this.zzanh;
                    int i34 = (i2 + 1) * i27;
                    i3 = this.zzani;
                    if (i34 <= i3 * i26) {
                        break;
                    }
                    zzaa(1);
                    int i35 = 0;
                    while (true) {
                        int i36 = this.zzamw;
                        if (i35 >= i36) {
                            break;
                        }
                        short[] sArr6 = this.zzang;
                        int i37 = (i33 * i36) + i35;
                        short s = sArr6[i37];
                        short s2 = sArr6[i37 + i36];
                        int i38 = this.zzanh;
                        int i39 = i38 * i27;
                        int i40 = (i38 + 1) * i27;
                        int i41 = i40 - (this.zzani * i26);
                        int i42 = i40 - i39;
                        this.zzane[(this.zzank * i36) + i35] = (short) ((((i42 - i41) * s2) + (s * i41)) / i42);
                        i35++;
                    }
                    this.zzani++;
                    this.zzank++;
                }
                int i43 = i2 + 1;
                this.zzanh = i43;
                if (i43 == i26) {
                    this.zzanh = 0;
                    zzoz.checkState(i3 == i27);
                    this.zzani = 0;
                }
                i33++;
            }
            int i44 = i - 1;
            if (i44 != 0) {
                short[] sArr7 = this.zzang;
                int i45 = this.zzamw;
                System.arraycopy(sArr7, i44 * i45, sArr7, 0, (i - i44) * i45);
                this.zzanl -= i44;
            }
        }
    }

    public final void setSpeed(float f) {
        this.zzahw = f;
    }

    public final void zza(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzamw;
        int i2 = remaining / i;
        zzab(i2);
        shortBuffer.get(this.zzanc, this.zzanj * this.zzamw, ((i * i2) << 1) / 2);
        this.zzanj += i2;
        zzgg();
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzamw, this.zzank);
        shortBuffer.put(this.zzane, 0, this.zzamw * min);
        int i = this.zzank - min;
        this.zzank = i;
        short[] sArr = this.zzane;
        int i2 = this.zzamw;
        System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    public final void zzc(float f) {
        this.zzahx = f;
    }

    public final void zzfj() {
        int i;
        int i2 = this.zzanj;
        float f = this.zzahw;
        float f2 = this.zzahx;
        int i3 = this.zzank + ((int) ((((((float) i2) / (f / f2)) + ((float) this.zzanl)) / f2) + 0.5f));
        zzab((this.zzamz * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.zzamz;
            int i5 = this.zzamw;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.zzanc[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.zzanj = (i * 2) + this.zzanj;
        zzgg();
        if (this.zzank > i3) {
            this.zzank = i3;
        }
        this.zzanj = 0;
        this.zzanm = 0;
        this.zzanl = 0;
    }

    public final int zzgf() {
        return this.zzank;
    }

    private final void zzb(short[] sArr, int i, int i2) {
        int i3 = this.zzamz / i2;
        int i4 = this.zzamw;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[a.c2(i7, i5, i6, i9)];
            }
            this.zzana[i7] = (short) (i8 / i5);
        }
    }

    private final void zza(short[] sArr, int i, int i2) {
        zzaa(i2);
        int i3 = this.zzamw;
        System.arraycopy(sArr, i * i3, this.zzane, this.zzank * i3, i3 * i2);
        this.zzank += i2;
    }

    private final int zza(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.zzamw;
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i7 < i5 * i2) {
                i7 = i2;
                i5 = i9;
            }
            if (i9 * i6 > i8 * i2) {
                i6 = i2;
                i8 = i9;
            }
            i2++;
        }
        this.zzanp = i5 / i7;
        this.zzanq = i8 / i6;
        return i7;
    }

    private static void zza(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr3[i8] * i10) + ((i - i10) * sArr2[i9])) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }
}
