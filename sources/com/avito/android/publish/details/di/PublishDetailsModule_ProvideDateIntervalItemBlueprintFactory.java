package com.avito.android.publish.details.di;

import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemBlueprint;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideDateIntervalItemBlueprintFactory implements Factory<DateIntervalItemBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<DateIntervalItemPresenter> b;

    public PublishDetailsModule_ProvideDateIntervalItemBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<DateIntervalItemPresenter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideDateIntervalItemBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<DateIntervalItemPresenter> provider) {
        return new PublishDetailsModule_ProvideDateIntervalItemBlueprintFactory(publishDetailsModule, provider);
    }

    public static DateIntervalItemBlueprint provideDateIntervalItemBlueprint(PublishDetailsModule publishDetailsModule, DateIntervalItemPresenter dateIntervalItemPresenter) {
        return (DateIntervalItemBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideDateIntervalItemBlueprint(dateIntervalItemPresenter));
    }

    @Override // javax.inject.Provider
    public DateIntervalItemBlueprint get() {
        return provideDateIntervalItemBlueprint(this.a, this.b.get());
    }
}
