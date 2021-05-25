package com.avito.android.similar_adverts.adapter.skeleton_title;

import dagger.internal.Factory;
public final class SimilarSkeletonTitlePresenterImpl_Factory implements Factory<SimilarSkeletonTitlePresenterImpl> {

    public static final class a {
        public static final SimilarSkeletonTitlePresenterImpl_Factory a = new SimilarSkeletonTitlePresenterImpl_Factory();
    }

    public static SimilarSkeletonTitlePresenterImpl_Factory create() {
        return a.a;
    }

    public static SimilarSkeletonTitlePresenterImpl newInstance() {
        return new SimilarSkeletonTitlePresenterImpl();
    }

    @Override // javax.inject.Provider
    public SimilarSkeletonTitlePresenterImpl get() {
        return newInstance();
    }
}
