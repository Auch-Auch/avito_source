package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.yandex.mobile.ads.AdEventListener;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdSize;
import com.yandex.mobile.ads.VideoController;
import com.yandex.mobile.ads.a;
import com.yandex.mobile.ads.impl.g;
public abstract class e extends RelativeLayout {
    @NonNull
    private final a a;
    @NonNull
    private final f b;
    @Nullable
    private AdSize c;

    public e(@NonNull Context context) {
        this(context, null);
    }

    private void a(int i) {
        if (!dt.a((ad) this.a)) {
            this.b.a(i);
        }
    }

    @NonNull
    public abstract a a(@NonNull Context context, @NonNull c cVar);

    public void destroy() {
        if (!dt.a((ad) this.a)) {
            this.a.e();
        }
    }

    public AdEventListener getAdEventListener() {
        return this.a.i();
    }

    @Nullable
    public AdSize getAdSize() {
        return this.c;
    }

    public String getBlockId() {
        return this.a.r();
    }

    @NonNull
    public VideoController getVideoController() {
        return this.a.h();
    }

    public void loadAd(AdRequest adRequest) {
        this.a.a(adRequest);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f fVar = this.b;
        getContext();
        fVar.a();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!dt.a((ad) this.a)) {
            setVisibility(this.a.c() ? 0 : 8);
        }
        configuration.toString();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.b;
        getContext();
        fVar.b();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        fz a3 = fy.a().a(getContext());
        if (!(a3 != null && a3.p()) || this == view) {
            a(i);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        getVisibility();
        a((i == 0 && getVisibility() == 0) ? 0 : 8);
    }

    public void pause() {
    }

    public void resume() {
    }

    public void setAdEventListener(AdEventListener adEventListener) {
        this.a.a(adEventListener);
    }

    public void setAdSize(@Nullable AdSize adSize) {
        this.c = adSize;
        this.a.b(a.a(adSize));
    }

    public void setAutoRefreshEnabled(boolean z) {
        this.a.a(z);
    }

    public void setBlockId(String str) {
        this.a.a_(str);
    }

    public void shouldOpenLinksInApp(boolean z) {
        this.a.a_(z);
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        f fVar;
        c cVar = new c(context);
        a a3 = a(context, cVar);
        this.a = a3;
        cVar.a(a3.s());
        if (isInEditMode()) {
            fVar = new g.b();
        } else {
            fVar = new g.a(a3);
        }
        this.b = fVar;
        fVar.a(context, this);
    }
}
