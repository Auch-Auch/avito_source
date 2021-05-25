package com.avito.android.publish_limits_info.history.di;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.publish_limits_info.history.PublishLimitsHistoryViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishLimitsHistoryModule_ProvideViewModelFactory implements Factory<PublishLimitsHistoryViewModel> {
    public final Provider<FragmentActivity> a;
    public final Provider<ViewModelProvider.Factory> b;

    public PublishLimitsHistoryModule_ProvideViewModelFactory(Provider<FragmentActivity> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PublishLimitsHistoryModule_ProvideViewModelFactory create(Provider<FragmentActivity> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new PublishLimitsHistoryModule_ProvideViewModelFactory(provider, provider2);
    }

    public static PublishLimitsHistoryViewModel provideViewModel(FragmentActivity fragmentActivity, ViewModelProvider.Factory factory) {
        return (PublishLimitsHistoryViewModel) Preconditions.checkNotNullFromProvides(PublishLimitsHistoryModule.INSTANCE.provideViewModel(fragmentActivity, factory));
    }

    @Override // javax.inject.Provider
    public PublishLimitsHistoryViewModel get() {
        return provideViewModel(this.a.get(), this.b.get());
    }
}
