package com.avito.android.user_stats.di;

import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.user_stats.UserStatsViewModel;
import com.avito.android.user_stats.UserStatsViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserStatsModule_ProvideUserStatsFactory implements Factory<UserStatsViewModel> {
    public final Provider<ViewModelStoreOwner> a;
    public final Provider<UserStatsViewModelFactory> b;

    public UserStatsModule_ProvideUserStatsFactory(Provider<ViewModelStoreOwner> provider, Provider<UserStatsViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserStatsModule_ProvideUserStatsFactory create(Provider<ViewModelStoreOwner> provider, Provider<UserStatsViewModelFactory> provider2) {
        return new UserStatsModule_ProvideUserStatsFactory(provider, provider2);
    }

    public static UserStatsViewModel provideUserStats(ViewModelStoreOwner viewModelStoreOwner, UserStatsViewModelFactory userStatsViewModelFactory) {
        return (UserStatsViewModel) Preconditions.checkNotNullFromProvides(UserStatsModule.INSTANCE.provideUserStats(viewModelStoreOwner, userStatsViewModelFactory));
    }

    @Override // javax.inject.Provider
    public UserStatsViewModel get() {
        return provideUserStats(this.a.get(), this.b.get());
    }
}
