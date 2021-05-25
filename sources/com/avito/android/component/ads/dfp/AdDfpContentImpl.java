package com.avito.android.component.ads.dfp;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.design.widget.dfp_debug.DfpFrameLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.facebook.drawee.drawable.ScalingUtils;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\nJ\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\"\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/avito/android/component/ads/dfp/AdDfpContentImpl;", "Lcom/avito/android/component/ads/dfp/AdDfpContent;", "Lcom/google/android/gms/ads/formats/NativeContentAd;", "ad", "", "setNativeAd", "(Lcom/google/android/gms/ads/formats/NativeContentAd;)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)V", "Landroid/net/Uri;", "imageUri", "setImage", "(Landroid/net/Uri;)V", "advertiser", "setAdvertiser", "callToAction", "setCallToAction", "destroy", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDebugListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setPlaceholder", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "setFailureDrawable", "Lcom/avito/android/component/ads/dfp/AdDfpContentViewsImpl;", "c", "Lcom/avito/android/component/ads/dfp/AdDfpContentViewsImpl;", "views", "Lcom/google/android/gms/ads/formats/NativeContentAdView;", AuthSource.BOOKING_ORDER, "Lcom/google/android/gms/ads/formats/NativeContentAdView;", "adView", "Lcom/avito/android/design/widget/dfp_debug/DfpFrameLayout;", AuthSource.SEND_ABUSE, "Lcom/avito/android/design/widget/dfp_debug/DfpFrameLayout;", "dpfDebuggableView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdDfpContentImpl implements AdDfpContent {
    public final DfpFrameLayout a;
    public final NativeContentAdView b;
    public final AdDfpContentViewsImpl c;

    public AdDfpContentImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = (DfpFrameLayout) view;
        View findViewById = view.findViewById(R.id.ad_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.google.android.gms.ads.formats.NativeContentAdView");
        NativeContentAdView nativeContentAdView = (NativeContentAdView) findViewById;
        this.b = nativeContentAdView;
        AdDfpContentViewsImpl adDfpContentViewsImpl = new AdDfpContentViewsImpl(view);
        this.c = adDfpContentViewsImpl;
        nativeContentAdView.setHeadlineView(adDfpContentViewsImpl.getTitleView());
        nativeContentAdView.setImageView(adDfpContentViewsImpl.getImageView());
        nativeContentAdView.setAdvertiserView(adDfpContentViewsImpl.getAdvertiserView());
        nativeContentAdView.setCallToActionView(adDfpContentViewsImpl.getCallToActionView());
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void destroy() {
        this.b.destroy();
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setAdvertiser(@Nullable CharSequence charSequence) {
        this.c.setAdvertiser(charSequence);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setCallToAction(@Nullable CharSequence charSequence) {
        this.c.setCallToAction(charSequence);
    }

    @Override // com.avito.android.design.widget.dfp_debug.DfpDebuggableView
    public void setDebugListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setDebugListener(function0);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setDescription(@NotNull CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition) {
        Intrinsics.checkNotNullParameter(charSequence, "description");
        Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
        this.b.setBodyView(this.c.setDescription(charSequence, descriptionPosition));
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.c.setFailureDrawable(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setImage(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        SimpleDraweeViewsKt.getRequestBuilder(this.c.getImageView()).uri(uri).load();
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setNativeAd(@NotNull NativeContentAd nativeContentAd) {
        Intrinsics.checkNotNullParameter(nativeContentAd, "ad");
        this.b.setNativeAd(nativeContentAd);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.c.setPlaceholder(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContent
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.c.setTitle(charSequence);
    }
}
