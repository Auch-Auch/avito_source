package com.avito.android.profile.cards.tfa;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TfaSettingsBlueprint_Factory implements Factory<TfaSettingsBlueprint> {
    public final Provider<TfaSettingsItemPresenter> a;

    public TfaSettingsBlueprint_Factory(Provider<TfaSettingsItemPresenter> provider) {
        this.a = provider;
    }

    public static TfaSettingsBlueprint_Factory create(Provider<TfaSettingsItemPresenter> provider) {
        return new TfaSettingsBlueprint_Factory(provider);
    }

    public static TfaSettingsBlueprint newInstance(TfaSettingsItemPresenter tfaSettingsItemPresenter) {
        return new TfaSettingsBlueprint(tfaSettingsItemPresenter);
    }

    @Override // javax.inject.Provider
    public TfaSettingsBlueprint get() {
        return newInstance(this.a.get());
    }
}
