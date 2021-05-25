package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
public final class zzls extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        int i = 1;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length >= 2);
        zzoa<?> zzoa = zzoaArr[0];
        zzog zzog = zzog.zzaum;
        if (zzoa == zzog || zzoaArr[1] == zzog) {
            return zzog;
        }
        String zzd = zzha.zzd(zzoaArr[0]);
        String zzd2 = zzha.zzd(zzoaArr[1]);
        int i2 = 64;
        if (zzoaArr.length > 2 && zzoaArr[2] != zzog && zzha.zza(zzoaArr[2])) {
            i2 = 66;
        }
        if (zzoaArr.length > 3 && zzoaArr[3] != zzog) {
            if (!(zzoaArr[3] instanceof zzoe)) {
                return zzog;
            }
            double zzc = zzha.zzc(zzoaArr[3]);
            if (Double.isInfinite(zzc) || zzc < 0.0d) {
                return zzog;
            }
            i = (int) zzc;
        }
        String str = null;
        try {
            Matcher matcher = Pattern.compile(zzd2, i2).matcher(zzd);
            if (matcher.find() && matcher.groupCount() >= i) {
                str = matcher.group(i);
            }
            if (str == null) {
                return zzog;
            }
            return new zzom(str);
        } catch (PatternSyntaxException unused) {
            return zzog.zzaum;
        }
    }
}
