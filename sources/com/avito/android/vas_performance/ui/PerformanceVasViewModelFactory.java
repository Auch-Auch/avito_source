package com.avito.android.vas_performance.ui;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.PerformanceVasConverter;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/vas_performance/ui/PerformanceVasViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/vas_performance/repository/VasRepository;", "c", "Lcom/avito/android/vas_performance/repository/VasRepository;", "vasRepository", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, AuthSource.BOOKING_ORDER, "checkoutContext", "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "f", "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "tracker", "Lcom/avito/android/vas_performance/PerformanceVasConverter;", "e", "Lcom/avito/android/vas_performance/PerformanceVasConverter;", "converter", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/vas_performance/PerformanceVasConverter;Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceVasViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final String b;
    public final VasRepository c;
    public final SchedulersFactory d;
    public final PerformanceVasConverter e;
    public final PerformanceVasTracker f;

    public PerformanceVasViewModelFactory(@NotNull String str, @NotNull String str2, @NotNull VasRepository vasRepository, @NotNull SchedulersFactory schedulersFactory, @NotNull PerformanceVasConverter performanceVasConverter, @NotNull PerformanceVasTracker performanceVasTracker) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkoutContext");
        Intrinsics.checkNotNullParameter(vasRepository, "vasRepository");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(performanceVasConverter, "converter");
        Intrinsics.checkNotNullParameter(performanceVasTracker, "tracker");
        this.a = str;
        this.b = str2;
        this.c = vasRepository;
        this.d = schedulersFactory;
        this.e = performanceVasConverter;
        this.f = performanceVasTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(PerformanceVasViewModelImpl.class)) {
            return new PerformanceVasViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
