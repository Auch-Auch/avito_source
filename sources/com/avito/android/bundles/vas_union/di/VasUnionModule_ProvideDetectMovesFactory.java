package com.avito.android.bundles.vas_union.di;

import dagger.internal.Factory;
public final class VasUnionModule_ProvideDetectMovesFactory implements Factory<Boolean> {

    public static final class a {
        public static final VasUnionModule_ProvideDetectMovesFactory a = new VasUnionModule_ProvideDetectMovesFactory();
    }

    public static VasUnionModule_ProvideDetectMovesFactory create() {
        return a.a;
    }

    public static boolean provideDetectMoves() {
        return VasUnionModule.provideDetectMoves();
    }

    @Override // javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provideDetectMoves());
    }
}
