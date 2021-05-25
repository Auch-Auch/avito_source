package com.avito.android.advert_core.feature_teasers.common;

import dagger.internal.Factory;
public final class CommonAdvertDetailsFeatureTeaserItemsAdapter_Factory implements Factory<CommonAdvertDetailsFeatureTeaserItemsAdapter> {

    public static final class a {
        public static final CommonAdvertDetailsFeatureTeaserItemsAdapter_Factory a = new CommonAdvertDetailsFeatureTeaserItemsAdapter_Factory();
    }

    public static CommonAdvertDetailsFeatureTeaserItemsAdapter_Factory create() {
        return a.a;
    }

    public static CommonAdvertDetailsFeatureTeaserItemsAdapter newInstance() {
        return new CommonAdvertDetailsFeatureTeaserItemsAdapter();
    }

    @Override // javax.inject.Provider
    public CommonAdvertDetailsFeatureTeaserItemsAdapter get() {
        return newInstance();
    }
}
