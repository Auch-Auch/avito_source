package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
@ShowFirstParty
@VisibleForTesting
public final class zzaa extends zzi<zzaa> {
    private String zzva;
    private int zzvb;
    private int zzvc;
    private String zzvd;
    private String zzve;
    private boolean zzvf;
    private boolean zzvg;

    public zzaa() {
        this(false);
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", this.zzva);
        hashMap.put("interstitial", Boolean.valueOf(this.zzvf));
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, Boolean.valueOf(this.zzvg));
        hashMap.put("screenId", Integer.valueOf(this.zzvb));
        hashMap.put("referrerScreenId", Integer.valueOf(this.zzvc));
        hashMap.put("referrerScreenName", this.zzvd);
        hashMap.put("referrerUri", this.zzve);
        return zzi.zza((Object) hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzi] */
    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzaa zzaa) {
        zzaa zzaa2 = zzaa;
        if (!TextUtils.isEmpty(this.zzva)) {
            zzaa2.zzva = this.zzva;
        }
        int i = this.zzvb;
        if (i != 0) {
            zzaa2.zzvb = i;
        }
        int i2 = this.zzvc;
        if (i2 != 0) {
            zzaa2.zzvc = i2;
        }
        if (!TextUtils.isEmpty(this.zzvd)) {
            zzaa2.zzvd = this.zzvd;
        }
        if (!TextUtils.isEmpty(this.zzve)) {
            String str = this.zzve;
            if (TextUtils.isEmpty(str)) {
                zzaa2.zzve = null;
            } else {
                zzaa2.zzve = str;
            }
        }
        boolean z = this.zzvf;
        if (z) {
            zzaa2.zzvf = z;
        }
        boolean z2 = this.zzvg;
        if (z2) {
            zzaa2.zzvg = z2;
        }
    }

    public final String zzca() {
        return this.zzva;
    }

    public final int zzcb() {
        return this.zzvb;
    }

    public final String zzcc() {
        return this.zzve;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzaa(boolean r5) {
        /*
            r4 = this;
            java.util.UUID r5 = java.util.UUID.randomUUID()
            long r0 = r5.getLeastSignificantBits()
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r0 = r0 & r2
            int r1 = (int) r0
            if (r1 == 0) goto L_0x0010
            goto L_0x001c
        L_0x0010:
            long r0 = r5.getMostSignificantBits()
            long r0 = r0 & r2
            int r1 = (int) r0
            if (r1 == 0) goto L_0x0019
            goto L_0x001c
        L_0x0019:
            r1 = 2147483647(0x7fffffff, float:NaN)
        L_0x001c:
            r5 = 0
            r4.<init>(r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzaa.<init>(boolean):void");
    }

    @ShowFirstParty
    @VisibleForTesting
    private zzaa(boolean z, int i) {
        Preconditions.checkNotZero(i);
        this.zzvb = i;
        this.zzvg = false;
    }
}
