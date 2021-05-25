package com.avito.android.bundles.vas_union.item.performance.vas;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PerformanceVasBlueprint_Factory implements Factory<PerformanceVasBlueprint> {
    public final Provider<PerformanceVasItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public PerformanceVasBlueprint_Factory(Provider<PerformanceVasItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PerformanceVasBlueprint_Factory create(Provider<PerformanceVasItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new PerformanceVasBlueprint_Factory(provider, provider2);
    }

    public static PerformanceVasBlueprint newInstance(PerformanceVasItemPresenter performanceVasItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new PerformanceVasBlueprint(performanceVasItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public PerformanceVasBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
