package com.avito.android.similar_adverts.adapter;

import com.avito.android.serp.adapter.skeleton.SkeletonPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SimilarSkeletonAdvertBlueprint_Factory implements Factory<SimilarSkeletonAdvertBlueprint> {
    public final Provider<SkeletonPresenter> a;

    public SimilarSkeletonAdvertBlueprint_Factory(Provider<SkeletonPresenter> provider) {
        this.a = provider;
    }

    public static SimilarSkeletonAdvertBlueprint_Factory create(Provider<SkeletonPresenter> provider) {
        return new SimilarSkeletonAdvertBlueprint_Factory(provider);
    }

    public static SimilarSkeletonAdvertBlueprint newInstance(SkeletonPresenter skeletonPresenter) {
        return new SimilarSkeletonAdvertBlueprint(skeletonPresenter);
    }

    @Override // javax.inject.Provider
    public SimilarSkeletonAdvertBlueprint get() {
        return newInstance(this.a.get());
    }
}
