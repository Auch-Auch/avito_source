package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.avito.android.search.map.view.PanelStateKt;
import org.json.JSONObject;
public enum fm implements fk {
    DEFAULT("default"),
    LOADING("loading"),
    HIDDEN(PanelStateKt.PANEL_HIDDEN);
    
    private final String d;

    private fm(String str) {
        this.d = str;
    }

    @Override // com.yandex.mobile.ads.impl.fk
    @NonNull
    public final String a() {
        return String.format("state: %s", JSONObject.quote(this.d));
    }
}
