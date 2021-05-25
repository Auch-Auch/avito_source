package com.google.mlkit.common.model;

import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
@KeepForSdk
public class RemoteModelSource {
    @Nullable
    public final String a;

    @KeepForSdk
    public RemoteModelSource(@Nullable String str) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        return Objects.equal(this.a, ((RemoteModelSource) obj).a);
    }

    public int hashCode() {
        return Objects.hashCode(this.a);
    }
}
