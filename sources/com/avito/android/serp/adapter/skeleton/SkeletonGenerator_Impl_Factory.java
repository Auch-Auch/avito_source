package com.avito.android.serp.adapter.skeleton;

import com.avito.android.serp.adapter.skeleton.SkeletonGenerator;
import dagger.internal.Factory;
public final class SkeletonGenerator_Impl_Factory implements Factory<SkeletonGenerator.Impl> {

    public static final class a {
        public static final SkeletonGenerator_Impl_Factory a = new SkeletonGenerator_Impl_Factory();
    }

    public static SkeletonGenerator_Impl_Factory create() {
        return a.a;
    }

    public static SkeletonGenerator.Impl newInstance() {
        return new SkeletonGenerator.Impl();
    }

    @Override // javax.inject.Provider
    public SkeletonGenerator.Impl get() {
        return newInstance();
    }
}
