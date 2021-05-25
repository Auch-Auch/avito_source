package com.avito.android.publish.select.di;

import com.avito.android.publish.select.blueprints.CheckableItemBlueprint;
import com.avito.android.publish.select.blueprints.CheckableItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SelectModule_ProvideCheckableItemBlueprintFactory implements Factory<CheckableItemBlueprint> {
    public final SelectModule a;
    public final Provider<CheckableItemPresenter> b;

    public SelectModule_ProvideCheckableItemBlueprintFactory(SelectModule selectModule, Provider<CheckableItemPresenter> provider) {
        this.a = selectModule;
        this.b = provider;
    }

    public static SelectModule_ProvideCheckableItemBlueprintFactory create(SelectModule selectModule, Provider<CheckableItemPresenter> provider) {
        return new SelectModule_ProvideCheckableItemBlueprintFactory(selectModule, provider);
    }

    public static CheckableItemBlueprint provideCheckableItemBlueprint(SelectModule selectModule, CheckableItemPresenter checkableItemPresenter) {
        return (CheckableItemBlueprint) Preconditions.checkNotNullFromProvides(selectModule.provideCheckableItemBlueprint(checkableItemPresenter));
    }

    @Override // javax.inject.Provider
    public CheckableItemBlueprint get() {
        return provideCheckableItemBlueprint(this.a, this.b.get());
    }
}
