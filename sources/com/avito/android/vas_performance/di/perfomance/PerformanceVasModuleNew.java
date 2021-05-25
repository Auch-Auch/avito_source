package com.avito.android.vas_performance.di.perfomance;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.PerformanceVasConverter;
import com.avito.android.vas_performance.PerformanceVasConverterImpl;
import com.avito.android.vas_performance.PerformanceVasViewModel;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.repository.VasRepositoryImpl;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import com.avito.android.vas_performance.ui.PerformanceVasViewModelFactory;
import com.avito.android.vas_performance.ui.PerformanceVasViewModelImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/avito/android/vas_performance/di/perfomance/PerformanceVasModuleNew;", "", "Lcom/avito/android/vas_performance/repository/VasRepository;", "vasRepository", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/vas_performance/PerformanceVasConverter;", "converter", "Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;", "tracker", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/vas_performance/PerformanceVasConverter;Lcom/avito/android/vas_performance/tracker/PerformanceVasTracker;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/fragment/app/Fragment;", "fragment", "factory", "Lcom/avito/android/vas_performance/PerformanceVasViewModel;", "provideViewModel$vas_performance_release", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/vas_performance/PerformanceVasViewModel;", "provideViewModel", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "checkoutContext", AuthSource.SEND_ABUSE, BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Declarations", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class PerformanceVasModuleNew {
    public final String a;
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/vas_performance/di/perfomance/PerformanceVasModuleNew$Declarations;", "", "Lcom/avito/android/vas_performance/PerformanceVasConverterImpl;", "performanceVasConverterImpl", "Lcom/avito/android/vas_performance/PerformanceVasConverter;", "provideConverter", "(Lcom/avito/android/vas_performance/PerformanceVasConverterImpl;)Lcom/avito/android/vas_performance/PerformanceVasConverter;", "Lcom/avito/android/vas_performance/repository/VasRepositoryImpl;", "vasRepositoryImpl", "Lcom/avito/android/vas_performance/repository/VasRepository;", "provideVasRepository", "(Lcom/avito/android/vas_performance/repository/VasRepositoryImpl;)Lcom/avito/android/vas_performance/repository/VasRepository;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        PerformanceVasConverter provideConverter(@NotNull PerformanceVasConverterImpl performanceVasConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        VasRepository provideVasRepository(@NotNull VasRepositoryImpl vasRepositoryImpl);
    }

    public PerformanceVasModuleNew(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkoutContext");
        this.a = str;
        this.b = str2;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PerformanceVasViewModel provideViewModel$vas_performance_release(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "factory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(PerformanceVasViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (PerformanceVasViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ViewModelProvider.Factory provideViewModelFactory(@NotNull VasRepository vasRepository, @NotNull SchedulersFactory schedulersFactory, @NotNull PerformanceVasConverter performanceVasConverter, @NotNull PerformanceVasTracker performanceVasTracker) {
        Intrinsics.checkNotNullParameter(vasRepository, "vasRepository");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(performanceVasConverter, "converter");
        Intrinsics.checkNotNullParameter(performanceVasTracker, "tracker");
        return new PerformanceVasViewModelFactory(this.a, this.b, vasRepository, schedulersFactory, performanceVasConverter, performanceVasTracker);
    }
}
