package com.avito.android.verification.verifications_list.list;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerificationsListBlueprint_Factory implements Factory<VerificationsListBlueprint> {
    public final Provider<VerificationsListItemPresenter> a;

    public VerificationsListBlueprint_Factory(Provider<VerificationsListItemPresenter> provider) {
        this.a = provider;
    }

    public static VerificationsListBlueprint_Factory create(Provider<VerificationsListItemPresenter> provider) {
        return new VerificationsListBlueprint_Factory(provider);
    }

    public static VerificationsListBlueprint newInstance(VerificationsListItemPresenter verificationsListItemPresenter) {
        return new VerificationsListBlueprint(verificationsListItemPresenter);
    }

    @Override // javax.inject.Provider
    public VerificationsListBlueprint get() {
        return newInstance(this.a.get());
    }
}
