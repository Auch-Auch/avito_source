package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Collections;
import java.util.List;
import java.util.Map;
public final class zzgl extends zzgm<FieldDescriptorType, Object> {
    public zzgl(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgm
    public final void zza() {
        if (!zzb()) {
            for (int i = 0; i < zzc(); i++) {
                Map.Entry zzb = zzb(i);
                if (((zzed) zzb.getKey()).zzd()) {
                    zzb.setValue(Collections.unmodifiableList((List) zzb.getValue()));
                }
            }
            for (Map.Entry entry : zzd()) {
                if (((zzed) entry.getKey()).zzd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
