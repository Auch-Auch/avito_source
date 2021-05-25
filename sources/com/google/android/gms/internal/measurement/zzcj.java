package com.google.android.gms.internal.measurement;

import a2.b.a.a.a;
import android.content.Context;
import java.util.Objects;
import javax.annotation.Nullable;
public final class zzcj extends zzde {
    private final Context zza;
    private final zzdv<zzdr<zzcs>> zzb;

    public zzcj(Context context, @Nullable zzdv<zzdr<zzcs>> zzdv) {
        Objects.requireNonNull(context, "Null context");
        this.zza = context;
        this.zzb = zzdv;
    }

    public final boolean equals(Object obj) {
        zzdv<zzdr<zzcs>> zzdv;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzde) {
            zzde zzde = (zzde) obj;
            if (this.zza.equals(zzde.zza()) && ((zzdv = this.zzb) != null ? zzdv.equals(zzde.zzb()) : zzde.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzdv<zzdr<zzcs>> zzdv = this.zzb;
        return hashCode ^ (zzdv == null ? 0 : zzdv.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder K = a.K(valueOf2.length() + valueOf.length() + 46, "FlagsContext{context=", valueOf, ", hermeticFileOverrides=", valueOf2);
        K.append("}");
        return K.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    public final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    @Nullable
    public final zzdv<zzdr<zzcs>> zzb() {
        return this.zzb;
    }
}
