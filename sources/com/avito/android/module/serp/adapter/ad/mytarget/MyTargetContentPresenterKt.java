package com.avito.android.module.serp.adapter.ad.mytarget;

import com.avito.android.component.ads.mytarget.AdMyTarget;
import com.avito.android.serp.ad.MyTargetBanner;
import com.avito.android.serp.ad.MyTargetBannerKt;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.util.Logs;
import com.my.target.common.models.ImageData;
import com.my.target.nativeads.NativeAd;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/component/ads/mytarget/AdMyTarget;", "Lcom/avito/android/serp/ad/MyTargetBanner;", "banner", "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "bgProvider", "", "bindMedia", "(Lcom/avito/android/component/ads/mytarget/AdMyTarget;Lcom/avito/android/serp/ad/MyTargetBanner;Lcom/avito/android/serp/ad/MyTargetImageBgProvider;)V", "serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class MyTargetContentPresenterKt {

    public static final class a<T> implements Consumer<Integer> {
        public final /* synthetic */ AdMyTarget a;

        public a(AdMyTarget adMyTarget) {
            this.a = adMyTarget;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            this.a.setImageBgDisposable(null);
            AdMyTarget adMyTarget = this.a;
            Intrinsics.checkNotNullExpressionValue(num2, "calculatedColor");
            adMyTarget.setMediaViewBackground(num2.intValue());
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("AdMyTarget.bindMedia image bg error", th);
        }
    }

    public static final void bindMedia(@NotNull AdMyTarget adMyTarget, @NotNull MyTargetBanner myTargetBanner, @NotNull MyTargetImageBgProvider myTargetImageBgProvider) {
        Intrinsics.checkNotNullParameter(adMyTarget, "$this$bindMedia");
        Intrinsics.checkNotNullParameter(myTargetBanner, "banner");
        Intrinsics.checkNotNullParameter(myTargetImageBgProvider, "bgProvider");
        adMyTarget.disposeImageBg();
        NativeAd ad = myTargetBanner.getAd();
        Integer bgColor = myTargetBanner.getBgColor();
        ImageData bgImageData = MyTargetBannerKt.bgImageData(ad);
        String url = bgImageData != null ? bgImageData.getUrl() : null;
        if (bgColor != null) {
            adMyTarget.setMediaViewBackground(bgColor.intValue());
        } else if (url == null) {
            adMyTarget.setMediaViewBackground(-1);
        } else {
            adMyTarget.setMediaViewBackground(0);
            adMyTarget.setImageBgDisposable(myTargetImageBgProvider.observe(url).subscribe(new a(adMyTarget), b.a));
        }
    }
}
