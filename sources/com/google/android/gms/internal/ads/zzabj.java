package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzabj extends zzabo {
    private final zzg zzcyp;
    @Nullable
    private final String zzcyq;
    private final String zzcyr;

    public zzabj(zzg zzg, @Nullable String str, String str2) {
        this.zzcyp = zzg;
        this.zzcyq = str;
        this.zzcyr = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final String getContent() {
        return this.zzcyr;
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final void recordClick() {
        this.zzcyp.zzka();
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final void recordImpression() {
        this.zzcyp.zzkb();
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final void zzn(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.zzcyp.zzh((View) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final String zzrp() {
        return this.zzcyq;
    }
}
