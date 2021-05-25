package com.avito.android.verification.di;

import com.avito.android.verification.verifications_list.list.VerificationsListItemPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class VerificationsListModule_ProvideItemPresentersSetFactory implements Factory<Set<ItemPresenter<?, ?>>> {
    public final VerificationsListModule a;
    public final Provider<VerificationsListItemPresenter> b;

    public VerificationsListModule_ProvideItemPresentersSetFactory(VerificationsListModule verificationsListModule, Provider<VerificationsListItemPresenter> provider) {
        this.a = verificationsListModule;
        this.b = provider;
    }

    public static VerificationsListModule_ProvideItemPresentersSetFactory create(VerificationsListModule verificationsListModule, Provider<VerificationsListItemPresenter> provider) {
        return new VerificationsListModule_ProvideItemPresentersSetFactory(verificationsListModule, provider);
    }

    public static Set<ItemPresenter<?, ?>> provideItemPresentersSet(VerificationsListModule verificationsListModule, VerificationsListItemPresenter verificationsListItemPresenter) {
        return (Set) Preconditions.checkNotNullFromProvides(verificationsListModule.provideItemPresentersSet(verificationsListItemPresenter));
    }

    @Override // javax.inject.Provider
    public Set<ItemPresenter<?, ?>> get() {
        return provideItemPresentersSet(this.a, this.b.get());
    }
}
