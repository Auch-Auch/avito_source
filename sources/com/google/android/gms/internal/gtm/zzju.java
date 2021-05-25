package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import com.google.android.gms.common.internal.Preconditions;
public final class zzju extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0 && zzoaArr.length <= 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) ((zzom) zzoaArr[0]).value();
        if (zzoaArr.length == 1) {
            return new zzom(str);
        }
        String zzd = zzha.zzd(zzoaArr[1]);
        zzoa<?> zzoa = zzoaArr.length < 3 ? zzog.zzaum : zzoaArr[2];
        int indexOf = str.indexOf(zzd);
        if (indexOf == -1) {
            return new zzom(str);
        }
        if (zzoa instanceof zzof) {
            zzoa = ((zzgz) ((zzof) zzoa).value()).zzb(zzfl, new zzom(zzd), new zzoe(Double.valueOf((double) indexOf)), new zzom(str));
        }
        String zzd2 = zzha.zzd(zzoa);
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(zzd.length() + indexOf);
        return new zzom(a.s2(a.q0(substring2, a.q0(zzd2, String.valueOf(substring).length())), substring, zzd2, substring2));
    }
}
