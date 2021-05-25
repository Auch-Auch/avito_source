package com.avito.android.publish.category_suggest.di;

import com.avito.android.publish.select.blueprints.CheckableItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CategoriesSuggestionsModule_ProvideCheckableItemPresenterFactory implements Factory<CheckableItemPresenter> {
    public final CategoriesSuggestionsModule a;

    public CategoriesSuggestionsModule_ProvideCheckableItemPresenterFactory(CategoriesSuggestionsModule categoriesSuggestionsModule) {
        this.a = categoriesSuggestionsModule;
    }

    public static CategoriesSuggestionsModule_ProvideCheckableItemPresenterFactory create(CategoriesSuggestionsModule categoriesSuggestionsModule) {
        return new CategoriesSuggestionsModule_ProvideCheckableItemPresenterFactory(categoriesSuggestionsModule);
    }

    public static CheckableItemPresenter provideCheckableItemPresenter(CategoriesSuggestionsModule categoriesSuggestionsModule) {
        return (CheckableItemPresenter) Preconditions.checkNotNullFromProvides(categoriesSuggestionsModule.provideCheckableItemPresenter());
    }

    @Override // javax.inject.Provider
    public CheckableItemPresenter get() {
        return provideCheckableItemPresenter(this.a);
    }
}
