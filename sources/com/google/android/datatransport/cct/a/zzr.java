package com.google.android.datatransport.cct.a;

import a2.j.b.a.b.a.e;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;
@AutoValue
public abstract class zzr {

    @AutoValue.Builder
    public static abstract class zza {
        @NonNull
        public abstract zza a(@Nullable Integer num);

        @NonNull
        public abstract zza b(@Nullable String str);

        @NonNull
        public zza zza(int i) {
            return a(Integer.valueOf(i));
        }

        @NonNull
        public abstract zza zza(long j);

        @NonNull
        public abstract zza zza(@Nullable zzp zzp);

        @NonNull
        public abstract zza zza(@Nullable zzu zzu);

        @NonNull
        public abstract zza zza(@Nullable List<zzq> list);

        @NonNull
        public abstract zzr zza();

        @NonNull
        public abstract zza zzb(long j);

        @NonNull
        public zza zzb(@NonNull String str) {
            return b(str);
        }
    }

    @NonNull
    public static zza zza() {
        return new e.a();
    }

    @Nullable
    public abstract zzp zzb();

    @Nullable
    @Encodable.Field(name = "logEvent")
    public abstract List<zzq> zzc();

    @Nullable
    public abstract Integer zzd();

    @Nullable
    public abstract String zze();

    @Nullable
    public abstract zzu zzf();

    public abstract long zzg();

    public abstract long zzh();
}
