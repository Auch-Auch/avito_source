package com.google.android.datatransport.cct.a;

import a2.j.b.a.b.a.d;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
@AutoValue
public abstract class zzq {

    @AutoValue.Builder
    public static abstract class zza {
        @NonNull
        public abstract zza zza(long j);

        @NonNull
        public abstract zza zza(@Nullable zzt zzt);

        @NonNull
        public abstract zza zza(@Nullable Integer num);

        @NonNull
        public abstract zzq zza();

        @NonNull
        public abstract zza zzb(long j);

        @NonNull
        public abstract zza zzc(long j);
    }

    @NonNull
    public static zza zza(@NonNull String str) {
        d.a aVar = new d.a();
        aVar.e = str;
        return aVar;
    }

    @Nullable
    public abstract Integer zza();

    public abstract long zzb();

    public abstract long zzc();

    @Nullable
    public abstract zzt zzd();

    @Nullable
    public abstract byte[] zze();

    @Nullable
    public abstract String zzf();

    public abstract long zzg();

    @NonNull
    public static zza zza(@NonNull byte[] bArr) {
        d.a aVar = new d.a();
        aVar.d = bArr;
        return aVar;
    }
}
