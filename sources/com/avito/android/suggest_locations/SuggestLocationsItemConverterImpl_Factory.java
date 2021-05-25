package com.avito.android.suggest_locations;

import dagger.internal.Factory;
public final class SuggestLocationsItemConverterImpl_Factory implements Factory<SuggestLocationsItemConverterImpl> {

    public static final class a {
        public static final SuggestLocationsItemConverterImpl_Factory a = new SuggestLocationsItemConverterImpl_Factory();
    }

    public static SuggestLocationsItemConverterImpl_Factory create() {
        return a.a;
    }

    public static SuggestLocationsItemConverterImpl newInstance() {
        return new SuggestLocationsItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public SuggestLocationsItemConverterImpl get() {
        return newInstance();
    }
}
