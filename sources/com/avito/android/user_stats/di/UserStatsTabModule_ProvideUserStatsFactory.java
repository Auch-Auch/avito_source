package com.avito.android.user_stats.di;

import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.user_stats.tab.UserStatsTabViewModel;
import com.avito.android.user_stats.tab.UserStatsTabViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserStatsTabModule_ProvideUserStatsFactory implements Factory<UserStatsTabViewModel> {
    public final Provider<ViewModelStoreOwner> a;
    public final Provider<UserStatsTabViewModelFactory> b;

    public UserStatsTabModule_ProvideUserStatsFactory(Provider<ViewModelStoreOwner> provider, Provider<UserStatsTabViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserStatsTabModule_ProvideUserStatsFactory create(Provider<ViewModelStoreOwner> provider, Provider<UserStatsTabViewModelFactory> provider2) {
        return new UserStatsTabModule_ProvideUserStatsFactory(provider, provider2);
    }

    public static UserStatsTabViewModel provideUserStats(ViewModelStoreOwner viewModelStoreOwner, UserStatsTabViewModelFactory userStatsTabViewModelFactory) {
        return (UserStatsTabViewModel) Preconditions.checkNotNullFromProvides(UserStatsTabModule.INSTANCE.provideUserStats(viewModelStoreOwner, userStatsTabViewModelFactory));
    }

    @Override // javax.inject.Provider
    public UserStatsTabViewModel get() {
        return provideUserStats(this.a.get(), this.b.get());
    }
}
