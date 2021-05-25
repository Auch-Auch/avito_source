package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public final class zzaol extends zzanm {
    private final UnifiedNativeAdMapper zzdli;

    public zzaol(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zzdli = unifiedNativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final String getAdvertiser() {
        return this.zzdli.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final String getBody() {
        return this.zzdli.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final String getCallToAction() {
        return this.zzdli.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final Bundle getExtras() {
        return this.zzdli.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final String getHeadline() {
        return this.zzdli.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdli.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image image : images) {
                arrayList.add(new zzadi(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final float getMediaContentAspectRatio() {
        return this.zzdli.getMediaContentAspectRatio();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final boolean getOverrideClickHandling() {
        return this.zzdli.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final boolean getOverrideImpressionRecording() {
        return this.zzdli.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final String getPrice() {
        return this.zzdli.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final double getStarRating() {
        if (this.zzdli.getStarRating() != null) {
            return this.zzdli.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final String getStore() {
        return this.zzdli.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzyg getVideoController() {
        if (this.zzdli.getVideoController() != null) {
            return this.zzdli.getVideoController().zzdt();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final float getVideoCurrentTime() {
        return this.zzdli.getCurrentTime();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final float getVideoDuration() {
        return this.zzdli.getDuration();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void recordImpression() {
        this.zzdli.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdli.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzadw zzsh() {
        NativeAd.Image icon = this.zzdli.getIcon();
        if (icon != null) {
            return new zzadi(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzado zzsi() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final IObjectWrapper zzsj() {
        Object zzjv = this.zzdli.zzjv();
        if (zzjv == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzjv);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdli.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final IObjectWrapper zzua() {
        View adChoicesContent = this.zzdli.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final IObjectWrapper zzub() {
        View zzadd = this.zzdli.zzadd();
        if (zzadd == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzadd);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdli.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
