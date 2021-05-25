package com.avito.android.search.map.reducer;

import dagger.internal.Factory;
public final class PinAdvertsReducer_Factory implements Factory<PinAdvertsReducer> {

    public static final class a {
        public static final PinAdvertsReducer_Factory a = new PinAdvertsReducer_Factory();
    }

    public static PinAdvertsReducer_Factory create() {
        return a.a;
    }

    public static PinAdvertsReducer newInstance() {
        return new PinAdvertsReducer();
    }

    @Override // javax.inject.Provider
    public PinAdvertsReducer get() {
        return newInstance();
    }
}
