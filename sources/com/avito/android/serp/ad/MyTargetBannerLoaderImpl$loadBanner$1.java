package com.avito.android.serp.ad;

import android.content.Context;
import android.graphics.Bitmap;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.MyTargetPassbackEvent;
import com.avito.android.remote.model.MyTargetBannerItem;
import com.avito.android.serp.ad.MyTargetBanner;
import com.avito.android.serp.ad.MyTargetBannerLoader;
import com.my.target.common.models.ImageData;
import com.my.target.nativeads.NativeAd;
import com.my.target.nativeads.banners.NativePromoBanner;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
public final class MyTargetBannerLoaderImpl$loadBanner$1<T> implements ObservableOnSubscribe<MyTargetBanner> {
    public final /* synthetic */ MyTargetBannerItem a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ MyTargetImageBgProvider c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ AdEventListenerHolder e;
    public final /* synthetic */ Analytics f;
    public final /* synthetic */ boolean g;

    public MyTargetBannerLoaderImpl$loadBanner$1(MyTargetBannerItem myTargetBannerItem, Context context, MyTargetImageBgProvider myTargetImageBgProvider, Ref.ObjectRef objectRef, AdEventListenerHolder adEventListenerHolder, Analytics analytics, boolean z) {
        this.a = myTargetBannerItem;
        this.b = context;
        this.c = myTargetImageBgProvider;
        this.d = objectRef;
        this.e = adEventListenerHolder;
        this.f = analytics;
        this.g = z;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(final ObservableEmitter<MyTargetBanner> observableEmitter) {
        NativeAd nativeAd = new NativeAd(this.a.getId().intValue(), this.b);
        Map<String, String> params = this.a.getParams();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nativeAd.getCustomParams().setCustomParam(entry.getKey(), entry.getValue());
            }
        }
        nativeAd.setMediaListener(new NativeAd.NativeAdMediaListener(this) { // from class: com.avito.android.serp.ad.MyTargetBannerLoaderImpl$loadBanner$1.2
            public final /* synthetic */ MyTargetBannerLoaderImpl$loadBanner$1 a;

            /* renamed from: com.avito.android.serp.ad.MyTargetBannerLoaderImpl$loadBanner$1$2$a */
            public static final class a<T> implements Consumer<Integer> {
                public final /* synthetic */ AnonymousClass2 a;

                public a(AnonymousClass2 r1, ImageData imageData) {
                    this.a = r1;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.rxjava3.functions.Consumer
                public void accept(Integer num) {
                    Integer num2 = num;
                    T t = this.a.a.d.element;
                    if (t != null) {
                        t.setBgColor(num2);
                    }
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.my.target.nativeads.NativeAd.NativeAdMediaListener
            public void onIconLoad(@NotNull NativeAd nativeAd2) {
                Intrinsics.checkNotNullParameter(nativeAd2, "p0");
            }

            @Override // com.my.target.nativeads.NativeAd.NativeAdMediaListener
            public void onImageLoad(@NotNull NativeAd nativeAd2) {
                Bitmap bitmap;
                Intrinsics.checkNotNullParameter(nativeAd2, "ad");
                ImageData bgImageData = MyTargetBannerKt.bgImageData(nativeAd2);
                if (bgImageData != null && (bitmap = bgImageData.getBitmap()) != null) {
                    MyTargetImageBgProvider myTargetImageBgProvider = this.a.c;
                    Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                    String url = bgImageData.getUrl();
                    Intrinsics.checkNotNullExpressionValue(url, "imageData.url");
                    myTargetImageBgProvider.calculateBgColor(bitmap, url).subscribe(new a(this, bgImageData), Functions.emptyConsumer());
                }
            }
        });
        nativeAd.setListener(new NativeAd.NativeAdListener(this) { // from class: com.avito.android.serp.ad.MyTargetBannerLoaderImpl$loadBanner$1.3
            public final /* synthetic */ MyTargetBannerLoaderImpl$loadBanner$1 a;

            {
                this.a = r1;
            }

            @Override // com.my.target.nativeads.NativeAd.NativeAdListener
            public void onClick(@NotNull NativeAd nativeAd2) {
                Intrinsics.checkNotNullParameter(nativeAd2, "ad");
                AdEventListener adEventListener = this.a.e.getAdEventListener();
                if (adEventListener != null) {
                    adEventListener.onAdClick();
                }
            }

            @Override // com.my.target.nativeads.NativeAd.NativeAdListener
            public void onLoad(@NotNull NativePromoBanner nativePromoBanner, @NotNull NativeAd nativeAd2) {
                Intrinsics.checkNotNullParameter(nativePromoBanner, "promoBanner");
                Intrinsics.checkNotNullParameter(nativeAd2, "ad");
                NativePromoBanner banner = nativeAd2.getBanner();
                if (banner != null) {
                    Intrinsics.checkNotNullExpressionValue(banner, "it");
                    if (Intrinsics.areEqual(banner.getNavigationType(), "store")) {
                        MyTargetBannerLoaderImpl$loadBanner$1 myTargetBannerLoaderImpl$loadBanner$1 = this.a;
                        myTargetBannerLoaderImpl$loadBanner$1.d.element = (T) new MyTargetBanner.MyTargetAppInstallBanner(nativeAd2, myTargetBannerLoaderImpl$loadBanner$1.e);
                        observableEmitter.onNext(this.a.d.element);
                        observableEmitter.onComplete();
                        return;
                    }
                    MyTargetBannerLoaderImpl$loadBanner$1 myTargetBannerLoaderImpl$loadBanner$12 = this.a;
                    myTargetBannerLoaderImpl$loadBanner$12.d.element = (T) new MyTargetBanner.MyTargetContentBanner(nativeAd2, myTargetBannerLoaderImpl$loadBanner$12.e);
                    observableEmitter.onNext(this.a.d.element);
                    observableEmitter.onComplete();
                    return;
                }
                observableEmitter.tryOnError(new MyTargetBannerLoader.MyTargetBannerLoaderException("MyTarget banner is null", nativeAd2));
            }

            @Override // com.my.target.nativeads.NativeAd.NativeAdListener
            public void onNoAd(@NotNull String str, @NotNull NativeAd nativeAd2) {
                Intrinsics.checkNotNullParameter(str, "reason");
                Intrinsics.checkNotNullParameter(nativeAd2, "ad");
                MyTargetBannerLoaderImpl$loadBanner$1 myTargetBannerLoaderImpl$loadBanner$1 = this.a;
                myTargetBannerLoaderImpl$loadBanner$1.f.track(new MyTargetPassbackEvent(myTargetBannerLoaderImpl$loadBanner$1.a.getId().intValue(), this.a.g));
                observableEmitter.tryOnError(new MyTargetBannerLoader.MyTargetBannerLoaderException(str, nativeAd2));
            }

            @Override // com.my.target.nativeads.NativeAd.NativeAdListener
            public void onShow(@NotNull NativeAd nativeAd2) {
                Intrinsics.checkNotNullParameter(nativeAd2, "ad");
            }

            @Override // com.my.target.nativeads.NativeAd.NativeAdListener
            public void onVideoComplete(@NotNull NativeAd nativeAd2) {
                Intrinsics.checkNotNullParameter(nativeAd2, "ad");
            }

            @Override // com.my.target.nativeads.NativeAd.NativeAdListener
            public void onVideoPause(@NotNull NativeAd nativeAd2) {
                Intrinsics.checkNotNullParameter(nativeAd2, "ad");
            }

            @Override // com.my.target.nativeads.NativeAd.NativeAdListener
            public void onVideoPlay(@NotNull NativeAd nativeAd2) {
                Intrinsics.checkNotNullParameter(nativeAd2, "ad");
            }
        });
        nativeAd.setCachePolicy(3);
        nativeAd.load();
    }
}
