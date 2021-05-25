package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.Features;
import com.avito.android.ab_tests.ABTestConfigTracker;
import com.avito.android.ab_tests.ABTestConfigTrackerImpl;
import com.avito.android.ab_tests.AbTestPrefs;
import com.avito.android.ab_tests.AbTestPrefsImpl;
import com.avito.android.ab_tests.AbTests;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.AbTestsConfigStorage;
import com.avito.android.ab_tests.UsedAbTestReporter;
import com.avito.android.ab_tests.UsedAbTestReporterImpl;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.Names;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import com.google.gson.Gson;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u0010\u001a\u00020\u000f2\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J?\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/di/module/PersistenceAbTestsModule;", "", "Lcom/avito/android/util/preferences/PreferenceFactory;", "factory", "Landroid/app/Application;", "context", "Lcom/avito/android/util/preferences/Preferences;", "provideAbTestsPreferences", "(Lcom/avito/android/util/preferences/PreferenceFactory;Landroid/app/Application;)Lcom/avito/android/util/preferences/Preferences;", "Ldagger/Lazy;", "Lcom/google/gson/Gson;", "gson", "preferences", "Lcom/avito/android/ab_tests/ABTestConfigTracker;", "abTestConfigTracker", "Lcom/avito/android/ab_tests/AbTestPrefs;", "provideAbTestPrefs", "(Ldagger/Lazy;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/ab_tests/ABTestConfigTracker;)Lcom/avito/android/ab_tests/AbTestPrefs;", "abTestPrefs", "Lcom/avito/android/ab_tests/UsedAbTestReporter;", "usedAbTestReporter", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/ab_tests/AbTestsConfigStorage;", "provideAbTestConfigStorage", "(Lcom/avito/android/ab_tests/AbTestPrefs;Lcom/avito/android/ab_tests/UsedAbTestReporter;Lcom/avito/android/Features;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/BuildInfo;Lcom/google/gson/Gson;)Lcom/avito/android/ab_tests/AbTestsConfigStorage;", "<init>", "()V", "Declarations", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public class PersistenceAbTestsModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/di/module/PersistenceAbTestsModule$Declarations;", "", "Lcom/avito/android/ab_tests/ABTestConfigTrackerImpl;", "abTestConfigTracker", "Lcom/avito/android/ab_tests/ABTestConfigTracker;", "bindsABTestConfigTracker", "(Lcom/avito/android/ab_tests/ABTestConfigTrackerImpl;)Lcom/avito/android/ab_tests/ABTestConfigTracker;", "Lcom/avito/android/ab_tests/UsedAbTestReporterImpl;", "usedAbTestReporter", "Lcom/avito/android/ab_tests/UsedAbTestReporter;", "bindsUsedAbTestReporter", "(Lcom/avito/android/ab_tests/UsedAbTestReporterImpl;)Lcom/avito/android/ab_tests/UsedAbTestReporter;", "Lcom/avito/android/ab_tests/AbTestsConfigStorage;", "abTestsConfigStorage", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "bindsAbTestsConfigProvider", "(Lcom/avito/android/ab_tests/AbTestsConfigStorage;)Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Singleton
        @Binds
        @NotNull
        ABTestConfigTracker bindsABTestConfigTracker(@NotNull ABTestConfigTrackerImpl aBTestConfigTrackerImpl);

        @Singleton
        @Binds
        @NotNull
        AbTestsConfigProvider bindsAbTestsConfigProvider(@NotNull AbTestsConfigStorage abTestsConfigStorage);

        @Singleton
        @Binds
        @NotNull
        UsedAbTestReporter bindsUsedAbTestReporter(@NotNull UsedAbTestReporterImpl usedAbTestReporterImpl);
    }

    @Provides
    @Singleton
    @NotNull
    public AbTestsConfigStorage provideAbTestConfigStorage(@NotNull AbTestPrefs abTestPrefs, @NotNull UsedAbTestReporter usedAbTestReporter, @NotNull Features features, @NotNull Analytics analytics, @NotNull BuildInfo buildInfo, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(abTestPrefs, "abTestPrefs");
        Intrinsics.checkNotNullParameter(usedAbTestReporter, "usedAbTestReporter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return new AbTestsConfigStorage(abTestPrefs, usedAbTestReporter, features, analytics, buildInfo, gson);
    }

    @Provides
    @NotNull
    @Singleton
    public AbTestPrefs provideAbTestPrefs(@StreamGson @NotNull Lazy<Gson> lazy, @AbTests @NotNull Preferences preferences, @NotNull ABTestConfigTracker aBTestConfigTracker) {
        Intrinsics.checkNotNullParameter(lazy, "gson");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(aBTestConfigTracker, "abTestConfigTracker");
        return new AbTestPrefsImpl(preferences, lazy, aBTestConfigTracker);
    }

    @Provides
    @AbTests
    @NotNull
    public Preferences provideAbTestsPreferences(@NotNull PreferenceFactory preferenceFactory, @NotNull Application application) {
        Intrinsics.checkNotNullParameter(preferenceFactory, "factory");
        Intrinsics.checkNotNullParameter(application, "context");
        return preferenceFactory.getCustomPreferences(application, Names.ABTESTS);
    }
}
