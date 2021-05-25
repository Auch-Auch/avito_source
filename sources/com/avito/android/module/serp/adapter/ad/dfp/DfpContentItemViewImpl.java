package com.avito.android.module.serp.adapter.ad.dfp;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.component.ads.dfp.AdDfpContent;
import com.avito.android.component.ads.dfp.AdDfpContentImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentItemView;
import com.avito.android.serp.BaseSerpViewHolder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\f\u0010\nJ\u001e\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b\"\u0010#J\"\u0010$\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b$\u0010\u001bJ\u0018\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0007H\u0001¢\u0006\u0004\b&\u0010\n¨\u0006+"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentItemViewImpl;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpContentItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lcom/avito/android/component/ads/dfp/AdDfpContent;", "", "destroy", "()V", "", "advertiser", "setAdvertiser", "(Ljava/lang/CharSequence;)V", "callToAction", "setCallToAction", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDebugListener", "(Lkotlin/jvm/functions/Function0;)V", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setFailureDrawable", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "Landroid/net/Uri;", "imageUri", "setImage", "(Landroid/net/Uri;)V", "Lcom/google/android/gms/ads/formats/NativeContentAd;", "ad", "setNativeAd", "(Lcom/google/android/gms/ads/formats/NativeContentAd;)V", "setPlaceholder", "title", "setTitle", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class DfpContentItemViewImpl extends BaseSerpViewHolder implements DfpContentItemView, AdDfpContent {
    public final /* synthetic */ AdDfpContentImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DfpContentItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new AdDfpContentImpl(view);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void destroy() {
        this.s.destroy();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        DfpContentItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setAdvertiser(@Nullable CharSequence charSequence) {
        this.s.setAdvertiser(charSequence);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setCallToAction(@Nullable CharSequence charSequence) {
        this.s.setCallToAction(charSequence);
    }

    @Override // com.avito.android.design.widget.dfp_debug.DfpDebuggableView
    public void setDebugListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setDebugListener(function0);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setDescription(@NotNull CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition) {
        Intrinsics.checkNotNullParameter(charSequence, "description");
        Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
        this.s.setDescription(charSequence, descriptionPosition);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.s.setFailureDrawable(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setImage(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        this.s.setImage(uri);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setNativeAd(@NotNull NativeContentAd nativeContentAd) {
        Intrinsics.checkNotNullParameter(nativeContentAd, "ad");
        this.s.setNativeAd(nativeContentAd);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.s.setPlaceholder(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.s.setTitle(charSequence);
    }
}
