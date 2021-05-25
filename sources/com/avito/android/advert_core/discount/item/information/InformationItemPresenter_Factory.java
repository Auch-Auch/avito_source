package com.avito.android.advert_core.discount.item.information;

import dagger.internal.Factory;
public final class InformationItemPresenter_Factory implements Factory<InformationItemPresenter> {

    public static final class a {
        public static final InformationItemPresenter_Factory a = new InformationItemPresenter_Factory();
    }

    public static InformationItemPresenter_Factory create() {
        return a.a;
    }

    public static InformationItemPresenter newInstance() {
        return new InformationItemPresenter();
    }

    @Override // javax.inject.Provider
    public InformationItemPresenter get() {
        return newInstance();
    }
}
