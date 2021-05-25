package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.an;
import java.util.HashMap;
import java.util.Map;
public final class nz {
    @NonNull
    private final Map<an.a, String> a = new HashMap<an.a, String>() { // from class: com.yandex.mobile.ads.impl.nz.1
        {
            put(an.a.AD_NOT_LOADED, "Ad is not loaded");
            put(an.a.APPLICATION_INACTIVE, "Screen is locked");
            put(an.a.INCONSISTENT_ASSET_VALUE, "Asset value %s doesn't match view value");
            put(an.a.NO_AD_VIEW, "No ad view");
            put(an.a.NO_VISIBLE_ADS, "No valid ads in ad unit");
            put(an.a.NO_VISIBLE_REQUIRED_ASSETS, "No visible required assets");
            put(an.a.NOT_ADDED_TO_HIERARCHY, "Ad view is not added to hierarchy");
            put(an.a.NOT_VISIBLE_FOR_PERCENT, "Ad is not visible for percent");
            put(an.a.REQUIRED_ASSET_CAN_NOT_BE_VISIBLE, "Required asset %s is not visible in ad view");
            put(an.a.REQUIRED_ASSET_IS_NOT_SUBVIEW, "Required asset %s is not subview of ad view");
            put(an.a.SUCCESS, "Unknown error, that shouldn't happen");
            put(an.a.SUPERVIEW_HIDDEN, "Ad view is hidden");
            put(an.a.TOO_SMALL, "View is too small");
        }
    };

    @NonNull
    public final String a(@NonNull an anVar) {
        String a3 = anVar.a();
        String str = this.a.get(anVar.b());
        return str != null ? String.format(str, a3) : "Visibility error";
    }
}
