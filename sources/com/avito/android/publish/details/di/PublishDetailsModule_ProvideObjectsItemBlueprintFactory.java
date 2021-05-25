package com.avito.android.publish.details.di;

import com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemBlueprint;
import com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideObjectsItemBlueprintFactory implements Factory<MultiStateObjectsItemBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<MultiStateObjectsItemPresenter> b;

    public PublishDetailsModule_ProvideObjectsItemBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<MultiStateObjectsItemPresenter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideObjectsItemBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<MultiStateObjectsItemPresenter> provider) {
        return new PublishDetailsModule_ProvideObjectsItemBlueprintFactory(publishDetailsModule, provider);
    }

    public static MultiStateObjectsItemBlueprint provideObjectsItemBlueprint(PublishDetailsModule publishDetailsModule, MultiStateObjectsItemPresenter multiStateObjectsItemPresenter) {
        return (MultiStateObjectsItemBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideObjectsItemBlueprint(multiStateObjectsItemPresenter));
    }

    @Override // javax.inject.Provider
    public MultiStateObjectsItemBlueprint get() {
        return provideObjectsItemBlueprint(this.a, this.b.get());
    }
}
