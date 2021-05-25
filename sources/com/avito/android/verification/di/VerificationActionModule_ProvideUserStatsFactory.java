package com.avito.android.verification.di;

import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.verification.verification_status.actions.VerificationActionViewModel;
import com.avito.android.verification.verification_status.actions.VerificationActionViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VerificationActionModule_ProvideUserStatsFactory implements Factory<VerificationActionViewModel> {
    public final VerificationActionModule a;
    public final Provider<ViewModelStoreOwner> b;
    public final Provider<VerificationActionViewModelFactory> c;

    public VerificationActionModule_ProvideUserStatsFactory(VerificationActionModule verificationActionModule, Provider<ViewModelStoreOwner> provider, Provider<VerificationActionViewModelFactory> provider2) {
        this.a = verificationActionModule;
        this.b = provider;
        this.c = provider2;
    }

    public static VerificationActionModule_ProvideUserStatsFactory create(VerificationActionModule verificationActionModule, Provider<ViewModelStoreOwner> provider, Provider<VerificationActionViewModelFactory> provider2) {
        return new VerificationActionModule_ProvideUserStatsFactory(verificationActionModule, provider, provider2);
    }

    public static VerificationActionViewModel provideUserStats(VerificationActionModule verificationActionModule, ViewModelStoreOwner viewModelStoreOwner, VerificationActionViewModelFactory verificationActionViewModelFactory) {
        return (VerificationActionViewModel) Preconditions.checkNotNullFromProvides(verificationActionModule.provideUserStats(viewModelStoreOwner, verificationActionViewModelFactory));
    }

    @Override // javax.inject.Provider
    public VerificationActionViewModel get() {
        return provideUserStats(this.a, this.b.get(), this.c.get());
    }
}
