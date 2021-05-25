package com.avito.android.component.ads.adfox;

import com.yandex.mobile.ads.nativeads.NativeImageAd;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JC\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/component/ads/adfox/AdfoxImage;", "", "Lcom/yandex/mobile/ads/nativeads/NativeImageAd;", "nativeAd", "", "isClosed", "showGrayBadge", "Lkotlin/Function0;", "", "closeListener", "openListener", "bindAd", "(Lcom/yandex/mobile/ads/nativeads/NativeImageAd;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AdfoxImage {
    void bindAd(@NotNull NativeImageAd nativeImageAd, boolean z, boolean z2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);
}
