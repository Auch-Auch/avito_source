package com.avito.android.advert_core.feature_teasers.common.dialog;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsFeatureTeaserDialogTextItemBlueprint_Factory implements Factory<AdvertDetailsFeatureTeaserDialogTextItemBlueprint> {
    public final Provider<AdvertDetailsFeatureTeaserDialogTextItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public AdvertDetailsFeatureTeaserDialogTextItemBlueprint_Factory(Provider<AdvertDetailsFeatureTeaserDialogTextItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsFeatureTeaserDialogTextItemBlueprint_Factory create(Provider<AdvertDetailsFeatureTeaserDialogTextItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new AdvertDetailsFeatureTeaserDialogTextItemBlueprint_Factory(provider, provider2);
    }

    public static AdvertDetailsFeatureTeaserDialogTextItemBlueprint newInstance(AdvertDetailsFeatureTeaserDialogTextItemPresenter advertDetailsFeatureTeaserDialogTextItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new AdvertDetailsFeatureTeaserDialogTextItemBlueprint(advertDetailsFeatureTeaserDialogTextItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsFeatureTeaserDialogTextItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
