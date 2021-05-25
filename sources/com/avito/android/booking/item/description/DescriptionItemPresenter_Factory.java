package com.avito.android.booking.item.description;

import dagger.internal.Factory;
public final class DescriptionItemPresenter_Factory implements Factory<DescriptionItemPresenter> {

    public static final class a {
        public static final DescriptionItemPresenter_Factory a = new DescriptionItemPresenter_Factory();
    }

    public static DescriptionItemPresenter_Factory create() {
        return a.a;
    }

    public static DescriptionItemPresenter newInstance() {
        return new DescriptionItemPresenter();
    }

    @Override // javax.inject.Provider
    public DescriptionItemPresenter get() {
        return newInstance();
    }
}
