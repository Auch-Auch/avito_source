package com.avito.android.safedeal.delivery_courier.di.module;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.di.PerFragment;
import com.avito.android.safedeal.delivery_courier.di.qualifier.OrderID;
import com.avito.android.safedeal.delivery_courier.di.qualifier.Source;
import com.avito.android.safedeal.delivery_courier.di.qualifier.TimeInterval;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectAnalyticsTracker;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectInteractor;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectInteractorImpl;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectResourceProvider;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectResourceProviderImpl;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModel;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModelFactory;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectViewModelImpl;
import com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval.TimeIntervalBlueprint;
import com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval.TimeIntervalItemPresenter;
import com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval.TimeIntervalItemPresenterImpl;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0002¢\u0006\u0004\b(\u0010)JO\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001aH\u0001¢\u0006\u0004\b \u0010!J\u0017\u0010'\u001a\u00020$2\u0006\u0010#\u001a\u00020\u001fH\u0001¢\u0006\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/module/DeliveryCourierTimeIntervalSelectModule;", "", "", "orderID", "source", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "selectedTimeInterval", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProvider;", "resourceProvider", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTracker;", "tracker", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModelFactory;", "provideDeliveryCourierTimeIntervalSelectViewModelFactory", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/delivery_courier/TimeInterval;Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProvider;Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTracker;)Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModelFactory;", "viewModelFactory", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModel;", "provideDeliveryCourierTimeIntervalSelectViewModel$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModelFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModel;", "provideDeliveryCourierTimeIntervalSelectViewModel", "viewModel", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItemPresenter;", "provideDateRangeItemPresenter$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectViewModel;)Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItemPresenter;", "provideDateRangeItemPresenter", "presenter", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalBlueprint;", "provideDateRangeBluePrint$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItemPresenter;)Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalBlueprint;", "provideDateRangeBluePrint", "timeIntervalBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideSuggestItemBinder$safedeal_release", "(Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideSuggestItemBinder", "<init>", "()V", "Dependencies", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class DeliveryCourierTimeIntervalSelectModule {
    @NotNull
    public static final DeliveryCourierTimeIntervalSelectModule INSTANCE = new DeliveryCourierTimeIntervalSelectModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/module/DeliveryCourierTimeIntervalSelectModule$Dependencies;", "", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectInteractorImpl;", "interactor", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectInteractor;", "bindsTimeIntervalInteractor", "(Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectInteractorImpl;)Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectInteractor;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProvider;", "bindsDeliveryCourierTimeIntervalResourceProvider", "(Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProviderImpl;)Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProvider;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl;", "tracker", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTracker;", "bindsDeliveryTimeIntervalSelectAnalyticsTracker", "(Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl;)Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTracker;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        DeliveryCourierTimeIntervalSelectResourceProvider bindsDeliveryCourierTimeIntervalResourceProvider(@NotNull DeliveryCourierTimeIntervalSelectResourceProviderImpl deliveryCourierTimeIntervalSelectResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryCourierTimeIntervalSelectAnalyticsTracker bindsDeliveryTimeIntervalSelectAnalyticsTracker(@NotNull DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl deliveryCourierTimeIntervalSelectAnalyticsTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryCourierTimeIntervalSelectInteractor bindsTimeIntervalInteractor(@NotNull DeliveryCourierTimeIntervalSelectInteractorImpl deliveryCourierTimeIntervalSelectInteractorImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TimeIntervalBlueprint provideDateRangeBluePrint$safedeal_release(@NotNull TimeIntervalItemPresenter timeIntervalItemPresenter) {
        Intrinsics.checkNotNullParameter(timeIntervalItemPresenter, "presenter");
        return new TimeIntervalBlueprint(timeIntervalItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TimeIntervalItemPresenter provideDateRangeItemPresenter$safedeal_release(@NotNull DeliveryCourierTimeIntervalSelectViewModel deliveryCourierTimeIntervalSelectViewModel) {
        Intrinsics.checkNotNullParameter(deliveryCourierTimeIntervalSelectViewModel, "viewModel");
        return new TimeIntervalItemPresenterImpl(deliveryCourierTimeIntervalSelectViewModel.getSelectedItemConsumer());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DeliveryCourierTimeIntervalSelectViewModel provideDeliveryCourierTimeIntervalSelectViewModel$safedeal_release(@NotNull DeliveryCourierTimeIntervalSelectViewModelFactory deliveryCourierTimeIntervalSelectViewModelFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(deliveryCourierTimeIntervalSelectViewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = ViewModelProviders.of(fragment, deliveryCourierTimeIntervalSelectViewModelFactory).get(DeliveryCourierTimeIntervalSelectViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (DeliveryCourierTimeIntervalSelectViewModel) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DeliveryCourierTimeIntervalSelectViewModelFactory provideDeliveryCourierTimeIntervalSelectViewModelFactory(@OrderID @NotNull String str, @Source @NotNull String str2, @TimeInterval @Nullable com.avito.android.remote.model.delivery_courier.TimeInterval timeInterval, @NotNull DeliveryCourierTimeIntervalSelectInteractor deliveryCourierTimeIntervalSelectInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull DeliveryCourierTimeIntervalSelectResourceProvider deliveryCourierTimeIntervalSelectResourceProvider, @NotNull DeliveryCourierTimeIntervalSelectAnalyticsTracker deliveryCourierTimeIntervalSelectAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(str, "orderID");
        Intrinsics.checkNotNullParameter(str2, "source");
        Intrinsics.checkNotNullParameter(deliveryCourierTimeIntervalSelectInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(deliveryCourierTimeIntervalSelectResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(deliveryCourierTimeIntervalSelectAnalyticsTracker, "tracker");
        return new DeliveryCourierTimeIntervalSelectViewModelFactory(str, str2, timeInterval, deliveryCourierTimeIntervalSelectInteractor, schedulersFactory, deliveryCourierTimeIntervalSelectResourceProvider, deliveryCourierTimeIntervalSelectAnalyticsTracker);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideSuggestItemBinder$safedeal_release(@NotNull TimeIntervalBlueprint timeIntervalBlueprint) {
        Intrinsics.checkNotNullParameter(timeIntervalBlueprint, "timeIntervalBlueprint");
        return new ItemBinder.Builder().registerItem(timeIntervalBlueprint).build();
    }
}
