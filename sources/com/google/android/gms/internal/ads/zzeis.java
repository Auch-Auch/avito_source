package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
public final class zzeis extends zzeff {
    public static final int[] zzija = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzijb;
    private final zzeff zzijc;
    private final zzeff zzijd;
    private final int zzije;
    private final int zzijf;

    private zzeis(zzeff zzeff, zzeff zzeff2) {
        this.zzijc = zzeff;
        this.zzijd = zzeff2;
        int size = zzeff.size();
        this.zzije = size;
        this.zzijb = zzeff2.size() + size;
        this.zzijf = Math.max(zzeff.zzbdn(), zzeff2.zzbdn()) + 1;
    }

    public static zzeff zza(zzeff zzeff, zzeff zzeff2) {
        if (zzeff2.size() == 0) {
            return zzeff;
        }
        if (zzeff.size() == 0) {
            return zzeff2;
        }
        int size = zzeff2.size() + zzeff.size();
        if (size < 128) {
            return zzb(zzeff, zzeff2);
        }
        if (zzeff instanceof zzeis) {
            zzeis zzeis = (zzeis) zzeff;
            if (zzeff2.size() + zzeis.zzijd.size() < 128) {
                return new zzeis(zzeis.zzijc, zzb(zzeis.zzijd, zzeff2));
            } else if (zzeis.zzijc.zzbdn() > zzeis.zzijd.zzbdn() && zzeis.zzbdn() > zzeff2.zzbdn()) {
                return new zzeis(zzeis.zzijc, new zzeis(zzeis.zzijd, zzeff2));
            }
        }
        if (size >= zzhm(Math.max(zzeff.zzbdn(), zzeff2.zzbdn()) + 1)) {
            return new zzeis(zzeff, zzeff2);
        }
        return zzeiu.zza(new zzeiu(null), zzeff, zzeff2);
    }

    private static zzeff zzb(zzeff zzeff, zzeff zzeff2) {
        int size = zzeff.size();
        int size2 = zzeff2.size();
        byte[] bArr = new byte[(size + size2)];
        zzeff.zza(bArr, 0, 0, size);
        zzeff2.zza(bArr, 0, size, size2);
        return zzeff.zzv(bArr);
    }

    public static int zzhm(int i) {
        int[] iArr = zzija;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeff, java.lang.Object
    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeff)) {
            return false;
        }
        zzeff zzeff = (zzeff) obj;
        if (this.zzijb != zzeff.size()) {
            return false;
        }
        if (this.zzijb == 0) {
            return true;
        }
        int zzbdp = zzbdp();
        int zzbdp2 = zzeff.zzbdp();
        if (zzbdp != 0 && zzbdp2 != 0 && zzbdp != zzbdp2) {
            return false;
        }
        zzeit zzeit = new zzeit(this, null);
        zzefm zzefm = (zzefm) zzeit.next();
        zzeit zzeit2 = new zzeit(zzeff, null);
        zzefm zzefm2 = (zzefm) zzeit2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = zzefm.size() - i;
            int size2 = zzefm2.size() - i2;
            int min = Math.min(size, size2);
            if (i == 0) {
                z = zzefm.zza(zzefm2, i2, min);
            } else {
                z = zzefm2.zza(zzefm, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            int i4 = this.zzijb;
            if (i3 < i4) {
                if (min == size) {
                    zzefm = (zzefm) zzeit.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    zzefm2 = (zzefm) zzeit2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final int size() {
        return this.zzijb;
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    /* renamed from: zzbdi */
    public final zzefk iterator() {
        return new zzeir(this);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final boolean zzbdk() {
        int zzg = this.zzijc.zzg(0, 0, this.zzije);
        zzeff zzeff = this.zzijd;
        if (zzeff.zzg(zzg, 0, zzeff.size()) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final zzefq zzbdl() {
        return new zzefv(new zzeiw(this));
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final int zzbdn() {
        return this.zzijf;
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final boolean zzbdo() {
        return this.zzijb >= zzhm(this.zzijf);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final byte zzfu(int i) {
        zzeff.zzaa(i, this.zzijb);
        return zzfv(i);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final byte zzfv(int i) {
        int i2 = this.zzije;
        if (i < i2) {
            return this.zzijc.zzfv(i);
        }
        return this.zzijd.zzfv(i - i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final int zzg(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzije;
        if (i4 <= i5) {
            return this.zzijc.zzg(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzijd.zzg(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzijd.zzg(this.zzijc.zzg(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final int zzh(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzije;
        if (i4 <= i5) {
            return this.zzijc.zzh(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzijd.zzh(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzijd.zzh(this.zzijc.zzh(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final zzeff zzz(int i, int i2) {
        int zzi = zzeff.zzi(i, i2, this.zzijb);
        if (zzi == 0) {
            return zzeff.zzibd;
        }
        if (zzi == this.zzijb) {
            return this;
        }
        int i3 = this.zzije;
        if (i2 <= i3) {
            return this.zzijc.zzz(i, i2);
        }
        if (i >= i3) {
            return this.zzijd.zzz(i - i3, i2 - i3);
        }
        zzeff zzeff = this.zzijc;
        return new zzeis(zzeff.zzz(i, zzeff.size()), this.zzijd.zzz(0, i2 - this.zzije));
    }

    public /* synthetic */ zzeis(zzeff zzeff, zzeff zzeff2, zzeir zzeir) {
        this(zzeff, zzeff2);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzije;
        if (i4 <= i5) {
            this.zzijc.zzb(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.zzijd.zzb(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.zzijc.zzb(bArr, i, i2, i6);
            this.zzijd.zzb(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final void zza(zzefc zzefc) throws IOException {
        this.zzijc.zza(zzefc);
        this.zzijd.zza(zzefc);
    }

    @Override // com.google.android.gms.internal.ads.zzeff
    public final String zza(Charset charset) {
        return new String(toByteArray(), charset);
    }
}
