package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzabh {
    private final Map<String, zzabi> zzcyl = new HashMap();
    @Nullable
    private final zzabk zzcym;

    public zzabh(@Nullable zzabk zzabk) {
        this.zzcym = zzabk;
    }

    public final void zza(String str, zzabi zzabi) {
        this.zzcyl.put(str, zzabi);
    }

    public final void zzb(String str, String str2, long j) {
        zzabi zzabi;
        zzabk zzabk = this.zzcym;
        zzabi zzabi2 = this.zzcyl.get(str2);
        String[] strArr = {str};
        if (!(zzabk == null || zzabi2 == null)) {
            zzabk.zza(zzabi2, j, strArr);
        }
        Map<String, zzabi> map = this.zzcyl;
        zzabk zzabk2 = this.zzcym;
        if (zzabk2 == null) {
            zzabi = null;
        } else {
            zzabi = zzabk2.zzex(j);
        }
        map.put(str, zzabi);
    }

    @Nullable
    public final zzabk zzrm() {
        return this.zzcym;
    }
}
