package com.avito.android.di.module;

import com.avito.android.ab_tests.ABTestConfigTracker;
import com.avito.android.ab_tests.AbTestsConfigStorage;
import com.avito.android.ab_tests.AbTestsReloadTask;
import com.avito.android.remote.ConfigApi;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.SchedulersFactory3;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/di/module/AbTestModule;", "", "Lcom/avito/android/remote/ConfigApi;", "avitoApi", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/ab_tests/AbTestsConfigStorage;", "abTestsConfigStorage", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/ab_tests/ABTestConfigTracker;", "tracker", "Lcom/avito/android/ab_tests/AbTestsReloadTask;", "provideAbTestsReloadTask", "(Lcom/avito/android/remote/ConfigApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/ab_tests/AbTestsConfigStorage;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/ab_tests/ABTestConfigTracker;)Lcom/avito/android/ab_tests/AbTestsReloadTask;", "<init>", "()V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AbTestGroupModule.class, AbTestsTasksModule.class})
public final class AbTestModule {
    @NotNull
    public static final AbTestModule INSTANCE = new AbTestModule();

    @Provides
    @NotNull
    public final AbTestsReloadTask provideAbTestsReloadTask(@NotNull ConfigApi configApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AbTestsConfigStorage abTestsConfigStorage, @NotNull DeviceMetrics deviceMetrics, @NotNull ABTestConfigTracker aBTestConfigTracker) {
        Intrinsics.checkNotNullParameter(configApi, "avitoApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(abTestsConfigStorage, "abTestsConfigStorage");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(aBTestConfigTracker, "tracker");
        return new AbTestsReloadTask(configApi, schedulersFactory3, abTestsConfigStorage, deviceMetrics, aBTestConfigTracker);
    }
}
