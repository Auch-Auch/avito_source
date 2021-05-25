package com.avito.android.publish.details.di;

import com.avito.android.publish.details.adapter.multiselect.MultiselectItemBlueprint;
import com.avito.android.publish.details.adapter.multiselect.RdsMultiselectItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideMultiselectItemBlueprintFactory implements Factory<MultiselectItemBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<RdsMultiselectItemPresenter> b;

    public PublishDetailsModule_ProvideMultiselectItemBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<RdsMultiselectItemPresenter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideMultiselectItemBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<RdsMultiselectItemPresenter> provider) {
        return new PublishDetailsModule_ProvideMultiselectItemBlueprintFactory(publishDetailsModule, provider);
    }

    public static MultiselectItemBlueprint provideMultiselectItemBlueprint(PublishDetailsModule publishDetailsModule, RdsMultiselectItemPresenter rdsMultiselectItemPresenter) {
        return (MultiselectItemBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideMultiselectItemBlueprint(rdsMultiselectItemPresenter));
    }

    @Override // javax.inject.Provider
    public MultiselectItemBlueprint get() {
        return provideMultiselectItemBlueprint(this.a, this.b.get());
    }
}
