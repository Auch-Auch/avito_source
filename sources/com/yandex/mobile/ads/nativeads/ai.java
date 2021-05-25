package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.view.View;
import com.yandex.mobile.ads.nativeads.al;
public final class ai implements ak<View> {
    @NonNull
    private final NativeAdViewBinder a;

    public ai(@NonNull NativeAdViewBinder nativeAdViewBinder) {
        this.a = nativeAdViewBinder;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.nativeads.ak
    @NonNull
    public final /* synthetic */ al a(@NonNull View view) {
        return new al.a(view).a(this.a.getAgeView()).b(this.a.getBodyView()).c(this.a.getCallToActionView()).d(this.a.getDomainView()).a(this.a.getFaviconView()).a(this.a.getFeedbackView()).b(this.a.getIconView()).c(this.a.getImageView()).a(this.a.getMediaView()).e(this.a.getPriceView()).a(this.a.getRatingView()).f(this.a.getReviewCountView()).g(this.a.getSponsoredView()).h(this.a.getTitleView()).i(this.a.getWarningView()).a();
    }
}
