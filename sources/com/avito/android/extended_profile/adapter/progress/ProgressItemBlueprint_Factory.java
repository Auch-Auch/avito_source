package com.avito.android.extended_profile.adapter.progress;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProgressItemBlueprint_Factory implements Factory<ProgressItemBlueprint> {
    public final Provider<ProgressItemPresenter> a;

    public ProgressItemBlueprint_Factory(Provider<ProgressItemPresenter> provider) {
        this.a = provider;
    }

    public static ProgressItemBlueprint_Factory create(Provider<ProgressItemPresenter> provider) {
        return new ProgressItemBlueprint_Factory(provider);
    }

    public static ProgressItemBlueprint newInstance(ProgressItemPresenter progressItemPresenter) {
        return new ProgressItemBlueprint(progressItemPresenter);
    }

    @Override // javax.inject.Provider
    public ProgressItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
