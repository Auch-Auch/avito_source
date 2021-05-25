package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;
@ShowFirstParty
public final class zzac extends zzi<zzac> {
    public String mCategory;
    public String zzvk;
    public long zzvl;
    public String zzvm;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("variableName", this.zzvk);
        hashMap.put("timeInMillis", Long.valueOf(this.zzvl));
        hashMap.put("category", this.mCategory);
        hashMap.put("label", this.zzvm);
        return zzi.zza((Object) hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzi] */
    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzac zzac) {
        zzac zzac2 = zzac;
        if (!TextUtils.isEmpty(this.zzvk)) {
            zzac2.zzvk = this.zzvk;
        }
        long j = this.zzvl;
        if (j != 0) {
            zzac2.zzvl = j;
        }
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzac2.mCategory = this.mCategory;
        }
        if (!TextUtils.isEmpty(this.zzvm)) {
            zzac2.zzvm = this.zzvm;
        }
    }
}
