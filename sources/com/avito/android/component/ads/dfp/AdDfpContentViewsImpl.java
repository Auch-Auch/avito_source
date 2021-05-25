package com.avito.android.component.ads.dfp;

import a2.g.r.g;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010B\u001a\u00020=¢\u0006\u0004\bI\u0010JJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001c\u0010\u0014J\u0019\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001e\u0010\u0014J!\u0010#\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b%\u0010$R\u001e\u0010+\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00103\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010-\u001a\u0004\b2\u0010/R\u001b\u00106\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b5\u0010/R\u001c\u0010<\u001a\u0002078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0019\u0010B\u001a\u00020=8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0019\u0010E\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010-\u001a\u0004\bD\u0010/R\u001b\u0010H\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010-\u001a\u0004\bG\u0010/¨\u0006K"}, d2 = {"Lcom/avito/android/component/ads/dfp/AdDfpContentViewsImpl;", "Lcom/avito/android/component/ads/dfp/AdDfpContentViews;", "", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "", "setVisibility", "(I)V", "Lcom/google/android/gms/ads/formats/UnifiedNativeAdView;", "adView", "setupUnifiedAdView", "(Lcom/google/android/gms/ads/formats/UnifiedNativeAdView;)V", "Lcom/google/android/gms/ads/formats/MediaView;", "mediaView", "addMediaView", "(Lcom/google/android/gms/ads/formats/MediaView;)V", "clearMediaViewContainer", "()V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "Landroid/widget/TextView;", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)Landroid/widget/TextView;", "advertiser", "setAdvertiser", "callToAction", "setCallToAction", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setPlaceholder", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "setFailureDrawable", "Landroid/widget/FrameLayout;", g.a, "Landroid/widget/FrameLayout;", "getMediaViewContainer", "()Landroid/widget/FrameLayout;", "mediaViewContainer", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "getDescriptionTopView", "()Landroid/widget/TextView;", "descriptionTopView", "e", "getCallToActionView", "callToActionView", "d", "getAdvertiserView", "advertiserView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "f", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/view/View;", "h", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", AuthSource.SEND_ABUSE, "getTitleView", "titleView", "c", "getDescriptionBottomView", "descriptionBottomView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdDfpContentViewsImpl implements AdDfpContentViews {
    @NotNull
    public final TextView a;
    @Nullable
    public final TextView b;
    @Nullable
    public final TextView c;
    @Nullable
    public final TextView d;
    @Nullable
    public final TextView e;
    @NotNull
    public final SimpleDraweeView f;
    @Nullable
    public final FrameLayout g;
    @NotNull
    public final View h;

    public AdDfpContentViewsImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.h = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        this.b = (TextView) view.findViewById(R.id.description_top);
        this.c = (TextView) view.findViewById(R.id.description_bottom);
        this.d = (TextView) view.findViewById(R.id.domain);
        this.e = (TextView) view.findViewById(R.id.more_info_button);
        View findViewById2 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.f = (SimpleDraweeView) findViewById2;
        this.g = (FrameLayout) view.findViewById(R.id.media_view_container);
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
    public final TextView getAdvertiserView() {
        return this.d;
    }

    @Nullable
    public final TextView getCallToActionView() {
        return this.e;
    }

    @Nullable
    public final TextView getDescriptionBottomView() {
        return this.c;
    }

    @Nullable
    public final TextView getDescriptionTopView() {
        return this.b;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    @NotNull
    public SimpleDraweeView getImageView() {
        return this.f;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    @Nullable
    public FrameLayout getMediaViewContainer() {
        return this.g;
    }

    @NotNull
    public final TextView getTitleView() {
        return this.a;
    }

    @NotNull
    public final View getView() {
        return this.h;
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setAdvertiser(@Nullable CharSequence charSequence) {
        TextView textView = this.d;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setCallToAction(@Nullable CharSequence charSequence) {
        TextView textView = this.e;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    @Nullable
    public TextView setDescription(@Nullable CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition) {
        Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
        TextView textView = this.c;
        if (textView == null) {
            TextView textView2 = this.b;
            if (textView2 != null) {
                TextViews.bindText$default(textView2, charSequence, false, 2, null);
            }
            return this.b;
        } else if (descriptionPosition instanceof DescriptionPosition.Top) {
            TextView textView3 = this.b;
            if (textView3 != null) {
                TextViews.bindText$default(textView3, charSequence, false, 2, null);
            }
            Views.hide(this.c);
            return this.b;
        } else if (descriptionPosition instanceof DescriptionPosition.Bottom) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
            TextView textView4 = this.b;
            if (textView4 != null) {
                Views.hide(textView4);
            }
            return this.c;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getImageView().getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.setFailureImage(drawable, scaleType);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getImageView().getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.setPlaceholderImage(drawable, scaleType);
        }
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setTitle(@Nullable CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setVisibility(int i) {
        this.h.setVisibility(i);
    }

    @Override // com.avito.android.component.ads.dfp.AdDfpContentViews
    public void setupUnifiedAdView(@NotNull UnifiedNativeAdView unifiedNativeAdView) {
        Intrinsics.checkNotNullParameter(unifiedNativeAdView, "adView");
        unifiedNativeAdView.setHeadlineView(this.a);
        unifiedNativeAdView.setAdvertiserView(this.d);
        unifiedNativeAdView.setCallToActionView(this.e);
    }
}
