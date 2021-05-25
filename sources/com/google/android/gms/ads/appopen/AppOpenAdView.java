package com.google.android.gms.ads.appopen;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzse;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzwu;
public final class AppOpenAdView extends ViewGroup {
    private AppOpenAd zzadu;
    private AppOpenAdPresentationCallback zzadv;

    public AppOpenAdView(Context context) {
        super(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    private final AdSize getAdSize() {
        zzwu zzdu = this.zzadu.zzdu();
        if (zzdu == null) {
            return null;
        }
        try {
            zzvj zzke = zzdu.zzke();
            if (zzke != null) {
                return zzke.zzpm();
            }
            return null;
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    private final void zzdw() {
        AppOpenAd appOpenAd = this.zzadu;
        if (appOpenAd != null && this.zzadv != null) {
            appOpenAd.zza(new zzse(this.zzadv));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzbbd.zzc("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public final void setAppOpenAd(AppOpenAd appOpenAd) {
        IObjectWrapper zzkc;
        try {
            zzwu zzdu = appOpenAd.zzdu();
            if (zzdu != null && (zzkc = zzdu.zzkc()) != null) {
                View view = (View) ObjectWrapper.unwrap(zzkc);
                if (view.getParent() == null) {
                    removeAllViews();
                    addView(view);
                    this.zzadu = appOpenAd;
                    zzdw();
                    return;
                }
                zzbbd.zzfc("Trying to set AppOpenAd which is already in use.");
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAppOpenAdPresentationCallback(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzadv = appOpenAdPresentationCallback;
        zzdw();
    }

    public AppOpenAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppOpenAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
