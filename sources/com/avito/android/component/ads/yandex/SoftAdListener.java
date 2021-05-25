package com.avito.android.component.ads.yandex;

import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.nativeads.ClosableNativeAdEventListener;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R0\u0010\f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \t*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b0\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR0\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \t*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b0\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/avito/android/component/ads/yandex/SoftAdListener;", "Lcom/yandex/mobile/ads/nativeads/ClosableNativeAdEventListener$SimpleClosableNativeAdEventListener;", "", "closeNativeAd", "()V", "onAdLeftApplication", "onAdOpened", "Ljava/lang/ref/SoftReference;", "Lkotlin/Function0;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Ljava/lang/ref/SoftReference;", "softCloseListener", AuthSource.BOOKING_ORDER, "softOpenListener", "closeListener", "openListener", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SoftAdListener extends ClosableNativeAdEventListener.SimpleClosableNativeAdEventListener {
    public final SoftReference<Function0<Unit>> a;
    public final SoftReference<Function0<Unit>> b;

    public SoftAdListener(@NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "closeListener");
        Intrinsics.checkNotNullParameter(function02, "openListener");
        this.a = new SoftReference<>(function0);
        this.b = new SoftReference<>(function02);
    }

    @Override // com.yandex.mobile.ads.nativeads.ClosableNativeAdEventListener.SimpleClosableNativeAdEventListener, com.yandex.mobile.ads.nativeads.ClosableNativeAdEventListener
    public void closeNativeAd() {
        Function0<Unit> function0 = this.a.get();
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdEventListener.SimpleNativeAdEventListener, com.yandex.mobile.ads.nativeads.NativeAdEventListener
    public void onAdLeftApplication() {
        Function0<Unit> function0 = this.b.get();
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.yandex.mobile.ads.nativeads.NativeAdEventListener.SimpleNativeAdEventListener, com.yandex.mobile.ads.nativeads.NativeAdEventListener
    public void onAdOpened() {
        Function0<Unit> function0 = this.b.get();
        if (function0 != null) {
            function0.invoke();
        }
    }
}
