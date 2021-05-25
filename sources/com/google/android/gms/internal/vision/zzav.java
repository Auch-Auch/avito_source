package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import android.content.Context;
import java.util.Objects;
import javax.annotation.Nullable;
public final class zzav extends zzbr {
    private final zzdf<zzcy<zzbe>> zzfw;
    private final Context zzg;

    public zzav(Context context, @Nullable zzdf<zzcy<zzbe>> zzdf) {
        Objects.requireNonNull(context, "Null context");
        this.zzg = context;
        this.zzfw = zzdf;
    }

    public final boolean equals(Object obj) {
        zzdf<zzcy<zzbe>> zzdf;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbr) {
            zzbr zzbr = (zzbr) obj;
            if (this.zzg.equals(zzbr.zzaa()) && ((zzdf = this.zzfw) != null ? zzdf.equals(zzbr.zzab()) : zzbr.zzab() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.zzg.hashCode() ^ 1000003) * 1000003;
        zzdf<zzcy<zzbe>> zzdf = this.zzfw;
        return hashCode ^ (zzdf == null ? 0 : zzdf.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzg);
        String valueOf2 = String.valueOf(this.zzfw);
        StringBuilder K = a.K(valueOf2.length() + valueOf.length() + 46, "FlagsContext{context=", valueOf, ", hermeticFileOverrides=", valueOf2);
        K.append("}");
        return K.toString();
    }

    @Override // com.google.android.gms.internal.vision.zzbr
    public final Context zzaa() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.vision.zzbr
    @Nullable
    public final zzdf<zzcy<zzbe>> zzab() {
        return this.zzfw;
    }
}
