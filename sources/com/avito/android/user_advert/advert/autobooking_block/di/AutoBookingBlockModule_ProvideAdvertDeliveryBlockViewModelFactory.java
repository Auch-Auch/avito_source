package com.avito.android.user_advert.advert.autobooking_block.di;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingBlockViewModel;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingBlockViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AutoBookingBlockModule_ProvideAdvertDeliveryBlockViewModelFactory implements Factory<AutoBookingBlockViewModel> {
    public final Provider<AutoBookingBlockViewModelFactory> a;
    public final Provider<FragmentActivity> b;

    public AutoBookingBlockModule_ProvideAdvertDeliveryBlockViewModelFactory(Provider<AutoBookingBlockViewModelFactory> provider, Provider<FragmentActivity> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AutoBookingBlockModule_ProvideAdvertDeliveryBlockViewModelFactory create(Provider<AutoBookingBlockViewModelFactory> provider, Provider<FragmentActivity> provider2) {
        return new AutoBookingBlockModule_ProvideAdvertDeliveryBlockViewModelFactory(provider, provider2);
    }

    public static AutoBookingBlockViewModel provideAdvertDeliveryBlockViewModel(AutoBookingBlockViewModelFactory autoBookingBlockViewModelFactory, FragmentActivity fragmentActivity) {
        return (AutoBookingBlockViewModel) Preconditions.checkNotNullFromProvides(AutoBookingBlockModule.provideAdvertDeliveryBlockViewModel(autoBookingBlockViewModelFactory, fragmentActivity));
    }

    @Override // javax.inject.Provider
    public AutoBookingBlockViewModel get() {
        return provideAdvertDeliveryBlockViewModel(this.a.get(), this.b.get());
    }
}
