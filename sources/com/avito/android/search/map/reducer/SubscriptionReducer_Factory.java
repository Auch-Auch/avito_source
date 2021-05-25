package com.avito.android.search.map.reducer;

import dagger.internal.Factory;
public final class SubscriptionReducer_Factory implements Factory<SubscriptionReducer> {

    public static final class a {
        public static final SubscriptionReducer_Factory a = new SubscriptionReducer_Factory();
    }

    public static SubscriptionReducer_Factory create() {
        return a.a;
    }

    public static SubscriptionReducer newInstance() {
        return new SubscriptionReducer();
    }

    @Override // javax.inject.Provider
    public SubscriptionReducer get() {
        return newInstance();
    }
}
