package com.google.android.gms.internal.vision;
public final class zzkd implements zzjl {
    private final int flags;
    private final String info;
    private final Object[] zzaal;
    private final zzjn zzaao;

    public zzkd(zzjn zzjn, String str, Object[] objArr) {
        this.zzaao = zzjn;
        this.info = str;
        this.zzaal = objArr;
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

    @Override // com.google.android.gms.internal.vision.zzjl
    public final int zzid() {
        return (this.flags & 1) == 1 ? zzjy.zzabd : zzjy.zzabe;
    }

    @Override // com.google.android.gms.internal.vision.zzjl
    public final boolean zzie() {
        return (this.flags & 2) == 2;
    }

    @Override // com.google.android.gms.internal.vision.zzjl
    public final zzjn zzif() {
        return this.zzaao;
    }

    public final String zzil() {
        return this.info;
    }

    public final Object[] zzim() {
        return this.zzaal;
    }
}
