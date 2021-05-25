package com.avito.android.blueprints.video;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VideoItemBlueprint_Factory implements Factory<VideoItemBlueprint> {
    public final Provider<VideoItemPresenter> a;

    public VideoItemBlueprint_Factory(Provider<VideoItemPresenter> provider) {
        this.a = provider;
    }

    public static VideoItemBlueprint_Factory create(Provider<VideoItemPresenter> provider) {
        return new VideoItemBlueprint_Factory(provider);
    }

    public static VideoItemBlueprint newInstance(VideoItemPresenter videoItemPresenter) {
        return new VideoItemBlueprint(videoItemPresenter);
    }

    @Override // javax.inject.Provider
    public VideoItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
