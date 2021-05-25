package com.avito.android.user_advert.advert.autopublish_block.di;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishBlockViewModel;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishBlockViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AutoPublishBlockModule_ProvideAdvertDeliveryBlockViewModelFactory implements Factory<AutoPublishBlockViewModel> {
    public final Provider<AutoPublishBlockViewModelFactory> a;
    public final Provider<FragmentActivity> b;

    public AutoPublishBlockModule_ProvideAdvertDeliveryBlockViewModelFactory(Provider<AutoPublishBlockViewModelFactory> provider, Provider<FragmentActivity> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AutoPublishBlockModule_ProvideAdvertDeliveryBlockViewModelFactory create(Provider<AutoPublishBlockViewModelFactory> provider, Provider<FragmentActivity> provider2) {
        return new AutoPublishBlockModule_ProvideAdvertDeliveryBlockViewModelFactory(provider, provider2);
    }

    public static AutoPublishBlockViewModel provideAdvertDeliveryBlockViewModel(AutoPublishBlockViewModelFactory autoPublishBlockViewModelFactory, FragmentActivity fragmentActivity) {
        return (AutoPublishBlockViewModel) Preconditions.checkNotNullFromProvides(AutoPublishBlockModule.provideAdvertDeliveryBlockViewModel(autoPublishBlockViewModelFactory, fragmentActivity));
    }

    @Override // javax.inject.Provider
    public AutoPublishBlockViewModel get() {
        return provideAdvertDeliveryBlockViewModel(this.a.get(), this.b.get());
    }
}
