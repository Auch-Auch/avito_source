package com.avito.android.verification.di;

import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.verification.verifications_list.VerificationsListViewModel;
import com.avito.android.verification.verifications_list.VerificationsListViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VerificationsListModule_ProvideUserStatsFactory implements Factory<VerificationsListViewModel> {
    public final VerificationsListModule a;
    public final Provider<ViewModelStoreOwner> b;
    public final Provider<VerificationsListViewModelFactory> c;

    public VerificationsListModule_ProvideUserStatsFactory(VerificationsListModule verificationsListModule, Provider<ViewModelStoreOwner> provider, Provider<VerificationsListViewModelFactory> provider2) {
        this.a = verificationsListModule;
        this.b = provider;
        this.c = provider2;
    }

    public static VerificationsListModule_ProvideUserStatsFactory create(VerificationsListModule verificationsListModule, Provider<ViewModelStoreOwner> provider, Provider<VerificationsListViewModelFactory> provider2) {
        return new VerificationsListModule_ProvideUserStatsFactory(verificationsListModule, provider, provider2);
    }

    public static VerificationsListViewModel provideUserStats(VerificationsListModule verificationsListModule, ViewModelStoreOwner viewModelStoreOwner, VerificationsListViewModelFactory verificationsListViewModelFactory) {
        return (VerificationsListViewModel) Preconditions.checkNotNullFromProvides(verificationsListModule.provideUserStats(viewModelStoreOwner, verificationsListViewModelFactory));
    }

    @Override // javax.inject.Provider
    public VerificationsListViewModel get() {
        return provideUserStats(this.a, this.b.get(), this.c.get());
    }
}
