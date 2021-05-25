package com.avito.android.user_stats.tab.list.items.blueprints.space;

import dagger.internal.Factory;
public final class SpaceItemPresenterImpl_Factory implements Factory<SpaceItemPresenterImpl> {

    public static final class a {
        public static final SpaceItemPresenterImpl_Factory a = new SpaceItemPresenterImpl_Factory();
    }

    public static SpaceItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static SpaceItemPresenterImpl newInstance() {
        return new SpaceItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SpaceItemPresenterImpl get() {
        return newInstance();
    }
}
