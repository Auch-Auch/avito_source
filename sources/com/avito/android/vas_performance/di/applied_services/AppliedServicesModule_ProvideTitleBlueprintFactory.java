package com.avito.android.vas_performance.di.applied_services;

import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitlePresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AppliedServicesModule_ProvideTitleBlueprintFactory implements Factory<ItemBlueprint<?, ?>> {
    public final AppliedServicesModule a;
    public final Provider<TitlePresenter> b;

    public AppliedServicesModule_ProvideTitleBlueprintFactory(AppliedServicesModule appliedServicesModule, Provider<TitlePresenter> provider) {
        this.a = appliedServicesModule;
        this.b = provider;
    }

    public static AppliedServicesModule_ProvideTitleBlueprintFactory create(AppliedServicesModule appliedServicesModule, Provider<TitlePresenter> provider) {
        return new AppliedServicesModule_ProvideTitleBlueprintFactory(appliedServicesModule, provider);
    }

    public static ItemBlueprint<?, ?> provideTitleBlueprint(AppliedServicesModule appliedServicesModule, TitlePresenter titlePresenter) {
        return (ItemBlueprint) Preconditions.checkNotNullFromProvides(appliedServicesModule.provideTitleBlueprint(titlePresenter));
    }

    @Override // javax.inject.Provider
    public ItemBlueprint<?, ?> get() {
        return provideTitleBlueprint(this.a, this.b.get());
    }
}
