package com.avito.android.bundles.di;

import dagger.internal.Factory;
public final class VasBundlesModule_ProvideDetectMovesFactory implements Factory<Boolean> {

    public static final class a {
        public static final VasBundlesModule_ProvideDetectMovesFactory a = new VasBundlesModule_ProvideDetectMovesFactory();
    }

    public static VasBundlesModule_ProvideDetectMovesFactory create() {
        return a.a;
    }

    public static boolean provideDetectMoves() {
        return VasBundlesModule.provideDetectMoves();
    }

    @Override // javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provideDetectMoves());
    }
}
