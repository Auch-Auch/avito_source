package com.avito.android.module.serp.adapter.ad.dfp;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.component.ads.dfp.AdDfpAppInstall;
import com.avito.android.component.ads.dfp.AdDfpAppInstallImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallItemView;
import com.avito.android.serp.BaseSerpViewHolder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\u0006J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0019\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\u001f\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ\"\u0010 \u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b \u0010\u001aJ\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\"\u0010\u001eJ\u0018\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0001¢\u0006\u0004\b%\u0010&J\"\u0010'\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b'\u0010\u001aJ\u001a\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b)\u0010\u000bJ\u0018\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0001¢\u0006\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallItemViewImpl;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpAppInstallItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lcom/avito/android/component/ads/dfp/AdDfpAppInstall;", "", "destroy", "()V", "hideRating", "", "callToAction", "setCallToAction", "(Ljava/lang/CharSequence;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDebugListener", "(Lkotlin/jvm/functions/Function0;)V", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setFailureDrawable", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "Landroid/net/Uri;", "icon", "setIcon", "(Landroid/net/Uri;)V", "setIconFailureDrawable", "setIconPlaceholder", "image", "setImage", "Lcom/google/android/gms/ads/formats/NativeAppInstallAd;", "nativeAd", "setNativeAd", "(Lcom/google/android/gms/ads/formats/NativeAppInstallAd;)V", "setPlaceholder", "title", "setTitle", "", "rating", "showRating", "(F)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class DfpAppInstallItemViewImpl extends BaseSerpViewHolder implements DfpAppInstallItemView, AdDfpAppInstall {
    public final /* synthetic */ AdDfpAppInstallImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DfpAppInstallItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new AdDfpAppInstallImpl(view);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void destroy() {
        this.s.destroy();
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void hideRating() {
        this.s.hideRating();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        DfpAppInstallItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setCallToAction(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "callToAction");
        this.s.setCallToAction(charSequence);
    }

    @Override // com.avito.android.design.widget.dfp_debug.DfpDebuggableView
    public void setDebugListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setDebugListener(function0);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setDescription(@Nullable CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition) {
        Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
        this.s.setDescription(charSequence, descriptionPosition);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.s.setFailureDrawable(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setIcon(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "icon");
        this.s.setIcon(uri);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setIconFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.s.setIconFailureDrawable(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setIconPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.s.setIconPlaceholder(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setImage(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "image");
        this.s.setImage(uri);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setNativeAd(@NotNull NativeAppInstallAd nativeAppInstallAd) {
        Intrinsics.checkNotNullParameter(nativeAppInstallAd, "nativeAd");
        this.s.setNativeAd(nativeAppInstallAd);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.s.setPlaceholder(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setTitle(@Nullable CharSequence charSequence) {
        this.s.setTitle(charSequence);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void showRating(float f) {
        this.s.showRating(f);
    }
}
