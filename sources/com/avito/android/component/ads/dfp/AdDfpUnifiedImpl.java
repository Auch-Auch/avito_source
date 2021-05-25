package com.avito.android.component.ads.dfp;

import a2.g.r.g;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.component.ads.AdViewUtils;
import com.avito.android.design.widget.dfp_debug.DfpDebuggableView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.RoundOutlineProviderKt;
import com.avito.android.ui_components.R;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010b\u001a\u00020]¢\u0006\u0004\bc\u0010dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\rJ!\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\rJ\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u001d\u0010+\u001a\u00020\u00042\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040)H\u0016¢\u0006\u0004\b+\u0010,J!\u00101\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J!\u00103\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b3\u00102J!\u00104\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b4\u00102J!\u00105\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b5\u00102R\u0018\u00109\u001a\u0004\u0018\u0001068B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR$\u0010N\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010\u0011R\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\"\u0010\\\u001a\u00020V8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b7\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0019\u0010b\u001a\u00020]8\u0006@\u0006¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a¨\u0006e"}, d2 = {"Lcom/avito/android/component/ads/dfp/AdDfpUnifiedImpl;", "Lcom/avito/android/component/ads/dfp/AdDfpUnified;", "", "isApplication", "", "setIsApplication", "(Z)V", "Lcom/google/android/gms/ads/MediaContent;", "mediaContent", "animated", "setMediaContent", "(Lcom/google/android/gms/ads/MediaContent;Z)V", "clearImageData", "()V", "Landroid/net/Uri;", "icon", "setIcon", "(Landroid/net/Uri;)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "callToAction", "setCallToAction", "advertiser", "setAdvertiser", "destroy", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)V", "", "rating", "showRating", "(F)V", "hideRating", "Lcom/google/android/gms/ads/formats/UnifiedNativeAd;", "nativeAd", "setNativeAd", "(Lcom/google/android/gms/ads/formats/UnifiedNativeAd;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDebugListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setPlaceholder", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "setFailureDrawable", "setIconPlaceholder", "setIconFailureDrawable", "Lcom/avito/android/component/ads/dfp/AdDfpContentViews;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/component/ads/dfp/AdDfpContentViews;", "resolvedContentViews", "e", "Lcom/avito/android/component/ads/dfp/AdDfpContentViews;", "contentViews", "Lcom/avito/android/design/widget/dfp_debug/DfpDebuggableView;", "c", "Lcom/avito/android/design/widget/dfp_debug/DfpDebuggableView;", "dfpDebuggableView", "Lcom/avito/android/component/ads/dfp/AdDfpAppInstallViews;", "f", "Lcom/avito/android/component/ads/dfp/AdDfpAppInstallViews;", "appInstallViews", "Lcom/google/android/gms/ads/formats/MediaView;", "h", "Lcom/google/android/gms/ads/formats/MediaView;", "mediaView", AuthSource.BOOKING_ORDER, "Landroid/net/Uri;", "getImageUri", "()Landroid/net/Uri;", "setImageUri", "imageUri", "Lcom/google/android/gms/ads/formats/UnifiedNativeAdView;", "d", "Lcom/google/android/gms/ads/formats/UnifiedNativeAdView;", "adView", g.a, "Ljava/lang/Boolean;", "isApplicationAd", "", "I", "getImageOperationId", "()I", "setImageOperationId", "(I)V", "imageOperationId", "Landroid/view/View;", "i", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdDfpUnifiedImpl implements AdDfpUnified {
    public int a;
    @Nullable
    public Uri b;
    public final DfpDebuggableView c;
    public final UnifiedNativeAdView d;
    public AdDfpContentViews e;
    public AdDfpAppInstallViews f;
    public Boolean g;
    public MediaView h;
    @NotNull
    public final View i;

    public AdDfpUnifiedImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.i = view;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.design.widget.dfp_debug.DfpDebuggableView");
        this.c = (DfpDebuggableView) view;
        View findViewById = view.findViewById(R.id.ad_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.google.android.gms.ads.formats.UnifiedNativeAdView");
        UnifiedNativeAdView unifiedNativeAdView = (UnifiedNativeAdView) findViewById;
        this.d = unifiedNativeAdView;
        MediaView mediaView = new MediaView(view.getContext());
        mediaView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
        mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        unifiedNativeAdView.setMediaView(mediaView);
        Unit unit = Unit.INSTANCE;
        this.h = mediaView;
    }

    public final AdDfpContentViews a() {
        Boolean bool = this.g;
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return this.f;
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            return this.e;
        }
        return null;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void clearImageData() {
        setImageUri(null);
        setImageOperationId(0);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void destroy() {
        this.d.destroy();
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public int getImageOperationId() {
        return this.a;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    @Nullable
    public Uri getImageUri() {
        return this.b;
    }

    @NotNull
    public final View getView() {
        return this.i;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void hideRating() {
        AdDfpAppInstallViews adDfpAppInstallViews = this.f;
        if (adDfpAppInstallViews != null) {
            adDfpAppInstallViews.hideRating();
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setAdvertiser(@Nullable CharSequence charSequence) {
        AdDfpContentViews a3 = a();
        if (a3 != null) {
            a3.setAdvertiser(charSequence);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setCallToAction(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "callToAction");
        AdDfpContentViews a3 = a();
        if (a3 != null) {
            a3.setCallToAction(charSequence);
        }
    }

    @Override // com.avito.android.design.widget.dfp_debug.DfpDebuggableView
    public void setDebugListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c.setDebugListener(function0);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setDescription(@Nullable CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition) {
        Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
        AdDfpContentViews a3 = a();
        this.d.setBodyView(a3 != null ? a3.setDescription(charSequence, descriptionPosition) : null);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        SimpleDraweeView imageView;
        GenericDraweeHierarchy genericDraweeHierarchy;
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        AdDfpContentViews a3 = a();
        if (a3 != null && (imageView = a3.getImageView()) != null && (genericDraweeHierarchy = (GenericDraweeHierarchy) imageView.getHierarchy()) != null) {
            genericDraweeHierarchy.setFailureImage(drawable, scaleType);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setIcon(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "icon");
        AdDfpAppInstallViews adDfpAppInstallViews = this.f;
        if (adDfpAppInstallViews != null) {
            adDfpAppInstallViews.setIcon(uri);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setIconFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        AdDfpAppInstallViews adDfpAppInstallViews = this.f;
        if (adDfpAppInstallViews != null) {
            adDfpAppInstallViews.setIconFailureDrawable(drawable, scaleType);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setIconPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        AdDfpAppInstallViews adDfpAppInstallViews = this.f;
        if (adDfpAppInstallViews != null) {
            adDfpAppInstallViews.setIconPlaceholder(drawable, scaleType);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setImageOperationId(int i2) {
        this.a = i2;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setImageUri(@Nullable Uri uri) {
        this.b = uri;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setIsApplication(boolean z) {
        FrameLayout mediaViewContainer;
        if (!Intrinsics.areEqual(this.g, Boolean.valueOf(z))) {
            if (this.g != null) {
                this.d.setCallToActionView(null);
                this.d.setHeadlineView(null);
                this.d.setIconView(null);
                this.d.setStarRatingView(null);
                this.d.setAdvertiserView(null);
                this.d.setImageView(null);
                this.d.setStarRatingView(null);
                this.d.setBodyView(null);
                AdDfpContentViews a3 = a();
                if (a3 != null) {
                    a3.clearMediaViewContainer();
                }
            }
            this.g = Boolean.valueOf(z);
            if (z) {
                if (this.f == null) {
                    View inflate = ((ViewStub) this.i.findViewById(R.id.dfp_app_install_top_view)).inflate();
                    Intrinsics.checkNotNullExpressionValue(inflate, "inflatedView");
                    this.f = new AdDfpAppInstallViewsImpl(inflate);
                }
                AdDfpAppInstallViews adDfpAppInstallViews = this.f;
                if (adDfpAppInstallViews != null) {
                    adDfpAppInstallViews.setVisibility(0);
                }
                AdDfpContentViews adDfpContentViews = this.e;
                if (adDfpContentViews != null) {
                    adDfpContentViews.setVisibility(8);
                }
            } else {
                if (this.e == null) {
                    View inflate2 = ((ViewStub) this.i.findViewById(R.id.dfp_content_top_view)).inflate();
                    Intrinsics.checkNotNullExpressionValue(inflate2, "inflatedView");
                    this.e = new AdDfpContentViewsImpl(inflate2);
                }
                AdDfpContentViews adDfpContentViews2 = this.e;
                if (adDfpContentViews2 != null) {
                    adDfpContentViews2.setVisibility(0);
                }
                AdDfpAppInstallViews adDfpAppInstallViews2 = this.f;
                if (adDfpAppInstallViews2 != null) {
                    adDfpAppInstallViews2.setVisibility(8);
                }
            }
            AdDfpContentViews a4 = a();
            if (a4 != null) {
                a4.setupUnifiedAdView(this.d);
                a4.addMediaView(this.h);
                AdDfpContentViews a5 = a();
                if (a5 != null && (mediaViewContainer = a5.getMediaViewContainer()) != null) {
                    RoundOutlineProviderKt.setCornerRadius(mediaViewContainer, AdViewUtils.INSTANCE.resolveCornerRadius(a4.getImageView()));
                }
            }
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setMediaContent(@NotNull MediaContent mediaContent, boolean z) {
        Intrinsics.checkNotNullParameter(mediaContent, "mediaContent");
        this.h.setMediaContent(mediaContent);
        this.h.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
        if (mediaContent.getMainImage() == null) {
            this.h.setAlpha(0.0f);
        } else if (z) {
            this.h.animate().alpha(1.0f).setDuration(300).start();
        } else {
            this.h.setAlpha(1.0f);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setNativeAd(@NotNull UnifiedNativeAd unifiedNativeAd) {
        Intrinsics.checkNotNullParameter(unifiedNativeAd, "nativeAd");
        this.d.setNativeAd(unifiedNativeAd);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        SimpleDraweeView imageView;
        GenericDraweeHierarchy genericDraweeHierarchy;
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        AdDfpContentViews a3 = a();
        if (a3 != null && (imageView = a3.getImageView()) != null && (genericDraweeHierarchy = (GenericDraweeHierarchy) imageView.getHierarchy()) != null) {
            genericDraweeHierarchy.setPlaceholderImage(drawable, scaleType);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void setTitle(@Nullable CharSequence charSequence) {
        AdDfpContentViews a3 = a();
        if (a3 != null) {
            a3.setTitle(charSequence);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpUnified
    public void showRating(float f2) {
        AdDfpAppInstallViews adDfpAppInstallViews = this.f;
        if (adDfpAppInstallViews != null) {
            adDfpAppInstallViews.showRating(f2);
        }
    }
}
