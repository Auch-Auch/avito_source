package com.avito.android.analytics.statsd;

import android.app.Application;
import com.avito.android.AnalyticsToggles;
import com.avito.android.StatsdToggles;
import com.avito.android.analytics.EventObserver;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.analytics.inhouse_transport.DiskStorageConverter;
import com.avito.android.analytics.inhouse_transport.FileStorage;
import com.avito.android.analytics.inhouse_transport.FileStorageImpl;
import com.avito.android.analytics.inhouse_transport.HotSwapEventStorage;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsSettingsStorage;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsStorageImpl;
import com.avito.android.analytics.inhouse_transport.InHouseCommonSendingModule;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.analytics.inhouse_transport.InMemoryEventStorage;
import com.avito.android.analytics.inhouse_transport.OnDiskEventStorage;
import com.avito.android.analytics.inhouse_transport.OverflowTrimmer;
import com.avito.android.analytics.inhouse_transport.OverflowTrimmerImpl;
import com.avito.android.analytics.statsd.StatsdEventTrackerImpl;
import com.avito.android.analytics.statsd.StatsdEventValidator;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Strings;
import com.avito.android.util.preferences.Preferences;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import dagger.multibindings.IntoSet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Provider;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001FB\t\b\u0002¢\u0006\u0004\bD\u0010EJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u000f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJA\u0010*\u001a\u00020\u00022\u000e\b\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\b\b\u0001\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\b\u0012\u0004\u0012\u00020!0,H\u0007¢\u0006\u0004\b-\u0010.JQ\u00106\u001a\b\u0012\u0004\u0012\u00020!0 2\u0014\b\u0001\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!000/2\u0014\b\u0001\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!03022\u000e\b\u0001\u00105\u001a\b\u0012\u0004\u0012\u00020!0,H\u0007¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\b\u0012\u0004\u0012\u00020!00H\u0007¢\u0006\u0004\b8\u00109JA\u0010@\u001a\b\u0012\u0004\u0012\u00020!032\b\b\u0001\u0010:\u001a\u00020\u00152\b\b\u0001\u0010;\u001a\u00020\u001a2\u000e\b\u0001\u0010=\u001a\b\u0012\u0004\u0012\u00020!0<2\u0006\u0010?\u001a\u00020>H\u0007¢\u0006\u0004\b@\u0010AJ\u0015\u0010B\u001a\b\u0012\u0004\u0012\u00020!0<H\u0007¢\u0006\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdCommonModule;", "", "Lcom/avito/android/analytics/statsd/StatsdEventTracker;", "tracker", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/analytics/EventObserver;", "provideStatsdEventObserver", "(Lcom/avito/android/analytics/statsd/StatsdEventTracker;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/analytics/EventObserver;", "Lcom/avito/android/StatsdToggles;", "stadsdToggles", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lokhttp3/OkHttpClient;", "httpClient", "gzipHttpClient", "Lcom/avito/android/analytics/statsd/StatsdApi;", "provideStatsdApi", "(Lcom/avito/android/StatsdToggles;Lcom/avito/android/util/BuildInfo;Lokhttp3/OkHttpClient;Lokhttp3/OkHttpClient;)Lcom/avito/android/analytics/statsd/StatsdApi;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/analytics/inhouse_transport/FileStorage;", "provideFileStorage", "(Landroid/app/Application;)Lcom/avito/android/analytics/inhouse_transport/FileStorage;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsSettingsStorage;", "provideStatsdSettingsStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsSettingsStorage;", "Lcom/avito/android/analytics/statsd/StatsdEventValidator;", "provideStatsdEventValidator", "(Lcom/avito/android/StatsdToggles;)Lcom/avito/android/analytics/statsd/StatsdEventValidator;", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "Lcom/avito/android/analytics/statsd/StatsdRecord;", "storage", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", "sender", "Lcom/avito/android/AnalyticsToggles;", "analyticsToggles", "validator", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "provideStatsdEventTracker", "(Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;Lcom/avito/android/AnalyticsToggles;Lcom/avito/android/analytics/statsd/StatsdEventValidator;Lcom/avito/android/analytics/grafana/GraphitePrefix;)Lcom/avito/android/analytics/statsd/StatsdEventTracker;", "Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmer;", "provideOverflowTrimmer", "()Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmer;", "Ljavax/inject/Provider;", "Lcom/avito/android/analytics/inhouse_transport/InMemoryEventStorage;", "inMemoryStorage", "Ldagger/Lazy;", "Lcom/avito/android/analytics/inhouse_transport/OnDiskEventStorage;", "onDiskStorage", "trimmer", "provideHotSwapStatsdEventStorage", "(Ljavax/inject/Provider;Ldagger/Lazy;Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmer;)Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "provideInMemoryStatsdEventStorage", "()Lcom/avito/android/analytics/inhouse_transport/InMemoryEventStorage;", "fileStorage", "settingsStorage", "Lcom/avito/android/analytics/inhouse_transport/DiskStorageConverter;", "storageConverter", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "provideOnDiskStatsdEventStorage", "(Lcom/avito/android/analytics/inhouse_transport/FileStorage;Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsSettingsStorage;Lcom/avito/android/analytics/inhouse_transport/DiskStorageConverter;Lcom/avito/android/util/RandomKeyProvider;)Lcom/avito/android/analytics/inhouse_transport/OnDiskEventStorage;", "provideDiskStorageConverter", "()Lcom/avito/android/analytics/inhouse_transport/DiskStorageConverter;", "<init>", "()V", StatsdEventTrackerKt.LOG_TAG, "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {InHouseCommonSendingModule.class})
public final class StatsdCommonModule {
    @NotNull
    public static final StatsdCommonModule INSTANCE = new StatsdCommonModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdCommonModule$Statsd;", "", "<init>", "()V", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface Statsd {
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    @Statsd
    public static final DiskStorageConverter<StatsdRecord> provideDiskStorageConverter() {
        return new SerializableStatsdDiskEventConverter();
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    @Statsd
    public static final FileStorage provideFileStorage(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new FileStorageImpl(application, "statsd");
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    @Statsd
    public static final InHouseEventStorage<StatsdRecord> provideHotSwapStatsdEventStorage(@Statsd @NotNull Provider<InMemoryEventStorage<StatsdRecord>> provider, @Statsd @NotNull Lazy<OnDiskEventStorage<StatsdRecord>> lazy, @Statsd @NotNull OverflowTrimmer<StatsdRecord> overflowTrimmer) {
        Intrinsics.checkNotNullParameter(provider, "inMemoryStorage");
        Intrinsics.checkNotNullParameter(lazy, "onDiskStorage");
        Intrinsics.checkNotNullParameter(overflowTrimmer, "trimmer");
        return new HotSwapEventStorage(provider, lazy, overflowTrimmer);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    @Statsd
    public static final InMemoryEventStorage<StatsdRecord> provideInMemoryStatsdEventStorage() {
        return new InMemoryEventStorage<>(100);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    @Statsd
    public static final OnDiskEventStorage<StatsdRecord> provideOnDiskStatsdEventStorage(@Statsd @NotNull FileStorage fileStorage, @Statsd @NotNull InHouseAnalyticsSettingsStorage inHouseAnalyticsSettingsStorage, @Statsd @NotNull DiskStorageConverter<StatsdRecord> diskStorageConverter, @NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(fileStorage, "fileStorage");
        Intrinsics.checkNotNullParameter(inHouseAnalyticsSettingsStorage, "settingsStorage");
        Intrinsics.checkNotNullParameter(diskStorageConverter, "storageConverter");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        return new OnDiskEventStorage<>(fileStorage, inHouseAnalyticsSettingsStorage, diskStorageConverter, randomKeyProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    @Statsd
    public static final OverflowTrimmer<StatsdRecord> provideOverflowTrimmer() {
        return new OverflowTrimmerImpl(100);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final StatsdApi provideStatsdApi(@NotNull StatsdToggles statsdToggles, @NotNull BuildInfo buildInfo, @InHouseCommonSendingModule.InHouseHttpClient @NotNull OkHttpClient okHttpClient, @InHouseCommonSendingModule.InHouseGzipHttpClient @NotNull OkHttpClient okHttpClient2) {
        Intrinsics.checkNotNullParameter(statsdToggles, "stadsdToggles");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(okHttpClient, "httpClient");
        Intrinsics.checkNotNullParameter(okHttpClient2, "gzipHttpClient");
        if (statsdToggles.getStatsdGzip().invoke().booleanValue()) {
            okHttpClient = okHttpClient2;
        }
        Retrofit.Builder client = new Retrofit.Builder().baseUrl(Strings.ensureEndsWith(statsdToggles.getStatsdApiUrl().getOriginalValue(), "/")).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient);
        if (buildInfo.isDebug()) {
            client.validateEagerly(true);
        }
        Object create = client.build().create(StatsdApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "builder\n            .bui…te(StatsdApi::class.java)");
        return (StatsdApi) create;
    }

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @Singleton
    public static final EventObserver provideStatsdEventObserver(@NotNull StatsdEventTracker statsdEventTracker, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(statsdEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        return new StatsdEventObserver(statsdEventTracker, schedulersFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final StatsdEventTracker provideStatsdEventTracker(@Statsd @NotNull InHouseEventStorage<StatsdRecord> inHouseEventStorage, @Statsd @NotNull InHouseAnalyticsFlushInteractor inHouseAnalyticsFlushInteractor, @NotNull AnalyticsToggles analyticsToggles, @NotNull StatsdEventValidator statsdEventValidator, @NotNull GraphitePrefix graphitePrefix) {
        Intrinsics.checkNotNullParameter(inHouseEventStorage, "storage");
        Intrinsics.checkNotNullParameter(inHouseAnalyticsFlushInteractor, "sender");
        Intrinsics.checkNotNullParameter(analyticsToggles, "analyticsToggles");
        Intrinsics.checkNotNullParameter(statsdEventValidator, "validator");
        Intrinsics.checkNotNullParameter(graphitePrefix, "graphitePrefix");
        return new StatsdEventTrackerImpl(inHouseEventStorage, inHouseAnalyticsFlushInteractor, statsdEventValidator, new StatsdEventTrackerImpl.Config(100, analyticsToggles.getLogAnalyticEvents().invoke().booleanValue()), graphitePrefix);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final StatsdEventValidator provideStatsdEventValidator(@NotNull StatsdToggles statsdToggles) {
        Intrinsics.checkNotNullParameter(statsdToggles, "stadsdToggles");
        return statsdToggles.getStatsdStrictMode().invoke().booleanValue() ? new StatsdEventValidator.Impl() : new StatsdEventValidator.Stub();
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    @Statsd
    public static final InHouseAnalyticsSettingsStorage provideStatsdSettingsStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        return new InHouseAnalyticsStorageImpl(preferences, "statsd");
    }
}
