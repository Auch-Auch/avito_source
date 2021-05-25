package com.avito.android.publish.select.di;

import com.avito.android.publish.select.blueprints.CheckableItemBlueprint;
import com.avito.android.select.title.TitleItemViewBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SelectModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final SelectModule a;
    public final Provider<CheckableItemBlueprint> b;
    public final Provider<TitleItemViewBlueprint> c;

    public SelectModule_ProvideItemBinderFactory(SelectModule selectModule, Provider<CheckableItemBlueprint> provider, Provider<TitleItemViewBlueprint> provider2) {
        this.a = selectModule;
        this.b = provider;
        this.c = provider2;
    }

    public static SelectModule_ProvideItemBinderFactory create(SelectModule selectModule, Provider<CheckableItemBlueprint> provider, Provider<TitleItemViewBlueprint> provider2) {
        return new SelectModule_ProvideItemBinderFactory(selectModule, provider, provider2);
    }

    public static ItemBinder provideItemBinder(SelectModule selectModule, CheckableItemBlueprint checkableItemBlueprint, TitleItemViewBlueprint titleItemViewBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(selectModule.provideItemBinder(checkableItemBlueprint, titleItemViewBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a, this.b.get(), this.c.get());
    }
}
