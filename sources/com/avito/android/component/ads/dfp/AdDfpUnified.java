package com.avito.android.component.ads.dfp;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.design.widget.dfp_debug.DfpDebuggableView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0019\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b\u001f\u0010\rJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0012H&¢\u0006\u0004\b%\u0010\u0015J\u0019\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b'\u0010\u0015J\u000f\u0010(\u001a\u00020\u0004H&¢\u0006\u0004\b(\u0010\rJ!\u0010-\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H&¢\u0006\u0004\b-\u0010.J!\u0010/\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H&¢\u0006\u0004\b/\u0010.J!\u00100\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H&¢\u0006\u0004\b0\u0010.J!\u00101\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H&¢\u0006\u0004\b1\u0010.R\u001c\u00107\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010;\u001a\u0004\u0018\u00010\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010\u0011¨\u0006<"}, d2 = {"Lcom/avito/android/component/ads/dfp/AdDfpUnified;", "Lcom/avito/android/design/widget/dfp_debug/DfpDebuggableView;", "", "isApplication", "", "setIsApplication", "(Z)V", "Lcom/google/android/gms/ads/MediaContent;", "mediaContent", "animated", "setMediaContent", "(Lcom/google/android/gms/ads/MediaContent;Z)V", "clearImageData", "()V", "Landroid/net/Uri;", "icon", "setIcon", "(Landroid/net/Uri;)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)V", "", "rating", "showRating", "(F)V", "hideRating", "Lcom/google/android/gms/ads/formats/UnifiedNativeAd;", "nativeAd", "setNativeAd", "(Lcom/google/android/gms/ads/formats/UnifiedNativeAd;)V", "callToAction", "setCallToAction", "advertiser", "setAdvertiser", "destroy", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setPlaceholder", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "setFailureDrawable", "setIconPlaceholder", "setIconFailureDrawable", "", "getImageOperationId", "()I", "setImageOperationId", "(I)V", "imageOperationId", "getImageUri", "()Landroid/net/Uri;", "setImageUri", "imageUri", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AdDfpUnified extends DfpDebuggableView {
    void clearImageData();

    void destroy();

    int getImageOperationId();

    @Nullable
    Uri getImageUri();

    void hideRating();

    void setAdvertiser(@Nullable CharSequence charSequence);

    void setCallToAction(@NotNull CharSequence charSequence);

    void setDescription(@Nullable CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition);

    void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType);

    void setIcon(@NotNull Uri uri);

    void setIconFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType);

    void setIconPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType);

    void setImageOperationId(int i);

    void setImageUri(@Nullable Uri uri);

    void setIsApplication(boolean z);

    void setMediaContent(@NotNull MediaContent mediaContent, boolean z);

    void setNativeAd(@NotNull UnifiedNativeAd unifiedNativeAd);

    void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType);

    void setTitle(@Nullable CharSequence charSequence);

    void showRating(float f);
}
