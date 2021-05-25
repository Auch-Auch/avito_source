package com.avito.android.verification.di;

import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.verification.verification_status.VerificationStatusViewModel;
import com.avito.android.verification.verification_status.VerificationStatusViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VerificationStatusModule_ProvideUserStatsFactory implements Factory<VerificationStatusViewModel> {
    public final VerificationStatusModule a;
    public final Provider<ViewModelStoreOwner> b;
    public final Provider<VerificationStatusViewModelFactory> c;

    public VerificationStatusModule_ProvideUserStatsFactory(VerificationStatusModule verificationStatusModule, Provider<ViewModelStoreOwner> provider, Provider<VerificationStatusViewModelFactory> provider2) {
        this.a = verificationStatusModule;
        this.b = provider;
        this.c = provider2;
    }

    public static VerificationStatusModule_ProvideUserStatsFactory create(VerificationStatusModule verificationStatusModule, Provider<ViewModelStoreOwner> provider, Provider<VerificationStatusViewModelFactory> provider2) {
        return new VerificationStatusModule_ProvideUserStatsFactory(verificationStatusModule, provider, provider2);
    }

    public static VerificationStatusViewModel provideUserStats(VerificationStatusModule verificationStatusModule, ViewModelStoreOwner viewModelStoreOwner, VerificationStatusViewModelFactory verificationStatusViewModelFactory) {
        return (VerificationStatusViewModel) Preconditions.checkNotNullFromProvides(verificationStatusModule.provideUserStats(viewModelStoreOwner, verificationStatusViewModelFactory));
    }

    @Override // javax.inject.Provider
    public VerificationStatusViewModel get() {
        return provideUserStats(this.a, this.b.get(), this.c.get());
    }
}
