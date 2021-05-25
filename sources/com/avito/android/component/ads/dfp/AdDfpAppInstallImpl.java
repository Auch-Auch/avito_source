package com.avito.android.component.ads.dfp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.design.widget.dfp_debug.DfpDebuggableView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0010J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010!\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001fH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010'\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J!\u0010)\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b)\u0010(J!\u0010*\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b*\u0010(J!\u0010+\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b+\u0010(R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcom/avito/android/component/ads/dfp/AdDfpAppInstallImpl;", "Lcom/avito/android/component/ads/dfp/AdDfpAppInstall;", "Landroid/net/Uri;", "image", "", "setImage", "(Landroid/net/Uri;)V", "icon", "setIcon", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "callToAction", "setCallToAction", "destroy", "()V", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)V", "", "rating", "showRating", "(F)V", "hideRating", "Lcom/google/android/gms/ads/formats/NativeAppInstallAd;", "nativeAd", "setNativeAd", "(Lcom/google/android/gms/ads/formats/NativeAppInstallAd;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDebugListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setPlaceholder", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "setFailureDrawable", "setIconPlaceholder", "setIconFailureDrawable", "Lcom/avito/android/component/ads/dfp/AdDfpAppInstallViewsImpl;", "c", "Lcom/avito/android/component/ads/dfp/AdDfpAppInstallViewsImpl;", "views", "Lcom/google/android/gms/ads/formats/NativeAppInstallAdView;", AuthSource.BOOKING_ORDER, "Lcom/google/android/gms/ads/formats/NativeAppInstallAdView;", "adView", "Lcom/avito/android/design/widget/dfp_debug/DfpDebuggableView;", AuthSource.SEND_ABUSE, "Lcom/avito/android/design/widget/dfp_debug/DfpDebuggableView;", "dfpDebuggableView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdDfpAppInstallImpl implements AdDfpAppInstall {
    public final DfpDebuggableView a;
    public final NativeAppInstallAdView b;
    public final AdDfpAppInstallViewsImpl c;

    public AdDfpAppInstallImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = (DfpDebuggableView) view;
        View findViewById = view.findViewById(R.id.ad_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.google.android.gms.ads.formats.NativeAppInstallAdView");
        NativeAppInstallAdView nativeAppInstallAdView = (NativeAppInstallAdView) findViewById;
        this.b = nativeAppInstallAdView;
        AdDfpAppInstallViewsImpl adDfpAppInstallViewsImpl = new AdDfpAppInstallViewsImpl(view);
        this.c = adDfpAppInstallViewsImpl;
        nativeAppInstallAdView.setCallToActionView(adDfpAppInstallViewsImpl.getInstallButton());
        nativeAppInstallAdView.setHeadlineView(adDfpAppInstallViewsImpl.getTitleView());
        nativeAppInstallAdView.setIconView(adDfpAppInstallViewsImpl.getIconView());
        nativeAppInstallAdView.setImageView(adDfpAppInstallViewsImpl.getImageView());
        nativeAppInstallAdView.setStarRatingView(adDfpAppInstallViewsImpl.getRatingBarView());
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void destroy() {
        this.b.destroy();
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void hideRating() {
        this.c.hideRating();
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setCallToAction(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "callToAction");
        this.c.setCallToAction(charSequence);
    }

    @Override // com.avito.android.design.widget.dfp_debug.DfpDebuggableView
    public void setDebugListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setDebugListener(function0);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setDescription(@Nullable CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition) {
        Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
        this.b.setBodyView(this.c.setDescription(charSequence, descriptionPosition));
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        GenericDraweeHierarchy genericDraweeHierarchy;
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        SimpleDraweeView imageView = this.c.getImageView();
        if (imageView != null && (genericDraweeHierarchy = (GenericDraweeHierarchy) imageView.getHierarchy()) != null) {
            genericDraweeHierarchy.setFailureImage(drawable, scaleType);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setIcon(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "icon");
        this.c.setIcon(uri);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setIconFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.c.setIconFailureDrawable(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setIconPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.c.setIconPlaceholder(drawable, scaleType);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setImage(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "image");
        SimpleDraweeView imageView = this.c.getImageView();
        if (imageView != null) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            SimpleDraweeViewsKt.getRequestBuilder(imageView).uri(uri).dominantColorEdge(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray4)).load();
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setNativeAd(@NotNull NativeAppInstallAd nativeAppInstallAd) {
        Intrinsics.checkNotNullParameter(nativeAppInstallAd, "nativeAd");
        this.b.setNativeAd(nativeAppInstallAd);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        GenericDraweeHierarchy genericDraweeHierarchy;
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        SimpleDraweeView imageView = this.c.getImageView();
        if (imageView != null && (genericDraweeHierarchy = (GenericDraweeHierarchy) imageView.getHierarchy()) != null) {
            genericDraweeHierarchy.setPlaceholderImage(drawable, scaleType);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void setTitle(@Nullable CharSequence charSequence) {
        this.c.setTitle(charSequence);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
    public void showRating(float f) {
        this.c.showRating(f);
    }
}
