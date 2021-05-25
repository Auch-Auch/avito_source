package com.avito.android.search.map.reducer;

import dagger.internal.Factory;
public final class UiReducer_Factory implements Factory<UiReducer> {

    public static final class a {
        public static final UiReducer_Factory a = new UiReducer_Factory();
    }

    public static UiReducer_Factory create() {
        return a.a;
    }

    public static UiReducer newInstance() {
        return new UiReducer();
    }

    @Override // javax.inject.Provider
    public UiReducer get() {
        return newInstance();
    }
}
