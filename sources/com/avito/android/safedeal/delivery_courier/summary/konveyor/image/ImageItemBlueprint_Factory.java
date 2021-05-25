package com.avito.android.safedeal.delivery_courier.summary.konveyor.image;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ImageItemBlueprint_Factory implements Factory<ImageItemBlueprint> {
    public final Provider<ImageItemPresenter> a;

    public ImageItemBlueprint_Factory(Provider<ImageItemPresenter> provider) {
        this.a = provider;
    }

    public static ImageItemBlueprint_Factory create(Provider<ImageItemPresenter> provider) {
        return new ImageItemBlueprint_Factory(provider);
    }

    public static ImageItemBlueprint newInstance(ImageItemPresenter imageItemPresenter) {
        return new ImageItemBlueprint(imageItemPresenter);
    }

    @Override // javax.inject.Provider
    public ImageItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
