package com.avito.android.recycler.responsive;

import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ResponsiveAdapterPresenterImpl_Factory implements Factory<ResponsiveAdapterPresenterImpl> {
    public final Provider<AdapterPresenter> a;
    public final Provider<CallableResponsiveItemPresenterRegistry> b;

    public ResponsiveAdapterPresenterImpl_Factory(Provider<AdapterPresenter> provider, Provider<CallableResponsiveItemPresenterRegistry> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ResponsiveAdapterPresenterImpl_Factory create(Provider<AdapterPresenter> provider, Provider<CallableResponsiveItemPresenterRegistry> provider2) {
        return new ResponsiveAdapterPresenterImpl_Factory(provider, provider2);
    }

    public static ResponsiveAdapterPresenterImpl newInstance(AdapterPresenter adapterPresenter, CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry) {
        return new ResponsiveAdapterPresenterImpl(adapterPresenter, callableResponsiveItemPresenterRegistry);
    }

    @Override // javax.inject.Provider
    public ResponsiveAdapterPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
