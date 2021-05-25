package com.avito.android.autodeal_details.di;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.autodeal_details.AutoDealDetailsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AutoDealDetailsModule_ProvideAutoDealDetailsViewModelFactory implements Factory<AutoDealDetailsViewModel> {
    public final Provider<ViewModelProvider.Factory> a;
    public final Provider<FragmentActivity> b;

    public AutoDealDetailsModule_ProvideAutoDealDetailsViewModelFactory(Provider<ViewModelProvider.Factory> provider, Provider<FragmentActivity> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AutoDealDetailsModule_ProvideAutoDealDetailsViewModelFactory create(Provider<ViewModelProvider.Factory> provider, Provider<FragmentActivity> provider2) {
        return new AutoDealDetailsModule_ProvideAutoDealDetailsViewModelFactory(provider, provider2);
    }

    public static AutoDealDetailsViewModel provideAutoDealDetailsViewModel(ViewModelProvider.Factory factory, FragmentActivity fragmentActivity) {
        return (AutoDealDetailsViewModel) Preconditions.checkNotNullFromProvides(AutoDealDetailsModule.INSTANCE.provideAutoDealDetailsViewModel(factory, fragmentActivity));
    }

    @Override // javax.inject.Provider
    public AutoDealDetailsViewModel get() {
        return provideAutoDealDetailsViewModel(this.a.get(), this.b.get());
    }
}
