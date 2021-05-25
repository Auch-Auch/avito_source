package com.avito.android.similar_adverts.adapter.skeleton_title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SimilarSkeletonTitleBlueprint_Factory implements Factory<SimilarSkeletonTitleBlueprint> {
    public final Provider<SimilarSkeletonTitlePresenter> a;

    public SimilarSkeletonTitleBlueprint_Factory(Provider<SimilarSkeletonTitlePresenter> provider) {
        this.a = provider;
    }

    public static SimilarSkeletonTitleBlueprint_Factory create(Provider<SimilarSkeletonTitlePresenter> provider) {
        return new SimilarSkeletonTitleBlueprint_Factory(provider);
    }

    public static SimilarSkeletonTitleBlueprint newInstance(SimilarSkeletonTitlePresenter similarSkeletonTitlePresenter) {
        return new SimilarSkeletonTitleBlueprint(similarSkeletonTitlePresenter);
    }

    @Override // javax.inject.Provider
    public SimilarSkeletonTitleBlueprint get() {
        return newInstance(this.a.get());
    }
}
