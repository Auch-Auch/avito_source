package com.avito.android.di.module;

import com.avito.android.analytics.inhouse_transport.InHouseCommonSendingModule;
import com.avito.android.remote.interceptor.UserAgentInterceptor;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/di/module/UserAgentModule;", "", "Lcom/avito/android/remote/interceptor/UserAgentInterceptor;", "interceptor", "Lokhttp3/Interceptor;", "bindsUserAgentInterceptor", "(Lcom/avito/android/remote/interceptor/UserAgentInterceptor;)Lokhttp3/Interceptor;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UserAgentModule {
    @NotNull
    public static final UserAgentModule INSTANCE = new UserAgentModule();

    @Provides
    @InHouseCommonSendingModule.InHouseGzipHttpClient
    @IntoSet
    @NotNull
    public final Interceptor bindsUserAgentInterceptor(@NotNull UserAgentInterceptor userAgentInterceptor) {
        Intrinsics.checkNotNullParameter(userAgentInterceptor, "interceptor");
        return userAgentInterceptor;
    }
}
