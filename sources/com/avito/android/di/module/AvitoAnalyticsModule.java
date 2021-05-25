package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.analytics.di.CrashlyticsModule;
import com.avito.android.analytics.di.PixelModule;
import com.avito.android.analytics.provider.CurrentUserIdProvider;
import com.avito.android.analytics.provider.CurrentUserIdProviderImpl;
import com.avito.android.analytics.provider.metrica.Metrica;
import com.avito.android.analytics.provider.metrica.MetricaImpl;
import com.avito.android.analytics_adjust.di.AdjustModule;
import com.avito.android.analytics_firebase.di.FirebaseModule;
import com.avito.android.di.module.HttpClientModule;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.OkHttpInjector;
import com.avito.android.version_conflict.ConfigStorage;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0010\u001a\u00020\f2\u000e\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0017¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/di/module/AvitoAnalyticsModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/version_conflict/ConfigStorage;", "configStorage", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/provider/metrica/Metrica;", "provideMetrica", "(Landroid/app/Application;Lcom/avito/android/version_conflict/ConfigStorage;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/analytics/provider/metrica/Metrica;", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", "httpClient", "Lcom/avito/android/util/OkHttpInjector;", "debugInjector", "provideOkHttpClient", "(Ldagger/Lazy;Lcom/avito/android/util/OkHttpInjector;)Lokhttp3/OkHttpClient;", "<init>", "()V", "Declarations", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {CoreAnalyticsModule.class, HttpClientModule.class, ApiAnalyticsModule.class, ClickStreamModule.class, StatsdModule.class, AdjustModule.class, AdjustTokenModule.class, CrashlyticsModule.class, FirebaseModule.class, PixelModule.class, Declarations.class})
public class AvitoAnalyticsModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/AvitoAnalyticsModule$Declarations;", "", "Lcom/avito/android/analytics/provider/CurrentUserIdProviderImpl;", "impl", "Lcom/avito/android/analytics/provider/CurrentUserIdProvider;", "bindCurrentUserIdProvider", "(Lcom/avito/android/analytics/provider/CurrentUserIdProviderImpl;)Lcom/avito/android/analytics/provider/CurrentUserIdProvider;", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Singleton
        @Binds
        @NotNull
        CurrentUserIdProvider bindCurrentUserIdProvider(@NotNull CurrentUserIdProviderImpl currentUserIdProviderImpl);
    }

    @Provides
    @Singleton
    @Nullable
    public Metrica provideMetrica(@NotNull Application application, @NotNull ConfigStorage configStorage, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(configStorage, "configStorage");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        if (configStorage.isYandexReportsEnabled()) {
            return new MetricaImpl(application, buildInfo);
        }
        return null;
    }

    @Provides
    @NotNull
    @Singleton
    @PixelModule.PixelHttpClient
    public OkHttpClient provideOkHttpClient(@HttpClientModule.BasicClient @NotNull Lazy<OkHttpClient> lazy, @Nullable OkHttpInjector okHttpInjector) {
        Intrinsics.checkNotNullParameter(lazy, "httpClient");
        OkHttpClient.Builder newBuilder = lazy.get().newBuilder();
        newBuilder.interceptors().clear();
        if (okHttpInjector != null) {
            okHttpInjector.inject(newBuilder);
        }
        return newBuilder.build();
    }
}
