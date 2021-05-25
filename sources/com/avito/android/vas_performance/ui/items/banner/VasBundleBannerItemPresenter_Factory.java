package com.avito.android.vas_performance.ui.items.banner;

import dagger.internal.Factory;
public final class VasBundleBannerItemPresenter_Factory implements Factory<VasBundleBannerItemPresenter> {

    public static final class a {
        public static final VasBundleBannerItemPresenter_Factory a = new VasBundleBannerItemPresenter_Factory();
    }

    public static VasBundleBannerItemPresenter_Factory create() {
        return a.a;
    }

    public static VasBundleBannerItemPresenter newInstance() {
        return new VasBundleBannerItemPresenter();
    }

    @Override // javax.inject.Provider
    public VasBundleBannerItemPresenter get() {
        return newInstance();
    }
}
