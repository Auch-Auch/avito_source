package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
public final class zzdbe implements zzden<zzdek<Bundle>> {
    @Nullable
    private final zzdij zzgtk;

    public zzdbe(@Nullable zzdij zzdij) {
        this.zzgtk = zzdij;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdek<Bundle>> zzaqs() {
        zzdij zzdij = this.zzgtk;
        return zzdvl.zzaf((zzdij == null || zzdij.zzasf() == null || this.zzgtk.zzasf().isEmpty()) ? null : new zzdek(this) { // from class: com.google.android.gms.internal.ads.zzdbh
            private final zzdbe zzgtl;

            {
                this.zzgtl = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdek
            public final void zzs(Object obj) {
                this.zzgtl.zzp((Bundle) obj);
            }
        });
    }

    public final /* synthetic */ void zzp(Bundle bundle) {
        bundle.putString("key_schema", this.zzgtk.zzasf());
    }
}
