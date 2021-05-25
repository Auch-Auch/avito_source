package com.yandex.mobile.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.yandex.mobile.ads.impl.a;
import com.yandex.mobile.ads.impl.c;
import com.yandex.mobile.ads.impl.e;
public final class AdView extends e {
    public AdView(@NonNull Context context) {
        super(context);
    }

    @Override // com.yandex.mobile.ads.impl.e
    @NonNull
    public final a a(@NonNull Context context, @NonNull c cVar) {
        return new a(context, this, cVar);
    }

    @Override // com.yandex.mobile.ads.impl.e
    public final void destroy() {
        super.destroy();
    }

    @Override // com.yandex.mobile.ads.impl.e
    public final AdEventListener getAdEventListener() {
        return super.getAdEventListener();
    }

    @Override // com.yandex.mobile.ads.impl.e
    @Nullable
    public final AdSize getAdSize() {
        return super.getAdSize();
    }

    @Override // com.yandex.mobile.ads.impl.e
    public final String getBlockId() {
        return super.getBlockId();
    }

    @Override // com.yandex.mobile.ads.impl.e
    @NonNull
    public final VideoController getVideoController() {
        return super.getVideoController();
    }

    @Override // com.yandex.mobile.ads.impl.e
    public final void loadAd(AdRequest adRequest) {
        super.loadAd(adRequest);
    }

    @Override // com.yandex.mobile.ads.impl.e
    public final void pause() {
        super.pause();
    }

    @Override // com.yandex.mobile.ads.impl.e
    public final void resume() {
        super.resume();
    }

    @Override // com.yandex.mobile.ads.impl.e
    public final void setAdEventListener(AdEventListener adEventListener) {
        super.setAdEventListener(adEventListener);
    }

    @Override // com.yandex.mobile.ads.impl.e
    public final void setAdSize(@Nullable AdSize adSize) {
        super.setAdSize(adSize);
    }

    @Override // com.yandex.mobile.ads.impl.e
    public final void setAutoRefreshEnabled(boolean z) {
        super.setAutoRefreshEnabled(z);
    }

    @Override // com.yandex.mobile.ads.impl.e
    public final void setBlockId(String str) {
        super.setBlockId(str);
    }

    @Override // com.yandex.mobile.ads.impl.e
    public final void shouldOpenLinksInApp(boolean z) {
        super.shouldOpenLinksInApp(z);
    }

    public AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
