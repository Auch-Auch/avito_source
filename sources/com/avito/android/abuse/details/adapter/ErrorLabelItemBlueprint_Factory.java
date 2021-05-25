package com.avito.android.abuse.details.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ErrorLabelItemBlueprint_Factory implements Factory<ErrorLabelItemBlueprint> {
    public final Provider<ErrorLabelItemPresenter> a;

    public ErrorLabelItemBlueprint_Factory(Provider<ErrorLabelItemPresenter> provider) {
        this.a = provider;
    }

    public static ErrorLabelItemBlueprint_Factory create(Provider<ErrorLabelItemPresenter> provider) {
        return new ErrorLabelItemBlueprint_Factory(provider);
    }

    public static ErrorLabelItemBlueprint newInstance(ErrorLabelItemPresenter errorLabelItemPresenter) {
        return new ErrorLabelItemBlueprint(errorLabelItemPresenter);
    }

    @Override // javax.inject.Provider
    public ErrorLabelItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
