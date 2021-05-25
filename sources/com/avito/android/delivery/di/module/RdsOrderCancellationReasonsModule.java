package com.avito.android.delivery.di.module;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.screens.RdsOrderCancellationScreen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProvider;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProviderImpl;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractor;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractorImpl;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationItemsConverter;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationItemsConverterImpl;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModelFactory;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModelImpl;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsItemsConverter;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsItemsConverterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/delivery/di/module/RdsOrderCancellationReasonsModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModelFactory;", "viewModelFactory", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModel;", "provideOrderCancellationViewModel", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModelFactory;)Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationReasonsViewModel;", "", "providesScreenContentType", "()Ljava/lang/String;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "contentType", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$delivery_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;Ljava/lang/String;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "<init>", "()V", "Dependencies", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, RdsOrderCancellationBlueprintsModule.class})
public final class RdsOrderCancellationReasonsModule {
    @NotNull
    public static final RdsOrderCancellationReasonsModule INSTANCE = new RdsOrderCancellationReasonsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/delivery/di/module/RdsOrderCancellationReasonsModule$Dependencies;", "", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractorImpl;", "interactor", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", "bindRdsOrderCancellationInteractor", "(Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractorImpl;)Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "bindOrderCancellationResourceProvider", "(Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProviderImpl;)Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverterImpl;", "converter", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverter;", "bindRdsOrderCancellationItemsConverter", "(Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverterImpl;)Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationItemsConverter;", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverterImpl;", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverter;", "bindReasonDetailsItemsConverter", "(Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverterImpl;)Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverter;", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTrackerImpl;", "tracker", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "bindTracker", "(Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTrackerImpl;)Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @Binds
        @NotNull
        OrderCancellationResourceProvider bindOrderCancellationResourceProvider(@NotNull OrderCancellationResourceProviderImpl orderCancellationResourceProviderImpl);

        @Binds
        @NotNull
        RdsOrderCancellationInteractor bindRdsOrderCancellationInteractor(@NotNull RdsOrderCancellationInteractorImpl rdsOrderCancellationInteractorImpl);

        @Binds
        @NotNull
        RdsOrderCancellationItemsConverter bindRdsOrderCancellationItemsConverter(@NotNull RdsOrderCancellationItemsConverterImpl rdsOrderCancellationItemsConverterImpl);

        @Binds
        @NotNull
        ReasonDetailsItemsConverter bindReasonDetailsItemsConverter(@NotNull ReasonDetailsItemsConverterImpl reasonDetailsItemsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        BaseScreenPerformanceTracker bindTracker(@NotNull BaseScreenPerformanceTrackerImpl baseScreenPerformanceTrackerImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final RdsOrderCancellationReasonsViewModel provideOrderCancellationViewModel(@NotNull Fragment fragment, @NotNull RdsOrderCancellationReasonsViewModelFactory rdsOrderCancellationReasonsViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(rdsOrderCancellationReasonsViewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, rdsOrderCancellationReasonsViewModelFactory).get(RdsOrderCancellationReasonsViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (RdsOrderCancellationReasonsViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final String providesScreenContentType() {
        return ScreenPublicConstsKt.CONTENT_TYPE_DELIVERY_ORDER_CANCELLATION;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenDiInjectTracker providesScreenDiInjectTracker$delivery_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory, @NotNull String str) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        Intrinsics.checkNotNullParameter(str, "contentType");
        return screenTrackerFactory.createDiInjectTracker(RdsOrderCancellationScreen.INSTANCE, timerFactory, str);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(RdsOrderCancellationScreen.INSTANCE, timerFactory);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ScreenInitTracker providesScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory, @NotNull String str) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        Intrinsics.checkNotNullParameter(str, "contentType");
        return screenTrackerFactory.createInitTracker(RdsOrderCancellationScreen.INSTANCE, timerFactory, str);
    }
}
