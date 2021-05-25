package com.avito.android.delivery.di.module;

import androidx.fragment.app.Fragment;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModel;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class RdsOrderCancellationReasonsModule_ProvideOrderCancellationViewModelFactory implements Factory<RdsOrderCancellationReasonsViewModel> {
    public final Provider<Fragment> a;
    public final Provider<RdsOrderCancellationReasonsViewModelFactory> b;

    public RdsOrderCancellationReasonsModule_ProvideOrderCancellationViewModelFactory(Provider<Fragment> provider, Provider<RdsOrderCancellationReasonsViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static RdsOrderCancellationReasonsModule_ProvideOrderCancellationViewModelFactory create(Provider<Fragment> provider, Provider<RdsOrderCancellationReasonsViewModelFactory> provider2) {
        return new RdsOrderCancellationReasonsModule_ProvideOrderCancellationViewModelFactory(provider, provider2);
    }

    public static RdsOrderCancellationReasonsViewModel provideOrderCancellationViewModel(Fragment fragment, RdsOrderCancellationReasonsViewModelFactory rdsOrderCancellationReasonsViewModelFactory) {
        return (RdsOrderCancellationReasonsViewModel) Preconditions.checkNotNullFromProvides(RdsOrderCancellationReasonsModule.INSTANCE.provideOrderCancellationViewModel(fragment, rdsOrderCancellationReasonsViewModelFactory));
    }

    @Override // javax.inject.Provider
    public RdsOrderCancellationReasonsViewModel get() {
        return provideOrderCancellationViewModel(this.a.get(), this.b.get());
    }
}
