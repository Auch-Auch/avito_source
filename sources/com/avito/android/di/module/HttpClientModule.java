package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.Features;
import com.avito.android.remote.HttpClientFactory;
import com.avito.android.remote.interceptor.ImageAcceptHeaderInterceptor;
import com.avito.android.remote.interceptor.SupportedFeaturesInterceptor;
import com.avito.android.remote.interceptor.UserAgentInterceptor;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.OkHttpInjector;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0004\u001e\u001f !B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004JI\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/avito/android/di/module/HttpClientModule;", "", "Lcom/avito/android/remote/HttpClientFactory;", "provideRetrofitHttpClientFactory$api_release", "()Lcom/avito/android/remote/HttpClientFactory;", "provideRetrofitHttpClientFactory", "httpClientFactory", "Landroid/app/Application;", "app", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/interceptor/SupportedFeaturesInterceptor;", "featuresInterceptor", "Lcom/avito/android/remote/interceptor/UserAgentInterceptor;", "userAgentInterceptor", "Lcom/avito/android/util/OkHttpInjector;", "debugInjector", "Lokhttp3/OkHttpClient;", "provideRetrofitHttpClient$api_release", "(Lcom/avito/android/remote/HttpClientFactory;Landroid/app/Application;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/Features;Lcom/avito/android/remote/interceptor/SupportedFeaturesInterceptor;Lcom/avito/android/remote/interceptor/UserAgentInterceptor;Lcom/avito/android/util/OkHttpInjector;)Lokhttp3/OkHttpClient;", "provideRetrofitHttpClient", "Lokhttp3/Interceptor;", "interceptor", "provideSimpleHttpClient$api_release", "(Lcom/avito/android/remote/HttpClientFactory;Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient;", "provideSimpleHttpClient", "<init>", "()V", "BasicClient", "Declarations", "FrescoClient", "ImageHeaderInterceptor", "api_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class HttpClientModule {

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/HttpClientModule$BasicClient;", "", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface BasicClient {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/HttpClientModule$Declarations;", "", "Lcom/avito/android/remote/interceptor/ImageAcceptHeaderInterceptor;", "interceptor", "Lokhttp3/Interceptor;", "bindImageHeaderInterceptor", "(Lcom/avito/android/remote/interceptor/ImageAcceptHeaderInterceptor;)Lokhttp3/Interceptor;", "api_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @ImageHeaderInterceptor
        @NotNull
        Interceptor bindImageHeaderInterceptor(@NotNull ImageAcceptHeaderInterceptor imageAcceptHeaderInterceptor);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/HttpClientModule$FrescoClient;", "", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface FrescoClient {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/HttpClientModule$ImageHeaderInterceptor;", "", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface ImageHeaderInterceptor {
    }

    @Provides
    @BasicClient
    @NotNull
    @Singleton
    public final OkHttpClient provideRetrofitHttpClient$api_release(@NotNull HttpClientFactory httpClientFactory, @NotNull Application application, @NotNull BuildInfo buildInfo, @NotNull Features features, @NotNull SupportedFeaturesInterceptor supportedFeaturesInterceptor, @NotNull UserAgentInterceptor userAgentInterceptor, @Nullable OkHttpInjector okHttpInjector) {
        Intrinsics.checkNotNullParameter(httpClientFactory, "httpClientFactory");
        Intrinsics.checkNotNullParameter(application, "app");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(supportedFeaturesInterceptor, "featuresInterceptor");
        Intrinsics.checkNotNullParameter(userAgentInterceptor, "userAgentInterceptor");
        return httpClientFactory.getClient(30, application, features, supportedFeaturesInterceptor, userAgentInterceptor, okHttpInjector, buildInfo.isDebug());
    }

    @Provides
    @NotNull
    public final HttpClientFactory provideRetrofitHttpClientFactory$api_release() {
        return new HttpClientFactory();
    }

    @Provides
    @NotNull
    @FrescoClient
    @Singleton
    public final OkHttpClient provideSimpleHttpClient$api_release(@NotNull HttpClientFactory httpClientFactory, @ImageHeaderInterceptor @NotNull Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(httpClientFactory, "httpClientFactory");
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        return httpClientFactory.getSimpleClient(30, interceptor);
    }
}
