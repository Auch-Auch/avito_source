package com.avito.android.advert.viewed;

import dagger.internal.Factory;
public final class ViewedAdvertsEventInteractorImpl_Factory implements Factory<ViewedAdvertsEventInteractorImpl> {

    public static final class a {
        public static final ViewedAdvertsEventInteractorImpl_Factory a = new ViewedAdvertsEventInteractorImpl_Factory();
    }

    public static ViewedAdvertsEventInteractorImpl_Factory create() {
        return a.a;
    }

    public static ViewedAdvertsEventInteractorImpl newInstance() {
        return new ViewedAdvertsEventInteractorImpl();
    }

    @Override // javax.inject.Provider
    public ViewedAdvertsEventInteractorImpl get() {
        return newInstance();
    }
}
