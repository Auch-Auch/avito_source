package com.avito.android.search.map.interactor;

import com.avito.android.search.map.viewed_pins.ViewedPinsStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ViewedPinsInteractorImpl_Factory implements Factory<ViewedPinsInteractorImpl> {
    public final Provider<ViewedPinsStorage> a;

    public ViewedPinsInteractorImpl_Factory(Provider<ViewedPinsStorage> provider) {
        this.a = provider;
    }

    public static ViewedPinsInteractorImpl_Factory create(Provider<ViewedPinsStorage> provider) {
        return new ViewedPinsInteractorImpl_Factory(provider);
    }

    public static ViewedPinsInteractorImpl newInstance(ViewedPinsStorage viewedPinsStorage) {
        return new ViewedPinsInteractorImpl(viewedPinsStorage);
    }

    @Override // javax.inject.Provider
    public ViewedPinsInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
