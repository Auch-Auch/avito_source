package com.avito.android.analytics.clickstream;

import android.app.Application;
import com.avito.android.AnalyticsToggles;
import com.avito.android.ClickstreamToggles;
import com.avito.android.analytics.EventObserver;
import com.avito.android.analytics.clickstream.ClickStreamEventTracker;
import com.avito.android.analytics.clickstream.ClickStreamEventTrackerImpl;
import com.avito.android.analytics.inhouse_transport.DiskStorageConverter;
import com.avito.android.analytics.inhouse_transport.FileStorage;
import com.avito.android.analytics.inhouse_transport.FileStorageImpl;
import com.avito.android.analytics.inhouse_transport.HotSwapEventStorage;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsSettingsStorage;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsStorageImpl;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsTimer;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.analytics.inhouse_transport.InMemoryEventStorage;
import com.avito.android.analytics.inhouse_transport.OnDiskEventStorage;
import com.avito.android.analytics.inhouse_transport.OverflowPassTrimmer;
import com.avito.android.analytics.inhouse_transport.OverflowTrimmer;
import com.avito.android.analytics.provider.clickstream.ClickStreamEventObserver;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.Preferences;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
import javax.inject.Provider;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import proto.events.apps.EventOuterClass;
import t6.n.x;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001FB\t\b\u0002¢\u0006\u0004\bD\u0010EJf\u0010\u0016\u001a\u00020\u00152\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0011\u0010\u000e\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010 \u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b \u0010!JQ\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0014\b\u0001\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#0\"2\u0014\b\u0001\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030&0%2\u000e\b\u0001\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030(H\u0007¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030(H\u0007¢\u0006\u0004\b,\u0010-J\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030#2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b.\u0010/JA\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030&2\b\b\u0001\u00101\u001a\u0002002\b\b\u0001\u00103\u001a\u0002022\u000e\b\u0001\u00105\u001a\b\u0012\u0004\u0012\u00020\u0003042\u0006\u00107\u001a\u000206H\u0007¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000304H\u0007¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u0002002\u0006\u0010=\u001a\u00020<H\u0007¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u0002022\u0006\u0010A\u001a\u00020@H\u0007¢\u0006\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamCommonModule;", "", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "Lproto/events/apps/EventOuterClass$Event;", "storage", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", "sender", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsTimer;", "timer", "Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker$ClickStreamEventSaturator;", "eventSaturator", "", "Lcom/avito/android/analytics/clickstream/EventValidator;", "Lkotlin/jvm/JvmSuppressWildcards;", "validators", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/AnalyticsToggles;", "analyticsToggles", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker;", "provideClickStreamEventTracker", "(Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsTimer;Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker$ClickStreamEventSaturator;Ljava/util/Set;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/AnalyticsToggles;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker;", "tracker", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/ClickstreamToggles;", "clickStreamToggles", "Lcom/avito/android/analytics/EventObserver;", "provideClickStreamEventObserver", "(Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/ClickstreamToggles;)Lcom/avito/android/analytics/EventObserver;", "provideEventValidators", "(Lcom/avito/android/ClickstreamToggles;)Ljava/util/Set;", "Ljavax/inject/Provider;", "Lcom/avito/android/analytics/inhouse_transport/InMemoryEventStorage;", "inMemoryStorage", "Ldagger/Lazy;", "Lcom/avito/android/analytics/inhouse_transport/OnDiskEventStorage;", "onDiskStorage", "Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmer;", "trimmer", "provideHotSwapClickStreamEventStorage", "(Ljavax/inject/Provider;Ldagger/Lazy;Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmer;)Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "provideOverflowTrimmer", "()Lcom/avito/android/analytics/inhouse_transport/OverflowTrimmer;", "provideInMemoryClickStreamEventStorage", "(Lcom/avito/android/AnalyticsToggles;)Lcom/avito/android/analytics/inhouse_transport/InMemoryEventStorage;", "Lcom/avito/android/analytics/inhouse_transport/FileStorage;", "fileStorage", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsSettingsStorage;", "settingsStorage", "Lcom/avito/android/analytics/inhouse_transport/DiskStorageConverter;", "storageConverter", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "provideOnDiskClickStreamEventStorage", "(Lcom/avito/android/analytics/inhouse_transport/FileStorage;Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsSettingsStorage;Lcom/avito/android/analytics/inhouse_transport/DiskStorageConverter;Lcom/avito/android/util/RandomKeyProvider;)Lcom/avito/android/analytics/inhouse_transport/OnDiskEventStorage;", "provideDiskStorageConverter", "()Lcom/avito/android/analytics/inhouse_transport/DiskStorageConverter;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "provideFileStorage", "(Landroid/app/Application;)Lcom/avito/android/analytics/inhouse_transport/FileStorage;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "provideClickStreamSettingsStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsSettingsStorage;", "<init>", "()V", ClickStreamEventTrackerKt.CS_LOG_TAG, "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ClickStreamCommonModule {
    @NotNull
    public static final ClickStreamCommonModule INSTANCE = new ClickStreamCommonModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamCommonModule$ClickStream;", "", "<init>", "()V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface ClickStream {
    }

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @Singleton
    public static final EventObserver provideClickStreamEventObserver(@NotNull ClickStreamEventTracker clickStreamEventTracker, @NotNull SchedulersFactory schedulersFactory, @NotNull ClickstreamToggles clickstreamToggles) {
        Intrinsics.checkNotNullParameter(clickStreamEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(clickstreamToggles, "clickStreamToggles");
        return new ClickStreamEventObserver(clickStreamEventTracker, clickstreamToggles, schedulersFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final ClickStreamEventTracker provideClickStreamEventTracker(@ClickStream @NotNull InHouseEventStorage<EventOuterClass.Event> inHouseEventStorage, @ClickStream @NotNull InHouseAnalyticsFlushInteractor inHouseAnalyticsFlushInteractor, @ClickStream @NotNull InHouseAnalyticsTimer inHouseAnalyticsTimer, @NotNull ClickStreamEventTracker.ClickStreamEventSaturator clickStreamEventSaturator, @NotNull Set<EventValidator> set, @NotNull TimeSource timeSource, @NotNull AnalyticsToggles analyticsToggles, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(inHouseEventStorage, "storage");
        Intrinsics.checkNotNullParameter(inHouseAnalyticsFlushInteractor, "sender");
        InHouseAnalyticsTimer inHouseAnalyticsTimer2 = inHouseAnalyticsTimer;
        Intrinsics.checkNotNullParameter(inHouseAnalyticsTimer, "timer");
        Intrinsics.checkNotNullParameter(clickStreamEventSaturator, "eventSaturator");
        Intrinsics.checkNotNullParameter(set, "validators");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(analyticsToggles, "analyticsToggles");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        ClickStreamEventTrackerImpl.Config config = new ClickStreamEventTrackerImpl.Config(analyticsToggles.getClickstreamDeliveryImprovements().invoke().booleanValue() ? 30 : 100, analyticsToggles.getLogAnalyticEvents().invoke().booleanValue(), DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS);
        if (!analyticsToggles.getClickstreamTimerTrigger().invoke().booleanValue()) {
            inHouseAnalyticsTimer2 = null;
        }
        return new ClickStreamEventTrackerImpl(inHouseEventStorage, inHouseAnalyticsFlushInteractor, set, clickStreamEventSaturator, timeSource, config, inHouseAnalyticsTimer2, buildInfo.isDebug());
    }

    @Provides
    @JvmStatic
    @ClickStream
    @NotNull
    @Singleton
    public static final InHouseAnalyticsSettingsStorage provideClickStreamSettingsStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        return new InHouseAnalyticsStorageImpl(preferences, "clickstream");
    }

    @Provides
    @JvmStatic
    @ClickStream
    @NotNull
    @Singleton
    public static final DiskStorageConverter<EventOuterClass.Event> provideDiskStorageConverter() {
        return new ProtobufDiskEventConverter();
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final Set<EventValidator> provideEventValidators(@NotNull ClickstreamToggles clickstreamToggles) {
        Intrinsics.checkNotNullParameter(clickstreamToggles, "clickStreamToggles");
        if (clickstreamToggles.getClickstreamStrictMode().invoke().booleanValue()) {
            return x.setOf(new DwhEventValidator());
        }
        return y.emptySet();
    }

    @Provides
    @JvmStatic
    @ClickStream
    @NotNull
    @Singleton
    public static final FileStorage provideFileStorage(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new FileStorageImpl(application, "clickstream");
    }

    @Provides
    @JvmStatic
    @ClickStream
    @NotNull
    @Singleton
    public static final InHouseEventStorage<EventOuterClass.Event> provideHotSwapClickStreamEventStorage(@ClickStream @NotNull Provider<InMemoryEventStorage<EventOuterClass.Event>> provider, @ClickStream @NotNull Lazy<OnDiskEventStorage<EventOuterClass.Event>> lazy, @ClickStream @NotNull OverflowTrimmer<EventOuterClass.Event> overflowTrimmer) {
        Intrinsics.checkNotNullParameter(provider, "inMemoryStorage");
        Intrinsics.checkNotNullParameter(lazy, "onDiskStorage");
        Intrinsics.checkNotNullParameter(overflowTrimmer, "trimmer");
        return new HotSwapEventStorage(provider, lazy, overflowTrimmer);
    }

    @Provides
    @JvmStatic
    @ClickStream
    @NotNull
    @Singleton
    public static final InMemoryEventStorage<EventOuterClass.Event> provideInMemoryClickStreamEventStorage(@NotNull AnalyticsToggles analyticsToggles) {
        Intrinsics.checkNotNullParameter(analyticsToggles, "analyticsToggles");
        return new InMemoryEventStorage<>(analyticsToggles.getClickstreamDeliveryImprovements().invoke().booleanValue() ? 30 : 100);
    }

    @Provides
    @JvmStatic
    @ClickStream
    @NotNull
    @Singleton
    public static final OnDiskEventStorage<EventOuterClass.Event> provideOnDiskClickStreamEventStorage(@ClickStream @NotNull FileStorage fileStorage, @ClickStream @NotNull InHouseAnalyticsSettingsStorage inHouseAnalyticsSettingsStorage, @ClickStream @NotNull DiskStorageConverter<EventOuterClass.Event> diskStorageConverter, @NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(fileStorage, "fileStorage");
        Intrinsics.checkNotNullParameter(inHouseAnalyticsSettingsStorage, "settingsStorage");
        Intrinsics.checkNotNullParameter(diskStorageConverter, "storageConverter");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        return new OnDiskEventStorage<>(fileStorage, inHouseAnalyticsSettingsStorage, diskStorageConverter, randomKeyProvider);
    }

    @Provides
    @JvmStatic
    @ClickStream
    @NotNull
    @Singleton
    public static final OverflowTrimmer<EventOuterClass.Event> provideOverflowTrimmer() {
        return new OverflowPassTrimmer();
    }
}
