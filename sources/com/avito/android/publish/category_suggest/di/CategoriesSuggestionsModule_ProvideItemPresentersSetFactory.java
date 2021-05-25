package com.avito.android.publish.category_suggest.di;

import com.avito.android.publish.wizard.blueprint.WizardItemPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class CategoriesSuggestionsModule_ProvideItemPresentersSetFactory implements Factory<Set<ItemPresenter<?, ?>>> {
    public final CategoriesSuggestionsModule a;
    public final Provider<WizardItemPresenter> b;

    public CategoriesSuggestionsModule_ProvideItemPresentersSetFactory(CategoriesSuggestionsModule categoriesSuggestionsModule, Provider<WizardItemPresenter> provider) {
        this.a = categoriesSuggestionsModule;
        this.b = provider;
    }

    public static CategoriesSuggestionsModule_ProvideItemPresentersSetFactory create(CategoriesSuggestionsModule categoriesSuggestionsModule, Provider<WizardItemPresenter> provider) {
        return new CategoriesSuggestionsModule_ProvideItemPresentersSetFactory(categoriesSuggestionsModule, provider);
    }

    public static Set<ItemPresenter<?, ?>> provideItemPresentersSet(CategoriesSuggestionsModule categoriesSuggestionsModule, WizardItemPresenter wizardItemPresenter) {
        return (Set) Preconditions.checkNotNullFromProvides(categoriesSuggestionsModule.provideItemPresentersSet(wizardItemPresenter));
    }

    @Override // javax.inject.Provider
    public Set<ItemPresenter<?, ?>> get() {
        return provideItemPresentersSet(this.a, this.b.get());
    }
}
