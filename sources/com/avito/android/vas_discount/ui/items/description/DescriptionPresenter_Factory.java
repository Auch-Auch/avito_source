package com.avito.android.vas_discount.ui.items.description;

import dagger.internal.Factory;
public final class DescriptionPresenter_Factory implements Factory<DescriptionPresenter> {

    public static final class a {
        public static final DescriptionPresenter_Factory a = new DescriptionPresenter_Factory();
    }

    public static DescriptionPresenter_Factory create() {
        return a.a;
    }

    public static DescriptionPresenter newInstance() {
        return new DescriptionPresenter();
    }

    @Override // javax.inject.Provider
    public DescriptionPresenter get() {
        return newInstance();
    }
}
