package com.avito.android.advert.item.features_teaser.items;

import dagger.internal.Factory;
public final class AdvertDetailsFeatureTeaserDialogPreviewItemPresenter_Factory implements Factory<AdvertDetailsFeatureTeaserDialogPreviewItemPresenter> {

    public static final class a {
        public static final AdvertDetailsFeatureTeaserDialogPreviewItemPresenter_Factory a = new AdvertDetailsFeatureTeaserDialogPreviewItemPresenter_Factory();
    }

    public static AdvertDetailsFeatureTeaserDialogPreviewItemPresenter_Factory create() {
        return a.a;
    }

    public static AdvertDetailsFeatureTeaserDialogPreviewItemPresenter newInstance() {
        return new AdvertDetailsFeatureTeaserDialogPreviewItemPresenter();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsFeatureTeaserDialogPreviewItemPresenter get() {
        return newInstance();
    }
}
