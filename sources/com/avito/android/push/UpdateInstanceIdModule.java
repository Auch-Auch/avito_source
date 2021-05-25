package com.avito.android.push;

import com.adjust.sdk.sig.BuildConfig;
import com.avito.android.analytics_adjust.Adjust;
import com.avito.android.di.PerService;
import com.avito.android.preferences.MutableTokenStorage;
import com.avito.android.push.UpdateInstanceIdInteractor;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/push/UpdateInstanceIdModule;", "", "Lcom/avito/android/analytics_adjust/Adjust;", BuildConfig.FLAVOR, "Lcom/avito/android/preferences/MutableTokenStorage;", "instanceIdStorage", "Lcom/avito/android/remote/NotificationsApi;", "notificationsApi", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/push/UpdateInstanceIdInteractor;", "provideUpdateInstanceIdInteractor", "(Lcom/avito/android/analytics_adjust/Adjust;Lcom/avito/android/preferences/MutableTokenStorage;Lcom/avito/android/remote/NotificationsApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/push/UpdateInstanceIdInteractor;", "<init>", "()V", "push_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UpdateInstanceIdModule {
    @PerService
    @Provides
    @NotNull
    public final UpdateInstanceIdInteractor provideUpdateInstanceIdInteractor(@NotNull Adjust adjust, @NotNull MutableTokenStorage mutableTokenStorage, @NotNull NotificationsApi notificationsApi, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(adjust, BuildConfig.FLAVOR);
        Intrinsics.checkNotNullParameter(mutableTokenStorage, "instanceIdStorage");
        Intrinsics.checkNotNullParameter(notificationsApi, "notificationsApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new UpdateInstanceIdInteractor.Impl(adjust, mutableTokenStorage, notificationsApi, schedulersFactory, buildInfo);
    }
}
