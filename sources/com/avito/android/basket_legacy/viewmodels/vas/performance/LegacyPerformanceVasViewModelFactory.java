package com.avito.android.basket_legacy.viewmodels.vas.performance;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.PerformanceVasConverter;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b&\u0010'J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/basket_legacy/viewmodels/vas/performance/LegacyPerformanceVasViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/vas_performance/PerformanceVasConverter;", "d", "Lcom/avito/android/vas_performance/PerformanceVasConverter;", "converter", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/vas_performance/repository/VasRepository;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/vas_performance/repository/VasRepository;", "vasRepository", "h", "openedFrom", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "c", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "basketRepository", "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "f", "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "performanceVasTracker", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Ljava/lang/String;Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/basket_legacy/repositories/BasketRepository;Lcom/avito/android/vas_performance/PerformanceVasConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;Lcom/avito/android/analytics/Analytics;Ljava/lang/String;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyPerformanceVasViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final VasRepository b;
    public final BasketRepository c;
    public final PerformanceVasConverter d;
    public final SchedulersFactory e;
    public final PerformanceVasTracker f;
    public final Analytics g;
    public final String h;

    public LegacyPerformanceVasViewModelFactory(@NotNull String str, @NotNull VasRepository vasRepository, @NotNull BasketRepository basketRepository, @NotNull PerformanceVasConverter performanceVasConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull PerformanceVasTracker performanceVasTracker, @NotNull Analytics analytics, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(vasRepository, "vasRepository");
        Intrinsics.checkNotNullParameter(basketRepository, "basketRepository");
        Intrinsics.checkNotNullParameter(performanceVasConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(performanceVasTracker, "performanceVasTracker");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = str;
        this.b = vasRepository;
        this.c = basketRepository;
        this.d = performanceVasConverter;
        this.e = schedulersFactory;
        this.f = performanceVasTracker;
        this.g = analytics;
        this.h = str2;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(LegacyPerformanceVasViewModelImpl.class)) {
            return new LegacyPerformanceVasViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
