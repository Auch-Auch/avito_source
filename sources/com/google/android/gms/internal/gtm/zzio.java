package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
public final class zzio extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 3);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzom);
        Preconditions.checkArgument(zzoaArr[2] instanceof zzoh);
        zzoa<?> zzoa = zzoaArr[0];
        String str = (String) ((zzom) zzoaArr[1]).value();
        List<zzoa<?>> value = ((zzoh) zzoaArr[2]).value();
        if (zzoa.zzcn(str)) {
            zzoa<?> zzco = zzoa.zzco(str);
            if (zzco instanceof zzof) {
                return ((zzgz) ((zzof) zzco).value()).zzb(zzfl, (zzoa[]) value.toArray(new zzoa[value.size()]));
            }
            throw new IllegalArgumentException(a.s2(a.q0(str, 35), "Apply TypeError: ", str, " is not a function"));
        } else if (zzoa.zzcp(str)) {
            zzgz zzcq = zzoa.zzcq(str);
            value.add(0, zzoa);
            return zzcq.zzb(zzfl, (zzoa[]) value.toArray(new zzoa[value.size()]));
        } else {
            throw new IllegalArgumentException(a.s2(a.q0(str, 40), "Apply TypeError: object has no ", str, " property"));
        }
    }
}
