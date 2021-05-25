package com.avito.android.component.ads.dfp;

import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.avito.android.app.DescriptionPosition;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u001c\u0010\u0014J\u0019\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u001e\u0010\u0014J!\u0010#\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b%\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/avito/android/component/ads/dfp/AdDfpContentViews;", "", "", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "", "setVisibility", "(I)V", "Lcom/google/android/gms/ads/formats/UnifiedNativeAdView;", "adView", "setupUnifiedAdView", "(Lcom/google/android/gms/ads/formats/UnifiedNativeAdView;)V", "Lcom/google/android/gms/ads/formats/MediaView;", "mediaView", "addMediaView", "(Lcom/google/android/gms/ads/formats/MediaView;)V", "clearMediaViewContainer", "()V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "Landroid/widget/TextView;", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)Landroid/widget/TextView;", "advertiser", "setAdvertiser", "callToAction", "setCallToAction", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setPlaceholder", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "setFailureDrawable", "Landroid/widget/FrameLayout;", "getMediaViewContainer", "()Landroid/widget/FrameLayout;", "mediaViewContainer", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AdDfpContentViews {
    void addMediaView(@NotNull MediaView mediaView);

    void clearMediaViewContainer();

    @Nullable
    SimpleDraweeView getImageView();

    @Nullable
    FrameLayout getMediaViewContainer();

    void setAdvertiser(@Nullable CharSequence charSequence);

    void setCallToAction(@Nullable CharSequence charSequence);

    @Nullable
    TextView setDescription(@Nullable CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition);

    void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType);

    void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType);

    void setTitle(@Nullable CharSequence charSequence);

    void setVisibility(int i);

    void setupUnifiedAdView(@NotNull UnifiedNativeAdView unifiedNativeAdView);
}
