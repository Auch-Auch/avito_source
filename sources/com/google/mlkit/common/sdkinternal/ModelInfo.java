package com.google.mlkit.common.sdkinternal;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
public class ModelInfo {
    public final String a;
    public final Uri b;
    public final String c;
    public final ModelType d;

    @KeepForSdk
    public ModelInfo(@NonNull String str, @NonNull Uri uri, @NonNull String str2, @NonNull ModelType modelType) {
        this.a = str;
        this.b = uri;
        this.c = str2;
        this.d = modelType;
    }

    @KeepForSdk
    public String getModelHash() {
        return this.c;
    }

    @KeepForSdk
    public String getModelNameForPersist() {
        return this.a;
    }

    @KeepForSdk
    public ModelType getModelType() {
        return this.d;
    }

    @KeepForSdk
    public Uri getModelUri() {
        return this.b;
    }
}
