package com.avito.android.in_app_calls.ui.callReview;

import androidx.fragment.app.Fragment;
import com.avito.android.app.arch_components.ViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CallReviewFragmentModule_ProvideCallReviewPresenterFactory implements Factory<CallReviewPresenter> {
    public final Provider<Fragment> a;
    public final Provider<ViewModelFactory> b;

    public CallReviewFragmentModule_ProvideCallReviewPresenterFactory(Provider<Fragment> provider, Provider<ViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CallReviewFragmentModule_ProvideCallReviewPresenterFactory create(Provider<Fragment> provider, Provider<ViewModelFactory> provider2) {
        return new CallReviewFragmentModule_ProvideCallReviewPresenterFactory(provider, provider2);
    }

    public static CallReviewPresenter provideCallReviewPresenter(Fragment fragment, ViewModelFactory viewModelFactory) {
        return (CallReviewPresenter) Preconditions.checkNotNullFromProvides(CallReviewFragmentModule.INSTANCE.provideCallReviewPresenter(fragment, viewModelFactory));
    }

    @Override // javax.inject.Provider
    public CallReviewPresenter get() {
        return provideCallReviewPresenter(this.a.get(), this.b.get());
    }
}
