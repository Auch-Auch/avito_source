package com.avito.android.advert_stats.item.details;

import dagger.internal.Factory;
public final class StatDetailItemPresenter_Factory implements Factory<StatDetailItemPresenter> {

    public static final class a {
        public static final StatDetailItemPresenter_Factory a = new StatDetailItemPresenter_Factory();
    }

    public static StatDetailItemPresenter_Factory create() {
        return a.a;
    }

    public static StatDetailItemPresenter newInstance() {
        return new StatDetailItemPresenter();
    }

    @Override // javax.inject.Provider
    public StatDetailItemPresenter get() {
        return newInstance();
    }
}
