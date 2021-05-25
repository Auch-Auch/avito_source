package com.avito.android.select;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectDialogPresenterResourceProvider_Factory implements Factory<SelectDialogPresenterResourceProvider> {
    public final Provider<Resources> a;

    public SelectDialogPresenterResourceProvider_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SelectDialogPresenterResourceProvider_Factory create(Provider<Resources> provider) {
        return new SelectDialogPresenterResourceProvider_Factory(provider);
    }

    public static SelectDialogPresenterResourceProvider newInstance(Resources resources) {
        return new SelectDialogPresenterResourceProvider(resources);
    }

    @Override // javax.inject.Provider
    public SelectDialogPresenterResourceProvider get() {
        return newInstance(this.a.get());
    }
}
