package com.avito.android.component.ads.yandex;

import android.graphics.drawable.Drawable;
import android.widget.Button;
import com.yandex.mobile.ads.nativeads.NativeContentAd;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010JC\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/component/ads/yandex/AdYandexContent;", "", "Landroid/widget/Button;", "view", "", "setFeedbackView", "(Landroid/widget/Button;)V", "", "clipToOutline", "setImageClipToOutline", "(Z)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "hasImage", "()Z", "Lcom/yandex/mobile/ads/nativeads/NativeContentAd;", "nativeAd", "isClose", "isRedesign", "Lkotlin/Function0;", "closeListener", "openListener", "bindAd", "(Lcom/yandex/mobile/ads/nativeads/NativeContentAd;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AdYandexContent {
    void bindAd(@NotNull NativeContentAd nativeContentAd, boolean z, boolean z2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);

    boolean hasImage();

    void setFeedbackView(@NotNull Button button);

    void setImage(@Nullable Drawable drawable);

    void setImageClipToOutline(boolean z);
}
