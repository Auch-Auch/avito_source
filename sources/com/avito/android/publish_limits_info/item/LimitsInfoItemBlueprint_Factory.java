package com.avito.android.publish_limits_info.item;

import com.avito.android.publish_limits_info.item.LimitsInfoItemBlueprint;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LimitsInfoItemBlueprint_Factory implements Factory<LimitsInfoItemBlueprint> {
    public final Provider<LimitsInfoItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;
    public final Provider<LimitsInfoItemBlueprint.LayoutProvider> c;

    public LimitsInfoItemBlueprint_Factory(Provider<LimitsInfoItemPresenter> provider, Provider<AttributedTextFormatter> provider2, Provider<LimitsInfoItemBlueprint.LayoutProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static LimitsInfoItemBlueprint_Factory create(Provider<LimitsInfoItemPresenter> provider, Provider<AttributedTextFormatter> provider2, Provider<LimitsInfoItemBlueprint.LayoutProvider> provider3) {
        return new LimitsInfoItemBlueprint_Factory(provider, provider2, provider3);
    }

    public static LimitsInfoItemBlueprint newInstance(LimitsInfoItemPresenter limitsInfoItemPresenter, AttributedTextFormatter attributedTextFormatter, LimitsInfoItemBlueprint.LayoutProvider layoutProvider) {
        return new LimitsInfoItemBlueprint(limitsInfoItemPresenter, attributedTextFormatter, layoutProvider);
    }

    @Override // javax.inject.Provider
    public LimitsInfoItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
