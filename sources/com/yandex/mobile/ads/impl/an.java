package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.hv;
public final class an {
    private final a a;
    private final cp b;
    private String c;

    public enum a {
        SUCCESS("success"),
        AD_NOT_LOADED("ad_not_loaded"),
        APPLICATION_INACTIVE("application_inactive"),
        INCONSISTENT_ASSET_VALUE("inconsistent_asset_value"),
        NO_AD_VIEW("no_ad_view"),
        NO_VISIBLE_ADS("no_visible_ads"),
        NO_VISIBLE_REQUIRED_ASSETS("no_visible_required_assets"),
        NOT_ADDED_TO_HIERARCHY("not_added_to_hierarchy"),
        NOT_VISIBLE_FOR_PERCENT("not_visible_for_percent"),
        REQUIRED_ASSET_CAN_NOT_BE_VISIBLE("required_asset_can_not_be_visible"),
        REQUIRED_ASSET_IS_NOT_SUBVIEW("required_asset_is_not_subview"),
        SUPERVIEW_HIDDEN("superview_hidden"),
        TOO_SMALL("too_small");
        
        private final String n;

        private a(String str) {
            this.n = str;
        }

        public final String a() {
            return this.n;
        }
    }

    public an(@NonNull a aVar, @NonNull cp cpVar) {
        this.a = aVar;
        this.b = cpVar;
    }

    public final String a() {
        return this.c;
    }

    public final a b() {
        return this.a;
    }

    @NonNull
    public final hv.b c() {
        return this.b.a(this.a);
    }

    @NonNull
    public final hv.b d() {
        return this.b.b();
    }

    @NonNull
    public final hv.b e() {
        return this.b.a();
    }

    public final void a(String str) {
        this.c = str;
    }
}
