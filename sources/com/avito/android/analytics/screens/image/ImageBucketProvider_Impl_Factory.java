package com.avito.android.analytics.screens.image;

import com.avito.android.analytics.screens.image.ImageBucketProvider;
import dagger.internal.Factory;
public final class ImageBucketProvider_Impl_Factory implements Factory<ImageBucketProvider.Impl> {

    public static final class a {
        public static final ImageBucketProvider_Impl_Factory a = new ImageBucketProvider_Impl_Factory();
    }

    public static ImageBucketProvider_Impl_Factory create() {
        return a.a;
    }

    public static ImageBucketProvider.Impl newInstance() {
        return new ImageBucketProvider.Impl();
    }

    @Override // javax.inject.Provider
    public ImageBucketProvider.Impl get() {
        return newInstance();
    }
}
