package com.avito.android.component.ads.dfp;

import a2.g.r.g;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010A\u001a\u00020<¢\u0006\u0004\bZ\u0010[J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0010J!\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010 \u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010\u001fJ\u0019\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J#\u0010)\u001a\u0004\u0018\u00010(2\b\u0010%\u001a\u0004\u0018\u00010!2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b)\u0010*J\u0019\u0010,\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b,\u0010$J\u0019\u0010.\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b.\u0010$J!\u0010/\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b/\u0010\u001fJ!\u00100\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b0\u0010\u001fR\u001e\u00106\u001a\u0004\u0018\u0001018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0019\u0010A\u001a\u00020<8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0019\u0010D\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\bB\u00108\u001a\u0004\bC\u0010:R\u001e\u0010J\u001a\u0004\u0018\u00010E8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001b\u0010P\u001a\u0004\u0018\u00010K8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001b\u0010S\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u00108\u001a\u0004\bR\u0010:R\u0019\u0010V\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\bT\u00108\u001a\u0004\bU\u0010:R\u001b\u0010Y\u001a\u0004\u0018\u0001018\u0006@\u0006¢\u0006\f\n\u0004\bW\u00103\u001a\u0004\bX\u00105¨\u0006\\"}, d2 = {"Lcom/avito/android/component/ads/dfp/AdDfpAppInstallViewsImpl;", "Lcom/avito/android/component/ads/dfp/AdDfpAppInstallViews;", "", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "", "setVisibility", "(I)V", "Lcom/google/android/gms/ads/formats/UnifiedNativeAdView;", "adView", "setupUnifiedAdView", "(Lcom/google/android/gms/ads/formats/UnifiedNativeAdView;)V", "Lcom/google/android/gms/ads/formats/MediaView;", "mediaView", "addMediaView", "(Lcom/google/android/gms/ads/formats/MediaView;)V", "clearMediaViewContainer", "()V", "Landroid/net/Uri;", "icon", "setIcon", "(Landroid/net/Uri;)V", "", "rating", "showRating", "(F)V", "hideRating", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setIconPlaceholder", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "setIconFailureDrawable", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "Landroid/widget/TextView;", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)Landroid/widget/TextView;", "advertiser", "setAdvertiser", "callToAction", "setCallToAction", "setPlaceholder", "setFailureDrawable", "Lcom/facebook/drawee/view/SimpleDraweeView;", g.a, "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "f", "Landroid/widget/TextView;", "getDescriptionTopView", "()Landroid/widget/TextView;", "descriptionTopView", "Landroid/view/View;", "i", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "c", "getInstallButton", "installButton", "Landroid/widget/FrameLayout;", "h", "Landroid/widget/FrameLayout;", "getMediaViewContainer", "()Landroid/widget/FrameLayout;", "mediaViewContainer", "Landroid/widget/RatingBar;", "d", "Landroid/widget/RatingBar;", "getRatingBarView", "()Landroid/widget/RatingBar;", "ratingBarView", "e", "getDescriptionBottomView", "descriptionBottomView", AuthSource.BOOKING_ORDER, "getTitleView", "titleView", AuthSource.SEND_ABUSE, "getIconView", "iconView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdDfpAppInstallViewsImpl implements AdDfpAppInstallViews {
    @Nullable
    public final SimpleDraweeView a;
    @NotNull
    public final TextView b;
    @NotNull
    public final TextView c;
    @Nullable
    public final RatingBar d;
    @Nullable
    public final TextView e;
    @Nullable
    public final TextView f;
    @Nullable
    public final SimpleDraweeView g;
    @Nullable
    public final FrameLayout h;
    @NotNull
    public final View i;

    public AdDfpAppInstallViewsImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.i = view;
        this.a = (SimpleDraweeView) view.findViewById(R.id.icon);
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.install_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        this.d = (RatingBar) view.findViewById(R.id.rating);
        this.e = (TextView) view.findViewById(R.id.description_bottom);
        this.f = (TextView) view.findViewById(R.id.description_top);
        this.g = (SimpleDraweeView) view.findViewById(R.id.image);
        this.h = (FrameLayout) view.findViewById(R.id.media_view_container);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void addMediaView(@NotNull MediaView mediaView) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        FrameLayout mediaViewContainer = getMediaViewContainer();
        if (mediaViewContainer != null) {
            mediaViewContainer.setVisibility(0);
        }
        FrameLayout mediaViewContainer2 = getMediaViewContainer();
        if (mediaViewContainer2 != null) {
            mediaViewContainer2.addView(mediaView);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void clearMediaViewContainer() {
        FrameLayout mediaViewContainer = getMediaViewContainer();
        if (mediaViewContainer != null) {
            mediaViewContainer.removeAllViews();
        }
    }

    @Nullable
    public final TextView getDescriptionBottomView() {
        return this.e;
    }

    @Nullable
    public final TextView getDescriptionTopView() {
        return this.f;
    }

    @Nullable
    public final SimpleDraweeView getIconView() {
        return this.a;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    @Nullable
    public SimpleDraweeView getImageView() {
        return this.g;
    }

    @NotNull
    public final TextView getInstallButton() {
        return this.c;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    @Nullable
    public FrameLayout getMediaViewContainer() {
        return this.h;
    }

    @Nullable
    public final RatingBar getRatingBarView() {
        return this.d;
    }

    @NotNull
    public final TextView getTitleView() {
        return this.b;
    }

    @NotNull
    public final View getView() {
        return this.i;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstallViews
    public void hideRating() {
        Views.setVisible(this.d, false);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setAdvertiser(@Nullable CharSequence charSequence) {
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setCallToAction(@Nullable CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    @Nullable
    public TextView setDescription(@Nullable CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition) {
        Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
        TextView textView = this.e;
        if (textView == null) {
            TextView textView2 = this.f;
            if (textView2 != null) {
                TextViews.bindText$default(textView2, charSequence, false, 2, null);
            }
            return this.f;
        } else if (descriptionPosition instanceof DescriptionPosition.Top) {
            TextView textView3 = this.f;
            if (textView3 != null) {
                TextViews.bindText$default(textView3, charSequence, false, 2, null);
            }
            Views.hide(this.e);
            return this.f;
        } else if (descriptionPosition instanceof DescriptionPosition.Bottom) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
            TextView textView4 = this.f;
            if (textView4 != null) {
                Views.hide(textView4);
            }
            return this.e;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        GenericDraweeHierarchy genericDraweeHierarchy;
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        SimpleDraweeView imageView = getImageView();
        if (imageView != null && (genericDraweeHierarchy = (GenericDraweeHierarchy) imageView.getHierarchy()) != null) {
            genericDraweeHierarchy.setFailureImage(drawable, scaleType);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstallViews
    public void setIcon(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "icon");
        SimpleDraweeView simpleDraweeView = this.a;
        if (simpleDraweeView != null) {
            simpleDraweeView.setImageURI(uri, (Object) null);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstallViews
    public void setIconFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        GenericDraweeHierarchy genericDraweeHierarchy;
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        SimpleDraweeView simpleDraweeView = this.a;
        if (simpleDraweeView != null && (genericDraweeHierarchy = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy()) != null) {
            genericDraweeHierarchy.setFailureImage(drawable, scaleType);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstallViews
    public void setIconPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        GenericDraweeHierarchy genericDraweeHierarchy;
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        SimpleDraweeView simpleDraweeView = this.a;
        if (simpleDraweeView != null && (genericDraweeHierarchy = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy()) != null) {
            genericDraweeHierarchy.setPlaceholderImage(drawable, scaleType);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        GenericDraweeHierarchy genericDraweeHierarchy;
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        SimpleDraweeView imageView = getImageView();
        if (imageView != null && (genericDraweeHierarchy = (GenericDraweeHierarchy) imageView.getHierarchy()) != null) {
            genericDraweeHierarchy.setPlaceholderImage(drawable, scaleType);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setTitle(@Nullable CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setVisibility(int i2) {
        this.i.setVisibility(i2);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setupUnifiedAdView(@NotNull UnifiedNativeAdView unifiedNativeAdView) {
        Intrinsics.checkNotNullParameter(unifiedNativeAdView, "adView");
        unifiedNativeAdView.setCallToActionView(this.c);
        unifiedNativeAdView.setHeadlineView(this.b);
        unifiedNativeAdView.setIconView(this.a);
        unifiedNativeAdView.setStarRatingView(this.d);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpAppInstallViews
    public void showRating(float f2) {
        RatingBar ratingBar = this.d;
        if (ratingBar != null) {
            ratingBar.setRating(f2);
        }
        Views.setVisible(this.d, true);
    }
}
