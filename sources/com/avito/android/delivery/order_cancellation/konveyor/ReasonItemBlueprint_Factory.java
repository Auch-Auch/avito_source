package com.avito.android.delivery.order_cancellation.konveyor;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ReasonItemBlueprint_Factory implements Factory<ReasonItemBlueprint> {
    public final Provider<ReasonItemPresenter> a;

    public ReasonItemBlueprint_Factory(Provider<ReasonItemPresenter> provider) {
        this.a = provider;
    }

    public static ReasonItemBlueprint_Factory create(Provider<ReasonItemPresenter> provider) {
        return new ReasonItemBlueprint_Factory(provider);
    }

    public static ReasonItemBlueprint newInstance(ReasonItemPresenter reasonItemPresenter) {
        return new ReasonItemBlueprint(reasonItemPresenter);
    }

    @Override // javax.inject.Provider
    public ReasonItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
