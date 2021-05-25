package com.avito.android.advert_stats.item.period;

import dagger.internal.Factory;
public final class PeriodItemPresenter_Factory implements Factory<PeriodItemPresenter> {

    public static final class a {
        public static final PeriodItemPresenter_Factory a = new PeriodItemPresenter_Factory();
    }

    public static PeriodItemPresenter_Factory create() {
        return a.a;
    }

    public static PeriodItemPresenter newInstance() {
        return new PeriodItemPresenter();
    }

    @Override // javax.inject.Provider
    public PeriodItemPresenter get() {
        return newInstance();
    }
}
