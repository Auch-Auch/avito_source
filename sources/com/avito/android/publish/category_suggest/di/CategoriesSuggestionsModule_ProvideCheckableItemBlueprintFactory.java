package com.avito.android.publish.category_suggest.di;

import com.avito.android.publish.select.blueprints.CheckableItemBlueprint;
import com.avito.android.publish.select.blueprints.CheckableItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CategoriesSuggestionsModule_ProvideCheckableItemBlueprintFactory implements Factory<CheckableItemBlueprint> {
    public final CategoriesSuggestionsModule a;
    public final Provider<CheckableItemPresenter> b;

    public CategoriesSuggestionsModule_ProvideCheckableItemBlueprintFactory(CategoriesSuggestionsModule categoriesSuggestionsModule, Provider<CheckableItemPresenter> provider) {
        this.a = categoriesSuggestionsModule;
        this.b = provider;
    }

    public static CategoriesSuggestionsModule_ProvideCheckableItemBlueprintFactory create(CategoriesSuggestionsModule categoriesSuggestionsModule, Provider<CheckableItemPresenter> provider) {
        return new CategoriesSuggestionsModule_ProvideCheckableItemBlueprintFactory(categoriesSuggestionsModule, provider);
    }

    public static CheckableItemBlueprint provideCheckableItemBlueprint(CategoriesSuggestionsModule categoriesSuggestionsModule, CheckableItemPresenter checkableItemPresenter) {
        return (CheckableItemBlueprint) Preconditions.checkNotNullFromProvides(categoriesSuggestionsModule.provideCheckableItemBlueprint(checkableItemPresenter));
    }

    @Override // javax.inject.Provider
    public CheckableItemBlueprint get() {
        return provideCheckableItemBlueprint(this.a, this.b.get());
    }
}
