package com.avito.android.advert.item.safedeal.trust_factors;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSafeDealTrustFactorsBlueprint_Factory implements Factory<AdvertDetailsSafeDealTrustFactorsBlueprint> {
    public final Provider<AdvertDetailsSafeDealTrustFactorsPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public AdvertDetailsSafeDealTrustFactorsBlueprint_Factory(Provider<AdvertDetailsSafeDealTrustFactorsPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsSafeDealTrustFactorsBlueprint_Factory create(Provider<AdvertDetailsSafeDealTrustFactorsPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new AdvertDetailsSafeDealTrustFactorsBlueprint_Factory(provider, provider2);
    }

    public static AdvertDetailsSafeDealTrustFactorsBlueprint newInstance(AdvertDetailsSafeDealTrustFactorsPresenter advertDetailsSafeDealTrustFactorsPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new AdvertDetailsSafeDealTrustFactorsBlueprint(advertDetailsSafeDealTrustFactorsPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSafeDealTrustFactorsBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
