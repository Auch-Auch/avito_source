package com.avito.android.vas_performance.ui.items.applied_services;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AppliedServiceBlueprint_Factory implements Factory<AppliedServiceBlueprint> {
    public final Provider<AppliedServiceItemPresenter> a;

    public AppliedServiceBlueprint_Factory(Provider<AppliedServiceItemPresenter> provider) {
        this.a = provider;
    }

    public static AppliedServiceBlueprint_Factory create(Provider<AppliedServiceItemPresenter> provider) {
        return new AppliedServiceBlueprint_Factory(provider);
    }

    public static AppliedServiceBlueprint newInstance(AppliedServiceItemPresenter appliedServiceItemPresenter) {
        return new AppliedServiceBlueprint(appliedServiceItemPresenter);
    }

    @Override // javax.inject.Provider
    public AppliedServiceBlueprint get() {
        return newInstance(this.a.get());
    }
}
