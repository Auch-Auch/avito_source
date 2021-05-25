package com.avito.android.brandspace.items.image;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ImageBlueprint_Factory implements Factory<ImageBlueprint> {
    public final Provider<ImagePresenter> a;

    public ImageBlueprint_Factory(Provider<ImagePresenter> provider) {
        this.a = provider;
    }

    public static ImageBlueprint_Factory create(Provider<ImagePresenter> provider) {
        return new ImageBlueprint_Factory(provider);
    }

    public static ImageBlueprint newInstance(ImagePresenter imagePresenter) {
        return new ImageBlueprint(imagePresenter);
    }

    @Override // javax.inject.Provider
    public ImageBlueprint get() {
        return newInstance(this.a.get());
    }
}
