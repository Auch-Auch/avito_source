package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;
@ShowFirstParty
public final class zzx extends zzi<zzx> {
    private String category;
    private String label;
    private long value;
    private String zzup;

    public final String getAction() {
        return this.zzup;
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getValue() {
        return this.value;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", this.category);
        hashMap.put("action", this.zzup);
        hashMap.put("label", this.label);
        hashMap.put("value", Long.valueOf(this.value));
        return zzi.zza((Object) hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzi] */
    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzx zzx) {
        zzx zzx2 = zzx;
        if (!TextUtils.isEmpty(this.category)) {
            zzx2.category = this.category;
        }
        if (!TextUtils.isEmpty(this.zzup)) {
            zzx2.zzup = this.zzup;
        }
        if (!TextUtils.isEmpty(this.label)) {
            zzx2.label = this.label;
        }
        long j = this.value;
        if (j != 0) {
            zzx2.value = j;
        }
    }

    public final String zzbr() {
        return this.category;
    }
}
