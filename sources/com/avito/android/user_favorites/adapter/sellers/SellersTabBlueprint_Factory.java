package com.avito.android.user_favorites.adapter.sellers;

import dagger.internal.Factory;
public final class SellersTabBlueprint_Factory implements Factory<SellersTabBlueprint> {

    public static final class a {
        public static final SellersTabBlueprint_Factory a = new SellersTabBlueprint_Factory();
    }

    public static SellersTabBlueprint_Factory create() {
        return a.a;
    }

    public static SellersTabBlueprint newInstance() {
        return new SellersTabBlueprint();
    }

    @Override // javax.inject.Provider
    public SellersTabBlueprint get() {
        return newInstance();
    }
}
