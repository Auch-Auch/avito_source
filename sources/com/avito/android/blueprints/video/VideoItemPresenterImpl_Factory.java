package com.avito.android.blueprints.video;

import dagger.internal.Factory;
public final class VideoItemPresenterImpl_Factory implements Factory<VideoItemPresenterImpl> {

    public static final class a {
        public static final VideoItemPresenterImpl_Factory a = new VideoItemPresenterImpl_Factory();
    }

    public static VideoItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static VideoItemPresenterImpl newInstance() {
        return new VideoItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public VideoItemPresenterImpl get() {
        return newInstance();
    }
}
