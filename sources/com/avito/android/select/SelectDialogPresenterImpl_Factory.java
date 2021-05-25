package com.avito.android.select;

import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.select.SelectDialogPresenter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
public final class SelectDialogPresenterImpl_Factory implements Factory<SelectDialogPresenterImpl> {
    public final Provider<SelectDialogInteractor> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<SelectDialogPresenter.ResourceProvider> d;
    public final Provider<Arguments> e;
    public final Provider<Bundle> f;
    public final Provider<Set<ItemPresenter<?, ?>>> g;
    public final Provider<Features> h;

    public SelectDialogPresenterImpl_Factory(Provider<SelectDialogInteractor> provider, Provider<AdapterPresenter> provider2, Provider<SchedulersFactory3> provider3, Provider<SelectDialogPresenter.ResourceProvider> provider4, Provider<Arguments> provider5, Provider<Bundle> provider6, Provider<Set<ItemPresenter<?, ?>>> provider7, Provider<Features> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static SelectDialogPresenterImpl_Factory create(Provider<SelectDialogInteractor> provider, Provider<AdapterPresenter> provider2, Provider<SchedulersFactory3> provider3, Provider<SelectDialogPresenter.ResourceProvider> provider4, Provider<Arguments> provider5, Provider<Bundle> provider6, Provider<Set<ItemPresenter<?, ?>>> provider7, Provider<Features> provider8) {
        return new SelectDialogPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static SelectDialogPresenterImpl newInstance(SelectDialogInteractor selectDialogInteractor, AdapterPresenter adapterPresenter, SchedulersFactory3 schedulersFactory3, SelectDialogPresenter.ResourceProvider resourceProvider, Arguments arguments, Bundle bundle, Set<ItemPresenter<?, ?>> set, Features features) {
        return new SelectDialogPresenterImpl(selectDialogInteractor, adapterPresenter, schedulersFactory3, resourceProvider, arguments, bundle, set, features);
    }

    @Override // javax.inject.Provider
    public SelectDialogPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
