package com.avito.android.delivery.map.point_info.konveyor.title;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TitleItemBlueprint_Factory implements Factory<TitleItemBlueprint> {
    public final Provider<TitleItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public TitleItemBlueprint_Factory(Provider<TitleItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TitleItemBlueprint_Factory create(Provider<TitleItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new TitleItemBlueprint_Factory(provider, provider2);
    }

    public static TitleItemBlueprint newInstance(TitleItemPresenter titleItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new TitleItemBlueprint(titleItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public TitleItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
