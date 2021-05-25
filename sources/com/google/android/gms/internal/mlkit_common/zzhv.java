package com.google.android.gms.internal.mlkit_common;

import java.util.Collections;
import java.util.List;
import java.util.Map;
public final class zzhv extends zzhs<FieldDescriptorType, Object> {
    public zzhv(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhs
    public final void zza() {
        if (!zzb()) {
            for (int i = 0; i < zzc(); i++) {
                Map.Entry zzb = zzb(i);
                if (((zzfn) zzb.getKey()).zzd()) {
                    zzb.setValue(Collections.unmodifiableList((List) zzb.getValue()));
                }
            }
            for (Map.Entry entry : zzd()) {
                if (((zzfn) entry.getKey()).zzd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
