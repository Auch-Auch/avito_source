package com.avito.android.advert_core.feature_teasers.common.dialog;

import dagger.internal.Factory;
public final class AdvertDetailsFeatureTeaserDialogTextItemPresenter_Factory implements Factory<AdvertDetailsFeatureTeaserDialogTextItemPresenter> {

    public static final class a {
        public static final AdvertDetailsFeatureTeaserDialogTextItemPresenter_Factory a = new AdvertDetailsFeatureTeaserDialogTextItemPresenter_Factory();
    }

    public static AdvertDetailsFeatureTeaserDialogTextItemPresenter_Factory create() {
        return a.a;
    }

    public static AdvertDetailsFeatureTeaserDialogTextItemPresenter newInstance() {
        return new AdvertDetailsFeatureTeaserDialogTextItemPresenter();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsFeatureTeaserDialogTextItemPresenter get() {
        return newInstance();
    }
}
