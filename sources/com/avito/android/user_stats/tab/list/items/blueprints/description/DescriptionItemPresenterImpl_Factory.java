package com.avito.android.user_stats.tab.list.items.blueprints.description;

import dagger.internal.Factory;
public final class DescriptionItemPresenterImpl_Factory implements Factory<DescriptionItemPresenterImpl> {

    public static final class a {
        public static final DescriptionItemPresenterImpl_Factory a = new DescriptionItemPresenterImpl_Factory();
    }

    public static DescriptionItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static DescriptionItemPresenterImpl newInstance() {
        return new DescriptionItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public DescriptionItemPresenterImpl get() {
        return newInstance();
    }
}
