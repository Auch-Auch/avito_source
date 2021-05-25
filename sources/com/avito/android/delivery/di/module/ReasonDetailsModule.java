package com.avito.android.delivery.di.module;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProvider;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProviderImpl;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractor;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractorImpl;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsItemsConverter;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsItemsConverterImpl;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModel;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModelFactory;
import com.avito.android.delivery.order_cancellation.details.ReasonDetailsViewModelImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/delivery/di/module/ReasonDetailsModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModelFactory;", "viewModelFactory", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModel;", "provideReasonDetailsViewModel$delivery_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModelFactory;)Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsViewModel;", "provideReasonDetailsViewModel", "<init>", "()V", "Dependencies", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ReasonDetailsBlueprintsModule.class, Dependencies.class})
public final class ReasonDetailsModule {
    @NotNull
    public static final ReasonDetailsModule INSTANCE = new ReasonDetailsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/delivery/di/module/ReasonDetailsModule$Dependencies;", "", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractorImpl;", "interactor", "Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", "bindOrderCancellationInteractor", "(Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractorImpl;)Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationInteractor;", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverterImpl;", "converter", "Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverter;", "bindReasonDetailsItemsConverter", "(Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverterImpl;)Lcom/avito/android/delivery/order_cancellation/details/ReasonDetailsItemsConverter;", "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "bindOrderCancellationResourceProvider", "(Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProviderImpl;)Lcom/avito/android/delivery/order_cancellation/OrderCancellationResourceProvider;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        RdsOrderCancellationInteractor bindOrderCancellationInteractor(@NotNull RdsOrderCancellationInteractorImpl rdsOrderCancellationInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        OrderCancellationResourceProvider bindOrderCancellationResourceProvider(@NotNull OrderCancellationResourceProviderImpl orderCancellationResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        ReasonDetailsItemsConverter bindReasonDetailsItemsConverter(@NotNull ReasonDetailsItemsConverterImpl reasonDetailsItemsConverterImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ReasonDetailsViewModel provideReasonDetailsViewModel$delivery_release(@NotNull Fragment fragment, @NotNull ReasonDetailsViewModelFactory reasonDetailsViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(reasonDetailsViewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, reasonDetailsViewModelFactory).get(ReasonDetailsViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (ReasonDetailsViewModel) viewModel;
    }
}
