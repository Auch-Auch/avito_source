package com.google.mlkit.common;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.mlkit.common.sdkinternal.MlKitContext;
public class MlKit {
    public static void initialize(@NonNull Context context) {
        MlKitContext.zza(context);
    }
}
