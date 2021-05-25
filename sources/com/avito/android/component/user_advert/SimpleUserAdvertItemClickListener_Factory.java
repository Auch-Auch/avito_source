package com.avito.android.component.user_advert;

import dagger.internal.Factory;
public final class SimpleUserAdvertItemClickListener_Factory implements Factory<SimpleUserAdvertItemClickListener> {

    public static final class a {
        public static final SimpleUserAdvertItemClickListener_Factory a = new SimpleUserAdvertItemClickListener_Factory();
    }

    public static SimpleUserAdvertItemClickListener_Factory create() {
        return a.a;
    }

    public static SimpleUserAdvertItemClickListener newInstance() {
        return new SimpleUserAdvertItemClickListener();
    }

    @Override // javax.inject.Provider
    public SimpleUserAdvertItemClickListener get() {
        return newInstance();
    }
}
