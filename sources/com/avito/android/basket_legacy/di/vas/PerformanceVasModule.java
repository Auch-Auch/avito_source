package com.avito.android.basket_legacy.di.vas;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.analytics.Analytics;
import com.avito.android.basket_legacy.di.AdvertId;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.viewmodels.vas.performance.LegacyPerformanceVasViewModelFactory;
import com.avito.android.basket_legacy.viewmodels.vas.performance.LegacyPerformanceVasViewModelImpl;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.LegacyPerformanceVasViewModel;
import com.avito.android.vas_performance.PerformanceVasConverter;
import com.avito.android.vas_performance.PerformanceVasConverterImpl;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.repository.VasRepositoryImpl;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0011\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJI\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/avito/android/basket_legacy/di/vas/PerformanceVasModule;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/vas_performance/repository/VasRepository;", "vasRepository", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "basketRepository", "Lcom/avito/android/vas_performance/PerformanceVasConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "tracker", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/basket_legacy/viewmodels/vas/performance/LegacyPerformanceVasViewModelFactory;", "provideLegacyViewModelFactory", "(Ljava/lang/String;Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/basket_legacy/repositories/BasketRepository;Lcom/avito/android/vas_performance/PerformanceVasConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/basket_legacy/viewmodels/vas/performance/LegacyPerformanceVasViewModelFactory;", "Landroidx/fragment/app/FragmentActivity;", "activity", "factory", "Lcom/avito/android/vas_performance/LegacyPerformanceVasViewModel;", "provideLegacyViewModelImpl$basket_release", "(Landroidx/fragment/app/FragmentActivity;Lcom/avito/android/basket_legacy/viewmodels/vas/performance/LegacyPerformanceVasViewModelFactory;)Lcom/avito/android/vas_performance/LegacyPerformanceVasViewModel;", "provideLegacyViewModelImpl", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "openedFrom", "<init>", "(Ljava/lang/String;)V", "Declarations", "basket_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, PerformanceVasAnalyticsModule.class})
public final class PerformanceVasModule {
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/basket_legacy/di/vas/PerformanceVasModule$Declarations;", "", "Lcom/avito/android/vas_performance/PerformanceVasConverterImpl;", "performanceVasConverterImpl", "Lcom/avito/android/vas_performance/PerformanceVasConverter;", "provideConverter", "(Lcom/avito/android/vas_performance/PerformanceVasConverterImpl;)Lcom/avito/android/vas_performance/PerformanceVasConverter;", "Lcom/avito/android/vas_performance/repository/VasRepositoryImpl;", "vasRepositoryImpl", "Lcom/avito/android/vas_performance/repository/VasRepository;", "provideVasRepository", "(Lcom/avito/android/vas_performance/repository/VasRepositoryImpl;)Lcom/avito/android/vas_performance/repository/VasRepository;", "basket_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        PerformanceVasConverter provideConverter(@NotNull PerformanceVasConverterImpl performanceVasConverterImpl);

        @PerActivity
        @Binds
        @NotNull
        VasRepository provideVasRepository(@NotNull VasRepositoryImpl vasRepositoryImpl);
    }

    public PerformanceVasModule(@Nullable String str) {
        this.a = str;
    }

    @Provides
    @PerActivity
    @NotNull
    public final LegacyPerformanceVasViewModelFactory provideLegacyViewModelFactory(@AdvertId @NotNull String str, @NotNull VasRepository vasRepository, @NotNull BasketRepository basketRepository, @NotNull PerformanceVasConverter performanceVasConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull PerformanceVasTracker performanceVasTracker, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(vasRepository, "vasRepository");
        Intrinsics.checkNotNullParameter(basketRepository, "basketRepository");
        Intrinsics.checkNotNullParameter(performanceVasConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(performanceVasTracker, "tracker");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new LegacyPerformanceVasViewModelFactory(str, vasRepository, basketRepository, performanceVasConverter, schedulersFactory, performanceVasTracker, analytics, this.a);
    }

    @Provides
    @PerActivity
    @NotNull
    public final LegacyPerformanceVasViewModel provideLegacyViewModelImpl$basket_release(@NotNull FragmentActivity fragmentActivity, @NotNull LegacyPerformanceVasViewModelFactory legacyPerformanceVasViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(legacyPerformanceVasViewModelFactory, "factory");
        ViewModel viewModel = ViewModelProviders.of(fragmentActivity, legacyPerformanceVasViewModelFactory).get(LegacyPerformanceVasViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…iewModelImpl::class.java)");
        return (LegacyPerformanceVasViewModel) viewModel;
    }
}
