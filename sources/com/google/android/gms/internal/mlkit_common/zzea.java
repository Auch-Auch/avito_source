package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzav;
import com.google.mlkit.common.sdkinternal.ModelType;
public final class zzea {
    public static zzav.zzal.zzb zza(ModelType modelType) {
        int i = zzec.zza[modelType.ordinal()];
        if (i == 1) {
            return zzav.zzal.zzb.BASE_TRANSLATE;
        }
        if (i != 2) {
            return zzav.zzal.zzb.TYPE_UNKNOWN;
        }
        return zzav.zzal.zzb.AUTOML_IMAGE_LABELING;
    }
}
