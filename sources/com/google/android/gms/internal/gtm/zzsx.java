package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
public final class zzsx implements zzsi {
    private final int flags;
    private final String info;
    private final Object[] zzbcz;
    private final zzsk zzbdc;

    public zzsx(zzsk zzsk, String str, Object[] objArr) {
        this.zzbdc = zzsk;
        this.info = str;
        this.zzbcz = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 >= 55296) {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            } else {
                this.flags = i | (charAt2 << i2);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsi
    public final int zzql() {
        return (this.flags & 1) == 1 ? zzrc.zze.zzbaz : zzrc.zze.zzbba;
    }

    @Override // com.google.android.gms.internal.gtm.zzsi
    public final boolean zzqm() {
        return (this.flags & 2) == 2;
    }

    @Override // com.google.android.gms.internal.gtm.zzsi
    public final zzsk zzqn() {
        return this.zzbdc;
    }

    public final String zzqt() {
        return this.info;
    }

    public final Object[] zzqu() {
        return this.zzbcz;
    }
}
