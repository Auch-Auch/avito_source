package com.avito.android.publish.details.di;

import com.avito.android.blueprints.select.MultiStateSelectItemBlueprint;
import com.avito.android.blueprints.select.MultiStateSelectItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideSelectItemBlueprintFactory implements Factory<MultiStateSelectItemBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<MultiStateSelectItemPresenter> b;

    public PublishDetailsModule_ProvideSelectItemBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<MultiStateSelectItemPresenter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideSelectItemBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<MultiStateSelectItemPresenter> provider) {
        return new PublishDetailsModule_ProvideSelectItemBlueprintFactory(publishDetailsModule, provider);
    }

    public static MultiStateSelectItemBlueprint provideSelectItemBlueprint(PublishDetailsModule publishDetailsModule, MultiStateSelectItemPresenter multiStateSelectItemPresenter) {
        return (MultiStateSelectItemBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideSelectItemBlueprint(multiStateSelectItemPresenter));
    }

    @Override // javax.inject.Provider
    public MultiStateSelectItemBlueprint get() {
        return provideSelectItemBlueprint(this.a, this.b.get());
    }
}
