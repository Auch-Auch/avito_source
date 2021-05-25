package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaat;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadr;
import com.google.android.gms.internal.ads.zzaea;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzwe;
import com.google.android.gms.internal.ads.zzze;
public final class UnifiedNativeAdView extends FrameLayout {
    private final FrameLayout zzbns;
    private final zzaea zzbnt = zzjs();

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.zzbns = zzd(context);
    }

    private final void zza(String str, View view) {
        try {
            this.zzbnt.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbbd.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    private final View zzbn(String str) {
        try {
            IObjectWrapper zzcs = this.zzbnt.zzcs(str);
            if (zzcs != null) {
                return (View) ObjectWrapper.unwrap(zzcs);
            }
            return null;
        } catch (RemoteException e) {
            zzbbd.zzc("Unable to call getAssetView on delegate", e);
            return null;
        }
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaea zzjs() {
        Preconditions.checkNotNull(this.zzbns, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzwe.zzpr().zza(this.zzbns.getContext(), this, this.zzbns);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbns);
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzbns;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final void destroy() {
        try {
            this.zzbnt.destroy();
        } catch (RemoteException e) {
            zzbbd.zzc("Unable to destroy native ad view", e);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzaea zzaea;
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcrc)).booleanValue() && (zzaea = this.zzbnt) != null) {
            try {
                zzaea.zzf(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call handleTouchEvent on delegate", e);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final AdChoicesView getAdChoicesView() {
        View zzbn = zzbn(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzbn instanceof AdChoicesView) {
            return (AdChoicesView) zzbn;
        }
        return null;
    }

    public final View getAdvertiserView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_ADVERTISER);
    }

    public final View getBodyView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_BODY);
    }

    public final View getCallToActionView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION);
    }

    public final View getHeadlineView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_HEADLINE);
    }

    public final View getIconView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_ICON);
    }

    public final View getImageView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_IMAGE);
    }

    public final MediaView getMediaView() {
        View zzbn = zzbn(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO);
        if (zzbn instanceof MediaView) {
            return (MediaView) zzbn;
        }
        if (zzbn == null) {
            return null;
        }
        zzbbd.zzef("View is not an instance of MediaView");
        return null;
    }

    public final View getPriceView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_PRICE);
    }

    public final View getStarRatingView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_STAR_RATING);
    }

    public final View getStoreView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_STORE);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzaea zzaea = this.zzbnt;
        if (zzaea != null) {
            try {
                zzaea.zzc(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        addView(this.zzbns);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.zzbns != view) {
            super.removeView(view);
        }
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public final void setAdvertiserView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADVERTISER, view);
    }

    public final void setBodyView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_BODY, view);
    }

    public final void setCallToActionView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION, view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbnt.zze(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbbd.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_HEADLINE, view);
    }

    public final void setIconView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ICON, view);
    }

    public final void setImageView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_IMAGE, view);
    }

    public final void setMediaView(MediaView mediaView) {
        zza(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO, mediaView);
        if (mediaView != null) {
            mediaView.zza(new zzadh(this) { // from class: com.google.android.gms.ads.formats.zzd
                private final UnifiedNativeAdView zzbnz;

                {
                    this.zzbnz = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzadh
                public final void setMediaContent(MediaContent mediaContent) {
                    this.zzbnz.zza(mediaContent);
                }
            });
            mediaView.zza(new zzadj(this) { // from class: com.google.android.gms.ads.formats.zze
                private final UnifiedNativeAdView zzbnz;

                {
                    this.zzbnz = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzadj
                public final void setImageScaleType(ImageView.ScaleType scaleType) {
                    this.zzbnz.zza(scaleType);
                }
            });
        }
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.zzbnt.zza((IObjectWrapper) unifiedNativeAd.zzjq());
        } catch (RemoteException e) {
            zzbbd.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_PRICE, view);
    }

    public final void setStarRatingView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STAR_RATING, view);
    }

    public final void setStoreView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STORE, view);
    }

    public final /* synthetic */ void zza(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            try {
                this.zzbnt.zzg(ObjectWrapper.wrap(scaleType));
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call setMediaViewImageScaleType on delegate", e);
            }
        }
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbns = zzd(context);
    }

    public final /* synthetic */ void zza(MediaContent mediaContent) {
        try {
            if (mediaContent instanceof zzze) {
                this.zzbnt.zza(((zzze) mediaContent).zzqu());
            } else if (mediaContent == null) {
                this.zzbnt.zza((zzadr) null);
            } else {
                zzbbd.zzef("Use MediaContent provided by UnifiedNativeAd.getMediaContent");
            }
        } catch (RemoteException e) {
            zzbbd.zzc("Unable to call setMediaContent on delegate", e);
        }
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbns = zzd(context);
    }

    @TargetApi(21)
    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbns = zzd(context);
    }
}
