package com.avito.android.shop.awards.item.award;

import dagger.internal.Factory;
public final class AwardItemPresenter_Factory implements Factory<AwardItemPresenter> {

    public static final class a {
        public static final AwardItemPresenter_Factory a = new AwardItemPresenter_Factory();
    }

    public static AwardItemPresenter_Factory create() {
        return a.a;
    }

    public static AwardItemPresenter newInstance() {
        return new AwardItemPresenter();
    }

    @Override // javax.inject.Provider
    public AwardItemPresenter get() {
        return newInstance();
    }
}
