package com.avito.android.di.module;

import com.avito.android.AnalyticsToggles;
import com.avito.android.AppConfigurationToggles;
import com.avito.android.AppFeatures;
import com.avito.android.ClickstreamToggles;
import com.avito.android.Features;
import com.avito.android.RemoteToggles;
import com.avito.android.StatsdToggles;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0002H'¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/di/module/AppFeaturesModule;", "", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/AppFeatures;", "provideAppFeatures", "(Lcom/avito/android/Features;)Lcom/avito/android/AppFeatures;", "appConfigurationToggles", "Lcom/avito/android/AppConfigurationToggles;", "provideAppConfigurationToggles", "(Lcom/avito/android/Features;)Lcom/avito/android/AppConfigurationToggles;", "clickstreamToggles", "Lcom/avito/android/ClickstreamToggles;", "provideClickstreamToggles", "(Lcom/avito/android/Features;)Lcom/avito/android/ClickstreamToggles;", "remoteToggles", "Lcom/avito/android/RemoteToggles;", "provideRemoteToggles", "(Lcom/avito/android/Features;)Lcom/avito/android/RemoteToggles;", "statsdToggles", "Lcom/avito/android/StatsdToggles;", "provideStatsdToggles", "(Lcom/avito/android/Features;)Lcom/avito/android/StatsdToggles;", "analyticsToggles", "Lcom/avito/android/AnalyticsToggles;", "provideAnalyticsToggles", "(Lcom/avito/android/Features;)Lcom/avito/android/AnalyticsToggles;", "features_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AppFeaturesModule {
    @Singleton
    @Binds
    @NotNull
    AnalyticsToggles provideAnalyticsToggles(@NotNull Features features);

    @Singleton
    @Binds
    @NotNull
    AppConfigurationToggles provideAppConfigurationToggles(@NotNull Features features);

    @Singleton
    @Binds
    @NotNull
    AppFeatures provideAppFeatures(@NotNull Features features);

    @Singleton
    @Binds
    @NotNull
    ClickstreamToggles provideClickstreamToggles(@NotNull Features features);

    @Singleton
    @Binds
    @NotNull
    RemoteToggles provideRemoteToggles(@NotNull Features features);

    @Singleton
    @Binds
    @NotNull
    StatsdToggles provideStatsdToggles(@NotNull Features features);
}
