package com.google.android.gms.common.stats;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
@KeepForSdk
@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    @KeepForSdk
    public interface Types {
        @RecentlyNonNull
        @KeepForSdk
        public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
        @RecentlyNonNull
        @KeepForSdk
        public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public String toString() {
        long zza = zza();
        int zzb = zzb();
        long zzc = zzc();
        String zzd = zzd();
        StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 53);
        sb.append(zza);
        sb.append("\t");
        sb.append(zzb);
        sb.append("\t");
        sb.append(zzc);
        sb.append(zzd);
        return sb.toString();
    }

    @RecentlyNonNull
    public abstract long zza();

    @RecentlyNonNull
    public abstract int zzb();

    @RecentlyNonNull
    public abstract long zzc();

    @RecentlyNonNull
    public abstract String zzd();
}
