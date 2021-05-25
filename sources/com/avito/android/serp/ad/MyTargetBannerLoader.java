package com.avito.android.serp.ad;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.MyTargetBannerItem;
import com.my.target.nativeads.NativeAd;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/serp/ad/MyTargetBannerLoader;", "", "Lcom/avito/android/remote/model/MyTargetBannerItem;", "banner", "", "isFallback", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/ad/MyTargetBanner;", "loadBanner", "(Lcom/avito/android/remote/model/MyTargetBannerItem;Z)Lio/reactivex/rxjava3/core/Observable;", "MyTargetBannerLoaderException", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface MyTargetBannerLoader {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable loadBanner$default(MyTargetBannerLoader myTargetBannerLoader, MyTargetBannerItem myTargetBannerItem, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return myTargetBannerLoader.loadBanner(myTargetBannerItem, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadBanner");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/serp/ad/MyTargetBannerLoader$MyTargetBannerLoaderException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "reason", "Lcom/my/target/nativeads/NativeAd;", AuthSource.BOOKING_ORDER, "Lcom/my/target/nativeads/NativeAd;", "getAd", "()Lcom/my/target/nativeads/NativeAd;", "ad", "<init>", "(Ljava/lang/String;Lcom/my/target/nativeads/NativeAd;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class MyTargetBannerLoaderException extends Exception {
        @NotNull
        public final String a;
        @NotNull
        public final NativeAd b;

        public MyTargetBannerLoaderException(@NotNull String str, @NotNull NativeAd nativeAd) {
            Intrinsics.checkNotNullParameter(str, "reason");
            Intrinsics.checkNotNullParameter(nativeAd, "ad");
            this.a = str;
            this.b = nativeAd;
        }

        @NotNull
        public final NativeAd getAd() {
            return this.b;
        }

        @NotNull
        public final String getReason() {
            return this.a;
        }
    }

    @NotNull
    Observable<MyTargetBanner> loadBanner(@NotNull MyTargetBannerItem myTargetBannerItem, boolean z);
}
