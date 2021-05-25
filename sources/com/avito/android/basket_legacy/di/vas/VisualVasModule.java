package com.avito.android.basket_legacy.di.vas;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.basket_legacy.di.AdvertId;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.viewmodels.vas.visual.LegacyVisualVasViewModelFactory;
import com.avito.android.basket_legacy.viewmodels.vas.visual.LegacyVisualVasViewModelImpl;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_performance.LegacyVisualVasViewModel;
import com.avito.android.vas_performance.StringProvider;
import com.avito.android.vas_performance.StringProviderImpl;
import com.avito.android.vas_performance.VisualVasConverter;
import com.avito.android.vas_performance.VisualVasConverterImpl;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJI\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/avito/android/basket_legacy/di/vas/VisualVasModule;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/vas_performance/repository/VasRepository;", "vasRepository", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "basketRepository", "Lcom/avito/android/vas_performance/VisualVasConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/vas_performance/StringProvider;", "stringProvider", "Lcom/avito/android/vas_performance/tracker/VisualVasTracker;", "visualVasTracker", "Lcom/avito/android/basket_legacy/viewmodels/vas/visual/LegacyVisualVasViewModelFactory;", "provideViewModelFactory", "(Ljava/lang/String;Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/basket_legacy/repositories/BasketRepository;Lcom/avito/android/vas_performance/VisualVasConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/vas_performance/StringProvider;Lcom/avito/android/vas_performance/tracker/VisualVasTracker;)Lcom/avito/android/basket_legacy/viewmodels/vas/visual/LegacyVisualVasViewModelFactory;", "Landroidx/fragment/app/FragmentActivity;", "activity", "factory", "Lcom/avito/android/vas_performance/LegacyVisualVasViewModel;", "provideViewModelImpl$basket_release", "(Landroidx/fragment/app/FragmentActivity;Lcom/avito/android/basket_legacy/viewmodels/vas/visual/LegacyVisualVasViewModelFactory;)Lcom/avito/android/vas_performance/LegacyVisualVasViewModel;", "provideViewModelImpl", "<init>", "()V", "Declarations", "basket_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, VisualVasAnalyticsModule.class})
public final class VisualVasModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/basket_legacy/di/vas/VisualVasModule$Declarations;", "", "Lcom/avito/android/vas_performance/VisualVasConverterImpl;", "visualVasConverterImpl", "Lcom/avito/android/vas_performance/VisualVasConverter;", "provideConverter", "(Lcom/avito/android/vas_performance/VisualVasConverterImpl;)Lcom/avito/android/vas_performance/VisualVasConverter;", "Lcom/avito/android/vas_performance/StringProviderImpl;", "stringProviderImpl", "Lcom/avito/android/vas_performance/StringProvider;", "provideStringProvider", "(Lcom/avito/android/vas_performance/StringProviderImpl;)Lcom/avito/android/vas_performance/StringProvider;", "basket_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        VisualVasConverter provideConverter(@NotNull VisualVasConverterImpl visualVasConverterImpl);

        @PerActivity
        @Binds
        @NotNull
        StringProvider provideStringProvider(@NotNull StringProviderImpl stringProviderImpl);
    }

    @Provides
    @PerActivity
    @NotNull
    public final LegacyVisualVasViewModelFactory provideViewModelFactory(@AdvertId @NotNull String str, @NotNull VasRepository vasRepository, @NotNull BasketRepository basketRepository, @NotNull VisualVasConverter visualVasConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull StringProvider stringProvider, @NotNull VisualVasTracker visualVasTracker) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(vasRepository, "vasRepository");
        Intrinsics.checkNotNullParameter(basketRepository, "basketRepository");
        Intrinsics.checkNotNullParameter(visualVasConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(visualVasTracker, "visualVasTracker");
        return new LegacyVisualVasViewModelFactory(str, vasRepository, basketRepository, visualVasConverter, schedulersFactory, stringProvider, visualVasTracker);
    }

    @Provides
    @PerActivity
    @NotNull
    public final LegacyVisualVasViewModel provideViewModelImpl$basket_release(@NotNull FragmentActivity fragmentActivity, @NotNull LegacyVisualVasViewModelFactory legacyVisualVasViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(legacyVisualVasViewModelFactory, "factory");
        ViewModel viewModel = ViewModelProviders.of(fragmentActivity, legacyVisualVasViewModelFactory).get(LegacyVisualVasViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…iewModelImpl::class.java)");
        return (LegacyVisualVasViewModel) viewModel;
    }
}
