package com.avito.android.vas_performance.di.visual;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.VisualVasConverter;
import com.avito.android.vas_performance.VisualVasConverterImpl;
import com.avito.android.vas_performance.VisualVasViewModelImpl;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.repository.VasRepositoryImpl;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import com.avito.android.vas_performance.ui.VisualVasViewModel;
import com.avito.android.vas_performance.ui.VisualVasViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/avito/android/vas_performance/di/visual/VisualVasModuleNew;", "", "Lcom/avito/android/vas_performance/repository/VasRepository;", "vasRepository", "Lcom/avito/android/vas_performance/VisualVasConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "tracker", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/vas_performance/VisualVasConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/vas_performance/tracker/VisualVasTracker;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/fragment/app/Fragment;", "fragment", "factory", "Lcom/avito/android/vas_performance/ui/VisualVasViewModel;", "provideViewModel$vas_performance_release", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/vas_performance/ui/VisualVasViewModel;", "provideViewModel", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, AuthSource.BOOKING_ORDER, "checkoutContext", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Declarations", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class VisualVasModuleNew {
    public final String a;
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/vas_performance/di/visual/VisualVasModuleNew$Declarations;", "", "Lcom/avito/android/vas_performance/VisualVasConverterImpl;", "performanceVasConverterImpl", "Lcom/avito/android/vas_performance/VisualVasConverter;", "provideConverter", "(Lcom/avito/android/vas_performance/VisualVasConverterImpl;)Lcom/avito/android/vas_performance/VisualVasConverter;", "Lcom/avito/android/vas_performance/repository/VasRepositoryImpl;", "vasRepositoryImpl", "Lcom/avito/android/vas_performance/repository/VasRepository;", "provideVasRepository", "(Lcom/avito/android/vas_performance/repository/VasRepositoryImpl;)Lcom/avito/android/vas_performance/repository/VasRepository;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        VisualVasConverter provideConverter(@NotNull VisualVasConverterImpl visualVasConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        VasRepository provideVasRepository(@NotNull VasRepositoryImpl vasRepositoryImpl);
    }

    public VisualVasModuleNew(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkoutContext");
        this.a = str;
        this.b = str2;
    }

    @Provides
    @PerFragment
    @NotNull
    public final VisualVasViewModel provideViewModel$vas_performance_release(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "factory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(VisualVasViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (VisualVasViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ViewModelProvider.Factory provideViewModelFactory(@NotNull VasRepository vasRepository, @NotNull VisualVasConverter visualVasConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull VisualVasTracker visualVasTracker) {
        Intrinsics.checkNotNullParameter(vasRepository, "vasRepository");
        Intrinsics.checkNotNullParameter(visualVasConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(visualVasTracker, "tracker");
        return new VisualVasViewModelFactory(this.a, this.b, vasRepository, visualVasConverter, schedulersFactory, visualVasTracker);
    }
}
