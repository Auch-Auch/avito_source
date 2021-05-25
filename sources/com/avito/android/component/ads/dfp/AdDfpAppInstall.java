package com.avito.android.component.ads.dfp;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.design.widget.dfp_debug.DfpDebuggableView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\tH&¢\u0006\u0004\b\u001d\u0010\fJ\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\u0017J!\u0010#\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b%\u0010$J!\u0010&\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b&\u0010$J!\u0010'\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H&¢\u0006\u0004\b'\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/component/ads/dfp/AdDfpAppInstall;", "Lcom/avito/android/design/widget/dfp_debug/DfpDebuggableView;", "Landroid/net/Uri;", "image", "", "setImage", "(Landroid/net/Uri;)V", "icon", "setIcon", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)V", "", "rating", "showRating", "(F)V", "hideRating", "()V", "Lcom/google/android/gms/ads/formats/NativeAppInstallAd;", "nativeAd", "setNativeAd", "(Lcom/google/android/gms/ads/formats/NativeAppInstallAd;)V", "callToAction", "setCallToAction", "destroy", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setPlaceholder", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "setFailureDrawable", "setIconPlaceholder", "setIconFailureDrawable", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AdDfpAppInstall extends DfpDebuggableView {
    void destroy();

    void hideRating();

    void setCallToAction(@NotNull CharSequence charSequence);

    void setDescription(@Nullable CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition);

    void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType);

    void setIcon(@NotNull Uri uri);

    void setIconFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType);

    void setIconPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType);

    void setImage(@NotNull Uri uri);

    void setNativeAd(@NotNull NativeAppInstallAd nativeAppInstallAd);

    void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType);

    void setTitle(@Nullable CharSequence charSequence);

    void showRating(float f);
}
