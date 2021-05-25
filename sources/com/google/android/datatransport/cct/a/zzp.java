package com.google.android.datatransport.cct.a;

import a2.j.b.a.b.a.c;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
@AutoValue
public abstract class zzp {

    @AutoValue.Builder
    public static abstract class zza {
        @NonNull
        public abstract zza zza(@Nullable zza zza);

        @NonNull
        public abstract zza zza(@Nullable zzb zzb);

        @NonNull
        public abstract zzp zza();
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class zzb extends Enum<zzb> {
        public static final zzb zza = new zzb("UNKNOWN", 0);
        public static final zzb zzb = new zzb("ANDROID_FIREBASE", 1);

        public zzb(String str, int i) {
        }
    }

    @NonNull
    public static zza zza() {
        return new c.a();
    }

    @Nullable
    public abstract zza zzb();

    @Nullable
    public abstract zzb zzc();
}
