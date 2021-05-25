package com.avito.android.app_rater.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.app_rater.AppRaterInteractor;
import com.avito.android.app_rater.events.AppRaterEventSourcePage;
import com.avito.android.app_rater.fragment.AppRaterDialogFragmentViewModelFactory;
import com.avito.android.di.PerFragment;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/app_rater/di/AppRaterDialogModule;", "", "Lcom/avito/android/app_rater/AppRaterInteractor;", "interactor", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/app_rater/events/AppRaterEventSourcePage;", "page", "Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModelFactory;", "provideViewModelFactory", "(Lcom/avito/android/app_rater/AppRaterInteractor;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/app_rater/events/AppRaterEventSourcePage;)Lcom/avito/android/app_rater/fragment/AppRaterDialogFragmentViewModelFactory;", "<init>", "()V", "app-rater_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AppRaterDialogModule {
    @NotNull
    public static final AppRaterDialogModule INSTANCE = new AppRaterDialogModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AppRaterDialogFragmentViewModelFactory provideViewModelFactory(@NotNull AppRaterInteractor appRaterInteractor, @NotNull TimeSource timeSource, @NotNull SchedulersFactory schedulersFactory, @NotNull Analytics analytics, @Nullable AppRaterEventSourcePage appRaterEventSourcePage) {
        Intrinsics.checkNotNullParameter(appRaterInteractor, "interactor");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new AppRaterDialogFragmentViewModelFactory(appRaterInteractor, timeSource, schedulersFactory, analytics, appRaterEventSourcePage);
    }
}
