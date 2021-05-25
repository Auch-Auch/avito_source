package com.avito.android.component.ads.yandex;

import com.avito.android.app.DescriptionPosition;
import com.yandex.mobile.ads.nativeads.NativeAppInstallAd;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J;\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/component/ads/yandex/AdYandexAppInstall;", "", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "", "bindBody", "(Lcom/avito/android/app/DescriptionPosition;)V", "Lcom/yandex/mobile/ads/nativeads/NativeAppInstallAd;", "nativeAd", "", "isClose", "Lkotlin/Function0;", "closeListener", "openListener", "bindAd", "(Lcom/yandex/mobile/ads/nativeads/NativeAppInstallAd;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AdYandexAppInstall {
    void bindAd(@NotNull NativeAppInstallAd nativeAppInstallAd, boolean z, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);

    void bindBody(@NotNull DescriptionPosition descriptionPosition);
}
