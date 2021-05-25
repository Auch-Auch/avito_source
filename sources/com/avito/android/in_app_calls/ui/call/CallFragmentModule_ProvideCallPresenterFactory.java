package com.avito.android.in_app_calls.ui.call;

import androidx.fragment.app.Fragment;
import com.avito.android.app.arch_components.ViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CallFragmentModule_ProvideCallPresenterFactory implements Factory<CallPresenter> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelFactory> b;

    public CallFragmentModule_ProvideCallPresenterFactory(Provider<Fragment> provider, Provider<ViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CallFragmentModule_ProvideCallPresenterFactory create(Provider<Fragment> provider, Provider<ViewModelFactory> provider2) {
        return new CallFragmentModule_ProvideCallPresenterFactory(provider, provider2);
    }

    public static CallPresenter provideCallPresenter(Fragment fragment, ViewModelFactory viewModelFactory) {
        return (CallPresenter) Preconditions.checkNotNullFromProvides(CallFragmentModule.INSTANCE.provideCallPresenter(fragment, viewModelFactory));
    }

    @Override // javax.inject.Provider
    public CallPresenter get() {
        return provideCallPresenter(this.a.get(), this.b.get());
    }
}
