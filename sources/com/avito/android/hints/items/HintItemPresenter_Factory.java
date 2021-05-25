package com.avito.android.hints.items;

import dagger.internal.Factory;
public final class HintItemPresenter_Factory implements Factory<HintItemPresenter> {

    public static final class a {
        public static final HintItemPresenter_Factory a = new HintItemPresenter_Factory();
    }

    public static HintItemPresenter_Factory create() {
        return a.a;
    }

    public static HintItemPresenter newInstance() {
        return new HintItemPresenter();
    }

    @Override // javax.inject.Provider
    public HintItemPresenter get() {
        return newInstance();
    }
}
