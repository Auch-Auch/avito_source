package com.avito.android.module.serp.adapter.ad.dfp;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.component.ads.dfp.AdDfpUnified;
import com.avito.android.component.ads.dfp.AdDfpUnifiedImpl;
import com.avito.android.serp.BaseSerpViewHolder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010E\u001a\u00020@¢\u0006\u0004\bM\u0010NJ\u001f\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\r\u0010\nJ\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0013\u0010\u0011J\u001e\u0010\u0014\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\u0014\u0010\bJ\"\u0010\u0018\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\u001e\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b\"\u0010#J\"\u0010$\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b$\u0010\u001fJ\"\u0010%\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b%\u0010\u001fJ\u0018\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0001¢\u0006\u0004\b(\u0010)J \u0010-\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020&H\u0001¢\u0006\u0004\b-\u0010.J\u0018\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020/H\u0001¢\u0006\u0004\b1\u00102J\"\u00103\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b3\u0010\u001fJ\u001a\u00105\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b5\u0010\u0011J\u0018\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u000206H\u0001¢\u0006\u0004\b8\u00109R\u001c\u0010?\u001a\u00020:8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0019\u0010E\u001a\u00020@8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001e\u0010L\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010#¨\u0006O"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedItemViewImpl;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpUnifiedItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lcom/avito/android/component/ads/dfp/AdDfpUnified;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "clearImageData", "destroy", "hideRating", "", "advertiser", "setAdvertiser", "(Ljava/lang/CharSequence;)V", "callToAction", "setCallToAction", "setDebugListener", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setFailureDrawable", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "Landroid/net/Uri;", "icon", "setIcon", "(Landroid/net/Uri;)V", "setIconFailureDrawable", "setIconPlaceholder", "", "isApplication", "setIsApplication", "(Z)V", "Lcom/google/android/gms/ads/MediaContent;", "mediaContent", "animated", "setMediaContent", "(Lcom/google/android/gms/ads/MediaContent;Z)V", "Lcom/google/android/gms/ads/formats/UnifiedNativeAd;", "nativeAd", "setNativeAd", "(Lcom/google/android/gms/ads/formats/UnifiedNativeAd;)V", "setPlaceholder", "title", "setTitle", "", "rating", "showRating", "(F)V", "", "getImageOperationId", "()I", "setImageOperationId", "(I)V", "imageOperationId", "Landroid/view/View;", "t", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "getImageUri", "()Landroid/net/Uri;", "setImageUri", "imageUri", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class DfpUnifiedItemViewImpl extends BaseSerpViewHolder implements DfpUnifiedItemView, AdDfpUnified {
    public Function0<Unit> s;
    @NotNull
    public final View t;
    public final /* synthetic */ AdDfpUnifiedImpl u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DfpUnifiedItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = new AdDfpUnifiedImpl(view);
        this.t = view;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void clearImageData() {
        this.u.clearImageData();
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void destroy() {
        this.u.destroy();
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public int getImageOperationId() {
        return this.u.getImageOperationId();
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    @Nullable
    public Uri getImageUri() {
        return this.u.getImageUri();
    }

    @NotNull
    public final View getView() {
        return this.t;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void hideRating() {
        this.u.hideRating();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.s;
        if (function0 != null) {
            function0.invoke();
        }
        this.s = null;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setAdvertiser(@Nullable CharSequence charSequence) {
        this.u.setAdvertiser(charSequence);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setCallToAction(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "callToAction");
        this.u.setCallToAction(charSequence);
    }

    @Override // com.avito.android.design.widget.dfp_debug.DfpDebuggableView
    public void setDebugListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u.setDebugListener(function0);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setDescription(@Nullable CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition) {
        Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
        this.u.setDescription(charSequence, descriptionPosition);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.u.setFailureDrawable(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setIcon(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "icon");
        this.u.setIcon(uri);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setIconFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.u.setIconFailureDrawable(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setIconPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.u.setIconPlaceholder(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setImageOperationId(int i) {
        this.u.setImageOperationId(i);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setImageUri(@Nullable Uri uri) {
        this.u.setImageUri(uri);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setIsApplication(boolean z) {
        this.u.setIsApplication(z);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setMediaContent(@NotNull MediaContent mediaContent, boolean z) {
        Intrinsics.checkNotNullParameter(mediaContent, "mediaContent");
        this.u.setMediaContent(mediaContent, z);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setNativeAd(@NotNull UnifiedNativeAd unifiedNativeAd) {
        Intrinsics.checkNotNullParameter(unifiedNativeAd, "nativeAd");
        this.u.setNativeAd(unifiedNativeAd);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.u.setPlaceholder(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setTitle(@Nullable CharSequence charSequence) {
        this.u.setTitle(charSequence);
    }

    @Override // com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void showRating(float f) {
        this.u.showRating(f);
    }
}
