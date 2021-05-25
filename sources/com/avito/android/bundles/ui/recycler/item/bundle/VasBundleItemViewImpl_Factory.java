package com.avito.android.bundles.ui.recycler.item.bundle;

import android.view.View;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VasBundleItemViewImpl_Factory implements Factory<VasBundleItemViewImpl> {
    public final Provider<View> a;
    public final Provider<AttributedTextFormatter> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<ItemBinder> d;

    public VasBundleItemViewImpl_Factory(Provider<View> provider, Provider<AttributedTextFormatter> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static VasBundleItemViewImpl_Factory create(Provider<View> provider, Provider<AttributedTextFormatter> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4) {
        return new VasBundleItemViewImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static VasBundleItemViewImpl newInstance(View view, AttributedTextFormatter attributedTextFormatter, AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return new VasBundleItemViewImpl(view, attributedTextFormatter, adapterPresenter, itemBinder);
    }

    @Override // javax.inject.Provider
    public VasBundleItemViewImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
