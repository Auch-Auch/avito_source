package com.google.android.gms.internal.gtm;

import com.avito.android.util.preferences.db_preferences.Types;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.common.internal.Preconditions;
public final class zzin extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        String str;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 1);
        Preconditions.checkArgument(!(zzoaArr[0] instanceof zzol));
        Preconditions.checkArgument(true ^ zzoo.zzm(zzoaArr[0]));
        zzoa<?> zzoa = zzoaArr[0];
        if (zzoa == zzog.zzaum) {
            str = AdError.UNDEFINED_DOMAIN;
        } else if (zzoa instanceof zzod) {
            str = Types.BOOLEAN;
        } else if (zzoa instanceof zzoe) {
            str = "number";
        } else if (zzoa instanceof zzom) {
            str = Types.STRING;
        } else {
            str = zzoa instanceof zzof ? "function" : "object";
        }
        return new zzom(str);
    }
}
