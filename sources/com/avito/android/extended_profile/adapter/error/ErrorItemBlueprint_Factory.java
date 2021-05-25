package com.avito.android.extended_profile.adapter.error;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ErrorItemBlueprint_Factory implements Factory<ErrorItemBlueprint> {
    public final Provider<ErrorItemPresenter> a;

    public ErrorItemBlueprint_Factory(Provider<ErrorItemPresenter> provider) {
        this.a = provider;
    }

    public static ErrorItemBlueprint_Factory create(Provider<ErrorItemPresenter> provider) {
        return new ErrorItemBlueprint_Factory(provider);
    }

    public static ErrorItemBlueprint newInstance(ErrorItemPresenter errorItemPresenter) {
        return new ErrorItemBlueprint(errorItemPresenter);
    }

    @Override // javax.inject.Provider
    public ErrorItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
