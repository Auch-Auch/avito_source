package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
import com.yandex.mobile.ads.nativeads.Rating;
public final class mi<V extends View & Rating> extends mk<V, String> {
    public mi(@NonNull V v) {
        super(v);
    }

    @Override // com.yandex.mobile.ads.impl.mk
    public final void a(@NonNull V v) {
        v.setRating(Float.valueOf(0.0f));
        super.a(v);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* bridge */ /* synthetic */ boolean a(@NonNull View view, @NonNull String str) {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ void b(@NonNull View view, @NonNull String str) {
        String str2 = str;
        try {
            ((Rating) view).setRating(Float.valueOf(Math.max(Float.parseFloat(str2), 0.0f)));
        } catch (NumberFormatException unused) {
            String.format("Could not parse rating value. Rating value is %s", str2);
        }
    }
}
