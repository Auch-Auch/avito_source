package com.avito.android.vas_performance.ui.items.visual;

import dagger.internal.Factory;
public final class VisualVasItemPresenterImpl_Factory implements Factory<VisualVasItemPresenterImpl> {

    public static final class a {
        public static final VisualVasItemPresenterImpl_Factory a = new VisualVasItemPresenterImpl_Factory();
    }

    public static VisualVasItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static VisualVasItemPresenterImpl newInstance() {
        return new VisualVasItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public VisualVasItemPresenterImpl get() {
        return newInstance();
    }
}
