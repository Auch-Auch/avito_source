package com.yandex.mobile.ads.nativeads;

import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.or;
public final class l extends NativeAdAssets {
    private av a;

    public final void a(@Nullable or orVar) {
        this.a = orVar != null ? new av(orVar) : null;
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        av avVar = this.a;
        av avVar2 = ((l) obj).a;
        if (avVar != null) {
            return avVar.equals(avVar2);
        }
        return avVar2 == null;
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdAssets
    public final int hashCode() {
        int hashCode = super.hashCode() * 31;
        av avVar = this.a;
        return hashCode + (avVar != null ? avVar.hashCode() : 0);
    }
}
