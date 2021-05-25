package com.avito.android.publish.input_vin.di;

import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.publish.input_vin.items.scan_button.ScanVinButtonItemPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class InputVinModule_ProvideItemPresentersSetFactory implements Factory<Set<ItemPresenter<?, ?>>> {
    public final Provider<ScanVinButtonItemPresenter> a;
    public final Provider<MultiStateInputItemPresenter> b;

    public InputVinModule_ProvideItemPresentersSetFactory(Provider<ScanVinButtonItemPresenter> provider, Provider<MultiStateInputItemPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InputVinModule_ProvideItemPresentersSetFactory create(Provider<ScanVinButtonItemPresenter> provider, Provider<MultiStateInputItemPresenter> provider2) {
        return new InputVinModule_ProvideItemPresentersSetFactory(provider, provider2);
    }

    public static Set<ItemPresenter<?, ?>> provideItemPresentersSet(ScanVinButtonItemPresenter scanVinButtonItemPresenter, MultiStateInputItemPresenter multiStateInputItemPresenter) {
        return (Set) Preconditions.checkNotNullFromProvides(InputVinModule.provideItemPresentersSet(scanVinButtonItemPresenter, multiStateInputItemPresenter));
    }

    @Override // javax.inject.Provider
    public Set<ItemPresenter<?, ?>> get() {
        return provideItemPresentersSet(this.a.get(), this.b.get());
    }
}
