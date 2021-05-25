package com.avito.android.delivery.di.module;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.screens.DeliveryLocationSuggestScreen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestInteractor;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestInteractorImpl;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModel;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModelFactory;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestViewModelImpl;
import com.avito.android.delivery.suggest.konveyor.empty.EmptyBlueprint;
import com.avito.android.delivery.suggest.konveyor.empty.EmptyItemPresenter;
import com.avito.android.delivery.suggest.konveyor.empty.EmptyItemPresenterImpl;
import com.avito.android.delivery.suggest.konveyor.suggest.SuggestBlueprint;
import com.avito.android.delivery.suggest.konveyor.suggest.SuggestItemPresenter;
import com.avito.android.delivery.suggest.konveyor.suggest.SuggestItemPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.location_picker.providers.AddressGeoCoder;
import com.avito.android.location_picker.providers.AvitoAddressGeoCoder;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002¢\u0006\u0004\b.\u0010/J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010%\u001a\u00020$2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001cH\u0007¢\u0006\u0004\b%\u0010&J'\u0010*\u001a\u00020'2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001cH\u0001¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020+2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/avito/android/delivery/di/module/DeliveryLocationSuggestModule;", "", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModelFactory;", "viewModelFactory", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;", "provideDeliveryCancelSuggestsViewModel$delivery_release", "(Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModelFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;", "provideDeliveryCancelSuggestsViewModel", "viewModel", "Lcom/avito/android/delivery/suggest/konveyor/suggest/SuggestItemPresenter;", "provideSuggestItemPresenter$delivery_release", "(Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestViewModel;)Lcom/avito/android/delivery/suggest/konveyor/suggest/SuggestItemPresenter;", "provideSuggestItemPresenter", "Lcom/avito/android/delivery/suggest/konveyor/suggest/SuggestBlueprint;", "suggestBlueprint", "Lcom/avito/android/delivery/suggest/konveyor/empty/EmptyBlueprint;", "emptyBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideSuggestItemBinder$delivery_release", "(Lcom/avito/android/delivery/suggest/konveyor/suggest/SuggestBlueprint;Lcom/avito/android/delivery/suggest/konveyor/empty/EmptyBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideSuggestItemBinder", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$delivery_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "", "providesScreenContentType", "()Ljava/lang/String;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "contentType", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$delivery_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "<init>", "()V", "Dependencies", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class DeliveryLocationSuggestModule {
    @NotNull
    public static final DeliveryLocationSuggestModule INSTANCE = new DeliveryLocationSuggestModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/delivery/di/module/DeliveryLocationSuggestModule$Dependencies;", "", "Lcom/avito/android/location_picker/providers/AvitoAddressGeoCoder;", "geoCoder", "Lcom/avito/android/location_picker/providers/AddressGeoCoder;", "bindAddressGeoCoder", "(Lcom/avito/android/location_picker/providers/AvitoAddressGeoCoder;)Lcom/avito/android/location_picker/providers/AddressGeoCoder;", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestInteractorImpl;", "interactor", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestInteractor;", "bindsLocationSuggestInteractor", "(Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestInteractorImpl;)Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestInteractor;", "Lcom/avito/android/delivery/suggest/konveyor/empty/EmptyItemPresenterImpl;", "presenter", "Lcom/avito/android/delivery/suggest/konveyor/empty/EmptyItemPresenter;", "bindEmptyItemPresenter", "(Lcom/avito/android/delivery/suggest/konveyor/empty/EmptyItemPresenterImpl;)Lcom/avito/android/delivery/suggest/konveyor/empty/EmptyItemPresenter;", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTrackerImpl;", "tracker", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "bindTracker", "(Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTrackerImpl;)Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        AddressGeoCoder bindAddressGeoCoder(@NotNull AvitoAddressGeoCoder avitoAddressGeoCoder);

        @PerFragment
        @Binds
        @NotNull
        EmptyItemPresenter bindEmptyItemPresenter(@NotNull EmptyItemPresenterImpl emptyItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        BaseScreenPerformanceTracker bindTracker(@NotNull BaseScreenPerformanceTrackerImpl baseScreenPerformanceTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryLocationSuggestInteractor bindsLocationSuggestInteractor(@NotNull DeliveryLocationSuggestInteractorImpl deliveryLocationSuggestInteractorImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$delivery_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DeliveryLocationSuggestViewModel provideDeliveryCancelSuggestsViewModel$delivery_release(@NotNull DeliveryLocationSuggestViewModelFactory deliveryLocationSuggestViewModelFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(deliveryLocationSuggestViewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment, deliveryLocationSuggestViewModelFactory).get(DeliveryLocationSuggestViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (DeliveryLocationSuggestViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideSuggestItemBinder$delivery_release(@NotNull SuggestBlueprint suggestBlueprint, @NotNull EmptyBlueprint emptyBlueprint) {
        Intrinsics.checkNotNullParameter(suggestBlueprint, "suggestBlueprint");
        Intrinsics.checkNotNullParameter(emptyBlueprint, "emptyBlueprint");
        return new ItemBinder.Builder().registerItem(suggestBlueprint).registerItem(emptyBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final SuggestItemPresenter provideSuggestItemPresenter$delivery_release(@NotNull DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel) {
        Intrinsics.checkNotNullParameter(deliveryLocationSuggestViewModel, "viewModel");
        return new SuggestItemPresenterImpl(deliveryLocationSuggestViewModel.getCoordinatesConsumer());
    }

    @Provides
    @PerFragment
    @NotNull
    public final String providesScreenContentType() {
        return ScreenPublicConstsKt.CONTENT_TYPE_DELIVERY_LOCATION_SUGGEST;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenDiInjectTracker providesScreenDiInjectTracker$delivery_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory, @NotNull String str) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        Intrinsics.checkNotNullParameter(str, "contentType");
        return screenTrackerFactory.createDiInjectTracker(DeliveryLocationSuggestScreen.INSTANCE, timerFactory, str);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(DeliveryLocationSuggestScreen.INSTANCE, timerFactory);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenInitTracker providesScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory, @NotNull String str) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        Intrinsics.checkNotNullParameter(str, "contentType");
        return screenTrackerFactory.createInitTracker(DeliveryLocationSuggestScreen.INSTANCE, timerFactory, str);
    }
}
