package com.avito.android.cookie_provider.di;

import com.avito.android.cookie_provider.CookieExpiredTime;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.cookie_provider.CookieProviderImpl;
import com.avito.android.remote.SupportFeaturesHeaderProvider;
import com.avito.android.remote.interceptor.DateHeaderProvider;
import com.avito.android.remote.interceptor.DeviceIdHeaderProvider;
import com.avito.android.remote.interceptor.GeoHeaderProvider;
import com.avito.android.remote.interceptor.HeaderProvider;
import com.avito.android.remote.interceptor.SessionHeaderProvider;
import com.avito.android.remote.interceptor.UserAgentHeaderProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JG\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/cookie_provider/di/CookieProviderModule;", "", "Lcom/avito/android/remote/interceptor/GeoHeaderProvider;", "geoHeaderProvider", "Lcom/avito/android/remote/interceptor/SessionHeaderProvider;", "sessionHeaderProvider", "Lcom/avito/android/remote/interceptor/DateHeaderProvider;", "dateHeaderProvider", "Lcom/avito/android/remote/interceptor/DeviceIdHeaderProvider;", "deviceIdHeaderProvider", "Lcom/avito/android/remote/SupportFeaturesHeaderProvider;", "supportFeaturesHeaderProvider", "Lcom/avito/android/remote/interceptor/UserAgentHeaderProvider;", "userAgentHeaderProvider", "Lcom/avito/android/cookie_provider/CookieExpiredTime;", "cookieExpiredTime", "Lcom/avito/android/cookie_provider/CookieProvider;", "provideCookieProvider$cookie_provider_release", "(Lcom/avito/android/remote/interceptor/GeoHeaderProvider;Lcom/avito/android/remote/interceptor/SessionHeaderProvider;Lcom/avito/android/remote/interceptor/DateHeaderProvider;Lcom/avito/android/remote/interceptor/DeviceIdHeaderProvider;Lcom/avito/android/remote/SupportFeaturesHeaderProvider;Lcom/avito/android/remote/interceptor/UserAgentHeaderProvider;Lcom/avito/android/cookie_provider/CookieExpiredTime;)Lcom/avito/android/cookie_provider/CookieProvider;", "provideCookieProvider", "<init>", "()V", "Declarations", "cookie-provider_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class CookieProviderModule {
    @NotNull
    public static final CookieProviderModule INSTANCE = new CookieProviderModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/cookie_provider/di/CookieProviderModule$Declarations;", "", "Lcom/avito/android/cookie_provider/CookieExpiredTimeImpl;", "time", "Lcom/avito/android/cookie_provider/CookieExpiredTime;", "bindCookieExpiredTime", "(Lcom/avito/android/cookie_provider/CookieExpiredTimeImpl;)Lcom/avito/android/cookie_provider/CookieExpiredTime;", "cookie-provider_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        CookieExpiredTime bindCookieExpiredTime(@NotNull CookieExpiredTimeImpl cookieExpiredTimeImpl);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final CookieProvider provideCookieProvider$cookie_provider_release(@NotNull GeoHeaderProvider geoHeaderProvider, @NotNull SessionHeaderProvider sessionHeaderProvider, @NotNull DateHeaderProvider dateHeaderProvider, @NotNull DeviceIdHeaderProvider deviceIdHeaderProvider, @NotNull SupportFeaturesHeaderProvider supportFeaturesHeaderProvider, @NotNull UserAgentHeaderProvider userAgentHeaderProvider, @NotNull CookieExpiredTime cookieExpiredTime) {
        Intrinsics.checkNotNullParameter(geoHeaderProvider, "geoHeaderProvider");
        Intrinsics.checkNotNullParameter(sessionHeaderProvider, "sessionHeaderProvider");
        Intrinsics.checkNotNullParameter(dateHeaderProvider, "dateHeaderProvider");
        Intrinsics.checkNotNullParameter(deviceIdHeaderProvider, "deviceIdHeaderProvider");
        Intrinsics.checkNotNullParameter(supportFeaturesHeaderProvider, "supportFeaturesHeaderProvider");
        Intrinsics.checkNotNullParameter(userAgentHeaderProvider, "userAgentHeaderProvider");
        Intrinsics.checkNotNullParameter(cookieExpiredTime, "cookieExpiredTime");
        return new CookieProviderImpl(CollectionsKt__CollectionsKt.listOf((Object[]) new HeaderProvider[]{geoHeaderProvider, sessionHeaderProvider, dateHeaderProvider, deviceIdHeaderProvider, supportFeaturesHeaderProvider, userAgentHeaderProvider}), cookieExpiredTime);
    }
}
