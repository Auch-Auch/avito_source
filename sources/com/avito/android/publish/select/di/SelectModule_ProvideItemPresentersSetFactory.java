package com.avito.android.publish.select.di;

import com.avito.android.publish.select.blueprints.CheckableItemPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class SelectModule_ProvideItemPresentersSetFactory implements Factory<Set<ItemPresenter<?, ?>>> {
    public final SelectModule a;
    public final Provider<CheckableItemPresenter> b;

    public SelectModule_ProvideItemPresentersSetFactory(SelectModule selectModule, Provider<CheckableItemPresenter> provider) {
        this.a = selectModule;
        this.b = provider;
    }

    public static SelectModule_ProvideItemPresentersSetFactory create(SelectModule selectModule, Provider<CheckableItemPresenter> provider) {
        return new SelectModule_ProvideItemPresentersSetFactory(selectModule, provider);
    }

    public static Set<ItemPresenter<?, ?>> provideItemPresentersSet(SelectModule selectModule, CheckableItemPresenter checkableItemPresenter) {
        return (Set) Preconditions.checkNotNullFromProvides(selectModule.provideItemPresentersSet(checkableItemPresenter));
    }

    @Override // javax.inject.Provider
    public Set<ItemPresenter<?, ?>> get() {
        return provideItemPresentersSet(this.a, this.b.get());
    }
}
