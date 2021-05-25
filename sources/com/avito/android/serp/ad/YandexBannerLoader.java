package com.avito.android.serp.ad;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.YandexBannerItem;
import com.yandex.mobile.ads.nativeads.NativeGenericAd;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ-\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/ad/YandexBannerLoader;", "", "Lcom/avito/android/remote/model/YandexBannerItem;", "banner", "", "isFallback", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/ad/YandexBanner;", "Lcom/yandex/mobile/ads/nativeads/NativeGenericAd;", "loadBanner", "(Lcom/avito/android/remote/model/YandexBannerItem;Z)Lio/reactivex/rxjava3/core/Observable;", "YandexBannerLoadingException", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface YandexBannerLoader {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable loadBanner$default(YandexBannerLoader yandexBannerLoader, YandexBannerItem yandexBannerItem, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return yandexBannerLoader.loadBanner(yandexBannerItem, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadBanner");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/serp/ad/YandexBannerLoader$YandexBannerLoadingException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "", AuthSource.SEND_ABUSE, "I", "getCode", "()I", "code", "<init>", "(ILjava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class YandexBannerLoadingException extends Exception {
        public final int a;
        @Nullable
        public final String b;

        public YandexBannerLoadingException(int i, @Nullable String str) {
            this.a = i;
            this.b = str;
        }

        public final int getCode() {
            return this.a;
        }

        @Nullable
        public final String getDescription() {
            return this.b;
        }
    }

    @NotNull
    Observable<YandexBanner<NativeGenericAd>> loadBanner(@NotNull YandexBannerItem yandexBannerItem, boolean z);
}
