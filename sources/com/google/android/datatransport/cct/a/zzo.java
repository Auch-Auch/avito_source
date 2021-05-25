package com.google.android.datatransport.cct.a;

import a2.j.b.a.b.a.b;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;
@AutoValue
@Encodable
public abstract class zzo {
    @NonNull
    public static zzo zza(@NonNull List<zzr> list) {
        return new b(list);
    }

    @NonNull
    @Encodable.Field(name = "logRequest")
    public abstract List<zzr> zza();
}
