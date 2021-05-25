package com.google.android.gms.internal.vision;

import java.util.Collections;
import java.util.List;
import java.util.Map;
public final class zzkj extends zzkg<FieldDescriptorType, Object> {
    public zzkj(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.vision.zzkg
    public final void zzej() {
        if (!isImmutable()) {
            for (int i = 0; i < zzin(); i++) {
                Map.Entry zzcc = zzcc(i);
                if (((zzhv) zzcc.getKey()).zzgo()) {
                    zzcc.setValue(Collections.unmodifiableList((List) zzcc.getValue()));
                }
            }
            for (Map.Entry entry : zzio()) {
                if (((zzhv) entry.getKey()).zzgo()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzej();
    }
}
