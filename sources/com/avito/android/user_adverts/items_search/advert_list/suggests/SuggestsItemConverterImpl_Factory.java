package com.avito.android.user_adverts.items_search.advert_list.suggests;

import dagger.internal.Factory;
public final class SuggestsItemConverterImpl_Factory implements Factory<SuggestsItemConverterImpl> {

    public static final class a {
        public static final SuggestsItemConverterImpl_Factory a = new SuggestsItemConverterImpl_Factory();
    }

    public static SuggestsItemConverterImpl_Factory create() {
        return a.a;
    }

    public static SuggestsItemConverterImpl newInstance() {
        return new SuggestsItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public SuggestsItemConverterImpl get() {
        return newInstance();
    }
}
