package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public final class zzant extends zzang {
    private final NativeAppInstallAdMapper zzdky;

    public zzant(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzdky = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getBody() {
        return this.zzdky.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getCallToAction() {
        return this.zzdky.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final Bundle getExtras() {
        return this.zzdky.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getHeadline() {
        return this.zzdky.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdky.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzadi(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final boolean getOverrideClickHandling() {
        return this.zzdky.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final boolean getOverrideImpressionRecording() {
        return this.zzdky.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getPrice() {
        return this.zzdky.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final double getStarRating() {
        return this.zzdky.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String getStore() {
        return this.zzdky.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzyg getVideoController() {
        if (this.zzdky.getVideoController() != null) {
            return this.zzdky.getVideoController().zzdt();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void recordImpression() {
        this.zzdky.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdky.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzadw zzsh() {
        NativeAd.Image icon = this.zzdky.getIcon();
        if (icon != null) {
            return new zzadi(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzado zzsi() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper zzsj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdky.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper zzua() {
        View adChoicesContent = this.zzdky.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper zzub() {
        View zzadd = this.zzdky.zzadd();
        if (zzadd == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzadd);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdky.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdky.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
