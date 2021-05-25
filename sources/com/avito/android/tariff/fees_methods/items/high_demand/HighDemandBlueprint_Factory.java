package com.avito.android.tariff.fees_methods.items.high_demand;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HighDemandBlueprint_Factory implements Factory<HighDemandBlueprint> {
    public final Provider<HighDemandPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public HighDemandBlueprint_Factory(Provider<HighDemandPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static HighDemandBlueprint_Factory create(Provider<HighDemandPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new HighDemandBlueprint_Factory(provider, provider2);
    }

    public static HighDemandBlueprint newInstance(HighDemandPresenter highDemandPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new HighDemandBlueprint(highDemandPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public HighDemandBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
