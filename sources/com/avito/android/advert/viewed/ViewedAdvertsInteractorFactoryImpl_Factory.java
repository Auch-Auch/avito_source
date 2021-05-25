package com.avito.android.advert.viewed;

import dagger.internal.Factory;
public final class ViewedAdvertsInteractorFactoryImpl_Factory implements Factory<ViewedAdvertsInteractorFactoryImpl> {

    public static final class a {
        public static final ViewedAdvertsInteractorFactoryImpl_Factory a = new ViewedAdvertsInteractorFactoryImpl_Factory();
    }

    public static ViewedAdvertsInteractorFactoryImpl_Factory create() {
        return a.a;
    }

    public static ViewedAdvertsInteractorFactoryImpl newInstance() {
        return new ViewedAdvertsInteractorFactoryImpl();
    }

    @Override // javax.inject.Provider
    public ViewedAdvertsInteractorFactoryImpl get() {
        return newInstance();
    }
}
