package com.avito.android.tariff.edit_info.item.prolongation;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TariffProlongationItemBlueprint_Factory implements Factory<TariffProlongationItemBlueprint> {
    public final Provider<TariffProlongationItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public TariffProlongationItemBlueprint_Factory(Provider<TariffProlongationItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffProlongationItemBlueprint_Factory create(Provider<TariffProlongationItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new TariffProlongationItemBlueprint_Factory(provider, provider2);
    }

    public static TariffProlongationItemBlueprint newInstance(TariffProlongationItemPresenter tariffProlongationItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new TariffProlongationItemBlueprint(tariffProlongationItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public TariffProlongationItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
