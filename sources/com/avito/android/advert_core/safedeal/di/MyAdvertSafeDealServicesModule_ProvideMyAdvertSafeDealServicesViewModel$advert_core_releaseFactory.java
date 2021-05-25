package com.avito.android.advert_core.safedeal.di;

import androidx.lifecycle.LifecycleOwner;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel;
import com.avito.android.advert_core.safedeal.MyAdvertSafedealServicesViewModelFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesViewModel$advert_core_releaseFactory implements Factory<MyAdvertSafeDealServicesViewModel> {
    public final Provider<LifecycleOwner> a;
    public final Provider<MyAdvertSafedealServicesViewModelFactory> b;

    public MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesViewModel$advert_core_releaseFactory(Provider<LifecycleOwner> provider, Provider<MyAdvertSafedealServicesViewModelFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesViewModel$advert_core_releaseFactory create(Provider<LifecycleOwner> provider, Provider<MyAdvertSafedealServicesViewModelFactory> provider2) {
        return new MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesViewModel$advert_core_releaseFactory(provider, provider2);
    }

    public static MyAdvertSafeDealServicesViewModel provideMyAdvertSafeDealServicesViewModel$advert_core_release(LifecycleOwner lifecycleOwner, MyAdvertSafedealServicesViewModelFactory myAdvertSafedealServicesViewModelFactory) {
        return (MyAdvertSafeDealServicesViewModel) Preconditions.checkNotNullFromProvides(MyAdvertSafeDealServicesModule.INSTANCE.provideMyAdvertSafeDealServicesViewModel$advert_core_release(lifecycleOwner, myAdvertSafedealServicesViewModelFactory));
    }

    @Override // javax.inject.Provider
    public MyAdvertSafeDealServicesViewModel get() {
        return provideMyAdvertSafeDealServicesViewModel$advert_core_release(this.a.get(), this.b.get());
    }
}
