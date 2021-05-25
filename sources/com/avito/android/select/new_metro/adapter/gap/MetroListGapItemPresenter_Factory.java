package com.avito.android.select.new_metro.adapter.gap;

import dagger.internal.Factory;
public final class MetroListGapItemPresenter_Factory implements Factory<MetroListGapItemPresenter> {

    public static final class a {
        public static final MetroListGapItemPresenter_Factory a = new MetroListGapItemPresenter_Factory();
    }

    public static MetroListGapItemPresenter_Factory create() {
        return a.a;
    }

    public static MetroListGapItemPresenter newInstance() {
        return new MetroListGapItemPresenter();
    }

    @Override // javax.inject.Provider
    public MetroListGapItemPresenter get() {
        return newInstance();
    }
}
