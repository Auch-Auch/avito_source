package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collections;
import java.util.List;
import java.util.Map;
public final class zzif extends zzig<FieldDescriptorType, Object> {
    public zzif(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzig
    public final void zza() {
        if (!zzb()) {
            for (int i = 0; i < zzc(); i++) {
                Map.Entry zzb = zzb(i);
                if (((zzfx) zzb.getKey()).zzd()) {
                    zzb.setValue(Collections.unmodifiableList((List) zzb.getValue()));
                }
            }
            for (Map.Entry entry : zzd()) {
                if (((zzfx) entry.getKey()).zzd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
