package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.sumsub.sns.core.common.SNSConstants;
public final class zzlq implements zzgz {
    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new zzom(SNSConstants.PLATFORM);
    }
}
