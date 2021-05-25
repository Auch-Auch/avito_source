package com.avito.android.publish.wizard.di;

import com.avito.android.publish.wizard.blueprint.WizardItemPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class WizardModule_ProvideItemPresentersSetFactory implements Factory<Set<ItemPresenter<?, ?>>> {
    public final WizardModule a;
    public final Provider<WizardItemPresenter> b;

    public WizardModule_ProvideItemPresentersSetFactory(WizardModule wizardModule, Provider<WizardItemPresenter> provider) {
        this.a = wizardModule;
        this.b = provider;
    }

    public static WizardModule_ProvideItemPresentersSetFactory create(WizardModule wizardModule, Provider<WizardItemPresenter> provider) {
        return new WizardModule_ProvideItemPresentersSetFactory(wizardModule, provider);
    }

    public static Set<ItemPresenter<?, ?>> provideItemPresentersSet(WizardModule wizardModule, WizardItemPresenter wizardItemPresenter) {
        return (Set) Preconditions.checkNotNullFromProvides(wizardModule.provideItemPresentersSet(wizardItemPresenter));
    }

    @Override // javax.inject.Provider
    public Set<ItemPresenter<?, ?>> get() {
        return provideItemPresentersSet(this.a, this.b.get());
    }
}
