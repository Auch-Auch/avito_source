package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
import org.json.JSONObject;
public final class zzdfl implements zzden<zzdfi> {
    private final String packageName;
    private final zzdvw zzgay;
    private final zzass zzgwb;
    private final Context zzvr;

    public zzdfl(@Nullable zzass zzass, Context context, String str, zzdvw zzdvw) {
        this.zzgwb = zzass;
        this.zzvr = context;
        this.packageName = str;
        this.zzgay = zzdvw;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdfi> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdfk
            private final zzdfl zzgwa;

            {
                this.zzgwa = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgwa.zzarl();
            }
        });
    }

    public final /* synthetic */ zzdfi zzarl() throws Exception {
        JSONObject jSONObject = new JSONObject();
        zzass zzass = this.zzgwb;
        if (zzass != null) {
            zzass.zza(this.zzvr, this.packageName, jSONObject);
        }
        return new zzdfi(jSONObject);
    }
}
