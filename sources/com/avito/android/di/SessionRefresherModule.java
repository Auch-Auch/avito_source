package com.avito.android.di;

import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.AccountUpdateInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.interceptor.RequestParamsInterceptor;
import com.avito.android.remote.interceptor.SessionInterceptor;
import com.avito.android.session_refresh.RequestParamsInterceptorImpl;
import com.avito.android.session_refresh.SessionInterceptorImpl;
import com.avito.android.session_refresh.SessionRefresher;
import com.google.gson.Gson;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/di/SessionRefresherModule;", "", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/session_refresh/SessionRefresher;", "sessionRefresher", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/interceptor/SessionInterceptor;", "provideSessionInterceptor", "(Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/session_refresh/SessionRefresher;Lcom/avito/android/Features;)Lcom/avito/android/remote/interceptor/SessionInterceptor;", "Lcom/avito/android/account/AccountUpdateInteractor;", "accountUpdateInteractor", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/analytics/Analytics;", "analytics", "provideSessionRefresher", "(Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/account/AccountUpdateInteractor;Lcom/google/gson/Gson;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)Lcom/avito/android/session_refresh/SessionRefresher;", "<init>", "()V", "Bindings", "session-refresher_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Bindings.class})
public final class SessionRefresherModule {
    @NotNull
    public static final SessionRefresherModule INSTANCE = new SessionRefresherModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/SessionRefresherModule$Bindings;", "", "Lcom/avito/android/session_refresh/RequestParamsInterceptorImpl;", "impl", "Lcom/avito/android/remote/interceptor/RequestParamsInterceptor;", "bindRequestParamsInterceptor", "(Lcom/avito/android/session_refresh/RequestParamsInterceptorImpl;)Lcom/avito/android/remote/interceptor/RequestParamsInterceptor;", "session-refresher_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @Reusable
        @Binds
        @NotNull
        RequestParamsInterceptor bindRequestParamsInterceptor(@NotNull RequestParamsInterceptorImpl requestParamsInterceptorImpl);
    }

    @Provides
    @Reusable
    @NotNull
    public final SessionInterceptor provideSessionInterceptor(@NotNull AccountStorageInteractor accountStorageInteractor, @NotNull SessionRefresher sessionRefresher, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(sessionRefresher, "sessionRefresher");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SessionInterceptorImpl(accountStorageInteractor, sessionRefresher, features);
    }

    @Provides
    @Reusable
    @NotNull
    public final SessionRefresher provideSessionRefresher(@NotNull AccountStorageInteractor accountStorageInteractor, @NotNull AccountUpdateInteractor accountUpdateInteractor, @NotNull Gson gson, @NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(accountUpdateInteractor, "accountUpdateInteractor");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SessionRefresher.Impl(accountStorageInteractor, accountUpdateInteractor, gson, analytics, features);
    }
}
