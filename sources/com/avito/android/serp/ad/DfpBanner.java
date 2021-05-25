package com.avito.android.serp.ad;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdNetworkBanner;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/serp/ad/DfpBanner;", "Lcom/avito/android/remote/model/AdNetworkBanner;", "<init>", "()V", "DfpAppInstallBanner", "DfpContentBanner", "DfpUnifiedBanner", "Lcom/avito/android/serp/ad/DfpBanner$DfpUnifiedBanner;", "Lcom/avito/android/serp/ad/DfpBanner$DfpContentBanner;", "Lcom/avito/android/serp/ad/DfpBanner$DfpAppInstallBanner;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class DfpBanner implements AdNetworkBanner {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/serp/ad/DfpBanner$DfpAppInstallBanner;", "Lcom/avito/android/serp/ad/DfpBanner;", "Lcom/google/android/gms/ads/formats/NativeAppInstallAd;", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/ads/formats/NativeAppInstallAd;", "getAppInstallAd", "()Lcom/google/android/gms/ads/formats/NativeAppInstallAd;", "appInstallAd", "Lcom/avito/android/serp/ad/AdEventListenerHolder;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/ad/AdEventListenerHolder;", "getAdEventListenerHolder", "()Lcom/avito/android/serp/ad/AdEventListenerHolder;", "adEventListenerHolder", "<init>", "(Lcom/google/android/gms/ads/formats/NativeAppInstallAd;Lcom/avito/android/serp/ad/AdEventListenerHolder;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class DfpAppInstallBanner extends DfpBanner {
        @NotNull
        public final NativeAppInstallAd a;
        @NotNull
        public final AdEventListenerHolder b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DfpAppInstallBanner(@NotNull NativeAppInstallAd nativeAppInstallAd, @NotNull AdEventListenerHolder adEventListenerHolder) {
            super(null);
            Intrinsics.checkNotNullParameter(nativeAppInstallAd, "appInstallAd");
            Intrinsics.checkNotNullParameter(adEventListenerHolder, "adEventListenerHolder");
            this.a = nativeAppInstallAd;
            this.b = adEventListenerHolder;
        }

        @NotNull
        public final AdEventListenerHolder getAdEventListenerHolder() {
            return this.b;
        }

        @NotNull
        public final NativeAppInstallAd getAppInstallAd() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/serp/ad/DfpBanner$DfpContentBanner;", "Lcom/avito/android/serp/ad/DfpBanner;", "Lcom/avito/android/serp/ad/AdEventListenerHolder;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/ad/AdEventListenerHolder;", "getAdEventListenerHolder", "()Lcom/avito/android/serp/ad/AdEventListenerHolder;", "adEventListenerHolder", "Lcom/google/android/gms/ads/formats/NativeContentAd;", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/ads/formats/NativeContentAd;", "getContentAd", "()Lcom/google/android/gms/ads/formats/NativeContentAd;", "contentAd", "<init>", "(Lcom/google/android/gms/ads/formats/NativeContentAd;Lcom/avito/android/serp/ad/AdEventListenerHolder;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class DfpContentBanner extends DfpBanner {
        @NotNull
        public final NativeContentAd a;
        @NotNull
        public final AdEventListenerHolder b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DfpContentBanner(@NotNull NativeContentAd nativeContentAd, @NotNull AdEventListenerHolder adEventListenerHolder) {
            super(null);
            Intrinsics.checkNotNullParameter(nativeContentAd, "contentAd");
            Intrinsics.checkNotNullParameter(adEventListenerHolder, "adEventListenerHolder");
            this.a = nativeContentAd;
            this.b = adEventListenerHolder;
        }

        @NotNull
        public final AdEventListenerHolder getAdEventListenerHolder() {
            return this.b;
        }

        @NotNull
        public final NativeContentAd getContentAd() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/serp/ad/DfpBanner$DfpUnifiedBanner;", "Lcom/avito/android/serp/ad/DfpBanner;", "Lcom/google/android/gms/ads/formats/UnifiedNativeAd;", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/ads/formats/UnifiedNativeAd;", "getAd", "()Lcom/google/android/gms/ads/formats/UnifiedNativeAd;", "ad", "Lcom/avito/android/serp/ad/AdEventListenerHolder;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/ad/AdEventListenerHolder;", "getAdEventListenerHolder", "()Lcom/avito/android/serp/ad/AdEventListenerHolder;", "adEventListenerHolder", "<init>", "(Lcom/google/android/gms/ads/formats/UnifiedNativeAd;Lcom/avito/android/serp/ad/AdEventListenerHolder;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class DfpUnifiedBanner extends DfpBanner {
        @NotNull
        public final UnifiedNativeAd a;
        @NotNull
        public final AdEventListenerHolder b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DfpUnifiedBanner(@NotNull UnifiedNativeAd unifiedNativeAd, @NotNull AdEventListenerHolder adEventListenerHolder) {
            super(null);
            Intrinsics.checkNotNullParameter(unifiedNativeAd, "ad");
            Intrinsics.checkNotNullParameter(adEventListenerHolder, "adEventListenerHolder");
            this.a = unifiedNativeAd;
            this.b = adEventListenerHolder;
        }

        @NotNull
        public final UnifiedNativeAd getAd() {
            return this.a;
        }

        @NotNull
        public final AdEventListenerHolder getAdEventListenerHolder() {
            return this.b;
        }
    }

    public DfpBanner() {
    }

    public DfpBanner(j jVar) {
    }
}
