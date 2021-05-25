package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.yandex.mobile.ads.nativeads.NativeAdViewBinder;
public final class ah {
    @NonNull
    public static <T extends View> NativeAdViewBinder a(@NonNull T t, @NonNull al alVar) {
        NativeAdViewBinder.Builder builder = new NativeAdViewBinder.Builder(t);
        try {
            NativeAdViewBinder.Builder bodyView = builder.setAgeView(alVar.b()).setBodyView(alVar.c());
            TextView d = alVar.d();
            View view = null;
            NativeAdViewBinder.Builder priceView = bodyView.setCallToActionView(d instanceof Button ? (Button) d : null).setDomainView(alVar.f()).setFaviconView(alVar.g()).setFeedbackView(alVar.h()).setIconView(alVar.i()).setImageView(alVar.j()).setMediaView(alVar.k()).setPriceView(alVar.l());
            View m = alVar.m();
            if (m instanceof Rating) {
                view = m;
            }
            priceView.setRatingView(view).setReviewCountView(alVar.n()).setSponsoredView(alVar.o()).setTitleView(alVar.p()).setWarningView(alVar.q());
        } catch (Exception unused) {
        }
        return builder.build();
    }
}
