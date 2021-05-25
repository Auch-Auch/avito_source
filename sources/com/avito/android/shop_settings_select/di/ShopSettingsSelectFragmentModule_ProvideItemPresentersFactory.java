package com.avito.android.shop_settings_select.di;

import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
public final class ShopSettingsSelectFragmentModule_ProvideItemPresentersFactory implements Factory<Set<ItemPresenter<?, ?>>> {

    public static final class a {
        public static final ShopSettingsSelectFragmentModule_ProvideItemPresentersFactory a = new ShopSettingsSelectFragmentModule_ProvideItemPresentersFactory();
    }

    public static ShopSettingsSelectFragmentModule_ProvideItemPresentersFactory create() {
        return a.a;
    }

    public static Set<ItemPresenter<?, ?>> provideItemPresenters() {
        return (Set) Preconditions.checkNotNullFromProvides(ShopSettingsSelectFragmentModule.INSTANCE.provideItemPresenters());
    }

    @Override // javax.inject.Provider
    public Set<ItemPresenter<?, ?>> get() {
        return provideItemPresenters();
    }
}
