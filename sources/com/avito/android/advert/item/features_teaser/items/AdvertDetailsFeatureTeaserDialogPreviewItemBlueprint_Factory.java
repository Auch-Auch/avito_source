package com.avito.android.advert.item.features_teaser.items;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsFeatureTeaserDialogPreviewItemBlueprint_Factory implements Factory<AdvertDetailsFeatureTeaserDialogPreviewItemBlueprint> {
    public final Provider<AdvertDetailsFeatureTeaserDialogPreviewItemPresenter> a;

    public AdvertDetailsFeatureTeaserDialogPreviewItemBlueprint_Factory(Provider<AdvertDetailsFeatureTeaserDialogPreviewItemPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsFeatureTeaserDialogPreviewItemBlueprint_Factory create(Provider<AdvertDetailsFeatureTeaserDialogPreviewItemPresenter> provider) {
        return new AdvertDetailsFeatureTeaserDialogPreviewItemBlueprint_Factory(provider);
    }

    public static AdvertDetailsFeatureTeaserDialogPreviewItemBlueprint newInstance(AdvertDetailsFeatureTeaserDialogPreviewItemPresenter advertDetailsFeatureTeaserDialogPreviewItemPresenter) {
        return new AdvertDetailsFeatureTeaserDialogPreviewItemBlueprint(advertDetailsFeatureTeaserDialogPreviewItemPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsFeatureTeaserDialogPreviewItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
