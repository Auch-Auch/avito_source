package com.avito.android.publish.details.di;

import com.avito.android.blueprints.range.cre_range.CreRangeItemBlueprint;
import com.avito.android.blueprints.range.cre_range.CreRangePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideCRERangeItemBlueprintFactory implements Factory<CreRangeItemBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<CreRangePresenter> b;

    public PublishDetailsModule_ProvideCRERangeItemBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<CreRangePresenter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideCRERangeItemBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<CreRangePresenter> provider) {
        return new PublishDetailsModule_ProvideCRERangeItemBlueprintFactory(publishDetailsModule, provider);
    }

    public static CreRangeItemBlueprint provideCRERangeItemBlueprint(PublishDetailsModule publishDetailsModule, CreRangePresenter creRangePresenter) {
        return (CreRangeItemBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideCRERangeItemBlueprint(creRangePresenter));
    }

    @Override // javax.inject.Provider
    public CreRangeItemBlueprint get() {
        return provideCRERangeItemBlueprint(this.a, this.b.get());
    }
}
