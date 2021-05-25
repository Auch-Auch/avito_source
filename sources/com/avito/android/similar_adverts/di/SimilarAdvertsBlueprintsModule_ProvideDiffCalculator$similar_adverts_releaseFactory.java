package com.avito.android.similar_adverts.di;

import com.avito.android.recycler.data_aware.DiffCalculator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class SimilarAdvertsBlueprintsModule_ProvideDiffCalculator$similar_adverts_releaseFactory implements Factory<DiffCalculator> {

    public static final class a {
        public static final SimilarAdvertsBlueprintsModule_ProvideDiffCalculator$similar_adverts_releaseFactory a = new SimilarAdvertsBlueprintsModule_ProvideDiffCalculator$similar_adverts_releaseFactory();
    }

    public static SimilarAdvertsBlueprintsModule_ProvideDiffCalculator$similar_adverts_releaseFactory create() {
        return a.a;
    }

    public static DiffCalculator provideDiffCalculator$similar_adverts_release() {
        return (DiffCalculator) Preconditions.checkNotNullFromProvides(SimilarAdvertsBlueprintsModule.INSTANCE.provideDiffCalculator$similar_adverts_release());
    }

    @Override // javax.inject.Provider
    public DiffCalculator get() {
        return provideDiffCalculator$similar_adverts_release();
    }
}
