package com.avito.android.bundles.ui.recycler.item.bundle;

import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VasBundleBlueprint_Factory implements Factory<VasBundleBlueprint> {
    public final Provider<VasBundleItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;
    public final Provider<ItemBinder> c;
    public final Provider<AdapterPresenter> d;

    public VasBundleBlueprint_Factory(Provider<VasBundleItemPresenter> provider, Provider<AttributedTextFormatter> provider2, Provider<ItemBinder> provider3, Provider<AdapterPresenter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static VasBundleBlueprint_Factory create(Provider<VasBundleItemPresenter> provider, Provider<AttributedTextFormatter> provider2, Provider<ItemBinder> provider3, Provider<AdapterPresenter> provider4) {
        return new VasBundleBlueprint_Factory(provider, provider2, provider3, provider4);
    }

    public static VasBundleBlueprint newInstance(VasBundleItemPresenter vasBundleItemPresenter, AttributedTextFormatter attributedTextFormatter, ItemBinder itemBinder, AdapterPresenter adapterPresenter) {
        return new VasBundleBlueprint(vasBundleItemPresenter, attributedTextFormatter, itemBinder, adapterPresenter);
    }

    @Override // javax.inject.Provider
    public VasBundleBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
