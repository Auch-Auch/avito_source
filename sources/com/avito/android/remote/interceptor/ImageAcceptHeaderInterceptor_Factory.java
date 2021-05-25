package com.avito.android.remote.interceptor;

import dagger.internal.Factory;
public final class ImageAcceptHeaderInterceptor_Factory implements Factory<ImageAcceptHeaderInterceptor> {

    public static final class a {
        public static final ImageAcceptHeaderInterceptor_Factory a = new ImageAcceptHeaderInterceptor_Factory();
    }

    public static ImageAcceptHeaderInterceptor_Factory create() {
        return a.a;
    }

    public static ImageAcceptHeaderInterceptor newInstance() {
        return new ImageAcceptHeaderInterceptor();
    }

    @Override // javax.inject.Provider
    public ImageAcceptHeaderInterceptor get() {
        return newInstance();
    }
}
