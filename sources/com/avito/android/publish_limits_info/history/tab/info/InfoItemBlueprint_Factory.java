package com.avito.android.publish_limits_info.history.tab.info;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InfoItemBlueprint_Factory implements Factory<InfoItemBlueprint> {
    public final Provider<InfoItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public InfoItemBlueprint_Factory(Provider<InfoItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InfoItemBlueprint_Factory create(Provider<InfoItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new InfoItemBlueprint_Factory(provider, provider2);
    }

    public static InfoItemBlueprint newInstance(InfoItemPresenter infoItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new InfoItemBlueprint(infoItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public InfoItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
