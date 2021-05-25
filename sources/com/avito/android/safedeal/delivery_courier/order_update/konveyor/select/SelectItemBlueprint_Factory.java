package com.avito.android.safedeal.delivery_courier.order_update.konveyor.select;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectItemBlueprint_Factory implements Factory<SelectItemBlueprint> {
    public final Provider<SelectItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public SelectItemBlueprint_Factory(Provider<SelectItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SelectItemBlueprint_Factory create(Provider<SelectItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new SelectItemBlueprint_Factory(provider, provider2);
    }

    public static SelectItemBlueprint newInstance(SelectItemPresenter selectItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new SelectItemBlueprint(selectItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public SelectItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
